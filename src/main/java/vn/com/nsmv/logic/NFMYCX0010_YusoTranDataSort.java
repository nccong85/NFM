package vn.com.nsmv.logic;

import java.util.Comparator;

import vn.com.nsmv.bean.NFMYCX0010_YusoTranBean;
import vn.com.nsmv.common.BusinessConst;

public class NFMYCX0010_YusoTranDataSort implements Comparator<NFMYCX0010_YusoTranBean> {

  @Override
  public int compare(NFMYCX0010_YusoTranBean o1, NFMYCX0010_YusoTranBean o2) {
    int comp = compareString(o1.getShukkaDate(), o2.getShukkaDate());
    if (comp != BusinessConst.CodeDef.NumberValue.NUMBER_0) {
      return comp;
    }
    comp = compareString(o1.getGyoshaCd(), o2.getGyoshaCd());
    if (comp != BusinessConst.CodeDef.NumberValue.NUMBER_0) {
      return comp;
    }
    comp = compareString(o1.getTsumiaiCd(), o2.getTsumiaiCd());
    if (comp != BusinessConst.CodeDef.NumberValue.NUMBER_0) {
      return comp;
    }
    comp = compareString(o1.getBinCd(), o2.getBinCd());
    if (comp != BusinessConst.CodeDef.NumberValue.NUMBER_0) {
      return comp;
    }
    return BusinessConst.CodeDef.NumberValue.NUMBER_0;
  }

  /**
   * Compare 2 string
   * 
   * @param s1
   * @param s2
   * @return compare result
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

  /**
   * Compare 2 number
   * 
   * @param s1
   * @param s2
   * @return compare result
   */
  private int compareNumber(Integer s1, Integer s2) {
    return s1.compareTo(s2);
  }
}
