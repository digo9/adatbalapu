package hu.itguruk.allaskeresoportal.repository;

import hu.itguruk.allaskeresoportal.entity.Allasajanlat;
import hu.itguruk.allaskeresoportal.entity.Allaskereso;
import hu.itguruk.allaskeresoportal.entity.Munkaltato;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllaskeresoRepository extends JpaRepository<Allaskereso, Long>{


  List<Allaskereso> findByAllasajanlats_Id(Long id);

}
