package hu.itguruk.allaskeresoportal.dto;

import hu.itguruk.allaskeresoportal.entity.Munkaltato;
import lombok.Data;

import java.util.List;

@Data
public class AllasajanlatDTO {

    private Long id;
    
    private String megnevezes;

    private String elvartVegzettsegek;

    private List<AllaskeresoDTO> jelentkezoDTOList;

    private Munkaltato ajanlatFeladoja;

    private String leiras;

}
