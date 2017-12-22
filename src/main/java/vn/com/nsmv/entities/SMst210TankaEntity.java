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
@Table(name = "s_mst_210_tanka")
@IdClass(Mst210Tanka_Pk.class)
public class SMst210TankaEntity {

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

  @Column(name = "tbl_shikibetsu1")
  private String tbl_shikibetsu1;

  @Column(name = "tanka_tani1")
  private String tanka_tani1;

  @Column(name = "tekiyo_ritsu1")
  private double tekiyo_ritsu1;

  @Column(name = "tbl_shikibetsu2")
  private String tbl_shikibetsu2;

  @Column(name = "tanka_tani2")
  private String tanka_tani2;

  @Column(name = "tekiyo_ritsu2")
  private double tekiyo_ritsu2;

  @Column(name = "tbl_shikibetsu3")
  private String tbl_shikibetsu3;

  @Column(name = "tanka_tani3")
  private String tanka_tani3;

  @Column(name = "tekiyo_ritsu3")
  private double tekiyo_ritsu3;

  @Column(name = "tbl_shikibetsu4")
  private String tbl_shikibetsu4;

  @Column(name = "tanka_tani4")
  private String tanka_tani4;

  @Column(name = "tekiyo_ritsu4")
  private double tekiyo_ritsu4;

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

  public String getTbl_shikibetsu1() {
    return tbl_shikibetsu1;
  }

  public void setTbl_shikibetsu1(String tbl_shikibetsu1) {
    this.tbl_shikibetsu1 = tbl_shikibetsu1;
  }

  public String getTanka_tani1() {
    return tanka_tani1;
  }

  public void setTanka_tani1(String tanka_tani1) {
    this.tanka_tani1 = tanka_tani1;
  }

  public double getTekiyo_ritsu1() {
    return tekiyo_ritsu1;
  }

  public void setTekiyo_ritsu1(double tekiyo_ritsu1) {
    this.tekiyo_ritsu1 = tekiyo_ritsu1;
  }

  public String getTbl_shikibetsu2() {
    return tbl_shikibetsu2;
  }

  public void setTbl_shikibetsu2(String tbl_shikibetsu2) {
    this.tbl_shikibetsu2 = tbl_shikibetsu2;
  }

  public String getTanka_tani2() {
    return tanka_tani2;
  }

  public void setTanka_tani2(String tanka_tani2) {
    this.tanka_tani2 = tanka_tani2;
  }

  public double getTekiyo_ritsu2() {
    return tekiyo_ritsu2;
  }

  public void setTekiyo_ritsu2(double tekiyo_ritsu2) {
    this.tekiyo_ritsu2 = tekiyo_ritsu2;
  }

  public String getTbl_shikibetsu3() {
    return tbl_shikibetsu3;
  }

  public void setTbl_shikibetsu3(String tbl_shikibetsu3) {
    this.tbl_shikibetsu3 = tbl_shikibetsu3;
  }

  public String getTanka_tani3() {
    return tanka_tani3;
  }

  public void setTanka_tani3(String tanka_tani3) {
    this.tanka_tani3 = tanka_tani3;
  }

  public double getTekiyo_ritsu3() {
    return tekiyo_ritsu3;
  }

  public void setTekiyo_ritsu3(double tekiyo_ritsu3) {
    this.tekiyo_ritsu3 = tekiyo_ritsu3;
  }

  public String getTbl_shikibetsu4() {
    return tbl_shikibetsu4;
  }

  public void setTbl_shikibetsu4(String tbl_shikibetsu4) {
    this.tbl_shikibetsu4 = tbl_shikibetsu4;
  }

  public String getTanka_tani4() {
    return tanka_tani4;
  }

  public void setTanka_tani4(String tanka_tani4) {
    this.tanka_tani4 = tanka_tani4;
  }

  public double getTekiyo_ritsu4() {
    return tekiyo_ritsu4;
  }

  public void setTekiyo_ritsu4(double tekiyo_ritsu4) {
    this.tekiyo_ritsu4 = tekiyo_ritsu4;
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
class Mst210Tanka_Pk implements Serializable {

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
