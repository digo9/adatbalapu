package hu.itguruk.allaskeresoportal.dto;

import lombok.Data;

import java.util.List;

@Data
public class MunkaltatoDTO {

    private Long id;

    private String cegNev;

    private String cegLeiras;

    private List<SzekhelyDTO> szekhelyDTOList;

    private BaseUserDTO baseUserDTO;
}
