package vn.com.nsmv.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vn.com.nsmv.bean.JsonResponse;
import vn.com.nsmv.bean.NFMYGX0400_Bean;
import vn.com.nsmv.bean.NFMYGX0400_UserSearchConditionBean;
import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.entities.Users;
import vn.com.nsmv.services.UsersServices;

@Controller
@RequestMapping("NFMYGX0400")
public class UsersController {

  @Autowired
  UsersServices userServices;

  @RequestMapping(value = "/init", method = { RequestMethod.GET })
  public String index(Model model, Integer offset, Integer maxResults, String sortName, String sortOrder) {
    model.addAttribute("userList", userServices.listAll(offset, maxResults,
        sortName != null ? sortName : "userId", sortOrder != null ? sortOrder : "ASC"));
    model.addAttribute("count", userServices.count());
    model.addAttribute("offset", offset != null ? offset : 0);
    model.addAttribute("rowPerPage", maxResults != null ? maxResults : 10);
    model.addAttribute("searchMode", "init");
    model.addAttribute("sortName", sortName != null ? sortName : "userId");
    model.addAttribute("sortOrder", sortOrder != null ? sortOrder : "ASC");
    return "NFMYGX0400_userList";
  }

  @RequestMapping(value = "/search", method = { RequestMethod.POST, RequestMethod.GET })
  public @ResponseBody JsonResponse search(NFMYGX0400_UserSearchConditionBean searchInfoBean) {
    JsonResponse response = new JsonResponse();

    if (searchInfoBean.getOffset() == null) {
      searchInfoBean.setOffset(0);
    }

    if (searchInfoBean.getRowPerPage() == null) {
      searchInfoBean.setRowPerPage(10);
    }

    if (searchInfoBean.getSortName() == null) {
      searchInfoBean.setSortName("userId");
    }

    if (searchInfoBean.getOffset() == null) {
      searchInfoBean.setSortOrder("ASC");
    }

    try {
      List<Users> searchResult = userServices.search(searchInfoBean);

      NFMYGX0400_Bean bean = new NFMYGX0400_Bean();

      long count = userServices.count(searchInfoBean);

      bean.setUserList(searchResult);
      bean.setCount(count);
      bean.setOffset(searchInfoBean.getOffset());
      bean.setRowPerPage(searchInfoBean.getRowPerPage());
      bean.setSearchMode("search");
      bean.setSortName(searchInfoBean.getSortName());
      bean.setSortOrder(searchInfoBean.getSortOrder());

      response.setStatus(BusinessConst.ResponseStatus.STATUS_OK);
      response.setResult(bean);
    } catch (Exception ex) {
      response.setStatus(BusinessConst.ResponseStatus.STATUS_FAILED);
    }
    return response;
  }

  @RequestMapping(value = "/paggingInit", method = { RequestMethod.POST })
  public @ResponseBody JsonResponse paggingInit(Integer offset, Integer rowPerPage, String sortName,
      String sortOrder) {
    JsonResponse response = new JsonResponse();
    try {
      List<Users> searchResult = userServices.listAll(offset, rowPerPage,
          sortName != null ? sortName : "userId", sortOrder != null ? sortOrder : "ASC");

      NFMYGX0400_Bean bean = new NFMYGX0400_Bean();

      long count = userServices.count();

      bean.setUserList(searchResult);
      bean.setCount(count);
      bean.setOffset(offset != null ? offset : 0);
      bean.setRowPerPage(rowPerPage != null ? rowPerPage : 10);
      bean.setSearchMode("init");
      bean.setSortName(sortName != null ? sortName : "userId");
      bean.setSortOrder(sortOrder != null ? sortOrder : "ASC");

      response.setStatus(BusinessConst.ResponseStatus.STATUS_OK);
      response.setResult(bean);
    } catch (Exception ex) {
      response.setStatus(BusinessConst.ResponseStatus.STATUS_FAILED);
    }
    return response;
  }

  @RequestMapping(value = "/paggingSearch", method = { RequestMethod.POST })
  public @ResponseBody JsonResponse paggingSearch(NFMYGX0400_UserSearchConditionBean searchInfoBean) {
    JsonResponse response = new JsonResponse();
    if (searchInfoBean.getOffset() == null) {
      searchInfoBean.setOffset(0);
    }

    if (searchInfoBean.getRowPerPage() == null) {
      searchInfoBean.setRowPerPage(10);
    }

    if (searchInfoBean.getSortName() == null) {
      searchInfoBean.setSortName("userId");
    }

    if (searchInfoBean.getOffset() == null) {
      searchInfoBean.setSortOrder("ASC");
    }
    try {
      List<Users> searchResult = userServices.search(searchInfoBean);

      NFMYGX0400_Bean bean = new NFMYGX0400_Bean();

      long count = userServices.count(searchInfoBean);

      bean.setUserList(searchResult);
      bean.setCount(count);
      bean.setOffset(searchInfoBean.getOffset());
      bean.setRowPerPage(searchInfoBean.getRowPerPage());
      bean.setSearchMode("search");
      bean.setSortName(searchInfoBean.getSortName());
      bean.setSortOrder(searchInfoBean.getSortOrder());

      response.setStatus(BusinessConst.ResponseStatus.STATUS_OK);
      response.setResult(bean);
    } catch (Exception ex) {
      response.setStatus(BusinessConst.ResponseStatus.STATUS_FAILED);
    }
    return response;
  }

  @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
  public @ResponseBody Map<String, Object> getSaved(Users users) {
    Map<String, Object> map = new HashMap<String, Object>();

    if (userServices.saveOrUpdate(users)) {
      map.put("status", "200");
      map.put("message", "Your record have been saved successfully");
    }

    return map;
  }

  @RequestMapping(value = "/delete", method = RequestMethod.POST)
  public @ResponseBody Map<String, Object> delete(Users users) {
    Map<String, Object> map = new HashMap<String, Object>();

    if (userServices.delete(users)) {
      map.put("status", "200");
      map.put("message", "Your record have been deleted successfully");
    }

    return map;
  }
}
