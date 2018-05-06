package hu.itguruk.allaskeresoportal.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
@Table(name = "ALLASAJANLAT")
public class Allasajanlat implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AllasajanlSeq")
  @SequenceGenerator(sequenceName = "ALLASAJANL_SEQ", allocationSize = 1, name = "AllasajanlSeq", initialValue = 30)
  private Long id;

  private String elvartVegzettsegek;

  @ManyToMany(cascade = {CascadeType.REMOVE})
  private List<Allaskereso> jelentkezo;

  @ManyToOne(cascade = {CascadeType.REMOVE})
  private Munkaltato ajanlatFeladoja;

  @Size(max = 2000)
  private String leiras;
}