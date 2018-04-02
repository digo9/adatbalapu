package hu.itguruk.allaskeresoportal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "SZEKHELY")
@Entity
public class Szekhely {

  @Id
  @GeneratedValue()
  private Long id;

  private String megye;

  private String cim;

  public Szekhely() {}

  public String getMegye() {
    return megye;
  }

  public void setMegye(String megye) {
    this.megye = megye;
  }

  public String getCim() {
    return cim;
  }

  public void setCim(String cim) {
    this.cim = cim;
  }


}
