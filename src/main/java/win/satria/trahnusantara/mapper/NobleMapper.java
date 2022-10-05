package win.satria.trahnusantara.mapper;

import org.springframework.stereotype.Component;
import win.satria.trahnusantara.dto.Noble;
import win.satria.trahnusantara.entity.NobleEntity;
import win.satria.trahnusantara.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

@Component
public class NobleMapper {

  public Noble entityToDto(NobleEntity entity) {
    return Noble.builder()
      .id(entity.getId())
      .name(entity.getName())
      .alias(entity.getAlias())
      .dateStart(entity.getDateStart())
      .dateEnd(entity.getDateEnd())
      .parentId(entity.getParentId())
      .kingdomId(entity.getKingdomId())
      .description(entity.getDescription())
      .build();
  }

  public List<Noble> bulkEntityToDto(List<NobleEntity> entities) {
    List<Noble> nobles = new ArrayList<>();
    entities.forEach(noble -> nobles.add(entityToDto(noble)));
    return nobles;
  }

  public NobleEntity dtoToEntity(Noble dto) {
    NobleEntity entity = new NobleEntity();
    entity.setId(dto.getId());
    entity.setName(dto.getName());
    entity.setAlias(dto.getAlias());
    entity.setDescription(dto.getDescription());
    entity.setKingdomId(dto.getKingdomId());
    entity.setParentId(dto.getParentId());
    entity.setDateStart(dto.getDateStart());
    entity.setDateEnd(dto.getDateEnd());
    entity.setCreatedDate(DateUtil.dateNow());
    entity.setUpdatedDate(DateUtil.dateNow());
    return entity;
  }

}
