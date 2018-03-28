package hu.itguruk.allaskeresoportal.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Vegzettseg {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
  @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
  private Long id;

  @ManyToOne
  private Allaskereso allaskereso;

  private String megnevezes;

  private Date megszerzesDatuma;

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

  public Date getMegszerzesDatuma() {
    return megszerzesDatuma;
  }

  public void setMegszerzesDatuma(Date megszerzesDatuma) {
    this.megszerzesDatuma = megszerzesDatuma;
  }

}
