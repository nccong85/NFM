package vn.com.nsmv.validator;

import java.util.ResourceBundle;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import vn.com.nsmv.bean.NFMYGX0100_Bean;
import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.common.MessageIdConst;
import vn.com.nsmv.entities.Users;

public class ValidateForm implements Validator {

	@Override
	public boolean supports(Class<?> c) {
		return Users.class.isAssignableFrom(c);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", MessageIdConst.NFMYGX0010_MSG_001,
				"Username is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", MessageIdConst.NFMYGX0010_MSG_002,
				"Password is required");
	}

	public String checkValidateNFMYGX0100(NFMYGX0100_Bean bean) {

		String dateFrom = bean.getShukkadatefrom();
		String dateTo = bean.getShukkadateto();
		String tSumiawaseCd = bean.getTsumiawasecd();
		ResourceBundle bundle = ResourceBundle.getBundle("messages_ja_JP");
		// Validate all of searching conditions, If the conditions are blank
		// that's mean pass condition
		if ((bean.getSojonoshukkobasho() == null || bean.getSojonoshukkobasho() == "")
				&& (bean.getSojonotorihikishubetsu() == null || bean.getSojonotorihikishubetsu() == "")
				&& (bean.getSojonooban() == null || bean.getSojonooban() == "") && (dateFrom == null || dateFrom == "")
				&& (dateTo == null || dateTo == "") && (bean.getWatashibasho() == null || bean.getWatashibasho() == "")
				&& (bean.getGyoushacd() == null || bean.getGyoushacd() == "")
				&& (bean.getHimokucd() == null || bean.getHimokucd() == "")
				&& (bean.getTsumiawasecd() == null || bean.getTsumiawasecd() == "")
				&& (bean.getSeikyunengetsu() == null || bean.getSeikyunengetsu() == "")) {

			return bundle.getString(MessageIdConst.CM_MSG_004);
		} else if (dateFrom!="" && dateTo!=""){
			if (!dateFrom.matches(MessageIdConst.DATE_REGEX)) {
				return "出荷日 format is 'yyyy/MM/dd'";
			}
			if (!dateTo.matches(MessageIdConst.DATE_REGEX)) {
				return "{出荷日 format is 'yyyy/MM/dd'";
			}
			
		}else if (tSumiawaseCd!="") {
			if (!tSumiawaseCd.matches("\\d")) {
				return "積合 is number 1->9 and 2 character";
			}
		}

		return BusinessConst.ResponseStatus.STATUS_OK;
	}

}
