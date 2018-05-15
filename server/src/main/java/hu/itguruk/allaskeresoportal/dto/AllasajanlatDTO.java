package hu.itguruk.allaskeresoportal.dto;

import hu.itguruk.allaskeresoportal.entity.Allaskereso;
import hu.itguruk.allaskeresoportal.entity.Munkaltato;
import hu.itguruk.allaskeresoportal.entity.Vegzettseg;
import java.math.BigDecimal;
import lombok.Data;

import java.util.List;

@Data
public class AllasajanlatDTO {

    private Long id;
    
    private String megnevezes;

    private List<Allaskereso> jelentkezo;

    private Munkaltato munkaltato;

    private String leiras;

    private List<Vegzettseg> vegzettseg;

    private BigDecimal fizetes;

}
