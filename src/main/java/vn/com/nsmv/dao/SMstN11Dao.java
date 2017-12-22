package vn.com.nsmv.dao;

import java.util.List;

import vn.com.nsmv.entities.SMstN11Entity;

/**
 * @author NSMV
 *
 */
public interface SMstN11Dao {

  /**
   * @return
   */
  public List<SMstN11Entity> selectByList(String seizoshoKbn);

  /**
   * @param entity SMst208Entity
   * @return List <SMst208Entity>
   */
  public List<SMstN11Entity> selectByPrimaryKey(SMstN11Entity entity);
}
