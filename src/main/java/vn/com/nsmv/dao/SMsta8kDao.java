package vn.com.nsmv.dao;

/**
 * SMsta8kDao class.
 * 
 * @author NSMV
 */
public interface SMsta8kDao {

  /**
   * Get gyosha name.
   * 
   * @param gyoshaCd
   * @return GyoshaName
   */
  String selectGyoshaName(String gyoshaCd);
}
