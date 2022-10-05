package win.satria.trahnusantara.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "kingdom")
@Data
public class KingdomEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(unique=true)
  private String name;
  private int yearStart;
  private int yearEnd;
  private Date createdDate;
  private Date updatedDate;

  public KingdomEntity() {

  }

}
