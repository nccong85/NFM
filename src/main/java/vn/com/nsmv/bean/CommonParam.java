package vn.com.nsmv.bean;

public class CommonParam {
  private String seizoshoKbn = "";
  private String sojoNoShukkoBasho = "";
  private String sojoNoTorihikiShubetsu = "";
  private String sojoNoOban = "";
  private Integer sojoNoRenban = 0;
  private Integer binCounter = 0;

  public String getSeizoshoKbn() {
    return seizoshoKbn;
  }

  public void setSeizoshoKbn(String seizoshoKbn) {
    this.seizoshoKbn = seizoshoKbn;
  }

  public String getSojoNoShukkoBasho() {
    return sojoNoShukkoBasho;
  }

  public void setSojoNoShukkoBasho(String sojoNoShukkoBasho) {
    this.sojoNoShukkoBasho = sojoNoShukkoBasho;
  }

  public String getSojoNoTorihikiShubetsu() {
    return sojoNoTorihikiShubetsu;
  }

  public void setSojoNoTorihikiShubetsu(String sojoNoTorihikiShubetsu) {
    this.sojoNoTorihikiShubetsu = sojoNoTorihikiShubetsu;
  }

  public String getSojoNoOban() {
    return sojoNoOban;
  }

  public void setSojoNoOban(String sojoNoOban) {
    this.sojoNoOban = sojoNoOban;
  }

  public Integer getSojoNoRenban() {
    return sojoNoRenban;
  }

  public void setSojoNoRenban(Integer sojoNoRenban) {
    this.sojoNoRenban = sojoNoRenban;
  }

  public Integer getBinCounter() {
    return binCounter;
  }

  public void setBinCounter(Integer binCounter) {
    this.binCounter = binCounter;
  }
  
}
