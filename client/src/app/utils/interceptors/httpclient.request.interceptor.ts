import { Injectable } from '@angular/core';
import {
  HttpEvent,
  HttpInterceptor,
  HttpHandler,
  HttpRequest
} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import { HttpClientResponseInterceptorService } from './httpclient.response.communication.service';

@Injectable()
export class HttpClientRequestInterceptor implements HttpInterceptor {
  constructor(
    private router: Router,
    private ownComService: HttpClientResponseInterceptorService
  ) {}

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    const duplicate = req.clone({ withCredentials: true });
    this.ownComService.referer = this.router.url;
    return next.handle(duplicate);
  }
}
