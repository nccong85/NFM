package vn.com.nsmv.dao;

import java.util.List;

import vn.com.nsmv.entities.STraErrEntity;

/**
 * Error transaction dao
 * 
 * @author NSMV
 *
 */
public interface STraErrDao {

	/**
	 * selectForlist method STraErrDao class
	 * 
	 * @return
	 */
	List<STraErrEntity> selectForList(String seizoshoKbn);

	/**
	 * selectForlist method
	 * 
	 * @return
	 */
	List<STraErrEntity> selectByPrimaryKey(STraErrEntity error);

	/**
	 * 
	 * @param error
	 * @return 
	 */
	boolean saveOrUpdate(STraErrEntity error);
	
	/**
	 * Get record count
	 * 
	 * @return
	 */
	int selectCount();
}
