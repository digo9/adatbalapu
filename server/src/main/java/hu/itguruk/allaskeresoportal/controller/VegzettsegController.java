package hu.itguruk.allaskeresoportal.controller;

import hu.itguruk.allaskeresoportal.dto.VegzettsegDTO;
import hu.itguruk.allaskeresoportal.entity.Vegzettseg;
import hu.itguruk.allaskeresoportal.repository.VegzettsegRepository;
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
@RequestMapping("/vegzettseg")
public class VegzettsegController {

  @Autowired
  VegzettsegRepository vegzettsegRepository;

  @Autowired
  ModelMapper modelMapper;

  @GetMapping("/all")
  public List<VegzettsegDTO> getAll() {
    return vegzettsegRepository.findAll()
        .stream()
        .map(vegzettseg -> modelMapper.map(vegzettseg, VegzettsegDTO.class))
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public Vegzettseg getOneById(@PathVariable(value = "id") Long id) {
    return vegzettsegRepository.findOne(id);
  }

  @DeleteMapping("/{id}")
  public void deleteOneById(@PathVariable(value = "id") Long id) {
    vegzettsegRepository.delete(id);
  }

  @PostMapping("/create")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<Vegzettseg> create(@RequestBody VegzettsegDTO vegzettsegDTO) {
    Vegzettseg vegzettseg = modelMapper.map(vegzettsegDTO, Vegzettseg.class);
    return ResponseEntity.ok(vegzettsegRepository.save(vegzettseg));
  }

  @PutMapping("/update")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<Vegzettseg> update(@RequestBody VegzettsegDTO vegzettsegDTO) {
    Vegzettseg vegzettseg = modelMapper.map(vegzettsegDTO, Vegzettseg.class);
    return ResponseEntity.ok(vegzettsegRepository.save(vegzettseg));
  }
}
