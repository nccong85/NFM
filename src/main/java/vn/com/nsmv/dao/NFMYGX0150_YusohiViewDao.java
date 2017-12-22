package vn.com.nsmv.dao;

import java.util.List;

import vn.com.nsmv.bean.CommonParam;
import vn.com.nsmv.bean.NFMYGX0150_YusohiViewBodyBean;
import vn.com.nsmv.bean.NFMYGX0150_YusohiViewHeadBean;

/**
 * Select yusohi dao class.
 * 
 * @author NSMV
 */
public interface NFMYGX0150_YusohiViewDao {
  /**
   * Get head info list
   * 
   * @param param
   * @return
   */
  List<NFMYGX0150_YusohiViewHeadBean> selectHeadInfoYusohi(CommonParam param);

  /**
   * Get body info list
   * 
   * @param param
   * @return
   */
  List<NFMYGX0150_YusohiViewBodyBean> selectBodyInfoYusohi(CommonParam param);

  /**
   * Get counts bin
   * 
   * @param param
   * @return
   */
  Integer selectBinCounts(CommonParam param);
}
