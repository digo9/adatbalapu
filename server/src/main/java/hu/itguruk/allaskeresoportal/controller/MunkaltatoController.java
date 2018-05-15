package hu.itguruk.allaskeresoportal.controller;

import hu.itguruk.allaskeresoportal.dto.MunkaltatoDTO;
import hu.itguruk.allaskeresoportal.entity.Munkaltato;
import hu.itguruk.allaskeresoportal.repository.MunkaltatoRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  public Munkaltato getOneById(@PathVariable(value = "id") Long id) {
    return munkaltatoRepository.findOne(id);
  }

  @DeleteMapping("/{id}")
  public void deleteOneById(@PathVariable(value = "id") Long id) {
    munkaltatoRepository.delete(id);
  }

  @PostMapping("/create")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<Munkaltato> saveOrUpdate(@RequestBody Munkaltato munkaltato) {
    return ResponseEntity.ok(munkaltatoRepository.save(munkaltato));
  }

  @PutMapping("/update")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<Munkaltato> update(@RequestBody Munkaltato munkaltato) {
    return ResponseEntity.ok(munkaltatoRepository.save(munkaltato));
  }
}
