package vn.com.nsmv.dao;

import java.util.List;

import vn.com.nsmv.bean.NFMYGX0140_Bean;
import vn.com.nsmv.entities.SMstYusoHeadEntity;

/**
 * Yuso master header transaction dao
 * 
 * @author NSMV
 *
 */
public interface SMstYusoHeadDao {

	/**
	 * selectForlist method STraYusoDao Class
	 * 
	 * @return
	 */
	List<SMstYusoHeadEntity> selectForList(String seizoshoKbn);

	/**
	 * selectForlist method
	 * 
	 * @return
	 */
	List<SMstYusoHeadEntity> selectByPrimaryKey(SMstYusoHeadEntity yusoMasterHeadEntity);

	/**
	 * selectForlist method
	 * 
	 * @return
	 */
	List<SMstYusoHeadEntity> selectByPrimaryKeyOrderByTeisei(SMstYusoHeadEntity yusoMasterHeadEntity);

	/**
	 * insert method
	 * 
	 * @return
	 */
	int insert(SMstYusoHeadEntity yusoMasterHead);

	/**
	 * updateByPrimaryKey method
	 * 
	 * @return
	 */
	boolean updateByPrimaryKey(SMstYusoHeadEntity yusoMasterHead);

	/**
	 * deleteByPrimaryKey method
	 * 
	 * @return
	 */
	boolean deleteByPrimaryKey(SMstYusoHeadEntity yusoMasterHead);

	void deleteAll();

	/**
	 * Get record count
	 * 
	 * @return
	 */
	int selectCount();

	/**
	 * selectHeadEntity
	 * @param seizoshoKbn
	 * @param sojonoShukkoBasho
	 * @param sojonoTorihikiShubetsu
	 * @param sojonoOban
	 * @param sojonoRenban
	 * @param headTeiseiKbn
	 * @param headTeiseiKaisu
	 * @param seikyuNengetsu
	 * @return SMstYusoHeadEntity
	 */
	SMstYusoHeadEntity selectHeadEntity(NFMYGX0140_Bean bean);
	
	/**
	 * @param seizoshoKbn
	 * @param sojonoShukkoBasho
	 * @param sojonoTorihikiShubetsu
	 * @param sojonoOban
	 * @param sojonoRenban
	 * @return
	 */
	NFMYGX0140_Bean selectHeadAnBody(String seizoshoKbn, String sojonoShukkoBasho, String sojonoTorihikiShubetsu, String sojonoOban, int sojonoRenban);
}
