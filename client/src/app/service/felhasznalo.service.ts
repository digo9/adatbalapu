import { Injectable } from '@angular/core';
import { SERVER_API_URL } from '../app.constants';
import { Observable } from 'rxjs/Observable';
import { HttpParams, HttpClient, HttpHeaders } from '@angular/common/http';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import { Felhasznalo } from '../model/baseuser.model';

@Injectable()
export class FelhasznaloService {
  private baseUrl = '/baseuser/';

  constructor(private httpClient: HttpClient) {}

  public getFelhasznaloAll(): Observable<Felhasznalo> {
    const url = SERVER_API_URL + this.baseUrl + 'all';
    const params = new HttpParams();

    return this.httpClient.get<Felhasznalo>(url, {
      params: params
    });
  }

  public getFelhasznaloById(id: number): Observable<Felhasznalo> {
    const url = SERVER_API_URL + this.baseUrl + id;
    const params = new HttpParams();

    return this.httpClient.get<Felhasznalo>(url, { params: params });
  }

  public getFelhasznaloByUsername(username: string): Observable<Felhasznalo> {
    const url = SERVER_API_URL + this.baseUrl + 'user';
    let params = new HttpParams();
    params = params.append('username', username);

    return this.httpClient.get<Felhasznalo>(url, { params: params });
  }

  public createFelhasznalo(felhasznalo: Felhasznalo): Observable<Felhasznalo> {
    const url = SERVER_API_URL + this.baseUrl + 'create';
    const params = new HttpParams();

    return this.httpClient.post<Felhasznalo>(url, felhasznalo, {
      params: params
    });
  }

  public updateBemutatkozoAdatok(
    felhasznalo: Felhasznalo
  ): Observable<Felhasznalo> {
    const url = SERVER_API_URL + this.baseUrl + 'update';
    const params = new HttpParams();

    return this.httpClient.put<Felhasznalo>(url, felhasznalo, {
      params: params
    });
  }
}
