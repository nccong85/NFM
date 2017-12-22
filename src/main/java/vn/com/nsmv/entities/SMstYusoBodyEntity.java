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
@Table(name = "s_mst_yuso_body")
@IdClass(YusoMasterBody_Pk.class)
public class SMstYusoBodyEntity {

	@EmbeddedId
	private String seizoshoKbn;

	@EmbeddedId
	private String sojonoShukkoBasho;

	@EmbeddedId
	private String sojonoTorihikiShubetsu;

	@EmbeddedId
	private String sojonoOban;

	@EmbeddedId
	private Integer sojonoRenban;

	@EmbeddedId
	private String headTeiseiKbn;

	@EmbeddedId
	private Integer headTeiseiKaisu;

	@EmbeddedId
	private String himokuCd;

	@EmbeddedId
	private String bodyTeiseiKbn;

	@EmbeddedId
	private Integer bodyTeiseiKaisu;

	@Column(name = "body_teisei_riyu")
	private String bodyTeiseiRiyu;

	@Column(name = "gyoshacd")
	private String gyoshaCd;

	@EmbeddedId
	private String seikyuNengetsu;

	@Column(name = "daisu")
	private Integer daisu;

	@Column(name = "tsumiaicd")
	private String tsumiaiCd;

	@Column(name = "tsumikomi_minato")
	private String tsumikomiMinato;

	@Column(name = "age_minato")
	private String ageMinato;

	@Column(name = "tranship_tsumikomi_minato")
	private String transhipTsumikomiMinato;

	@Column(name = "tranship_age_minato")
	private String transhipAgeMinato;

	@Column(name = "chukei_kyori1")
	private Integer chukeiKyori1;

	@Column(name = "chukei_kyori2")
	private Integer chukeiKyori2;

	@Column(name = "nagasa")
	private Integer nagasa;

	@Column(name = "tanka_tani")
	private String tankaTani;

	@Column(name = "tanka")
	private Integer tanka;

	@Column(name = "kingaku")
	private Integer kingaku;

	@Column(name = "yushutsu_chukei_kbn")
	private String yushutsuChukeiKbn;

	@Column(name = "yushutsu_futaisen_nissu")
	private Integer yushutsuFutaisenNissu;

	@Column(name = "yushutsu_sokouhokan_nissu")
	private Integer yushutsuSokouhokanNissu;

	@Column(name = "yushutsu_kenryo_ryosu")
	private Integer yushutsuKenryoRyosu;

	@Column(name = "yushutsu_shinkoku_kensu")
	private Integer yushutsuShinkokuensu;

	@Column(name = "warimashi_kuton")
	private String warimashiKuton;

	@Column(name = "warimashi_chojaku")
	private String warimashiChojaku;

	@Column(name = "warimashi_hinshu")
	private String warimashiHinshu;

	@Column(name = "warimashi_kyujitsu")
	private String warimashiKyujitsu;

	@Column(name = "warimashi_jikangai")
	private String warimashiJikangai;

	@Column(name = "uchiwake_base_juryo")
	private Integer uchiwakeBaseJuryo;

	@Column(name = "uchiwake_base_kingaku")
	private Integer uchiwakeBaseKingaku;

	@Column(name = "uchiwake_kuton_juryo")
	private Integer uchiwakeKutonJuryo;

	@Column(name = "uchiwake_kuton_kingaku")
	private Integer uchiwakeKutonKingaku;

	@Column(name = "uchiwake_chojaku_juryo")
	private Integer uchiwakeChojakuJuryo;

	@Column(name = "uchiwake_chojaku_kingaku")
	private Integer uchiwakeChojakuKingaku;

	@Column(name = "uchiwake_jikangai_juryo")
	private Integer uchiwakeJikangaiJuryo;

	@Column(name = "uchiwake_jikangai_kingaku")
	private Integer uchiwakeJikangaiKingaku;

	@Column(name = "uchiwake_hinshu_juryo")
	private Integer uchiwake_hinshu_juryo;

	@Column(name = "uchiwake_hinshu_kingaku")
	private Integer uchiwake_hinshu_kingaku;

	@Column(name = "uchiwake_sonota_juryo")
	private Integer uchiwakeSonotaJuryo;

	@Column(name = "uchiwake_sonota_kingaku")
	private Integer uchiwakeSonotaKingaku;

	@Column(name = "extracd1")
	private String extraCd1;

	@Column(name = "extra_kingaku1")
	private Integer extraKingaku1;

	@Column(name = "extracd2")
	private String extracd2;

	@Column(name = "extra_kingaku2")
	private Integer extraKingaku2;

	@Column(name = "extracd3")
	private String extraCd3;

	@Column(name = "extra_kingaku3")
	private Integer extraKingaku3;

	@Column(name = "sagyo_kbn")
	private String sagyoKbn;

	@Column(name = "shin_tanka")
	private Integer shinTanka;

	@Column(name = "shin_kingaku")
	private Integer shinKingaku;

	@Column(name = "betto_flg")
	private String bettoFlg;

	@Column(name = "keireki_flg")
	private String keirekiFlg;

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

	public String getHeadTeiseiKbn() {
		return headTeiseiKbn;
	}

	public void setHeadTeiseiKbn(String headTeiseiKbn) {
		this.headTeiseiKbn = headTeiseiKbn;
	}

	public Integer getHeadTeiseiKaisu() {
		return headTeiseiKaisu;
	}

	public void setHeadTeiseiKaisu(Integer headTeiseiKaisu) {
		this.headTeiseiKaisu = headTeiseiKaisu;
	}

	public String getHimokuCd() {
		return himokuCd;
	}

	public void setHimokuCd(String himokuCd) {
		this.himokuCd = himokuCd;
	}

	public String getBodyTeiseiKbn() {
		return bodyTeiseiKbn;
	}

	public void setBodyTeiseiKbn(String bodyTeiseiKbn) {
		this.bodyTeiseiKbn = bodyTeiseiKbn;
	}

	public Integer getBodyTeiseiKaisu() {
		return bodyTeiseiKaisu;
	}

	public void setBodyTeiseiKaisu(Integer bodyTeiseiKaisu) {
		this.bodyTeiseiKaisu = bodyTeiseiKaisu;
	}

	public String getBodyTeiseiRiyu() {
		return bodyTeiseiRiyu;
	}

	public void setBodyTeiseiRiyu(String bodyTeiseiRiyu) {
		this.bodyTeiseiRiyu = bodyTeiseiRiyu;
	}

	public String getGyoshaCd() {
		return gyoshaCd;
	}

	public void setGyoshaCd(String gyoshaCd) {
		this.gyoshaCd = gyoshaCd;
	}

	public String getSeikyuNengetsu() {
		return seikyuNengetsu;
	}

	public void setSeikyuNengetsu(String seikyuNengetsu) {
		this.seikyuNengetsu = seikyuNengetsu;
	}

	public Integer getDaisu() {
		return daisu;
	}

	public void setDaisu(Integer daisu) {
		this.daisu = daisu;
	}

	public String getTsumiaiCd() {
		return tsumiaiCd;
	}

	public void setTsumiaiCd(String tsumiaiCd) {
		this.tsumiaiCd = tsumiaiCd;
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

	public Integer getChukeiKyori1() {
		return chukeiKyori1;
	}

	public void setChukeiKyori1(Integer chukeiKyori1) {
		this.chukeiKyori1 = chukeiKyori1;
	}

	public Integer getChukeiKyori2() {
		return chukeiKyori2;
	}

	public void setChukeiKyori2(Integer chukeiKyori2) {
		this.chukeiKyori2 = chukeiKyori2;
	}

	public Integer getNagasa() {
		return nagasa;
	}

	public void setNagasa(Integer nagasa) {
		this.nagasa = nagasa;
	}

	public String getTankaTani() {
		return tankaTani;
	}

	public void setTankaTani(String tankaTani) {
		this.tankaTani = tankaTani;
	}

	public Integer getTanka() {
		return tanka;
	}

	public void setTanka(Integer tanka) {
		this.tanka = tanka;
	}

	public Integer getKingaku() {
		return kingaku;
	}

	public void setKingaku(Integer kingaku) {
		this.kingaku = kingaku;
	}

	public String getYushutsuChukeiKbn() {
		return yushutsuChukeiKbn;
	}

	public void setYushutsuChukeiKbn(String yushutsuChukeiKbn) {
		this.yushutsuChukeiKbn = yushutsuChukeiKbn;
	}

	public Integer getYushutsuFutaisenNissu() {
		return yushutsuFutaisenNissu;
	}

	public void setYushutsuFutaisenNissu(Integer yushutsuFutaisenNissu) {
		this.yushutsuFutaisenNissu = yushutsuFutaisenNissu;
	}

	public Integer getYushutsuSokouhokanNissu() {
		return yushutsuSokouhokanNissu;
	}

	public void setYushutsuSokouhokanNissu(Integer yushutsuSokouhokanNissu) {
		this.yushutsuSokouhokanNissu = yushutsuSokouhokanNissu;
	}

	public Integer getYushutsuKenryoRyosu() {
		return yushutsuKenryoRyosu;
	}

	public void setYushutsuKenryoRyosu(Integer yushutsuKenryoRyosu) {
		this.yushutsuKenryoRyosu = yushutsuKenryoRyosu;
	}

	public Integer getYushutsuShinkokuensu() {
		return yushutsuShinkokuensu;
	}

	public void setYushutsuShinkokuensu(Integer yushutsuShinkokuensu) {
		this.yushutsuShinkokuensu = yushutsuShinkokuensu;
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

	public String getWarimashiHinshu() {
		return warimashiHinshu;
	}

	public void setWarimashiHinshu(String warimashiHinshu) {
		this.warimashiHinshu = warimashiHinshu;
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

	public Integer getUchiwakeBaseJuryo() {
		return uchiwakeBaseJuryo;
	}

	public void setUchiwakeBaseJuryo(Integer uchiwakeBaseJuryo) {
		this.uchiwakeBaseJuryo = uchiwakeBaseJuryo;
	}

	public Integer getUchiwakeBaseKingaku() {
		return uchiwakeBaseKingaku;
	}

	public void setUchiwakeBaseKingaku(Integer uchiwakeBaseKingaku) {
		this.uchiwakeBaseKingaku = uchiwakeBaseKingaku;
	}

	public Integer getUchiwakeKutonJuryo() {
		return uchiwakeKutonJuryo;
	}

	public void setUchiwakeKutonJuryo(Integer uchiwakeKutonJuryo) {
		this.uchiwakeKutonJuryo = uchiwakeKutonJuryo;
	}

	public Integer getUchiwakeKutonKingaku() {
		return uchiwakeKutonKingaku;
	}

	public void setUchiwakeKutonKingaku(Integer uchiwakeKutonKingaku) {
		this.uchiwakeKutonKingaku = uchiwakeKutonKingaku;
	}

	public Integer getUchiwakeChojakuJuryo() {
		return uchiwakeChojakuJuryo;
	}

	public void setUchiwakeChojakuJuryo(Integer uchiwakeChojakuJuryo) {
		this.uchiwakeChojakuJuryo = uchiwakeChojakuJuryo;
	}

	public Integer getUchiwakeChojakuKingaku() {
		return uchiwakeChojakuKingaku;
	}

	public void setUchiwakeChojakuKingaku(Integer uchiwakeChojakuKingaku) {
		this.uchiwakeChojakuKingaku = uchiwakeChojakuKingaku;
	}

	public Integer getUchiwakeJikangaiJuryo() {
		return uchiwakeJikangaiJuryo;
	}

	public void setUchiwakeJikangaiJuryo(Integer uchiwakeJikangaiJuryo) {
		this.uchiwakeJikangaiJuryo = uchiwakeJikangaiJuryo;
	}

	public Integer getUchiwakeJikangaiKingaku() {
		return uchiwakeJikangaiKingaku;
	}

	public void setUchiwakeJikangaiKingaku(Integer uchiwakeJikangaiKingaku) {
		this.uchiwakeJikangaiKingaku = uchiwakeJikangaiKingaku;
	}

	public Integer getUchiwake_hinshu_juryo() {
		return uchiwake_hinshu_juryo;
	}

	public void setUchiwake_hinshu_juryo(Integer uchiwake_hinshu_juryo) {
		this.uchiwake_hinshu_juryo = uchiwake_hinshu_juryo;
	}

	public Integer getUchiwake_hinshu_kingaku() {
		return uchiwake_hinshu_kingaku;
	}

	public void setUchiwake_hinshu_kingaku(Integer uchiwake_hinshu_kingaku) {
		this.uchiwake_hinshu_kingaku = uchiwake_hinshu_kingaku;
	}

	public Integer getUchiwakeSonotaJuryo() {
		return uchiwakeSonotaJuryo;
	}

	public void setUchiwakeSonotaJuryo(Integer uchiwakeSonotaJuryo) {
		this.uchiwakeSonotaJuryo = uchiwakeSonotaJuryo;
	}

	public Integer getUchiwakeSonotaKingaku() {
		return uchiwakeSonotaKingaku;
	}

	public void setUchiwakeSonotaKingaku(Integer uchiwakeSonotaKingaku) {
		this.uchiwakeSonotaKingaku = uchiwakeSonotaKingaku;
	}

	public String getExtraCd1() {
		return extraCd1;
	}

	public void setExtraCd1(String extraCd1) {
		this.extraCd1 = extraCd1;
	}

	public Integer getExtraKingaku1() {
		return extraKingaku1;
	}

	public void setExtraKingaku1(Integer extraKingaku1) {
		this.extraKingaku1 = extraKingaku1;
	}

	public String getExtracd2() {
		return extracd2;
	}

	public void setExtracd2(String extracd2) {
		this.extracd2 = extracd2;
	}

	public Integer getExtraKingaku2() {
		return extraKingaku2;
	}

	public void setExtraKingaku2(Integer extraKingaku2) {
		this.extraKingaku2 = extraKingaku2;
	}

	public String getExtraCd3() {
		return extraCd3;
	}

	public void setExtraCd3(String extraCd3) {
		this.extraCd3 = extraCd3;
	}

	public Integer getExtraKingaku3() {
		return extraKingaku3;
	}

	public void setExtraKingaku3(Integer extraKingaku3) {
		this.extraKingaku3 = extraKingaku3;
	}

	public String getSagyoKbn() {
		return sagyoKbn;
	}

	public void setSagyoKbn(String sagyoKbn) {
		this.sagyoKbn = sagyoKbn;
	}

	public Integer getShinTanka() {
		return shinTanka;
	}

	public void setShinTanka(Integer shinTanka) {
		this.shinTanka = shinTanka;
	}

	public Integer getShinKingaku() {
		return shinKingaku;
	}

	public void setShinKingaku(Integer shinKingaku) {
		this.shinKingaku = shinKingaku;
	}

	public String getBettoFlg() {
		return bettoFlg;
	}

	public void setBettoFlg(String bettoFlg) {
		this.bettoFlg = bettoFlg;
	}

	public String getKeirekiFlg() {
		return keirekiFlg;
	}

	public void setKeirekiFlg(String keirekiFlg) {
		this.keirekiFlg = keirekiFlg;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ageMinato == null) ? 0 : ageMinato.hashCode());
		result = prime * result + ((bettoFlg == null) ? 0 : bettoFlg.hashCode());
		result = prime * result + ((bodyTeiseiKaisu == null) ? 0 : bodyTeiseiKaisu.hashCode());
		result = prime * result + ((bodyTeiseiKbn == null) ? 0 : bodyTeiseiKbn.hashCode());
		result = prime * result + ((bodyTeiseiRiyu == null) ? 0 : bodyTeiseiRiyu.hashCode());
		result = prime * result + ((chukeiKyori1 == null) ? 0 : chukeiKyori1.hashCode());
		result = prime * result + ((chukeiKyori2 == null) ? 0 : chukeiKyori2.hashCode());
		result = prime * result + ((daisu == null) ? 0 : daisu.hashCode());
		result = prime * result + ((extraCd1 == null) ? 0 : extraCd1.hashCode());
		result = prime * result + ((extraCd3 == null) ? 0 : extraCd3.hashCode());
		result = prime * result + ((extraKingaku1 == null) ? 0 : extraKingaku1.hashCode());
		result = prime * result + ((extraKingaku2 == null) ? 0 : extraKingaku2.hashCode());
		result = prime * result + ((extraKingaku3 == null) ? 0 : extraKingaku3.hashCode());
		result = prime * result + ((extracd2 == null) ? 0 : extracd2.hashCode());
		result = prime * result + ((gyoshaCd == null) ? 0 : gyoshaCd.hashCode());
		result = prime * result + ((headTeiseiKaisu == null) ? 0 : headTeiseiKaisu.hashCode());
		result = prime * result + ((headTeiseiKbn == null) ? 0 : headTeiseiKbn.hashCode());
		result = prime * result + ((himokuCd == null) ? 0 : himokuCd.hashCode());
		result = prime * result + ((keirekiFlg == null) ? 0 : keirekiFlg.hashCode());
		result = prime * result + ((kingaku == null) ? 0 : kingaku.hashCode());
		result = prime * result + ((koshinDate == null) ? 0 : koshinDate.hashCode());
		result = prime * result + ((koshinsha == null) ? 0 : koshinsha.hashCode());
		result = prime * result + ((nagasa == null) ? 0 : nagasa.hashCode());
		result = prime * result + ((sagyoKbn == null) ? 0 : sagyoKbn.hashCode());
		result = prime * result + ((seikyuNengetsu == null) ? 0 : seikyuNengetsu.hashCode());
		result = prime * result + ((seizoshoKbn == null) ? 0 : seizoshoKbn.hashCode());
		result = prime * result + ((shinKingaku == null) ? 0 : shinKingaku.hashCode());
		result = prime * result + ((shinTanka == null) ? 0 : shinTanka.hashCode());
		result = prime * result + ((sojonoOban == null) ? 0 : sojonoOban.hashCode());
		result = prime * result + ((sojonoRenban == null) ? 0 : sojonoRenban.hashCode());
		result = prime * result + ((sojonoShukkoBasho == null) ? 0 : sojonoShukkoBasho.hashCode());
		result = prime * result + ((sojonoTorihikiShubetsu == null) ? 0 : sojonoTorihikiShubetsu.hashCode());
		result = prime * result + ((tanka == null) ? 0 : tanka.hashCode());
		result = prime * result + ((tankaTani == null) ? 0 : tankaTani.hashCode());
		result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
		result = prime * result + ((torokuDate == null) ? 0 : torokuDate.hashCode());
		result = prime * result + ((torokusha == null) ? 0 : torokusha.hashCode());
		result = prime * result + ((transhipAgeMinato == null) ? 0 : transhipAgeMinato.hashCode());
		result = prime * result + ((transhipTsumikomiMinato == null) ? 0 : transhipTsumikomiMinato.hashCode());
		result = prime * result + ((tsumiaiCd == null) ? 0 : tsumiaiCd.hashCode());
		result = prime * result + ((tsumikomiMinato == null) ? 0 : tsumikomiMinato.hashCode());
		result = prime * result + ((uchiwakeBaseJuryo == null) ? 0 : uchiwakeBaseJuryo.hashCode());
		result = prime * result + ((uchiwakeBaseKingaku == null) ? 0 : uchiwakeBaseKingaku.hashCode());
		result = prime * result + ((uchiwakeChojakuJuryo == null) ? 0 : uchiwakeChojakuJuryo.hashCode());
		result = prime * result + ((uchiwakeChojakuKingaku == null) ? 0 : uchiwakeChojakuKingaku.hashCode());
		result = prime * result + ((uchiwakeJikangaiJuryo == null) ? 0 : uchiwakeJikangaiJuryo.hashCode());
		result = prime * result + ((uchiwakeJikangaiKingaku == null) ? 0 : uchiwakeJikangaiKingaku.hashCode());
		result = prime * result + ((uchiwakeKutonJuryo == null) ? 0 : uchiwakeKutonJuryo.hashCode());
		result = prime * result + ((uchiwakeKutonKingaku == null) ? 0 : uchiwakeKutonKingaku.hashCode());
		result = prime * result + ((uchiwakeSonotaJuryo == null) ? 0 : uchiwakeSonotaJuryo.hashCode());
		result = prime * result + ((uchiwakeSonotaKingaku == null) ? 0 : uchiwakeSonotaKingaku.hashCode());
		result = prime * result + ((uchiwake_hinshu_juryo == null) ? 0 : uchiwake_hinshu_juryo.hashCode());
		result = prime * result + ((uchiwake_hinshu_kingaku == null) ? 0 : uchiwake_hinshu_kingaku.hashCode());
		result = prime * result + ((warimashiChojaku == null) ? 0 : warimashiChojaku.hashCode());
		result = prime * result + ((warimashiHinshu == null) ? 0 : warimashiHinshu.hashCode());
		result = prime * result + ((warimashiJikangai == null) ? 0 : warimashiJikangai.hashCode());
		result = prime * result + ((warimashiKuton == null) ? 0 : warimashiKuton.hashCode());
		result = prime * result + ((warimashiKyujitsu == null) ? 0 : warimashiKyujitsu.hashCode());
		result = prime * result + ((yushutsuChukeiKbn == null) ? 0 : yushutsuChukeiKbn.hashCode());
		result = prime * result + ((yushutsuFutaisenNissu == null) ? 0 : yushutsuFutaisenNissu.hashCode());
		result = prime * result + ((yushutsuKenryoRyosu == null) ? 0 : yushutsuKenryoRyosu.hashCode());
		result = prime * result + ((yushutsuShinkokuensu == null) ? 0 : yushutsuShinkokuensu.hashCode());
		result = prime * result + ((yushutsuSokouhokanNissu == null) ? 0 : yushutsuSokouhokanNissu.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SMstYusoBodyEntity other = (SMstYusoBodyEntity) obj;
		if (ageMinato == null) {
			if (other.ageMinato != null)
				return false;
		} else if (!ageMinato.equals(other.ageMinato))
			return false;
		if (bettoFlg == null) {
			if (other.bettoFlg != null)
				return false;
		} else if (!bettoFlg.equals(other.bettoFlg))
			return false;
		if (bodyTeiseiKaisu == null) {
			if (other.bodyTeiseiKaisu != null)
				return false;
		} else if (!bodyTeiseiKaisu.equals(other.bodyTeiseiKaisu))
			return false;
		if (bodyTeiseiKbn == null) {
			if (other.bodyTeiseiKbn != null)
				return false;
		} else if (!bodyTeiseiKbn.equals(other.bodyTeiseiKbn))
			return false;
		if (bodyTeiseiRiyu == null) {
			if (other.bodyTeiseiRiyu != null)
				return false;
		} else if (!bodyTeiseiRiyu.equals(other.bodyTeiseiRiyu))
			return false;
		if (chukeiKyori1 == null) {
			if (other.chukeiKyori1 != null)
				return false;
		} else if (!chukeiKyori1.equals(other.chukeiKyori1))
			return false;
		if (chukeiKyori2 == null) {
			if (other.chukeiKyori2 != null)
				return false;
		} else if (!chukeiKyori2.equals(other.chukeiKyori2))
			return false;
		if (daisu == null) {
			if (other.daisu != null)
				return false;
		} else if (!daisu.equals(other.daisu))
			return false;
		if (extraCd1 == null) {
			if (other.extraCd1 != null)
				return false;
		} else if (!extraCd1.equals(other.extraCd1))
			return false;
		if (extraCd3 == null) {
			if (other.extraCd3 != null)
				return false;
		} else if (!extraCd3.equals(other.extraCd3))
			return false;
		if (extraKingaku1 == null) {
			if (other.extraKingaku1 != null)
				return false;
		} else if (!extraKingaku1.equals(other.extraKingaku1))
			return false;
		if (extraKingaku2 == null) {
			if (other.extraKingaku2 != null)
				return false;
		} else if (!extraKingaku2.equals(other.extraKingaku2))
			return false;
		if (extraKingaku3 == null) {
			if (other.extraKingaku3 != null)
				return false;
		} else if (!extraKingaku3.equals(other.extraKingaku3))
			return false;
		if (extracd2 == null) {
			if (other.extracd2 != null)
				return false;
		} else if (!extracd2.equals(other.extracd2))
			return false;
		if (gyoshaCd == null) {
			if (other.gyoshaCd != null)
				return false;
		} else if (!gyoshaCd.equals(other.gyoshaCd))
			return false;
		if (headTeiseiKaisu == null) {
			if (other.headTeiseiKaisu != null)
				return false;
		} else if (!headTeiseiKaisu.equals(other.headTeiseiKaisu))
			return false;
		if (headTeiseiKbn == null) {
			if (other.headTeiseiKbn != null)
				return false;
		} else if (!headTeiseiKbn.equals(other.headTeiseiKbn))
			return false;
		if (himokuCd == null) {
			if (other.himokuCd != null)
				return false;
		} else if (!himokuCd.equals(other.himokuCd))
			return false;
		if (keirekiFlg == null) {
			if (other.keirekiFlg != null)
				return false;
		} else if (!keirekiFlg.equals(other.keirekiFlg))
			return false;
		if (kingaku == null) {
			if (other.kingaku != null)
				return false;
		} else if (!kingaku.equals(other.kingaku))
			return false;
		if (koshinDate == null) {
			if (other.koshinDate != null)
				return false;
		} else if (!koshinDate.equals(other.koshinDate))
			return false;
		if (koshinsha == null) {
			if (other.koshinsha != null)
				return false;
		} else if (!koshinsha.equals(other.koshinsha))
			return false;
		if (nagasa == null) {
			if (other.nagasa != null)
				return false;
		} else if (!nagasa.equals(other.nagasa))
			return false;
		if (sagyoKbn == null) {
			if (other.sagyoKbn != null)
				return false;
		} else if (!sagyoKbn.equals(other.sagyoKbn))
			return false;
		if (seikyuNengetsu == null) {
			if (other.seikyuNengetsu != null)
				return false;
		} else if (!seikyuNengetsu.equals(other.seikyuNengetsu))
			return false;
		if (seizoshoKbn == null) {
			if (other.seizoshoKbn != null)
				return false;
		} else if (!seizoshoKbn.equals(other.seizoshoKbn))
			return false;
		if (shinKingaku == null) {
			if (other.shinKingaku != null)
				return false;
		} else if (!shinKingaku.equals(other.shinKingaku))
			return false;
		if (shinTanka == null) {
			if (other.shinTanka != null)
				return false;
		} else if (!shinTanka.equals(other.shinTanka))
			return false;
		if (sojonoOban == null) {
			if (other.sojonoOban != null)
				return false;
		} else if (!sojonoOban.equals(other.sojonoOban))
			return false;
		if (sojonoRenban == null) {
			if (other.sojonoRenban != null)
				return false;
		} else if (!sojonoRenban.equals(other.sojonoRenban))
			return false;
		if (sojonoShukkoBasho == null) {
			if (other.sojonoShukkoBasho != null)
				return false;
		} else if (!sojonoShukkoBasho.equals(other.sojonoShukkoBasho))
			return false;
		if (sojonoTorihikiShubetsu == null) {
			if (other.sojonoTorihikiShubetsu != null)
				return false;
		} else if (!sojonoTorihikiShubetsu.equals(other.sojonoTorihikiShubetsu))
			return false;
		if (tanka == null) {
			if (other.tanka != null)
				return false;
		} else if (!tanka.equals(other.tanka))
			return false;
		if (tankaTani == null) {
			if (other.tankaTani != null)
				return false;
		} else if (!tankaTani.equals(other.tankaTani))
			return false;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		if (torokuDate == null) {
			if (other.torokuDate != null)
				return false;
		} else if (!torokuDate.equals(other.torokuDate))
			return false;
		if (torokusha == null) {
			if (other.torokusha != null)
				return false;
		} else if (!torokusha.equals(other.torokusha))
			return false;
		if (transhipAgeMinato == null) {
			if (other.transhipAgeMinato != null)
				return false;
		} else if (!transhipAgeMinato.equals(other.transhipAgeMinato))
			return false;
		if (transhipTsumikomiMinato == null) {
			if (other.transhipTsumikomiMinato != null)
				return false;
		} else if (!transhipTsumikomiMinato.equals(other.transhipTsumikomiMinato))
			return false;
		if (tsumiaiCd == null) {
			if (other.tsumiaiCd != null)
				return false;
		} else if (!tsumiaiCd.equals(other.tsumiaiCd))
			return false;
		if (tsumikomiMinato == null) {
			if (other.tsumikomiMinato != null)
				return false;
		} else if (!tsumikomiMinato.equals(other.tsumikomiMinato))
			return false;
		if (uchiwakeBaseJuryo == null) {
			if (other.uchiwakeBaseJuryo != null)
				return false;
		} else if (!uchiwakeBaseJuryo.equals(other.uchiwakeBaseJuryo))
			return false;
		if (uchiwakeBaseKingaku == null) {
			if (other.uchiwakeBaseKingaku != null)
				return false;
		} else if (!uchiwakeBaseKingaku.equals(other.uchiwakeBaseKingaku))
			return false;
		if (uchiwakeChojakuJuryo == null) {
			if (other.uchiwakeChojakuJuryo != null)
				return false;
		} else if (!uchiwakeChojakuJuryo.equals(other.uchiwakeChojakuJuryo))
			return false;
		if (uchiwakeChojakuKingaku == null) {
			if (other.uchiwakeChojakuKingaku != null)
				return false;
		} else if (!uchiwakeChojakuKingaku.equals(other.uchiwakeChojakuKingaku))
			return false;
		if (uchiwakeJikangaiJuryo == null) {
			if (other.uchiwakeJikangaiJuryo != null)
				return false;
		} else if (!uchiwakeJikangaiJuryo.equals(other.uchiwakeJikangaiJuryo))
			return false;
		if (uchiwakeJikangaiKingaku == null) {
			if (other.uchiwakeJikangaiKingaku != null)
				return false;
		} else if (!uchiwakeJikangaiKingaku.equals(other.uchiwakeJikangaiKingaku))
			return false;
		if (uchiwakeKutonJuryo == null) {
			if (other.uchiwakeKutonJuryo != null)
				return false;
		} else if (!uchiwakeKutonJuryo.equals(other.uchiwakeKutonJuryo))
			return false;
		if (uchiwakeKutonKingaku == null) {
			if (other.uchiwakeKutonKingaku != null)
				return false;
		} else if (!uchiwakeKutonKingaku.equals(other.uchiwakeKutonKingaku))
			return false;
		if (uchiwakeSonotaJuryo == null) {
			if (other.uchiwakeSonotaJuryo != null)
				return false;
		} else if (!uchiwakeSonotaJuryo.equals(other.uchiwakeSonotaJuryo))
			return false;
		if (uchiwakeSonotaKingaku == null) {
			if (other.uchiwakeSonotaKingaku != null)
				return false;
		} else if (!uchiwakeSonotaKingaku.equals(other.uchiwakeSonotaKingaku))
			return false;
		if (uchiwake_hinshu_juryo == null) {
			if (other.uchiwake_hinshu_juryo != null)
				return false;
		} else if (!uchiwake_hinshu_juryo.equals(other.uchiwake_hinshu_juryo))
			return false;
		if (uchiwake_hinshu_kingaku == null) {
			if (other.uchiwake_hinshu_kingaku != null)
				return false;
		} else if (!uchiwake_hinshu_kingaku.equals(other.uchiwake_hinshu_kingaku))
			return false;
		if (warimashiChojaku == null) {
			if (other.warimashiChojaku != null)
				return false;
		} else if (!warimashiChojaku.equals(other.warimashiChojaku))
			return false;
		if (warimashiHinshu == null) {
			if (other.warimashiHinshu != null)
				return false;
		} else if (!warimashiHinshu.equals(other.warimashiHinshu))
			return false;
		if (warimashiJikangai == null) {
			if (other.warimashiJikangai != null)
				return false;
		} else if (!warimashiJikangai.equals(other.warimashiJikangai))
			return false;
		if (warimashiKuton == null) {
			if (other.warimashiKuton != null)
				return false;
		} else if (!warimashiKuton.equals(other.warimashiKuton))
			return false;
		if (warimashiKyujitsu == null) {
			if (other.warimashiKyujitsu != null)
				return false;
		} else if (!warimashiKyujitsu.equals(other.warimashiKyujitsu))
			return false;
		if (yushutsuChukeiKbn == null) {
			if (other.yushutsuChukeiKbn != null)
				return false;
		} else if (!yushutsuChukeiKbn.equals(other.yushutsuChukeiKbn))
			return false;
		if (yushutsuFutaisenNissu == null) {
			if (other.yushutsuFutaisenNissu != null)
				return false;
		} else if (!yushutsuFutaisenNissu.equals(other.yushutsuFutaisenNissu))
			return false;
		if (yushutsuKenryoRyosu == null) {
			if (other.yushutsuKenryoRyosu != null)
				return false;
		} else if (!yushutsuKenryoRyosu.equals(other.yushutsuKenryoRyosu))
			return false;
		if (yushutsuShinkokuensu == null) {
			if (other.yushutsuShinkokuensu != null)
				return false;
		} else if (!yushutsuShinkokuensu.equals(other.yushutsuShinkokuensu))
			return false;
		if (yushutsuSokouhokanNissu == null) {
			if (other.yushutsuSokouhokanNissu != null)
				return false;
		} else if (!yushutsuSokouhokanNissu.equals(other.yushutsuSokouhokanNissu))
			return false;
		return true;
	}

}

@Embeddable
class YusoMasterBody_Pk implements Serializable {

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

	@Column(name = "head_teisei_kbn")
	private String headTeiseiKbn;

	@Column(name = "head_teisei_kaisu")
	private Integer headTeiseiKaisu;

	@Column(name = "himokucd")
	private String himokuCd;

	@Column(name = "body_teisei_kbn")
	private String bodyTeiseiKbn;

	@Column(name = "body_teisei_kaisu")
	private Integer bodyTeiseiKaisu;

	@Column(name = "seikyu_nengetsu")
	private String seikyuNengetsu;
}
