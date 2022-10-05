package win.satria.trahnusantara.service;

import win.satria.trahnusantara.dto.BaseResponse;
import win.satria.trahnusantara.dto.Kingdom;
import win.satria.trahnusantara.entity.KingdomEntity;

import java.util.List;

public interface KingdomService {

  List<Kingdom> getAllKingdom();
  Kingdom getKingdomById(Integer id);
  List<KingdomEntity> bulkAddKingdom(List<Kingdom> kingdoms);

}
