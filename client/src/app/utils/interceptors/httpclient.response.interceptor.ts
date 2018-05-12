import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';

import { ANONYMOUS } from '../../auth/authentication.service';
import { HttpClientResponseInterceptorService } from './httpclient.response.communication.service';
import { URLs } from '../../app.constants';

@Injectable()
export class HttpClientResponseInterceptor implements HttpInterceptor {
  constructor(
    private router: Router,
    private ownComService: HttpClientResponseInterceptorService
  ) {}

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    return next
      .handle(req)
      .map((event: HttpEvent<any>) => {
        return event;
      })
      .catch((err: HttpErrorResponse) => {
        if (err.status === 400) {
          console.log(err.error.message);
        }
        if (err.status === 401) {
          sessionStorage.setItem('allaskereso_user_principal', ANONYMOUS);
          this.ownComService.needPrincipalRecheck.next(null);
          this.router.navigate([URLs.ROOT, URLs.LOGIN]);
        }
        if (err.status === 403) {
          if (this.isRequestRefererActive()) {
            this.router.navigate([URLs.ROOT, URLs.FORBIDDEN]);
          }
        }
        if (err.status === 404) {
          this.router.navigate([URLs.ROOT, URLs.OLDAL_NEM_ELERHETO]);
        }
        return Observable.throw(err);
      });
  }

  isRequestRefererActive() {
    return this.ownComService.referer === this.router.url;
  }
}
