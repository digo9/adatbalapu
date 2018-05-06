import { Injectable } from '@angular/core';
import { SERVER_API_URL } from '../app.constants';
import { Observable } from 'rxjs/Observable';
import { HttpParams, HttpClient } from '@angular/common/http';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import { ServiceConfig } from '../_api-module';
import { Oneletrajz } from '../model/oneletrajz.model';

@Injectable()
export class OneletrajzService {
  private baseUrl = '/oneletrajz';

  constructor(
    private httpClient: HttpClient,
    private serviceConfig: ServiceConfig
  ) {}

  private get onError(): (error: Response) => ErrorObservable {
    return this.serviceConfig.onError || this.handleError.bind(this);
  }

  private handleError(error: Response): ErrorObservable {
    // in a real world app, we may send the error to some remote logging infrastructure
    // instead of just logging it to the console
    this.log('error', error);

    return Observable.throw(error);
  }

  private log(level: string, message: any): void {
    if (this.serviceConfig.debug) {
      console[level](message);
    }
  }

  public getOneletrajzAll(): Observable<Oneletrajz> {
    const url = SERVER_API_URL + this.baseUrl + '/all';
    const params = new HttpParams();

    return this.httpClient
      .get<Oneletrajz>(url, { params: params })
      .catch((error: Response) => this.onError(error));
  }

  public getOneletrajzById(id: number): Observable<Oneletrajz> {
    const url = SERVER_API_URL + this.baseUrl + id;
    const params = new HttpParams();

    return this.httpClient
      .get<Oneletrajz>(url, { params: params })
      .catch((error: Response) => this.onError(error));
  }

  public createOneletrajzat(oneletrajz: Oneletrajz): Observable<Oneletrajz> {
    const url = SERVER_API_URL + this.baseUrl + '/create';
    const params = new HttpParams();

    return this.httpClient
      .post<Oneletrajz>(url, oneletrajz, { params: params })
      .catch((error: Response) => this.onError(error));
  }

  public updateOneletrajzAdatok(oneletrajz: Oneletrajz): Observable<Oneletrajz> {
    const url = SERVER_API_URL + this.baseUrl + '/update';
    const params = new HttpParams();

    return this.httpClient
      .put<Oneletrajz>(url, oneletrajz, { params: params })
      .catch((error: Response) => this.onError(error));
  }
}
