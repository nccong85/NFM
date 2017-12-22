package vn.com.nsmv.bean;

public class NFMYGX0100_HimokuBean {

  // 費目コード
  private String himokucd;
  // 業者コード
  private String gyoshacd;
  // 単価単位
  private String tankaTani;
  // 新単価
  private String tanka;
  // 新金額
  private String kingaku;

  
  public NFMYGX0100_HimokuBean(String inHimokucd, String inTankaTani,
      String inTanka, String inKingaku) {
    this.himokucd = inHimokucd;
    this.tankaTani = inTankaTani;
    this.tanka = inTanka;
    this.kingaku = inKingaku;
  }

  public String getHimokucd() {
    return himokucd;
  }

  public void setHimokucd(String himokucd) {
    this.himokucd = himokucd;
  }

  public String getGyoshacd() {
    return gyoshacd;
  }

  public void setGyoshacd(String gyoshacd) {
    this.gyoshacd = gyoshacd;
  }

  public String getTankaTani() {
    return tankaTani;
  }

  public void setTankaTani(String tankaTani) {
    this.tankaTani = tankaTani;
  }

  public String getTanka() {
    return tanka;
  }

  public void setTanka(String tanka) {
    this.tanka = tanka;
  }

  public String getKingaku() {
    return kingaku;
  }

  public void setKingaku(String kingaku) {
    this.kingaku = kingaku;
  }
}
