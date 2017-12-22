package vn.com.nsmv.bean;


/**
 * Search condition bean
 * @author cong85
 *
 */
public class NFMYCX0010_YusoTranSearchBean {
  private String seizoshoKbn = "";
  private String targetYear = "";
  private String targetMonth = "";
  private String gyoushaCd = "";
  
  
  /**
   * @return
   */
  public String getSeizoshoKbn() {
    return seizoshoKbn;
  }
  
  
  /**
   * @param seizoshoKbn
   */
  public void setSeizoshoKbn(String seizoshoKbn) {
    this.seizoshoKbn = seizoshoKbn;
  }
  
  /**
   * @return
   */
  public String getTargetYear() {
    return targetYear;
  }
  
  /**
   * @param targetYear
   */
  public void setTargetYear(String targetYear) {
    this.targetYear = targetYear;
  }
  
  /**
   * @return
   */
  public String getTargetMonth() {
    return targetMonth;
  }
  
  /**
   * @param targetMonth
   */
  public void setTargetMonth(String targetMonth) {
    this.targetMonth = targetMonth;
  }
  
  /**
   * @return
   */
  public String getGyoushaCd() {
    return gyoushaCd;
  }
  
  /**
   * @param gyoushaCd
   */
  public void setGyoushaCd(String gyoushaCd) {
    this.gyoushaCd = gyoushaCd;
  }
}
