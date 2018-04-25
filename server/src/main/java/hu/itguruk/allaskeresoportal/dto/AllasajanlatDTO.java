package hu.itguruk.allaskeresoportal.dto;

import hu.itguruk.allaskeresoportal.entities.Allaskereso;
import hu.itguruk.allaskeresoportal.entities.Munkaltato;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AllasajanlatDTO {

    private Long id;

    private String elvartVegzettsegek;

    private List<Allaskereso> jelentkezo;

    private Munkaltato ajanlatFeladoja;

    private String leiras;

    public AllasajanlatDTO() { }

    public AllasajanlatDTO(String elvartVegzettsegek, List<Allaskereso> jelentkezo, Munkaltato ajanlatFeladoja, String leiras) {
        this.elvartVegzettsegek = elvartVegzettsegek;
        this.jelentkezo = jelentkezo;
        this.ajanlatFeladoja = ajanlatFeladoja;
        this.leiras = leiras;
    }

}
