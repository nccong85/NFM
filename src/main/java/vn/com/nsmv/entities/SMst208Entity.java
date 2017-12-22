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
@Table(name = "s_mst_208")
@IdClass(SMst208_Pk.class)
public class SMst208Entity {
  @EmbeddedId
  private String seizosho_kbn ;

  @EmbeddedId
  private String data_kbn ;

  @EmbeddedId
  private String key1 ;

  @EmbeddedId
  private String key2 ;

  @Column(name = "base_tanka1")
  private Integer base_tanka1;

  @Column(name = "base_tanka2")
  private Integer base_tanka2;

  @Column(name = "base_tanka3")
  private Integer base_tanka3;

  @Column(name = "base_tanka4")
  private Integer base_tanka4;

  @Column(name = "base_tanka5")
  private Integer base_tanka5;

  @Column(name = "base_tanka6")
  private Integer base_tanka6;

  @Column(name = "base_tanka7")
  private Integer base_tanka7;

  @Column(name = "base_tanka8")
  private Integer base_tanka8;

  @Column(name = "base_tanka9")
  private Integer base_tanka9;

  @Column(name = "base_tanka10")
  private Integer base_tanka10;

  @Column(name = "base_tanka11")
  private Integer base_tanka11;

  @Column(name = "base_tanka12")
  private Integer base_tanka12;

  @Column(name = "koso_tanka1")
  private Integer koso_tanka1;

  @Column(name = "koso_tanka2")
  private Integer koso_tanka2;

  @Column(name = "koso_tanka3")
  private Integer koso_tanka3;

  @Column(name = "koso_tanka4")
  private Integer koso_tanka4;

  @Column(name = "koso_tanka5")
  private Integer koso_tanka5;

  @Column(name = "koso_tanka6")
  private Integer koso_tanka6;

  @Column(name = "koso_tanka7")
  private Integer koso_tanka7;

  @Column(name = "koso_tanka8")
  private Integer koso_tanka8;

  @Column(name = "koso_tanka9")
  private Integer koso_tanka9;

  @Column(name = "koso_tanka10")
  private Integer koso_tanka10;

  @Column(name = "koso_tanka11")
  private Integer koso_tanka11;

  @Column(name = "koso_tanka12")
  private Integer koso_tanka12;

  @Column(name = "soyotm")
  private Integer soyotm;

  @Column(name = "keitm")
  private Integer keitm;

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

  public Integer getBase_tanka1() {
    return base_tanka1;
  }

  public void setBase_tanka1(Integer base_tanka1) {
    this.base_tanka1 = base_tanka1;
  }

  public Integer getBase_tanka2() {
    return base_tanka2;
  }

  public void setBase_tanka2(Integer base_tanka2) {
    this.base_tanka2 = base_tanka2;
  }

  public Integer getBase_tanka3() {
    return base_tanka3;
  }

  public void setBase_tanka3(Integer base_tanka3) {
    this.base_tanka3 = base_tanka3;
  }

  public Integer getBase_tanka4() {
    return base_tanka4;
  }

  public void setBase_tanka4(Integer base_tanka4) {
    this.base_tanka4 = base_tanka4;
  }

  public Integer getBase_tanka5() {
    return base_tanka5;
  }

  public void setBase_tanka5(Integer base_tanka5) {
    this.base_tanka5 = base_tanka5;
  }

  public Integer getBase_tanka6() {
    return base_tanka6;
  }

  public void setBase_tanka6(Integer base_tanka6) {
    this.base_tanka6 = base_tanka6;
  }

  public Integer getBase_tanka7() {
    return base_tanka7;
  }

  public void setBase_tanka7(Integer base_tanka7) {
    this.base_tanka7 = base_tanka7;
  }

  public Integer getBase_tanka8() {
    return base_tanka8;
  }

  public void setBase_tanka8(Integer base_tanka8) {
    this.base_tanka8 = base_tanka8;
  }

  public Integer getBase_tanka9() {
    return base_tanka9;
  }

  public void setBase_tanka9(Integer base_tanka9) {
    this.base_tanka9 = base_tanka9;
  }

  public Integer getBase_tanka10() {
    return base_tanka10;
  }

  public void setBase_tanka10(Integer base_tanka10) {
    this.base_tanka10 = base_tanka10;
  }

  public Integer getBase_tanka11() {
    return base_tanka11;
  }

  public void setBase_tanka11(Integer base_tanka11) {
    this.base_tanka11 = base_tanka11;
  }

  public Integer getBase_tanka12() {
    return base_tanka12;
  }

  public void setBase_tanka12(Integer base_tanka12) {
    this.base_tanka12 = base_tanka12;
  }

  public Integer getKoso_tanka1() {
    return koso_tanka1;
  }

  public void setKoso_tanka1(Integer koso_tanka1) {
    this.koso_tanka1 = koso_tanka1;
  }

  public Integer getKoso_tanka2() {
    return koso_tanka2;
  }

  public void setKoso_tanka2(Integer koso_tanka2) {
    this.koso_tanka2 = koso_tanka2;
  }

  public Integer getKoso_tanka3() {
    return koso_tanka3;
  }

  public void setKoso_tanka3(Integer koso_tanka3) {
    this.koso_tanka3 = koso_tanka3;
  }

  public Integer getKoso_tanka4() {
    return koso_tanka4;
  }

  public void setKoso_tanka4(Integer koso_tanka4) {
    this.koso_tanka4 = koso_tanka4;
  }

  public Integer getKoso_tanka5() {
    return koso_tanka5;
  }

  public void setKoso_tanka5(Integer koso_tanka5) {
    this.koso_tanka5 = koso_tanka5;
  }

  public Integer getKoso_tanka6() {
    return koso_tanka6;
  }

  public void setKoso_tanka6(Integer koso_tanka6) {
    this.koso_tanka6 = koso_tanka6;
  }

  public Integer getKoso_tanka7() {
    return koso_tanka7;
  }

  public void setKoso_tanka7(Integer koso_tanka7) {
    this.koso_tanka7 = koso_tanka7;
  }

  public Integer getKoso_tanka8() {
    return koso_tanka8;
  }

  public void setKoso_tanka8(Integer koso_tanka8) {
    this.koso_tanka8 = koso_tanka8;
  }

  public Integer getKoso_tanka9() {
    return koso_tanka9;
  }

  public void setKoso_tanka9(Integer koso_tanka9) {
    this.koso_tanka9 = koso_tanka9;
  }

  public Integer getKoso_tanka10() {
    return koso_tanka10;
  }

  public void setKoso_tanka10(Integer koso_tanka10) {
    this.koso_tanka10 = koso_tanka10;
  }

  public Integer getKoso_tanka11() {
    return koso_tanka11;
  }

  public void setKoso_tanka11(Integer koso_tanka11) {
    this.koso_tanka11 = koso_tanka11;
  }

  public Integer getKoso_tanka12() {
    return koso_tanka12;
  }

  public void setKoso_tanka12(Integer koso_tanka12) {
    this.koso_tanka12 = koso_tanka12;
  }

  public Integer getSoyotm() {
    return soyotm;
  }

  public void setSoyotm(Integer soyotm) {
    this.soyotm = soyotm;
  }

  public Integer getKeitm() {
    return keitm;
  }

  public void setKeitm(Integer keitm) {
    this.keitm = keitm;
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
class SMst208_Pk implements Serializable {

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