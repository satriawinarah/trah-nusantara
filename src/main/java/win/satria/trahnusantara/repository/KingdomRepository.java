package win.satria.trahnusantara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import win.satria.trahnusantara.entity.KingdomEntity;

import java.util.List;
import java.util.Optional;

public interface KingdomRepository extends JpaRepository<KingdomEntity, Integer> {

  List<KingdomEntity> findAll();
  Optional<KingdomEntity> findById(Integer id);

}
