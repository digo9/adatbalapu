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
public class Allaskereso extends User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
  @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
  private Long id;

  @Size(max = 200)
  private String elerhetoseg;

  @Size(max = 20)
  private String statusz;

  private Date utolsoBejelentkezes;

  @OneToOne
  private Oneletrajz oneletrajz;

  @OneToMany
  private List<Vegzettseg> vegzettseg;

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

  public List<Vegzettseg> getVegzettseg() {
    return vegzettseg;
  }

  public void setVegzettseg(List<Vegzettseg> vegzettseg) {
    this.vegzettseg = vegzettseg;
  }

}
