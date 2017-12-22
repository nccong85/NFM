package vn.com.nsmv.bean;

import java.util.List;

/**
 * @author TayLQ create at October 10, 2016
 */
public class NFMYGX0140_Bean {

	// S_MST_YUSO_HEAD table
	private String seizoshoKbn;
	private String sojoNoBasho;
	private String sojoNoShubetsu;
	private String sojoNoOban;
	private int sojoNoRenban;
	private String shukkaDate;
	private String keiyakunoYear;
	private String keiyakunoKankatsu;
	private String keiyakunoHinshu;
	private String keiyakunoTorihiki;
	private String keiyakunoMonth;
	private String keiyakunoOban;
	private String ichijiJuyoka;
	// S_MST_A5K.USER_KANJI
	private String userKanji;
	private String shukkoBasho;
	// S_MST_A7K.SHUKKOBA_NIKKEN_KANJI
	private String nikenKaji;
	private String buppin04;
	// BKN4_KANJI.S_MST_60S
	private String bkn4Kanji;
	private String ukBasho;
	// CONCAT(S_MST_A3K.KEN_KANJI, S_MST_A3K.SIGUN_KANJI) AS UKEWATASHIBASHO
	private String a3kUkBasho;
	private String ukJoken;
	// S_MST_A9K.UKE_JOKEN_KANJI
	private String jokenKanji;
	private String binCd;
	private String tsumikomiMinato;
	private String ageMinato;
	private int daisu;
	private int juryo;
	private String tsumiaiCd;
	private int kihonYusoKyori;

	// Stand by for update
	private String headTeiseiKbn;
	private int headTeiseiKaisu;
	private String bodyTeiseiKbn;
	private int bodyTeiseiKaisu;
	private String seikyuNengetsu;

	// S_MST_YUSO_BODY table
	private String keirekiFlg;
	private String himokuCd;
	private String gyoshaCd;
	private String tankaTani;
	private int tanka;
	private int uchiwakeBaseJuryo;
	private int uchiwakeBaseKingaku;
	private int uchiwakeKutonJuryo;
	private int uchiwakeKutonKingaku;
	private int uchiwakeChoJakuJuryo;
	private int uchiwakeChojakuKingaku;
	private int uchiwakeJikangaiJuryo;
	private int uchiwakeJikagaiKingaku;
	private int uchiwakeSonotaJuryo;
	private int uchiwakeSonotaKingaku;
	private int totalJuryo;
	private int totalKingaku;
	private String teiseiRiyu;
	private String action;
	private String oldSeikyuNengetsu;
	private String oldHimokuCd;

	public List<NFMYGX0140_Bean> selectDetail;

	public String getSeizoshoKbn() {
		return seizoshoKbn;
	}

	public void setSeizoshoKbn(String seizoshoKbn) {
		this.seizoshoKbn = seizoshoKbn;
	}

	public String getSojoNoBasho() {
		return sojoNoBasho;
	}

	public void setSojoNoBasho(String sojoNoBasho) {
		this.sojoNoBasho = sojoNoBasho;
	}

	public String getSojoNoShubetsu() {
		return sojoNoShubetsu;
	}

	public void setSojoNoShubetsu(String sojoNoShubetsu) {
		this.sojoNoShubetsu = sojoNoShubetsu;
	}

	public String getSojoNoOban() {
		return sojoNoOban;
	}

	public void setSojoNoOban(String sojoNoOban) {
		this.sojoNoOban = sojoNoOban;
	}

	public int getSojoNoRenban() {
		return sojoNoRenban;
	}

	public void setSojoNoRenban(int sojoNoRenban) {
		this.sojoNoRenban = sojoNoRenban;
	}

	public String getShukkaDate() {
		return shukkaDate;
	}

	public void setShukkaDate(String shukkaDate) {
		this.shukkaDate = shukkaDate;
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

	public String getKeiyakunoTorihiki() {
		return keiyakunoTorihiki;
	}

	public void setKeiyakunoTorihiki(String keiyakunoTorihiki) {
		this.keiyakunoTorihiki = keiyakunoTorihiki;
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

	public String getUserKanji() {
		return userKanji;
	}

	public void setUserKanji(String userKanji) {
		this.userKanji = userKanji;
	}

	public String getShukkoBasho() {
		return shukkoBasho;
	}

	public void setShukkoBasho(String shukkoBasho) {
		this.shukkoBasho = shukkoBasho;
	}

	public String getNikenKaji() {
		return nikenKaji;
	}

	public void setNikenKaji(String nikenKaji) {
		this.nikenKaji = nikenKaji;
	}

	public String getBuppin04() {
		return buppin04;
	}

	public void setBuppin04(String buppin04) {
		this.buppin04 = buppin04;
	}

	public String getBkn4Kanji() {
		return bkn4Kanji;
	}

	public void setBkn4Kanji(String bkn4Kanji) {
		this.bkn4Kanji = bkn4Kanji;
	}

	public String getUkBasho() {
		return ukBasho;
	}

	public void setUkBasho(String ukBasho) {
		this.ukBasho = ukBasho;
	}

	public String getA3kUkBasho() {
		return a3kUkBasho;
	}

	public void setA3kUkBasho(String a3kUkBasho) {
		this.a3kUkBasho = a3kUkBasho;
	}

	public String getUkJoken() {
		return ukJoken;
	}

	public void setUkJoken(String ukJoken) {
		this.ukJoken = ukJoken;
	}

	public String getJokenKanji() {
		return jokenKanji;
	}

	public void setJokenKanji(String jokenKanji) {
		this.jokenKanji = jokenKanji;
	}

	public String getBinCd() {
		return binCd;
	}

	public void setBinCd(String binCd) {
		this.binCd = binCd;
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

	public int getDaisu() {
		return daisu;
	}

	public void setDaisu(int daisu) {
		this.daisu = daisu;
	}

	public int getJuryo() {
		return juryo;
	}

	public void setJuryo(int juryo) {
		this.juryo = juryo;
	}

	public String getTsumiaiCd() {
		return tsumiaiCd;
	}

	public void setTsumiaiCd(String tsumiaiCd) {
		this.tsumiaiCd = tsumiaiCd;
	}

	public int getKihonYusoKyori() {
		return kihonYusoKyori;
	}

	public void setKihonYusoKyori(int kihonYusoKyori) {
		this.kihonYusoKyori = kihonYusoKyori;
	}

	public String getHeadTeiseiKbn() {
		return headTeiseiKbn;
	}

	public void setHeadTeiseiKbn(String headTeiseiKbn) {
		this.headTeiseiKbn = headTeiseiKbn;
	}

	public int getHeadTeiseiKaisu() {
		return headTeiseiKaisu;
	}

	public void setHeadTeiseiKaisu(int headTeiseiKaisu) {
		this.headTeiseiKaisu = headTeiseiKaisu;
	}

	public String getBodyTeiseiKbn() {
		return bodyTeiseiKbn;
	}

	public void setBodyTeiseiKbn(String bodyTeiseiKbn) {
		this.bodyTeiseiKbn = bodyTeiseiKbn;
	}

	public int getBodyTeiseiKaisu() {
		return bodyTeiseiKaisu;
	}

	public void setBodyTeiseiKaisu(int bodyTeiseiKaisu) {
		this.bodyTeiseiKaisu = bodyTeiseiKaisu;
	}

	public String getSeikyuNengetsu() {
		return seikyuNengetsu;
	}

	public void setSeikyuNengetsu(String seikyuNengetsu) {
		this.seikyuNengetsu = seikyuNengetsu;
	}

	public String getHimokuCd() {
		return himokuCd;
	}

	public String getKeirekiFlg() {
		return keirekiFlg;
	}

	public void setKeirekiFlg(String keirekiFlg) {
		this.keirekiFlg = keirekiFlg;
	}

	public void setHimokuCd(String himokuCd) {
		this.himokuCd = himokuCd;
	}

	public String getGyoshaCd() {
		return gyoshaCd;
	}

	public void setGyoshaCd(String gyoshaCd) {
		this.gyoshaCd = gyoshaCd;
	}

	public String getTankaTani() {
		return tankaTani;
	}

	public void setTankaTani(String tankaTani) {
		this.tankaTani = tankaTani;
	}

	public int getTanka() {
		return tanka;
	}

	public void setTanka(int tanka) {
		this.tanka = tanka;
	}

	public int getUchiwakeBaseJuryo() {
		return uchiwakeBaseJuryo;
	}

	public void setUchiwakeBaseJuryo(int uchiwakeBaseJuryo) {
		this.uchiwakeBaseJuryo = uchiwakeBaseJuryo;
	}

	public int getUchiwakeBaseKingaku() {
		return uchiwakeBaseKingaku;
	}

	public void setUchiwakeBaseKingaku(int uchiwakeBaseKingaku) {
		this.uchiwakeBaseKingaku = uchiwakeBaseKingaku;
	}

	public int getUchiwakeKutonJuryo() {
		return uchiwakeKutonJuryo;
	}

	public void setUchiwakeKutonJuryo(int uchiwakeKutonJuryo) {
		this.uchiwakeKutonJuryo = uchiwakeKutonJuryo;
	}

	public int getUchiwakeKutonKingaku() {
		return uchiwakeKutonKingaku;
	}

	public void setUchiwakeKutonKingaku(int uchiwakeKutonKingaku) {
		this.uchiwakeKutonKingaku = uchiwakeKutonKingaku;
	}

	public int getUchiwakeChoJakuJuryo() {
		return uchiwakeChoJakuJuryo;
	}

	public void setUchiwakeChoJakuJuryo(int uchiwakeChoJakuJuryo) {
		this.uchiwakeChoJakuJuryo = uchiwakeChoJakuJuryo;
	}

	public int getUchiwakeChojakuKingaku() {
		return uchiwakeChojakuKingaku;
	}

	public void setUchiwakeChojakuKingaku(int uchiwakeChojakuKingaku) {
		this.uchiwakeChojakuKingaku = uchiwakeChojakuKingaku;
	}

	public int getUchiwakeJikangaiJuryo() {
		return uchiwakeJikangaiJuryo;
	}

	public void setUchiwakeJikangaiJuryo(int uchiwakeJikangaiJuryo) {
		this.uchiwakeJikangaiJuryo = uchiwakeJikangaiJuryo;
	}

	public int getUchiwakeJikagaiKingaku() {
		return uchiwakeJikagaiKingaku;
	}

	public void setUchiwakeJikagaiKingaku(int uchiwakeJikagaiKingaku) {
		this.uchiwakeJikagaiKingaku = uchiwakeJikagaiKingaku;
	}

	public int getUchiwakeSonotaJuryo() {
		return uchiwakeSonotaJuryo;
	}

	public void setUchiwakeSonotaJuryo(int uchiwakeSonotaJuryo) {
		this.uchiwakeSonotaJuryo = uchiwakeSonotaJuryo;
	}

	public int getUchiwakeSonotaKingaku() {
		return uchiwakeSonotaKingaku;
	}

	public void setUchiwakeSonotaKingaku(int uchiwakeSonotaKingaku) {
		this.uchiwakeSonotaKingaku = uchiwakeSonotaKingaku;
	}

	public int getTotalJuryo() {
		return totalJuryo;
	}

	public void setTotalJuryo(int totalJuryo) {
		this.totalJuryo = totalJuryo;
	}

	public int getTotalKingaku() {
		return totalKingaku;
	}

	public void setTotalKingaku(int totalKingaku) {
		this.totalKingaku = totalKingaku;
	}

	public List<NFMYGX0140_Bean> getSelectDetail() {
		return selectDetail;
	}

	public void setSelectDetail(List<NFMYGX0140_Bean> selectDetail) {
		this.selectDetail = selectDetail;
	}

	public String getTeiseiRiyu() {
		return teiseiRiyu;
	}

	public void setTeiseiRiyu(String teiseiRiyu) {
		this.teiseiRiyu = teiseiRiyu;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getOldSeikyuNengetsu() {
		return oldSeikyuNengetsu;
	}

	public void setOldSeikyuNengetsu(String oldSeikyuNengetsu) {
		this.oldSeikyuNengetsu = oldSeikyuNengetsu;
	}

	public String getOldHimokuCd() {
		return oldHimokuCd;
	}

	public void setOldHimokuCd(String oldHimokuCd) {
		this.oldHimokuCd = oldHimokuCd;
	}

}
