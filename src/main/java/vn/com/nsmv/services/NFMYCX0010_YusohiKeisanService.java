package vn.com.nsmv.services;

import java.util.List;

import vn.com.nsmv.bean.NFMYCX0010_YusoMasterForTest;
import vn.com.nsmv.bean.NFMYCX0010_YusoTranSearchBean;
import vn.com.nsmv.entities.STraYusoEntity;;

public interface NFMYCX0010_YusohiKeisanService {

	/**
	 * @return
	 */
	public NFMYCX0010_YusoMasterForTest caculateAll();

	/**
	 * @param yusoTranSearch
	 * @return
	 */
	public List<STraYusoEntity> list(NFMYCX0010_YusoTranSearchBean yusoTranSearch);

	/**
	 * @return
	 */
	public Long count();

	/**
	 * Delete from YusoTran
	 * 
	 * @param yusoTran
	 * @return
	 */
	public boolean delete(STraYusoEntity yusoTran);

	/**
	 * Delete from Yuso Master Head and Yuso Master Body.
	 * 
	 * @param yusoTran
	 * @return
	 */
	public void deleteAll();

	/**
	 * @param yusoTran
	 * @return
	 */
	public boolean saveOrUpdate(STraYusoEntity yusoTran);

}
