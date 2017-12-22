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
@Table(name = "s_mst_yuso_head")
@IdClass(YusoMasterHead_Pk.class)
public class SMstYusoHeadEntity {

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
	private String seikyuNengetsu;

	public String getSeikyuNengetsu() {
		return seikyuNengetsu;
	}

	public void setSeikyuNengetsu(String seikyuNengetsu) {
		this.seikyuNengetsu = seikyuNengetsu;
	}

	@Column(name = "head_teisei_riyu")
	private String headTeiseiRiyu;

	@Column(name = "bincd")
	private String binCd;

	@Column(name = "shukka_date")
	private String shukkaDate;

	@Column(name = "shukko_basho")
	private String shukkoBasho;

	@Column(name = "ukewatashi_basho")
	private String ukewatashiBasho;

	@Column(name = "ukewatashi_joken")
	private String ukewatashiJoken;

	@Column(name = "kihon_yuso_kyori")
	private Integer kihonYusoKyori;

	@Column(name = "reigai_yuso")
	private Integer reigaiYuso;

	@Column(name = "juryo")
	private Integer juryo;

	@Column(name = "tonkiro")
	private Integer tonkiro;

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

	@Column(name = "headno")
	private String headNo;

	@Column(name = "teikino")
	private String teikiNo;

	@Column(name = "buppin04")
	private String buppin04;

	@Column(name = "shaban")
	private String shaban;

	@Column(name = "hcarno")
	private String hcarNo;

	@Column(name = "tsumiai_flg")
	private String tsumiaiFlg;

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

	public String getHeadTeiseiRiyu() {
		return headTeiseiRiyu;
	}

	public void setHeadTeiseiRiyu(String headTeiseiRiyu) {
		this.headTeiseiRiyu = headTeiseiRiyu;
	}

	public String getBinCd() {
		return binCd;
	}

	public void setBinCd(String binCd) {
		this.binCd = binCd;
	}

	public String getShukkaDate() {
		return shukkaDate;
	}

	public void setShukkaDate(String shukkaDate) {
		this.shukkaDate = shukkaDate;
	}

	public String getShukkoBasho() {
		return shukkoBasho;
	}

	public void setShukkoBasho(String shukkoBasho) {
		this.shukkoBasho = shukkoBasho;
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

	public Integer getKihonYusoKyori() {
		return kihonYusoKyori;
	}

	public void setKihonYusoKyori(Integer kihonYusoKyori) {
		this.kihonYusoKyori = kihonYusoKyori;
	}

	public Integer getReigaiYuso() {
		return reigaiYuso;
	}

	public void setReigaiYuso(Integer reigaiYuso) {
		this.reigaiYuso = reigaiYuso;
	}

	public Integer getJuryo() {
		return juryo;
	}

	public void setJuryo(Integer juryo) {
		this.juryo = juryo;
	}

	public Integer getTonkiro() {
		return tonkiro;
	}

	public void setTonkiro(Integer tonkiro) {
		this.tonkiro = tonkiro;
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

	public String getHeadNo() {
		return headNo;
	}

	public void setHeadNo(String headNo) {
		this.headNo = headNo;
	}

	public String getTeikiNo() {
		return teikiNo;
	}

	public void setTeikiNo(String teikiNo) {
		this.teikiNo = teikiNo;
	}

	public String getBuppin04() {
		return buppin04;
	}

	public void setBuppin04(String buppin04) {
		this.buppin04 = buppin04;
	}

	public String getShaban() {
		return shaban;
	}

	public void setShaban(String shaban) {
		this.shaban = shaban;
	}

	public String getHcarNo() {
		return hcarNo;
	}

	public void setHcarNo(String hcarNo) {
		this.hcarNo = hcarNo;
	}

	public String getTsumiaiFlg() {
		return tsumiaiFlg;
	}

	public void setTsumiaiFlg(String tsumiaiFlg) {
		this.tsumiaiFlg = tsumiaiFlg;
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
		result = prime * result + ((binCd == null) ? 0 : binCd.hashCode());
		result = prime * result + ((buppin04 == null) ? 0 : buppin04.hashCode());
		result = prime * result + ((hcarNo == null) ? 0 : hcarNo.hashCode());
		result = prime * result + ((headNo == null) ? 0 : headNo.hashCode());
		result = prime * result + ((headTeiseiKaisu == null) ? 0 : headTeiseiKaisu.hashCode());
		result = prime * result + ((headTeiseiKbn == null) ? 0 : headTeiseiKbn.hashCode());
		result = prime * result + ((headTeiseiRiyu == null) ? 0 : headTeiseiRiyu.hashCode());
		result = prime * result + ((ichijiJuyoka == null) ? 0 : ichijiJuyoka.hashCode());
		result = prime * result + ((juryo == null) ? 0 : juryo.hashCode());
		result = prime * result + ((keirekiFlg == null) ? 0 : keirekiFlg.hashCode());
		result = prime * result + ((keiyakunoHinshu == null) ? 0 : keiyakunoHinshu.hashCode());
		result = prime * result + ((keiyakunoKankatsu == null) ? 0 : keiyakunoKankatsu.hashCode());
		result = prime * result + ((keiyakunoMonth == null) ? 0 : keiyakunoMonth.hashCode());
		result = prime * result + ((keiyakunoOban == null) ? 0 : keiyakunoOban.hashCode());
		result = prime * result + ((keiyakunoTorihikiShubetsu == null) ? 0 : keiyakunoTorihikiShubetsu.hashCode());
		result = prime * result + ((keiyakunoYear == null) ? 0 : keiyakunoYear.hashCode());
		result = prime * result + ((kihonYusoKyori == null) ? 0 : kihonYusoKyori.hashCode());
		result = prime * result + ((koshinDate == null) ? 0 : koshinDate.hashCode());
		result = prime * result + ((koshinsha == null) ? 0 : koshinsha.hashCode());
		result = prime * result + ((reigaiYuso == null) ? 0 : reigaiYuso.hashCode());
		result = prime * result + ((seikyuNengetsu == null) ? 0 : seikyuNengetsu.hashCode());
		result = prime * result + ((seizoshoKbn == null) ? 0 : seizoshoKbn.hashCode());
		result = prime * result + ((shaban == null) ? 0 : shaban.hashCode());
		result = prime * result + ((shukkaDate == null) ? 0 : shukkaDate.hashCode());
		result = prime * result + ((shukkoBasho == null) ? 0 : shukkoBasho.hashCode());
		result = prime * result + ((sojonoOban == null) ? 0 : sojonoOban.hashCode());
		result = prime * result + ((sojonoRenban == null) ? 0 : sojonoRenban.hashCode());
		result = prime * result + ((sojonoShukkoBasho == null) ? 0 : sojonoShukkoBasho.hashCode());
		result = prime * result + ((sojonoTorihikiShubetsu == null) ? 0 : sojonoTorihikiShubetsu.hashCode());
		result = prime * result + ((teikiNo == null) ? 0 : teikiNo.hashCode());
		result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
		result = prime * result + ((tonkiro == null) ? 0 : tonkiro.hashCode());
		result = prime * result + ((torokuDate == null) ? 0 : torokuDate.hashCode());
		result = prime * result + ((torokusha == null) ? 0 : torokusha.hashCode());
		result = prime * result + ((tsumiaiFlg == null) ? 0 : tsumiaiFlg.hashCode());
		result = prime * result + ((ukewatashiBasho == null) ? 0 : ukewatashiBasho.hashCode());
		result = prime * result + ((ukewatashiJoken == null) ? 0 : ukewatashiJoken.hashCode());
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
		SMstYusoHeadEntity other = (SMstYusoHeadEntity) obj;
		if (binCd == null) {
			if (other.binCd != null)
				return false;
		} else if (!binCd.equals(other.binCd))
			return false;
		if (buppin04 == null) {
			if (other.buppin04 != null)
				return false;
		} else if (!buppin04.equals(other.buppin04))
			return false;
		if (hcarNo == null) {
			if (other.hcarNo != null)
				return false;
		} else if (!hcarNo.equals(other.hcarNo))
			return false;
		if (headNo == null) {
			if (other.headNo != null)
				return false;
		} else if (!headNo.equals(other.headNo))
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
		if (headTeiseiRiyu == null) {
			if (other.headTeiseiRiyu != null)
				return false;
		} else if (!headTeiseiRiyu.equals(other.headTeiseiRiyu))
			return false;
		if (ichijiJuyoka == null) {
			if (other.ichijiJuyoka != null)
				return false;
		} else if (!ichijiJuyoka.equals(other.ichijiJuyoka))
			return false;
		if (juryo == null) {
			if (other.juryo != null)
				return false;
		} else if (!juryo.equals(other.juryo))
			return false;
		if (keirekiFlg == null) {
			if (other.keirekiFlg != null)
				return false;
		} else if (!keirekiFlg.equals(other.keirekiFlg))
			return false;
		if (keiyakunoHinshu == null) {
			if (other.keiyakunoHinshu != null)
				return false;
		} else if (!keiyakunoHinshu.equals(other.keiyakunoHinshu))
			return false;
		if (keiyakunoKankatsu == null) {
			if (other.keiyakunoKankatsu != null)
				return false;
		} else if (!keiyakunoKankatsu.equals(other.keiyakunoKankatsu))
			return false;
		if (keiyakunoMonth == null) {
			if (other.keiyakunoMonth != null)
				return false;
		} else if (!keiyakunoMonth.equals(other.keiyakunoMonth))
			return false;
		if (keiyakunoOban == null) {
			if (other.keiyakunoOban != null)
				return false;
		} else if (!keiyakunoOban.equals(other.keiyakunoOban))
			return false;
		if (keiyakunoTorihikiShubetsu == null) {
			if (other.keiyakunoTorihikiShubetsu != null)
				return false;
		} else if (!keiyakunoTorihikiShubetsu.equals(other.keiyakunoTorihikiShubetsu))
			return false;
		if (keiyakunoYear == null) {
			if (other.keiyakunoYear != null)
				return false;
		} else if (!keiyakunoYear.equals(other.keiyakunoYear))
			return false;
		if (kihonYusoKyori == null) {
			if (other.kihonYusoKyori != null)
				return false;
		} else if (!kihonYusoKyori.equals(other.kihonYusoKyori))
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
		if (reigaiYuso == null) {
			if (other.reigaiYuso != null)
				return false;
		} else if (!reigaiYuso.equals(other.reigaiYuso))
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
		if (shaban == null) {
			if (other.shaban != null)
				return false;
		} else if (!shaban.equals(other.shaban))
			return false;
		if (shukkaDate == null) {
			if (other.shukkaDate != null)
				return false;
		} else if (!shukkaDate.equals(other.shukkaDate))
			return false;
		if (shukkoBasho == null) {
			if (other.shukkoBasho != null)
				return false;
		} else if (!shukkoBasho.equals(other.shukkoBasho))
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
		if (teikiNo == null) {
			if (other.teikiNo != null)
				return false;
		} else if (!teikiNo.equals(other.teikiNo))
			return false;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		if (tonkiro == null) {
			if (other.tonkiro != null)
				return false;
		} else if (!tonkiro.equals(other.tonkiro))
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
		if (tsumiaiFlg == null) {
			if (other.tsumiaiFlg != null)
				return false;
		} else if (!tsumiaiFlg.equals(other.tsumiaiFlg))
			return false;
		if (ukewatashiBasho == null) {
			if (other.ukewatashiBasho != null)
				return false;
		} else if (!ukewatashiBasho.equals(other.ukewatashiBasho))
			return false;
		if (ukewatashiJoken == null) {
			if (other.ukewatashiJoken != null)
				return false;
		} else if (!ukewatashiJoken.equals(other.ukewatashiJoken))
			return false;
		return true;
	}

}

@Embeddable
class YusoMasterHead_Pk implements Serializable {

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

	@Column(name = "seikyu_nengetsu")
	private String seikyuNengetsu;

}
