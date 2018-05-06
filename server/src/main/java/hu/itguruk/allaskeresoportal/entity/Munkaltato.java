package hu.itguruk.allaskeresoportal.entity;

import java.util.List;
import javax.persistence.CascadeType;
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
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "munkaltato_seq")
  @SequenceGenerator(name = "munkaltato_seq", sequenceName = "munkaltato_seq", allocationSize = 1)
  private Long id;

  private String cegNev;

  private String cegLeiras;

  @OneToMany(cascade = {CascadeType.REMOVE})
  private List<Szekhely> szekhely;

  @OneToOne(cascade = {CascadeType.REMOVE})
  private BaseUser baseUser;

}
