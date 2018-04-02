package hu.itguruk.allaskeresoportal.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

@Entity
public class Vegzettseg {

  @Id
  @GeneratedValue()
  private Long id;

  @ManyToOne
  private Allaskereso allaskereso;

  private String megnevezes;

  @Size(max = 4)
  private int megszerzesDatuma;

  public Vegzettseg() {}

  public Allaskereso getAllaskereso() {
    return allaskereso;
  }

  public void setAllaskereso(Allaskereso allaskereso) {
    this.allaskereso = allaskereso;
  }

  public String getMegnevezes() {
    return megnevezes;
  }

  public void setMegnevezes(String megnevezes) {
    this.megnevezes = megnevezes;
  }

  public int getMegszerzesDatuma() {
    return megszerzesDatuma;
  }

  public void setMegszerzesDatuma(int megszerzesDatuma) {
    this.megszerzesDatuma = megszerzesDatuma;
  }

}
