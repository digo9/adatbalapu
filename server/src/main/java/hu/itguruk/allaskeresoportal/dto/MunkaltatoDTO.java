package hu.itguruk.allaskeresoportal.dto;

import hu.itguruk.allaskeresoportal.entities.Szekhely;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MunkaltatoDTO {

    private Long id;

    private String nev;

    private String cegLeiras;

    private List<Szekhely> szekhely;

    public MunkaltatoDTO() {}

    public MunkaltatoDTO(String nev, String cegLeiras, List<Szekhely> szekhely) {
        this.nev = nev;
        this.cegLeiras = cegLeiras;
        this.szekhely = szekhely;
    }
}
