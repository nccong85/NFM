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
@Table(name = "s_mst_n11")
@IdClass(MstN11_Pk.class)
public class SMstN11Entity {
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

  @EmbeddedId
  private String tsumikomi_minato;

  @EmbeddedId
  private String age_minato;

  @EmbeddedId
  private String tranship_tsumikomi_minato;

  @EmbeddedId
  private String ukewatashi_basho;

  @EmbeddedId
  private String chukei_kbn;

  @EmbeddedId
  private String hamakbn;

  @EmbeddedId
  private String mochikomi_cd;

  @EmbeddedId
  private String sub_cd;

  @EmbeddedId
  private String tumikomi_kbn;

  @EmbeddedId
  private String karioki_kbn;

  @EmbeddedId
  private String bt_kbn;

  @EmbeddedId
  private String hinshu;

  @Column(name = "tanka_tani")
  private String tanka_tani;

  @Column(name = "tanka")
  private Integer tanka;

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

  public String getTsumikomi_minato() {
    return tsumikomi_minato;
  }

  public void setTsumikomi_minato(String tsumikomi_minato) {
    this.tsumikomi_minato = tsumikomi_minato;
  }

  public String getAge_minato() {
    return age_minato;
  }

  public void setAge_minato(String age_minato) {
    this.age_minato = age_minato;
  }

  public String getTranship_tsumikomi_minato() {
    return tranship_tsumikomi_minato;
  }

  public void setTranship_tsumikomi_minato(String tranship_tsumikomi_minato) {
    this.tranship_tsumikomi_minato = tranship_tsumikomi_minato;
  }

  public String getUkewatashi_basho() {
    return ukewatashi_basho;
  }

  public void setUkewatashi_basho(String ukewatashi_basho) {
    this.ukewatashi_basho = ukewatashi_basho;
  }

  public String getChukei_kbn() {
    return chukei_kbn;
  }

  public void setChukei_kbn(String chukei_kbn) {
    this.chukei_kbn = chukei_kbn;
  }

  public String getHamakbn() {
    return hamakbn;
  }

  public void setHamakbn(String hamakbn) {
    this.hamakbn = hamakbn;
  }

  public String getMochikomi_cd() {
    return mochikomi_cd;
  }

  public void setMochikomi_cd(String mochikomi_cd) {
    this.mochikomi_cd = mochikomi_cd;
  }

  public String getSub_cd() {
    return sub_cd;
  }

  public void setSub_cd(String sub_cd) {
    this.sub_cd = sub_cd;
  }

  public String getTumikomi_kbn() {
    return tumikomi_kbn;
  }

  public void setTumikomi_kbn(String tumikomi_kbn) {
    this.tumikomi_kbn = tumikomi_kbn;
  }

  public String getKarioki_kbn() {
    return karioki_kbn;
  }

  public void setKarioki_kbn(String karioki_kbn) {
    this.karioki_kbn = karioki_kbn;
  }

  public String getBt_kbn() {
    return bt_kbn;
  }

  public void setBt_kbn(String bt_kbn) {
    this.bt_kbn = bt_kbn;
  }

  public String getHinshu() {
    return hinshu;
  }

  public void setHinshu(String hinshu) {
    this.hinshu = hinshu;
  }

  public String getTanka_tani() {
    return tanka_tani;
  }

  public void setTanka_tani(String tanka_tani) {
    this.tanka_tani = tanka_tani;
  }

  public Integer getTanka() {
    return tanka;
  }

  public void setTanka(Integer tanka) {
    this.tanka = tanka;
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
class MstN11_Pk implements Serializable {

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
  
  @Column(name = "tsumikomi_minato")
  private String tsumikomi_minato;
  
  @Column(name = "age_minato")
  private String age_minato;
  
  @Column(name = "tranship_tsumikomi_minato")
  private String tranship_tsumikomi_minato;
  
  @Column(name = "ukewatashi_basho")
  private String ukewatashi_basho;
  
  @Column(name = "chukei_kbn")
  private String chukei_kbn;
  
  @Column(name = "hamakbn")
  private String hamakbn;
  
  @Column(name = "mochikomi_cd")
  private String mochikomi_cd;
  
  @Column(name = "sub_cd")
  private String sub_cd;
  
  @Column(name = "tumikomi_kbn")
  private String tumikomi_kbn;
  
  @Column(name = "karioki_kbn")
  private String karioki_kbn;
  
  @Column(name = "bt_kbn")
  private String bt_kbn;
  
  @Column(name = "hinshu")
  private String hinshu;
}
