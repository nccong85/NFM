package vn.com.nsmv.logic;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import vn.com.nsmv.bean.NFMYCX0010_AnbunItem;
import vn.com.nsmv.bean.NFMYCX0010_TsumiawaseYusoMasterBean;
import vn.com.nsmv.bean.NFMYCX0010_YusoMasterBean;
import vn.com.nsmv.bean.NFMYCX0010_YusoMasterBodyBean;
import vn.com.nsmv.common.BusinessConst;

public class NFMYCX0010_TsumiawaseAnbunLogic {

  public NFMYCX0010_TsumiawaseAnbunLogic() {
  }

  public void doSortingTsumiawaseList(List<NFMYCX0010_TsumiawaseYusoMasterBean> tsumiawaseyusoMasterList) {
    Collections.sort(tsumiawaseyusoMasterList, new NFMYCX0010_TsumiawaseDataSort());
  }

  public void extractTsumiawase(List<NFMYCX0010_YusoMasterBean> tsumiawaseyusoMasterList,
      List<NFMYCX0010_YusoMasterBean> yusoMasterAnbunList,
      List<NFMYCX0010_YusoMasterBean> tsumiawaseGokeiList) {

    NFMYCX0010_AnbunItem tsumiawaseGokei = new NFMYCX0010_AnbunItem();
    int sumBaseKingaku = 0;
    int sumKutonKingaku = 0;
    int sumChojakuKingaku = 0;
    int sumJikangaiKingaku = 0;
    int sumKyujitsuKingaku = 0;
    int sumHinshuKingaku = 0;

    int sumBaseJuryo = 0;
    int sumKutonJuryo = 0;
    int sumChojakuJuryo = 0;
    int sumJikangaiJuryo = 0;
    int sumKyujitsuJuryo = 0;
    int sumHinshuJuryo = 0;

    String wkShukkaDate = BusinessConst.CodeDef.CheckSpace.BLANK;

    String wkGyoshaCd = BusinessConst.CodeDef.CheckSpace.BLANK;

    String wkBincd = BusinessConst.CodeDef.CheckSpace.BLANK;

    String wkTsumiaiCd = BusinessConst.CodeDef.CheckSpace.BLANK;

    // NFMYCX0010_YusoMasterBean yusoMaster = new NFMYCX0010_YusoMasterBean();

    NFMYCX0010_YusoMasterBean yusoMaster = null;
    NFMYCX0010_YusoMasterBean tempGokei = null;
    int nBaseKingaku = 0;
    int nKutonKingaku = 0;
    int nChojakuKingaku = 0;
    int nJikangaiKingaku = 0;
    int nKyujitsuKingaku = 0;
    int nHinshuKingaku = 0;
    
    int nBaseJuryo = 0;
    int nKutonJuryo = 0;
    int nChojakuJuryo = 0;
    int nJikangaiJuryo = 0;
    int nKyujitsuJuryo = 0;
    int nHinshuJuryo = 0;

    for (int i = 0; i < tsumiawaseyusoMasterList.size(); i++) {
      NFMYCX0010_YusoMasterBean tsumiawaseBean = tsumiawaseyusoMasterList.get(i);

      if (tsumiawaseBean.getYusoMasterBodyBean().getTsumiaiCd()
          .equals(BusinessConst.CodeDef.Tsumiaicd.VALUE_00)) {
        yusoMasterAnbunList.add(tsumiawaseBean);
      } else {
        yusoMaster = new NFMYCX0010_YusoMasterBean();

        // Copy data to yuso master
        yusoMaster.setSojonoShukkoBasho(tsumiawaseBean.getYusoMasterHeadBean().getSojonoShukkoBasho());
        yusoMaster
            .setSojonoTorihikiShubetsu(tsumiawaseBean.getYusoMasterHeadBean().getSojonoTorihikiShubetsu());
        yusoMaster.setSojonoOban(tsumiawaseBean.getYusoMasterHeadBean().getSojonoOban());
        yusoMaster.setSojonoRenban(tsumiawaseBean.getYusoMasterHeadBean().getSojonoRenban());
        yusoMaster.setHimokuCd(tsumiawaseBean.getYusoMasterBodyBean().getHimokuCd());
        yusoMaster.setYusoMasterHeadBean(tsumiawaseBean.getYusoMasterHeadBean());
        yusoMaster.setYusoMasterBodyBean(tsumiawaseBean.getYusoMasterBodyBean());

        tempGokei = findTsumiawaseGokei(tsumiawaseBean, tsumiawaseGokeiList);

        nBaseKingaku = new BigDecimal(tsumiawaseBean.getYusoMasterBodyBean().getUchiwakeBaseJuryo())
            .multiply(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeBaseKingaku()))
            .divide(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeBaseJuryo()), 0,
                BigDecimal.ROUND_HALF_UP)
            .intValue();
        
        nBaseJuryo = new BigDecimal(tsumiawaseBean.getYusoMasterBodyBean().getUchiwakeBaseJuryo())
            .multiply(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeBaseJuryo()))
            .divide(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeBaseJuryo()), 0,
                BigDecimal.ROUND_HALF_UP)
            .intValue();
        
        yusoMaster.getYusoMasterBodyBean().setUchiwakeBaseJuryo(nBaseJuryo);
        yusoMaster.getYusoMasterBodyBean().setUchiwakeBaseKingaku(nBaseKingaku);
        
        nKutonKingaku = new BigDecimal(tsumiawaseBean.getYusoMasterBodyBean().getUchiwakeBaseJuryo())
            .multiply(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeKutonKingaku()))
            .divide(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeBaseJuryo()), 0,
                BigDecimal.ROUND_HALF_UP)
            .intValue();
        
        nKutonJuryo = new BigDecimal(tsumiawaseBean.getYusoMasterBodyBean().getUchiwakeBaseJuryo())
            .multiply(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeKutonJuryo()))
            .divide(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeBaseJuryo()), 0,
                BigDecimal.ROUND_HALF_UP)
            .intValue();
        
        yusoMaster.getYusoMasterBodyBean().setUchiwakeKutonJuryo(nKutonJuryo);
        yusoMaster.getYusoMasterBodyBean().setUchiwakeKutonKingaku(nKutonKingaku);

        nChojakuKingaku = new BigDecimal(tsumiawaseBean.getYusoMasterBodyBean().getUchiwakeBaseJuryo())
            .multiply(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeChojakuKingaku()))
            .divide(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeBaseJuryo()), 0,
                BigDecimal.ROUND_HALF_UP)
            .intValue();
        
        nChojakuJuryo = new BigDecimal(tsumiawaseBean.getYusoMasterBodyBean().getUchiwakeBaseJuryo())
            .multiply(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeChojakuJuryo()))
            .divide(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeBaseJuryo()), 0,
                BigDecimal.ROUND_HALF_UP)
            .intValue();
        
        yusoMaster.getYusoMasterBodyBean().setUchiwakeChojakuJuryo(nChojakuJuryo);
        yusoMaster.getYusoMasterBodyBean().setUchiwakeChojakuKingaku(nChojakuKingaku);
        
        nJikangaiKingaku = new BigDecimal(tsumiawaseBean.getYusoMasterBodyBean().getUchiwakeBaseJuryo())
            .multiply(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeJikangaiKingaku()))
            .divide(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeBaseJuryo()), 0,
                BigDecimal.ROUND_HALF_UP)
            .intValue();
        
        nJikangaiJuryo = new BigDecimal(tsumiawaseBean.getYusoMasterBodyBean().getUchiwakeBaseJuryo())
            .multiply(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeJikangaiJuryo()))
            .divide(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeBaseJuryo()), 0,
                BigDecimal.ROUND_HALF_UP)
            .intValue();
        
        yusoMaster.getYusoMasterBodyBean().setUchiwakeJikangaiJuryo(nJikangaiJuryo);
        yusoMaster.getYusoMasterBodyBean().setUchiwakeJikangaiKingaku(nJikangaiKingaku);
        
        nKyujitsuKingaku = new BigDecimal(tsumiawaseBean.getYusoMasterBodyBean().getUchiwakeBaseJuryo())
            .multiply(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeSonotaKingaku()))
            .divide(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeBaseJuryo()), 0,
                BigDecimal.ROUND_HALF_UP)
            .intValue();
        
        nKyujitsuJuryo = new BigDecimal(tsumiawaseBean.getYusoMasterBodyBean().getUchiwakeBaseJuryo())
            .multiply(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeSonotaJuryo()))
            .divide(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeBaseJuryo()), 0,
                BigDecimal.ROUND_HALF_UP)
            .intValue();
        
        yusoMaster.getYusoMasterBodyBean().setUchiwakeSonotaJuryo(nKyujitsuJuryo);
        yusoMaster.getYusoMasterBodyBean().setUchiwakeSonotaKingaku(nKyujitsuKingaku);
        
        nHinshuKingaku = new BigDecimal(tsumiawaseBean.getYusoMasterBodyBean().getUchiwakeBaseJuryo())
            .multiply(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeHinshuKingaku()))
            .divide(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeBaseJuryo()), 0,
                BigDecimal.ROUND_HALF_UP)
            .intValue();
        
        nHinshuJuryo = new BigDecimal(tsumiawaseBean.getYusoMasterBodyBean().getUchiwakeBaseJuryo())
            .multiply(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeHinshuJuryo()))
            .divide(new BigDecimal(tempGokei.getYusoMasterBodyBean().getUchiwakeBaseJuryo()), 0,
                BigDecimal.ROUND_HALF_UP)
            .intValue();
        
        yusoMaster.getYusoMasterBodyBean().setUchiwakeHinshuJuryo(nHinshuJuryo);
        yusoMaster.getYusoMasterBodyBean().setUchiwakeHinshuKingaku(nHinshuKingaku);
      }
    }
  }

  private NFMYCX0010_YusoMasterBean findTsumiawaseGokei(NFMYCX0010_YusoMasterBean bean,
      List<NFMYCX0010_YusoMasterBean> tsumiawaseGokeiList) {
    for (int i = 0; i < tsumiawaseGokeiList.size(); i++) {
      NFMYCX0010_YusoMasterBean gokeiBean = tsumiawaseGokeiList.get(i);

      NFMYCX0010_YusoMasterBodyBean bodyBean = bean.getYusoMasterBodyBean();
      NFMYCX0010_YusoMasterBodyBean bodyGokeiBean = gokeiBean.getYusoMasterBodyBean();

      if (bean.getYusoMasterHeadBean().getShukkaDate()
          .equals(gokeiBean.getYusoMasterHeadBean().getShukkaDate())
          && bodyBean.getGyoshaCd().equals(bodyGokeiBean.getGyoshaCd())
          && bodyBean.getTsumiaiCd().equals(bodyGokeiBean.getTsumiaiCd())) {
        return gokeiBean;
      }
    }
    return null;
  }

  private void executeAnbun(NFMYCX0010_AnbunItem tsumiawaseGokei,
      List<NFMYCX0010_TsumiawaseYusoMasterBean> anbunList,
      List<NFMYCX0010_YusoMasterBean> yusoMasterAnbunList) {
    int accumulateBaseKingaku = 0;
    int accumulateKutonKingaku = 0;
    int accumulateChojakuKingaku = 0;
    int accumulateJikangaiKingaku = 0;
    int accumulateKyujitsuKingaku = 0;
    int accumulateHinshuKingaku = 0;
    int nBaseKingaku = 0;
    int nKutonKingaku = 0;
    int nChojakuKingaku = 0;
    int nJikangaiKingaku = 0;
    int nKyujitsuKingaku = 0;
    int nHinshuKingaku = 0;

    for (int i = 0; i < anbunList.size(); i++) {
      NFMYCX0010_TsumiawaseYusoMasterBean anbun = anbunList.get(i);
      NFMYCX0010_YusoMasterBean yusoMaster = new NFMYCX0010_YusoMasterBean();

      // Copy data to yuso master
      yusoMaster.setSojonoShukkoBasho(anbun.getYusoMasterHeadBean().getSojonoShukkoBasho());
      yusoMaster.setSojonoTorihikiShubetsu(anbun.getYusoMasterHeadBean().getSojonoTorihikiShubetsu());
      yusoMaster.setSojonoOban(anbun.getYusoMasterHeadBean().getSojonoOban());
      yusoMaster.setSojonoRenban(anbun.getYusoMasterHeadBean().getSojonoRenban());
      yusoMaster.setHimokuCd(anbun.getYusoMasterBodyBean().getHimokuCd());
      yusoMaster.setYusoMasterHeadBean(anbun.getYusoMasterHeadBean());
      yusoMaster.setYusoMasterBodyBean(anbun.getYusoMasterBodyBean());

      if (i < anbunList.size() - 1) {

        // Anbun
        if (tsumiawaseGokei.getSumBaseJuryo() > 0) {
          nBaseKingaku = new BigDecimal(anbun.getYusoMasterBodyBean().getUchiwakeBaseJuryo())
              .multiply(new BigDecimal(tsumiawaseGokei.getSumBaseKingaku()))
              .divide(new BigDecimal(tsumiawaseGokei.getSumBaseJuryo()), 0, BigDecimal.ROUND_HALF_UP)
              .intValue();

          yusoMaster.getYusoMasterBodyBean().setUchiwakeBaseKingaku(nBaseKingaku);
        }

        if (tsumiawaseGokei.getSumKutonJuryo() > 0) {
          nKutonKingaku = new BigDecimal(anbun.getYusoMasterBodyBean().getUchiwakeKutonJuryo())
              .multiply(new BigDecimal(tsumiawaseGokei.getSumKutonKingaku()))
              .divide(new BigDecimal(tsumiawaseGokei.getSumKutonJuryo()), 0, BigDecimal.ROUND_HALF_UP)
              .intValue();
          yusoMaster.getYusoMasterBodyBean().setUchiwakeKutonKingaku(nKutonKingaku);
        }

        if (tsumiawaseGokei.getSumChojakuJuryo() > 0) {
          nChojakuKingaku = new BigDecimal(anbun.getYusoMasterBodyBean().getUchiwakeChojakuJuryo())
              .multiply(new BigDecimal(tsumiawaseGokei.getSumChojakuKingaku()))
              .divide(new BigDecimal(tsumiawaseGokei.getSumChojakuJuryo()), 0, BigDecimal.ROUND_HALF_UP)
              .intValue();
          yusoMaster.getYusoMasterBodyBean().setUchiwakeChojakuKingaku(nChojakuKingaku);
        }

        if (tsumiawaseGokei.getSumJikangaiJuryo() > 0) {

          nJikangaiKingaku = new BigDecimal(anbun.getYusoMasterBodyBean().getUchiwakeJikangaiJuryo())
              .multiply(new BigDecimal(tsumiawaseGokei.getSumJikangaiKingaku()))
              .divide(new BigDecimal(tsumiawaseGokei.getSumJikangaiJuryo()), 0, BigDecimal.ROUND_HALF_UP)
              .intValue();

          yusoMaster.getYusoMasterBodyBean().setUchiwakeJikangaiKingaku(nJikangaiKingaku);
        }

        if (tsumiawaseGokei.getSumKyujitsuJuryo() > 0) {
          nKyujitsuKingaku = new BigDecimal(anbun.getYusoMasterBodyBean().getUchiwakeSonotaJuryo())
              .multiply(new BigDecimal(tsumiawaseGokei.getSumKyujitsuKingaku()))
              .divide(new BigDecimal(tsumiawaseGokei.getSumKyujitsuJuryo()), 0, BigDecimal.ROUND_HALF_UP)
              .intValue();

          yusoMaster.getYusoMasterBodyBean().setUchiwakeSonotaKingaku(nKyujitsuKingaku);
        }

        if (tsumiawaseGokei.getSumHinshuJuryo() > 0) {
          nHinshuKingaku = new BigDecimal(anbun.getYusoMasterBodyBean().getUchiwakeHinshuJuryo())
              .multiply(new BigDecimal(tsumiawaseGokei.getSumHinshuKingaku()))
              .divide(new BigDecimal(tsumiawaseGokei.getSumHinshuJuryo()), 0, BigDecimal.ROUND_HALF_UP)
              .intValue();

          // Update gokei kingaku
          yusoMaster.getYusoMasterBodyBean().setKingaku(nBaseKingaku + nKutonKingaku + nChojakuKingaku
              + nJikangaiKingaku + nKyujitsuKingaku + nHinshuKingaku);

          yusoMaster.getYusoMasterBodyBean().setUchiwakeHinshuKingaku(nHinshuKingaku);
        }

        accumulateBaseKingaku += nBaseKingaku;
        accumulateKutonKingaku += nKutonKingaku;
        accumulateChojakuKingaku += nChojakuKingaku;
        accumulateJikangaiKingaku += nJikangaiKingaku;
        accumulateKyujitsuKingaku += nKyujitsuKingaku;
        accumulateHinshuKingaku += nHinshuKingaku;
      } else {
        yusoMaster.getYusoMasterBodyBean()
            .setUchiwakeBaseKingaku(tsumiawaseGokei.getSumBaseKingaku() - accumulateBaseKingaku);
        yusoMaster.getYusoMasterBodyBean()
            .setUchiwakeKutonKingaku(tsumiawaseGokei.getSumKutonKingaku() - accumulateKutonKingaku);
        yusoMaster.getYusoMasterBodyBean()
            .setUchiwakeChojakuKingaku(tsumiawaseGokei.getSumChojakuKingaku() - accumulateChojakuKingaku);
        yusoMaster.getYusoMasterBodyBean()
            .setUchiwakeJikangaiKingaku(tsumiawaseGokei.getSumKyujitsuKingaku() - accumulateJikangaiKingaku);
        yusoMaster.getYusoMasterBodyBean()
            .setUchiwakeSonotaKingaku(tsumiawaseGokei.getSumKyujitsuKingaku() - accumulateKyujitsuKingaku);
        yusoMaster.getYusoMasterBodyBean()
            .setUchiwakeHinshuKingaku(tsumiawaseGokei.getSumHinshuKingaku() - accumulateHinshuKingaku);
      }
      yusoMasterAnbunList.add(yusoMaster);
    }
  }
}
