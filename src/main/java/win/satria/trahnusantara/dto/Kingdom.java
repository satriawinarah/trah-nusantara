package win.satria.trahnusantara.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class Kingdom {

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private int id;

  private String name;
  private int yearStart;
  private int yearEnd;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Date createdDate;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Date updatedDate;

}
