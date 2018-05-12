import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';
import { SERVER_API_URL } from '../app.constants';
import { Felhasznalo } from '../model/baseuser.model';
import { FelhasznaloService } from '../service/felhasznalo.service';

export const ANONYMOUS = 'anonymousUser';
const WEBSTORAGE_PRINCIPAL = 'allaskereso_user_principal';
@Injectable()
export class AuthenticationService {
  public principal: any;
  public _isLoggedIn = new Subject<boolean>();
  public currentFelhasznalo: Felhasznalo;
  constructor(
    private http: HttpClient,
    private router: Router,
    private felhasznaloService: FelhasznaloService
  ) {}

  isLoggedIn(): Promise<boolean> {
    return new Promise((resolve, reject) => {
      if (this.principal === ANONYMOUS) {
        resolve(false);
      } else if (this.principal) {
        resolve(true);
      } else if (!this.principal) {
        this.isSessionActive()
          .toPromise()
          .then(response => {
            this.principal = response;
            sessionStorage.setItem(
              'oeny_user_principal',
              JSON.stringify(response)
            );
            if (response.toString() === ANONYMOUS) {
              resolve(false);
            } else {
              resolve(true);
            }
          })
          .catch(error => {
            this.principal = ANONYMOUS;
            sessionStorage.setItem(WEBSTORAGE_PRINCIPAL, ANONYMOUS);
            resolve(false);
          });
      }
    });
  }

  isSessionActive(): Observable<Response | String> {
    return this.http.get<Response | String>(SERVER_API_URL + '/secure');
  }

  login(username: string, password: string): Promise<boolean> {
    return new Promise((resolve, reject) => {
      const headers = new HttpHeaders()
        .set('Content-Type', 'application/x-www-form-urlencoded')
        .set('Access-Control-Allow-Origin', '*');
      const params = new HttpParams()
        .set('username', username)
        .set('password', password);
      this.http
        .post(SERVER_API_URL + '/login', null, {
          headers: headers,
          params: params,
          withCredentials: true
        })
        .toPromise()
        .then(response => {
          this._isLoggedIn.next(true);
          this.principal = response;
          if (this.principal) {
            this.felhasznaloService
              .getFelhasznaloByUsername(username)
              .subscribe(responseFelhasznalo => {
                this.currentFelhasznalo = responseFelhasznalo;
              });
            sessionStorage.setItem(
              WEBSTORAGE_PRINCIPAL,
              JSON.stringify(this.principal)
            );
          }
          resolve(true);
        })
        .catch(e => {
          resolve(false);
        });
    });
  }

  logout(): Promise<boolean> {
    return new Promise((resolve, reject) => {
      this.principal = ANONYMOUS;
      sessionStorage.setItem(WEBSTORAGE_PRINCIPAL, ANONYMOUS);
      this._isLoggedIn.next(false);
      this.router.navigate(['/']);
      this.http
        .get<Response>(SERVER_API_URL + '/logout')
        .toPromise()
        .then(() => {
          this.currentFelhasznalo = undefined;
          resolve(true);
        })
        .catch(e => {
          resolve(false);
        });
    });
  }

  destroySession() {
    this.principal = ANONYMOUS;
    sessionStorage.setItem(WEBSTORAGE_PRINCIPAL, ANONYMOUS);
    this.http.get<Response>(SERVER_API_URL + '/logout').subscribe();
  }

  syncPrincipal() {
    const sstPrincipal = sessionStorage.getItem(WEBSTORAGE_PRINCIPAL);
    if (sstPrincipal) {
      let storedPrincipal;
      try {
        storedPrincipal = JSON.parse(sstPrincipal);
      } catch (error) {
        storedPrincipal = sstPrincipal;
      }
      this.principal = storedPrincipal;
      this.isLoggedIn().then(status => this._isLoggedIn.next(status));
    }
  }

  hasRole(role: string) {
    if (this.principal instanceof Object) {
      return this.principal.authorities.find(element => {
        return element.authority === role;
      });
    } else {
      return false;
    }
  }
}
