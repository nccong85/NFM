package vn.com.nsmv.bean;

import java.util.List;

import vn.com.nsmv.entities.SMstYusoBodyEntity;
import vn.com.nsmv.entities.SMstYusoHeadEntity;

public class NFMYCX0010_YusoMasterForTest {
	private List<SMstYusoHeadEntity> yusoMasterHeadList = null;
	private List<SMstYusoBodyEntity> yusoMasterBodyList = null;
	private List<NFMYCX0010_YusoMasterBodyBean> yusoMasterBodyListAnbun = null;

	public List<SMstYusoHeadEntity> getYusoMasterHeadList() {
		return yusoMasterHeadList;
	}

	public void setYusoMasterHeadList(List<SMstYusoHeadEntity> yusoMasterHeadList) {
		this.yusoMasterHeadList = yusoMasterHeadList;
	}

	public List<SMstYusoBodyEntity> getYusoMasterBodyList() {
		return yusoMasterBodyList;
	}

	public void setYusoMasterBodyList(List<SMstYusoBodyEntity> yusoMasterBodyList) {
		this.yusoMasterBodyList = yusoMasterBodyList;
	}

	public List<NFMYCX0010_YusoMasterBodyBean> getYusoMasterBodyListAnbun() {
		return yusoMasterBodyListAnbun;
	}

	public void setYusoMasterBodyListAnbun(List<NFMYCX0010_YusoMasterBodyBean> yusoMasterBodyListAnbun) {
		this.yusoMasterBodyListAnbun = yusoMasterBodyListAnbun;
	}
}
