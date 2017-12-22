package vn.com.nsmv.dao;

/**
 * Common data access class.
 * 
 * @author NSMV
 */
public interface NFMYCX0020_CommonDao {
  /**
   * Get bin name
   * 
   * @param binCd
   * @return
   */
  String selectBinName(String binCd);

  /**
   * Get gyosha name.
   * 
   * @param gyoshaCd
   * @return GyoshaName
   */
  String selectGyoshaName(String gyoshaCd);

  /**
   * Get himoku name.
   * 
   * @param himokuCd
   * @return HimokuName
   */
  String selectHimokuName(String himokuCd);
}
