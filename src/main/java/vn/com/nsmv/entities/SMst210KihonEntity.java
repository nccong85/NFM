package vn.com.nsmv.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "s_mst_210_kihon")
@IdClass(Mst210Kihon_Pk.class)
public class SMst210KihonEntity {
  @EmbeddedId
  private String seizosho_kbn;

  @EmbeddedId
  private String shukko_basho;

  @EmbeddedId
  private String gyoshacd;

  @EmbeddedId
  private String bincd;

  @EmbeddedId
  private String himokucd;

  @Column(name = "teikiyo_patan")
  private String teikiyo_patan;

  @Column(name = "kinen_kbn")
  private String kinen_kbn;

  @Column(name = "kyor_tbl_sikibetsu")
  private String kyor_tbl_sikibetsu;

  @Column(name = "base_kbn")
  private String base_kbn;

  @Column(name = "chojaku_tanka_tani")
  private String chojaku_tanka_tani;

  @Column(name = "chojaku_ritsu1")
  private Integer chojaku_ritsu1;

  @Column(name = "chojaku_ritsu2")
  private Integer chojaku_ritsu2;

  @Column(name = "hinshu_tanka_tani")
  private String hinshu_tanka_tani;

  @Column(name = "hinshu_ritsu")
  private Integer hinshu_ritsu;

  @Column(name = "jikankai_tanka_tani")
  private String jikankai_tanka_tani;

  @Column(name = "jikankai_ritsu")
  private Integer jikankai_ritsu;

  @Column(name = "kyujitsu_tanka_tani")
  private String kyujitsu_tanka_tani;

  @Column(name = "kyujitsu_ritsu")
  private Integer kyujitsu_ritsu;

  @Column(name = "toki_tanka_tani")
  private String toki_tanka_tani;

  @Column(name = "toki_ritsu")
  private Integer toki_ritsu;

  @Column(name = "subkey1")
  private String subkey1;

  @Column(name = "subkey2")
  private String subkey2;

  @Column(name = "subkey3")
  private String subkey3;

  @Column(name = "subkey4")
  private String subkey4;

  @Column(name = "subkey5")
  private String subkey5;

  @Column(name = "subkey6")
  private String subkey6;

  @Column(name = "subkey7")
  private String subkey7;

  @Column(name = "subkey8")
  private String subkey8;

  @Column(name = "subkey9")
  private String subkey9;

  @Column(name = "subkey10")
  private String subkey10;

  @Column(name = "subkey11")
  private String subkey11;

  @Column(name = "kbn_kyor1")
  private Integer kbn_kyor1;

  @Column(name = "kbn_kyor2")
  private Integer kbn_kyor2;

  @Column(name = "sonota_kuton_ritsu1")
  private Integer sonota_kuton_ritsu1;

  @Column(name = "sonota_kuton_ritsu2")
  private Integer sonota_kuton_ritsu2;

  @Column(name = "sonota_kuton_ritsu3")
  private Integer sonota_kuton_ritsu3;

  @Column(name = "torokusha")
  private String torokusha;

  @Column(name = "toroku_date", nullable = true)
  private Date torokuDate;

  @Column(name = "koshinsha", nullable = true)
  private String koshinsha;

  @Column(name = "koshin_date", nullable = true)
  private Date koshinDate;

  @Column(name = "time_stamp", nullable = true)
  private Date timeStamp;

  public String getSeizosho_kbn() {
    return seizosho_kbn;
  }

  public void setSeizosho_kbn(String seizosho_kbn) {
    this.seizosho_kbn = seizosho_kbn;
  }

  public String getShukko_basho() {
    return shukko_basho;
  }

  public void setShukko_basho(String shukko_basho) {
    this.shukko_basho = shukko_basho;
  }

  public String getGyoshacd() {
    return gyoshacd;
  }

  public void setGyoshacd(String gyoshacd) {
    this.gyoshacd = gyoshacd;
  }

  public String getBincd() {
    return bincd;
  }

  public void setBincd(String bincd) {
    this.bincd = bincd;
  }

  public String getHimokucd() {
    return himokucd;
  }

  public void setHimokucd(String himokucd) {
    this.himokucd = himokucd;
  }

  public String getTeikiyo_patan() {
    return teikiyo_patan;
  }

  public void setTeikiyo_patan(String teikiyo_patan) {
    this.teikiyo_patan = teikiyo_patan;
  }

  public String getKinen_kbn() {
    return kinen_kbn;
  }

  public void setKinen_kbn(String kinen_kbn) {
    this.kinen_kbn = kinen_kbn;
  }

  public String getKyor_tbl_sikibetsu() {
    return kyor_tbl_sikibetsu;
  }

  public void setKyor_tbl_sikibetsu(String kyor_tbl_sikibetsu) {
    this.kyor_tbl_sikibetsu = kyor_tbl_sikibetsu;
  }

  public String getBase_kbn() {
    return base_kbn;
  }

  public void setBase_kbn(String base_kbn) {
    this.base_kbn = base_kbn;
  }

  public String getChojaku_tanka_tani() {
    return chojaku_tanka_tani;
  }

  public void setChojaku_tanka_tani(String chojaku_tanka_tani) {
    this.chojaku_tanka_tani = chojaku_tanka_tani;
  }

  public Integer getChojaku_ritsu1() {
    return chojaku_ritsu1;
  }

  public void setChojaku_ritsu1(Integer chojaku_ritsu1) {
    this.chojaku_ritsu1 = chojaku_ritsu1;
  }

  public Integer getChojaku_ritsu2() {
    return chojaku_ritsu2;
  }

  public void setChojaku_ritsu2(Integer chojaku_ritsu2) {
    this.chojaku_ritsu2 = chojaku_ritsu2;
  }

  public String getHinshu_tanka_tani() {
    return hinshu_tanka_tani;
  }

  public void setHinshu_tanka_tani(String hinshu_tanka_tani) {
    this.hinshu_tanka_tani = hinshu_tanka_tani;
  }

  public Integer getHinshu_ritsu() {
    return hinshu_ritsu;
  }

  public void setHinshu_ritsu(Integer hinshu_ritsu) {
    this.hinshu_ritsu = hinshu_ritsu;
  }

  public String getJikankai_tanka_tani() {
    return jikankai_tanka_tani;
  }

  public void setJikankai_tanka_tani(String jikankai_tanka_tani) {
    this.jikankai_tanka_tani = jikankai_tanka_tani;
  }

  public Integer getJikankai_ritsu() {
    return jikankai_ritsu;
  }

  public void setJikankai_ritsu(Integer jikankai_ritsu) {
    this.jikankai_ritsu = jikankai_ritsu;
  }

  public String getKyujitsu_tanka_tani() {
    return kyujitsu_tanka_tani;
  }

  public void setKyujitsu_tanka_tani(String kyujitsu_tanka_tani) {
    this.kyujitsu_tanka_tani = kyujitsu_tanka_tani;
  }

  public Integer getKyujitsu_ritsu() {
    return kyujitsu_ritsu;
  }

  public void setKyujitsu_ritsu(Integer kyujitsu_ritsu) {
    this.kyujitsu_ritsu = kyujitsu_ritsu;
  }

  public String getToki_tanka_tani() {
    return toki_tanka_tani;
  }

  public void setToki_tanka_tani(String toki_tanka_tani) {
    this.toki_tanka_tani = toki_tanka_tani;
  }

  public Integer getToki_ritsu() {
    return toki_ritsu;
  }

  public void setToki_ritsu(Integer toki_ritsu) {
    this.toki_ritsu = toki_ritsu;
  }

  public String getSubkey1() {
    return subkey1;
  }

  public void setSubkey1(String subkey1) {
    this.subkey1 = subkey1;
  }

  public String getSubkey2() {
    return subkey2;
  }

  public void setSubkey2(String subkey2) {
    this.subkey2 = subkey2;
  }

  public String getSubkey3() {
    return subkey3;
  }

  public void setSubkey3(String subkey3) {
    this.subkey3 = subkey3;
  }

  public String getSubkey4() {
    return subkey4;
  }

  public void setSubkey4(String subkey4) {
    this.subkey4 = subkey4;
  }

  public String getSubkey5() {
    return subkey5;
  }

  public void setSubkey5(String subkey5) {
    this.subkey5 = subkey5;
  }

  public String getSubkey6() {
    return subkey6;
  }

  public void setSubkey6(String subkey6) {
    this.subkey6 = subkey6;
  }

  public String getSubkey7() {
    return subkey7;
  }

  public void setSubkey7(String subkey7) {
    this.subkey7 = subkey7;
  }

  public String getSubkey8() {
    return subkey8;
  }

  public void setSubkey8(String subkey8) {
    this.subkey8 = subkey8;
  }

  public String getSubkey9() {
    return subkey9;
  }

  public void setSubkey9(String subkey9) {
    this.subkey9 = subkey9;
  }

  public String getSubkey10() {
    return subkey10;
  }

  public void setSubkey10(String subkey10) {
    this.subkey10 = subkey10;
  }

  public String getSubkey11() {
    return subkey11;
  }

  public void setSubkey11(String subkey11) {
    this.subkey11 = subkey11;
  }

  public Integer getKbn_kyor1() {
    return kbn_kyor1;
  }

  public void setKbn_kyor1(Integer kbn_kyor1) {
    this.kbn_kyor1 = kbn_kyor1;
  }

  public Integer getKbn_kyor2() {
    return kbn_kyor2;
  }

  public void setKbn_kyor2(Integer kbn_kyor2) {
    this.kbn_kyor2 = kbn_kyor2;
  }

  public Integer getSonota_kuton_ritsu1() {
    return sonota_kuton_ritsu1;
  }

  public void setSonota_kuton_ritsu1(Integer sonota_kuton_ritsu1) {
    this.sonota_kuton_ritsu1 = sonota_kuton_ritsu1;
  }

  public Integer getSonota_kuton_ritsu2() {
    return sonota_kuton_ritsu2;
  }

  public void setSonota_kuton_ritsu2(Integer sonota_kuton_ritsu2) {
    this.sonota_kuton_ritsu2 = sonota_kuton_ritsu2;
  }

  public Integer getSonota_kuton_ritsu3() {
    return sonota_kuton_ritsu3;
  }

  public void setSonota_kuton_ritsu3(Integer sonota_kuton_ritsu3) {
    this.sonota_kuton_ritsu3 = sonota_kuton_ritsu3;
  }

  public String getTorokusha() {
    return torokusha;
  }

  public void setTorokusha(String torokusha) {
    this.torokusha = torokusha;
  }

  public Date getTorokuDate() {
    return torokuDate;
  }

  public void setTorokuDate(Date torokuDate) {
    this.torokuDate = torokuDate;
  }

  public String getKoshinsha() {
    return koshinsha;
  }

  public void setKoshinsha(String koshinsha) {
    this.koshinsha = koshinsha;
  }

  public Date getKoshinDate() {
    return koshinDate;
  }

  public void setKoshinDate(Date koshinDate) {
    this.koshinDate = koshinDate;
  }

  public Date getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Date timeStamp) {
    this.timeStamp = timeStamp;
  }
}

@Embeddable
class Mst210Kihon_Pk implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "seizosho_kbn")
  private String seizosho_kbn;

  @Column(name = "shukko_basho")
  private String shukko_basho;

  @Column(name = "gyoshacd")
  private String gyoshacd;
  
  @Column(name = "bincd")
  private String bincd;
  
  @Column(name = "himokucd")
  private String himokucd;
}