import { Injectable } from '@angular/core';
import { SERVER_API_URL } from '../app.constants';
import { Observable } from 'rxjs/Observable';
import { HttpParams, HttpClient, HttpHeaders } from '@angular/common/http';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import { Allaskereso } from '../model/allaskereso.model';

@Injectable()
export class AllaskeresoService {
  private baseUrl = '/allaskereso/';

  constructor(private httpClient: HttpClient) {}

  public getAllaskeresoAll(): Observable<Allaskereso> {
    const url = SERVER_API_URL + this.baseUrl + 'all';
    const params = new HttpParams();

    return this.httpClient.get<Allaskereso>(url, {
      params: params
    });
  }

  public getAllaskeresoById(id: number): Observable<Allaskereso> {
    const url = SERVER_API_URL + this.baseUrl + id;
    const params = new HttpParams();

    return this.httpClient.get<Allaskereso>(url, { params: params });
  }

  public createAllaskereso(allaskereso: Allaskereso): Observable<Allaskereso> {
    const url = SERVER_API_URL + this.baseUrl + 'create';
    const params = new HttpParams();

    return this.httpClient.post<Allaskereso>(url, allaskereso, {
      params: params
    });
  }

  public updateBemutatkozoAdatok(
    allaskereso: Allaskereso
  ): Observable<Allaskereso> {
    const url = SERVER_API_URL + this.baseUrl + 'update';
    const params = new HttpParams();

    return this.httpClient.put<Allaskereso>(url, allaskereso, {
      params: params
    });
  }
}
