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
@Table(name = "s_mst_207")
@IdClass(SMst207_Pk.class)
public class SMst207Entity {

  @EmbeddedId
  private String seizosho_kbn;
  
  @EmbeddedId
  private String data_kbn;
  
  @EmbeddedId
  private String key1;
  
  @EmbeddedId
  private String key2;
  
  @Column(name = "kihon_yuso_kyori")
  private Integer kihon_yuso_kyori;
  
  @Column(name = "keisan_yuso_kyori")
  private Integer keisan_yuso_kyori;
  
  @Column(name = "kinen_kbn")
  private String kinen_kbn;

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

  public String getData_kbn() {
    return data_kbn;
  }

  public void setData_kbn(String data_kbn) {
    this.data_kbn = data_kbn;
  }

  public String getKey1() {
    return key1;
  }

  public void setKey1(String key1) {
    this.key1 = key1;
  }

  public String getKey2() {
    return key2;
  }

  public void setKey2(String key2) {
    this.key2 = key2;
  }

  public Integer getKihon_yuso_kyori() {
    return kihon_yuso_kyori;
  }

  public void setKihon_yuso_kyori(Integer kihon_yuso_kyori) {
    this.kihon_yuso_kyori = kihon_yuso_kyori;
  }

  public Integer getKeisan_yuso_kyori() {
    return keisan_yuso_kyori;
  }

  public void setKeisan_yuso_kyori(Integer keisan_yuso_kyori) {
    this.keisan_yuso_kyori = keisan_yuso_kyori;
  }

  public String getKinen_kbn() {
    return kinen_kbn;
  }

  public void setKinen_kbn(String kinen_kbn) {
    this.kinen_kbn = kinen_kbn;
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
class SMst207_Pk implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "seizosho_kbn")
  private String seizosho_kbn;

  @Column(name = "data_kbn")
  private String data_kbn;

  @Column(name = "key1")
  private String key1;

  @Column(name = "key2")
  private String key2;
}

