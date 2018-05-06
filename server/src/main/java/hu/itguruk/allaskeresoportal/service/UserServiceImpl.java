package hu.itguruk.allaskeresoportal.service;

import hu.itguruk.allaskeresoportal.entity.BaseUser;
import hu.itguruk.allaskeresoportal.repository.BaseUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserService, UserDetailsService {

  @Autowired
  private BaseUserRepository userRepository;

  @Override
  public BaseUser findByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    BaseUser user = findByUsername(username);
    if(user == null) {
      throw new UsernameNotFoundException(username);
    }
    return new UserDetailsImpl(user);
  }
}
