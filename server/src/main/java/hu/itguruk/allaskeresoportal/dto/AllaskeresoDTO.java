package hu.itguruk.allaskeresoportal.dto;

import hu.itguruk.allaskeresoportal.entity.Oneletrajz;
import hu.itguruk.allaskeresoportal.entity.Role;
import lombok.Data;

import java.util.Date;

@Data
public class AllaskeresoDTO {

    private Long id;

    private String vezeteknev;

    private String keresztnev;

    private String elerhetoseg;

    private String statusz;

    private Date utolsoBejelentkezes;

    private OneletrajzDTO oneletrajzDTO;

    private BaseUserDTO baseUserDTO;

}
