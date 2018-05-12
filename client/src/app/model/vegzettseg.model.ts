import { Allaskereso } from './allaskereso.model';

export class Vegzettseg {
  constructor(
    public id?: number,
    public allaskereso?: Allaskereso[],
    public megnevezes?: String
  ) {
    this.allaskereso = [];
  }
}
