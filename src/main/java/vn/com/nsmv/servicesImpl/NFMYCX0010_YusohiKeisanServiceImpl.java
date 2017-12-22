package vn.com.nsmv.servicesImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import vn.com.nsmv.bean.NFMYCX0010_210TankaResult;
import vn.com.nsmv.bean.NFMYCX0010_BaseCaculateResult;
import vn.com.nsmv.bean.NFMYCX0010_ChojakuCaculateResult;
import vn.com.nsmv.bean.NFMYCX0010_HSearchResult;
import vn.com.nsmv.bean.NFMYCX0010_JikangaiCaculateResult;
import vn.com.nsmv.bean.NFMYCX0010_KeisanParam;
import vn.com.nsmv.bean.NFMYCX0010_KutonCaculateResult;
import vn.com.nsmv.bean.NFMYCX0010_KyujitsuCaculateResult;
import vn.com.nsmv.bean.NFMYCX0010_N11SearchResult;
import vn.com.nsmv.bean.NFMYCX0010_SearchResult;
import vn.com.nsmv.bean.NFMYCX0010_TsumiawaseListBean;
import vn.com.nsmv.bean.NFMYCX0010_TsumiawaseYusoMasterBean;
import vn.com.nsmv.bean.NFMYCX0010_UchiwakeResult;
import vn.com.nsmv.bean.NFMYCX0010_YusoMasterBean;
import vn.com.nsmv.bean.NFMYCX0010_YusoMasterBodyBean;
import vn.com.nsmv.bean.NFMYCX0010_YusoMasterForTest;
import vn.com.nsmv.bean.NFMYCX0010_YusoMasterHeadBean;
import vn.com.nsmv.bean.NFMYCX0010_YusoTranBean;
import vn.com.nsmv.bean.NFMYCX0010_YusoTranSearchBean;
import vn.com.nsmv.daoImpl.SMst113DaoImpl;
import vn.com.nsmv.daoImpl.SMst207DaoImpl;
import vn.com.nsmv.daoImpl.SMst208DaoImpl;
import vn.com.nsmv.daoImpl.SMst210KihonDaoImpl;
import vn.com.nsmv.daoImpl.SMst210TankaDaoImpl;
import vn.com.nsmv.daoImpl.SMstN11DaoImpl;
import vn.com.nsmv.daoImpl.SMstYusoBodyDaoImpl;
import vn.com.nsmv.daoImpl.SMstYusoHeadDaoImpl;
import vn.com.nsmv.daoImpl.STraErrDaoImpl;
import vn.com.nsmv.daoImpl.STraYusoDaoImpl;
import vn.com.nsmv.entities.SMst113Entity;
import vn.com.nsmv.entities.SMst207Entity;
import vn.com.nsmv.entities.SMst208Entity;
import vn.com.nsmv.entities.SMst210KihonEntity;
import vn.com.nsmv.entities.SMst210TankaEntity;
import vn.com.nsmv.entities.SMstN11Entity;
import vn.com.nsmv.entities.STraErrEntity;
import vn.com.nsmv.entities.STraYusoEntity;
import vn.com.nsmv.logic.NFMYCX0010_TsumiawaseAnbunLogic;
import vn.com.nsmv.logic.NFMYCX0010_UpdateYusoMstLogic;
import vn.com.nsmv.logic.NFMYCX0010_YusoTranDataSort;
import vn.com.nsmv.services.NFMYCX0010_YusohiKeisanService;
import vn.com.nsmv.common.BusinessCommonUtil;
import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.common.DateUtil;
import vn.com.nsmv.common.NumberUtil;
import vn.com.nsmv.common.StringUtil;

@Service
public class NFMYCX0010_YusohiKeisanServiceImpl implements NFMYCX0010_YusohiKeisanService {

  @Autowired
  STraYusoDaoImpl yusoTranDao;

  @Autowired
  SMst207DaoImpl mst207Dao;

  @Autowired
  SMstYusoHeadDaoImpl yusoMstHead;

  @Autowired
  SMstYusoBodyDaoImpl yusoMstBody;

  @Autowired
  SMst113DaoImpl mst113Dao;

  @Autowired
  SMst210KihonDaoImpl mst210KihonDao;

  @Autowired
  SMst210TankaDaoImpl mst210TankaDao;

  @Autowired
  SMst208DaoImpl mst208Dao;

  @Autowired
  SMstN11DaoImpl mstN11Dao;

  @Autowired
  STraErrDaoImpl traErrDao;

  private static final Logger logger = Logger.getLogger(NFMYCX0010_YusohiKeisanServiceImpl.class);

  private static final char M_CHARATER = 'M';

  private static final char G_CHARATER = 'G';

  private static final double SOHIRE_RITSU = 0.08;

  private NFMYCX0010_TsumiawaseListBean findTsumiawaseList(NFMYCX0010_YusoTranBean bean,
      List<NFMYCX0010_YusoTranBean> caculationSojoList) {

    NFMYCX0010_TsumiawaseListBean tsumiawaseTarget = new NFMYCX0010_TsumiawaseListBean();
    List<NFMYCX0010_YusoTranBean> tsumiawaseList = new ArrayList<>();

    boolean hasBetto = false;
    for (int i = 0; i < caculationSojoList.size(); i++) {
      NFMYCX0010_YusoTranBean temp = caculationSojoList.get(i);

      if (!temp.getTsumiaiCd().equals(BusinessConst.CodeDef.Tsumiaicd.VALUE_00)) {
        if (temp.getShukkaDate().equals(bean.getShukkaDate()) && temp.getGyoshaCd().equals(bean.getGyoshaCd())
            && temp.getBinCd().equals(bean.getBinCd()) && temp.getTsumiaiCd().equals(bean.getTsumiaiCd())) {
          tsumiawaseList.add(temp);

          if (NumberUtil.nullToZero(temp.getBetto()) != 0) {
            hasBetto = true;
          }
        }
      }
    }

    tsumiawaseTarget.setHasBetto(hasBetto);
    tsumiawaseTarget.setTsumiawaseList(tsumiawaseList);
    return tsumiawaseTarget;
  }

  private void tsumiawaseGokei(List<NFMYCX0010_YusoTranBean> caculationSojoList,
      List<NFMYCX0010_YusoTranBean> tsumiawaseGokeiList) {

    NFMYCX0010_TsumiawaseListBean tsumiawaseTarget = null;
    // Sort list
    Collections.sort(caculationSojoList, new NFMYCX0010_YusoTranDataSort());

    for (int i = 0; i < caculationSojoList.size(); i++) {

      NFMYCX0010_YusoTranBean bean = caculationSojoList.get(i);

      if (i > 0) {
        NFMYCX0010_YusoTranBean previousBean = caculationSojoList.get(i - 1);
        if (bean.getShukkaDate().equals(previousBean.getShukkaDate())
            && bean.getGyoshaCd().equals(previousBean.getGyoshaCd())
            && bean.getBinCd().equals(previousBean.getBinCd())
            && bean.getTsumiaiCd().equals(previousBean.getTsumiaiCd())) {

          // Check to set betto
          if (tsumiawaseTarget.getTsumiawaseList().size() > 0 && tsumiawaseTarget.isHasBetto()
              && NumberUtil.nullToZero(bean.getBetto()) == 0) {
            bean.setBetto(100);
          }
          continue;
        } else {
          tsumiawaseTarget = findTsumiawaseList(bean, caculationSojoList);

          // Check to set betto
          if (tsumiawaseTarget.getTsumiawaseList().size() > 0 && tsumiawaseTarget.isHasBetto()
              && NumberUtil.nullToZero(bean.getBetto()) == 0) {
            bean.setBetto(100);
          }

          NFMYCX0010_YusoTranBean gokeiBean = new NFMYCX0010_YusoTranBean();
          int sumJuryo = 0;
          int sumcho1Ju = 0;
          int sumcho2Ju = 0;
          int sumfutaId = 0;
          int sumKyuryo = 0;
          int sumTomeryo = 0;
          int sumSokokis = 0;
          int sumBetto = 0;

          if (tsumiawaseTarget.getTsumiawaseList().size() > 1) {
            BeanUtils.copyProperties(tsumiawaseTarget.getTsumiawaseList().get(0), gokeiBean);

            for (int j = 0; j < tsumiawaseTarget.getTsumiawaseList().size(); j++) {
              NFMYCX0010_YusoTranBean temp = tsumiawaseTarget.getTsumiawaseList().get(j);
              sumJuryo += NumberUtil.nullToZero(temp.getJuryo());
              sumcho1Ju += NumberUtil.nullToZero(temp.getCho1ju());
              sumcho2Ju += NumberUtil.nullToZero(temp.getCho2ju());
              sumfutaId += NumberUtil.nullToZero(temp.getYushutsuFutaisenNissu());
              sumKyuryo += NumberUtil.nullToZero(temp.getKyuryo());
              sumTomeryo += NumberUtil.nullToZero(temp.getTomeryo());
              sumSokokis += NumberUtil.nullToZero(temp.getYushutsuSokouhokanNissu());
              sumBetto += NumberUtil.nullToZero(temp.getBetto());

              if (temp.getKeisanYusoKyori() > gokeiBean.getKeisanYusoKyori()) {
                gokeiBean.setKeisanYusoKyori(temp.getKeisanYusoKyori());
                gokeiBean.setKinenKbn(temp.getKinenKbn());
              }
            }

            gokeiBean.setJuryo(sumJuryo);
            gokeiBean.setCho1ju(sumcho1Ju);
            gokeiBean.setCho2ju(sumcho2Ju);
            gokeiBean.setYushutsuFutaisenNissu(sumfutaId);
            gokeiBean.setKyuryo(sumKyuryo);
            gokeiBean.setTomeryo(sumTomeryo);
            gokeiBean.setYushutsuSokouhokanNissu(sumSokokis);
            gokeiBean.setBetto(sumBetto);

            if (sumJuryo > 0 && !StringUtil.subString(gokeiBean.getBinCd(), 0, 2)
                .equals(BusinessConst.CodeDef.BinCd.BINCD_13)) {
              tsumiawaseGokeiList.add(gokeiBean);
            }
          }
        }
      } else {
        tsumiawaseTarget = findTsumiawaseList(bean, caculationSojoList);

        // Check to set betto
        if (tsumiawaseTarget.getTsumiawaseList().size() > 0 && tsumiawaseTarget.isHasBetto()
            && NumberUtil.nullToZero(bean.getBetto()) == 0) {
          bean.setBetto(100);
        }

        NFMYCX0010_YusoTranBean gokeiBean = new NFMYCX0010_YusoTranBean();
        int sumJuryo = 0;
        int sumcho1Ju = 0;
        int sumcho2Ju = 0;
        int sumfutaId = 0;
        int sumKyuryo = 0;
        int sumTomeryo = 0;
        int sumSokokis = 0;
        int sumBetto = 0;

        if (tsumiawaseTarget.getTsumiawaseList().size() > 1) {
          BeanUtils.copyProperties(tsumiawaseTarget.getTsumiawaseList().get(0), gokeiBean);

          for (int j = 0; j < tsumiawaseTarget.getTsumiawaseList().size(); j++) {
            NFMYCX0010_YusoTranBean temp = tsumiawaseTarget.getTsumiawaseList().get(j);
            sumJuryo += NumberUtil.nullToZero(temp.getJuryo());
            sumcho1Ju += NumberUtil.nullToZero(temp.getCho1ju());
            sumcho2Ju += NumberUtil.nullToZero(temp.getCho2ju());
            sumfutaId += NumberUtil.nullToZero(temp.getYushutsuFutaisenNissu());
            sumKyuryo += NumberUtil.nullToZero(temp.getKyuryo());
            sumTomeryo += NumberUtil.nullToZero(temp.getTomeryo());
            sumSokokis += NumberUtil.nullToZero(temp.getYushutsuSokouhokanNissu());
            sumBetto += NumberUtil.nullToZero(temp.getBetto());

            if (temp.getKeisanYusoKyori() > gokeiBean.getKeisanYusoKyori()) {
              gokeiBean.setKeisanYusoKyori(temp.getKeisanYusoKyori());
              gokeiBean.setKinenKbn(temp.getKinenKbn());
            }
          }

          gokeiBean.setJuryo(sumJuryo);
          gokeiBean.setCho1ju(sumcho1Ju);
          gokeiBean.setCho2ju(sumcho2Ju);
          gokeiBean.setYushutsuFutaisenNissu(sumfutaId);
          gokeiBean.setKyuryo(sumKyuryo);
          gokeiBean.setTomeryo(sumTomeryo);
          gokeiBean.setYushutsuSokouhokanNissu(sumSokokis);
          gokeiBean.setBetto(sumBetto);

          if (sumJuryo > 0 && !StringUtil.subString(gokeiBean.getBinCd(), 0, 2)
              .equals(BusinessConst.CodeDef.BinCd.BINCD_13)) {
            tsumiawaseGokeiList.add(gokeiBean);
          }
        }
      }
    }
  }

  @Override
  public NFMYCX0010_YusoMasterForTest caculateAll() {

    logger.info("START CACULATION");

    // Create tsumiawase gokei list
    List<NFMYCX0010_YusoTranBean> tsumiawaseGokeiList = new ArrayList<>();

    // Get caculation list
    List<NFMYCX0010_YusoTranBean> caculationSojoList = selectYusoTranList();

    // Caculate kyori
    this.caculateYusoKyori(caculationSojoList);

    this.tsumiawaseGokei(caculationSojoList, tsumiawaseGokeiList);

    // Init result list
    List<NFMYCX0010_YusoMasterBean> yusoMasterList = new ArrayList<NFMYCX0010_YusoMasterBean>();
    List<NFMYCX0010_YusoMasterBean> yusoMasterGokeiList = new ArrayList<NFMYCX0010_YusoMasterBean>();

    // Caculate yusohi 
    yusoMasterList = this.caculateYusohi(caculationSojoList);
    
    // Caculate yusohi in tsumiawase gokei
    yusoMasterGokeiList = this.caculateYusohi(tsumiawaseGokeiList);

    // Anbun logic
//    List<NFMYCX0010_TsumiawaseYusoMasterBean> tsumiawaseList = new ArrayList<>();
//    for (int i = 0; i < yusoMasterList.size(); i++) {
//      NFMYCX0010_YusoMasterBean masterBean = yusoMasterList.get(i);
//
//      NFMYCX0010_TsumiawaseYusoMasterBean tsumiawaseBean = new NFMYCX0010_TsumiawaseYusoMasterBean();
//      tsumiawaseBean.setShukkaDate(masterBean.getYusoMasterHeadBean().getShukkaDate());
//      tsumiawaseBean.setGyoshacd(masterBean.getYusoMasterBodyBean().getGyoshaCd());
//      tsumiawaseBean.setBincd(masterBean.getYusoMasterHeadBean().getBinCd());
//      tsumiawaseBean.setTsumiaicd(masterBean.getYusoMasterBodyBean().getTsumiaiCd());
//      tsumiawaseBean.setHimokucd(masterBean.getYusoMasterBodyBean().getHimokuCd());
//      tsumiawaseBean.setYusoMasterHeadBean(masterBean.getYusoMasterHeadBean());
//      tsumiawaseBean.setYusoMasterBodyBean(masterBean.getYusoMasterBodyBean());
//
//      tsumiawaseList.add(tsumiawaseBean);
//
//    }

    List<NFMYCX0010_YusoMasterBean> yusoMasterAnbun = new ArrayList<>();
    NFMYCX0010_TsumiawaseAnbunLogic anbunLogic = new NFMYCX0010_TsumiawaseAnbunLogic();

    //anbunLogic.doSortingTsumiawaseList(tsumiawaseList);
    anbunLogic.extractTsumiawase(yusoMasterList, yusoMasterAnbun,yusoMasterGokeiList);

    List<NFMYCX0010_YusoMasterBodyBean> bodyAnbunList = new ArrayList<>();
    for (int i = 0; i < yusoMasterAnbun.size(); i++) {
      NFMYCX0010_YusoMasterBodyBean bean = new NFMYCX0010_YusoMasterBodyBean();
      BeanUtils.copyProperties(yusoMasterAnbun.get(i).getYusoMasterBodyBean(), bean);
      bodyAnbunList.add(bean);
    }
    
    // Update database
    NFMYCX0010_UpdateYusoMstLogic yusoMasterUpdateLogic = new NFMYCX0010_UpdateYusoMstLogic(yusoMstHead,
        yusoMstBody);
    try {
      
      // TODO need set user information
      yusoMasterUpdateLogic.updateYusoMst(yusoMasterList, "H");
    } catch (Exception e) {
      e.printStackTrace();
    }

    logger.info("END CACULATION");

    // TODO For test
    NFMYCX0010_YusoMasterForTest yusoMasterListForTest = new NFMYCX0010_YusoMasterForTest();
    yusoMasterListForTest.setYusoMasterHeadList(yusoMstHead.selectForList("H"));
    yusoMasterListForTest.setYusoMasterBodyList(yusoMstBody.selectForList("H"));
    yusoMasterListForTest.setYusoMasterBodyListAnbun(bodyAnbunList);

    return yusoMasterListForTest;
  }

  @Override
  public List<STraYusoEntity> list(NFMYCX0010_YusoTranSearchBean yusoTranSearch) {
    return null;

  }

  @Override
  public Long count() {
    return null;
  }

  @Override
  public boolean delete(STraYusoEntity yusoTran) {
    return false;
  }

  @Override
  public boolean saveOrUpdate(STraYusoEntity yusoTran) {
    return false;
  }

  @Override
  public void deleteAll() {

    yusoMstHead.deleteAll();
    yusoMstBody.deleteAll();

  }

  /**
   * Yusohi caculate method
   * 
   * @param caculationSojoList
   * @return caculated list
   */
  private List<NFMYCX0010_YusoMasterBean> caculateYusohi(List<NFMYCX0010_YusoTranBean> caculationSojoList) {

    // Declare work variable
    int wkKeisanTanka = 0;
    String wkTankaTani = "";
    String wkPattern = "";
    int wkBaseTanka = 0;
    int wkaBaseKingaku = 0;
    int wkSHoSho = 0;
    int wkLHoSho = 0;
    int wkKyori = 0;

    // Declare variable for query 210 table
    String W4_ASHUKCD = "";
    String W4_AGYOCD = "";
    String W4_ABINCD = "";
    String W4_AHIMOCD = "";

    String wkTenkaiHimokuCd = "";
    String wkTenkaiGyoshaCd = "";

    // Return list
    List<NFMYCX0010_YusoMasterBean> yusoMasterList = new ArrayList<NFMYCX0010_YusoMasterBean>();

    // Declare variable for update yuso master body
    NFMYCX0010_YusoMasterHeadBean yusoMasterHeadBean = new NFMYCX0010_YusoMasterHeadBean();
    NFMYCX0010_YusoMasterBodyBean yusoMasterBodyBean = new NFMYCX0010_YusoMasterBodyBean();

    for (int i = 0; i < caculationSojoList.size(); i++) {

      NFMYCX0010_YusoTranBean sojoData = caculationSojoList.get(i);

      // Get bincode
      String binCd = StringUtil.subString(sojoData.getBinCd(), 0, 2);
      String subCd = StringUtil.subString(sojoData.getBinCd(), 2, 1);
      String kinenKbn = StringUtil.nullToEmpty(sojoData.getKinenKbn());
      String sukkoBasho = StringUtil.nullToEmpty(sojoData.getShukkoBasho());

      // In case BinCode is 90 or 91
      if (binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_90)
          || binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_91)) {

        caculateYusohi_Case1(yusoMasterList, sojoData);
        continue;
      }

      // In case BinCode is 828 or 829
      if (binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_828)
          || binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_829)) {

        caculateYusohi_Case2(yusoMasterList, sojoData);
        continue;
      }

      // Query in himoku tenkai
      SMst113Entity mst113Entity = new SMst113Entity();

      // Set data for search in mst113
      this.settingDataToMst113(mst113Entity, sojoData);

      List<SMst113Entity> mst113EntityList = mst113Dao.selectByPrimaryKey(mst113Entity);

      if (mst113EntityList != null && mst113EntityList.size() > 0) {
        for (SMst113Entity mst113 : mst113EntityList) {
          NFMYCX0010_KeisanParam param = new NFMYCX0010_KeisanParam();

          if (NumberUtil.nullToZero(sojoData.getBetto()) == 0) {
            wkTenkaiHimokuCd = mst113.getTenkai_himokucd();
            wkTenkaiGyoshaCd = mst113.getTenkai_gyoshacd();
            param.setTenkaiGyosha(wkTenkaiGyoshaCd);
            param.setTenkaiHimoku(wkTenkaiHimokuCd);
            param.setSojoData(sojoData);

            // KE060
            if (sukkoBasho.equals(BusinessConst.CodeDef.ShukkoBasho.BASHO_0SB)
                && binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_11)
                && sojoData.getUkewatashiBasho().equals(BusinessConst.CodeDef.UkeWatashiBashou.UKEWA_1281)) {

              // Set tanka and tankatani
              param.setTankaTani(BusinessConst.CodeDef.TankaTani.TANKATANI_T);
              param.setKeisanTanka(BusinessConst.CodeDef.Tanka.TANKA_330);

              // Caculate
              NFMYCX0010_UchiwakeResult uchiwakeResult = new NFMYCX0010_UchiwakeResult();
              NFMYCX0010_BaseCaculateResult baseResult = caculateBaseKingaku(param);

              // Save result to Head and Body
              uchiwakeResult.setBaseResult(baseResult);
              yusoMasterHeadBean = writeHeadData(param);
              yusoMasterBodyBean = writeBodyData(param, uchiwakeResult);
              NFMYCX0010_YusoMasterBean yusoMaster = new NFMYCX0010_YusoMasterBean();

              // Setting data for Yusomaster
              this.settingDataForYusoMaster(yusoMaster, yusoMasterHeadBean, yusoMasterBodyBean, param);

              // Add to list
              yusoMasterList.add(yusoMaster);
              continue;

            } else if (sukkoBasho.equals(BusinessConst.CodeDef.ShukkoBasho.BASHO_0SF)
                && binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_11)
                && sojoData.getUkewatashiBasho().equals(BusinessConst.CodeDef.UkeWatashiBashou.UKEWA_4085)) {
              // Set tanka and tankatani
              param.setTankaTani(BusinessConst.CodeDef.TankaTani.TANKATANI_T);
              param.setKeisanTanka(BusinessConst.CodeDef.Tanka.TANKA_1450);
              NFMYCX0010_UchiwakeResult uchiwakeResult = new NFMYCX0010_UchiwakeResult();
              NFMYCX0010_BaseCaculateResult baseResult = caculateBaseKingaku(param);
              uchiwakeResult.setBaseResult(baseResult);
              yusoMasterHeadBean = writeHeadData(param);
              yusoMasterBodyBean = writeBodyData(param, uchiwakeResult);

              NFMYCX0010_YusoMasterBean yusoMaster = new NFMYCX0010_YusoMasterBean();

              // Setting data for Yusomaster
              this.settingDataForYusoMaster(yusoMaster, yusoMasterHeadBean, yusoMasterBodyBean, param);

              // Add to list
              yusoMasterList.add(yusoMaster);
              continue;

            } else if (sukkoBasho.equals(BusinessConst.CodeDef.ShukkoBasho.BASHO_0SF)
                && binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_11)
                && sojoData.getUkewatashiBasho().equals(BusinessConst.CodeDef.UkeWatashiBashou.UKEWA_4081)) {
              // Set tanka and tankatani
              param.setTankaTani(BusinessConst.CodeDef.TankaTani.TANKATANI_T);
              param.setKeisanTanka(BusinessConst.CodeDef.Tanka.TANKA_580);
              NFMYCX0010_UchiwakeResult uchiwakeResult = new NFMYCX0010_UchiwakeResult();
              NFMYCX0010_BaseCaculateResult baseResult = caculateBaseKingaku(param);
              uchiwakeResult.setBaseResult(baseResult);
              yusoMasterHeadBean = writeHeadData(param);
              yusoMasterBodyBean = writeBodyData(param, uchiwakeResult);

              NFMYCX0010_YusoMasterBean yusoMaster = new NFMYCX0010_YusoMasterBean();

              // Setting data for Yusomaster
              this.settingDataForYusoMaster(yusoMaster, yusoMasterHeadBean, yusoMasterBodyBean, param);

              // Add to list
              yusoMasterList.add(yusoMaster);
              continue;

            } else if (sukkoBasho.equals(BusinessConst.CodeDef.ShukkoBasho.BASHO_0SH)
                || sukkoBasho.equals(BusinessConst.CodeDef.ShukkoBasho.BASHO_0SC)) {

              // Call CCHeck
              W4_AGYOCD = CCheck(sojoData, binCd, param);

            } else if (sukkoBasho.equals(BusinessConst.CodeDef.ShukkoBasho.BASHO_0SD)) {

              // Call DCHeck
              W4_AGYOCD = DCheck(sojoData, binCd, param);
            } else {
              W4_AGYOCD = wkTenkaiGyoshaCd;
              if (mst113.getTenkai_gyoshacd().equals(BusinessConst.CodeDef.Gyoshacd.GYOSHACD_009)) {
                W4_AGYOCD = BusinessConst.CodeDef.Gyoshacd.GYOSHACD_007;
              }
            }

            // KE070
            W4_ASHUKCD = sukkoBasho;
            W4_ABINCD = binCd;
            W4_AHIMOCD = wkTenkaiHimokuCd;

            // Set data to search in 210 Kihon and 210 tanka
            SMst210KihonEntity searchKihonEntity = new SMst210KihonEntity();
            SMst210TankaEntity searchTankaEntity = new SMst210TankaEntity();

            // 210 Kihon
            searchKihonEntity.setSeizosho_kbn(sojoData.getSeizoshoKbn());
            searchKihonEntity.setShukko_basho(W4_ASHUKCD);
            searchKihonEntity.setGyoshacd(W4_AGYOCD);
            searchKihonEntity.setBincd(W4_ABINCD);
            searchKihonEntity.setHimokucd(W4_AHIMOCD);

            // 210 Tanka
            searchTankaEntity.setSeizosho_kbn(sojoData.getSeizoshoKbn());
            searchTankaEntity.setShukko_basho(W4_ASHUKCD);
            searchTankaEntity.setGyoshacd(W4_AGYOCD);
            searchTankaEntity.setBincd(W4_ABINCD);
            searchTankaEntity.setHimokucd(W4_AHIMOCD);

            // Execute search
            List<SMst210KihonEntity> kihonEntityList = mst210KihonDao.selectByPrimaryKey(searchKihonEntity);
            List<SMst210TankaEntity> tankaEntityList = mst210TankaDao.selectByPrimaryKey(searchTankaEntity);

            if ((kihonEntityList != null && kihonEntityList.size() > 0)
                && (tankaEntityList != null && tankaEntityList.size() > 0)) {

              // Get data
              SMst210KihonEntity kihonEntity = kihonEntityList.get(0);
              SMst210TankaEntity tankaEntity = tankaEntityList.get(0);

              // Set data to param
              this.settingParam(param, kihonEntity);

              // Get data of 210 Tanka
              NFMYCX0010_210TankaResult result1 = new NFMYCX0010_210TankaResult();
              NFMYCX0010_210TankaResult result2 = new NFMYCX0010_210TankaResult();
              NFMYCX0010_210TankaResult result3 = new NFMYCX0010_210TankaResult();
              NFMYCX0010_210TankaResult result4 = new NFMYCX0010_210TankaResult();
              result1.setTblId(StringUtil.nullToEmpty(tankaEntity.getTbl_shikibetsu1()).trim());
              result1.setTankaTani(StringUtil.nullToEmpty(tankaEntity.getTanka_tani1()).trim());
              result1.setTekiyoRitsu(tankaEntity.getTekiyo_ritsu1());
              result2.setTblId(StringUtil.nullToEmpty(tankaEntity.getTbl_shikibetsu2()).trim());
              result2.setTankaTani(StringUtil.nullToEmpty(tankaEntity.getTanka_tani2()).trim());
              result2.setTekiyoRitsu(tankaEntity.getTekiyo_ritsu2());
              result3.setTblId(StringUtil.nullToEmpty(tankaEntity.getTbl_shikibetsu3()).trim());
              result3.setTankaTani(StringUtil.nullToEmpty(tankaEntity.getTanka_tani3()).trim());
              result3.setTekiyoRitsu(tankaEntity.getTekiyo_ritsu3());
              result4.setTblId(StringUtil.nullToEmpty(tankaEntity.getTbl_shikibetsu4()).trim());
              result4.setTankaTani(StringUtil.nullToEmpty(tankaEntity.getTanka_tani4()).trim());
              result4.setTekiyoRitsu(tankaEntity.getTekiyo_ritsu4());

              // MOVEWKS-RTN
              this.adjustTekyoRitsu(searchKihonEntity, result1);

              // KE081
              if (StringUtil.nullToEmpty(kihonEntity.getTeikiyo_patan())
                  .equals(BusinessConst.CodeDef.TeikiyoPatan.VALUE_6)) {

                // KE140
                if (binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_11)
                    && wkTenkaiHimokuCd.equals(BusinessConst.CodeDef.Himokucd.HIMOKU_H1)) {
                  wkKeisanTanka = sojoData.getTomeryo();
                  param.setKeisanTanka(wkKeisanTanka);

                  NFMYCX0010_YusoMasterBean yusoMaster = caculateKingaku(param);
                  yusoMasterList.add(yusoMaster);
                  continue;
                } else if (binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_12)
                    && wkTenkaiHimokuCd.equals(BusinessConst.CodeDef.Himokucd.HIMOKU_H1)) {
                  wkKeisanTanka = sojoData.getTomeryo();
                  param.setKeisanTanka(wkKeisanTanka);

                  NFMYCX0010_YusoMasterBean yusoMaster = caculateKingaku(param);
                  yusoMasterList.add(yusoMaster);
                  continue;
                } else {

                  SMstN11Entity n11EntityForSearch = settingEntityForSearch(sojoData, kihonEntity, W4_ASHUKCD,
                      W4_AGYOCD, W4_ABINCD, W4_AHIMOCD);

                  // KE150
                  NFMYCX0010_N11SearchResult tankaResult = getTankaFromN11(n11EntityForSearch);
                  wkTankaTani = tankaResult.getTankaTani();
                  wkKeisanTanka = tankaResult.getTanka();

                  param.setKeisanTanka(wkKeisanTanka);
                  param.setTankaTani(wkTankaTani);

                  NFMYCX0010_YusoMasterBean yusoMaster = caculateKingaku(param);
                  yusoMasterList.add(yusoMaster);
                  continue;
                }
              }

              // Caculate kyori
              if (StringUtil.nullToEmpty(kihonEntity.getKyor_tbl_sikibetsu())
                  .equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T15)) {
                wkKyori = caculateKyori(sojoData);
              } else {
                wkKyori = sojoData.getKeisanYusoKyori();
              }

              // KE081
              result1 = caculate210TankaResult(kinenKbn, result1, result2, result3, result4);

              // KE090
              wkTankaTani = result1.getTankaTani();
              param.setTankaTani(wkTankaTani);

              if (kinenKbn.equals(BusinessConst.CodeDef.KinenKbn.VALUE_0)
                  || kinenKbn.equals(BusinessConst.CodeDef.KinenKbn.VALUE_1)
                  || kinenKbn.equals(BusinessConst.CodeDef.KinenKbn.VALUE_3)) {

                // Do nothing
              } else if ((kinenKbn.equals(BusinessConst.CodeDef.KinenKbn.VALUE_2)
                  || kinenKbn.equals(BusinessConst.CodeDef.KinenKbn.VALUE_4))
                  && NumberUtil.nullToZero(kihonEntity.getSonota_kuton_ritsu2()) != 0) {
                param.setKutonRitsu(NumberUtil.nullToZero(kihonEntity.getSonota_kuton_ritsu2()));
              } else if (kinenKbn.equals(BusinessConst.CodeDef.KinenKbn.VALUE_5)
                  && NumberUtil.nullToZero(kihonEntity.getSonota_kuton_ritsu3()) != 0) {
                param.setKutonRitsu(NumberUtil.nullToZero(kihonEntity.getSonota_kuton_ritsu3()));
              }

              // KE100
              // Set data to search in 208 master
              SMst208Entity mst208Entity = new SMst208Entity();
              wkPattern = this.setting208MstEntityAndWorkPattern(mst208Entity, sojoData, result1.getTblId(),
                  wkKyori);

              // KE110 : Query in 208 table
              List<SMst208Entity> mst208EntityList = mst208Dao.selectByPrimaryKey(mst208Entity);

              if (mst208EntityList != null && mst208EntityList.size() > 0) {
                SMst208Entity entity = mst208EntityList.get(0);

                NFMYCX0010_SearchResult result = new NFMYCX0010_SearchResult();
                NFMYCX0010_HSearchResult resultH = new NFMYCX0010_HSearchResult();

                if (wkPattern.equals(BusinessConst.CodeDef.WorkPattern.PATTERN_A)
                    && binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_32)
                    && (wkTenkaiHimokuCd.equals(BusinessConst.CodeDef.TenkaiHimokucd.HIMOKU_B_SPACE)
                        || wkTenkaiHimokuCd.equals(BusinessConst.CodeDef.TenkaiHimokucd.HIMOKU_D_SPACE))) {

                  int unchinKingaku = 0;
                  if (wkTenkaiHimokuCd.equals(BusinessConst.CodeDef.TenkaiHimokucd.HIMOKU_D_SPACE)) {
                    wkKeisanTanka = entity.getBase_tanka3();
                  } else {
                    wkKeisanTanka = entity.getBase_tanka1();
                    unchinKingaku = sojoData.getJuryo() / 50;
                  }
                  wkaBaseKingaku = entity.getBase_tanka2() * unchinKingaku + entity.getBase_tanka1();

                  // Set data for param
                  param.setKeisanTanka(wkKeisanTanka);
                  param.setWbaKingaku(wkaBaseKingaku);
                } else if (wkPattern.equals(BusinessConst.CodeDef.WorkPattern.PATTERN_A)
                    || wkPattern.equals(BusinessConst.CodeDef.WorkPattern.PATTERN_D)) {
                  wkBaseTanka = entity.getBase_tanka1();
                } else if (wkPattern.equals(BusinessConst.CodeDef.WorkPattern.PATTERN_B)) {
                  result = bSearch(subCd, entity);
                  wkBaseTanka = result.getBaseTanka();
                  wkSHoSho = result.getHosho();
                  param.setsHosho(wkSHoSho);
                } else if (wkPattern.equals(BusinessConst.CodeDef.WorkPattern.PATTERN_C)) {
                  result = cSearch(sojoData.getJuryo(), entity);
                  wkBaseTanka = result.getBaseTanka();
                  wkLHoSho = result.getHosho();
                  param.setlHosho(wkLHoSho);
                } else if (wkPattern.equals(BusinessConst.CodeDef.WorkPattern.PATTERN_E)) {
                  result = eSearch(sojoData.getUkewatashiBasho(), sojoData.getShukkaDate(), entity);
                  wkBaseTanka = result.getBaseTanka();
                } else if (wkPattern.equals(BusinessConst.CodeDef.WorkPattern.PATTERN_F)
                    && (binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_21)
                        || binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_22))
                    && wkTenkaiHimokuCd.equals(BusinessConst.CodeDef.Himokucd.HIMOKU_H1)) {
                  resultH = hSearch(subCd, entity, result1.getTekiyoRitsu());
                  wkBaseTanka = resultH.getBaseTanka();
                  wkKeisanTanka = resultH.getKeisanTanka();

                  param.setKeisanTanka(wkKeisanTanka);

                  NFMYCX0010_YusoMasterBean yusoMaster = caculateKingaku(param);
                  yusoMasterList.add(yusoMaster);
                  continue;

                } else if (wkPattern.equals(BusinessConst.CodeDef.WorkPattern.PATTERN_F)) {
                  result = fSearch(sojoData.getNagasa().toString(), entity);
                  wkBaseTanka = result.getBaseTanka();
                } else if (wkPattern.equals(BusinessConst.CodeDef.WorkPattern.PATTERN_G)) {
                  result = gSearch(sojoData.getJuryo(), entity);
                  wkKeisanTanka = result.getBaseTanka();

                  param.setKeisanTanka(wkKeisanTanka);

                  NFMYCX0010_YusoMasterBean yusoMaster = caculateKingaku(param);
                  yusoMasterList.add(yusoMaster);
                  continue;
                } else if (wkPattern.equals(BusinessConst.CodeDef.WorkPattern.PATTERN_T)) {
                  result = tSearch(sojoData.getJuryo(), entity);
                  wkBaseTanka = result.getBaseTanka();
                  wkSHoSho = result.getHosho();

                  param.setKeisanTanka(wkKeisanTanka);
                  param.setsHosho(wkSHoSho);

                  NFMYCX0010_YusoMasterBean yusoMaster = caculateKingaku(param);
                  yusoMasterList.add(yusoMaster);
                  continue;
                }

                // KE130
                if (result1.getTekiyoRitsu() == 0) {
                  wkKeisanTanka = wkBaseTanka;
                  param.setKeisanTanka(wkKeisanTanka);
                } else {
                  wkKeisanTanka = new BigDecimal(wkBaseTanka)
                      .multiply(new BigDecimal(result1.getTekiyoRitsu()))
                      .divide(new BigDecimal(1000), 0, BigDecimal.ROUND_HALF_UP).intValue();
                  wkKeisanTanka = wkKeisanTanka * 10;

                  param.setKeisanTanka(wkKeisanTanka);
                  NFMYCX0010_YusoMasterBean yusoMaster = caculateKingaku(param);
                  yusoMasterList.add(yusoMaster);
                  continue;
                }

                // KE140
                if (binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_11)
                    && wkTenkaiHimokuCd.equals(BusinessConst.CodeDef.Himokucd.HIMOKU_H1)) {
                  wkKeisanTanka = sojoData.getTomeryo();
                  param.setKeisanTanka(wkKeisanTanka);

                  NFMYCX0010_YusoMasterBean yusoMaster = caculateKingaku(param);
                  yusoMasterList.add(yusoMaster);
                  continue;
                } else if (binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_12)
                    && wkTenkaiHimokuCd.equals(BusinessConst.CodeDef.Himokucd.HIMOKU_H1)) {
                  wkKeisanTanka = sojoData.getTomeryo();
                  param.setKeisanTanka(wkKeisanTanka);

                  NFMYCX0010_YusoMasterBean yusoMaster = caculateKingaku(param);
                  yusoMasterList.add(yusoMaster);
                  continue;

                } else {

                  SMstN11Entity n11EntityForSearch = settingEntityForSearch(sojoData, kihonEntity, W4_ASHUKCD,
                      W4_AGYOCD, W4_ABINCD, W4_AHIMOCD);

                  // KE150
                  NFMYCX0010_N11SearchResult tankaResult = getTankaFromN11(n11EntityForSearch);
                  wkTankaTani = tankaResult.getTankaTani();
                  wkKeisanTanka = tankaResult.getTanka();

                  param.setKeisanTanka(wkKeisanTanka);
                  param.setTankaTani(wkTankaTani);

                  NFMYCX0010_YusoMasterBean yusoMaster = caculateKingaku(param);
                  yusoMasterList.add(yusoMaster);
                  continue;
                }

              } else {
                // TODO Write error to table log

                wkKeisanTanka = 0;
                param.setKeisanTanka(wkKeisanTanka);

                NFMYCX0010_YusoMasterBean yusoMaster = caculateKingaku(param);
                yusoMasterList.add(yusoMaster);
                continue;
              }

            } else {
              String binCd11 = StringUtil.subString(sojoData.getBinCd(), 0, 1);

              // Check Bincd
              if (!binCd11.equals(BusinessConst.CodeDef.NumberValue.FIVE)) {
                // TODO Write error log
              } else if (param.getTenkaiGyosha().equals("***")) {
                // TODO Write error log
              } else {
                NFMYCX0010_YusoMasterBean yusoMaster = funeKingakuCaculate(param);
                yusoMasterList.add(yusoMaster);
                continue;
              }
            }

          } else {
            // In case have betto kingaku
            wkTenkaiHimokuCd = mst113.getTenkai_himokucd();
            wkTenkaiGyoshaCd = mst113.getTenkai_gyoshacd();
            param.setTenkaiGyosha(wkTenkaiGyoshaCd);
            param.setTenkaiHimoku(wkTenkaiHimokuCd);
            param.setSojoData(sojoData);
            param.setTenkaiHimoku(BusinessConst.CodeDef.Himokucd.Z_SPACE_1);

            NFMYCX0010_YusoMasterBean yusoMaster = caculateKingaku(param);
            yusoMasterList.add(yusoMaster);
            continue;
          }
        }
      } else {

        // KE025
        if (NumberUtil.nullToZero(sojoData.getBetto()) != 0) {
          NFMYCX0010_KeisanParam param = new NFMYCX0010_KeisanParam();

          param.setTenkaiGyosha(sojoData.getGyoshaCd());
          param.setTenkaiHimoku(BusinessConst.CodeDef.Himokucd.Z_SPACE_1);
          param.setTankaTani(BusinessConst.CodeDef.TankaTani.TANKATANI_W);
          param.setKeisanTanka(BusinessConst.CodeDef.NumberValue.NUMBER_0);
          param.setSojoData(sojoData);
          NFMYCX0010_UchiwakeResult uchiwakeResult = new NFMYCX0010_UchiwakeResult();

          // Set base kingaku and base juryo
          NFMYCX0010_BaseCaculateResult baseResult = new NFMYCX0010_BaseCaculateResult();
          baseResult.setBaseJuryo(NumberUtil.nullToZero(sojoData.getJuryo()));
          baseResult.setBaseKingaku(NumberUtil.nullToZero(sojoData.getBetto()));
          uchiwakeResult.setBaseResult(baseResult);

          yusoMasterHeadBean = writeHeadData(param);
          yusoMasterBodyBean = writeBodyData(param, uchiwakeResult);
          NFMYCX0010_YusoMasterBean yusoMaster = new NFMYCX0010_YusoMasterBean();

          this.settingDataForYusoMaster(yusoMaster, yusoMasterHeadBean, yusoMasterBodyBean, param);

          yusoMasterList.add(yusoMaster);
          continue;
        } else {
          STraErrEntity error = new STraErrEntity();

          error.setShoriStartDate(DateUtil.getTimestamp());
          error.setSeizoshoKbn(sojoData.getSeizoshoKbn());
          error.setSojonoShukkoBasho(sojoData.getSojonoShukkoBasho());
          error.setSojonoTorihikiShubetsu(sojoData.getSojonoTorihikiShubetsu());
          error.setSojonoOban(sojoData.getSojonoOban());
          error.setSojonoRenban(sojoData.getSojonoRenban());
          error.setErrShubetsu("1");

          try {
            traErrDao.saveOrUpdate(error);
          } catch (Exception ex) {
            logger.error(ex);
          }
        }
      }
    }
    return yusoMasterList;
  }

  /**
   * Get caculation list
   * 
   * @return list
   */
  private List<NFMYCX0010_YusoTranBean> selectYusoTranList() {

    List<NFMYCX0010_YusoTranBean> sojoBeanList = new ArrayList<NFMYCX0010_YusoTranBean>();
    List<STraYusoEntity> sojoList = yusoTranDao.list();

    for (int i = 0; i < sojoList.size(); i++) {
      NFMYCX0010_YusoTranBean sojo = new NFMYCX0010_YusoTranBean();
      BeanUtils.copyProperties(sojoList.get(i), sojo);
      sojoBeanList.add(sojo);
    }

    return sojoBeanList;
  }

  private void caculateYusoKyori(List<NFMYCX0010_YusoTranBean> sojoList) {

    for (int i = 0; i < sojoList.size(); i++) {
      NFMYCX0010_YusoTranBean sojoData = sojoList.get(i);

      // Convert hinshu
      convertHinshu(sojoData);

      // Convert bincd
      convertBinCd(sojoData);

      // Remove sohirei
      if (sojoData.getBinCd().equals(BusinessConst.CodeDef.BinCd.BINCD_800)
          && sojoData.getGyoshaCd().equals(BusinessConst.CodeDef.Gyoshacd.GYOSHACD_008)) {

        if (sojoData.getBetto() != null) {
          BigDecimal betto = new BigDecimal(sojoData.getBetto()).divide(new BigDecimal(1 + SOHIRE_RITSU), 0,
              BigDecimal.ROUND_HALF_UP);
          sojoData.setBetto(betto.intValue());
        }
      }

      // Caculate kyori
      SMst207Entity mst207 = mst207Dao.selectByPrimaryKey(sojoData.getSeizoshoKbn(),
          BusinessConst.CodeDef.DataKbn.DATAKBN_T11,
          BusinessCommonUtil.convertNogiSukkoBasho(sojoData.getSojonoShukkoBasho()),
          sojoData.getUkewatashiBasho());

      sojoData.setKihonYusoKyori(mst207.getKihon_yuso_kyori());
      sojoData.setKeisanYusoKyori(mst207.getKeisan_yuso_kyori());
      sojoData.setKinenKbn(mst207.getKinen_kbn());
    }
  }

  private void settingDataToMst113(SMst113Entity mst113Entity, NFMYCX0010_YusoTranBean sojoData) {

    // Get bincode
    String binCd = StringUtil.subString(sojoData.getBinCd(), 0, 2);

    // Set seizoshoKbn
    mst113Entity.setSeizosho_kbn(sojoData.getSeizoshoKbn());

    // Set bincode
    mst113Entity.setBincd(binCd);

    // Set gyoshaCd
    if (sojoData.getGyoshaCd().equals(BusinessConst.CodeDef.Gyoshacd.GYOSHACD_009)) {
      mst113Entity.setGyoshacd(BusinessConst.CodeDef.Gyoshacd.GYOSHACD_007);
    } else {
      mst113Entity.setGyoshacd(sojoData.getGyoshaCd());
    }

    // Set yushutsu kubun
    if (sojoData.getSojonoTorihikiShubetsu().equals(BusinessConst.CodeDef.SojonoTorihikiShubetsu.VALUE_3)
        || sojoData.getSojonoTorihikiShubetsu()
            .equals(BusinessConst.CodeDef.SojonoTorihikiShubetsu.VALUE_4)) {
      mst113Entity.setYushutsu_kbn(BusinessConst.CodeDef.YushutsuKbn.VALUE_1);
    } else {
      mst113Entity.setYushutsu_kbn(BusinessConst.CodeDef.YushutsuKbn.BLANK);
    }
  }

  /**
   * Adjust teikyo ritsu
   * 
   * @param searchKihonEntity
   * @param result1
   */
  private void adjustTekyoRitsu(SMst210KihonEntity searchKihonEntity, NFMYCX0010_210TankaResult result1) {
    // MOVEWKS-RTN
    StringBuilder sb = new StringBuilder();
    sb.append(searchKihonEntity.getSeizosho_kbn());
    sb.append(searchKihonEntity.getShukko_basho());
    sb.append(searchKihonEntity.getGyoshacd());
    sb.append(searchKihonEntity.getBincd());
    sb.append(searchKihonEntity.getHimokucd());

    if (sb.toString().equals("H0SH00711A ")) {
      double tekiyoRitsu = result1.getTekiyoRitsu() + 0.1;
      result1.setTekiyoRitsu(tekiyoRitsu);
    }

    if (sb.toString().equals("H0SH00712A ")) {
      double tekiyoRitsu = result1.getTekiyoRitsu() + 0.8;
      result1.setTekiyoRitsu(tekiyoRitsu);
    }

    if (sb.toString().equals("H0SH00718A ")) {
      double tekiyoRitsu = result1.getTekiyoRitsu() + 0.8;
      result1.setTekiyoRitsu(tekiyoRitsu);
    }
  }

  // KE081
  /**
   * Caculate tankatani , tekyo ritsu and tblId from data 210 master
   * 
   * @param kinenKbn
   * @param result1
   * @param result2
   * @param result3
   * @param result4
   * @return
   */
  private NFMYCX0010_210TankaResult caculate210TankaResult(String kinenKbn, NFMYCX0010_210TankaResult result1,
      NFMYCX0010_210TankaResult result2, NFMYCX0010_210TankaResult result3,
      NFMYCX0010_210TankaResult result4) {

    if (kinenKbn.equals(BusinessConst.CodeDef.KinenKbn.VALUE_0)
        || kinenKbn.equals(BusinessConst.CodeDef.KinenKbn.VALUE_1)
        || kinenKbn.equals(BusinessConst.CodeDef.KinenKbn.VALUE_SPACE)) {

      // Do nothing
    } else if (kinenKbn.equals(BusinessConst.CodeDef.KinenKbn.VALUE_2)
        && !result2.getTblId().equals(BusinessConst.CodeDef.CheckSpace.BLANK)) {
      result1.setTblId(result2.getTblId());
      result1.setTankaTani(result2.getTankaTani());
      result1.setTekiyoRitsu(result2.getTekiyoRitsu());
    } else if (kinenKbn.equals(BusinessConst.CodeDef.KinenKbn.VALUE_5)
        && !result3.getTblId().equals(BusinessConst.CodeDef.CheckSpace.BLANK)) {
      result1.setTblId(result3.getTblId());
      result1.setTankaTani(result3.getTankaTani());
      result1.setTekiyoRitsu(result3.getTekiyoRitsu());
    } else if ((kinenKbn.equals(BusinessConst.CodeDef.KinenKbn.VALUE_3)
        || kinenKbn.equals(BusinessConst.CodeDef.KinenKbn.VALUE_4))
        && !result4.getTblId().equals(BusinessConst.CodeDef.CheckSpace.BLANK)) {
      result1.setTblId(result4.getTblId());
      result1.setTankaTani(result4.getTankaTani());
      result1.setTekiyoRitsu(result4.getTekiyoRitsu());
    }

    // Return value
    return result1;
  }

  /**
   * Set data to search in 208 master(KE100)
   * 
   * @param mst208Entity
   * @param sojoData
   * @param wkTblId1
   * @param wkKyori
   * @return Work Patern
   */
  private String setting208MstEntityAndWorkPattern(SMst208Entity mst208Entity,
      NFMYCX0010_YusoTranBean sojoData, String wkTblId1, int wkKyori) {
    String wkPattern = "";

    if (wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T20)
        || wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T21)) {
      wkPattern = BusinessConst.CodeDef.WorkPattern.PATTERN_A;
      mst208Entity.setSeizosho_kbn(sojoData.getSeizoshoKbn());
      mst208Entity.setData_kbn(wkTblId1);
      mst208Entity.setKey1(StringUtil.getStr(wkKyori));
      mst208Entity.setKey2(BusinessConst.CodeDef.CheckSpace.SPACE1);

    } else if (wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T2A)
        || wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T2B)
        || wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T2C)
        || wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T2D)
        || wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T2E)
        || wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T2F)
        || wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T2G)
        || wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T2H)
        || wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T2I)
        || wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T2J)) {

      wkPattern = BusinessConst.CodeDef.WorkPattern.PATTERN_B;

      mst208Entity.setSeizosho_kbn(sojoData.getSeizoshoKbn());
      mst208Entity.setData_kbn(wkTblId1);
      mst208Entity.setKey1(StringUtil.getStr(wkKyori));
      mst208Entity.setKey2(BusinessConst.CodeDef.CheckSpace.SPACE1);

    } else if (wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T30)) {
      wkPattern = BusinessConst.CodeDef.WorkPattern.PATTERN_C;
      mst208Entity.setSeizosho_kbn(sojoData.getSeizoshoKbn());
      mst208Entity.setData_kbn(wkTblId1);
      mst208Entity.setKey1(StringUtil.getStr(wkKyori));
      mst208Entity.setKey2(BusinessConst.CodeDef.CheckSpace.SPACE1);

    } else if (wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T30)) {
      wkPattern = BusinessConst.CodeDef.WorkPattern.PATTERN_C;
      mst208Entity.setSeizosho_kbn(sojoData.getSeizoshoKbn());
      mst208Entity.setData_kbn(wkTblId1);
      mst208Entity.setKey1(StringUtil.getStr(wkKyori));
      mst208Entity.setKey2(BusinessConst.CodeDef.CheckSpace.SPACE1);

    } else if (wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T31)) {
      wkPattern = BusinessConst.CodeDef.WorkPattern.PATTERN_T;
      mst208Entity.setSeizosho_kbn(sojoData.getSeizoshoKbn());
      mst208Entity.setData_kbn(wkTblId1);
      mst208Entity.setKey1(StringUtil.subString(sojoData.getUkewatashiBasho(), 0, 2));
      mst208Entity.setKey2(BusinessConst.CodeDef.CheckSpace.SPACE1);

    } else if (wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T40)
        || wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T41)) {
      wkPattern = BusinessConst.CodeDef.WorkPattern.PATTERN_D;
      mst208Entity.setData_kbn(wkTblId1);
      mst208Entity.setKey1(sojoData.getUkewatashiBasho());
      mst208Entity.setKey2(BusinessConst.CodeDef.CheckSpace.SPACE1);

    } else if (wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T42)) {
      wkPattern = BusinessConst.CodeDef.WorkPattern.PATTERN_G;
      mst208Entity.setData_kbn(wkTblId1);
      mst208Entity.setKey1(sojoData.getUkewatashiBasho());
      mst208Entity.setKey2(BusinessConst.CodeDef.CheckSpace.SPACE1);

    } else if (wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T43)) {
      wkPattern = BusinessConst.CodeDef.WorkPattern.PATTERN_E;

      mst208Entity.setData_kbn(wkTblId1);
      mst208Entity.setKey1(sojoData.getShukkoBasho());
      mst208Entity.setKey2(StringUtil.subString(sojoData.getUkewatashiBasho(), 0, 2));

    } else if (wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_T50)) {
      wkPattern = BusinessConst.CodeDef.WorkPattern.PATTERN_F;
      mst208Entity.setData_kbn(wkTblId1);
      mst208Entity.setKey1(sojoData.getTsumikomiMinato());
      mst208Entity.setKey2(sojoData.getAgeMinato());

    } else if (wkTblId1.equals(BusinessConst.CodeDef.kyorTblSikibetsu.VALUE_0SD)) {
      wkPattern = BusinessConst.CodeDef.WorkPattern.PATTERN_A;
      mst208Entity.setData_kbn(wkTblId1);
      mst208Entity.setKey1(sojoData.getUkewatashiBasho());
      mst208Entity.setKey2(BusinessConst.CodeDef.CheckSpace.SPACE1);
    }

    return wkPattern;

  }

  /**
   * Set data to caculate param.
   * 
   * @param param
   * @param kihonEntity
   */
  private void settingParam(NFMYCX0010_KeisanParam param, SMst210KihonEntity kihonEntity) {
    param.setKutonRitsu(NumberUtil.nullToZero(kihonEntity.getSonota_kuton_ritsu1()));
    param.setChojakuTankaTani(StringUtil.nullToEmpty(kihonEntity.getChojaku_tanka_tani()));
    param.setChojakuTanka1(NumberUtil.nullToZero(kihonEntity.getChojaku_ritsu1()));
    param.setChojakuTanka2(NumberUtil.nullToZero(kihonEntity.getChojaku_ritsu2()));
    param.setJikangaiTankaTani(StringUtil.nullToEmpty(kihonEntity.getJikankai_tanka_tani()));
    param.setJikangaiTanka(NumberUtil.nullToZero(kihonEntity.getJikankai_ritsu()));
    param.setKyujitsuTankaTani(StringUtil.nullToEmpty(kihonEntity.getKyujitsu_tanka_tani()));
    param.setKyujitsuTanka(NumberUtil.nullToZero(kihonEntity.getKyujitsu_ritsu()));
    param.setHinshuTankaTani(StringUtil.nullToEmpty(kihonEntity.getHinshu_tanka_tani()));
    param.setHinshuTanka(NumberUtil.nullToZero(kihonEntity.getHinshu_ritsu()));
    param.setTokiTankaTanni(StringUtil.nullToEmpty(kihonEntity.getToki_tanka_tani()));
    param.setTokiTanka(NumberUtil.nullToZero(kihonEntity.getToki_ritsu()));
  }

  /**
   * Caculate when not found data in 210 master.
   * 
   * @param param
   * @return
   */
  private NFMYCX0010_YusoMasterBean funeKingakuCaculate(NFMYCX0010_KeisanParam param) {

    param.setTankaTani(BusinessConst.CodeDef.TankaTani.TANKATANI_T);

    NFMYCX0010_UchiwakeResult uchiwakeResult = new NFMYCX0010_UchiwakeResult();

    NFMYCX0010_YusoMasterHeadBean yusoMasterHeadBean = writeHeadData(param);
    NFMYCX0010_YusoMasterBodyBean yusoMasterBodyBean = writeBodyData(param, uchiwakeResult);
    NFMYCX0010_YusoMasterBean yusoMaster = new NFMYCX0010_YusoMasterBean();
    this.settingDataForYusoMaster(yusoMaster, yusoMasterHeadBean, yusoMasterBodyBean, param);

    return yusoMaster;
  }

  /**
   * Implement search in N11 master
   * 
   * @param searchEntity
   * @return
   */
  private NFMYCX0010_N11SearchResult getTankaFromN11(SMstN11Entity searchEntity) {
    NFMYCX0010_N11SearchResult result = new NFMYCX0010_N11SearchResult();

    List<SMstN11Entity> n11EntityList = mstN11Dao.selectByPrimaryKey(searchEntity);

    if (n11EntityList != null && n11EntityList.size() > 0) {
      result.setTankaTani(n11EntityList.get(0).getTanka_tani());
      result.setTanka(n11EntityList.get(0).getTanka());
    } else {
      result.setTanka(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    }

    return result;
  }

  private SMstN11Entity settingEntityForSearch(NFMYCX0010_YusoTranBean sojoData,
      SMst210KihonEntity kihonEntity, String W5_ASHUKCD, String W5_AGYOCD, String W5_ABINCD,
      String W5_AHIMOCD) {
    SMstN11Entity n11EntityForSearch = new SMstN11Entity();
    String subCd = StringUtil.subString(sojoData.getBinCd(), 2, 1);

    String W5_SETUMICD = "";
    String W5_SEAGECD = "";
    String W5_TRTUMICD = "";
    String W5_UKECHI = "";
    String W5_CHUKBN = "";
    String W5_HAMAKBN = "";
    String W5_MOCHICD = "";
    String W5_SUBCD = "";

    if (kihonEntity.getSubkey1() != null
        && kihonEntity.getSubkey1().equals(BusinessConst.CodeDef.NumberValue.ONE)) {
      W5_SETUMICD = sojoData.getTsumikomiMinato();
    }
    if (kihonEntity.getSubkey2() != null
        && kihonEntity.getSubkey2().equals(BusinessConst.CodeDef.NumberValue.ONE)) {
      W5_SEAGECD = sojoData.getAgeMinato();
    }
    if (kihonEntity.getSubkey3() != null
        && kihonEntity.getSubkey3().equals(BusinessConst.CodeDef.NumberValue.ONE)) {
      W5_TRTUMICD = sojoData.getTranshipTsumikomiMinato();
    }
    if (kihonEntity.getSubkey4() != null
        && kihonEntity.getSubkey4().equals(BusinessConst.CodeDef.NumberValue.ONE)) {
      W5_UKECHI = sojoData.getUkewatashiBasho();
    }
    if (kihonEntity.getSubkey5() != null
        && kihonEntity.getSubkey5().equals(BusinessConst.CodeDef.NumberValue.ONE)) {
      W5_CHUKBN = sojoData.getYushutsuChukeiKbn();
    }
    if (kihonEntity.getSubkey6() != null
        && kihonEntity.getSubkey6().equals(BusinessConst.CodeDef.NumberValue.ONE)) {
      W5_HAMAKBN = sojoData.getHamaKbn();
    }
    if (kihonEntity.getSubkey7() != null
        && kihonEntity.getSubkey7().equals(BusinessConst.CodeDef.NumberValue.ONE)) {
      W5_MOCHICD = BusinessConst.CodeDef.CheckSpace.SPACE1;
    }
    if (kihonEntity.getSubkey8() != null
        && kihonEntity.getSubkey8().equals(BusinessConst.CodeDef.NumberValue.ONE)) {
      W5_SUBCD = subCd;
    }

    n11EntityForSearch.setSeizosho_kbn(sojoData.getSeizoshoKbn());
    n11EntityForSearch.setShukko_basho(W5_ASHUKCD);
    n11EntityForSearch.setGyoshacd(W5_AGYOCD);
    n11EntityForSearch.setBincd(W5_ABINCD);
    n11EntityForSearch.setHimokucd(W5_AHIMOCD);
    n11EntityForSearch.setTsumikomi_minato(W5_SETUMICD);
    n11EntityForSearch.setAge_minato(W5_SEAGECD);
    n11EntityForSearch.setTranship_tsumikomi_minato(W5_TRTUMICD);
    n11EntityForSearch.setUkewatashi_basho(W5_UKECHI);
    n11EntityForSearch.setChukei_kbn(W5_CHUKBN);
    n11EntityForSearch.setHamakbn(W5_HAMAKBN);
    n11EntityForSearch.setMochikomi_cd(W5_MOCHICD);
    n11EntityForSearch.setSub_cd(W5_SUBCD);

    return n11EntityForSearch;
  }

  /**
   * Get distance from 207 Master.
   * 
   * @param NFMYCX0010_YusoTranBean sojoData
   * @return Keisan Kyori
   */
  private int caculateKyori(NFMYCX0010_YusoTranBean sojoData) {
    SMst207Entity mst207 = mst207Dao.selectByPrimaryKey(sojoData.getSeizoshoKbn(),
        BusinessConst.CodeDef.DataKbn.DATAKBN_T15, sojoData.getAgeMinato(), sojoData.getUkewatashiBasho());

    return mst207.getKeisan_yuso_kyori();
  }

  /**
   * Caculate uchiwake yusohi (KE170)
   * 
   * @param param NFMYCX0010_KeisanParam
   * @return Caculated result
   */
  private NFMYCX0010_YusoMasterBean caculateKingaku(NFMYCX0010_KeisanParam param) {

    if (param.getSojoData().getShukkoBasho().equals(BusinessConst.CodeDef.ShukkoBasho.BASHO_0SD)) {
      param.setKeisanTanka(wariRtn(param.getSojoData(), param.getTenkaiHimoku()));
    }

    NFMYCX0010_BaseCaculateResult baseResult = caculateBaseKingaku(param);
    NFMYCX0010_KutonCaculateResult kutonResult = caculateKutonKingaku(param);
    NFMYCX0010_ChojakuCaculateResult chojakuResult = caculateChojakuKingaku(param);
    NFMYCX0010_JikangaiCaculateResult jikangaiResult = caculateJikangaiKingaku(param);
    NFMYCX0010_KyujitsuCaculateResult kyujitsuResult = caculateKyujitsuKingaku(param);

    NFMYCX0010_UchiwakeResult uchiwakeResult = new NFMYCX0010_UchiwakeResult();
    uchiwakeResult.setBaseResult(baseResult);
    uchiwakeResult.setKutonResult(kutonResult);
    uchiwakeResult.setChojakuResult(chojakuResult);
    uchiwakeResult.setJikangaiResult(jikangaiResult);
    uchiwakeResult.setKyujitsuResult(kyujitsuResult);

    NFMYCX0010_YusoMasterHeadBean yusoMasterHeadBean = writeHeadData(param);
    NFMYCX0010_YusoMasterBodyBean yusoMasterBodyBean = writeBodyData(param, uchiwakeResult);
    NFMYCX0010_YusoMasterBean yusoMaster = new NFMYCX0010_YusoMasterBean();

    this.settingDataForYusoMaster(yusoMaster, yusoMasterHeadBean, yusoMasterBodyBean, param);

    return yusoMaster;
  }

  /**
   * Set data to NFMYCX0010_YusoMasterBean object.
   * 
   * @param yusoMaster
   * @param yusoMasterHeadBean
   * @param yusoMasterBodyBean
   * @param param
   */
  private void settingDataForYusoMaster(NFMYCX0010_YusoMasterBean yusoMaster,
      NFMYCX0010_YusoMasterHeadBean yusoMasterHeadBean, NFMYCX0010_YusoMasterBodyBean yusoMasterBodyBean,
      NFMYCX0010_KeisanParam param) {

    yusoMaster.setSojonoShukkoBasho(param.getSojoData().getSojonoShukkoBasho());
    yusoMaster.setSojonoTorihikiShubetsu(param.getSojoData().getSojonoTorihikiShubetsu());
    yusoMaster.setSojonoOban(param.getSojoData().getSojonoOban());
    yusoMaster.setSojonoRenban(param.getSojoData().getSojonoRenban());
    yusoMaster.setHimokuCd(param.getTenkaiHimoku());

    yusoMaster.setYusoMasterHeadBean(yusoMasterHeadBean);
    yusoMaster.setYusoMasterBodyBean(yusoMasterBodyBean);
  }

  private NFMYCX0010_YusoMasterHeadBean writeHeadData(NFMYCX0010_KeisanParam param) {
    NFMYCX0010_YusoMasterHeadBean masterHead = new NFMYCX0010_YusoMasterHeadBean();
    NFMYCX0010_YusoTranBean sojoData = param.getSojoData();

    masterHead.setSeizoshoKbn(sojoData.getSeizoshoKbn());
    masterHead.setSojonoShukkoBasho(sojoData.getSojonoShukkoBasho());
    masterHead.setSojonoTorihikiShubetsu(sojoData.getSojonoTorihikiShubetsu());
    masterHead.setSojonoOban(sojoData.getSojonoOban());
    masterHead.setSojonoRenban(sojoData.getSojonoRenban());
    masterHead.setBinCd(sojoData.getBinCd());
    masterHead.setShukkaDate(sojoData.getShukkaDate());
    masterHead.setUkewatashiBasho(sojoData.getUkewatashiBasho());
    masterHead.setUkewatashiJoken(sojoData.getUkewatashiJoken());
    masterHead.setIchijiJuyoka(sojoData.getIchijiJuyoka());
    masterHead.setBuppin04(sojoData.getBuppin04());
    masterHead.setKihonYusoKyori(sojoData.getKihonYusoKyori());
    masterHead.setJuryo(sojoData.getJuryo());
    masterHead.setHeadNo(sojoData.getHeadNo());
    masterHead.setShukkoBasho(sojoData.getShukkoBasho());
    masterHead.setKeiyakunoHinshu(sojoData.getKeiyakunoHinshu());
    masterHead.setKeiyakunoKankatsu(sojoData.getKeiyakunoKankatsu());
    masterHead.setKeiyakunoMonth(sojoData.getKeiyakunoMonth());
    masterHead.setKeiyakunoOban(sojoData.getKeiyakunoOban());
    masterHead.setKeiyakunoTorihikiShubetsu(sojoData.getKeiyakunoTorihikiShubetsu());
    masterHead.setKeiyakunoYear(sojoData.getKeiyakunoYear());
    masterHead.setHeadNo(sojoData.getHeadNo());

    return masterHead;
  }

  private NFMYCX0010_YusoMasterBodyBean writeBodyData(NFMYCX0010_KeisanParam param,
      NFMYCX0010_UchiwakeResult uchiwakeResult) {

    NFMYCX0010_YusoMasterBodyBean masterBody = new NFMYCX0010_YusoMasterBodyBean();
    NFMYCX0010_YusoTranBean sojoData = param.getSojoData();
    String warimashiKuton = (sojoData.getWarimashiKuton() != null) ? sojoData.getWarimashiKuton() : "";

    String warimashiChojaku = (sojoData.getWarimashiChojaku() != null) ? sojoData.getWarimashiChojaku() : "";

    int chojaku1Juryo = (sojoData.getCho1ju() != null) ? sojoData.getCho1ju() : 0;
    int chojaku2Juryo = (sojoData.getCho2ju() != null) ? sojoData.getCho2ju() : 0;

    String warimashiJikangai = (sojoData.getWarimashiJikangai() != null) ? sojoData.getWarimashiJikangai()
        : "";

    String warimashiKyujitsu = (sojoData.getWarimashiKyujitsu() != null) ? sojoData.getWarimashiKyujitsu()
        : "";

    String binCd = StringUtil.subString(sojoData.getBinCd(), 0, 2);
    int keisanTanka = param.getKeisanTanka();
    int daisu = sojoData.getDaisu();
    int kutonRitsu = param.getKutonRitsu();
    int gokeiKingaku = 0;
    int checkKingaku = 0;
    int baseKingaku = uchiwakeResult.getBaseResult().getBaseKingaku();

    masterBody.setTsumiaiCd(sojoData.getTsumiaiCd());
    masterBody.setHimokuCd(param.getTenkaiHimoku());
    masterBody.setSojonoShukkoBasho(sojoData.getSojonoShukkoBasho());
    masterBody.setSojonoTorihikiShubetsu(sojoData.getSojonoTorihikiShubetsu());
    masterBody.setSojonoOban(sojoData.getSojonoOban());
    masterBody.setSojonoRenban(sojoData.getSojonoRenban());
    if (sojoData.getGyoshaCd().equals(BusinessConst.CodeDef.Gyoshacd.GYOSHACD_009)) {
      masterBody.setGyoshaCd(sojoData.getGyoshaCd());
    } else {
      masterBody.setGyoshaCd(param.getTenkaiGyosha());
    }

    masterBody.setDaisu(NumberUtil.nullToZero(daisu));
    masterBody.setTsumikomiMinato(sojoData.getTsumikomiMinato());
    masterBody.setAgeMinato(sojoData.getAgeMinato());
    masterBody.setTranshipTsumikomiMinato(sojoData.getTranshipTsumikomiMinato());
    masterBody.setTranshipAgeMinato(sojoData.getTranshipAgeMinato());
    masterBody.setChukeiKyori1(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    masterBody.setChukeiKyori2(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    masterBody.setNagasa(NumberUtil.nullToZero(sojoData.getNagasa()));
    masterBody.setTankaTani(param.getTankaTani());
    masterBody.setTanka(NumberUtil.nullToZero(keisanTanka));
    gokeiKingaku = uchiwakeResult.getBaseResult().getBaseKingaku()
        + uchiwakeResult.getKutonResult().getKutonKingaku()
        + uchiwakeResult.getChojakuResult().getChojakuKingaku()
        + uchiwakeResult.getJikangaiResult().getJikangaiKingaku()
        + uchiwakeResult.getJikangaiResult().getJikangaiKingaku();
    masterBody.setKingaku(NumberUtil.nullToZero(gokeiKingaku));

    if (binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_90)
        || binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_91)) {
      masterBody.setWarimashiKuton(BusinessConst.CodeDef.CheckSpace.SPACE1);
      masterBody.setWarimashiChojaku(BusinessConst.CodeDef.CheckSpace.SPACE1);
    } else if (sojoData.getBinCd().equals(BusinessConst.CodeDef.BinCd.BINCD_828)
        || sojoData.getBinCd().equals(BusinessConst.CodeDef.BinCd.BINCD_829)) {
      masterBody.setWarimashiKuton(BusinessConst.CodeDef.CheckSpace.SPACE1);
      masterBody.setWarimashiChojaku(BusinessConst.CodeDef.CheckSpace.SPACE1);
    } else if (sojoData.getShukkoBasho().equals(BusinessConst.CodeDef.ShukkoBasho.BASHO_0SF)
        && binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_16)) {
      masterBody.setWarimashiKuton(BusinessConst.CodeDef.CheckSpace.SPACE1);
      masterBody.setWarimashiChojaku(BusinessConst.CodeDef.CheckSpace.SPACE1);
    } else if (warimashiKuton.equals(BusinessConst.CodeDef.CheckSpace.SPACE1)
        || uchiwakeResult.getKutonResult().getKutonKingaku() == 0) {
      masterBody.setWarimashiKuton(BusinessConst.CodeDef.CheckSpace.SPACE1);
    } else {
      switch (kutonRitsu) {
      case 1:
        masterBody.setWarimashiKuton(BusinessConst.CodeDef.NumberValue.THREE);
        if (daisu == 0 || daisu == 1) {
          checkKingaku = keisanTanka;
        } else {
          checkKingaku = keisanTanka * daisu;
        }

        if (uchiwakeResult.getChojakuResult().getChojakuKingaku() == 0
            && uchiwakeResult.getJikangaiResult().getJikangaiKingaku() == 0
            && uchiwakeResult.getKyujitsuResult().getKyujitsuKingaku() == 0) {
          if (checkKingaku != gokeiKingaku) {
            uchiwakeResult.getBaseResult().setBaseKingaku(baseKingaku + checkKingaku - gokeiKingaku);
            masterBody.setKingaku(checkKingaku);
          }
        }
        break;

      case 7:
        masterBody.setWarimashiKuton(BusinessConst.CodeDef.NumberValue.ONE);

        if (daisu == 0 || daisu == 1) {
          checkKingaku = 7 * keisanTanka;
        } else {
          checkKingaku = 7 * keisanTanka * daisu;
        }

        if (uchiwakeResult.getChojakuResult().getChojakuKingaku() == 0
            && uchiwakeResult.getJikangaiResult().getJikangaiKingaku() == 0
            && uchiwakeResult.getKyujitsuResult().getKyujitsuKingaku() == 0) {
          if (checkKingaku != gokeiKingaku) {
            uchiwakeResult.getBaseResult().setBaseKingaku(baseKingaku + checkKingaku - gokeiKingaku);
            masterBody.setKingaku(checkKingaku);
          }
        }
        break;

      case 8:
        masterBody.setWarimashiKuton(BusinessConst.CodeDef.NumberValue.FOUR);

        if (daisu == 0 || daisu == 1) {
          checkKingaku = 8 * keisanTanka;
        } else {
          checkKingaku = 8 * keisanTanka * daisu;
        }

        if (uchiwakeResult.getChojakuResult().getChojakuKingaku() == 0
            && uchiwakeResult.getJikangaiResult().getJikangaiKingaku() == 0
            && uchiwakeResult.getKyujitsuResult().getKyujitsuKingaku() == 0) {
          if (checkKingaku != gokeiKingaku) {
            uchiwakeResult.getBaseResult().setBaseKingaku(baseKingaku + checkKingaku - gokeiKingaku);
            masterBody.setKingaku(checkKingaku);
          }
        }
        break;
      case 10:
        masterBody.setWarimashiKuton(BusinessConst.CodeDef.NumberValue.TWO);

        if (daisu == 0 || daisu == 1) {
          checkKingaku = 8 * keisanTanka;
        } else {
          checkKingaku = 8 * keisanTanka * daisu;
        }

        if (uchiwakeResult.getChojakuResult().getChojakuKingaku() == 0
            && uchiwakeResult.getJikangaiResult().getJikangaiKingaku() == 0
            && uchiwakeResult.getKyujitsuResult().getKyujitsuKingaku() == 0) {
          if (checkKingaku != gokeiKingaku) {
            uchiwakeResult.getBaseResult().setBaseKingaku(baseKingaku + checkKingaku - gokeiKingaku);
            masterBody.setKingaku(checkKingaku);
          }
        }
        break;
      }
    }

    // BO020
    if (warimashiChojaku.equals(BusinessConst.CodeDef.CheckSpace.SPACE1)) {
      masterBody.setWarimashiChojaku(BusinessConst.CodeDef.CheckSpace.SPACE1);
    } else if (chojaku2Juryo != 0) {
      masterBody.setWarimashiChojaku(BusinessConst.CodeDef.NumberValue.TWO);
    } else if (chojaku1Juryo != 0) {
      masterBody.setWarimashiChojaku(BusinessConst.CodeDef.NumberValue.ONE);
    } else {
      masterBody.setWarimashiChojaku(BusinessConst.CodeDef.CheckSpace.SPACE1);
    }

    masterBody.setWarimashiHinshu(BusinessConst.CodeDef.CheckSpace.SPACE1);
    masterBody.setWarimashiJikangai(warimashiJikangai);
    masterBody.setWarimashiKyujitsu(warimashiKyujitsu);
    masterBody.setYushutsuChukeiKbn(
        (sojoData.getYushutsuChukeiKbn() != null) ? sojoData.getYushutsuChukeiKbn() : "");
    masterBody.setYushutsuFutaisenNissu(
        (sojoData.getYushutsuFutaisenNissu() != null) ? sojoData.getYushutsuFutaisenNissu() : 0);
    masterBody.setYushutsuSokouhokanNissu(
        (sojoData.getYushutsuSokouhokanNissu() != null) ? sojoData.getYushutsuSokouhokanNissu() : 0);
    masterBody.setYushutsuKenryoRyosu(
        (sojoData.getYushutsuKenryoRyosu() != null) ? sojoData.getYushutsuKenryoRyosu() : 0);

    masterBody.setUchiwakeBaseKingaku(uchiwakeResult.getBaseResult().getBaseKingaku());
    masterBody.setUchiwakeBaseJuryo(uchiwakeResult.getBaseResult().getBaseJuryo());
    masterBody.setUchiwakeKutonKingaku(uchiwakeResult.getKutonResult().getKutonKingaku());
    masterBody.setUchiwakeKutonJuryo(uchiwakeResult.getKutonResult().getKutonJuryo());
    masterBody.setUchiwakeChojakuKingaku(uchiwakeResult.getChojakuResult().getChojakuKingaku());
    masterBody.setUchiwakeChojakuJuryo(uchiwakeResult.getChojakuResult().getChojakuJuryo());
    masterBody.setUchiwakeJikangaiKingaku(uchiwakeResult.getJikangaiResult().getJikangaiKingaku());
    masterBody.setUchiwakeJikangaiJuryo(uchiwakeResult.getJikangaiResult().getJikangaiJuryo());
    masterBody.setUchiwakeSonotaKingaku(uchiwakeResult.getKyujitsuResult().getKyujitsuKingaku());
    masterBody.setUchiwakeSonotaJuryo(uchiwakeResult.getKyujitsuResult().getKyujitsuJuryo());
    masterBody.setUchiwakeHinshuKingaku(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    masterBody.setUchiwakeHinshuJuryo(BusinessConst.CodeDef.NumberValue.NUMBER_0);

    return masterBody;
  }

  private NFMYCX0010_BaseCaculateResult caculateBaseKingaku(NFMYCX0010_KeisanParam param) {
    NFMYCX0010_BaseCaculateResult baseResult = new NFMYCX0010_BaseCaculateResult();
    NFMYCX0010_YusoTranBean sojoData = param.getSojoData();
    String binCd = StringUtil.subString(sojoData.getBinCd(), 0, 2);
    String subCd = StringUtil.subString(sojoData.getBinCd(), 2, 1);
    int baseKingaku = 0;
    int sHosho = 0;

    if (sojoData.getBetto() != null && sojoData.getBetto() != 0) {
      if (!StringUtil.subString(binCd, 0, 1).equals(BusinessConst.CodeDef.NumberValue.ONE)
          || binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_13)) {
        baseResult.setBaseKingaku(sojoData.getBetto());
        baseResult.setBaseJuryo(sojoData.getJuryo());
        param.setTankaTani(BusinessConst.CodeDef.TankaTani.TANKATANI_W);
        param.setKeisanTanka(BusinessConst.CodeDef.NumberValue.NUMBER_0);

        return baseResult;
      } else {
        sHosho = caculateSHosho(subCd);

        if (sHosho > sojoData.getJuryo()) {
          baseKingaku = new BigDecimal(sojoData.getBetto()).multiply(new BigDecimal(sojoData.getJuryo()))
              .divide(new BigDecimal(sHosho), 0, BigDecimal.ROUND_HALF_UP).intValue();

          baseResult.setBaseKingaku(baseKingaku);
          baseResult.setBaseJuryo(sojoData.getJuryo());
          param.setTankaTani(BusinessConst.CodeDef.TankaTani.TANKATANI_W);
          param.setKeisanTanka(BusinessConst.CodeDef.NumberValue.NUMBER_0);

          return baseResult;
        } else {
          baseResult.setBaseKingaku(sojoData.getBetto());
          baseResult.setBaseJuryo(sojoData.getJuryo());
          param.setTankaTani(BusinessConst.CodeDef.TankaTani.TANKATANI_W);
          param.setKeisanTanka(BusinessConst.CodeDef.NumberValue.NUMBER_0);

          return baseResult;
        }
      }
    }

    if (binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_32)
        && param.getTenkaiHimoku().equals(BusinessConst.CodeDef.TenkaiHimokucd.HIMOKU_B_SPACE)) {
      baseResult.setBaseKingaku(param.getWbaKingaku());
      baseResult.setBaseJuryo(sojoData.getJuryo());
      return baseResult;
    }

    if ((binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_11)
        || binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_12))
        && param.getTenkaiHimoku().equals(BusinessConst.CodeDef.Himokucd.HIMOKU_H1)) {
      baseResult.setBaseKingaku(param.getKeisanTanka());
      baseResult.setBaseJuryo(sojoData.getJuryo());

      return baseResult;
    }

    if (param.getTankaTani().equals(BusinessConst.CodeDef.TankaTani.TANKATANI_H)) {

    }

    if (param.getTankaTani().equals(BusinessConst.CodeDef.TankaTani.TANKATANI_K)) {
      if (param.getTenkaiHimoku().equals(BusinessConst.CodeDef.Himokucd.HIMOKU_X1)) {
        int wkKensu = sojoData.getYushutsuKenryoRyosu();
        baseKingaku = new BigDecimal(param.getKeisanTanka()).multiply(new BigDecimal(wkKensu)).intValue();

        baseResult.setBaseKingaku(baseKingaku);
        baseResult.setBaseJuryo(sojoData.getJuryo());
        return baseResult;
      }
    }

    if (param.getTankaTani().equals(BusinessConst.CodeDef.TankaTani.TANKATANI_L)) {
      if (sojoData.getJuryo() > 1000) {
        baseKingaku = new BigDecimal(param.getKeisanTanka()).multiply(new BigDecimal(sojoData.getJuryo()))
            .divide(new BigDecimal(1000), 0, BigDecimal.ROUND_HALF_UP).intValue();

        baseResult.setBaseKingaku(baseKingaku);
        baseResult.setBaseJuryo(sojoData.getJuryo());
      } else {
        if (param.getlHosho() != 0) {
          baseKingaku = new BigDecimal(param.getKeisanTanka()).multiply(new BigDecimal(sojoData.getJuryo()))
              .divide(new BigDecimal(param.getlHosho()), 0, BigDecimal.ROUND_HALF_UP).intValue();

          baseResult.setBaseKingaku(baseKingaku);
          baseResult.setBaseJuryo(sojoData.getJuryo());
        } else {
          baseResult.setBaseKingaku(BusinessConst.CodeDef.NumberValue.NUMBER_0);
          baseResult.setBaseJuryo(sojoData.getJuryo());
        }
      }

      return baseResult;
    }

    if (param.getTankaTani().equals(BusinessConst.CodeDef.TankaTani.TANKATANI_S)) {
      if (sojoData.getDaisu() == 0) {
        sHosho = new BigDecimal(param.getsHosho()).multiply(new BigDecimal(1000)).intValue();

      } else {
        sHosho = new BigDecimal(param.getsHosho()).multiply(new BigDecimal(sojoData.getDaisu()))
            .multiply(new BigDecimal(1000)).intValue();
      }

      if (sojoData.getJuryo() > sHosho) {
        baseResult.setBaseKingaku(param.getKeisanTanka());
        baseResult.setBaseJuryo(sojoData.getJuryo());
        return baseResult;
      }
      if (sHosho != 0) {
        baseKingaku = new BigDecimal(param.getKeisanTanka()).multiply(new BigDecimal(sojoData.getJuryo()))
            .divide(new BigDecimal(sHosho), 0, BigDecimal.ROUND_HALF_UP).intValue();

      } else {
        baseKingaku = 0;
      }

      if (binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_13)) {
        baseResult.setBaseJuryo(sojoData.getJuryo());
        baseResult.setBaseKingaku(baseKingaku);
        param.setKeisanTanka(baseKingaku);

        return baseResult;
      }
      baseResult.setBaseJuryo(sojoData.getJuryo());
      baseResult.setBaseKingaku(baseKingaku);

      return baseResult;
    }

    if (param.getTankaTani().equals(BusinessConst.CodeDef.TankaTani.TANKATANI_T)) {
      baseKingaku = new BigDecimal(param.getKeisanTanka()).multiply(new BigDecimal(sojoData.getJuryo()))
          .divide(new BigDecimal(1000), 0, BigDecimal.ROUND_HALF_UP).intValue();

      baseResult.setBaseKingaku(baseKingaku);
      baseResult.setBaseJuryo(sojoData.getJuryo());

      return baseResult;
    }

    if (param.getTankaTani().equals(BusinessConst.CodeDef.TankaTani.TANKATANI_H)) {
      int wkNisu = 0;
      if (param.getTenkaiHimoku().equals(BusinessConst.CodeDef.Himokucd.HIMOKU_N_SPACE)) {
        wkNisu = sojoData.getYushutsuSokouhokanNissu();
      }
      if (param.getTenkaiHimoku().equals(BusinessConst.CodeDef.Himokucd.HIMOKU_G_SPACE)) {
        wkNisu = sojoData.getYushutsuFutaisenNissu();
      }
      baseKingaku = new BigDecimal(param.getKeisanTanka()).multiply(new BigDecimal(wkNisu))
          .multiply(new BigDecimal(sojoData.getJuryo())).intValue();

      baseResult.setBaseKingaku(baseKingaku);
      baseResult.setBaseJuryo(sojoData.getJuryo());

      return baseResult;

    }

    return baseResult;
  }

  private int caculateSHosho(String subCd) {
    int sHosho = 0;
    switch (subCd) {
    case BusinessConst.CodeDef.subCdHashmap.KEY_1:
      sHosho = BusinessConst.CodeDef.NumberValue.NUMBER_1000;
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_2:
      sHosho = BusinessConst.CodeDef.NumberValue.NUMBER_2000;
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_4:
      sHosho = BusinessConst.CodeDef.NumberValue.NUMBER_4000;
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_5:
      sHosho = BusinessConst.CodeDef.NumberValue.NUMBER_5000;
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_6:
      sHosho = BusinessConst.CodeDef.NumberValue.NUMBER_6000;
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_8:
      sHosho = BusinessConst.CodeDef.NumberValue.NUMBER_8000;
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_SPACE:
      sHosho = BusinessConst.CodeDef.NumberValue.NUMBER_10000;
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_0:
      sHosho = BusinessConst.CodeDef.NumberValue.NUMBER_10000;
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_F:
      sHosho = BusinessConst.CodeDef.NumberValue.NUMBER_12000;
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_G:
      sHosho = BusinessConst.CodeDef.NumberValue.NUMBER_15000;
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_H:
      sHosho = BusinessConst.CodeDef.NumberValue.NUMBER_20000;
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_I:
      sHosho = BusinessConst.CodeDef.NumberValue.NUMBER_25000;
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_J:
      sHosho = BusinessConst.CodeDef.NumberValue.NUMBER_30000;
      break;
    }
    return sHosho;
  }

  private NFMYCX0010_KutonCaculateResult caculateKutonKingaku(NFMYCX0010_KeisanParam param) {
    NFMYCX0010_KutonCaculateResult kutonResult = new NFMYCX0010_KutonCaculateResult();
    String tankaTani = param.getTankaTani();
    int juryo = param.getSojoData().getJuryo();
    int betto = (param.getSojoData().getBetto() != null) ? param.getSojoData().getBetto() : 0;
    String binCd = StringUtil.subString(param.getSojoData().getBinCd(), 0, 2);
    String binCd11 = StringUtil.subString(param.getSojoData().getBinCd(), 0, 1);
    String subCd = StringUtil.subString(param.getSojoData().getBinCd(), 2, 1);
    int baseKingaku = 0;
    int daisu = param.getSojoData().getDaisu();
    int sHosho = param.getsHosho();
    int lHosho = param.getlHosho();

    if (betto != 0) {
      if (!binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_13)
          && binCd11.equals(BusinessConst.CodeDef.NumberValue.NUMBER_1)) {
        sHosho = caculateSHosho(subCd);
        if (sHosho > juryo) {
          baseKingaku = new BigDecimal(betto).multiply(new BigDecimal(juryo))
              .divide(new BigDecimal(sHosho), 0, BigDecimal.ROUND_HALF_UP).intValue();

          kutonResult.setKutonKingaku(betto - baseKingaku);
          kutonResult.setKutonJuryo(sHosho - juryo);
          return kutonResult;
        }
      }
    }

    if (tankaTani.equals(BusinessConst.CodeDef.TankaTani.TANKATANI_S)) {
      if (daisu == 0 || daisu == 1) {
        sHosho = new BigDecimal(param.getsHosho()).multiply(new BigDecimal(1000)).intValue();
      } else {
        sHosho = new BigDecimal(param.getsHosho()).multiply(new BigDecimal(daisu))
            .multiply(new BigDecimal(1000)).intValue();
      }
      if (juryo < sHosho && !binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_13)) {
        if (sHosho != 0) {
          baseKingaku = new BigDecimal(param.getKeisanTanka()).multiply(new BigDecimal(juryo))
              .divide(new BigDecimal(sHosho), 0, BigDecimal.ROUND_HALF_UP).intValue();

        } else {
          baseKingaku = 0;
        }
      }
      if (daisu == 0 || daisu == 1) {
        kutonResult.setKutonKingaku(param.getKeisanTanka() - baseKingaku);
        kutonResult.setKutonJuryo(sHosho - juryo);
        return kutonResult;
      } else {
        sHosho = new BigDecimal(param.getsHosho()).multiply(new BigDecimal(daisu))
            .multiply(new BigDecimal(1000)).intValue();

        kutonResult.setKutonKingaku(
            new BigDecimal(param.getKeisanTanka()).multiply(new BigDecimal(daisu)).intValue() - baseKingaku);
        kutonResult.setKutonJuryo(sHosho - juryo);
        return kutonResult;
      }
    }

    if (tankaTani.equals(BusinessConst.CodeDef.TankaTani.TANKATANI_S)) {
      if (juryo < 1000) {
        if (lHosho != 0) {
          baseKingaku = new BigDecimal(param.getKeisanTanka()).multiply(new BigDecimal(juryo))
              .divide(new BigDecimal(lHosho), 0, BigDecimal.ROUND_HALF_UP).intValue();

        } else {
          baseKingaku = 0;
        }

        kutonResult.setKutonKingaku(param.getKeisanTanka() - baseKingaku);
        kutonResult.setKutonJuryo(lHosho - juryo);
        return kutonResult;
      }
    }

    if (tankaTani.equals(BusinessConst.CodeDef.TankaTani.TANKATANI_T)) {

      if (daisu == 0 || daisu == 1) {
        param.setKuton(new BigDecimal(param.getKutonRitsu()).multiply(new BigDecimal(1000)).intValue());
      } else {
        param.setKuton(new BigDecimal(param.getKutonRitsu()).multiply(new BigDecimal(daisu))
            .multiply(new BigDecimal(1000)).intValue());
      }

      if (param.getKuton() <= juryo) {
        kutonResult.setKutonJuryo(0);
        kutonResult.setKutonKingaku(0);
      } else {
        kutonResult.setKutonJuryo(param.getKuton() - juryo);
        kutonResult.setKutonKingaku(new BigDecimal(param.getKeisanTanka())
            .multiply(new BigDecimal(new BigDecimal(param.getKuton()).intValue() - juryo))
            .divide(new BigDecimal(1000), 0, BigDecimal.ROUND_HALF_UP).intValue());
      }
      return kutonResult;
    }

    kutonResult.setKutonJuryo(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    kutonResult.setKutonKingaku(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    return kutonResult;
  }

  private NFMYCX0010_ChojakuCaculateResult caculateChojakuKingaku(NFMYCX0010_KeisanParam param) {
    NFMYCX0010_ChojakuCaculateResult chojakuResult = new NFMYCX0010_ChojakuCaculateResult();
    String tankaTani = param.getTankaTani();
    int chojakuKingaku1 = 0;
    int chojakuKingaku2 = 0;
    int chojakuJuryo1 = (param.getSojoData().getCho1ju() != null) ? param.getSojoData().getCho1ju() : 0;
    int chojakuJuryo2 = (param.getSojoData().getCho2ju() != null) ? param.getSojoData().getCho2ju() : 0;

    chojakuResult.setChojakuKingaku(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    chojakuResult.setChojakuJuryo(BusinessConst.CodeDef.NumberValue.NUMBER_0);

    if (tankaTani.equals(BusinessConst.CodeDef.TankaTani.TANKATANI_L)
        || tankaTani.equals(BusinessConst.CodeDef.TankaTani.TANKATANI_S)) {

      chojakuKingaku1 = new BigDecimal(param.getKeisanTanka()).multiply(new BigDecimal(chojakuJuryo1))
          .multiply(new BigDecimal(param.getChojakuTanka1()))
          .divide(new BigDecimal(100000), 0, BigDecimal.ROUND_HALF_UP).intValue();

      chojakuKingaku2 = new BigDecimal(param.getKeisanTanka()).multiply(new BigDecimal(chojakuJuryo2))
          .multiply(new BigDecimal(param.getChojakuTanka2()))
          .divide(new BigDecimal(100000), 0, BigDecimal.ROUND_HALF_UP).intValue();

      chojakuResult.setChojakuJuryo(chojakuJuryo1 + chojakuJuryo2);
      if (chojakuKingaku1 + chojakuKingaku2 == 0) {
        chojakuResult.setChojakuKingaku(BusinessConst.CodeDef.NumberValue.NUMBER_0);
      } else {
        chojakuResult.setChojakuKingaku(chojakuKingaku1 + chojakuKingaku2);
      }
      return chojakuResult;
    }

    if (tankaTani.equals(BusinessConst.CodeDef.TankaTani.TANKATANI_T)) {

      chojakuKingaku1 = new BigDecimal(chojakuJuryo1).multiply(new BigDecimal(param.getChojakuTanka1()))
          .divide(new BigDecimal(100000), 0, BigDecimal.ROUND_HALF_UP).intValue();

      chojakuKingaku2 = new BigDecimal(chojakuJuryo2).multiply(new BigDecimal(param.getChojakuTanka2()))
          .divide(new BigDecimal(100000), 0, BigDecimal.ROUND_HALF_UP).intValue();

      chojakuResult.setChojakuJuryo(chojakuJuryo1 + chojakuJuryo2);
      if (chojakuKingaku1 + chojakuKingaku2 == 0) {
        chojakuResult.setChojakuKingaku(BusinessConst.CodeDef.NumberValue.NUMBER_0);
      } else {
        chojakuResult.setChojakuKingaku(chojakuKingaku1 + chojakuKingaku2);
      }
    }

    return chojakuResult;
  }

  private NFMYCX0010_JikangaiCaculateResult caculateJikangaiKingaku(NFMYCX0010_KeisanParam param) {
    NFMYCX0010_JikangaiCaculateResult jikangaiResult = new NFMYCX0010_JikangaiCaculateResult();
    String tankaTani = param.getTankaTani();
    int juryo = param.getSojoData().getJuryo();
    int jikangaiJuryo = 0;
    int jikangaiKingaku = 0;

    if (tankaTani.equals(BusinessConst.CodeDef.TankaTani.TANKATANI_T)) {
      if (param.getKuton() < juryo) {
        param.setHosho(juryo);
      } else {
        param.setHosho(param.getKuton());
      }

      if (param.getJikangaiTankaTani().equals(BusinessConst.CodeDef.TankaTani.TANKATANI_T)) {
        jikangaiJuryo = juryo;
        jikangaiKingaku = new BigDecimal(param.getJikangaiTanka() * param.getHosho() / 1000)
            .setScale(0, BigDecimal.ROUND_HALF_UP).intValue();

      } else {
        jikangaiJuryo = juryo;
        jikangaiKingaku = new BigDecimal(param.getJikangaiTanka()).multiply(new BigDecimal(param.getHosho()))
            .multiply(new BigDecimal(param.getKeisanTanka()))
            .divide(new BigDecimal(100000), 0, BigDecimal.ROUND_HALF_UP).intValue();
      }
    }

    jikangaiResult.setJikangaiKingaku(jikangaiKingaku);
    jikangaiResult.setJikangaiJuryo(jikangaiJuryo);

    return jikangaiResult;
  }

  private NFMYCX0010_KyujitsuCaculateResult caculateKyujitsuKingaku(NFMYCX0010_KeisanParam param) {
    NFMYCX0010_KyujitsuCaculateResult kyujitsuResult = new NFMYCX0010_KyujitsuCaculateResult();
    String tankaTani = param.getTankaTani();
    int juryo = param.getSojoData().getJuryo();
    int kyujitsuJuryo = 0;
    int kyujitsuKingaku = 0;

    if (tankaTani.equals(BusinessConst.CodeDef.TankaTani.TANKATANI_T)) {
      if (param.getKuton() < juryo) {
        param.setHosho(juryo);
      } else {
        param.setHosho(param.getKuton());
      }

      if (param.getKyujitsuTankaTani().equals(BusinessConst.CodeDef.TankaTani.TANKATANI_T)) {
        kyujitsuJuryo = juryo;
        kyujitsuKingaku = new BigDecimal(param.getKyujitsuTanka()).multiply(new BigDecimal(param.getHosho()))
            .divide(new BigDecimal(1000), 0, BigDecimal.ROUND_HALF_UP).intValue();

      } else {
        kyujitsuJuryo = juryo;
        kyujitsuKingaku = new BigDecimal(param.getKyujitsuTanka()).multiply(new BigDecimal(param.getHosho()))
            .multiply(new BigDecimal(param.getKeisanTanka()))
            .divide(new BigDecimal(100000), 0, BigDecimal.ROUND_HALF_UP).intValue();
      }
    }

    kyujitsuResult.setKyujitsuKingaku(kyujitsuKingaku);
    kyujitsuResult.setKyujitsuJuryo(kyujitsuJuryo);
    return kyujitsuResult;
  }

  private int wariRtn(NFMYCX0010_YusoTranBean sojoData, String tenkaiHimoku) {

    int keisanTanka = 0;

    String binCd = StringUtil.subString(sojoData.getBinCd(), 0, 2);
    String preCd = StringUtil.subString(sojoData.getUkewatashiBasho(), 0, 2);
    String ukewatashiJoken = sojoData.getUkewatashiJoken();
    double wkRitsu = 0.0;
    int wkGaku = 0;

    if ((sojoData.getHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.G11)
        || sojoData.getHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.ATERISK2A))
        && binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_52)
        && tenkaiHimoku.equals(BusinessConst.CodeDef.TenkaiHimokucd.HIMOKU_F1)
        && ukewatashiJoken.equals(BusinessConst.CodeDef.UkewatashiJoken.JOKEN_49)
        && (preCd.equals(BusinessConst.CodeDef.UkeWatashiBashou.UKEWA_40)
            || preCd.equals(BusinessConst.CodeDef.UkeWatashiBashou.UKEWA_41)
            || preCd.equals(BusinessConst.CodeDef.UkeWatashiBashou.UKEWA_42)
            || preCd.equals(BusinessConst.CodeDef.UkeWatashiBashou.UKEWA_43)
            || preCd.equals(BusinessConst.CodeDef.UkeWatashiBashou.UKEWA_44)
            || preCd.equals(BusinessConst.CodeDef.UkeWatashiBashou.UKEWA_45)
            || preCd.equals(BusinessConst.CodeDef.UkeWatashiBashou.UKEWA_46))) {
      wkRitsu = 1.5;
    } else if ((sojoData.getHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.G11)
        || sojoData.getHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.ATERISK2A))
        && binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_52)
        && (tenkaiHimoku.equals(BusinessConst.CodeDef.TenkaiHimokucd.HIMOKU_F_SPACE)
            || tenkaiHimoku.equals(BusinessConst.CodeDef.TenkaiHimokucd.HIMOKU_F1))) {
      wkRitsu = 1.1;
    } else if ((sojoData.getHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.G12)
        || sojoData.getHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.G71)
        || sojoData.getHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.G72)
        || sojoData.getHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.ATERISK2B))
        && binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_52)
        && (tenkaiHimoku.equals(BusinessConst.CodeDef.TenkaiHimokucd.HIMOKU_F_SPACE)
            || tenkaiHimoku.equals(BusinessConst.CodeDef.TenkaiHimokucd.HIMOKU_F1))) {
      wkRitsu = 1.5;
    } else if ((sojoData.getHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.H41)
        || sojoData.getHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.ATERISK1P))
        && binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_52)
        && tenkaiHimoku.equals(BusinessConst.CodeDef.TenkaiHimokucd.HIMOKU_F_SPACE)) {
      wkGaku = -200;
    } else if ((sojoData.getHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.G51)
        || sojoData.getHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.G34)
        || sojoData.getHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.ATERISK7H)
        || sojoData.getHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.ATERISK7G))
        && binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_52)
        && tenkaiHimoku.equals(BusinessConst.CodeDef.TenkaiHimokucd.HIMOKU_F_SPACE)
        && preCd.equals(BusinessConst.CodeDef.UkeWatashiBashou.UKEWA_01)) {
      wkRitsu = 1.2;
    }

    if (wkRitsu != 0.0) {
      keisanTanka = new BigDecimal(wkRitsu).multiply(new BigDecimal(keisanTanka)).intValue();

    } else if (wkGaku != 0) {
      keisanTanka = keisanTanka + wkGaku;
    }
    return keisanTanka;

  }

  private NFMYCX0010_SearchResult bSearch(String subCd, SMst208Entity entity) {
    NFMYCX0010_SearchResult result = new NFMYCX0010_SearchResult();

    switch (subCd) {
    case BusinessConst.CodeDef.subCdHashmap.KEY_1:
      result.setBaseTanka(entity.getBase_tanka1());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_1);
      return result;
    case BusinessConst.CodeDef.subCdHashmap.KEY_2:
      result.setBaseTanka(entity.getBase_tanka2());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_2);
      return result;

    case BusinessConst.CodeDef.subCdHashmap.KEY_4:
      result.setBaseTanka(entity.getBase_tanka3());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_4);
      return result;

    case BusinessConst.CodeDef.subCdHashmap.KEY_5:
      result.setBaseTanka(entity.getBase_tanka4());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_5);
      return result;

    case BusinessConst.CodeDef.subCdHashmap.KEY_6:
      result.setBaseTanka(entity.getBase_tanka5());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_6);
      return result;

    case BusinessConst.CodeDef.subCdHashmap.KEY_8:
      result.setBaseTanka(entity.getBase_tanka6());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_6);
      return result;

    case BusinessConst.CodeDef.subCdHashmap.KEY_SPACE:
      result.setBaseTanka(entity.getBase_tanka7());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_10);
      return result;
    case BusinessConst.CodeDef.subCdHashmap.KEY_F:
      result.setBaseTanka(entity.getBase_tanka8());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_12);
      return result;
    case BusinessConst.CodeDef.subCdHashmap.KEY_G:
      result.setBaseTanka(entity.getBase_tanka9());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_15);
      return result;

    case BusinessConst.CodeDef.subCdHashmap.KEY_H:
      result.setBaseTanka(entity.getBase_tanka10());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_20);
      return result;

    case BusinessConst.CodeDef.subCdHashmap.KEY_I:
      result.setBaseTanka(entity.getBase_tanka11());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_25);
      return result;

    case BusinessConst.CodeDef.subCdHashmap.KEY_J:
      result.setBaseTanka(entity.getBase_tanka12());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_30);
      return result;
    }

    result.setBaseTanka(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    return result;
  }

  private NFMYCX0010_SearchResult cSearch(Integer juryo, SMst208Entity entity) {
    NFMYCX0010_SearchResult result = new NFMYCX0010_SearchResult();

    if (juryo < BusinessConst.CodeDef.NumberValue.NUMBER_100) {
      result.setBaseTanka(entity.getBase_tanka1());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_100);
      return result;
    } else if (juryo < BusinessConst.CodeDef.NumberValue.NUMBER_200) {
      result.setBaseTanka(entity.getBase_tanka2());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_200);
      return result;
    } else if (juryo < BusinessConst.CodeDef.NumberValue.NUMBER_300) {
      result.setBaseTanka(entity.getBase_tanka3());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_300);
      return result;
    } else if (juryo < BusinessConst.CodeDef.NumberValue.NUMBER_300) {
      result.setBaseTanka(entity.getBase_tanka3());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_400);
      return result;
    } else if (juryo < BusinessConst.CodeDef.NumberValue.NUMBER_400) {
      result.setBaseTanka(entity.getBase_tanka4());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_400);
      return result;
    } else if (juryo < BusinessConst.CodeDef.NumberValue.NUMBER_500) {
      result.setBaseTanka(entity.getBase_tanka5());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_500);
      return result;
    } else if (juryo < BusinessConst.CodeDef.NumberValue.NUMBER_600) {
      result.setBaseTanka(entity.getBase_tanka6());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_600);
      return result;
    } else if (juryo < BusinessConst.CodeDef.NumberValue.NUMBER_700) {
      result.setBaseTanka(entity.getBase_tanka7());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_700);
      return result;
    } else if (juryo < BusinessConst.CodeDef.NumberValue.NUMBER_800) {
      result.setBaseTanka(entity.getBase_tanka8());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_800);
      return result;
    } else if (juryo < BusinessConst.CodeDef.NumberValue.NUMBER_900) {
      result.setBaseTanka(entity.getBase_tanka9());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_900);
      return result;
    } else if (juryo < BusinessConst.CodeDef.NumberValue.NUMBER_1000) {
      result.setBaseTanka(entity.getBase_tanka10());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_1000);
      return result;
    } else {
      result.setBaseTanka(entity.getBase_tanka11());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_0);
      return result;
    }
  }

  private NFMYCX0010_SearchResult eSearch(String ukewatashiBasho, String sukkaDate, SMst208Entity entity) {
    NFMYCX0010_SearchResult result = new NFMYCX0010_SearchResult();

    String preCd = StringUtil.subString(ukewatashiBasho, 0, 2);
    String monthDate = StringUtil.subString(sukkaDate, 2, 4);
    if (monthDate.indexOf(BusinessConst.CodeDef.NumberValue.ZERO) == 0) {
      monthDate = StringUtil.subString(monthDate, 1, 3);
    }
    switch (preCd) {
    case BusinessConst.CodeDef.UkechiBasho.UKE_01:
      if (Integer.parseInt(monthDate) > 1116 || Integer.parseInt(monthDate) < 415) {
        result.setBaseTanka(entity.getBase_tanka2());
        result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_0);

      } else {
        result.setBaseTanka(entity.getBase_tanka1());
        result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_0);
      }
      return result;
    case BusinessConst.CodeDef.UkechiBasho.UKE_02:
    case BusinessConst.CodeDef.UkechiBasho.UKE_05:
    case BusinessConst.CodeDef.UkechiBasho.UKE_06:
    case BusinessConst.CodeDef.UkechiBasho.UKE_15:
    case BusinessConst.CodeDef.UkechiBasho.UKE_16:
    case BusinessConst.CodeDef.UkechiBasho.UKE_17:
    case BusinessConst.CodeDef.UkechiBasho.UKE_18:
      if (Integer.parseInt(monthDate) > 1201 || Integer.parseInt(monthDate) < 331) {
        result.setBaseTanka(entity.getBase_tanka2());
        result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_0);
      } else {
        result.setBaseTanka(entity.getBase_tanka1());
        result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_0);
      }
      return result;
    }

    result.setBaseTanka(entity.getBase_tanka1());
    result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    return result;
  }

  private NFMYCX0010_SearchResult fSearch(String nagasa, SMst208Entity entity) {
    NFMYCX0010_SearchResult result = new NFMYCX0010_SearchResult();
    if (nagasa.equals(BusinessConst.CodeDef.Nagasa.NAGASA_03)) {
      result.setBaseTanka(entity.getBase_tanka1());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    } else if (nagasa.equals(BusinessConst.CodeDef.Nagasa.NAGASA_04)) {
      result.setBaseTanka(entity.getBase_tanka2());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    } else if (nagasa.equals(BusinessConst.CodeDef.Nagasa.NAGASA_05)) {
      result.setBaseTanka(entity.getBase_tanka3());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    } else if (nagasa.equals(BusinessConst.CodeDef.Nagasa.NAGASA_06)) {
      result.setBaseTanka(entity.getBase_tanka4());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    } else if (nagasa.equals(BusinessConst.CodeDef.Nagasa.NAGASA_07)) {
      result.setBaseTanka(entity.getBase_tanka5());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    } else if (nagasa.equals(BusinessConst.CodeDef.Nagasa.NAGASA_08)) {
      result.setBaseTanka(entity.getBase_tanka6());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    } else if (nagasa.equals(BusinessConst.CodeDef.Nagasa.NAGASA_09)) {
      result.setBaseTanka(entity.getBase_tanka7());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    } else if (nagasa.equals(BusinessConst.CodeDef.Nagasa.NAGASA_10)) {
      result.setBaseTanka(entity.getBase_tanka8());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    } else if (nagasa.equals(BusinessConst.CodeDef.Nagasa.NAGASA_11)) {
      result.setBaseTanka(entity.getBase_tanka9());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    } else if (nagasa.equals(BusinessConst.CodeDef.Nagasa.NAGASA_12)) {
      result.setBaseTanka(entity.getBase_tanka10());
      result.setHosho(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    }

    // TODO Not implement code...
    return result;
  }

  private NFMYCX0010_SearchResult gSearch(Integer juryo, SMst208Entity entity) {
    // TODO Need using BigDecimal Round Up.
    NFMYCX0010_SearchResult result = new NFMYCX0010_SearchResult();
    int wgJuryo = (juryo + 999) / 1000;
    int wgAB = wgJuryo / 6;
    int wgX = wgAB;
    wgAB = wgJuryo - (6 * wgX);
    int wgY = wgAB;

    if (wgAB == 0) {
      result.setBaseTanka(entity.getBase_tanka6() * wgX);
    } else {
      switch (wgY) {
      case 1:
        result.setBaseTanka(entity.getBase_tanka1() * wgX + entity.getBase_tanka1());
        break;
      case 2:
        result.setBaseTanka(entity.getBase_tanka1() * wgX + entity.getBase_tanka2());
        break;
      case 3:
        result.setBaseTanka(entity.getBase_tanka1() * wgX + entity.getBase_tanka3());
        break;
      case 4:
        result.setBaseTanka(entity.getBase_tanka1() * wgX + entity.getBase_tanka4());
        break;
      case 5:
        result.setBaseTanka(entity.getBase_tanka1() * wgX + entity.getBase_tanka5());
        break;
      case 6:
        result.setBaseTanka(entity.getBase_tanka1() * wgX + entity.getBase_tanka6());
        break;
      case 7:
        result.setBaseTanka(entity.getBase_tanka1() * wgX + entity.getBase_tanka7());
        break;
      case 8:
        result.setBaseTanka(entity.getBase_tanka1() * wgX + entity.getBase_tanka8());
        break;
      case 9:
        result.setBaseTanka(entity.getBase_tanka1() * wgX + entity.getBase_tanka9());
        break;
      case 10:
        result.setBaseTanka(entity.getBase_tanka1() * wgX + entity.getBase_tanka10());
        break;
      case 11:
        result.setBaseTanka(entity.getBase_tanka1() * wgX + entity.getBase_tanka11());
        break;
      case 12:
        result.setBaseTanka(entity.getBase_tanka1() * wgX + entity.getBase_tanka12());
        break;
      }
    }
    return result;
  }

  private NFMYCX0010_SearchResult tSearch(Integer juryo, SMst208Entity entity) {
    NFMYCX0010_SearchResult result = new NFMYCX0010_SearchResult();
    // TODO Need using BigDecimal Round Up.
    int wgJuryo = (juryo + 99);
    int wgAB = wgJuryo / 100;
    int wgX = wgAB;

    if (wgX < 10) {
      switch (wgX) {
      case 1:
        result.setBaseTanka(entity.getBase_tanka1());
        result.setHosho(wgX * 100);
        break;
      case 2:
        result.setBaseTanka(entity.getBase_tanka2());
        result.setHosho(wgX * 100);
        break;
      case 3:
        result.setBaseTanka(entity.getBase_tanka3());
        result.setHosho(wgX * 100);
        break;
      case 4:
        result.setBaseTanka(entity.getBase_tanka4());
        result.setHosho(wgX * 100);
        break;
      case 5:
        result.setBaseTanka(entity.getBase_tanka5());
        result.setHosho(wgX * 100);
        break;
      case 6:
        result.setBaseTanka(entity.getBase_tanka6());
        result.setHosho(wgX * 100);
        break;
      case 7:
        result.setBaseTanka(entity.getBase_tanka7());
        result.setHosho(wgX * 100);
        break;
      case 8:
        result.setBaseTanka(entity.getBase_tanka8());
        result.setHosho(wgX * 100);
        break;
      case 9:
        result.setBaseTanka(entity.getBase_tanka9());
        result.setHosho(wgX * 100);
        break;
      }
    } else {
      int wgY = wgX - 10;
      result.setBaseTanka(entity.getBase_tanka10() + (entity.getBase_tanka11() * wgY));
      result.setHosho(wgX * 100);
    }
    return result;
  }

  private NFMYCX0010_HSearchResult hSearch(String subCd, SMst208Entity entity, double wkTekiyoRitsu1) {
    NFMYCX0010_HSearchResult result = new NFMYCX0010_HSearchResult();

    int baseTanka = 0;
    switch (subCd) {
    case BusinessConst.CodeDef.subCdHashmap.KEY_1:
    case BusinessConst.CodeDef.subCdHashmap.KEY_2:
      result.setBaseTanka(entity.getKoso_tanka2());
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_4:
      baseTanka = entity.getKoso_tanka3();
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_5:
      baseTanka = entity.getKoso_tanka4();
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_6:
      baseTanka = entity.getKoso_tanka5();
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_8:
      baseTanka = entity.getKoso_tanka6();
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_SPACE:
      baseTanka = entity.getKoso_tanka7();
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_0:
      baseTanka = entity.getKoso_tanka7();
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_F:
      baseTanka = entity.getKoso_tanka8();
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_G:
      baseTanka = entity.getKoso_tanka9();
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_H:
      baseTanka = entity.getKoso_tanka10();
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_I:
      baseTanka = entity.getKoso_tanka11();
      break;
    case BusinessConst.CodeDef.subCdHashmap.KEY_J:
      baseTanka = entity.getKoso_tanka12();
      break;
    }

    int kstm = entity.getKeitm();
    if (wkTekiyoRitsu1 == 0) {
      result.setBaseTanka(baseTanka);
      result.setKeisanTanka(
          new BigDecimal(baseTanka).multiply(new BigDecimal(kstm)).multiply(new BigDecimal(20)).intValue());
    } else {
      result.setKeisanTanka(new BigDecimal(baseTanka).multiply(new BigDecimal(wkTekiyoRitsu1))
          .divide(new BigDecimal(100), 0, BigDecimal.ROUND_HALF_UP).intValue());
    }

    return result;
  }

  private void caculateYusohi_Case1(List<NFMYCX0010_YusoMasterBean> yusoMasterList,
      NFMYCX0010_YusoTranBean sojoData) {
    NFMYCX0010_YusoMasterBean yusoMaster = new NFMYCX0010_YusoMasterBean();

    NFMYCX0010_YusoMasterHeadBean yusoHeadBean = new NFMYCX0010_YusoMasterHeadBean();

    NFMYCX0010_YusoMasterBodyBean yusoBodyBean = new NFMYCX0010_YusoMasterBodyBean();

    // Set gyousha = 999
    sojoData.setGyoshaCd(BusinessConst.CodeDef.Gyoshacd.GYOSHACD_999);

    // Set data to Yuso Master
    setYusoMasterHeadList_Case1(yusoHeadBean, sojoData);
    setYusoMasterBodyList_Case1(yusoBodyBean, sojoData);

    // Set data to Yuso Master Object
    yusoMaster.setYusoMasterHeadBean(yusoHeadBean);
    yusoMaster.setYusoMasterBodyBean(yusoBodyBean);

    yusoMasterList.add(yusoMaster);
  }

  private void caculateYusohi_Case2(List<NFMYCX0010_YusoMasterBean> yusoMasterList,
      NFMYCX0010_YusoTranBean sojoData) {
    NFMYCX0010_YusoMasterBean yusoMaster = new NFMYCX0010_YusoMasterBean();

    NFMYCX0010_YusoMasterHeadBean yusoHeadBean = new NFMYCX0010_YusoMasterHeadBean();

    NFMYCX0010_YusoMasterBodyBean yusoBodyBean = new NFMYCX0010_YusoMasterBodyBean();

    // Set data to Yuso Master
    setYusoMasterHeadList_Case2(yusoHeadBean, sojoData);
    setYusoMasterBodyList_Case2(yusoBodyBean, sojoData);

    // Set data to Yuso Master Object
    yusoMaster.setYusoMasterHeadBean(yusoHeadBean);
    yusoMaster.setYusoMasterBodyBean(yusoBodyBean);

    yusoMasterList.add(yusoMaster);
  }

  private void setYusoMasterHeadList_Case1(NFMYCX0010_YusoMasterHeadBean yusoHeadList,
      NFMYCX0010_YusoTranBean sojoData) {

    yusoHeadList.setSeizoshoKbn(sojoData.getSeizoshoKbn());
    yusoHeadList.setSojonoShukkoBasho(sojoData.getSojonoShukkoBasho());
    yusoHeadList.setSojonoTorihikiShubetsu(sojoData.getSojonoTorihikiShubetsu());
    yusoHeadList.setSojonoOban(sojoData.getSojonoOban());
    yusoHeadList.setSojonoRenban(sojoData.getSojonoRenban());
    yusoHeadList.setBinCd(sojoData.getBinCd());
    yusoHeadList.setShukkaDate(sojoData.getShukkaDate());
    yusoHeadList.setUkewatashiBasho(sojoData.getUkewatashiBasho());
    yusoHeadList.setUkewatashiJoken(sojoData.getUkewatashiJoken());
    yusoHeadList.setIchijiJuyoka(sojoData.getIchijiJuyoka());
    yusoHeadList.setBuppin04(sojoData.getBuppin04());
    yusoHeadList.setKihonYusoKyori(sojoData.getKihonYusoKyori());
    yusoHeadList.setJuryo(sojoData.getJuryo());
    yusoHeadList.setHeadNo(sojoData.getHeadNo());

  }

  private void setYusoMasterBodyList_Case1(NFMYCX0010_YusoMasterBodyBean yusoBodyList,
      NFMYCX0010_YusoTranBean sojoData) {

    yusoBodyList.setSeizoshoKbn(sojoData.getSeizoshoKbn());
    yusoBodyList.setSojonoShukkoBasho(sojoData.getSojonoShukkoBasho());
    yusoBodyList.setSojonoTorihikiShubetsu(sojoData.getSojonoTorihikiShubetsu());
    yusoBodyList.setSojonoOban(sojoData.getSojonoOban());
    yusoBodyList.setSojonoRenban(sojoData.getSojonoRenban());
    yusoBodyList.setHimokuCd(BusinessConst.CodeDef.Himokucd.Z_SPACE_1);
    yusoBodyList.setTankaTani(BusinessConst.CodeDef.TankaTani.TANKATANI_W);
    yusoBodyList.setTanka(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeBaseKingaku(sojoData.getBetto());
    yusoBodyList.setUchiwakeBaseJuryo(sojoData.getJuryo());
    yusoBodyList.setUchiwakeKutonKingaku(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeKutonJuryo(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeChojakuKingaku(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeChojakuJuryo(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeJikangaiKingaku(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeJikangaiJuryo(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeSonotaKingaku(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeSonotaJuryo(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeHinshuKingaku(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeBaseJuryo(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setDaisu(sojoData.getDaisu());
    yusoBodyList.setTsumiaiCd(sojoData.getTsumiaiCd());
    yusoBodyList.setTsumikomiMinato(sojoData.getTsumikomiMinato());
    yusoBodyList.setAgeMinato(sojoData.getAgeMinato());
    yusoBodyList.setTranshipTsumikomiMinato(sojoData.getTranshipTsumikomiMinato());
    yusoBodyList.setTranshipAgeMinato(sojoData.getTranshipAgeMinato());

  }

  private void setYusoMasterHeadList_Case2(NFMYCX0010_YusoMasterHeadBean yusoHeadList,
      NFMYCX0010_YusoTranBean sojoData) {

    yusoHeadList.setSeizoshoKbn(sojoData.getSeizoshoKbn());
    yusoHeadList.setSojonoShukkoBasho(sojoData.getSojonoShukkoBasho());
    yusoHeadList.setSojonoTorihikiShubetsu(sojoData.getSojonoTorihikiShubetsu());
    yusoHeadList.setSojonoOban(sojoData.getSojonoOban());
    yusoHeadList.setSojonoRenban(sojoData.getSojonoRenban());
    yusoHeadList.setBinCd(sojoData.getBinCd());
    yusoHeadList.setShukkaDate(sojoData.getShukkaDate());
    yusoHeadList.setUkewatashiBasho(sojoData.getUkewatashiBasho());
    yusoHeadList.setUkewatashiJoken(sojoData.getUkewatashiJoken());
    yusoHeadList.setIchijiJuyoka(sojoData.getIchijiJuyoka());
    yusoHeadList.setBuppin04(sojoData.getBuppin04());
    yusoHeadList.setKihonYusoKyori(sojoData.getKihonYusoKyori());
    yusoHeadList.setJuryo(sojoData.getJuryo());
    yusoHeadList.setHeadNo(sojoData.getHeadNo());

  }

  private void setYusoMasterBodyList_Case2(NFMYCX0010_YusoMasterBodyBean yusoBodyList,
      NFMYCX0010_YusoTranBean sojoData) {

    yusoBodyList.setSeizoshoKbn(sojoData.getSeizoshoKbn());
    yusoBodyList.setSojonoShukkoBasho(sojoData.getSojonoShukkoBasho());
    yusoBodyList.setSojonoTorihikiShubetsu(sojoData.getSojonoTorihikiShubetsu());
    yusoBodyList.setSojonoOban(sojoData.getSojonoOban());
    yusoBodyList.setSojonoRenban(sojoData.getSojonoRenban());
    yusoBodyList.setHimokuCd(BusinessConst.CodeDef.Himokucd.HIMOKU_A_SPACE);
    yusoBodyList.setTankaTani(BusinessConst.CodeDef.TankaTani.TANKATANI_W);
    yusoBodyList.setTanka(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeBaseKingaku(sojoData.getBetto());
    yusoBodyList.setUchiwakeBaseJuryo(sojoData.getJuryo());
    yusoBodyList.setUchiwakeKutonKingaku(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeKutonJuryo(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeChojakuKingaku(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeChojakuJuryo(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeJikangaiKingaku(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeJikangaiJuryo(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeSonotaKingaku(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeSonotaJuryo(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeHinshuKingaku(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setUchiwakeBaseJuryo(BusinessConst.CodeDef.NumberValue.NUMBER_0);
    yusoBodyList.setDaisu(sojoData.getDaisu());
    yusoBodyList.setTsumiaiCd(sojoData.getTsumiaiCd());
    yusoBodyList.setTsumikomiMinato(sojoData.getTsumikomiMinato());
    yusoBodyList.setAgeMinato(sojoData.getAgeMinato());
    yusoBodyList.setTranshipTsumikomiMinato(sojoData.getTranshipTsumikomiMinato());
    yusoBodyList.setTranshipAgeMinato(sojoData.getTranshipAgeMinato());

  }

  /**
   * @param sojoData YusoTranBean
   */
  private void convertBinCd(NFMYCX0010_YusoTranBean sojoData) {
    // Convert 便コード
    if (sojoData.getBinCd().equals(BusinessConst.CodeDef.BinCd.BINCD_11X)
        || sojoData.getBinCd().equals(BusinessConst.CodeDef.BinCd.BINCD_11Y)) {
      sojoData.setBinCd(BusinessConst.CodeDef.BinCd.BINCD_110);
    } else if (sojoData.getBinCd().equals(BusinessConst.CodeDef.BinCd.BINCD_12X)
        || sojoData.getBinCd().equals(BusinessConst.CodeDef.BinCd.BINCD_12Y)) {
      sojoData.setBinCd(BusinessConst.CodeDef.BinCd.BINCD_124);
    } else if (sojoData.getBinCd().equals(BusinessConst.CodeDef.BinCd.BINCD_18X)
        || sojoData.getBinCd().equals(BusinessConst.CodeDef.BinCd.BINCD_18Y)) {
      sojoData.setBinCd(BusinessConst.CodeDef.BinCd.BINCD_184);
    }
  }

  /**
   * @param sojoData YusoTranBean
   */
  private void convertHinshu(NFMYCX0010_YusoTranBean sojoData) {
    // Convert 品種
    if (sojoData.getKeiyakunoHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.M21)
        || sojoData.getKeiyakunoHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.M22)
        || sojoData.getKeiyakunoHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.M23)
        || sojoData.getKeiyakunoHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.M24)
        || sojoData.getKeiyakunoHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.M25)
        || sojoData.getKeiyakunoHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.M26)
        || sojoData.getKeiyakunoHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.M27)
        || sojoData.getKeiyakunoHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.M28)
        || sojoData.getKeiyakunoHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.M29)
        || sojoData.getKeiyakunoHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.M2A)
        || sojoData.getKeiyakunoHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.M2B)
        || sojoData.getKeiyakunoHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.M2C)
        || sojoData.getKeiyakunoHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.M2H)
        || sojoData.getKeiyakunoHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.M2I)
        || sojoData.getKeiyakunoHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.M2T)) {
      sojoData.setKeiyakunoHinshu(sojoData.getKeiyakunoHinshu().replace(M_CHARATER, G_CHARATER));
    } else if (sojoData.getKeiyakunoHinshu().equals(BusinessConst.CodeDef.KeiyakunoHinshu.M2Y)) {
      sojoData.setKeiyakunoHinshu(BusinessConst.CodeDef.KeiyakunoHinshu.R39);
    }
  }

  /**
   * Determine gyosha code(DCheck)
   * 
   * @param sojoData
   * @param binCd
   * @param param
   * @return
   */
  private String DCheck(NFMYCX0010_YusoTranBean sojoData, String binCd, NFMYCX0010_KeisanParam param) {

    String W4_AGYOCD = "";
    if (binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_53)
        && (param.getTenkaiHimoku().equals(BusinessConst.CodeDef.Himokucd.HIMOKU_K_SPACE)
            || param.getTenkaiHimoku().equals(BusinessConst.CodeDef.Himokucd.HIMOKU_A1))) {

      if (sojoData.getAgeMinato().equals(BusinessConst.CodeDef.AgeMinato.VALUE_0104)
          || sojoData.getAgeMinato().equals(BusinessConst.CodeDef.AgeMinato.VALUE_1283)) {
        W4_AGYOCD = sojoData.getGyoshaCd();
        param.setTenkaiGyosha(sojoData.getGyoshaCd());
      }

      if (sojoData.getAgeMinato().equals(BusinessConst.CodeDef.AgeMinato.VALUE_0185)) {
        W4_AGYOCD = BusinessConst.CodeDef.Gyoshacd.GYOSHACD_051;
        param.setTenkaiGyosha(BusinessConst.CodeDef.Gyoshacd.GYOSHACD_051);
      }

    } else {
      W4_AGYOCD = BusinessConst.CodeDef.CheckSpace.SPACE1;
      param.setTenkaiGyosha(BusinessConst.CodeDef.CheckSpace.SPACE1);
    }
    return W4_AGYOCD;
  }

  /**
   * Determine gyosha code(CCheck)
   * 
   * @param sojoData
   * @param binCd
   * @param param
   * @return
   */
  private String CCheck(NFMYCX0010_YusoTranBean sojoData, String binCd, NFMYCX0010_KeisanParam param) {

    String W4_AGYOCD = "";
    if (binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_53)
        && param.getTenkaiHimoku().equals(BusinessConst.CodeDef.Himokucd.HIMOKU_J_SPACE)) {

      if (sojoData.getTsumikomiMinato().equals(BusinessConst.CodeDef.TsumikomiMinato.TSUMIKOMIMINATO_1382)) {
        W4_AGYOCD = BusinessConst.CodeDef.Gyoshacd.GYOSHACD_001;
        param.setTenkaiGyosha(BusinessConst.CodeDef.Gyoshacd.GYOSHACD_001);
      }

      if (sojoData.getTsumikomiMinato().equals(BusinessConst.CodeDef.TsumikomiMinato.TSUMIKOMIMINATO_1283)
          || sojoData.getTsumikomiMinato()
              .equals(BusinessConst.CodeDef.TsumikomiMinato.TSUMIKOMIMINATO_1383)) {
        W4_AGYOCD = BusinessConst.CodeDef.Gyoshacd.GYOSHACD_038;
        param.setTenkaiGyosha(BusinessConst.CodeDef.Gyoshacd.GYOSHACD_038);
      }
    } else if (binCd.equals(BusinessConst.CodeDef.BinCd.BINCD_53)
        && (param.getTenkaiHimoku().equals(BusinessConst.CodeDef.Himokucd.HIMOKU_J_SPACE)
            || (param.getTenkaiHimoku().equals(BusinessConst.CodeDef.Himokucd.HIMOKU_E_SPACE))
            || (param.getTenkaiHimoku().equals(BusinessConst.CodeDef.Himokucd.HIMOKU_K_SPACE))
            || (param.getTenkaiHimoku().equals(BusinessConst.CodeDef.Himokucd.HIMOKU_A1)))) {

      if (sojoData.getAgeMinato().equals(BusinessConst.CodeDef.AgeMinato.VALUE_4704)) {
        W4_AGYOCD = BusinessConst.CodeDef.Gyoshacd.GYOSHACD_035;
        param.setTenkaiGyosha(BusinessConst.CodeDef.Gyoshacd.GYOSHACD_035);
      }

      if (sojoData.getAgeMinato().equals(BusinessConst.CodeDef.AgeMinato.VALUE_0113)
          || sojoData.getAgeMinato().equals(BusinessConst.CodeDef.AgeMinato.VALUE_2786)
          || sojoData.getAgeMinato().equals(BusinessConst.CodeDef.AgeMinato.VALUE_4002)) {
        W4_AGYOCD = BusinessConst.CodeDef.Gyoshacd.GYOSHACD_038;
        param.setTenkaiGyosha(BusinessConst.CodeDef.Gyoshacd.GYOSHACD_038);
      }
    } else {

      W4_AGYOCD = param.getTenkaiGyosha();
      if (param.getTenkaiGyosha().equals(BusinessConst.CodeDef.Gyoshacd.GYOSHACD_009)) {
        W4_AGYOCD = BusinessConst.CodeDef.Gyoshacd.GYOSHACD_007;
      }
    }

    return W4_AGYOCD;

  }
}
