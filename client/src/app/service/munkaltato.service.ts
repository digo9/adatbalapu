import { Injectable } from '@angular/core';
import { SERVER_API_URL } from '../app.constants';
import { Observable } from 'rxjs/Observable';
import { HttpParams, HttpClient } from '@angular/common/http';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import { ServiceConfig } from '../_api-module';
import { Munkaltato } from '../model/munkaltato.model';

@Injectable()
export class MunkaltatoService {
  private baseUrl = '/munkaltato/';

  constructor(private httpClient: HttpClient) {}

  public getMunkaltatoAll(): Observable<Munkaltato> {
    const url = SERVER_API_URL + this.baseUrl + 'all';
    const params = new HttpParams();

    return this.httpClient.get<Munkaltato>(url, { params: params });
  }

  public getMunkaltatoById(id: number): Observable<Munkaltato> {
    const url = SERVER_API_URL + this.baseUrl + id;
    const params = new HttpParams();

    return this.httpClient.get<Munkaltato>(url, { params: params });
  }

  public createMunkaltato(munkaltato: Munkaltato): Observable<Munkaltato> {
    const url = SERVER_API_URL + this.baseUrl + 'create';
    const params = new HttpParams();

    return this.httpClient.post<Munkaltato>(url, munkaltato, {
      params: params
    });
  }

  public updateMunkaltatoAdatok(
    munkaltato: Munkaltato
  ): Observable<Munkaltato> {
    const url = SERVER_API_URL + this.baseUrl + 'update';
    const params = new HttpParams();

    return this.httpClient.put<Munkaltato>(url, munkaltato, { params: params });
  }
}
