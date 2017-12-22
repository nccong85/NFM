package vn.com.nsmv.bean;

import java.util.ArrayList;
import java.util.List;

public class NFMYGX0100_SearchResultBean {

  private String keisanStatus = "";

  // 製造所区分
  private String seizoshoKbn = "";
  // 送状番号-出庫場所
  private String sojonoShukkoBasho = "";
  // 送状番号-取引種別
  private String sojonoTorihikiShubetsu = "";
  // 送状番号-追番
  private String sojonoOban = "";
  // 送状番号-連番
  private String sojonoRenban = "";
  // 出荷年月日
  private String shukkaDate = "";
  // 請求年月
  private String seikyuNengetsu = "";
  // 便コード
  private String bincd = "";
  // 出庫場所
  private String shukkoBasho = "";
  // 受渡場所
  private String ukewatashiBasho = "";

  private String gyoshaCd = "";

  // 積合コード
  private String tsumiaicd = "";
  // 台数
  private String daisu = "";
  // 重量
  private String juryo = "";
  // HEAD-訂正区分
  private String headTeiseiKbn = "";
  // HEAD-訂正回数
  private String headTeiseiKaisu = "";
  // 送状費目データCOリスト
  private List<NFMYGX0100_HimokuBean> sojoHimokuDataCOList = new ArrayList<NFMYGX0100_HimokuBean>();

  public List<NFMYGX0100_HimokuBean> getSojoHimokuDataCOList() {
    return sojoHimokuDataCOList;
  }

  public void setSojoHimokuDataCOList(List<NFMYGX0100_HimokuBean> sojoHimokuDataCOList) {
    this.sojoHimokuDataCOList = sojoHimokuDataCOList;
  }

  public String getKeisanStatus() {
    return keisanStatus;
  }

  public void setKeisanStatus(String keisanStatus) {
    this.keisanStatus = keisanStatus;
  }

  // 備考
  private String biko = "";
  // グレーフラグ
  private String greyFlag = "";

  /**
   * headTeiseiKbnの取得
   * 
   * @return 文字
   */
  public String getHeadTeiseiKbn() {
    return headTeiseiKbn;
  }

  /**
   * headTeiseiKbnの設定
   * 
   * @param headTeiseiKbn
   *          セットする headTeiseiKbn
   */
  public void setHeadTeiseiKbn(String headTeiseiKbn) {
    this.headTeiseiKbn = headTeiseiKbn;
  }

  /**
   * headTeiseiKaisuの取得
   * 
   * @return 文字
   */
  public String getHeadTeiseiKaisu() {
    return headTeiseiKaisu;
  }

  /**
   * headTeiseiKaisuの設定
   * 
   * @param headTeiseiKaisu
   *          セットする headTeiseiKaisu
   */
  public void setHeadTeiseiKaisu(String headTeiseiKaisu) {
    this.headTeiseiKaisu = headTeiseiKaisu;
  }

  /**
   * seizoshoKbnの取得
   * 
   * @return 文字
   */
  public String getSeizoshoKbn() {
    return seizoshoKbn;
  }

  /**
   * seizoshoKbnの設定
   * 
   * @param seizoshoKbn
   *          セットする seizoshoKbn
   */
  public void setSeizoshoKbn(String seizoshoKbn) {
    this.seizoshoKbn = seizoshoKbn;
  }

  /**
   * sojonoShukkoBashoの取得
   * 
   * @return 文字
   */
  public String getSojonoShukkoBasho() {
    return sojonoShukkoBasho;
  }

  /**
   * sojonoShukkoBashoの設定
   * 
   * @param sojonoShukkoBasho
   *          セットする sojonoShukkoBasho
   */
  public void setSojonoShukkoBasho(String sojonoShukkoBasho) {
    this.sojonoShukkoBasho = sojonoShukkoBasho;
  }

  /**
   * sojonoTorihikiShubetsuの取得
   * 
   * @return 文字
   */
  public String getSojonoTorihikiShubetsu() {
    return sojonoTorihikiShubetsu;
  }

  /**
   * sojonoTorihikiShubetsuの設定
   * 
   * @param sojonoTorihikiShubetsu
   *          セットする sojonoTorihikiShubetsu
   */
  public void setSojonoTorihikiShubetsu(String sojonoTorihikiShubetsu) {
    this.sojonoTorihikiShubetsu = sojonoTorihikiShubetsu;
  }

  /**
   * sojonoObanの取得
   * 
   * @return 文字
   */
  public String getSojonoOban() {
    return sojonoOban;
  }

  /**
   * sojonoObanの設定
   * 
   * @param sojonoOban
   *          セットする sojonoOban
   */
  public void setSojonoOban(String sojonoOban) {
    this.sojonoOban = sojonoOban;
  }

  
  
  public String getSojonoRenban() {
    return sojonoRenban;
  }

  public void setSojonoRenban(String sojonoRenban) {
    this.sojonoRenban = sojonoRenban;
  }

  /**
   * shukkaDateの取得
   * 
   * @return 文字
   */
  public String getShukkaDate() {
    return shukkaDate;
  }

  /**
   * shukkaDateの設定
   * 
   * @param shukkaDate
   *          セットする shukkaDate
   */
  public void setShukkaDate(String shukkaDate) {
    this.shukkaDate = shukkaDate;
  }

  /**
   * seikyuNengetsuの取得
   * 
   * @return 文字
   */
  public String getSeikyuNengetsu() {
    return seikyuNengetsu;
  }

  /**
   * seikyuNengetsuの設定
   * 
   * @param seikyuNengetsu
   *          セットする seikyuNengetsu
   */
  public void setSeikyuNengetsu(String seikyuNengetsu) {
    this.seikyuNengetsu = seikyuNengetsu;
  }

  /**
   * bincdの取得
   * 
   * @return 文字
   */
  public String getBincd() {
    return bincd;
  }

  /**
   * bincdの設定
   * 
   * @param bincd
   *          セットする bincd
   */
  public void setBincd(String bincd) {
    this.bincd = bincd;
  }

  /**
   * shukkoBashoの取得
   * 
   * @return 文字
   */
  public String getShukkoBasho() {
    return shukkoBasho;
  }

  /**
   * shukkoBashoの設定
   * 
   * @param shukkoBasho
   *          セットする shukkoBasho
   */
  public void setShukkoBasho(String shukkoBasho) {
    this.shukkoBasho = shukkoBasho;
  }

  /**
   * ukewatashiBashoの取得
   * 
   * @return 文字
   */
  public String getUkewatashiBasho() {
    return ukewatashiBasho;
  }

  /**
   * ukewatashiBashoの設定
   * 
   * @param ukewatashiBasho
   *          セットする ukewatashiBasho
   */
  public void setUkewatashiBasho(String ukewatashiBasho) {
    this.ukewatashiBasho = ukewatashiBasho;
  }

  public String getGyoshaCd() {
    return gyoshaCd;
  }

  public void setGyoshaCd(String gyoshaCd) {
    this.gyoshaCd = gyoshaCd;
  }

  /**
   * tsumiaicdの取得
   * 
   * @return 文字
   */
  public String getTsumiaicd() {
    return tsumiaicd;
  }

  /**
   * tsumiaicdの設定
   * 
   * @param tsumiaicd
   *          セットする tsumiaicd
   */
  public void setTsumiaicd(String tsumiaicd) {
    this.tsumiaicd = tsumiaicd;
  }

  /**
   * daisuの取得
   * 
   * @return 文字
   */
  public String getDaisu() {
    return daisu;
  }

  /**
   * daisuの設定
   * 
   * @param daisu
   *          セットする daisu
   */
  public void setDaisu(String daisu) {
    this.daisu = daisu;
  }

  /**
   * juryoの取得
   * 
   * @return 文字
   */
  public String getJuryo() {
    return juryo;
  }

  /**
   * juryoの設定
   * 
   * @param juryo
   *          セットする juryo
   */
  public void setJuryo(String juryo) {
    this.juryo = juryo;
  }

  /**
   * bikoの取得
   * 
   * @return 文字
   */
  public String getBiko() {
    return biko;
  }

  /**
   * bikoの設定
   * 
   * @param biko
   *          セットする biko
   */
  public void setBiko(String biko) {
    this.biko = biko;
  }

  /**
   * greyFlagの取得
   * 
   * @return 文字
   */
  public String getGreyFlag() {
    return greyFlag;
  }

  /**
   * greyFlagの設定
   * 
   * @param greyFlag
   *          セットする greyFlag
   */
  public void setGreyFlag(String greyFlag) {
    this.greyFlag = greyFlag;
  }
}
