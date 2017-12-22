package vn.com.nsmv.logic;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;

import vn.com.nsmv.bean.NFMYCX0010_YusoMasterBean;
import vn.com.nsmv.bean.NFMYCX0010_YusoMasterBodyBean;
import vn.com.nsmv.bean.NFMYCX0010_YusoMasterHeadBean;
import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.common.NumberUtil;
import vn.com.nsmv.common.StringUtil;
import vn.com.nsmv.daoImpl.SMstYusoBodyDaoImpl;
import vn.com.nsmv.daoImpl.SMstYusoHeadDaoImpl;
import vn.com.nsmv.entities.SMstYusoBodyEntity;
import vn.com.nsmv.entities.SMstYusoHeadEntity;

public class NFMYCX0010_UpdateYusoMstLogic {

  // Declare logger
  private static final Logger logger = Logger.getLogger(NFMYCX0010_UpdateYusoMstLogic.class);

  private SMstYusoHeadDaoImpl yusoMstHead;

  private SMstYusoBodyDaoImpl yusoMstBody;

  public NFMYCX0010_UpdateYusoMstLogic(SMstYusoHeadDaoImpl yusoMstHead,
      SMstYusoBodyDaoImpl yusoMstBody) {
    this.yusoMstHead = yusoMstHead;
    this.yusoMstBody = yusoMstBody;
  }

  public void updateYusoMst(List<NFMYCX0010_YusoMasterBean> yusoMstBeanList, String seizoshoKbn)
      throws Exception {

    NFMYCX0010_YusoMasterHeadBean yusoMstHeadCO = null;

    NFMYCX0010_YusoMasterHeadBean editYusoMstHeadCO = null;

    NFMYCX0010_YusoMasterBodyBean yusoMstBodyCO = null;

    int wkTeiseiKaisu = BusinessConst.CodeDef.NumberValue.NUMBER_0;

    String wkTeiseiKbn = BusinessConst.CodeDef.CheckSpace.BLANK;

    String wkSeikyuNengetsu = BusinessConst.CodeDef.CheckSpace.BLANK;

    Collections.sort(yusoMstBeanList, new NFMYCX0010_YusoMstBeanSort());

    SMstYusoHeadEntity sMstYusoHeadEntity = null;

    SMstYusoBodyEntity sMstYusoBodyEntity = null;

    List<SMstYusoHeadEntity> sMstYusoHeadEntityLst = null;

    List<SMstYusoBodyEntity> sMstYusoBodyEntityLst = null;

    // SMstYusoUchiwakeEntity sMstYusoUchiwakeEntity = null;

    for (NFMYCX0010_YusoMasterBean cYusoMstCO : yusoMstBeanList) {
      sMstYusoHeadEntity = new SMstYusoHeadEntity();

      sMstYusoHeadEntity.setSeizoshoKbn(seizoshoKbn);

      sMstYusoHeadEntity.setSojonoShukkoBasho(cYusoMstCO.getSojonoShukkoBasho());

      sMstYusoHeadEntity.setSojonoTorihikiShubetsu(cYusoMstCO.getSojonoTorihikiShubetsu());

      sMstYusoHeadEntity.setSojonoOban(cYusoMstCO.getSojonoOban());

      sMstYusoHeadEntity.setSojonoRenban(cYusoMstCO.getSojonoRenban());

      try {
        sMstYusoHeadEntityLst = yusoMstHead.selectByPrimaryKeyOrderByTeisei(sMstYusoHeadEntity);

        if (sMstYusoHeadEntityLst != null && sMstYusoHeadEntityLst.size() > 0) {
          yusoMstHeadCO = new NFMYCX0010_YusoMasterHeadBean();
          BeanUtils.copyProperties(sMstYusoHeadEntityLst.get(0), yusoMstHeadCO);

          if (BusinessConst.CodeDef.HeadTeiseiKbn.C.equals(yusoMstHeadCO.getHeadTeiseiKbn())) {
            wkTeiseiKaisu = yusoMstHeadCO.getHeadTeiseiKaisu();
            wkTeiseiKbn = BusinessConst.CodeDef.HeadTeiseiKbn.S;
          } else {
            yusoMstHeadCO.setKeirekiFlg(BusinessConst.CodeDef.NumberValue.ONE);

            sMstYusoHeadEntity = new SMstYusoHeadEntity();
            BeanUtils.copyProperties(yusoMstHeadCO, sMstYusoHeadEntity);

            yusoMstHead.updateByPrimaryKey(sMstYusoHeadEntity);

            editYusoMstHeadCO = new NFMYCX0010_YusoMasterHeadBean();
            BeanUtils.copyProperties(yusoMstHeadCO, editYusoMstHeadCO);

            editYusoMstHeadCO.setHeadTeiseiKbn(BusinessConst.CodeDef.HeadTeiseiKbn.C);

            editYusoMstHeadCO.setJuryo(NumberUtil.nullToZero(yusoMstHeadCO.getJuryo())
                * BusinessConst.CodeDef.NumberValue.MINUS_ONE);

            insertYusoMstHead(editYusoMstHeadCO, seizoshoKbn);

            wkTeiseiKaisu = yusoMstHeadCO.getHeadTeiseiKaisu();

            wkTeiseiKbn = BusinessConst.CodeDef.HeadTeiseiKbn.T;

            sMstYusoBodyEntity = new SMstYusoBodyEntity();

            sMstYusoBodyEntity.setSeizoshoKbn(seizoshoKbn);

            sMstYusoBodyEntity.setSojonoShukkoBasho(yusoMstHeadCO.getSojonoShukkoBasho());

            sMstYusoBodyEntity.setSojonoTorihikiShubetsu(yusoMstHeadCO.getSojonoTorihikiShubetsu());

            sMstYusoBodyEntity.setSojonoOban(yusoMstHeadCO.getSojonoOban());

            sMstYusoBodyEntity.setSojonoRenban(yusoMstHeadCO.getSojonoRenban());

            sMstYusoBodyEntity.setHeadTeiseiKaisu(yusoMstHeadCO.getHeadTeiseiKaisu());

            sMstYusoBodyEntity.setHeadTeiseiKbn(yusoMstHeadCO.getHeadTeiseiKbn());

            sMstYusoBodyEntity.setSeikyuNengetsu(yusoMstHeadCO.getSeikyuNengetsu());

            sMstYusoBodyEntity.setKeirekiFlg(BusinessConst.CodeDef.NumberValue.ZERO);

            try {
              sMstYusoBodyEntityLst = yusoMstBody.selectForList(sMstYusoBodyEntity);

              if (sMstYusoBodyEntityLst != null && sMstYusoBodyEntityLst.size() > 0) {
                for (SMstYusoBodyEntity sMstYusoBodyEntity2 : sMstYusoBodyEntityLst) {

                  sMstYusoBodyEntity2.setKeirekiFlg(BusinessConst.CodeDef.NumberValue.ONE);

                  yusoMstBody.updateByPrimaryKey(sMstYusoBodyEntity2);

                  yusoMstBodyCO = new NFMYCX0010_YusoMasterBodyBean();
                  BeanUtils.copyProperties(sMstYusoBodyEntity2, yusoMstBodyCO);

                  yusoMstBodyCO.setHeadTeiseiKbn(BusinessConst.CodeDef.HeadTeiseiKbn.C);

                  yusoMstBodyCO.setKingaku(NumberUtil.nullToZero(yusoMstBodyCO.getKingaku())
                      * BusinessConst.CodeDef.NumberValue.MINUS_ONE);

                  yusoMstBodyCO.setShinKingaku(NumberUtil.nullToZero(yusoMstBodyCO.getShinKingaku())
                      * BusinessConst.CodeDef.NumberValue.MINUS_ONE);

                  yusoMstBodyCO.setUchiwakeBaseJuryo(
                      NumberUtil.nullToZero(yusoMstBodyCO.getUchiwakeBaseJuryo())
                          * BusinessConst.CodeDef.NumberValue.MINUS_ONE);

                  yusoMstBodyCO.setUchiwakeBaseKingaku(
                      NumberUtil.nullToZero(yusoMstBodyCO.getUchiwakeBaseKingaku())
                          * BusinessConst.CodeDef.NumberValue.MINUS_ONE);

                  yusoMstBodyCO.setUchiwakeKutonJuryo(
                      NumberUtil.nullToZero(yusoMstBodyCO.getUchiwakeKutonJuryo())
                          * BusinessConst.CodeDef.NumberValue.MINUS_ONE);

                  yusoMstBodyCO.setUchiwakeKutonKingaku(
                      NumberUtil.nullToZero(yusoMstBodyCO.getUchiwakeKutonKingaku())
                          * BusinessConst.CodeDef.NumberValue.MINUS_ONE);

                  yusoMstBodyCO.setUchiwakeChojakuJuryo(
                      NumberUtil.nullToZero(yusoMstBodyCO.getUchiwakeChojakuJuryo())
                          * BusinessConst.CodeDef.NumberValue.MINUS_ONE);

                  yusoMstBodyCO.setUchiwakeChojakuKingaku(
                      NumberUtil.nullToZero(yusoMstBodyCO.getUchiwakeChojakuKingaku())
                          * BusinessConst.CodeDef.NumberValue.MINUS_ONE);

                  yusoMstBodyCO.setUchiwakeJikangaiJuryo(
                      NumberUtil.nullToZero(yusoMstBodyCO.getUchiwakeJikangaiJuryo())
                          * BusinessConst.CodeDef.NumberValue.MINUS_ONE);

                  yusoMstBodyCO.setUchiwakeJikangaiKingaku(
                      NumberUtil.nullToZero(yusoMstBodyCO.getUchiwakeJikangaiKingaku())
                          * BusinessConst.CodeDef.NumberValue.MINUS_ONE);

                  yusoMstBodyCO.setUchiwakeHinshuJuryo(
                      NumberUtil.nullToZero(yusoMstBodyCO.getUchiwakeHinshuJuryo())
                          * BusinessConst.CodeDef.NumberValue.MINUS_ONE);

                  yusoMstBodyCO.setUchiwakeHinshuKingaku(
                      NumberUtil.nullToZero(yusoMstBodyCO.getUchiwakeHinshuKingaku())
                          * BusinessConst.CodeDef.NumberValue.MINUS_ONE);

                  yusoMstBodyCO.setUchiwakeSonotaJuryo(
                      NumberUtil.nullToZero(yusoMstBodyCO.getUchiwakeSonotaJuryo())
                          * BusinessConst.CodeDef.NumberValue.MINUS_ONE);

                  yusoMstBodyCO.setUchiwakeSonotaKingaku(
                      NumberUtil.nullToZero(yusoMstBodyCO.getUchiwakeSonotaKingaku())
                          * BusinessConst.CodeDef.NumberValue.MINUS_ONE);

                  insertYusoMstBody(yusoMstBodyCO, seizoshoKbn);
                }
              }

            } catch (HibernateException e) {

            }
          }
        } else {
          wkTeiseiKaisu = BusinessConst.CodeDef.NumberValue.MINUS_ONE;
          wkTeiseiKbn = BusinessConst.CodeDef.BodyTeiseiKbn.S;
        }

        yusoMstHeadCO = new NFMYCX0010_YusoMasterHeadBean();
        BeanUtils.copyProperties(cYusoMstCO.getYusoMasterHeadBean(), yusoMstHeadCO);

        yusoMstHeadCO.setHeadTeiseiKbn(wkTeiseiKbn);

        yusoMstHeadCO.setHeadTeiseiKaisu(wkTeiseiKaisu + 1);

        yusoMstHeadCO.setSeikyuNengetsu(StringUtil.subString(yusoMstHeadCO.getShukkaDate(), 0, 6));

        wkSeikyuNengetsu = StringUtil.subString(yusoMstHeadCO.getShukkaDate(), 0, 6);

        yusoMstHeadCO.setKeirekiFlg(BusinessConst.CodeDef.NumberValue.ZERO);

        insertYusoMstHead(yusoMstHeadCO, seizoshoKbn);
        
        cYusoMstCO.getYusoMasterBodyBean().setHeadTeiseiKbn(wkTeiseiKbn);

        cYusoMstCO.getYusoMasterBodyBean().setHeadTeiseiKaisu(wkTeiseiKaisu + 1);

        cYusoMstCO.getYusoMasterBodyBean()
            .setBodyTeiseiKbn(BusinessConst.CodeDef.BodyTeiseiKbn.S);

        cYusoMstCO.getYusoMasterBodyBean()
            .setBodyTeiseiKaisu(BusinessConst.CodeDef.NumberValue.NUMBER_0);

        cYusoMstCO.getYusoMasterBodyBean().setSeikyuNengetsu(wkSeikyuNengetsu);

        cYusoMstCO.getYusoMasterBodyBean()
            .setKeirekiFlg(BusinessConst.CodeDef.NumberValue.ZERO);

        insertYusoMstBody(cYusoMstCO.getYusoMasterBodyBean(), seizoshoKbn);

      } catch (Exception ex) {
        logger.error(ex.getMessage());
      }
    }
  }

  private void insertYusoMstBody(NFMYCX0010_YusoMasterBodyBean yusoMstBodyCO, String seizoshoKbn) {

    SMstYusoBodyEntity sMstYusoBodyEntity = new SMstYusoBodyEntity();

    BeanUtils.copyProperties(yusoMstBodyCO, sMstYusoBodyEntity);

    sMstYusoBodyEntity.setSeizoshoKbn(seizoshoKbn);

    try {
      yusoMstBody.insert(sMstYusoBodyEntity);
    } catch (HibernateException ex) {

      logger.error(ex.getMessage());
    }

  }

  private void insertYusoMstHead(NFMYCX0010_YusoMasterHeadBean yusoMstHeadCO, String seizoshoKbn) {
    SMstYusoHeadEntity sMstYusoHeadEntity = new SMstYusoHeadEntity();

    BeanUtils.copyProperties(yusoMstHeadCO, sMstYusoHeadEntity);

    sMstYusoHeadEntity.setSeizoshoKbn(seizoshoKbn);

    try {
      yusoMstHead.insert(sMstYusoHeadEntity);
    } catch (Exception ex) {

      logger.error(ex.getMessage());
    }

  }
}
