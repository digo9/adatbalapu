import { CV } from './cv.model';

export const enum Role {

    ROLE_ADMIN, ROLE_USERorupda

}

export const enum County {
    'Bács-Kiskun',
    'Baranya',
    'Békés',
    'Borsod-Abaúj-Zemplén',
    'Csongrád',
    'Fejér',
    'Győr-Moson-Sopron',
    'Hajdú-Bihar',
    'Heves',
    'Jász-Nagykun-Szolnok',
    'Komárom-Esztergom',
    'Nógrád',
    'Pest',
    'Somogy',
    'Szabolcs-Szatmár-Bereg',
    'Tolna',
    'Vas',
    'Veszprém',
    'Zala'
}

export class User {

    public id?: number;

    public name?: string;

    public password?: string;

    public email?: string;

    public role?: Role;

    public address?: string;

    public county?: County;

    public lastLogin?: Date;

    public cvs?: CV[];

}
