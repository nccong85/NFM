package vn.com.nsmv.bean;

public class NFMYCX0010_YusoMasterBean {

  private String seizoshoKbn = "";
  private String sojonoShukkoBasho = "";
  private String sojonoTorihikiShubetsu = "";
  private String sojonoOban = "";
  private int sojonoRenban = 0;
  private String himokuCd = "";
  private NFMYCX0010_YusoMasterHeadBean yusoMasterHeadBean = null;
  private NFMYCX0010_YusoMasterBodyBean yusoMasterBodyBean = null;

  public String getSeizoshoKbn() {
    return seizoshoKbn;
  }

  public void setSeizoshoKbn(String seizoshoKbn) {
    this.seizoshoKbn = seizoshoKbn;
  }

  public String getSojonoShukkoBasho() {
    return sojonoShukkoBasho;
  }

  public void setSojonoShukkoBasho(String sojonoShukkoBasho) {
    this.sojonoShukkoBasho = sojonoShukkoBasho;
  }

  public String getSojonoTorihikiShubetsu() {
    return sojonoTorihikiShubetsu;
  }

  public void setSojonoTorihikiShubetsu(String sojonoTorihikiShubetsu) {
    this.sojonoTorihikiShubetsu = sojonoTorihikiShubetsu;
  }

  public String getSojonoOban() {
    return sojonoOban;
  }

  public void setSojonoOban(String sojonoOban) {
    this.sojonoOban = sojonoOban;
  }

  public int getSojonoRenban() {
    return sojonoRenban;
  }

  public void setSojonoRenban(int sojonoRenban) {
    this.sojonoRenban = sojonoRenban;
  }

  public String getHimokuCd() {
    return himokuCd;
  }

  public void setHimokuCd(String himokucd) {
    this.himokuCd = himokucd;
  }

  public NFMYCX0010_YusoMasterHeadBean getYusoMasterHeadBean() {
    return yusoMasterHeadBean;
  }

  public void setYusoMasterHeadBean(NFMYCX0010_YusoMasterHeadBean yusoMasterHeadBean) {
    this.yusoMasterHeadBean = yusoMasterHeadBean;
  }

  public NFMYCX0010_YusoMasterBodyBean getYusoMasterBodyBean() {
    return yusoMasterBodyBean;
  }

  public void setYusoMasterBodyBean(NFMYCX0010_YusoMasterBodyBean yusoMasterBodyBean) {
    this.yusoMasterBodyBean = yusoMasterBodyBean;
  }
}
