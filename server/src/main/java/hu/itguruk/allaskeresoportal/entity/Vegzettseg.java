package hu.itguruk.allaskeresoportal.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Vegzettseg {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VegzettsegSeq")
  @SequenceGenerator(sequenceName = "VEGZETTSEG_SEQ", allocationSize = 1, name = "VegzettsegSeq", initialValue = 30)
  private Long id;

  @ManyToOne(cascade = {CascadeType.REMOVE})
  private Allaskereso allaskereso;

  private String megnevezes;

  @Size(max = 4)
  private int megszerzesDatuma;

}
