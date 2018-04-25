package hu.itguruk.allaskeresoportal.controller;

import hu.itguruk.allaskeresoportal.dto.AllasajanlatDTO;
import hu.itguruk.allaskeresoportal.entities.Allasajanlat;
import hu.itguruk.allaskeresoportal.repository.AllasajanlatRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/allasajanlat")
public class AllasajanlatController {

    @Autowired
    AllasajanlatRepository allasajanlatRepository;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/all")
    public List<AllasajanlatDTO> getAll() {
        return allasajanlatRepository.findAll()
                .stream()
                .map(ajanlat -> modelMapper.map(ajanlat, AllasajanlatDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AllasajanlatDTO getOneById(@PathVariable(value = "id") Long id) {
        return modelMapper.map(allasajanlatRepository.getOne(id),AllasajanlatDTO.class);
    }

    @PostMapping("/saveorupdate")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Allasajanlat> saveOrUpdate(@RequestBody AllasajanlatDTO allasajanlatDTO) {
        Allasajanlat allasajanlat = modelMapper.map(allasajanlatDTO, Allasajanlat.class);
        return ResponseEntity.ok(allasajanlatRepository.save(allasajanlat));
    }

}