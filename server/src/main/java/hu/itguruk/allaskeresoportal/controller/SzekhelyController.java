package hu.itguruk.allaskeresoportal.controller;

import hu.itguruk.allaskeresoportal.dto.SzekhelyDTO;
import hu.itguruk.allaskeresoportal.entity.Szekhely;
import hu.itguruk.allaskeresoportal.repository.SzekhelyRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/szekhely")
public class SzekhelyController {

  @Autowired
  SzekhelyRepository szekhelyRepository;

  @Autowired
  ModelMapper modelMapper;

  @GetMapping("/all")
  public List<SzekhelyDTO> getAll() {
    return szekhelyRepository.findAll()
        .stream()
        .map(szekhely -> modelMapper.map(szekhely, SzekhelyDTO.class))
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public SzekhelyDTO getOneById(@PathVariable(value = "id") Long id) {
    return modelMapper.map(szekhelyRepository.getOne(id),SzekhelyDTO.class);
  }

  @PostMapping("/create")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<Szekhely> create(@RequestBody SzekhelyDTO szekhelyDTO) {
    Szekhely szekhely = modelMapper.map(szekhelyDTO, Szekhely.class);
    return ResponseEntity.ok(szekhelyRepository.save(szekhely));
  }

  @PutMapping("/update")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<Szekhely> update(@RequestBody SzekhelyDTO szekhelyDTO) {
    Szekhely vegzettseg = modelMapper.map(szekhelyDTO, Szekhely.class);
    return ResponseEntity.ok(szekhelyRepository.save(vegzettseg));
  }
}
