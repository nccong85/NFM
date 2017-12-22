package vn.com.nsmv.services;

import vn.com.nsmv.bean.NFMYGX0120_SojoDataBean;
import vn.com.nsmv.bean.NFMYGX0120_SukkaJissekiBean;

/**
 * Add new SojoData
 * 
 * @author NSMV
 */
public interface NFMYGX0120_YusohiTorokuService {

  /**
   * Get sukka jisseki data.
   * 
   * @param sojoNo
   * @return
   */
  NFMYGX0120_SukkaJissekiBean selectSukkaJissekiInfo(String sojoNo);

  /**
   * Insert new sojo data.
   * 
   * @param sojoData
   * @throws Exception
   */
  void insertSojoData(NFMYGX0120_SojoDataBean sojoData) throws Exception;

  /**
   * Check sojoNo exits in yuso master and yuso tran.
   * 
   * @param seizoshoKbn
   * @param sojoNoSukkoBasho
   * @param sojoNoTorihikiShubetsu
   * @param sojoNoOban
   * @return checkResult
   */
  boolean isExist(String seizoshoKbn, String sojoNo);

  /**
   * Get bin name.
   * 
   * @param binCd
   * @return bin name
   */
  String selectBinName(String binCd);

  /**
   * Get gyosha name.
   * 
   * @param gyoshaCd
   * @return gyosha name
   */
  String selectGyoshaName(String gyoshaCd);
}
