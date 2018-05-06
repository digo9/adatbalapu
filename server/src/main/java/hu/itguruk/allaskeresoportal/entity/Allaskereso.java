package hu.itguruk.allaskeresoportal.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Allaskereso {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "allaskereso_seq")
  @SequenceGenerator(name = "allaskereso_seq", sequenceName = "allaskereso_seq", allocationSize = 1)
  private Long id;

  private String vezeteknev;

  private String keresztnev;

  @Size(max = 200)
  private String elerhetoseg;

  @Size(max = 20)
  private String statusz;

  private Date utolsoBejelentkezes;

  @OneToOne(cascade = {CascadeType.REMOVE})
  private Oneletrajz oneletrajz;

  @OneToOne(cascade = {CascadeType.REMOVE})
  private BaseUser baseUser;

}
