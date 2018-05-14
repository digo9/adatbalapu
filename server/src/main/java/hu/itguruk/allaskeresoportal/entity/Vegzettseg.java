package hu.itguruk.allaskeresoportal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Vegzettseg {

  @Id
//  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VegzettsegSeq")
//  @SequenceGenerator(sequenceName = "VEGZETTSEG_SEQ", allocationSize = 1, name = "VegzettsegSeq", initialValue = 30)
  @GeneratedValue
  private Long id;

  @ManyToMany
  private List<Allaskereso> allaskereso;

  private String megnevezes;

}
