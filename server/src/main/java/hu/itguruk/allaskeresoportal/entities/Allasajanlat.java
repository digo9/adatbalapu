package hu.itguruk.allaskeresoportal.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Allasajanlat {

  @Id
  @GeneratedValue()
  private Long id;

  private String elvartVegzettsegek;

  @ManyToMany
  private List<Allaskereso> jelentkezo;

  @ManyToOne
  private Munkaltato ajanlatFeladoja;

  @Size(max = 2000)
  private String leiras;

  public Allasajanlat() {}

  public String getElvartVegzettsegek() {
    return elvartVegzettsegek;
  }

  public void setElvartVegzettsegek(String elvartVegzettsegek) {
    this.elvartVegzettsegek = elvartVegzettsegek;
  }

  public List<Allaskereso> getJeletnekzok() {
    return jelentkezo;
  }

  public void setJeletnekzok(List<Allaskereso> jeletnekzo) {
    this.jelentkezo = jeletnekzo;
  }

  public Munkaltato getAjanlatFeladoja() {
    return ajanlatFeladoja;
  }

  public void setAjanlatFeladoja(Munkaltato ajanlatFeladoja) {
    this.ajanlatFeladoja = ajanlatFeladoja;
  }

  public List<Allaskereso> getJelentkezo() {
    return jelentkezo;
  }

  public void setJelentkezo(List<Allaskereso> jelentkezo) {
    this.jelentkezo = jelentkezo;
  }

  public String getLeiras() {
    return leiras;
  }

  public void setLeiras(String leiras) {
    this.leiras = leiras;
  }

}
