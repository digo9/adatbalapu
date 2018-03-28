package hu.itguruk.allaskeresoportal.controller;

import java.util.List;
import org.leandreck.endpoints.annotations.TypeScriptEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import hu.itguruk.allaskeresoportal.entities.User;
import hu.itguruk.allaskeresoportal.service.UserService;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping()
@TypeScriptEndpoint
public class UserController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/api/users", method = RequestMethod.GET,
      produces = APPLICATION_JSON_VALUE)
  public List<User> getUsers() {
    return userService.getAllUser();
  }
}
