package hu.itguruk.allaskeresoportal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hu.itguruk.allaskeresoportal.entities.User;
import hu.itguruk.allaskeresoportal.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public void generateUser() {
    // userRepository.save(new User("Username"));
  }

  public List<User> getAllUser() {
    return userRepository.findAll();
  }
}
