import { Oneletrajz } from './oneletrajz.model';
import { Felhasznalo } from './baseuser.model';

export class Allaskereso {
  constructor(
    public id?: number,
    public elerhetoseg?: string,
    public vezeteknev?: string,
    public keresztnev?: string,
    public statusz?: string,
    public utolsoBejelentkezes?: Date,
    public felhasznaloId?: number,
    public oneletrajz?: Oneletrajz,
    public felhasznalo?: Felhasznalo
  ) {}
}
