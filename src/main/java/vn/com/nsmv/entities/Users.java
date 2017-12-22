package vn.com.nsmv.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "s_mst_user")
public class Users {

  @Column(name = "seizosho_kbn")
  private String seizoshoKbn;

  @Id
  @Column(name = "user_id")
  private String userId;

  @Column(name = "password")
  private String password;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "sosa_kengen")
  private String sosaKengen;

  @Column(name = "user_role")
  private String userRole;

  @Column(name = "user_kaisha_name")
  private String userKaishaName;

  @Column(name = "user_shozoku")
  private String userShozoku;

  @Column(name = "user_tel")
  private String userTel;

  @Column(name = "user_mail")
  private String userMail;

  @Column(name = "del_flg")
  private String delFlg;
  @Column(name = "torokusha")
  private String torokusha;

  @Column(name = "toroku_date", nullable = true)
  private Date torokuDate;

  @Column(name = "koshinsha")
  private String koshinsha;

  @Column(name = "koshin_date", nullable = true)
  private Date koshinDate;

  @Column(name = "time_stamp", nullable = true)
  private Date timeStamp;

  public String getSeizoshoKbn() {
    return seizoshoKbn;
  }

  public void setSeizoshoKbn(String seizoshoKbn) {
    this.seizoshoKbn = seizoshoKbn;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserKaishaName() {
    return userKaishaName;
  }

  public void setUserKaishaName(String userKaishaName) {
    this.userKaishaName = userKaishaName;
  }

  public String getUserShozoku() {
    return userShozoku;
  }

  public void setUserShozoku(String userShozoku) {
    this.userShozoku = userShozoku;
  }

  public String getUserTel() {
    return userTel;
  }

  public void setUserTel(String userTel) {
    this.userTel = userTel;
  }

  public String getUserMail() {
    return userMail;
  }

  public void setUserMail(String userMail) {
    this.userMail = userMail;
  }

  public String getSosaKengen() {
    return sosaKengen;
  }

  public void setSosaKengen(String sosaKengen) {
    this.sosaKengen = sosaKengen;
  }

  public String getUserRole() {
    return userRole;
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }

  public String getDelFlg() {
    return delFlg;
  }

  public void setDelFlg(String delFlg) {
    this.delFlg = delFlg;
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
