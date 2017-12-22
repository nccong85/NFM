package vn.com.nsmv.dao;

import java.util.List;

import vn.com.nsmv.entities.SMst210KihonEntity;;

/**
 * SMst210KihonDao interface
 * @author NSMV
 *
 */
public interface SMst210KihonDao {

  /**
   * Search in SMst210KihonEntity
   * @return
   */
  public List<SMst210KihonEntity> selectByList(String seizoshoKbn);


  /**
   * Search in SMst210KihonEntity
   * @param SMst210KihonEntity
   * @return SMst210KihonEntity
   */
  public List<SMst210KihonEntity> selectByPrimaryKey(SMst210KihonEntity entity);
}
