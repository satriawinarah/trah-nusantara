package win.satria.trahnusantara.util;

import java.sql.Date;

public class DateUtil {

  public static Date dateNow() {
    return new Date(new java.util.Date().getTime());
  }

}
