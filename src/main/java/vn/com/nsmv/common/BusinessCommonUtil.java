package vn.com.nsmv.common;

public class BusinessCommonUtil {

  /**
   * Convert Nogi sukko basho from MA1,MA3 to OSH
   * 
   * @param sukkoBasho
   * @return
   */
  public static String convertNogiSukkoBasho(String sukkoBasho) {
    return (sukkoBasho.equals(BusinessConst.CodeDef.ShukkoBasho.BASHO_MA1)
        || sukkoBasho.equals(BusinessConst.CodeDef.ShukkoBasho.BASHO_MA3))
            ? BusinessConst.CodeDef.ShukkoBasho.BASHO_0SH : sukkoBasho;
  }

  // This is Update 2
  public static String createLikeQuery(String itemName) {
    return "%" + itemName + "%";
  }

  public static String removeSlash(String date) {
    if (!StringUtil.getStr(date).isEmpty()) {
      return date.replace("/", StringUtil.EMPTY_STRING);
    } else {
      return StringUtil.EMPTY_STRING;
    }
  }

  public static String removeComma(String str) {
    if (!StringUtil.getStr(str).isEmpty()) {
      return str.replace(",", StringUtil.EMPTY_STRING);
    } else {
      return StringUtil.EMPTY_STRING;
    }
  }
}
