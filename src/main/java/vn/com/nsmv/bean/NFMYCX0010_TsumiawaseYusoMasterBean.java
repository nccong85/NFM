package vn.com.nsmv.bean;

public class NFMYCX0010_TsumiawaseYusoMasterBean {
	// 出荷年月日
	private String shukkaDate = "";
	// 業者コード
	private String gyoshacd = "";
	// 積合コード
	private String tsumiaicd = "";
	// 便コード
	private String bincd = "";
	// 費目コード
	private String himokucd = "";

	private NFMYCX0010_YusoMasterHeadBean yusoMasterHeadBean = null;
	private NFMYCX0010_YusoMasterBodyBean yusoMasterBodyBean = null;

	public String getShukkaDate() {
		return shukkaDate;
	}

	public void setShukkaDate(String shukkaDate) {
		this.shukkaDate = shukkaDate;
	}

	public String getGyoshacd() {
		return gyoshacd;
	}

	public void setGyoshacd(String gyoshacd) {
		this.gyoshacd = gyoshacd;
	}

	public String getTsumiaicd() {
		return tsumiaicd;
	}

	public void setTsumiaicd(String tsumiaicd) {
		this.tsumiaicd = tsumiaicd;
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

	public NFMYCX0010_YusoMasterHeadBean getYusoMasterHeadBean() {
		return yusoMasterHeadBean;
	}

	public void setYusoMasterHeadBean(NFMYCX0010_YusoMasterHeadBean yusoMasterHeadBean) {
		this.yusoMasterHeadBean = yusoMasterHeadBean;
	}

	public NFMYCX0010_YusoMasterBodyBean getYusoMasterBodyBean() {
		return yusoMasterBodyBean;
	}

	public void setYusoMasterBodyBean(NFMYCX0010_YusoMasterBodyBean yusoMasterBodyBean) {
		this.yusoMasterBodyBean = yusoMasterBodyBean;
	}

}
