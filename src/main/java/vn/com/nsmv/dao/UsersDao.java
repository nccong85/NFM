package vn.com.nsmv.dao;

import java.util.List;

import vn.com.nsmv.bean.NFMYGX0400_UserSearchConditionBean;
import vn.com.nsmv.entities.Users;

public interface UsersDao {

  /**
   * @return
   */
  public List<Users> list();

  /**
   * @param offset
   * @param maxResults
   * @param sortName
   * @param sortOrder
   * @return
   */
  public List<Users> listAll(Integer offset, Integer maxResults, String sortName, String sortOrder);

  public boolean delete(Users users);

  /**
   * @param users
   * @return
   */
  public boolean saveOrUpdate(Users users);

  public Long count();

  public Long countByQuery(NFMYGX0400_UserSearchConditionBean searchBean);

  public List<Users> searchUsers(NFMYGX0400_UserSearchConditionBean searchBean);
}