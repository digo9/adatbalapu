import { Injectable } from '@angular/core';
import { SERVER_API_URL } from '../app.constants';
import { Observable } from 'rxjs/Observable';
import { HttpParams, HttpClient } from '@angular/common/http';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import { ServiceConfig } from '../_api-module';
import { Szekhely } from '../model/szekhely.model';

@Injectable()
export class SzekhelyService {
  private baseUrl = '/szekhely/';

  constructor(private httpClient: HttpClient) {}

  public getSzekhelyAll(): Observable<Szekhely> {
    const url = SERVER_API_URL + this.baseUrl + 'all';
    const params = new HttpParams();

    return this.httpClient.get<Szekhely>(url, { params: params });
  }

  public getSzekhelyById(id: number): Observable<Szekhely> {
    const url = SERVER_API_URL + this.baseUrl + id;
    const params = new HttpParams();

    return this.httpClient.get<Szekhely>(url, { params: params });
  }

  public createSzekhelyat(szekhely: Szekhely): Observable<Szekhely> {
    const url = SERVER_API_URL + this.baseUrl + 'create';
    const params = new HttpParams();

    return this.httpClient.post<Szekhely>(url, szekhely, { params: params });
  }

  public updateSzekhelyAdatok(szekhely: Szekhely): Observable<Szekhely> {
    const url = SERVER_API_URL + this.baseUrl + 'update';
    const params = new HttpParams();

    return this.httpClient.put<Szekhely>(url, szekhely, { params: params });
  }
}
