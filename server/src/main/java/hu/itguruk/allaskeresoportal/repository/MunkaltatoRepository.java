package hu.itguruk.allaskeresoportal.repository;

import hu.itguruk.allaskeresoportal.entity.Munkaltato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunkaltatoRepository extends JpaRepository<Munkaltato, Long> {

  Munkaltato findByAllasajanlats_id(Long id);

}
