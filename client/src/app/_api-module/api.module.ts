import { NgModule, ModuleWithProviders } from '@angular/core';
import { UserController } from './usercontroller.generated';
import { ServiceConfig } from './serviceconfig';
import { HttpClient } from '@angular/common/http';

@NgModule({})
export class APIModule {
    static forRoot(serviceConfig: ServiceConfig = { context: '' }): ModuleWithProviders {
        return {
            ngModule: APIModule,
            providers: [
                { provide: ServiceConfig, useValue: serviceConfig },
                UserController, HttpClient
            ]
        };
    }
}
