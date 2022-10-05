package win.satria.trahnusantara.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Builder
public class Noble {

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Integer id;

  private String name;
  private String alias;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Integer parentId;

  private Integer dateStart;
  private Integer dateEnd;
  private String description;
  private Integer kingdomId;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Date createdDate;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Date updatedDate;

  private List<Noble> children = new ArrayList<>();

  public void addChildren(Noble noble) {
    if(Objects.isNull(children)) {
      children = new ArrayList<>();
    }
    children.add(noble);
  }

}
