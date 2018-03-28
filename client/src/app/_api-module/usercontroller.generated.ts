import { HttpClient, HttpParams, HttpRequest, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/Observable';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/map';

import { User } from './user.model.generated';
import { ServiceConfig } from './serviceconfig';

@Injectable()
export class UserController {
    private get serviceBaseURL(): string {
        return this.serviceConfig.context + '';
    }
    private get onError(): (error: HttpErrorResponse) => ErrorObservable {
        return this.serviceConfig.onError || this.handleError.bind(this);
    }

    constructor(private httpClient: HttpClient, private serviceConfig: ServiceConfig) { }
    /* GET */
    public getUsersGet(): Observable<User[]> {
        const url = this.serviceBaseURL + '/api/users';
        const params = this.createHttpParams({});

        return this.httpClient.get<User[]>(url, {params: params})
            .catch((error: HttpErrorResponse) => this.onError(error));
    }


    /* HEAD */

    /* POST */

    /* PUT */

    /* PATCH */

    /* DELETE */

    /* OPTIONS */


    private handleError(error: HttpErrorResponse): ErrorObservable {
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

    private createHttpParams(values: { [index: string]: any }): HttpParams {
        let params: HttpParams = new HttpParams();

        Object.keys(values).forEach((key: string) => {
            const value: any = values[key];
            if (value != undefined) {
                params = params.set(key, String(value));
            }
        });

        return params;
    }
}
