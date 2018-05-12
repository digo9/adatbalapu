package hu.itguruk.allaskeresoportal.controller;

import hu.itguruk.allaskeresoportal.dto.BaseUserDTO;
import hu.itguruk.allaskeresoportal.dto.MunkaltatoDTO;
import hu.itguruk.allaskeresoportal.entity.BaseUser;
import hu.itguruk.allaskeresoportal.entity.Munkaltato;
import hu.itguruk.allaskeresoportal.repository.BaseUserRepository;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/baseuser")
public class BaseUserController {


  @Autowired
  BaseUserRepository baseUserRepository;

  @Autowired
  ModelMapper modelMapper;

  @GetMapping("/all")
  public List<BaseUserDTO> getAll() {
    return baseUserRepository.findAll()
        .stream()
        .map(baseUser -> modelMapper.map(baseUser, BaseUserDTO.class))
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public BaseUserDTO getOneById(@PathVariable(value = "id") Long id) {
    return modelMapper.map(baseUserRepository.getOne(id),BaseUserDTO.class);
  }

  @PostMapping("/create")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<BaseUser> saveOrUpdate(@RequestBody BaseUserDTO baseUserDTO) {
    BaseUser baseUser = modelMapper.map(baseUserDTO, BaseUser.class);
    return ResponseEntity.ok(baseUserRepository.save(baseUser));
  }

  @PutMapping("/update")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<BaseUser> update(@RequestBody BaseUserDTO baseUserDTO) {
    BaseUser baseUser = modelMapper.map(baseUserDTO, BaseUser.class);
    return ResponseEntity.ok(baseUserRepository.save(baseUser));
  }

  @GetMapping("/user")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<BaseUser> getUserByUsername(@RequestParam("username") String felhasznalonev) {
    BaseUser baseUser = baseUserRepository.findByFelhasznalonev(felhasznalonev);
    return ResponseEntity.ok(baseUserRepository.save(baseUser));
  }


}
