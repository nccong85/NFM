package vn.com.nsmv.controllers;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.com.nsmv.bean.CommonParam;
import vn.com.nsmv.bean.NFMYGX0150_MultiBinView;
import vn.com.nsmv.bean.NFMYGX0150_SingleBinView;
import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.common.MessageIdConst;
import vn.com.nsmv.common.NumberUtil;
import vn.com.nsmv.services.NFMYGX0150_YusohiViewService;

@Controller
@RequestMapping(BusinessConst.CodeDef.ScreenId.NFMYGX0150)
public class NFMYGX0150_Controller {
  @Autowired
  NFMYGX0150_YusohiViewService yusohiViewService;

  // Declare logger
  private static final Logger logger = Logger.getLogger(NFMYGX0150_Controller.class);

  // Declare resource bundle
  private static final ResourceBundle bundle = ResourceBundle
      .getBundle(BusinessConst.LocaleDef.JAPANESE_MESSAGE_RESOURCE);

  private static final String VIEW_MODE = "viewMode";

  private static final String BUSINESS_MESSAGE = "businessMessage";

  private static final String SOJONO = "sojoNo";

  private static final String MULTI_BEAN_YUSOHI = "multiBinYusohi";

  private static final String SINGLE_BEAN_YUSOHI = "singleBinYusohi";

  /**
   * Get yusohi data
   * 
   * @param basho
   * @param shubetsu
   * @param oban
   * @return yusohi data
   */
  @RequestMapping(value = "view/{basho}-{shubetsu}-{oban}-{renban}", method = RequestMethod.GET)
  public ModelAndView view(@PathVariable String basho, @PathVariable String shubetsu,
      @PathVariable String oban, @PathVariable String renban) {

    // Declare variables
    CommonParam param = new CommonParam();
    ModelAndView mav = new ModelAndView(BusinessConst.CodeDef.ScreenId.NFMYGX0150);
    NFMYGX0150_MultiBinView multiBinYusohi = null;
    NFMYGX0150_SingleBinView singleBinYusohi = null;
    Integer binCounter = 0;

    // TODO set seizoshoKbn
    // Setting param to get data
    param.setSeizoshoKbn("H");
    param.setSojoNoShukkoBasho(basho);
    param.setSojoNoTorihikiShubetsu(shubetsu);
    param.setSojoNoOban(oban);
    param.setSojoNoRenban(NumberUtil.toInteger(renban));

    // Call services
    try {

      binCounter = yusohiViewService.getBinCounter(param);
      param.setBinCounter(binCounter);

      if (binCounter > 1) {
        multiBinYusohi = yusohiViewService.selectMultiBinYusohi(param);
        multiBinYusohi.setActiveTab(renban);
        mav.addObject(VIEW_MODE, BusinessConst.CodeDef.NumberValue.ONE);
        mav.addObject(SOJONO, param);
        mav.addObject(MULTI_BEAN_YUSOHI, multiBinYusohi);
      } else {

        singleBinYusohi = yusohiViewService.selectSingleBinYusohi(param);

        if (singleBinYusohi.getHeadInfoList().size() > 0) {
          // Setting object to return
          mav.addObject(VIEW_MODE, BusinessConst.CodeDef.NumberValue.ZERO);
          mav.addObject(SOJONO, param);
          mav.addObject(SINGLE_BEAN_YUSOHI, singleBinYusohi);
        } else {
          mav.addObject(VIEW_MODE, BusinessConst.CodeDef.NumberValue.ZERO);
          mav.addObject(SOJONO, param);
          mav.addObject(BUSINESS_MESSAGE, bundle.getString(MessageIdConst.NFMYGX0150_MSG_002).trim());
        }
      }
    } catch (Exception ex) {
      logger.error(ex.getMessage());
      mav.addObject(VIEW_MODE, BusinessConst.CodeDef.NumberValue.ZERO);
      mav.addObject(SOJONO, param);
      mav.addObject(BUSINESS_MESSAGE, bundle.getString(MessageIdConst.NFMYGX0150_MSG_001));
    }

    // Return to jsp
    return mav;
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
}
