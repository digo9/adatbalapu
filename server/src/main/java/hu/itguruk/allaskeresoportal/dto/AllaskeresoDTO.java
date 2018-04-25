package hu.itguruk.allaskeresoportal.dto;

import hu.itguruk.allaskeresoportal.entities.Oneletrajz;
import hu.itguruk.allaskeresoportal.entities.Role;
import lombok.Data;

import java.util.Date;

@Data
public class AllaskeresoDTO {

    private Long id;

    private String nev;

    private Role role;

    private String elerhetoseg;

    private String statusz;

    private Date utolsoBejelentkezes;

    private Oneletrajz oneletrajz;

}
