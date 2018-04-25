package hu.itguruk.allaskeresoportal.controller;

import hu.itguruk.allaskeresoportal.dto.AllasajanlatDTO;
import hu.itguruk.allaskeresoportal.entities.Allasajanlat;
import hu.itguruk.allaskeresoportal.repository.AllasajanlatRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/allasajanlat")
public class AllasajanlatController {

    @Autowired
    AllasajanlatRepository allasajanlatRepository;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/osszes")
    public List<AllasajanlatDTO> getAllAllasajanlat(){
        return allasajanlatRepository.findAll()
                .stream()
                .map(ajanlat -> modelMapper.map(ajanlat, AllasajanlatDTO.class))
                .collect(Collectors.toList());
    }

}
