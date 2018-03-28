import { Injectable } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';

@Injectable()
export abstract class ServiceConfig {
    context?: string;
    debug?: boolean;
    onError?(error?: HttpErrorResponse): ErrorObservable;
}
