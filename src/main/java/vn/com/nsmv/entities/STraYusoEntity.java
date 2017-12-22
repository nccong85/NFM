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
@Table(name = "s_tra_yuso")
@IdClass(YusoTran_Pk.class)
public class STraYusoEntity {

  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private String seizoshoKbn;

  @Column(name = "headno")
  private String headNo;

  @EmbeddedId
  private String sojonoShukkoBasho;

  @EmbeddedId
  private String sojonoTorihikiShubetsu;

  @EmbeddedId
  private String sojonoOban;

  @EmbeddedId
  private Integer sojonoRenban;

  @Column(name = "shukka_date")
  private String shukkaDate;

  @Column(name = "ukewatashi_basho")
  private String ukewatashiBasho;

  @Column(name = "ukewatashi_joken")
  private String ukewatashiJoken;

  @Column(name = "keiyakuno_year")
  private String keiyakunoYear;

  @Column(name = "keiyakuno_kankatsu")
  private String keiyakunoKankatsu;

  @Column(name = "keiyakuno_hinshu")
  private String keiyakunoHinshu;

  @Column(name = "keiyakuno_torihiki_shubetsu")
  private String keiyakunoTorihikiShubetsu;

  @Column(name = "keiyakuno_month")
  private String keiyakunoMonth;

  @Column(name = "keiyakuno_oban")
  private String keiyakunoOban;

  @Column(name = "ichiji_juyoka")
  private String ichijiJuyoka;

  @Column(name = "juryo")
  private Integer juryo;

  @Column(name = "cho1ju")
  private Integer cho1ju;

  @Column(name = "cho2ju")
  private Integer cho2ju;

  @Column(name = "binCd")
  private String binCd;

  @Column(name = "gyoshacd")
  private String gyoshaCd;

  @Column(name = "tsumiaicd")
  private String tsumiaiCd;

  @Column(name = "daisu")
  private Integer daisu;

  @Column(name = "rentmk")
  private String rentmk;

  @Column(name = "betto")
  private Integer betto;

  @Column(name = "tsumikomi_minato")
  private String tsumikomiMinato;

  @Column(name = "age_minato")
  private String ageMinato;

  @Column(name = "nagasa")
  private Integer nagasa;

  @Column(name = "chukei_kyori2")
  private Integer chukeiKyori2;

  @Column(name = "tumikomi_kbn")
  private String tumikomiKbn;

  @Column(name = "yushutsu_sokouhokan_nissu")
  private Integer yushutsuSokouhokanNissu;

  @Column(name = "yushutsu_futaisen_nissu")
  private Integer yushutsuFutaisenNissu;

  @Column(name = "yushutsu_kenryo_ryosu")
  private Integer yushutsuKenryoRyosu;

  @Column(name = "yushutsu_chukei_kbn")
  private String yushutsuChukeiKbn;

  @Column(name = "warimashi_kuton")
  private String warimashiKuton;

  @Column(name = "warimashi_chojaku")
  private String warimashiChojaku;

  @Column(name = "warimashi_kyujitsu")
  private String warimashiKyujitsu;

  @Column(name = "warimashi_jikangai")
  private String warimashiJikangai;

  @Column(name = "kyuryo")
  private Integer kyuryo;

  @Column(name = "tomeryo")
  private Integer tomeryo;

  @Column(name = "hamakbn")
  private String hamaKbn;

  @Column(name = "tranship_tsumikomi_minato")
  private String transhipTsumikomiMinato;

  @Column(name = "tranship_age_minato")
  private String transhipAgeMinato;

  @Column(name = "hanbai_kbn")
  private String hanbaiKbn;

  @Column(name = "teikino")
  private String teikino;

  @Column(name = "sagyo_kbn")
  private String sagyoKbn;

  @Column(name = "shukko_basho")
  private String shukkoBasho;

  @Column(name = "buppin04")
  private String buppin04; 
  
  @Column(name = "teisei_riyu")
  private String teiseiRiyu;
  
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

  public String getSeizoshoKbn() {
    return seizoshoKbn;
  }

  public void setSeizoshoKbn(String seizoshoKbn) {
    this.seizoshoKbn = seizoshoKbn;
  }

  public String getHeadNo() {
    return headNo;
  }

  public void setHeadNo(String headNo) {
    this.headNo = headNo;
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

  public Integer getSojonoRenban() {
    return sojonoRenban;
  }

  public void setSojonoRenban(Integer sojonoRenban) {
    this.sojonoRenban = sojonoRenban;
  }

  public String getShukkaDate() {
    return shukkaDate;
  }

  public void setShukkaDate(String shukkaDate) {
    this.shukkaDate = shukkaDate;
  }

  public String getUkewatashiBasho() {
    return ukewatashiBasho;
  }

  public void setUkewatashiBasho(String ukewatashiBasho) {
    this.ukewatashiBasho = ukewatashiBasho;
  }

  public String getUkewatashiJoken() {
    return ukewatashiJoken;
  }

  public void setUkewatashiJoken(String ukewatashiJoken) {
    this.ukewatashiJoken = ukewatashiJoken;
  }

  public String getKeiyakunoYear() {
    return keiyakunoYear;
  }

  public void setKeiyakunoYear(String keiyakunoYear) {
    this.keiyakunoYear = keiyakunoYear;
  }

  public String getKeiyakunoKankatsu() {
    return keiyakunoKankatsu;
  }

  public void setKeiyakunoKankatsu(String keiyakunoKankatsu) {
    this.keiyakunoKankatsu = keiyakunoKankatsu;
  }

  public String getKeiyakunoHinshu() {
    return keiyakunoHinshu;
  }

  public void setKeiyakunoHinshu(String keiyakunoHinshu) {
    this.keiyakunoHinshu = keiyakunoHinshu;
  }

  public String getKeiyakunoTorihikiShubetsu() {
    return keiyakunoTorihikiShubetsu;
  }

  public void setKeiyakunoTorihikiShubetsu(String keiyakunoTorihikiShubetsu) {
    this.keiyakunoTorihikiShubetsu = keiyakunoTorihikiShubetsu;
  }

  public String getKeiyakunoMonth() {
    return keiyakunoMonth;
  }

  public void setKeiyakunoMonth(String keiyakunoMonth) {
    this.keiyakunoMonth = keiyakunoMonth;
  }

  public String getKeiyakunoOban() {
    return keiyakunoOban;
  }

  public void setKeiyakunoOban(String keiyakunoOban) {
    this.keiyakunoOban = keiyakunoOban;
  }

  public String getIchijiJuyoka() {
    return ichijiJuyoka;
  }

  public void setIchijiJuyoka(String ichijiJuyoka) {
    this.ichijiJuyoka = ichijiJuyoka;
  }

  public Integer getJuryo() {
    return juryo;
  }

  public void setJuryo(Integer juryo) {
    this.juryo = juryo;
  }

  public Integer getCho1ju() {
    return cho1ju;
  }

  public void setCho1ju(Integer cho1ju) {
    this.cho1ju = cho1ju;
  }

  public Integer getCho2ju() {
    return cho2ju;
  }

  public void setCho2ju(Integer cho2ju) {
    this.cho2ju = cho2ju;
  }

  public String getBinCd() {
    return binCd;
  }

  public void setBinCd(String binCd) {
    this.binCd = binCd;
  }

  public String getGyoshaCd() {
    return gyoshaCd;
  }

  public void setGyoshaCd(String gyoshaCd) {
    this.gyoshaCd = gyoshaCd;
  }

  public String getTsumiaiCd() {
    return tsumiaiCd;
  }

  public void setTsumiaiCd(String tsumiaiCd) {
    this.tsumiaiCd = tsumiaiCd;
  }

  public Integer getDaisu() {
    return daisu;
  }

  public void setDaisu(Integer daisu) {
    this.daisu = daisu;
  }

  public String getRentmk() {
    return rentmk;
  }

  public void setRentmk(String rentmk) {
    this.rentmk = rentmk;
  }

  public Integer getBetto() {
    return betto;
  }

  public void setBetto(Integer betto) {
    this.betto = betto;
  }

  public String getTsumikomiMinato() {
    return tsumikomiMinato;
  }

  public void setTsumikomiMinato(String tsumikomiMinato) {
    this.tsumikomiMinato = tsumikomiMinato;
  }

  public String getAgeMinato() {
    return ageMinato;
  }

  public void setAgeMinato(String ageMinato) {
    this.ageMinato = ageMinato;
  }

  public Integer getNagasa() {
    return nagasa;
  }

  public void setNagasa(Integer nagasa) {
    this.nagasa = nagasa;
  }

  public Integer getChukeiKyori2() {
    return chukeiKyori2;
  }

  public void setChukeiKyori2(Integer chukeiKyori2) {
    this.chukeiKyori2 = chukeiKyori2;
  }

  public String getTumikomiKbn() {
    return tumikomiKbn;
  }

  public void setTumikomiKbn(String tumikomiKbn) {
    this.tumikomiKbn = tumikomiKbn;
  }

  public Integer getYushutsuSokouhokanNissu() {
    return yushutsuSokouhokanNissu;
  }

  public void setYushutsuSokouhokanNissu(Integer yushutsuSokouhokanNissu) {
    this.yushutsuSokouhokanNissu = yushutsuSokouhokanNissu;
  }

  public Integer getYushutsuFutaisenNissu() {
    return yushutsuFutaisenNissu;
  }

  public void setYushutsuFutaisenNissu(Integer yushutsuFutaisenNissu) {
    this.yushutsuFutaisenNissu = yushutsuFutaisenNissu;
  }

  public Integer getYushutsuKenryoRyosu() {
    return yushutsuKenryoRyosu;
  }

  public void setYushutsuKenryoRyosu(Integer yushutsuKenryoRyosu) {
    this.yushutsuKenryoRyosu = yushutsuKenryoRyosu;
  }

  public String getYushutsuChukeiKbn() {
    return yushutsuChukeiKbn;
  }

  public void setYushutsuChukeiKbn(String yushutsuChukeiKbn) {
    this.yushutsuChukeiKbn = yushutsuChukeiKbn;
  }

  public String getWarimashiKuton() {
    return warimashiKuton;
  }

  public void setWarimashiKuton(String warimashiKuton) {
    this.warimashiKuton = warimashiKuton;
  }

  public String getWarimashiChojaku() {
    return warimashiChojaku;
  }

  public void setWarimashiChojaku(String warimashiChojaku) {
    this.warimashiChojaku = warimashiChojaku;
  }

  public String getWarimashiKyujitsu() {
    return warimashiKyujitsu;
  }

  public void setWarimashiKyujitsu(String warimashiKyujitsu) {
    this.warimashiKyujitsu = warimashiKyujitsu;
  }

  public String getWarimashiJikangai() {
    return warimashiJikangai;
  }

  public void setWarimashiJikangai(String warimashiJikangai) {
    this.warimashiJikangai = warimashiJikangai;
  }

  public Integer getKyuryo() {
    return kyuryo;
  }

  public void setKyuryo(Integer kyuryo) {
    this.kyuryo = kyuryo;
  }

  public Integer getTomeryo() {
    return tomeryo;
  }

  public void setTomeryo(Integer tomeryo) {
    this.tomeryo = tomeryo;
  }

  public String getHamaKbn() {
    return hamaKbn;
  }

  public void setHamaKbn(String hamaKbn) {
    this.hamaKbn = hamaKbn;
  }

  public String getTranshipTsumikomiMinato() {
    return transhipTsumikomiMinato;
  }

  public void setTranshipTsumikomiMinato(String transhipTsumikomiMinato) {
    this.transhipTsumikomiMinato = transhipTsumikomiMinato;
  }

  public String getTranshipAgeMinato() {
    return transhipAgeMinato;
  }

  public void setTranshipAgeMinato(String transhipAgeMinato) {
    this.transhipAgeMinato = transhipAgeMinato;
  }

  public String getHanbaiKbn() {
    return hanbaiKbn;
  }

  public void setHanbaiKbn(String hanbaiKbn) {
    this.hanbaiKbn = hanbaiKbn;
  }

  public String getTeikino() {
    return teikino;
  }

  public void setTeikino(String teikino) {
    this.teikino = teikino;
  }

  public String getSagyoKbn() {
    return sagyoKbn;
  }

  public void setSagyoKbn(String sagyoKbn) {
    this.sagyoKbn = sagyoKbn;
  }

  public String getShukkoBasho() {
    return shukkoBasho;
  }

  public void setShukkoBasho(String shukkoBasho) {
    this.shukkoBasho = shukkoBasho;
  }

  public String getBuppin04() {
    return buppin04;
  }

  public void setBuppin04(String buppin04) {
    this.buppin04 = buppin04;
  }

  public String getTeiseiRiyu() {
	return teiseiRiyu;
}

public void setTeiseiRiyu(String teiseiRiyu) {
	this.teiseiRiyu = teiseiRiyu;
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

  public static long getSerialversionuid() {
    return serialVersionUID;
  }
}

@Embeddable
class YusoTran_Pk implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "seizosho_kbn")
  private String seizoshoKbn;

  @Column(name = "sojono_shukko_basho")
  private String sojonoShukkoBasho;

  @Column(name = "sojono_torihiki_shubetsu")
  private String sojonoTorihikiShubetsu;
  
  @Column(name = "sojono_oban")
  private String sojonoOban;

  @Column(name = "sojono_renban")
  private Integer sojonoRenban;
}
