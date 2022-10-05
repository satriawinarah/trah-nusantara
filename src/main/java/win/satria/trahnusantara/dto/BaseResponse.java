package win.satria.trahnusantara.dto;

import lombok.Builder;
import lombok.Data;
import win.satria.trahnusantara.constant.ErrorConstant;

import java.util.Objects;

@Data
@Builder
public class BaseResponse {

  private int status;
  private String statusMessage;
  private Object body;

  public static BaseResponse ok() {
    return BaseResponse.builder()
      .status(ErrorConstant.SUCCESS)
      .statusMessage(ErrorConstant.SUCCESS_MSG)
      .body(null)
      .build();
  }

  public static BaseResponse ok(Object body) {
    if(Objects.isNull(body)) {
      return BaseResponse.builder()
        .status(ErrorConstant.NOT_FOUND)
        .statusMessage(ErrorConstant.CONTENT_NOT_FOUND_MSG)
        .body(null)
        .build();
    }
    return BaseResponse.builder()
      .status(ErrorConstant.SUCCESS)
      .statusMessage(ErrorConstant.SUCCESS_MSG)
      .body(body)
      .build();
  }

}
