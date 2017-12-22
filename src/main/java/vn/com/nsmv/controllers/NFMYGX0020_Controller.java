package vn.com.nsmv.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.services.NFMYGX0010_UserService;

@Controller
@RequestMapping(BusinessConst.CodeDef.ScreenId.NFMYGX0020)
public class NFMYGX0020_Controller {
	
	// I'M A MAIN VIEW	
	@Autowired
	NFMYGX0010_UserService service;
	
	/**
	 * Init initial main view
	 * @param model
	 * @param request
	 * @return jsp
	 */
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(Model model, HttpServletRequest request) {
		// Check user into session
		if (!service.checkSessionByUser(request)) {
			return "redirect:/NFMYGX0010/login";
		}
		
		return BusinessConst.CodeDef.ScreenId.NFMYGX0020;
	}

}
