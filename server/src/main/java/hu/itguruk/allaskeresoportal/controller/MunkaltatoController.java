package hu.itguruk.allaskeresoportal.controller;

import hu.itguruk.allaskeresoportal.dto.MunkaltatoDTO;
import hu.itguruk.allaskeresoportal.entities.Munkaltato;
import hu.itguruk.allaskeresoportal.repository.MunkaltatoRepository;
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
@RequestMapping("/munkaltato")
public class MunkaltatoController {

  @Autowired
  MunkaltatoRepository munkaltatoRepository;

  @Autowired
  ModelMapper modelMapper;

  @GetMapping("/all")
  public List<MunkaltatoDTO> getAll() {
    return munkaltatoRepository.findAll()
        .stream()
        .map(munkaltato -> modelMapper.map(munkaltato, MunkaltatoDTO.class))
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public MunkaltatoDTO getOneById(@PathVariable(value = "id") Long id) {
    return modelMapper.map(munkaltatoRepository.getOne(id),MunkaltatoDTO.class);
  }

  @PostMapping("/saveorupdate")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<Munkaltato> saveOrUpdate(@RequestBody MunkaltatoDTO munkaltatoDTO) {
    Munkaltato munkaltato = modelMapper.map(munkaltatoDTO, Munkaltato.class);
    return ResponseEntity.ok(munkaltatoRepository.save(munkaltato));
  }
}
