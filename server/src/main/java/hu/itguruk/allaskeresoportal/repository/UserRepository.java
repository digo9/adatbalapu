package hu.itguruk.allaskeresoportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hu.itguruk.allaskeresoportal.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
