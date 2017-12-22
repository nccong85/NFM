package vn.com.nsmv.daoImpl;

import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nsmv.bean.NFMYGX0400_UserSearchConditionBean;
import vn.com.nsmv.dao.UsersDao;
import vn.com.nsmv.entities.Users;

@Repository
@Transactional
public class UsersDaoImpl implements UsersDao {

  @Autowired
  SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @SuppressWarnings("unchecked")
  public List<Users> list() {
    // TODO Auto-generated method stub
    return sessionFactory.getCurrentSession().createQuery("from User").list();
  }

  @SuppressWarnings("unchecked")
  public List<Users> listAll(Integer offset, Integer maxResults, String sortName, String sortOrder) {
    // TODO Auto-generated method stub

    String sql = "";
    sql = "from Users Order By " + sortName + " " + sortOrder;
    List<Users> listUsers = sessionFactory.getCurrentSession().createQuery(sql)
        .setFirstResult(offset != null ? offset : 0).setMaxResults(maxResults != null ? maxResults : 10)
        .list();

    if (listUsers != null && listUsers.size() > 0) {
      return listUsers;
    }
    return null;
  }

  public boolean delete(Users users) {
    // TODO Auto-generated method stub
    try {
      sessionFactory.getCurrentSession().delete(users);
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return false;
    }

    return true;
  }

  public boolean saveOrUpdate(Users users) {
    // TODO Auto-generated method stub
    try {
      sessionFactory.getCurrentSession().saveOrUpdate(users);
      return true;
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return false;
    }

  }

  public Long count() {
    return (Long) sessionFactory.getCurrentSession().createCriteria(Users.class)
        .setProjection(Projections.rowCount()).uniqueResult();
  }

  @SuppressWarnings("unchecked")
  public List<Users> searchUsers(NFMYGX0400_UserSearchConditionBean searchBean) {
    try {
      StringBuilder sb = new StringBuilder();

      sb.append("FROM Users ");
      sb.append("WHERE 1=1");
      if (!searchBean.getSearchUserId().equals("")) {
        sb.append(" AND userId LIKE '%");
        sb.append(searchBean.getSearchUserId() + "%'");
      }

      if (!searchBean.getSearchUserName().equals("")) {
        sb.append(" AND userName LIKE '%");
        sb.append(searchBean.getSearchUserName() + "%'");
      }

      if (!searchBean.getSearchUserKaishaName().equals("")) {
        sb.append(" AND userKaishaName LIKE '%");
        sb.append(searchBean.getSearchUserKaishaName() + "%'");
      }

      if (!searchBean.getSearchUserSozoku().equals("")) {
        sb.append(" AND userShozoku LIKE '%");
        sb.append(searchBean.getSearchUserSozoku() + "%'");
      }

      if (!searchBean.getSearchUserMail().equals("")) {
        sb.append(" AND userMail LIKE '%");
        sb.append(searchBean.getSearchUserMail() + "%'");
      }

      if (!searchBean.getSearchUserTel().equals("")) {
        sb.append(" AND userTel LIKE '%");
        sb.append(searchBean.getSearchUserTel() + "%'");
      }
      if (searchBean.getSortName() != null && searchBean.getSortOrder() != null) {
        sb.append(" Order By " + searchBean.getSortName() + " " + searchBean.getSortOrder());
      }

      List<Users> listUsers = sessionFactory.getCurrentSession().createQuery(sb.toString())
          .setFirstResult(searchBean.getOffset() != null ? searchBean.getOffset() : 0)
          .setMaxResults(searchBean.getRowPerPage() != null ? searchBean.getRowPerPage() : 10).list();

      if (listUsers != null && listUsers.size() > 0) {
        return listUsers;
      }
      return null;
    } catch (HibernateException e) {
      e.printStackTrace();
      return Collections.emptyList();
    }
  }

  public Long countByQuery(NFMYGX0400_UserSearchConditionBean searchBean) {
    // TODO Auto-generated method stub
    StringBuilder sb = new StringBuilder();

    sb.append("SELECT count(*) ");
    sb.append("FROM Users ");
    sb.append("WHERE 1=1");
    if (!searchBean.getSearchUserId().equals("")) {
      sb.append(" AND userId LIKE '%");
      sb.append(searchBean.getSearchUserId() + "%'");
    }

    if (!searchBean.getSearchUserName().equals("")) {
      sb.append(" AND userName LIKE '%");
      sb.append(searchBean.getSearchUserName() + "%'");
    }

    if (!searchBean.getSearchUserKaishaName().equals("")) {
      sb.append(" AND userKaishaName LIKE '%");
      sb.append(searchBean.getSearchUserKaishaName() + "%'");
    }

    if (!searchBean.getSearchUserSozoku().equals("")) {
      sb.append(" AND userShozoku LIKE '%");
      sb.append(searchBean.getSearchUserSozoku() + "%'");
    }

    if (!searchBean.getSearchUserMail().equals("")) {
      sb.append(" AND userMail LIKE '%");
      sb.append(searchBean.getSearchUserMail() + "%'");
    }

    if (!searchBean.getSearchUserTel().equals("")) {
      sb.append(" AND userTel LIKE '%");
      sb.append(searchBean.getSearchUserTel() + "%'");
    }

    return (Long) sessionFactory.openSession().createQuery(sb.toString()).uniqueResult();
  }

}
