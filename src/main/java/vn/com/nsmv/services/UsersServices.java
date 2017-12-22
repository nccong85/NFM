package vn.com.nsmv.services;

import java.util.List;

import vn.com.nsmv.bean.NFMYGX0400_UserSearchConditionBean;
import vn.com.nsmv.entities.Users;

public interface UsersServices {
  public List<Users> list();

  public List<Users> listAll(Integer offset, Integer maxResults, String sortName, String sortOrder);

  public List<Users> search(NFMYGX0400_UserSearchConditionBean searchInfoBean);

  public Long count();

  public Long count(NFMYGX0400_UserSearchConditionBean searchInfoBean);

  public boolean delete(Users users);

  public boolean saveOrUpdate(Users users);

}
