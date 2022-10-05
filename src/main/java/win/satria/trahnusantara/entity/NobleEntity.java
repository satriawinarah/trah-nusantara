package win.satria.trahnusantara.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "noble")
@Data
public class NobleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;
  private String alias;
  private Integer parentId;
  private Integer dateStart;
  private Integer dateEnd;
  private String description;
  private Integer kingdomId;
  private Date createdDate;
  private Date updatedDate;

}
