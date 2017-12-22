package vn.com.nsmv.dao;

import java.util.List;

import vn.com.nsmv.entities.SMst210TankaEntity;

public interface SMst210TankaDao {
  /**
   * Search in SMst210KihonEntity
   * @return
   */
  public List<SMst210TankaEntity> selectByList(String seizoshoKbn);


  /**
   * Search in SMst210KihonEntity
   * @param SMst210KihonEntity
   * @return SMst210KihonEntity
   */
  public List<SMst210TankaEntity> selectByPrimaryKey(SMst210TankaEntity entity);

}
