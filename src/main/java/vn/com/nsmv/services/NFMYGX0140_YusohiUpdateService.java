package vn.com.nsmv.services;

import vn.com.nsmv.bean.NFMYGX0140_Bean;
import vn.com.nsmv.entities.SMstYusoBodyEntity;
import vn.com.nsmv.entities.SMstYusoHeadEntity;

/**
 * @author TayLQ
 * create at October 10, 2016
 */
public interface NFMYGX0140_YusohiUpdateService {

	/**
	 * selectHeadAnBody
	 * @param seizoshoKbn
	 * @param sojoNoBasho
	 * @param sojoNoShubetsu
	 * @param sojoNoOban
	 * @return NFMYGX0140_Bean
	 */
	NFMYGX0140_Bean selectHeadAndBody(String seizoshoKbn, String sojoNoBasho, String sojoNoShubetsu, String sojoNoOban, int renban);
	
	/**
	 * saveChange
	 * @param bean
	 * @return boolean
	 */
	void saveOnHead(NFMYGX0140_Bean bean);
	
	/**
	 * @param bean
	 */
	void saveOnBody(NFMYGX0140_Bean bean, int headTeiseiKbn);
	
	/**
	 * @param bean
	 * @return
	 */
	boolean disableHimokuCd(NFMYGX0140_Bean bean);
	
	/**
	 * SelectHeadEntiy
	 * @param bean
	 * @return SMstYusoHeadEntity
	 */
	SMstYusoHeadEntity selectHeadEntity(NFMYGX0140_Bean bean);
	
	/**
	 * SelectBodyEntiy
	 * @param bean
	 * @return SMstYusoBodyEntity
	 */
	SMstYusoBodyEntity selectBodyEntity(NFMYGX0140_Bean bean);
	
	/**
	 * CheckHimokuCdExist
	 * @param seizoshoKbn
	 * @param sojonoShukkoBasho
	 * @param sojonoTorihikiShubetsu
	 * @param sojonoOban
	 * @param sojonoRenban
	 * @param keirekiFlg
	 * @return boolean
	 */
	boolean checkHimokuCdExist(NFMYGX0140_Bean bean);
	
	
	/**selectBinName
	 * @param binCd
	 * @return
	 */
	String selectBinName(String binCd);
	
	/**
	 * @param gyoshaCd
	 * @return
	 */
	String selectGyoshaName(String gyoshaCd);

	  /**
	   * Get himoku name.
	   * 
	   * @param himokuCd
	   * @return HimokuName
	   */
	  String selectHimokuName(String himokuCd);
}
