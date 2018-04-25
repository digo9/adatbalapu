package hu.itguruk.allaskeresoportal.dto;

import hu.itguruk.allaskeresoportal.entities.Oneletrajz;
import hu.itguruk.allaskeresoportal.entities.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AllaskeresoDTO {

    private Long id;

    private String nev;

    private Role role;

    private String elerhetoseg;

    private String statusz;

    private Date utolsoBejelentkezes;

    private Oneletrajz oneletrajz;

    public AllaskeresoDTO() {}

    public AllaskeresoDTO(String nev, Role role, String elerhetoseg, String statusz, Date utolsoBejelentkezes, Oneletrajz oneletrajz) {
        this.nev = nev;
        this.role = role;
        this.elerhetoseg = elerhetoseg;
        this.statusz = statusz;
        this.utolsoBejelentkezes = utolsoBejelentkezes;
        this.oneletrajz = oneletrajz;
    }

}
