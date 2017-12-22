package vn.com.nsmv.controllers;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.com.nsmv.bean.NFMYGX0010_UserBean;
import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.common.MessageIdConst;
import vn.com.nsmv.entities.SMstUserEntity;
import vn.com.nsmv.services.NFMYGX0010_UserService;
import vn.com.nsmv.validator.ValidateForm;

/**
 * Handle user login action
 * 
 * @author TayLQ
 *
 */
@Controller
@RequestMapping(BusinessConst.CodeDef.ScreenId.NFMYGX0010)
public class NFMYGX0010_Controller {

	@Autowired
	NFMYGX0010_UserService service;

	@Autowired
	ValidateForm validate;

	/**
	 * Init initial login form
	 * 
	 * @param user
	 * @return jsp
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String init(NFMYGX0010_UserBean user) {
		return BusinessConst.CodeDef.ScreenId.NFMYGX0010;
	}

	/**
	 * Login submit login form
	 * 
	 * @param bean
	 * @param result
	 * @param status
	 * @return jsp
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(NFMYGX0010_UserBean bean, Model model, BindingResult result, HttpServletRequest request) {

		// Check Validate login form
		validate.validate(bean, result);
		if (result.hasErrors()) {
			return BusinessConst.CodeDef.ScreenId.NFMYGX0010;
		}

		// Check userId
		int count = service.login(bean.getUserId(), bean.getPassword());

		// Get resources bundle
		ResourceBundle bundle = ResourceBundle.getBundle("messages_ja_JP");

		if (count == MessageIdConst.USER_NOT_EXISTS) {
			model.addAttribute("message", bundle.getString(MessageIdConst.NFMYGX0010_MSG_003));
			return BusinessConst.CodeDef.ScreenId.NFMYGX0010;

		} else if (count == MessageIdConst.LOGIN_SUCCESS) {
			// Get user information
			SMstUserEntity user = service.getUserById(bean.getUserId());

			// Save user to session
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "redirect:/" + BusinessConst.CodeDef.ScreenId.NFMYGX0020 + "/init";

		} else if (count == MessageIdConst.LOGIN_FAILED) {
			model.addAttribute("message", bundle.getString(MessageIdConst.NFMYGX0010_MSG_004));
			return BusinessConst.CodeDef.ScreenId.NFMYGX0010;
		}

		return null;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		 request.getSession().invalidate();
		return "redirect:/"+BusinessConst.CodeDef.ScreenId.NFMYGX0010+"/login";
	}

}