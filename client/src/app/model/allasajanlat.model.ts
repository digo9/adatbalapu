import { Allaskereso } from './allaskereso.model';
import { Munkaltato } from './munkaltato.model';
import { Vegzettseg } from './vegzettseg.model';

export class Allasajanlat {
  constructor(
    public id?: number,
    public megnevezes?: String,
    public jelentkezo?: Allaskereso[],
    public munkaltato?: Munkaltato,
    public leiras?: String,
    public fizetes?: number,
    public vegzettseg?: Vegzettseg[]
  ) {
    this.jelentkezo = [];
    this.vegzettseg = [];
  }
}
