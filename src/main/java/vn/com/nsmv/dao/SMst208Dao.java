package vn.com.nsmv.dao;

import java.util.List;

import vn.com.nsmv.entities.SMst208Entity;

/**
 * SMst207Dao interface
 * @author NSMV
 *
 */
public interface SMst208Dao {

  /**
   * @return
   */
  public List<SMst208Entity> selectByList(String seizoshoKbn);

  /**
   * @param entity SMst208Entity
   * @return List <SMst208Entity>
   */
  public List<SMst208Entity> selectByPrimaryKey(SMst208Entity entity);
}
