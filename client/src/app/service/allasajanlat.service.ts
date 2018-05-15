import { Injectable } from '@angular/core';
import { SERVER_API_URL } from '../app.constants';
import { Observable } from 'rxjs/Observable';
import { HttpParams, HttpClient } from '@angular/common/http';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import { ServiceConfig } from '../_api-module';
import { Allasajanlat } from '../model/allasajanlat.model';
import { Munkaltato } from '../model/munkaltato.model';

@Injectable()
export class AllasajanlatService {
  private baseUrl = '/allasajanlat/';

  constructor(private httpClient: HttpClient) {}

  public getAllasajanlatAll(): Observable<Allasajanlat[]> {
    const url = SERVER_API_URL + this.baseUrl + 'all';
    const params = new HttpParams();

    return this.httpClient.get<Allasajanlat[]>(url, { params: params });
  }

  public getAllasajanlatById(id: number): Observable<Allasajanlat> {
    const url = SERVER_API_URL + this.baseUrl + id;
    const params = new HttpParams();

    return this.httpClient.get<Allasajanlat>(url, { params: params });
  }

  public getAssignedUsers(allasajanlatId: number): Observable<Allasajanlat[]> {
    const url = SERVER_API_URL + this.baseUrl + allasajanlatId + '/users';
    const params = new HttpParams();

    return this.httpClient.get<Allasajanlat[]>(url, { params: params });
  }

  public getMunkaltatok(munkaltatoId: number): Observable<Munkaltato[]> {
    const url = SERVER_API_URL + this.baseUrl + munkaltatoId + '/munkaltato';
    const params = new HttpParams();

    return this.httpClient.get<Munkaltato[]>(url, { params: params });
  }

  public createAllasajanlat(
    allasajanlat: Allasajanlat
  ): Observable<Allasajanlat> {
    const url = SERVER_API_URL + this.baseUrl + 'create';
    const params = new HttpParams();

    return this.httpClient.post<Allasajanlat>(url, allasajanlat, {
      params: params
    });
  }

  public updateBemutatkozoAdatok(
    allasajanlat: Allasajanlat
  ): Observable<Allasajanlat> {
    const url = SERVER_API_URL + this.baseUrl + 'update';
    const params = new HttpParams();

    return this.httpClient.put<Allasajanlat>(url, allasajanlat, {
      params: params
    });
  }
}
