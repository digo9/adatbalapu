package hu.itguruk.allaskeresoportal.controller;

import org.leandreck.endpoints.annotations.TypeScriptEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.itguruk.allaskeresoportal.service.UserService;

@RestController
@RequestMapping()
@TypeScriptEndpoint
public class UserController {

  @Autowired
  UserService userService;

}
