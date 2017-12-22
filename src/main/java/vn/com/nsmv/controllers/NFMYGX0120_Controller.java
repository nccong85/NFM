package vn.com.nsmv.controllers;

import java.util.ResourceBundle;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vn.com.nsmv.bean.JsonResponse;
import vn.com.nsmv.bean.NFMYGX0120_SojoDataBean;
import vn.com.nsmv.bean.NFMYGX0120_SukkaJissekiBean;
import vn.com.nsmv.common.BusinessCommonUtil;
import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.common.MessageIdConst;
import vn.com.nsmv.common.StringUtil;
import vn.com.nsmv.services.NFMYGX0120_YusohiTorokuService;

/**
 * Insert new sojo data.
 * 
 * @author NSMV
 */
@Controller
@RequestMapping(BusinessConst.CodeDef.ScreenId.NFMYGX0120)
public class NFMYGX0120_Controller {

  // Declare logger
  private static final Logger logger = Logger.getLogger(NFMYGX0120_Controller.class);

  // Declare bundle object
  private static ResourceBundle bundle = ResourceBundle
      .getBundle(BusinessConst.LocaleDef.JAPANESE_MESSAGE_RESOURCE);

  @Autowired
  NFMYGX0120_YusohiTorokuService yusohiTorokuService;

  @Autowired
  @Qualifier("nfmygx0120SojoDataValidator")
  private Validator validator;

  @InitBinder
  private void initBinder(WebDataBinder binder) {
    binder.setValidator(validator);
  }

  /**
   * Init page
   * 
   * @return
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView init() {

    ModelAndView mav = new ModelAndView(BusinessConst.CodeDef.ScreenId.NFMYGX0120);
    return mav;
  }

  /**
   * Get sojo data from sukka jisseki.
   * 
   * @param bean sojodata
   * @return get status
   */
  @RequestMapping(value = "/checkSojoNo", method = { RequestMethod.POST })
  public @ResponseBody JsonResponse checkSojo(NFMYGX0120_SojoDataBean bean) {
    JsonResponse response = new JsonResponse();
    NFMYGX0120_SukkaJissekiBean sukkaJissekiBean = null;

    // TODO Set sezhoshoKbn
    String seizoshoKbn = "H";

    // Check sojoNo not blank
    if (!StringUtil.isEmpty(bean.getSojoNo())) {

      // Check sojoNo exist
      if (!yusohiTorokuService.isExist(seizoshoKbn, bean.getSojoNo())) {

        // Get data from sukka jisseki
        sukkaJissekiBean = yusohiTorokuService.selectSukkaJissekiInfo(bean.getSojoNo());

        // Setting return data
        if (StringUtil.isEmpty(sukkaJissekiBean.getSojoNo())) {
          response.setStatus(BusinessConst.ResponseStatus.STATUS_FAILED);
          response.setResult(bundle.getString(MessageIdConst.NFMYGX0120_MSG_003));
        } else {
          response.setStatus(BusinessConst.ResponseStatus.STATUS_OK);
          response.setResult(sukkaJissekiBean);
        }

      } else {
        response.setStatus(BusinessConst.ResponseStatus.STATUS_FAILED);
        response.setResult(bundle.getString(MessageIdConst.NFMYGX0120_MSG_004));
      }
    } else {
      response.setStatus(BusinessConst.ResponseStatus.STATUS_FAILED);
      response.setResult(bundle.getString(MessageIdConst.NFMYGX0120_MSG_006));
    }

    // Return data
    return response;
  }

  /**
   * Insert sojo data
   * 
   * @param bean insert info
   * @param result insert status
   * @return
   */
  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public @ResponseBody JsonResponse addNew(@Valid NFMYGX0120_SojoDataBean bean, BindingResult result) {
    JsonResponse response = new JsonResponse();
    if (result.hasErrors()) {
      response.setStatus(BusinessConst.ResponseStatus.STATUS_FAILED);
      response.setResult(result.getAllErrors());
    } else {
      try {

        // TODO Set seizoshoKbn
        bean.setSeizoshoKbn("H");

        // Remove comma on numeric item
        bean.setJuryo(BusinessCommonUtil.removeComma(bean.getJuryo()));
        bean.setJuryo1(BusinessCommonUtil.removeComma(bean.getJuryo1()));
        bean.setJuryo2(BusinessCommonUtil.removeComma(bean.getJuryo2()));
        bean.setJuryo3(BusinessCommonUtil.removeComma(bean.getJuryo3()));
        bean.setJuryo4(BusinessCommonUtil.removeComma(bean.getJuryo4()));
        bean.setCho1ju(BusinessCommonUtil.removeComma(bean.getCho1ju()));
        bean.setCho2ju(BusinessCommonUtil.removeComma(bean.getCho2ju()));
        bean.setBetto(BusinessCommonUtil.removeComma(bean.getBetto()));
        bean.setBetto1(BusinessCommonUtil.removeComma(bean.getBetto1()));
        bean.setBetto2(BusinessCommonUtil.removeComma(bean.getBetto2()));
        bean.setBetto3(BusinessCommonUtil.removeComma(bean.getBetto3()));
        bean.setBetto4(BusinessCommonUtil.removeComma(bean.getBetto4()));
        bean.setDaisu(BusinessCommonUtil.removeComma(bean.getDaisu()));

        // Call service insert sojoData
        yusohiTorokuService.insertSojoData(bean);

        // Setting response
        response.setStatus(BusinessConst.ResponseStatus.STATUS_OK);
        response.setResult(bundle.getString(MessageIdConst.NFMYGX0120_MSG_001));
      } catch (Exception ex) {
        logger.error(ex.getMessage());

        // Setting response
        response.setStatus(BusinessConst.ResponseStatus.STATUS_FAILED);
        response.setResult(bundle.getString(MessageIdConst.NFMYGX0120_MSG_005));
      }
    }
    return response;
  }

  /**
   * Back to search page
   * 
   * @return NFMYGX0100 page
   */
  @RequestMapping(value = "/back", method = RequestMethod.POST)
  public String back() {
    return "redirect:/NFMYGX0100/init";
  }

  /**
   * Get bin name.
   * 
   * @return response
   */
  @RequestMapping(value = "/getBinName", method = RequestMethod.POST)
  public @ResponseBody JsonResponse getBinName(String binCd) {
    JsonResponse response = new JsonResponse();
    String binName = StringUtil.EMPTY_STRING;
    try {
      binName = yusohiTorokuService.selectBinName(binCd);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
    }
    response.setResult(binName);
    return response;
  }

  /**
   * Get gyosha name.
   * 
   * @return response
   */
  @RequestMapping(value = "/getGyoshaName", method = RequestMethod.POST)
  public @ResponseBody JsonResponse getGyoshaName(String gyoshaCd) {
    JsonResponse response = new JsonResponse();
    String gyoshaName = StringUtil.EMPTY_STRING;
    try {
      gyoshaName = yusohiTorokuService.selectGyoshaName(gyoshaCd);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
    }
    response.setResult(gyoshaName);
    return response;
  }
}
