package hu.itguruk.allaskeresoportal.dto;

import hu.itguruk.allaskeresoportal.entity.Munkaltato;
import java.math.BigDecimal;
import lombok.Data;

import java.util.List;

@Data
public class AllasajanlatDTO {

    private Long id;
    
    private String megnevezes;

    private List<AllaskeresoDTO> jelentkezoDTOList;

    private MunkaltatoDTO ajanlatFeladojaDTO;

    private String leiras;

    private List<VegzettsegDTO> vegzettsegDTOList;

    private BigDecimal fizetes;

}
