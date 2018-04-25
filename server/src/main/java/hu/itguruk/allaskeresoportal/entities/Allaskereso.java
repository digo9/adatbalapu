package hu.itguruk.allaskeresoportal.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Table(name = "ALLASKERESO")
@Entity
public class Allaskereso {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AllaskeresoSeq")
  @SequenceGenerator(sequenceName = "ALLASKERESO_SEQ", allocationSize = 1, name = "AllaskeresoSeq", initialValue = 30)
  private Long id;

  private String nev;

  private Role role;

  @Size(max = 200)
  private String elerhetoseg;

  @Size(max = 20)
  private String statusz;

  private Date utolsoBejelentkezes;

  @OneToOne
  private Oneletrajz oneletrajz;

}
