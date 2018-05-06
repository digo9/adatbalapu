import { Injectable } from '@angular/core';
import { SERVER_API_URL } from '../app.constants';
import { Observable } from 'rxjs/Observable';
import { HttpParams, HttpClient } from '@angular/common/http';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import { ServiceConfig } from '../_api-module';
import { Allasajanlat } from '../model/allasajanlat.model';

@Injectable()
export class AllasajanlatService {
  private baseUrl = '/allasajanlat';

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

  public getAllasajanlatAll(): Observable<Allasajanlat> {
    const url = SERVER_API_URL + this.baseUrl + '/all';
    const params = new HttpParams();

    return this.httpClient
      .get<Allasajanlat>(url, { params: params })
      .catch((error: Response) => this.onError(error));
  }

  public getAllasajanlatById(id: number): Observable<Allasajanlat> {
    const url = SERVER_API_URL + this.baseUrl + id;
    const params = new HttpParams();

    return this.httpClient
      .get<Allasajanlat>(url, { params: params })
      .catch((error: Response) => this.onError(error));
  }

  public createAllasajanlat(
    allasajanlat: Allasajanlat
  ): Observable<Allasajanlat> {
    const url = SERVER_API_URL + this.baseUrl + '/create';
    const params = new HttpParams();

    return this.httpClient
      .post<Allasajanlat>(url, allasajanlat, { params: params })
      .catch((error: Response) => this.onError(error));
  }

  public updateBemutatkozoAdatok(
    allasajanlat: Allasajanlat
  ): Observable<Allasajanlat> {
    const url = SERVER_API_URL + this.baseUrl + '/update';
    const params = new HttpParams();

    return this.httpClient
      .put<Allasajanlat>(url, allasajanlat, { params: params })
      .catch((error: Response) => this.onError(error));
  }
}
