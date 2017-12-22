package vn.com.nsmv.validator;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import vn.com.nsmv.bean.CommonSojoDataBean;
import vn.com.nsmv.common.BusinessCommonUtil;
import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.common.MessageIdConst;
import vn.com.nsmv.common.NumberUtil;
import vn.com.nsmv.common.StringUtil;

public class NFMYGX0130_SojoDataValidator implements Validator {

	@Override
	public boolean supports(Class<?> c) {
		return CommonSojoDataBean.class.isAssignableFrom(c);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ResourceBundle bundle = ResourceBundle.getBundle(BusinessConst.LocaleDef.JAPANESE_MESSAGE_RESOURCE);
		CommonSojoDataBean bean = (CommonSojoDataBean) target;

		// Check require
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "juryo", "",
				MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_REQUIRE), "重量"));

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bincd", "",
				MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_REQUIRE), "便コード"));

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gyoshacd", "",
				MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_REQUIRE), "業者コード"));

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "daisu", "",
				MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_REQUIRE), "台数"));

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "teisei_riyu", "",
				MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_REQUIRE), "修正理由"));

		// Check numeric
		if (!StringUtil.isEmpty(bean.getMinato())) {
		if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getMinato()))) {
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
		if (!StringUtil.isEmpty(bean.getJuryo01())) {
			if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getJuryo01()))) {
				errors.reject(MessageIdConst.CM_MSG_NUMERIC,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "重量１"));
			}
		}

		if (!StringUtil.isEmpty(bean.getJuryo02())) {
			if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getJuryo02()))) {
				errors.reject(MessageIdConst.CM_MSG_NUMERIC,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "重量２"));
			}
		}

		if (!StringUtil.isEmpty(bean.getJuryo03())) {
			if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getJuryo03()))) {
				errors.reject(MessageIdConst.CM_MSG_NUMERIC,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "重量３"));
			}
		}

		if (!StringUtil.isEmpty(bean.getJuryo04())) {
			if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getJuryo04()))) {
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

		if (!StringUtil.isEmpty(bean.getAge_minato())) {
			if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getAge_minato()))) {
				errors.reject(MessageIdConst.CM_MSG_NUMERIC,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "揚港"));
			}
		}

		if (!StringUtil.isEmpty(bean.getRyosu())) {
			if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getRyosu()))) {
				errors.reject(MessageIdConst.CM_MSG_NUMERIC,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "検量料数"));
			}
		}

		if (!StringUtil.isEmpty(bean.getSokouhokan())) {
			if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getSokouhokan()))) {
				errors.reject(MessageIdConst.CM_MSG_NUMERIC,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "倉庫保管日数"));
			}
		}

		if (!StringUtil.isEmpty(bean.getFutaisen())) {
			if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getFutaisen()))) {
				errors.reject(MessageIdConst.CM_MSG_NUMERIC,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "艀滞船日数"));
			}
		}
		
		if (!StringUtil.isEmpty(bean.getKyuryo())) {
			if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getKyuryo()))) {
				errors.reject(MessageIdConst.CM_MSG_NUMERIC,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "休日割増"));
			}
		}
		
		if (!StringUtil.isEmpty(bean.getBetto())) {
			if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getBetto()))) {
				errors.reject(MessageIdConst.CM_MSG_NUMERIC,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "別途協議"));
			}
		}

		if (!StringUtil.isEmpty(bean.getBetto01())) {
			if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getBetto01()))) {
				errors.reject(MessageIdConst.CM_MSG_NUMERIC,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "別途協議１"));
			}
		}

		if (!StringUtil.isEmpty(bean.getBetto02())) {
			if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getBetto02()))) {
				errors.reject(MessageIdConst.CM_MSG_NUMERIC,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "別途協議２"));
			}
		}

		if (!StringUtil.isEmpty(bean.getBetto03())) {
			if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getBetto03()))) {
				errors.reject(MessageIdConst.CM_MSG_NUMERIC,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "別途協議３"));
			}
		}

		if (!StringUtil.isEmpty(bean.getBetto04())) {
			if (!NumberUtil.isDigits(BusinessCommonUtil.removeComma(bean.getBetto04()))) {
				errors.reject(MessageIdConst.CM_MSG_NUMERIC,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_NUMERIC), "別途協議４"));
			}
		}

		// Check length
		if (!StringUtil.isEmpty(bean.getMinato())) {
			if (bean.getMinato().length() != 4) {
				errors.reject(MessageIdConst.CM_MSG_CHECK_LENGTH,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_CHECK_LENGTH), "積港", "4"));
			}
		}

		if (!StringUtil.isEmpty(bean.getAge_minato())) {
			if (bean.getAge_minato().length() != 4) {
				errors.reject(MessageIdConst.CM_MSG_CHECK_LENGTH,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_CHECK_LENGTH), "揚港", "4"));
			}
		}

		if (!StringUtil.isEmpty(bean.getGyoshacd())) {
			if (bean.getGyoshacd().length() != 3) {
				errors.reject(MessageIdConst.CM_MSG_CHECK_LENGTH,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_CHECK_LENGTH), "業者コード", "3"));
			}
		}

		if (!StringUtil.isEmpty(bean.getTsumiaicd())) {
			if (bean.getTsumiaicd().length() != 2) {
				errors.reject(MessageIdConst.CM_MSG_CHECK_LENGTH,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_CHECK_LENGTH), "積合コード", "2"));
			}
		}

		if (!StringUtil.isEmpty(bean.getBincd())) {
			if (bean.getBincd().length() != 3) {
				errors.reject(MessageIdConst.CM_MSG_CHECK_LENGTH,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_CHECK_LENGTH), "便コード", "3"));
			}
		}

		if (!StringUtil.isEmpty(bean.getBincd01())) {
			if (bean.getBincd01().length() != 3) {
				errors.reject(MessageIdConst.CM_MSG_CHECK_LENGTH,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_CHECK_LENGTH), "便コード１", "3"));
			}
		}

		if (!StringUtil.isEmpty(bean.getBincd02())) {
			if (bean.getBincd02().length() != 3) {
				errors.reject(MessageIdConst.CM_MSG_CHECK_LENGTH,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_CHECK_LENGTH), "便コード２", "3"));
			}
		}

		if (!StringUtil.isEmpty(bean.getBincd03())) {
			if (bean.getBincd03().length() != 3) {
				errors.reject(MessageIdConst.CM_MSG_CHECK_LENGTH,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_CHECK_LENGTH), "便コード３", "3"));
			}
		}

		if (!StringUtil.isEmpty(bean.getBincd04())) {
			if (bean.getBincd04().length() != 3) {
				errors.reject(MessageIdConst.CM_MSG_CHECK_LENGTH,
						MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_CHECK_LENGTH), "便コード４", "3"));
			}
		}

		// Check relation
		if ((StringUtil.isEmpty(bean.getBincd01()) && !StringUtil.isEmpty(bean.getJuryo01()))
				|| (!StringUtil.isEmpty(bean.getBincd01()) && StringUtil.isEmpty(bean.getJuryo01()))) {
			errors.reject(MessageIdConst.CM_MSG_REQUIRE,
					MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_REQUIRE), "便コード１又は重量１"));
		}

		if ((StringUtil.isEmpty(bean.getBincd02()) && !StringUtil.isEmpty(bean.getJuryo02()))
				|| (!StringUtil.isEmpty(bean.getBincd02()) && StringUtil.isEmpty(bean.getJuryo02()))) {
			errors.reject(MessageIdConst.CM_MSG_REQUIRE,
					MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_REQUIRE), "便コード２又は重量２"));
		}

		if ((StringUtil.isEmpty(bean.getBincd03()) && !StringUtil.isEmpty(bean.getJuryo03()))
				|| (!StringUtil.isEmpty(bean.getBincd03()) && StringUtil.isEmpty(bean.getJuryo03()))) {
			errors.reject(MessageIdConst.CM_MSG_REQUIRE,
					MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_REQUIRE), "便コード３又は重量３"));
		}
		if ((StringUtil.isEmpty(bean.getBincd04()) && !StringUtil.isEmpty(bean.getJuryo04()))
				|| (!StringUtil.isEmpty(bean.getBincd04()) && StringUtil.isEmpty(bean.getJuryo04()))) {
			errors.reject(MessageIdConst.CM_MSG_REQUIRE,
					MessageFormat.format(bundle.getString(MessageIdConst.CM_MSG_REQUIRE), "便コード４又は重量４"));
		}
	}
}
