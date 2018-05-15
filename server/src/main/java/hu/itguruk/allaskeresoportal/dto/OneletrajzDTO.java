package hu.itguruk.allaskeresoportal.dto;

import hu.itguruk.allaskeresoportal.entity.Allaskereso;
import lombok.Data;

@Data
public class OneletrajzDTO {

    private Long id;

    private String nyelv;

    private String leiras;

    private Allaskereso allaskereso;

}
