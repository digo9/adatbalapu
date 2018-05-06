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

export class BaseUser {
  constructor(
    public id?: number,
    public username?: string,
    public password?: string,
    public email?: string,
    public role?: Role,
    public munkaltatoId?: number,
    public allaskeresoId?: number
  ) {}
}
