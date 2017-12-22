package vn.com.nsmv.dao;

import java.util.List;

import vn.com.nsmv.entities.SMst113Entity;


/**
 * 113 master header transaction dao
 * @author NSMV
 *
 */
public interface SMst113Dao {

  /**
   * selectForlist method
   * STraYusoDao Class 
   * @return
   */
  List<SMst113Entity> selectForList(String seizoshoKbn);

  
  /**
   * selectForlist method
   * @return
   */
  List<SMst113Entity> selectByPrimaryKey(SMst113Entity mst113Entity);
  
  /**
   * Get record count
   * @return
   */
  int selectCount();
}
