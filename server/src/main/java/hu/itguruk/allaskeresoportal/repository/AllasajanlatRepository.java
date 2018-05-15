package hu.itguruk.allaskeresoportal.repository;

import hu.itguruk.allaskeresoportal.entity.Allasajanlat;
import hu.itguruk.allaskeresoportal.entity.Allaskereso;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AllasajanlatRepository extends JpaRepository<Allasajanlat, Long> {

  // List<Allasajanlat> findByJelentkezos_Id(Long id);

}
