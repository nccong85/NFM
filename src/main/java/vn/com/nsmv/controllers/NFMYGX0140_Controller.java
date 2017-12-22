package vn.com.nsmv.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.nsmv.bean.JsonResponse;
import vn.com.nsmv.bean.NFMYGX0140_Bean;
import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.common.MessageIdConst;
import vn.com.nsmv.common.StringUtil;
import vn.com.nsmv.entities.SMstUserEntity;
import vn.com.nsmv.services.NFMYGX0010_UserService;
import vn.com.nsmv.services.NFMYGX0140_YusohiUpdateService;
import vn.com.nsmv.validator.NFMYGX0140_SojoDataValidator;

/**
 * @author TayLQ create at October 18th, 2016
 */
@Controller
@RequestMapping(BusinessConst.CodeDef.ScreenId.NFMYGX0140)
public class NFMYGX0140_Controller {

	private static final Logger logger = Logger.getLogger(NFMYGX0140_Controller.class);

	@Autowired
	NFMYGX0140_SojoDataValidator nfmygx0140SojoDataValidator;
	@Autowired
	NFMYGX0140_YusohiUpdateService service;
	@Autowired
	NFMYGX0010_UserService auth;
	private static final String ITEM_VIEW = "item";
	private static final String ITEM_VIEW_SESSION = "nfmygx0140_initial";
	
	
	/**
	 * INITITAL 
	 * @param request
	 * @param model
	 * @param basho
	 * @param shubetsu
	 * @param oban
	 * @param renban
	 * @return jsp
	 */
	@RequestMapping(value = "/init/{basho}-{shubetsu}-{oban}-{renban}", method = RequestMethod.GET)
	public String init(HttpServletRequest request, Model model, @PathVariable String basho, 
		@PathVariable String shubetsu, @PathVariable String oban, @PathVariable int renban){

		// Check user into session
		HttpSession session = request.getSession();
		SMstUserEntity user = (SMstUserEntity) session.getAttribute("user");
		if (!auth.checkSessionByUser(request)) {
			return "redirect:/NFMYGX0010/login";
		}

		// Get sojo information
		NFMYGX0140_Bean bean = service.selectHeadAndBody(user.getSeizoshoKbn(), basho, shubetsu, oban, renban);
		
		if (bean!=null) {
			session.setAttribute(ITEM_VIEW_SESSION, bean);
			model.addAttribute(ITEM_VIEW, bean);
		}else{
			ResourceBundle bundle = ResourceBundle.getBundle(BusinessConst.LocaleDef.JAPANESE_MESSAGE_RESOURCE);
			model.addAttribute("error", bundle.getString(MessageIdConst.NFMYGX0140_MSG_003));
		}
		

		return BusinessConst.CodeDef.ScreenId.NFMYGX0140;
	}

	/**
	 * SAVE
	 * @param jsData
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody JsonResponse save(@RequestBody String jsData, HttpServletRequest request) {
		ResourceBundle bundle = ResourceBundle.getBundle(BusinessConst.LocaleDef.JAPANESE_MESSAGE_RESOURCE);
		JsonResponse response = new JsonResponse();
		StringBuffer result = new StringBuffer();
		Map<String, String> map = new HashMap<>();
		
		try {
			// convert Json string to java object
			ObjectMapper mapper = new ObjectMapper();
			List<NFMYGX0140_Bean> listObject = Arrays.asList(mapper.readValue(jsData.toString(), NFMYGX0140_Bean[].class));
			
			for (NFMYGX0140_Bean record : listObject) {
				if (record.getAction().equals("addNew")) {
					if (service.checkHimokuCdExist(record)) {
						response.setStatus(BusinessConst.ResponseStatus.STATUS_FAILED);
						response.setResult(bundle.getString(MessageIdConst.NFMYGX0140_MSG_007));
						return response;
					}
				}else if(record.getAction().equals("update")){
					if (!record.getHimokuCd().equals(record.getOldHimokuCd())) {
						if (service.checkHimokuCdExist(record)) {
							response.setStatus(BusinessConst.ResponseStatus.STATUS_FAILED);
							response.setResult(bundle.getString(MessageIdConst.NFMYGX0140_MSG_007));
							return response;
						}
					}
				}
			}
			
			
			
			// Check list size after convert
			if (listObject.size() > 0) {
				// Get first object
				NFMYGX0140_Bean bean = listObject.get(0);
				
				// validate all common data
				map = nfmygx0140SojoDataValidator.validateCommonData(bean);
				
				// if it has not get a error validation
				if (map.size()==0) {
					// check value change 
					String checked = nfmygx0140SojoDataValidator.checkCommonData(request, bean);
					if(checked!=null){
						// if head content was changed
						if (checked.equals(BusinessConst.CodeDef.NumberValue.ZERO)) {
							for (NFMYGX0140_Bean record : listObject) {
								service.saveOnHead(record);
								response.setStatus(BusinessConst.ResponseStatus.STATUS_OK);
								response.setResult(bundle.getString(MessageIdConst.NFMYGX0140_MSG_001));
							}

						// if body content was changed
						} else if (checked.equals(BusinessConst.CodeDef.NumberValue.ONE)) {
							
							for (NFMYGX0140_Bean record : listObject) {
								// check value change in table
								map = nfmygx0140SojoDataValidator.validateMultiRecords(record);
								if (map.size()==0) {
									service.saveOnBody(record, 0);
									response.setStatus(BusinessConst.ResponseStatus.STATUS_OK);
									response.setResult(bundle.getString(MessageIdConst.NFMYGX0140_MSG_001));
								}else{
									for (Map.Entry<String, String> m : map.entrySet()){
										result.append("●"+m.getKey()+" "+m.getValue()+"</br>");
									}
									response.setStatus(BusinessConst.ResponseStatus.STATUS_FAILED);
									response.setResult(result.toString());
									return response;
								}
							}
						} 
					// if head and body unchange then check rows into table
					} else {
						for (NFMYGX0140_Bean record : listObject) {
							// if the valueable has changed
							map = nfmygx0140SojoDataValidator.validateMultiRecords(record);
							if (map.size()==0){
								service.saveOnBody(record, 0);
								response.setStatus(BusinessConst.ResponseStatus.STATUS_OK);
								response.setResult(bundle.getString(MessageIdConst.NFMYGX0140_MSG_001));
							}else{
								for (Map.Entry<String, String> m : map.entrySet()){
									result.append("●"+m.getKey()+" "+m.getValue()+"</br>");
								}
								response.setStatus(BusinessConst.ResponseStatus.STATUS_FAILED);
								response.setResult(result.toString());
								return response;
							}
						}
					} 
				}else{
					for (Map.Entry<String, String> m : map.entrySet()){
						result.append("●"+m.getKey()+" "+m.getValue()+"</br>");
					}
					response.setStatus(BusinessConst.ResponseStatus.STATUS_FAILED);
					response.setResult(result.toString());
					return response;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return response;
	}

	/**DELETE
	 * @param jsData
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody JsonResponse delete(@RequestBody String jsData, HttpServletRequest request) {
		JsonResponse response = new JsonResponse();

		try {
			// convert Json string to java object
			ObjectMapper mapper = new ObjectMapper();
			List<NFMYGX0140_Bean> listObject = Arrays.asList(mapper.readValue(jsData.toString(), NFMYGX0140_Bean[].class));
			ResourceBundle bundle = ResourceBundle.getBundle(BusinessConst.LocaleDef.JAPANESE_MESSAGE_RESOURCE);
			// Check list size after convert
			if (listObject.size() > 0) {
				for (NFMYGX0140_Bean bean : listObject) {
					if (service.disableHimokuCd(bean)) {
						response.setStatus(BusinessConst.ResponseStatus.STATUS_OK);
						response.setResult(bundle.getString(MessageIdConst.NFMYGX0140_MSG_004));
					}else{
						response.setStatus(BusinessConst.ResponseStatus.STATUS_FAILED);
						response.setResult(bundle.getString(MessageIdConst.NFMYGX0140_MSG_005));
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return response;
	}

	/**
	 * GetBinName
	 * @param binCd
	 * @return response
	 */
	@RequestMapping(value = "/getBinName", method = RequestMethod.POST)
	public @ResponseBody JsonResponse getBinName(String binCd) {
		JsonResponse response = new JsonResponse();
		String name = StringUtil.EMPTY_STRING;
		try {
			name = service.selectBinName(binCd);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		response.setResult(name);
		return response;
	}
	
	/**
	 * GetHimokuName
	 * @param himokuCd
	 * @return response
	 */
	@RequestMapping(value = "/getHimokuName", method = RequestMethod.POST)
	public @ResponseBody JsonResponse getHimokuName(String himokuCd) {
		JsonResponse response = new JsonResponse();
		String name = StringUtil.EMPTY_STRING;
		try {
			name = service.selectHimokuName(himokuCd);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		response.setResult(name);
		return response;
	}
	
	/**
	 * GetGyoshaName
	 * @param gyoshaCd
	 * @return response
	 */
	@RequestMapping(value = "/getGyoshaName", method = RequestMethod.POST)
	public @ResponseBody JsonResponse getGyoshaName(String gyoshaCd) {
		JsonResponse response = new JsonResponse();
		String name = StringUtil.EMPTY_STRING;
		try {
			name = service.selectGyoshaName(gyoshaCd);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		response.setResult(name);
		return response;
	}
}
