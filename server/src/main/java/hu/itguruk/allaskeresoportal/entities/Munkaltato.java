package hu.itguruk.allaskeresoportal.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "MUNKALTATO")
@Entity
public class Munkaltato {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MunkaltatoSeq")
  @SequenceGenerator(sequenceName = "MUNKALTATO_SEQ", allocationSize = 1, name = "MunkaltatoSeq", initialValue = 30)
  private Long id;

  private String nev;

  private String cegLeiras;

  @OneToMany
  private List<Szekhely> szekhely;

}
