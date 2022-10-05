package win.satria.trahnusantara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import win.satria.trahnusantara.entity.NobleEntity;

import java.util.List;

public interface NobleRepository extends JpaRepository<NobleEntity, Integer> {

  List<NobleEntity> findAllByKingdomId(Integer parentId);

}
