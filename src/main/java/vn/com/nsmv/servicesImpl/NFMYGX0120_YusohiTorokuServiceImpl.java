package vn.com.nsmv.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.nsmv.bean.NFMYGX0100_SearchBean;
import vn.com.nsmv.bean.NFMYGX0100_SearchResultBean;
import vn.com.nsmv.bean.NFMYGX0120_SojoDataBean;
import vn.com.nsmv.bean.NFMYGX0120_SukkaJissekiBean;
import vn.com.nsmv.common.BusinessCommonUtil;
import vn.com.nsmv.common.DateUtil;
import vn.com.nsmv.common.NumberUtil;
import vn.com.nsmv.common.StringUtil;
import vn.com.nsmv.dao.NFMYCX0020_CommonDao;
import vn.com.nsmv.dao.NFMYGX0100_YusohiSearchDao;
import vn.com.nsmv.dao.SShkaSeiDao;
import vn.com.nsmv.dao.STraYusoDao;
import vn.com.nsmv.entities.STraYusoEntity;
import vn.com.nsmv.services.NFMYGX0120_YusohiTorokuService;

@Service
public class NFMYGX0120_YusohiTorokuServiceImpl implements NFMYGX0120_YusohiTorokuService {

  private static final Logger logger = Logger.getLogger(NFMYGX0120_YusohiTorokuServiceImpl.class);

  private static final int RENBAN_0 = 0;

  @Autowired
  SShkaSeiDao sukkaJissekiDao;

  @Autowired
  NFMYCX0020_CommonDao nfmycx0020CommonDao;

  @Autowired
  STraYusoDao yusoTranDao;

  @Autowired
  NFMYGX0100_YusohiSearchDao yusohiSearchDao;

  /*
   * (non-Javadoc)
   * 
   * @see vn.com.nsmv.services.NFMYGX0120_YusohiTorokuService#
   * selectSukkaJissekiInfo(java.lang.String)
   */
  @Override
  public NFMYGX0120_SukkaJissekiBean selectSukkaJissekiInfo(String sojoNo) {
    NFMYGX0120_SukkaJissekiBean sukkaJisseki = null;
    try {
      sukkaJisseki = sukkaJissekiDao.selectSojoNo(sojoNo);

    } catch (Exception ex) {
      logger.error(ex.getMessage());
      sukkaJisseki = new NFMYGX0120_SukkaJissekiBean();
    }
    return sukkaJisseki;
  }

  /*
   * (non-Javadoc)
   * 
   * @see vn.com.nsmv.services.NFMYGX0120_YusohiTorokuService#insertSojoData(vn.com
   * .nsmv.bean.NFMYGX0120_SojoDataBean)
   */
  @Override
  public void insertSojoData(NFMYGX0120_SojoDataBean sojoData) throws Exception {
    int renban = 0;

    String sojoNoSukkoBasho = StringUtil.subString(sojoData.getSojoNo(), 0, 3);
    String sojoNoTorihikiShubetsu = StringUtil.subString(sojoData.getSojoNo(), 3, 1);
    String sojoNoOban = StringUtil.subString(sojoData.getSojoNo(), 4, 5);

    // Copy properties
    STraYusoEntity yusoTranEntity = new STraYusoEntity();
    BeanUtils.copyProperties(sojoData, yusoTranEntity);

    // Setting item not mapping
    // Setting SojoNo
    yusoTranEntity.setSojonoShukkoBasho(sojoNoSukkoBasho);
    yusoTranEntity.setSojonoTorihikiShubetsu(sojoNoTorihikiShubetsu);
    yusoTranEntity.setSojonoOban(sojoNoOban);

    // Seting SukkaDate
    yusoTranEntity.setShukkaDate(BusinessCommonUtil.removeSlash(sojoData.getSukkaDate()));

    // Setting KeiyakuNo
    yusoTranEntity.setKeiyakunoYear(StringUtil.subString(sojoData.getKeiyakuNo(), 0, 1));
    yusoTranEntity.setKeiyakunoKankatsu(StringUtil.subString(sojoData.getKeiyakuNo(), 1, 2));
    yusoTranEntity.setKeiyakunoHinshu(StringUtil.subString(sojoData.getKeiyakuNo(), 3, 3));
    yusoTranEntity.setKeiyakunoTorihikiShubetsu(StringUtil.subString(sojoData.getKeiyakuNo(), 3, 1));
    yusoTranEntity.setKeiyakunoMonth(StringUtil.subString(sojoData.getKeiyakuNo(), 6, 1));
    yusoTranEntity.setKeiyakunoOban(StringUtil.subString(sojoData.getKeiyakuNo(), 7, 4));

    // Setting Juryo
    yusoTranEntity.setJuryo(NumberUtil.toInteger(sojoData.getJuryo()));
    yusoTranEntity.setBetto(NumberUtil.toInteger(sojoData.getBetto()));
    yusoTranEntity.setDaisu(NumberUtil.toInteger(sojoData.getDaisu()));

    yusoTranEntity.setCho1ju(NumberUtil.toInteger(sojoData.getCho1ju()));
    yusoTranEntity.setCho2ju(NumberUtil.toInteger(sojoData.getCho2ju()));
    yusoTranEntity.setYushutsuKenryoRyosu(NumberUtil.toInteger(sojoData.getYushutsuKenryoRyosu()));
    yusoTranEntity.setYushutsuSokouhokanNissu(NumberUtil.toInteger(sojoData.getYushutsuSokouhokanNissu()));

    // Setting SukkoBasho
    yusoTranEntity.setShukkoBasho(BusinessCommonUtil.convertNogiSukkoBasho(sojoData.getSukkoBasho()));
    yusoTranEntity.setSojonoRenban(RENBAN_0);

    // Setting time
    yusoTranEntity.setTorokuDate(DateUtil.getTimestamp());

    // Insert first record
    yusoTranDao.saveOrUpdate(yusoTranEntity);

    if (!StringUtil.isEmpty(sojoData.getBinCd1()) && !StringUtil.isEmpty(sojoData.getJuryo1())) {
      renban++;
      yusoTranEntity.setBinCd(sojoData.getBinCd1());
      yusoTranEntity.setJuryo(NumberUtil.toInteger(sojoData.getJuryo1()));
      yusoTranEntity.setBetto(NumberUtil.toInteger(sojoData.getBetto1()));
      yusoTranEntity.setSojonoRenban(renban);

      // Insert second record
      yusoTranDao.saveOrUpdate(yusoTranEntity);
    }

    if (!StringUtil.isEmpty(sojoData.getBinCd2()) && !StringUtil.isEmpty(sojoData.getJuryo2())) {
      renban++;
      yusoTranEntity.setBinCd(sojoData.getBinCd2());
      yusoTranEntity.setJuryo(NumberUtil.toInteger(sojoData.getJuryo2()));
      yusoTranEntity.setBetto(NumberUtil.toInteger(sojoData.getBetto2()));
      yusoTranEntity.setSojonoRenban(renban);

      // Insert third record
      yusoTranDao.saveOrUpdate(yusoTranEntity);
    }

    if (!StringUtil.isEmpty(sojoData.getBinCd3()) && !StringUtil.isEmpty(sojoData.getJuryo3())) {
      renban++;
      yusoTranEntity.setBinCd(sojoData.getBinCd3());
      yusoTranEntity.setJuryo(NumberUtil.toInteger(sojoData.getJuryo3()));
      yusoTranEntity.setBetto(NumberUtil.toInteger(sojoData.getBetto3()));
      yusoTranEntity.setSojonoRenban(renban);

      // Insert four record
      yusoTranDao.saveOrUpdate(yusoTranEntity);
    }

    if (!StringUtil.isEmpty(sojoData.getBinCd4()) && !StringUtil.isEmpty(sojoData.getJuryo4())) {
      renban++;
      yusoTranEntity.setBinCd(sojoData.getBinCd4());
      yusoTranEntity.setJuryo(NumberUtil.toInteger(sojoData.getJuryo4()));
      yusoTranEntity.setBetto(NumberUtil.toInteger(sojoData.getBetto4()));
      yusoTranEntity.setSojonoRenban(renban);

      // Insert five record
      yusoTranDao.saveOrUpdate(yusoTranEntity);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see vn.com.nsmv.services.NFMYGX0120_YusohiTorokuService#checkExist(java.lang.String,
   * java.lang.String, java.lang.String, java.lang.String)
   */
  @Override
  public boolean isExist(String seizoshoKbn, String sojoNo) {
    boolean checkResult = false;

    if (!StringUtil.isEmpty(sojoNo) && sojoNo.length() == 9) {

      NFMYGX0100_SearchBean searchBean = new NFMYGX0100_SearchBean();
      searchBean.setSeizoshoKbn(seizoshoKbn);
      searchBean.setSearchSojoNoShukkoBasho(StringUtil.subString(sojoNo, 0, 3));
      searchBean.setSearchSojoNoTorihikiShubetsu(StringUtil.subString(sojoNo, 3, 1));
      searchBean.setSearchSojoNoOban(StringUtil.subString(sojoNo, 4, 5));

      List<NFMYGX0100_SearchResultBean> searchResultList = new ArrayList<>();
      try {
        searchResultList = yusohiSearchDao.selectForSearch(searchBean);
      } catch (Exception ex) {
        logger.error(ex.getMessage());
      }

      if (searchResultList != null && searchResultList.size() > 0) {
        checkResult = true;
      } else {
        checkResult = false;
      }
    }

    return checkResult;
  }

  /*
   * (non-Javadoc)
   * 
   * @see vn.com.nsmv.services.NFMYGX0120_YusohiTorokuService#selectBinName(java.lang.String)
   */
  @Override
  public String selectBinName(String binCd) {
    return nfmycx0020CommonDao.selectBinName(binCd);
  }

  /*
   * (non-Javadoc)
   * 
   * @see vn.com.nsmv.services.NFMYGX0120_YusohiTorokuService#selectGyoshaName(java.lang.String)
   */
  @Override
  public String selectGyoshaName(String gyoshaCd) {
    return nfmycx0020CommonDao.selectGyoshaName(gyoshaCd);
  }
}
