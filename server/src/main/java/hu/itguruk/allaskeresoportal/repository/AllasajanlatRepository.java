package hu.itguruk.allaskeresoportal.repository;

import hu.itguruk.allaskeresoportal.entities.Allasajanlat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllasajanlatRepository extends JpaRepository<Allasajanlat, Long> {
}
