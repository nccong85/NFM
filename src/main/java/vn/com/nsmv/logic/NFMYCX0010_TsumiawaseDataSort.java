package vn.com.nsmv.logic;

import java.util.Comparator;

import vn.com.nsmv.bean.NFMYCX0010_TsumiawaseYusoMasterBean;
import vn.com.nsmv.common.BusinessConst;

public class NFMYCX0010_TsumiawaseDataSort implements Comparator<NFMYCX0010_TsumiawaseYusoMasterBean> {

  public int compare(NFMYCX0010_TsumiawaseYusoMasterBean o1, NFMYCX0010_TsumiawaseYusoMasterBean o2) {
    int comp = compareString(o1.getShukkaDate(), o2.getShukkaDate());
    if (comp != BusinessConst.CodeDef.NumberValue.NUMBER_0) {
      return comp;
    }
    comp = compareString(o1.getGyoshacd(), o2.getGyoshacd());
    if (comp != BusinessConst.CodeDef.NumberValue.NUMBER_0) {
      return comp;
    }
    comp = compareString(o1.getTsumiaicd(), o2.getTsumiaicd());
    if (comp != BusinessConst.CodeDef.NumberValue.NUMBER_0) {
      return comp;
    }
    comp = compareString(o1.getBincd(), o2.getBincd());
    if (comp != BusinessConst.CodeDef.NumberValue.NUMBER_0) {
      return comp;
    }
    comp = compareString(o1.getHimokucd(), o2.getHimokucd());
    if (comp != BusinessConst.CodeDef.NumberValue.NUMBER_0) {
      return comp;
    }
    return BusinessConst.CodeDef.NumberValue.NUMBER_0;
  }

  /**
   * ２つの文字列を比較する
   * 
   * @param s1 文字
   * @param s2 文字
   * @return 字数
   */
  private int compareString(String s1, String s2) {
    if (s1 == null && s2 == null) {
      return BusinessConst.CodeDef.NumberValue.NUMBER_0;
    } else if (s1 == null) {
      return BusinessConst.CodeDef.NumberValue.MINUS_ONE;
    } else if (s2 == null) {
      return BusinessConst.CodeDef.NumberValue.NUMBER_1;
    } else {
      return s1.compareTo(s2);
    }
  }

}
