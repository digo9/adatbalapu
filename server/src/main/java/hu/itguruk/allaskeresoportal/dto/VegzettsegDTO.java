package hu.itguruk.allaskeresoportal.dto;

import hu.itguruk.allaskeresoportal.entities.Allaskereso;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VegzettsegDTO {

    private Long id;

    private Allaskereso allaskereso;

    private String megnevezes;

    private int megszerzesDatuma;

    public VegzettsegDTO() {}

    public VegzettsegDTO(Allaskereso allaskereso, String megnevezes, int megszerzesDatuma) {
        this.allaskereso = allaskereso;
        this.megnevezes = megnevezes;
        this.megszerzesDatuma = megszerzesDatuma;
    }

}
