import { Allaskereso } from './allaskereso.model';
import { Munkaltato } from './munkaltato.model';

export const enum Role {
  ROLE_ADMIN,
  ROLE_USER
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

export class Felhasznalo {
  constructor(
    public id?: number,
    public email?: string,
    public felhasznalonev?: string,
    public jelszo?: string,
    public engedelyezve?: number,
    public roles?: Role[],
    public allaskeresoId?: number,
    public munkaltato?: Munkaltato,
    public allaskereso?: Allaskereso
  ) {
    this.roles = [];
  }
}
