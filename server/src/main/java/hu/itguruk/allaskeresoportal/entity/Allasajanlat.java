package hu.itguruk.allaskeresoportal.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
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
//  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AllasajanlSeq")
//  @SequenceGenerator(sequenceName = "ALLASAJANL_SEQ", allocationSize = 1, name = "AllasajanlSeq", initialValue = 30)
  @GeneratedValue
  private Long id;

  private String megnevezes;
  
  @ManyToMany(cascade = {CascadeType.ALL})
  private List<Allaskereso> jelentkezo;

  @ManyToOne
  @JoinColumn(name = "munkaltato_ID", referencedColumnName = "ID")
  private Munkaltato munkaltato;

  @Size(max = 2000)
  private String leiras;

  @ManyToMany(cascade = {CascadeType.ALL})
  private List<Vegzettseg> vegzettseg;

  private BigDecimal fizetes;
}
