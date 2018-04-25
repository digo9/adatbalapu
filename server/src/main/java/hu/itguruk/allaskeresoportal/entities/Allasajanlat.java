package hu.itguruk.allaskeresoportal.entities;

import java.io.Serializable;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import lombok.Data;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Data
@Entity
public class Allasajanlat implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AllasajanlSeq")
  @SequenceGenerator(sequenceName = "ALLASAJANL_SEQ", allocationSize = 1, name = "AllasajanlSeq", initialValue = 30)
  private Long id;

  private String elvartVegzettsegek;

  @ManyToMany
  private List<Allaskereso> jelentkezo;

  @ManyToOne
  private Munkaltato ajanlatFeladoja;

  @Size(max = 2000)
  private String leiras;
}
