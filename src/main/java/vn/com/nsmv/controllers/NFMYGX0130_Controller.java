package vn.com.nsmv.controllers;

import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.nsmv.bean.CommonSojoDataBean;
import vn.com.nsmv.bean.JsonResponse;
import vn.com.nsmv.common.BusinessCommonUtil;
import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.common.MessageIdConst;
import vn.com.nsmv.common.StringUtil;
import vn.com.nsmv.entities.SMstUserEntity;
import vn.com.nsmv.services.NFMYGX0010_UserService;
import vn.com.nsmv.services.NFMYGX0130_Service;

/**
 * Edit Sojo
 * @author TayLQ
 */
@Controller
@RequestMapping(BusinessConst.CodeDef.ScreenId.NFMYGX0130)
public class NFMYGX0130_Controller {

	// Declarative Logger
	private static final Logger logger = Logger.getLogger(NFMYGX0130_Controller.class);
	
	@Autowired
	NFMYGX0010_UserService auth;
	@Autowired
	NFMYGX0130_Service service;
	
	@Autowired
	@Qualifier("nfmygx0130SojoDataValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	/**
	 * Init page
	 * @param request
	 * @param model
	 * @param basho
	 * @param shubetsu
	 * @param oban
	 * @return jsp
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit/{basho}-{shubetsu}-{oban}", method = RequestMethod.GET)
	public String init(HttpServletRequest request, Model model, @PathVariable String basho, 
			@PathVariable String shubetsu, @PathVariable String oban) throws Exception{
		
		// Check user into session
		if (!auth.checkSessionByUser(request)) {
			return "redirect:/NFMYGX0010/login";
		}
		
		// Get user session
		HttpSession session = request.getSession();
		SMstUserEntity user = (SMstUserEntity)session.getAttribute("user");
		
		// Get records from database
		List<CommonSojoDataBean> listObject = service.selectDetailBySojoNo(user.getSeizoshoKbn(), basho, shubetsu, oban);		
		int i = 0;
		for (CommonSojoDataBean bean : listObject) {
			if (i==0) {
				model.addAttribute("item", bean);
			}else if(i>0){
				model.addAttribute("item"+i, bean);
			}
			i++;
		}
		
		model.addAttribute("size", listObject.size());
		
		return BusinessConst.CodeDef.ScreenId.NFMYGX0130;
	}

	/**
	 * Save Or insert sojo
	 * @param bean
	 * @param request
	 * @return string
	 * @throws Exception
	 */
	@RequestMapping(value ="/save", method = RequestMethod.POST)
	public @ResponseBody JsonResponse save(@Valid CommonSojoDataBean bean, BindingResult result, HttpServletRequest request){
		
		JsonResponse response = new JsonResponse();
		ResourceBundle bundle = ResourceBundle.getBundle(BusinessConst.LocaleDef.JAPANESE_MESSAGE_RESOURCE);
		// Check Validate
		if (result.hasErrors()) {
			response.setStatus(BusinessConst.ResponseStatus.STATUS_FAILED);
			response.setResult(result.getAllErrors());
			return response;
		}
		
		// Get user session
		HttpSession session = request.getSession();
		SMstUserEntity user = (SMstUserEntity)session.getAttribute("user");
		bean.setSeizokbn(user.getSeizoshoKbn());
		
		// Remove comma on numeric item
        bean.setJuryo(BusinessCommonUtil.removeComma(bean.getJuryo()));
        bean.setJuryo01(BusinessCommonUtil.removeComma(bean.getJuryo01()));
        bean.setJuryo02(BusinessCommonUtil.removeComma(bean.getJuryo02()));
        bean.setJuryo03(BusinessCommonUtil.removeComma(bean.getJuryo03()));
        bean.setJuryo04(BusinessCommonUtil.removeComma(bean.getJuryo04()));
        bean.setCho1ju(BusinessCommonUtil.removeComma(bean.getCho1ju()));
        bean.setCho2ju(BusinessCommonUtil.removeComma(bean.getCho2ju()));
        bean.setBetto(BusinessCommonUtil.removeComma(bean.getBetto()));
        bean.setBetto01(BusinessCommonUtil.removeComma(bean.getBetto01()));
        bean.setBetto02(BusinessCommonUtil.removeComma(bean.getBetto02()));
        bean.setBetto03(BusinessCommonUtil.removeComma(bean.getBetto03()));
        bean.setBetto04(BusinessCommonUtil.removeComma(bean.getBetto04()));
        bean.setDaisu(BusinessCommonUtil.removeComma(bean.getDaisu()));
		
        boolean flag = false;
		
		// UPDATE/INSERT RECORD INTO DATABASE
		try {
			// Save first record
			bean.setRenban(0);
			flag = service.saveSojo(bean);
			
			// Save second record
			if (!StringUtil.nullToEmpty(bean.getBincd01()).isEmpty()
					&& !StringUtil.nullToEmpty(bean.getJuryo01()).isEmpty()) {
				bean.setBincd(bean.getBincd01());
				bean.setJuryo(bean.getJuryo01());
				bean.setRenban(1);

				flag = service.saveSojo(bean);
			}

			// Save third record
			if (!StringUtil.nullToEmpty(bean.getBincd02()).isEmpty()
					&& !StringUtil.nullToEmpty(bean.getJuryo02()).isEmpty()) {
				bean.setBincd(bean.getBincd02());
				bean.setJuryo(bean.getJuryo02());
				bean.setRenban(2);

				flag = service.saveSojo(bean);
			}
			
			// Save fourth record
			if (!StringUtil.nullToEmpty(bean.getBincd03()).isEmpty()
					&& !StringUtil.nullToEmpty(bean.getJuryo03()).isEmpty()) {
				bean.setBincd(bean.getBincd03());
				bean.setJuryo(bean.getJuryo03());
				bean.setRenban(3);

				flag = service.saveSojo(bean);
			}
			
			// Save last record
			if (!StringUtil.nullToEmpty(bean.getBincd04()).isEmpty()
					&& !StringUtil.nullToEmpty(bean.getJuryo04()).isEmpty()) {
				bean.setBincd(bean.getBincd04());
				bean.setJuryo(bean.getJuryo04());
				bean.setRenban(4);

				flag = service.saveSojo(bean);
			}
			
			// Setting response
			if(!flag){
				 response.setStatus(BusinessConst.ResponseStatus.STATUS_FAILED);
				 response.setResult(bundle.getString(MessageIdConst.NFMYGX0130_MSG_002));
			}else{
				response.setStatus(BusinessConst.ResponseStatus.STATUS_OK);
				response.setResult(bundle.getString(MessageIdConst.NFMYGX0130_MSG_001));
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}		
		
		return response;
	}
	
	/**
	 * GetBinName
	 * @param binCd
	 * @return
	 */
	@RequestMapping(value = "/getBinName", method = RequestMethod.POST)
	public @ResponseBody JsonResponse getBinName(String binCd) {
		JsonResponse response = new JsonResponse();
		String binName = StringUtil.EMPTY_STRING;
		try {
			binName = service.selectBinName(binCd);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		response.setResult(binName);
		return response;
	}
}
