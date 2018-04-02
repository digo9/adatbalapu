package hu.itguruk.allaskeresoportal.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "MUNKALTATO")
@Entity
public class Munkaltato {

  @Id
  @GeneratedValue()
  private Long id;

  private String nev;

  private String cegLeiras;

  @OneToMany
  private List<Szekhely> szekhely;

  public Munkaltato() {}

  public String getNev() {
    return nev;
  }

  public void setNev(String nev) {
    this.nev = nev;
  }

  public String getCegLeiras() {
    return cegLeiras;
  }

  public void setCegLeiras(String cegLeiras) {
    this.cegLeiras = cegLeiras;
  }

  public List<Szekhely> getSzekhely() {
    return szekhely;
  }

  public void setSzekhely(List<Szekhely> szekhely) {
    this.szekhely = szekhely;
  }

}
