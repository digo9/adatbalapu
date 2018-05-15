package hu.itguruk.allaskeresoportal.dto;

import hu.itguruk.allaskeresoportal.entity.Allaskereso;
import lombok.Data;

@Data
public class VegzettsegDTO {

    private Long id;

    private Allaskereso allaskereso;

    private String megnevezes;

}
