package hu.itguruk.allaskeresoportal.controller;

import hu.itguruk.allaskeresoportal.dto.OneletrajzDTO;
import hu.itguruk.allaskeresoportal.entities.Oneletrajz;
import hu.itguruk.allaskeresoportal.repository.OneletrajzRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oneletrajz")
public class OneletrajzController {

  @Autowired
  OneletrajzRepository oneletrajzRepository;

  @Autowired
  ModelMapper modelMapper;

  @GetMapping("/all")
  public List<OneletrajzDTO> getAll() {
    return oneletrajzRepository.findAll()
        .stream()
        .map(oneletrajz -> modelMapper.map(oneletrajz, OneletrajzDTO.class))
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public OneletrajzDTO getOneById(@PathVariable(value = "id") Long id) {
    return modelMapper.map(oneletrajzRepository.getOne(id),OneletrajzDTO.class);
  }

  @PostMapping("/saveorupdate")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<Oneletrajz> saveOrUpdate(@RequestBody OneletrajzDTO oneletrajzDTO) {
    Oneletrajz oneletrajz = modelMapper.map(oneletrajzDTO, Oneletrajz.class);
    return ResponseEntity.ok(oneletrajzRepository.save(oneletrajz));
  }
}
