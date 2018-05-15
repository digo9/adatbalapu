package hu.itguruk.allaskeresoportal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Allaskereso {

  @Id
//  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "allaskereso_seq")
//  @SequenceGenerator(name = "allaskereso_seq", sequenceName = "allaskereso_seq", allocationSize = 1, initialValue = 30)
  @GeneratedValue
  private Long id;

  private String vezeteknev;

  private String keresztnev;

  @Size(max = 200)
  private String elerhetoseg;

  @Size(max = 20)
  private String statusz;

  private Date utolsoBejelentkezes;

  @OneToOne(cascade = {CascadeType.ALL})
  private Oneletrajz oneletrajz;

  @JsonIgnore
  @ManyToMany(mappedBy = "jelentkezos")
  private List<Allasajanlat> allasajanlats = new ArrayList<>();

//  @OneToOne(cascade = {CascadeType.ALL})
//  private BaseUser felhasznalo;

}
