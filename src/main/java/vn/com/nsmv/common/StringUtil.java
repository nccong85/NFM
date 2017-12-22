package vn.com.nsmv.common;

import java.math.BigDecimal;
import org.apache.commons.lang3.StringUtils;
import vn.com.nsmv.common.BusinessConst;

public class StringUtil {
  /**
   * 非インスタンス化のための private コンストラクター。
   */
  private StringUtil() {
  }

  // =========================================================================
  // 定数
  // ==========
  /** 半角スペース */
  public static final String SINGLE_SPACE_STRING = " ";
  
  public static final String EMPTY_STRING = StringUtils.EMPTY;


  // =========================================================================
  // 空文字関連
  // ==========
  /**
   * 指定の文字列がnullまたは空文字である場合、真を返します。
   *
   * @param value 文字列
   * @return nullまたは空文字である場合は真。
   */
  public static boolean isEmpty(String value) {
      return StringUtils.isEmpty(value);
  }

  /**
   * 指定の文字列がnullまたは空文字である場合、真を返します。
   *
   * @param value 文字列
   * @return nullまたは空文字である場合は真。
   */
  public static boolean isEmptyWithTrim(String value) {
      return StringUtils.isEmpty(trim(value));
  }

  /**
   * addDataString
   * @param 文字
   * @param 文字
   * @return String
   */
  public static String addDataString(String str, Integer digit) {

      if (str == null) {
          str = "";
      }

      if (str.length() < digit) {
          int pad = digit - str.length();
          for (int i = 0; i < pad; i++) {
              str = str + " ";
          }
          return str;

      } else if (str.length() > digit && digit > 0) {
          str = str.substring(0, digit);
      }

      return str;
  }

  /**
   * padLeftZero
   * @param 文字
   * @param 数字
   * @return String
   */
  public static String addDataInteger(Integer number, Integer digit) {

      if (number == null) {
          number = 0;
      }
      if (number.toString().length() > digit) {
          number = Integer.valueOf(number.toString().substring(0, digit));
      }
      String format = "%1$0" + digit + "d";
      String str = String.format(format, number);

      return str;
  }

  /**
   * padLeftZero
   * @param 文字
   * @param 数字
   * @return String
   */
  public static String addDataIntegerSign(Integer number, Integer digit) {

      if (number == null) {
          number = 0;
      }
      if (number.toString().length() > digit) {
          number = Integer.valueOf(number.toString().substring(0, digit));
      }
      String format = "%1$+0" + digit + "d";
      String str = String.format(format, number);

      return str;
  }

  /**
   * 半角空白のみトリムを行います。 対象文字列がNULLの場合はNULLを返します。
   *
   * @param src
   *            トリム対象文字列
   * @return トリム後文字列
   */
  public static String trim(String src) {

      return src == null ? null : StringUtils.strip(src, SINGLE_SPACE_STRING);
  }

  /**
   * 空白を設定する
   * @param   要素数
   * @return  文字列
   */
  public static String setSpace(int len) {
      String result = "";

      for (int i = 0; i < len; i++) {
          result = result.concat(BusinessConst.CodeDef.HonshaSofuBODY.KUHAKU_SPACE_1);
      }

      return result;
  }

  /**
   * nullToEmpty
   * @param number 数字
   * @return 文字列
   */
  public static String nullToEmpty(Integer number) {
      if (number == null) {
          return StringUtils.EMPTY;
      }
      return number.toString();
  }

  /**
   * nullToEmpty
   * @param number 数字
   * @return 文字列
   */
  public static String nullToEmpty(BigDecimal number) {
      if (number == null) {
          return StringUtils.EMPTY;
      }
      return number.toString();
  }

  /**
   * nullToEmpty
   * null文字を空文字("")に変換す
   * @param str 変換前文字列
   * @return 変換後文字列
   */

  public static String nullToEmpty(String str) {
      if (str == null) {
          return StringUtils.EMPTY;
      }
      return str;
  }

  /**
   * 文字列の切り出し
   *
   * @param str 文字列
   * @param start スタート
   * @param length 長さ
   * @return 切り出した文字列
   */
  public static String subString(String str, int start, int length) {

      if (str == null || "".equals(str.trim())) {
          return "";
      }
      if (str.length() < start + length) {
          return "";
      }

      return str.substring(start, start + length);
  }


  /**
   * 文字列取得（NullPointerException対応）
   * 引数を文字列に変換した値を返す。
   *
   * @param object Object 対象文字列
   * @return String nullの場合：""
   *                文字列の場合：対象文字列
   */
  public static String getStr(Object object) {

      // 1．判定、及び戻り値の返却
      // #1 対象文字列 = null
      if (object == null) {
          // ""（空白）を返却する
          return "";
          // #1 上記以外
      } else {
          // 対象文字列を返却する
          return object.toString();

          // #1 END
      }

  }  
}
