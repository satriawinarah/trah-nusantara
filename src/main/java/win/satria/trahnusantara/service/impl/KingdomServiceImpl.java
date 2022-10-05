package win.satria.trahnusantara.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import win.satria.trahnusantara.dto.BaseResponse;
import win.satria.trahnusantara.dto.Kingdom;
import win.satria.trahnusantara.entity.KingdomEntity;
import win.satria.trahnusantara.mapper.KingdomMapper;
import win.satria.trahnusantara.repository.KingdomRepository;
import win.satria.trahnusantara.service.KingdomService;

import java.util.List;
import java.util.Optional;

@Service
public class KingdomServiceImpl implements KingdomService {

  @Autowired
  private KingdomRepository kingdomRepository;

  @Autowired
  private KingdomMapper mapper;

  @Override
  public List<Kingdom> getAllKingdom() {
    List<KingdomEntity> entities = kingdomRepository.findAll();
    return mapper.bulkEntityToDto(entities);
  }

  @Override
  public Kingdom getKingdomById(Integer id) {
    Optional<KingdomEntity> entity = kingdomRepository.findById(id);
    if(entity.isPresent()) {
      return mapper.entityToDto(entity.get());
    }
    return null;
  }

  @Override
  public List<KingdomEntity> bulkAddKingdom(List<Kingdom> kingdoms) {
    List<KingdomEntity> entities = kingdomRepository.saveAll(mapper.bulkDtoToEntity(kingdoms));
    return entities;
  }
}
