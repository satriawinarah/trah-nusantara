package win.satria.trahnusantara.service;

import win.satria.trahnusantara.dto.Noble;

public interface NobleService {

  Noble getNobleFamilyTreeByKingdomId(Integer rootParentId);

  Noble bulkAddNoblePerFamily(Noble noble);

}
