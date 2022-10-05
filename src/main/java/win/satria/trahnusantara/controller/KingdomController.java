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
import win.satria.trahnusantara.dto.Kingdom;
import win.satria.trahnusantara.service.KingdomService;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/kingdoms")
public class KingdomController {

  @Autowired
  private KingdomService kingdomService;

  @GetMapping
  public BaseResponse getAllKingdoms() {
    return BaseResponse.ok(kingdomService.getAllKingdom());
  }

  @GetMapping("/{id}")
  public BaseResponse getKingdomById(@PathVariable(value="id") Integer id) {
    return BaseResponse.ok(kingdomService.getKingdomById(id));
  }

  @PostMapping
  public BaseResponse bulkAddKingdom(@RequestBody @Validated List<Kingdom> kingdoms) {
    return BaseResponse.ok(kingdomService.bulkAddKingdom(kingdoms));
  }

}
