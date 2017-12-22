package vn.com.nsmv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.services.NFMYCX0010_YusohiKeisanService;

/**
 * Handle re-caculate Transportation cost action.
 * 
 * @author NSMV
 *
 */
@Controller
@RequestMapping(BusinessConst.CodeDef.ScreenId.NFMYGX0200)
public class NFMYGX0200_Controller {

  @Autowired
  NFMYCX0010_YusohiKeisanService yusoTranService;

  @RequestMapping(value = "/init", method = { RequestMethod.GET })
  public String init(Model model) throws Exception {
    model.addAttribute("message", "Inited!!");
    return BusinessConst.CodeDef.ScreenId.NFMYGX0200;
  }

  @RequestMapping(value = "/executeCaculate", method = { RequestMethod.GET, RequestMethod.POST })
  public String executeCaculate(Model model) throws Exception {

    model.addAttribute("caculateResult", yusoTranService.caculateAll());
    model.addAttribute("message", "Caculated!!");
    return BusinessConst.CodeDef.ScreenId.NFMYGX0200;
  }

  @RequestMapping(value = "/deleteYusohi", method = { RequestMethod.GET, RequestMethod.POST })
  public String executeDelete(Model model) throws Exception {

    yusoTranService.deleteAll();
    model.addAttribute("message", "Deleted!!");
    return BusinessConst.CodeDef.ScreenId.NFMYGX0200;
  }
}
