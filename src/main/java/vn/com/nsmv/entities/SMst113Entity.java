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
@Table(name = "s_mst_y13")
@IdClass(Mst113_Pk.class)
public class SMst113Entity {

  @EmbeddedId
  private String seizosho_kbn;
  
  @EmbeddedId
  private String bincd;
  
  @EmbeddedId
  private String gyoshacd;
  
  @EmbeddedId
  private String yushutsu_kbn;
  
  @EmbeddedId
  private String tenkai_himokucd;
  
  @Column(name = "tenkai_gyoshacd")
  private String tenkai_gyoshacd;
  
  @Column(name = "tenkai_tsumiai_kbn")
  private String tenkai_tsumiai_kbn;
  
  @Column(name = "tenkai_head_kbn")
  private String tenkai_head_kbn;

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

  public String getBincd() {
    return bincd;
  }

  public void setBincd(String bincd) {
    this.bincd = bincd;
  }

  public String getGyoshacd() {
    return gyoshacd;
  }

  public void setGyoshacd(String gyoshacd) {
    this.gyoshacd = gyoshacd;
  }

  public String getYushutsu_kbn() {
    return yushutsu_kbn;
  }

  public void setYushutsu_kbn(String yushutsu_kbn) {
    this.yushutsu_kbn = yushutsu_kbn;
  }

  public String getTenkai_himokucd() {
    return tenkai_himokucd;
  }

  public void setTenkai_himokucd(String tenkai_himokucd) {
    this.tenkai_himokucd = tenkai_himokucd;
  }

  public String getTenkai_gyoshacd() {
    return tenkai_gyoshacd;
  }

  public void setTenkai_gyoshacd(String tenkai_gyoshacd) {
    this.tenkai_gyoshacd = tenkai_gyoshacd;
  }

  public String getTenkai_tsumiai_kbn() {
    return tenkai_tsumiai_kbn;
  }

  public void setTenkai_tsumiai_kbn(String tenkai_tsumiai_kbn) {
    this.tenkai_tsumiai_kbn = tenkai_tsumiai_kbn;
  }

  public String getTenkai_head_kbn() {
    return tenkai_head_kbn;
  }

  public void setTenkai_head_kbn(String tenkai_head_kbn) {
    this.tenkai_head_kbn = tenkai_head_kbn;
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
class Mst113_Pk implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "seizosho_kbn")
  private String seizosho_kbn;

  @Column(name = "bincd")
  private String bincd;

  @Column(name = "gyoshacd")
  private String gyoshacd;
  
  @Column(name = "yushutsu_kbn")
  private String yushutsu_kbn;
  
  @Column(name = "tenkai_himokucd")
  private String tenkai_himokucd;
}