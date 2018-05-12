import { Szekhely } from './szekhely.model';
import { Felhasznalo } from './baseuser.model';

export class Munkaltato {
  constructor(
    public id?: number,
    public cegNev?: string,
    public cegLeiras?: string,
    public szekhely?: Szekhely[],
    public felhasznalo?: Felhasznalo
  ) {
    this.szekhely = [];
  }
}
