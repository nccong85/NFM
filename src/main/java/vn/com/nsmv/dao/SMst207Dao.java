package vn.com.nsmv.dao;

import java.util.List;

import vn.com.nsmv.entities.SMst207Entity;

/**
 * SMst207Dao interface
 * @author NSMV
 *
 */
public interface SMst207Dao {

  /**
   * @return
   */
  public List<SMst207Entity> selectByList(String seizoshoKbn);

  /**
   * @param seizoshoKbn
   * @param dataKbn
   * @param key1
   * @param key2
   * @return
   */
  public SMst207Entity selectByPrimaryKey(String seizoshoKbn, String dataKbn, String key1,
      String key2);
}
