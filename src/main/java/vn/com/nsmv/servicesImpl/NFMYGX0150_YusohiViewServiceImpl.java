package vn.com.nsmv.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.nsmv.bean.CommonParam;
import vn.com.nsmv.bean.NFMYGX0150_MultiBinView;
import vn.com.nsmv.bean.NFMYGX0150_SingleBinView;
import vn.com.nsmv.bean.NFMYGX0150_YusohiGokeiBean;
import vn.com.nsmv.bean.NFMYGX0150_YusohiViewBodyBean;
import vn.com.nsmv.bean.NFMYGX0150_YusohiViewHeadBean;
import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.common.NumberUtil;
import vn.com.nsmv.dao.NFMYCX0020_CommonDao;
import vn.com.nsmv.daoImpl.NFMYGX0150_YusohiViewDaoImpl;
import vn.com.nsmv.services.NFMYGX0150_YusohiViewService;

/**
 * NFMYGX0150_YusohiViewServiceImpl class
 * 
 * @author NSMV
 */
@Service
public class NFMYGX0150_YusohiViewServiceImpl implements NFMYGX0150_YusohiViewService {

  /**
   * yusohiViewDao
   */
  @Autowired
  NFMYGX0150_YusohiViewDaoImpl yusohiViewDao;

  /**
   * nfmycx0020CommonDao
   */
  @Autowired
  NFMYCX0020_CommonDao nfmycx0020CommonDao;

  /**
   * BIN Constant
   */
  private static final String BIN = "便";

  /*
   * (non-Javadoc)
   * 
   * @see vn.com.nsmv.services.NFMYGX0150_YusohiViewService#selectMultiBinYusohi(vn.com.nsmv.bean.
   * CommonParam)
   */
  @Override
  public NFMYGX0150_MultiBinView selectMultiBinYusohi(CommonParam param) throws Exception {
    NFMYGX0150_MultiBinView multiBinYusohi = new NFMYGX0150_MultiBinView();
    NFMYGX0150_YusohiGokeiBean gokeiBean = new NFMYGX0150_YusohiGokeiBean();
    Integer binCounter = param.getBinCounter();

    for (int i = 0; i < binCounter; i++) {
      param.setSojoNoRenban(i);
      this.selectYusohiByRenban(param, multiBinYusohi, gokeiBean);
    }

    // Caculate sum juryo
    gokeiBean.setGokeiJuryo(gokeiBean.getJuryo1() + gokeiBean.getJuryo2() + gokeiBean.getJuryo3()
        + gokeiBean.getJuryo4() + gokeiBean.getJuryo5());

    // Caculate sum kingaku
    gokeiBean.setGokeiKingaku(gokeiBean.getKingaku1() + gokeiBean.getKingaku2() + gokeiBean.getKingaku3()
        + gokeiBean.getKingaku4() + gokeiBean.getKingaku5());

    multiBinYusohi.setHeadInfoSum(gokeiBean);

    return multiBinYusohi;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * vn.com.nsmv.services.NFMYGX0150_YusohiViewService#getBinCounter(vn.com.nsmv.bean.CommonParam)
   */
  @Override
  public Integer getBinCounter(CommonParam param) throws Exception {
    return yusohiViewDao.selectBinCounts(param);
  }

  /*
   * (non-Javadoc)
   * 
   * @see vn.com.nsmv.services.NFMYGX0150_YusohiViewService#selectSingleBinYusohi(vn.com.nsmv.bean.
   * CommonParam)
   */
  @Override
  public NFMYGX0150_SingleBinView selectSingleBinYusohi(CommonParam param) throws Exception {

    NFMYGX0150_SingleBinView singleBinYusohi = new NFMYGX0150_SingleBinView();

    // Get head info list
    List<NFMYGX0150_YusohiViewHeadBean> headInfoList = yusohiViewDao.selectHeadInfoYusohi(param);

    // Set bin name
    this.setBinName(headInfoList);

    // Get body info list
    List<NFMYGX0150_YusohiViewBodyBean> bodyInfoList = yusohiViewDao.selectBodyInfoYusohi(param);

    // Set himoku name
    this.setHimokuName(bodyInfoList);

    // Set gyosha name
    this.setGyoshaName(bodyInfoList);

    this.sumKingakuToHead(headInfoList, bodyInfoList);

    singleBinYusohi.setHeadInfoList(headInfoList);
    singleBinYusohi.setBodyInfoList(bodyInfoList);

    return singleBinYusohi;
  }

  /**
   * Setting value to bean.
   * 
   * @param param
   * @param bean
   */
  private void selectYusohiByRenban(CommonParam param, NFMYGX0150_MultiBinView bean,
      NFMYGX0150_YusohiGokeiBean gokeiBean) {
    List<NFMYGX0150_YusohiViewHeadBean> headInfoList;
    List<NFMYGX0150_YusohiViewBodyBean> bodyInfoList;
    headInfoList = yusohiViewDao.selectHeadInfoYusohi(param);

    if (headInfoList.size() > 0) {
      // Set bin name
      this.setBinName(headInfoList);

      // Call dao method
      bodyInfoList = yusohiViewDao.selectBodyInfoYusohi(param);
      // Caculate kingaku on head
      this.sumKingakuToHead(headInfoList, bodyInfoList);

      // Set himoku name
      this.setHimokuName(bodyInfoList);

      // Set gyosha name
      this.setGyoshaName(bodyInfoList);

      switch (param.getSojoNoRenban()) {
      case 0: {
        bean.setBinCd1(headInfoList.get(0).getBincd().concat(BIN));
        bean.setHeadInfoList1(headInfoList);
        bean.setBodyInfoList1(bodyInfoList);

        for (int i = 0; i < headInfoList.size(); i++) {
          NFMYGX0150_YusohiViewHeadBean temp = headInfoList.get(i);
          if (temp.getKeirikiFlg().equals(BusinessConst.CodeDef.NumberValue.ZERO)) {
            gokeiBean.setBinCd1(temp.getBincd());
            gokeiBean.setJuryo1(temp.getJuryo());
            gokeiBean.setKingaku1(temp.getKingaku());
          }
        }
        break;
      }

      case 1: {
        bean.setBinCd2(headInfoList.get(0).getBincd().concat(BIN));
        bean.setHeadInfoList2(headInfoList);
        bean.setBodyInfoList2(bodyInfoList);

        for (int i = 0; i < headInfoList.size(); i++) {
          NFMYGX0150_YusohiViewHeadBean temp = headInfoList.get(i);
          if (temp.getKeirikiFlg().equals(BusinessConst.CodeDef.NumberValue.ZERO)) {
            gokeiBean.setBinCd2(temp.getBincd());
            gokeiBean.setJuryo2(temp.getJuryo());
            gokeiBean.setKingaku2(temp.getKingaku());
          }
        }

        break;
      }

      case 2: {
        bean.setBinCd3(headInfoList.get(0).getBincd().concat(BIN));
        bean.setHeadInfoList3(headInfoList);
        bean.setBodyInfoList3(bodyInfoList);

        for (int i = 0; i < headInfoList.size(); i++) {
          NFMYGX0150_YusohiViewHeadBean temp = headInfoList.get(i);
          if (temp.getKeirikiFlg().equals(BusinessConst.CodeDef.NumberValue.ZERO)) {
            gokeiBean.setBinCd1(temp.getBincd());
            gokeiBean.setJuryo3(temp.getJuryo());
            gokeiBean.setKingaku3(temp.getKingaku());
          }
        }
        break;
      }

      case 3: {
        bean.setBinCd4(headInfoList.get(0).getBincd().concat(BIN));
        bean.setHeadInfoList4(headInfoList);
        bean.setBodyInfoList4(bodyInfoList);

        for (int i = 0; i < headInfoList.size(); i++) {
          NFMYGX0150_YusohiViewHeadBean temp = headInfoList.get(i);
          if (temp.getKeirikiFlg().equals(BusinessConst.CodeDef.NumberValue.ZERO)) {
            gokeiBean.setBinCd1(temp.getBincd());
            gokeiBean.setJuryo4(temp.getJuryo());
            gokeiBean.setKingaku4(temp.getKingaku());
          }
        }
        break;
      }

      case 4: {
        bean.setBinCd5(headInfoList.get(0).getBincd().concat(BIN));
        bean.setHeadInfoList5(headInfoList);
        bean.setBodyInfoList5(bodyInfoList);

        for (int i = 0; i < headInfoList.size(); i++) {
          NFMYGX0150_YusohiViewHeadBean temp = headInfoList.get(i);
          if (temp.getKeirikiFlg().equals(BusinessConst.CodeDef.NumberValue.ZERO)) {
            gokeiBean.setBinCd1(temp.getBincd());
            gokeiBean.setJuryo5(temp.getJuryo());
            gokeiBean.setKingaku5(temp.getKingaku());
          }
        }
        break;
      }
      }
    } else {
      switch (param.getSojoNoRenban()) {
      case 0: {
        bean.setBinCd1(BusinessConst.CodeDef.CheckSpace.BLANK);
        break;
      }

      case 1: {
        bean.setBinCd2(BusinessConst.CodeDef.CheckSpace.BLANK);
        break;
      }

      case 2: {
        bean.setBinCd3(BusinessConst.CodeDef.CheckSpace.BLANK);
        break;
      }

      case 3: {
        bean.setBinCd4(BusinessConst.CodeDef.CheckSpace.BLANK);
        break;
      }

      case 4: {
        bean.setBinCd5(BusinessConst.CodeDef.CheckSpace.BLANK);
        break;
      }
      }
    }
  }

  /**
   * Caculate kingaku to head info.
   * 
   * @param headInfoList
   * @param bodyInfoList
   */
  private void sumKingakuToHead(List<NFMYGX0150_YusohiViewHeadBean> headInfoList,
      List<NFMYGX0150_YusohiViewBodyBean> bodyInfoList) {
    for (int i = 0; i < headInfoList.size(); i++) {
      NFMYGX0150_YusohiViewHeadBean thead1 = headInfoList.get(i);
      int sumKingaku = 0;
      for (int j = 0; j < bodyInfoList.size(); j++) {
        NFMYGX0150_YusohiViewBodyBean tbody1 = bodyInfoList.get(j);
        if (tbody1.getHeadTeiseiKaisu().equals(thead1.getHeadTeiseiKaisu())
            && tbody1.getHeadTeiseiKbn().equals(thead1.getHeadTeiseiKbn())
            && tbody1.getBodyKeirikiFlag().equals(thead1.getKeirikiFlg())) {
          sumKingaku += NumberUtil.nullToZero(tbody1.getKingaku());
        }
      }
      thead1.setKingaku(sumKingaku);
    }
  }

  /**
   * Set bin name
   * 
   * @param headInfoList
   */
  private void setBinName(List<NFMYGX0150_YusohiViewHeadBean> headInfoList) {
    String binCd = "";
    String binName = "";

    // Get bin name
    for (int i = 0; i < headInfoList.size(); i++) {
      if (!binCd.equals(headInfoList.get(i).getBincd())) {
        binName = nfmycx0020CommonDao.selectBinName(headInfoList.get(i).getBincd());
      }
      binCd = headInfoList.get(i).getBincd();
      headInfoList.get(i).setBincdName(binName);
    }
  }

  /**
   * Set himoku name
   * 
   * @param bodyInfoList
   */
  private void setHimokuName(List<NFMYGX0150_YusohiViewBodyBean> bodyInfoList) {
    String himokuCd = "";
    String himokuName = "";

    // Get bin name
    for (int i = 0; i < bodyInfoList.size(); i++) {
      if (!himokuCd.equals(bodyInfoList.get(i).getHimokucd())) {
        himokuName = nfmycx0020CommonDao.selectHimokuName(bodyInfoList.get(i).getHimokucd());
      }
      himokuCd = bodyInfoList.get(i).getHimokucd();
      bodyInfoList.get(i).setHimokuName(himokuName);
    }
  }

  /**
   * Set gyosha name
   * 
   * @param bodyInfoList
   */
  private void setGyoshaName(List<NFMYGX0150_YusohiViewBodyBean> bodyInfoList) {
    String gyoshaCd = "";
    String gyoshaName = "";

    // Get bin name
    for (int i = 0; i < bodyInfoList.size(); i++) {
      if (!gyoshaCd.equals(bodyInfoList.get(i).getGyoshaCd())) {
        gyoshaName = nfmycx0020CommonDao.selectGyoshaName(bodyInfoList.get(i).getGyoshaCd());
      }
      gyoshaCd = bodyInfoList.get(i).getGyoshaCd();
      bodyInfoList.get(i).setGyoshaName(gyoshaName);
    }
  }
}
