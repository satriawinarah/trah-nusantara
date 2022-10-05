package win.satria.trahnusantara.mapper;

import org.springframework.stereotype.Component;
import win.satria.trahnusantara.dto.Kingdom;
import win.satria.trahnusantara.entity.KingdomEntity;
import win.satria.trahnusantara.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

@Component
public class KingdomMapper {

  public Kingdom entityToDto(KingdomEntity entity) {
    return Kingdom.builder()
      .id(entity.getId())
      .name(entity.getName())
      .yearStart(entity.getYearStart())
      .yearEnd(entity.getYearEnd())
      .createdDate(entity.getCreatedDate())
      .updatedDate(entity.getUpdatedDate())
      .build();
  }

  public KingdomEntity dtoToEntity(Kingdom dto) {
    KingdomEntity entity = new KingdomEntity();
    entity.setName(dto.getName());
    entity.setYearStart(dto.getYearStart());
    entity.setYearEnd(dto.getYearEnd());
    entity.setCreatedDate(DateUtil.dateNow());
    entity.setUpdatedDate(DateUtil.dateNow());
    return entity;
  }

  public List<Kingdom> bulkEntityToDto(List<KingdomEntity> entities) {
    List<Kingdom> kingdoms = new ArrayList<>();
    entities.forEach(entity -> kingdoms.add(entityToDto(entity)));

    return kingdoms;
  }

  public List<KingdomEntity> bulkDtoToEntity(List<Kingdom> dtos) {
    List<KingdomEntity> entities = new ArrayList<>();
    dtos.forEach(dto -> entities.add(dtoToEntity(dto)));

    return entities;
  }

}
