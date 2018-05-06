package hu.itguruk.allaskeresoportal.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "SZEKHELY")
@Entity
public class Szekhely {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SekhelySeq")
  @SequenceGenerator(sequenceName = "SZEKHELY_SEQ", allocationSize = 1, name = "SekhelySeq", initialValue = 30)
  private Long id;

  private String megye;

  private String cim;

  @ManyToOne(cascade = {CascadeType.REMOVE})
  private Munkaltato munkaltato;

}