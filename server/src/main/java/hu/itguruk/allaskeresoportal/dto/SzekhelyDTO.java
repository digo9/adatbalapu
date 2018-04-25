package hu.itguruk.allaskeresoportal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SzekhelyDTO {

    private Long id;

    private String megye;

    private String cim;

    public SzekhelyDTO() {}

    public SzekhelyDTO(String megye, String cim) {
        this.megye = megye;
        this.cim = cim;
    }
}
