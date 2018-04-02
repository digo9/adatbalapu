package hu.itguruk.allaskeresoportal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Table(name = "ONELETRAJZ")
@Entity
public class Oneletrajz {

  @Id
  @GeneratedValue()
  private Long id;

  @Size(max = 30)
  private String nyelv;

  @Size(max = 2000)
  private String leiras;

  public Oneletrajz() {}

  public String getNyelv() {
    return nyelv;
  }

  public void setNyelv(String nyelv) {
    this.nyelv = nyelv;
  }

  public String getLeiras() {
    return leiras;
  }

  public void setLeiras(String leiras) {
    this.leiras = leiras;
  }

}
