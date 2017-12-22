package vn.com.nsmv.validator;

import java.util.ResourceBundle;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vn.com.nsmv.bean.NFMYGX0100_SearchBean;
import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.common.MessageIdConst;
import vn.com.nsmv.common.StringUtil;

public class NFMYGX0100_SearchConditionValidator implements Validator {

  @Override
  public boolean supports(Class<?> c) {
    return NFMYGX0100_SearchBean.class.isAssignableFrom(c);
  }

  @Override
  public void validate(Object target, Errors errors) {

    ResourceBundle bundle = ResourceBundle.getBundle(BusinessConst.LocaleDef.JAPANESE_MESSAGE_RESOURCE);
    NFMYGX0100_SearchBean bean = (NFMYGX0100_SearchBean) target;
    String pattern = "";
    Pattern r = null;
    Matcher m = null;

    // Check is number Ukewatashibasho
    if (!StringUtil.isEmpty(bean.getSearchUkewatashiBasho())) {
      pattern = "\\d{0,4}";
      r = Pattern.compile(pattern);
      m = r.matcher(bean.getSearchUkewatashiBasho());
      if (!m.matches()) {
        errors.reject(MessageIdConst.NFMYGX0100_MSG_003,
            String.format(bundle.getString(MessageIdConst.NFMYGX0100_MSG_003), "送状番号"));
      }
    }

    // Check is number GyoshaCd
    if (!StringUtil.isEmpty(bean.getSearchYusoGyoshaCd())) {
      pattern = "\\d{0,3}";
      r = Pattern.compile(pattern);
      m = r.matcher(bean.getSearchYusoGyoshaCd());
      if (!m.matches()) {
        errors.reject(MessageIdConst.NFMYGX0100_MSG_004, bundle.getString(MessageIdConst.NFMYGX0100_MSG_004));
      }
    }

    // Check is number TsumiawaseCd
    if (!StringUtil.isEmpty(bean.getSearchTsumiaiCd())) {
      pattern = "\\d{0,2}";
      r = Pattern.compile(pattern);
      m = r.matcher(bean.getSearchTsumiaiCd());
      if (!m.matches()) {
        errors.reject(MessageIdConst.NFMYGX0100_MSG_005, bundle.getString(MessageIdConst.NFMYGX0100_MSG_005));
      }
    }

    // Check is number Seikyu Nengetsu
    if (!StringUtil.isEmpty(bean.getSearchSeikyuYearMonth())) {
      pattern = "\\d{0,6}";
      r = Pattern.compile(pattern);
      m = r.matcher(bean.getSearchSeikyuYearMonth());
      if (!m.matches()) {
        errors.reject(MessageIdConst.NFMYGX0100_MSG_006, bundle.getString(MessageIdConst.NFMYGX0100_MSG_006));
      }
    }
  }
}
