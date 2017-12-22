package vn.com.nsmv.controllers;

import java.util.List;
import java.util.ResourceBundle;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.com.nsmv.bean.NFMYGX0100_SearchBean;
import vn.com.nsmv.bean.NFMYGX0100_SearchResultBean;
import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.common.MessageIdConst;
import vn.com.nsmv.services.NFMYGX0100_YusohiSearchService;

@Controller
@RequestMapping(BusinessConst.CodeDef.ScreenId.NFMYGX0100)
public class NFMYGX0100_Controller {

	@Autowired
	NFMYGX0100_YusohiSearchService yusohiSearchSerive;

	@Autowired
	@Qualifier("nfmygx0100SearchConditionValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public ModelAndView init(NFMYGX0100_SearchBean bean, Model model) {

		ModelAndView mav = new ModelAndView(BusinessConst.CodeDef.ScreenId.NFMYGX0100);

		List<NFMYGX0100_SearchResultBean> searchResult = yusohiSearchSerive.init("H");
		mav.addObject("searchResultList", searchResult);

		return mav;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(@Valid NFMYGX0100_SearchBean bean, BindingResult result, Model model) {

		ResourceBundle bundle = ResourceBundle.getBundle(BusinessConst.LocaleDef.JAPANESE_MESSAGE_RESOURCE);
		if (result.hasErrors()) {

			ModelAndView mav = new ModelAndView(BusinessConst.CodeDef.ScreenId.NFMYGX0100);
			return mav;

		} else {
			ModelAndView mav = new ModelAndView(BusinessConst.CodeDef.ScreenId.NFMYGX0100);
			// TODO Set seizoshoKbn
			bean.setSeizoshoKbn("H");
			
			List<NFMYGX0100_SearchResultBean> searchResult = yusohiSearchSerive.search(bean);
			if (searchResult != null && searchResult.size() > 0) {
				mav.addObject("searchResultList", searchResult);
			} else {
				mav.addObject("businessMessage", bundle.getString(MessageIdConst.NFMYGX0100_MSG_007));
			}

			return mav;
		}
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(){
//		ModelAndView mav = new ModelAndView(BusinessConst.CodeDef.ScreenId.NFMYGX0120);
//		return mav;
		
		return "redirect:/NFMYGX0120/";
	}
}
