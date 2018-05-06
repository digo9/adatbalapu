import { Injectable } from '@angular/core';
import { SERVER_API_URL } from '../app.constants';
import { Observable } from 'rxjs/Observable';
import { HttpParams, HttpClient } from '@angular/common/http';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import { ServiceConfig } from '../_api-module';
import { Munkaltato } from '../model/munkaltato.model';

@Injectable()
export class MunkaltatoService {
  private baseUrl = '/munkaltato';

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

  public getMunkaltatoAll(): Observable<Munkaltato> {
    const url = SERVER_API_URL + this.baseUrl + '/all';
    const params = new HttpParams();

    return this.httpClient
      .get<Munkaltato>(url, { params: params })
      .catch((error: Response) => this.onError(error));
  }

  public getMunkaltatoById(id: number): Observable<Munkaltato> {
    const url = SERVER_API_URL + this.baseUrl + id;
    const params = new HttpParams();

    return this.httpClient
      .get<Munkaltato>(url, { params: params })
      .catch((error: Response) => this.onError(error));
  }

  public createMunkaltatoat(munkaltato: Munkaltato): Observable<Munkaltato> {
    const url = SERVER_API_URL + this.baseUrl + '/create';
    const params = new HttpParams();

    return this.httpClient
      .post<Munkaltato>(url, munkaltato, { params: params })
      .catch((error: Response) => this.onError(error));
  }

  public updateMunkaltatoAdatok(munkaltato: Munkaltato): Observable<Munkaltato> {
    const url = SERVER_API_URL + this.baseUrl + '/update';
    const params = new HttpParams();

    return this.httpClient
      .put<Munkaltato>(url, munkaltato, { params: params })
      .catch((error: Response) => this.onError(error));
  }
}
