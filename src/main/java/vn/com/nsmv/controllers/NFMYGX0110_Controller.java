package vn.com.nsmv.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.nsmv.bean.CommonSojoDataBean;
import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.entities.SMstUserEntity;
import vn.com.nsmv.services.NFMYGX0010_UserService;
import vn.com.nsmv.services.NFMYGX0110_Services;

@Controller
@RequestMapping(BusinessConst.CodeDef.ScreenId.NFMYGX0110)
public class NFMYGX0110_Controller {
	private static final Logger logger = Logger.getLogger(NFMYGX0110_Controller.class);

	@Autowired
	NFMYGX0110_Services service;
	@Autowired
	NFMYGX0010_UserService auth;;

	/**
	 * Init
	 * 
	 * @param request
	 * @param model
	 * @param basho
	 * @param shubetsu
	 * @param oban
	 * @return jsp
	 */
	@RequestMapping(value = "/init/{basho}-{shubetsu}-{oban}", method = RequestMethod.GET)
	public String init(HttpServletRequest request, Model model, @PathVariable String basho,
			@PathVariable String shubetsu, @PathVariable String oban) throws Exception {

		// Check user into session
		if (!auth.checkSessionByUser(request)) {
			return "redirect:/NFMYGX0010/login";
		}
		String display = "none";

		HttpSession session = request.getSession();
		SMstUserEntity user = (SMstUserEntity) session.getAttribute("user");

		List<CommonSojoDataBean> listObject = service.selectDetailBySojoNo(user.getSeizoshoKbn(), basho, shubetsu,
				oban);

		int size = listObject.size();

		if (size > 0) {
			model.addAttribute("detail", listObject.get(size - 1));
		}

		if (size >= 2) {
			display = "block";
			listObject.remove(listObject.get(size - 1));
			model.addAttribute("listObject", listObject);
		}

		model.addAttribute("display", display);
		return BusinessConst.CodeDef.ScreenId.NFMYGX0110;
	}

	/**
	 * Delete
	 * 
	 * @param request
	 * @param model
	 * @param basho
	 * @param shubetsu
	 * @param oban
	 * @return string
	 */
	@RequestMapping(value = "/delete/{basho}-{shubetsu}-{oban}", method = RequestMethod.GET)
	public @ResponseBody String delete(HttpServletRequest request, Model model, @PathVariable String basho,
			@PathVariable String shubetsu, @PathVariable String oban) {

		HttpSession session = request.getSession();
		SMstUserEntity user = (SMstUserEntity) session.getAttribute("user");

		try {
			boolean flag = service.deleteBySojoNo(user.getSeizoshoKbn(), basho, shubetsu, oban);
			if (!flag) {
				return BusinessConst.ResponseStatus.STATUS_FAILED;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return BusinessConst.ResponseStatus.STATUS_OK;
	}
}
