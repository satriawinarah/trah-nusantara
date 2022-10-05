package win.satria.trahnusantara.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import win.satria.trahnusantara.dto.Noble;
import win.satria.trahnusantara.entity.NobleEntity;
import win.satria.trahnusantara.mapper.NobleMapper;
import win.satria.trahnusantara.repository.NobleRepository;
import win.satria.trahnusantara.service.NobleService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class NobleServiceImpl implements NobleService {

  @Autowired
  private NobleRepository nobleRepository;

  @Autowired
  private NobleMapper mapper;

  @Override
  public Noble getNobleFamilyTreeByKingdomId(Integer kingdomId) {
    List<NobleEntity> entities = nobleRepository.findAllByKingdomId(kingdomId);
    List<Noble> nobles = mapper.bulkEntityToDto(entities);

    return createFamilyTree(nobles);
  }

  @Transactional
  @Override
  public Noble bulkAddNoblePerFamily(Noble noble) {
    if(Objects.isNull(noble.getId())) {
      NobleEntity rootEntity = nobleRepository.save(mapper.dtoToEntity(noble));
      noble.setId(rootEntity.getId());
    } else {
      nobleRepository.save(mapper.dtoToEntity(noble));
    }
    walkOnTheTree(noble);

    return noble;
  }

  private void walkOnTheTree(Noble noble) {
    for(Noble child: noble.getChildren()) {
      child.setParentId(noble.getId());

      if(Objects.isNull(child.getId())) {
        NobleEntity nobleEntity  = nobleRepository.save(mapper.dtoToEntity(child));
        child.setId(nobleEntity.getId());
      } else {
        nobleRepository.save(mapper.dtoToEntity(child));
      }

      walkOnTheTree(child);
    }
  }

  private Noble createFamilyTree(List<Noble> nobles) {
    Noble root = determineRoot(nobles);
    recursiveBuilder(root, excludeParent(nobles, root));

    return root;
  }

  private void recursiveBuilder(Noble parent, List<Noble> children) {
    for(Noble noble: children) {
      if(parent.getId() == noble.getParentId()) {
        parent.addChildren(noble);
      }
      recursiveBuilder(noble, excludeParent(children, noble));
    }
  }

  private List<Noble> excludeParent(List<Noble> children, Noble parent) {
    return children.stream().filter(noble -> noble.getId() != parent.getId()).collect(Collectors.toList());
  }

  private Noble determineRoot(List<Noble> nobles) {
    return nobles.stream().filter(noble -> Objects.isNull(noble.getParentId())).findFirst().get();
  }

}
