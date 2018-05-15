package hu.itguruk.allaskeresoportal.dto;

import hu.itguruk.allaskeresoportal.entity.BaseUser;
import hu.itguruk.allaskeresoportal.entity.Szekhely;
import lombok.Data;

import java.util.List;

@Data
public class MunkaltatoDTO {

    private Long id;

    private String cegNev;

    private String cegLeiras;

    private List<Szekhely> szekhely;

    private BaseUser baseUser;
}
