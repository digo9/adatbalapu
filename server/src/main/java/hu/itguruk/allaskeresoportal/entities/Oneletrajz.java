package hu.itguruk.allaskeresoportal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Table(name = "ONELETRAJZ")
@Entity
public class Oneletrajz {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OneletrajzSeq")
  @SequenceGenerator(sequenceName = "ONELETRAJZ_SEQ", allocationSize = 1, name = "OneletrajzSeq", initialValue = 30)
  private Long id;

  @Size(max = 30)
  private String nyelv;

  @Size(max = 2000)
  private String leiras;

}