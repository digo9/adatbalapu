package hu.itguruk.allaskeresoportal.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Table(name = "ALLASKERESO")
@Entity
public class Allaskereso {

  @Id
  @GeneratedValue()
  private Long id;

  private String nev;

  private Role role;

  @Size(max = 200)
  private String elerhetoseg;

  @Size(max = 20)
  private String statusz;

  private Date utolsoBejelentkezes;

  @OneToOne
  private Oneletrajz oneletrajz;

  public Allaskereso() {}

  public String getElerhetoseg() {
    return elerhetoseg;
  }

  public void setElerhetoseg(String elerhetoseg) {
    this.elerhetoseg = elerhetoseg;
  }

  public String getStatusz() {
    return statusz;
  }

  public void setStatusz(String statusz) {
    this.statusz = statusz;
  }

  public Date getUtolsoBejelentkezes() {
    return utolsoBejelentkezes;
  }

  public void setUtolsoBejelentkezes(Date utolsoBejelentkezes) {
    this.utolsoBejelentkezes = utolsoBejelentkezes;
  }

  public Oneletrajz getOneletrajz() {
    return oneletrajz;
  }

  public void setOneletrajz(Oneletrajz oneletrajz) {
    this.oneletrajz = oneletrajz;
  }

  public String getNev() {
    return nev;
  }

  public void setNev(String nev) {
    this.nev = nev;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }


}
