package vn.com.nsmv.validator;

import java.util.ResourceBundle;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import vn.com.nsmv.bean.NFMYGX0120_SojoDataBean;
import vn.com.nsmv.common.BusinessCommonUtil;
import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.common.MessageIdConst;
import vn.com.nsmv.common.NumberUtil;
import vn.com.nsmv.common.StringUtil;

import java.text.MessageFormat;

public class NFMYGX0120_SojoDataValidator implements Validator {

  @Override
  public boolean supports(Class<?> c) {
    return NFMYGX0120_SojoDataBean.class.isAssignableFrom(c);
  }

  @Override
  public void validate(Object target, Errors errors) {
    ResourceBundle bundle = ResourceBundle.getBundle(BusinessConst.LocaleDef.JAPANESE_MESSAGE_RESOURCE);
    NFMYGX0120_SojoDataBean bean = (NFMYGX0120_SojoDataBean) target;

    // Check require
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sojoNo", "",
        MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_REQUIRE), "送状番号"));

    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "binCd", "",
        MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_REQUIRE), "重量"));

    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "binCd", "",
        MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_REQUIRE), "便コード"));

    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gyoshaCd", "",
        MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_REQUIRE), "業者コード"));

    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "daisu", "",
        MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_REQUIRE), "台数"));

    // Check numeric
    if (!StringUtil.isEmpty(bean.getTsumikomiMinato())) {
      if (!NumberUtil.isDigits(bean.getTsumikomiMinato())) {
        errors.reject(MessageIdConst.CM_MSG_NUMERIC,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "積港"));
      }
    }

    if (!StringUtil.isEmpty(bean.getJuryo())) {
      if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getJuryo()))) {
        errors.reject(MessageIdConst.CM_MSG_NUMERIC,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "重量"));
      }
    }

    if (!StringUtil.isEmpty(bean.getJuryo1())) {
      if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getJuryo1()))) {
        errors.reject(MessageIdConst.CM_MSG_NUMERIC,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "重量１"));
      }
    }

    if (!StringUtil.isEmpty(bean.getJuryo2())) {
      if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getJuryo2()))) {
        errors.reject(MessageIdConst.CM_MSG_NUMERIC,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "重量２"));
      }
    }

    if (!StringUtil.isEmpty(bean.getJuryo3())) {
      if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getJuryo3()))) {
        errors.reject(MessageIdConst.CM_MSG_NUMERIC,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "重量３"));
      }
    }

    if (!StringUtil.isEmpty(bean.getJuryo4())) {
      if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getJuryo4()))) {
        errors.reject(MessageIdConst.CM_MSG_NUMERIC,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "重量４"));
      }
    }

    if (!StringUtil.isEmpty(bean.getCho1ju())) {
      if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getCho1ju()))) {
        errors.reject(MessageIdConst.CM_MSG_NUMERIC,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "長尺１重量"));
      }
    }

    if (!StringUtil.isEmpty(bean.getCho2ju())) {
      if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getCho2ju()))) {
        errors.reject(MessageIdConst.CM_MSG_NUMERIC,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "長尺２重量"));
      }
    }

    if (!StringUtil.isEmpty(bean.getDaisu())) {
      if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getDaisu()))) {
        errors.reject(MessageIdConst.CM_MSG_NUMERIC,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "台数"));
      }
    }

    if (!StringUtil.isEmpty(bean.getAgeMinato())) {
      if (!NumberUtil.isDigits(bean.getAgeMinato())) {
        errors.reject(MessageIdConst.CM_MSG_NUMERIC,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "揚港"));
      }
    }

    if (!StringUtil.isEmpty(bean.getYushutsuKenryoRyosu())) {
      if (!NumberUtil.isDigits(bean.getYushutsuKenryoRyosu())) {
        errors.reject(MessageIdConst.CM_MSG_NUMERIC,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "検量料数"));
      }
    }

    if (!StringUtil.isEmpty(bean.getYushutsuSokouhokanNissu())) {
      if (!NumberUtil.isDigits(bean.getYushutsuSokouhokanNissu())) {
        errors.reject(MessageIdConst.CM_MSG_NUMERIC,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "倉庫保管日数"));
      }
    }

    if (!StringUtil.isEmpty(bean.getYushutsuFutaisenNissu())) {
      if (!NumberUtil.isDigits(bean.getYushutsuFutaisenNissu())) {
        errors.reject(MessageIdConst.CM_MSG_NUMERIC,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "艀滞船日数"));
      }
    }

    if (!StringUtil.isEmpty(bean.getBetto())) {
      if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getBetto()))) {
        errors.reject(MessageIdConst.CM_MSG_NUMERIC,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "別途協議"));
      }
    }
    
    if (!StringUtil.isEmpty(bean.getBetto1())) {
      if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getBetto1()))) {
        errors.reject(MessageIdConst.CM_MSG_NUMERIC,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "別途協議１"));
      }
    }
    
    if (!StringUtil.isEmpty(bean.getBetto2())) {
      if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getBetto2()))) {
        errors.reject(MessageIdConst.CM_MSG_NUMERIC,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "別途協議２"));
      }
    }
    
    if (!StringUtil.isEmpty(bean.getBetto3())) {
      if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getBetto3()))) {
        errors.reject(MessageIdConst.CM_MSG_NUMERIC,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "別途協議３"));
      }
    }
    
    if (!StringUtil.isEmpty(bean.getBetto4())) {
      if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getBetto4()))) {
        errors.reject(MessageIdConst.CM_MSG_NUMERIC,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "別途協議４"));
      }
    }

    // Check length
    if (!StringUtil.isEmpty(bean.getTsumikomiMinato())) {
      if (bean.getTsumikomiMinato().length() != 4) {
        errors.reject(MessageIdConst.CM_MSG_CHECK_LENGTH,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_CHECK_LENGTH), "積港", "4"));
      }
    }

    if (!StringUtil.isEmpty(bean.getAgeMinato())) {
      if (bean.getAgeMinato().length() != 4) {
        errors.reject(MessageIdConst.CM_MSG_CHECK_LENGTH,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_CHECK_LENGTH), "揚港", "4"));
      }
    }

    if (!StringUtil.isEmpty(bean.getGyoshaCd())) {
      if (bean.getGyoshaCd().length() != 3) {
        errors.reject(MessageIdConst.CM_MSG_CHECK_LENGTH,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_CHECK_LENGTH), "業者コード", "3"));
      }
    }

    if (!StringUtil.isEmpty(bean.getTsumiaiCd())) {
      if (bean.getTsumiaiCd().length() != 2) {
        errors.reject(MessageIdConst.CM_MSG_CHECK_LENGTH,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_CHECK_LENGTH), "積合コード", "2"));
      }
    }

    if (!StringUtil.isEmpty(bean.getBinCd())) {
      if (bean.getBinCd().length() != 3) {
        errors.reject(MessageIdConst.CM_MSG_CHECK_LENGTH,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_CHECK_LENGTH), "便コード", "3"));
      }
    }

    if (!StringUtil.isEmpty(bean.getBinCd1())) {
      if (bean.getBinCd().length() != 3) {
        errors.reject(MessageIdConst.CM_MSG_CHECK_LENGTH,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_CHECK_LENGTH), "便コード１", "3"));
      }
    }

    if (!StringUtil.isEmpty(bean.getBinCd2())) {
      if (bean.getBinCd2().length() != 3) {
        errors.reject(MessageIdConst.CM_MSG_CHECK_LENGTH,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_CHECK_LENGTH), "便コード２", "3"));
      }
    }

    if (!StringUtil.isEmpty(bean.getBinCd3())) {
      if (bean.getBinCd3().length() != 3) {
        errors.reject(MessageIdConst.CM_MSG_CHECK_LENGTH,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_CHECK_LENGTH), "便コード３", "3"));
      }
    }

    if (!StringUtil.isEmpty(bean.getBinCd4())) {
      if (bean.getBinCd4().length() != 3) {
        errors.reject(MessageIdConst.CM_MSG_CHECK_LENGTH,
            MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_CHECK_LENGTH), "便コード４", "3"));
      }
    }

    // Check relation
    if ((StringUtil.isEmpty(bean.getBinCd1()) && !StringUtil.isEmpty(bean.getJuryo1()))
        || (!StringUtil.isEmpty(bean.getBinCd1()) && StringUtil.isEmpty(bean.getJuryo1()))) {
      errors.reject(MessageIdConst.CM_MSG_REQUIRE,
          MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_REQUIRE), "便コード１又は重量１"));
    }

    if ((StringUtil.isEmpty(bean.getBinCd2()) && !StringUtil.isEmpty(bean.getJuryo2()))
        || (!StringUtil.isEmpty(bean.getBinCd2()) && StringUtil.isEmpty(bean.getJuryo2()))) {
      errors.reject(MessageIdConst.CM_MSG_REQUIRE,
          MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_REQUIRE), "便コード２又は重量２"));
    }

    if ((StringUtil.isEmpty(bean.getBinCd3()) && !StringUtil.isEmpty(bean.getJuryo3()))
        || (!StringUtil.isEmpty(bean.getBinCd3()) && StringUtil.isEmpty(bean.getJuryo3()))) {
      errors.reject(MessageIdConst.CM_MSG_REQUIRE,
          MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_REQUIRE), "便コード３又は重量３"));
    }

    if ((StringUtil.isEmpty(bean.getBinCd4()) && !StringUtil.isEmpty(bean.getJuryo4()))
        || (!StringUtil.isEmpty(bean.getBinCd4()) && StringUtil.isEmpty(bean.getJuryo4()))) {
      errors.reject(MessageIdConst.CM_MSG_REQUIRE,
          MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_REQUIRE), "便コード４又は重量４"));
    }
  }
}
