package hu.itguruk.allaskeresoportal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OneletrajzDTO {

    private Long id;

    private String nyelv;

    private String leiras;

    public OneletrajzDTO() {}

    public OneletrajzDTO(String nyelv, String leiras) {
        this.nyelv = nyelv;
        this.leiras = leiras;
    }

}
