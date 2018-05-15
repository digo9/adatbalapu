package hu.itguruk.allaskeresoportal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Munkaltato {

  @Id
//  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "munkaltato_seq")
//  @SequenceGenerator(name = "munkaltato_seq", sequenceName = "munkaltato_seq", allocationSize = 1)
  @GeneratedValue
  private Long id;

  @Column(name = "nev")
  private String cegNev;

  private String cegLeiras;

  @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE})
  private List<Szekhely> szekhely;

  @JsonIgnore
  @OneToMany(cascade={CascadeType.ALL, CascadeType.REMOVE}, mappedBy="munkaltato")
  private List<Allasajanlat> allasajanlats =
      new ArrayList<Allasajanlat>();

  @JsonIgnore
  @OneToOne
  private BaseUser felhasznalo;

}
