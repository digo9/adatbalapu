package hu.itguruk.allaskeresoportal.controller;


import hu.itguruk.allaskeresoportal.dto.AllaskeresoDTO;
import hu.itguruk.allaskeresoportal.entity.Allaskereso;
import hu.itguruk.allaskeresoportal.repository.AllaskeresoRepository;
import java.util.Date;
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
@RequestMapping("/allaskereso")
public class AllaskeresoController {

  @Autowired
  AllaskeresoRepository allaskeresoRepository;

  @Autowired
  ModelMapper modelMapper;

  @GetMapping("/all")
  public List<AllaskeresoDTO> getAll() {
    return allaskeresoRepository.findAll()
        .stream()
        .map(allaskereso -> modelMapper.map(allaskereso, AllaskeresoDTO.class))
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public AllaskeresoDTO getOneById(@PathVariable(value = "id") Long id) {
    return modelMapper.map(allaskeresoRepository.getOne(id),AllaskeresoDTO.class);
  }

  @PostMapping("/create")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<Allaskereso> saveOrUpdate(@RequestBody Allaskereso allaskereso) {
    allaskereso.setUtolsoBejelentkezes(new Date());
    allaskereso.getFelhasznalo().setEngedelyezve(true);
    return ResponseEntity.ok(allaskeresoRepository.save(allaskereso));
  }

  @PutMapping("/update")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<Allaskereso> update(@RequestBody Allaskereso allaskereso) {
    return ResponseEntity.ok(allaskeresoRepository.save(allaskereso));
  }
}
