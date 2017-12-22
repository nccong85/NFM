package vn.com.nsmv.logic;

import java.util.Comparator;

import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.bean.NFMYCX0010_YusoMasterBean;;

public class NFMYCX0010_YusoMstBeanSort implements Comparator<NFMYCX0010_YusoMasterBean> {

  public int compare(NFMYCX0010_YusoMasterBean o1, NFMYCX0010_YusoMasterBean o2) {
    int comp = compareString(o1.getSeizoshoKbn(), o2.getSeizoshoKbn());
    if (comp != BusinessConst.CodeDef.NumberValue.NUMBER_0) {
      return comp;
    }
    comp = compareString(o1.getSojonoShukkoBasho(), o2.getSojonoShukkoBasho());
    if (comp != BusinessConst.CodeDef.NumberValue.NUMBER_0) {
      return comp;
    }
    comp = compareString(o1.getSojonoTorihikiShubetsu(), o2.getSojonoTorihikiShubetsu());
    if (comp != BusinessConst.CodeDef.NumberValue.NUMBER_0) {
      return comp;
    }
    comp = compareString(o1.getSojonoOban(), o2.getSojonoOban());
    if (comp != BusinessConst.CodeDef.NumberValue.NUMBER_0) {
      return comp;
    }

    comp = compareNumber(o1.getSojonoRenban(), o2.getSojonoRenban());
    if (comp != BusinessConst.CodeDef.NumberValue.NUMBER_0) {
      return comp;
    }

    comp = compareString(o1.getHimokuCd(), o2.getHimokuCd());
    if (comp != BusinessConst.CodeDef.NumberValue.NUMBER_0) {
      return comp;
    }
    return BusinessConst.CodeDef.NumberValue.NUMBER_0;
  }

  
  /**
   * Compare 2 string
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
   * @param s1
   * @param s2
   * @return compare result
   */
  private int compareNumber(Integer s1, Integer s2) {
    return s1.compareTo(s2);
  }
}
