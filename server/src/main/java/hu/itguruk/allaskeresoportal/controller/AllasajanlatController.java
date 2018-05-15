package hu.itguruk.allaskeresoportal.controller;

import hu.itguruk.allaskeresoportal.dto.AllasajanlatDTO;
import hu.itguruk.allaskeresoportal.entity.Allasajanlat;
import hu.itguruk.allaskeresoportal.entity.Allaskereso;
import hu.itguruk.allaskeresoportal.entity.BaseUser;
import hu.itguruk.allaskeresoportal.entity.Munkaltato;
import hu.itguruk.allaskeresoportal.repository.AllasajanlatRepository;
import hu.itguruk.allaskeresoportal.repository.AllaskeresoRepository;
import hu.itguruk.allaskeresoportal.repository.MunkaltatoRepository;
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

    @Autowired
    AllaskeresoRepository allaskeresoRepository;

    @Autowired
    MunkaltatoRepository munkaltatoRepository;

    @GetMapping("/all")
    public List<Allasajanlat> getAll() {
        return allasajanlatRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Allasajanlat getOneById(@PathVariable(value = "id") Long id) {
        return allasajanlatRepository.findOne(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteOneById(@PathVariable(value = "id") Long id) {
        allasajanlatRepository.delete(id);
    }

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Allasajanlat> saveOrUpdate(@RequestBody Allasajanlat allasajanlat) {
        // Allasajanlat allasajanlat = modelMapper.map(allasajanlatDTO, Allasajanlat.class);
      return ResponseEntity.ok(allasajanlatRepository.save(allasajanlat));
    }

    @PutMapping("/update")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Allasajanlat> update(@RequestBody Allasajanlat allasajanlat) {
        // Allasajanlat vegzettseg = modelMapper.map(allasajanlatDTO, Allasajanlat.class);
        return ResponseEntity.ok(allasajanlatRepository.save(allasajanlat));
    }

    @GetMapping("/{id}/users")
    public List<Allaskereso> assignedUsers(@PathVariable (value = "id") Long id) {
       return allaskeresoRepository.findByAllasajanlats_Id(id);
    }

    @GetMapping("/{id}/munkaltato")
    public Munkaltato munkaltato(@PathVariable (value = "id") Long id ){
        Munkaltato munk = munkaltatoRepository.findByAllasajanlats_id(id);
        munk.setAllasajanlats(null);
        return munk;
    }

}
