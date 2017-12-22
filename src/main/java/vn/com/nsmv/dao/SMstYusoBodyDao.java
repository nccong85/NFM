package vn.com.nsmv.dao;

import java.util.List;

import vn.com.nsmv.bean.NFMYGX0140_Bean;
import vn.com.nsmv.entities.SMstYusoBodyEntity;

/**
 * @author TayLQ
 *
 */
/**
 * @author TayLQ
 *
 */
/**
 * @author TayLQ
 *
 */
public interface SMstYusoBodyDao {
	/**
	 * selectForlist method
	 * 
	 * @param seizoshoKbn
	 * @return List SMstYusoBodyEntity
	 */
	List<SMstYusoBodyEntity> selectForList(String seizoshoKbn);

	/**
	 * selectForlist method
	 * 
	 * @param sMstYusoBodyEntity
	 * @return List SMstYusoBodyEntity
	 */
	List<SMstYusoBodyEntity> selectForList(SMstYusoBodyEntity sMstYusoBodyEntity);

	/**
	 * selectForlist method
	 * 
	 * @param yusoMasterBody
	 * @return SMstYusoBodyEntity
	 */
	SMstYusoBodyEntity selectByPrimaryKey(SMstYusoBodyEntity sMstYusoBodyEntity);

	/**
	 * @param yusoMasterBody
	 */
	int insert(SMstYusoBodyEntity entity);

	/**
	 * updateByPrimaryKey method
	 * 
	 * @return
	 */
	boolean updateByPrimaryKey(SMstYusoBodyEntity yusoMasterBody);

	/**
	 * deleteByPrimaryKey method
	 * 
	 * @return
	 */
	boolean deleteByPrimaryKey(SMstYusoBodyEntity yusoMasterBody);

	void deleteAll();

	/**
	 * Get record count
	 * 
	 * @return
	 */
	int selectCount();
	
	
	/**
	 * selectBodyEntity
	 * @param bean
	 * @return
	 */
	SMstYusoBodyEntity selectBodyEntity(NFMYGX0140_Bean bean);
	
	/**
	 * checkHimokuCdExist
	 * @param bean
	 * @return
	 */
	boolean checkHimokuCdExist(NFMYGX0140_Bean bean);
}
