package hu.itguruk.allaskeresoportal.repository;

import hu.itguruk.allaskeresoportal.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

  Role findByRole(String role);

}
