package vn.com.nsmv.services;

import vn.com.nsmv.bean.CommonParam;
import vn.com.nsmv.bean.NFMYGX0150_MultiBinView;
import vn.com.nsmv.bean.NFMYGX0150_SingleBinView;

/**
 * Get yusohi service class.
 * 
 * @author NSMV
 */
public interface NFMYGX0150_YusohiViewService {

  /**
   * Get multi bin yusohi
   * 
   * @param param
   * @return
   * @throws Exception
   */
  NFMYGX0150_MultiBinView selectMultiBinYusohi(CommonParam param) throws Exception;

  /**
   * Get sing le bin yusohi
   * 
   * @param param
   * @return
   * @throws Exception
   */
  NFMYGX0150_SingleBinView selectSingleBinYusohi(CommonParam param) throws Exception;

  /**
   * Get bin counter.
   * 
   * @param param
   * @return
   * @throws Exception
   */
  Integer getBinCounter(CommonParam param) throws Exception;
}
