package hu.itguruk.allaskeresoportal.service;

import hu.itguruk.allaskeresoportal.entity.BaseUser;
import hu.itguruk.allaskeresoportal.repository.BaseUserRepository;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

  private static final String ADMIN_ROLE = "ADMIN";

  @Autowired
  private BaseUserRepository userRepository;

  @Override
  public BaseUser findByUsername(String username) {
    return userRepository.findByFelhasznalonev(username);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    BaseUser user = findByUsername(username);
    if(user == null) {
      System.out.println("Invaild username and password!");
      throw new UsernameNotFoundException(username);
    }
    return new UserDetailsImpl(user);
  }

  private Collection<GrantedAuthority> getAuthorities(BaseUser user) {
    Set<GrantedAuthority> authorities = new HashSet<>();
    authorities.add(new SimpleGrantedAuthority(ADMIN_ROLE));
    return authorities;
  }
}
