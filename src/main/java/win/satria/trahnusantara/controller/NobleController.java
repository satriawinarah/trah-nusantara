package win.satria.trahnusantara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.satria.trahnusantara.dto.BaseResponse;
import win.satria.trahnusantara.dto.Noble;
import win.satria.trahnusantara.service.NobleService;

@RestController
@RequestMapping("/v1/nobles")
public class NobleController {

  @Autowired
  private NobleService nobleService;

  @GetMapping("/{kingdomId}")
  public BaseResponse getFamilyTreeByParentId(@PathVariable(value="kingdomId") Integer kingdomId) {
    return BaseResponse.ok(nobleService.getNobleFamilyTreeByKingdomId(kingdomId));
  }

  @PostMapping
  public BaseResponse bulkAddNobles(@RequestBody @Validated Noble noble) {
    return BaseResponse.ok(nobleService.bulkAddNoblePerFamily(noble));
  }

}
