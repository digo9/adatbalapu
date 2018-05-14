package hu.itguruk.allaskeresoportal.dto;

import hu.itguruk.allaskeresoportal.entity.Allaskereso;
import hu.itguruk.allaskeresoportal.entity.Munkaltato;
import hu.itguruk.allaskeresoportal.entity.Role;
import java.util.Set;
import lombok.Data;

@Data
public class BaseUserDTO {

  private Long id;

  private String felhasznalonev;

  private String email;

  private String jelszo;

  private Set<Role> roles;

  private boolean engedelyezve;

  private Munkaltato munkaltato;

  private Allaskereso allaskereso;

}
