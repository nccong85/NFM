package vn.com.nsmv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("NFMYGX0160")
public class NFMYGX0160_Controller {
	// i'm a main view
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init(){
		return "NFMYGX0160";
	}

}
