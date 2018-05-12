package hu.itguruk.allaskeresoportal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

  @RequestMapping("/secure")
  public ResponseEntity<Object> getSecureData() {
    return new ResponseEntity<>(
        SecurityContextHolder.getContext().getAuthentication().getPrincipal(), HttpStatus.OK);
  }

  @RequestMapping("/errorPage")
  public ResponseEntity<Void> errorPage() {
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }


}
