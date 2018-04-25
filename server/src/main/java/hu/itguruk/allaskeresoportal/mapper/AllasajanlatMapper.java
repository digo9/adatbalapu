package hu.itguruk.allaskeresoportal.mapper;

import hu.itguruk.allaskeresoportal.dto.AllasajanlatDTO;
import hu.itguruk.allaskeresoportal.entities.Allasajanlat;
import org.modelmapper.ModelMapper;


public class AllasajanlatMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public AllasajanlatDTO allasajanlatEntityToDTO(Allasajanlat allasajanlat) {
        return modelMapper.map(allasajanlat, AllasajanlatDTO.class);
    }


}
