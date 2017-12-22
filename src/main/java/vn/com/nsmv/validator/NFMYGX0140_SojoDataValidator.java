package vn.com.nsmv.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import vn.com.nsmv.bean.NFMYGX0140_Bean;
import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.common.MessageIdConst;
import vn.com.nsmv.common.StringUtil;

public class NFMYGX0140_SojoDataValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

	}

	/**
	 * checkCommonData
	 * @param request
	 * @param bean
	 * @return
	 */
	public String checkCommonData(HttpServletRequest request, NFMYGX0140_Bean bean) {

		HttpSession session = request.getSession();
		NFMYGX0140_Bean original = (NFMYGX0140_Bean) session.getAttribute("nfmygx0140_initial");

		// 便コード {14}
		if (!original.getBinCd().trim().equals(bean.getBinCd())) {
			return BusinessConst.CodeDef.NumberValue.ZERO;
		}
		// 重量 {19}
		else if (original.getJuryo() != bean.getJuryo()) {
			return BusinessConst.CodeDef.NumberValue.ZERO;
		}
		// 距離 {21}
		else if (original.getKihonYusoKyori() != bean.getKihonYusoKyori()) {
			return BusinessConst.CodeDef.NumberValue.ZERO;
		}
		// 積港 {16}
		else if (!original.getAgeMinato().trim().equals(bean.getAgeMinato())) {
			return BusinessConst.CodeDef.NumberValue.ONE;
		}
		// 揚港 {17}
		else if (!original.getAgeMinato().trim().equals(bean.getAgeMinato())) {
			return BusinessConst.CodeDef.NumberValue.ONE;
		}
		// 台数 {18}
		else if (original.getDaisu() != bean.getDaisu()) {
			return BusinessConst.CodeDef.NumberValue.ONE;
		}
		// 積合コード {20}
		else if (!original.getTsumiaiCd().trim().equals(bean.getTsumiaiCd())) {
			return BusinessConst.CodeDef.NumberValue.ONE;
		}

		return null;
	}

	/**
	 * Check value change body before execute statement
	 * 
	 * @param entity
	 * @param bean
	 * @return boolean
	 */
	public Map<String, String> validateCommonData(NFMYGX0140_Bean bean) {

		ResourceBundle bundle = ResourceBundle.getBundle(BusinessConst.LocaleDef.JAPANESE_MESSAGE_RESOURCE);
		Map<String, String> result = new HashMap<>();
		
		// ==== VALIDATE HEAD VALUE ===
		// 便コード {14}
		if (StringUtil.isEmpty(bean.getBinCd())) {
			result.put("便コード", bundle.getString(MessageIdConst.NFMYGX0140_MSG_REQUIRE));
		} else {
			if (bean.getBinCd().length() != 3) {
				result.put("便コード", bundle.getString(MessageIdConst.NFMYGX0140_MSG_LENGTH));
			}
		}

		// 台数
		if (bean.getDaisu() ==0) {
			result.put("台数", bundle.getString(MessageIdConst.NFMYGX0140_MSG_INVALID_ZERO));
		}
		
		// 重量
		if (bean.getJuryo() ==0) {
			result.put("重量", bundle.getString(MessageIdConst.NFMYGX0140_MSG_INVALID_ZERO));
		}
		
		// ==== VALIDATE BODY VALUE ===
		// 積港 {16}
		if (!StringUtil.isEmpty(bean.getTsumikomiMinato())) {
			if (bean.getTsumikomiMinato().length() != 4) {
				result.put("積港", bundle.getString(MessageIdConst.NFMYGX0140_MSG_LENGTH));
			}
		}

		// 揚港 {17}
		if (!StringUtil.isEmpty(bean.getAgeMinato())) {
			if (bean.getAgeMinato().length() != 4) {
				result.put("揚港", bundle.getString(MessageIdConst.NFMYGX0140_MSG_LENGTH));
			}
		}

		// 積合コード {20}
		if (!StringUtil.isEmpty(bean.getTsumiaiCd())) {
			if (bean.getTsumiaiCd().length() != 2) {
				result.put("積合コード", bundle.getString(MessageIdConst.NFMYGX0140_MSG_LENGTH));
			}
		}
		
		return result;
	}

	/**
	 * validateMultiRecords
	 * @param bean
	 * @return map
	 */
	public Map<String, String> validateMultiRecords(NFMYGX0140_Bean bean) {

		Map<String, String> result = new HashMap<>();
		ResourceBundle bundle = ResourceBundle.getBundle(BusinessConst.LocaleDef.JAPANESE_MESSAGE_RESOURCE);
		
		// if action = update >> HimokuCd and Seikunengetsu are disable on HTML
		if (bean.getAction().equals(MessageIdConst.NFMYGX0140_ACT_UPDATE)) {
			// 業者
			if (StringUtil.isEmpty(bean.getGyoshaCd())) {
				result.put("業者", bundle.getString(MessageIdConst.NFMYGX0140_MSG_REQUIRE));
			} else {
				if (bean.getGyoshaCd().length() != 3) {
					result.put("業者", bundle.getString(MessageIdConst.NFMYGX0140_MSG_LENGTH));
				}
			}

			// 単位単価
			if (StringUtil.isEmpty(bean.getTankaTani())) {
				result.put("単位単価", bundle.getString(MessageIdConst.NFMYGX0140_MSG_REQUIRE));
			} else {
				if (bean.getTankaTani().length() != 1) {
					result.put("単位単価", bundle.getString(MessageIdConst.NFMYGX0140_MSG_LENGTH));
				}
			}
			
		} else if (bean.getAction().equals(MessageIdConst.NFMYGX0140_ACT_ADD)) {
			if (!StringUtil.isEmpty(bean.getHimokuCd()) || !StringUtil.isEmpty(bean.getGyoshaCd())
					|| !StringUtil.isEmpty(bean.getSeikyuNengetsu()) || !StringUtil.isEmpty(bean.getTankaTani()) 
					|| bean.getUchiwakeBaseJuryo()!=0 || bean.getUchiwakeBaseKingaku()!=0
					|| bean.getUchiwakeKutonJuryo()!=0 || bean.getUchiwakeKutonKingaku()!=0
					|| bean.getUchiwakeChoJakuJuryo()!=0 || bean.getUchiwakeChojakuKingaku()!=0
					|| bean.getUchiwakeJikangaiJuryo()!=0 || bean.getUchiwakeJikagaiKingaku()!=0
					|| bean.getUchiwakeSonotaJuryo()!=0 || bean.getUchiwakeSonotaKingaku()!=0) {
				// 費目 {23}
				if (StringUtil.isEmpty(bean.getHimokuCd())) {
					result.put("費目", bundle.getString(MessageIdConst.NFMYGX0140_MSG_REQUIRE));
				}
				// 業者 {24}
				if (StringUtil.isEmpty(bean.getGyoshaCd())) {
					result.put("業者", bundle.getString(MessageIdConst.NFMYGX0140_MSG_REQUIRE));
				} else if (bean.getGyoshaCd().length() != 3) {
					result.put("業者", bundle.getString(MessageIdConst.NFMYGX0140_MSG_LENGTH));
				}
				// 請求年月 {25}
				if (StringUtil.isEmpty(bean.getSeikyuNengetsu())) {
					result.put("請求年月", bundle.getString(MessageIdConst.NFMYGX0140_MSG_REQUIRE));
				} else if (bean.getSeikyuNengetsu().length() != 6) {
					result.put("請求年月", bundle.getString(MessageIdConst.NFMYGX0140_MSG_LENGTH));
				}
				// 単位単価 {26}
				if (StringUtil.isEmpty(bean.getTankaTani())) {
					result.put("単位単価", bundle.getString(MessageIdConst.NFMYGX0140_MSG_REQUIRE));
				} else if (bean.getTankaTani().length() != 1) {
					result.put("単位単価", bundle.getString(MessageIdConst.NFMYGX0140_MSG_LENGTH));
				}
				
			}
		}
		// 修正理由
		if (StringUtil.isEmpty(bean.getTeiseiRiyu())) {
			result.put("修正理由", bundle.getString(MessageIdConst.NFMYGX0140_MSG_REQUIRE));
		}
		return result;
	}

}
