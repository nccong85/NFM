package vn.com.nsmv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.com.nsmv.common.BusinessConst;

@Controller
@RequestMapping(BusinessConst.CodeDef.ScreenId.NFMYCX0010)
// this is 5rd Update
public class NFMYCX0010_Controller {
	// This is 3rd update
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init(){
        // This is 4rd update
		return "NFMYCX0010";
	}

}
