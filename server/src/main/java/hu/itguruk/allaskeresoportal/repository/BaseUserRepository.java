package hu.itguruk.allaskeresoportal.repository;

import hu.itguruk.allaskeresoportal.entity.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseUserRepository extends JpaRepository<BaseUser, Long> {

  BaseUser findByUsername(String username);

}
