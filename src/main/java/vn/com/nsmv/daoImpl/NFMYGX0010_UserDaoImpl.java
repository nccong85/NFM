package vn.com.nsmv.daoImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nsmv.common.EncryptPassword;
import vn.com.nsmv.dao.NFMYGX0010_UsersDao;
import vn.com.nsmv.entities.SMstUserEntity;

@Repository
@Transactional
public class NFMYGX0010_UserDaoImpl implements NFMYGX0010_UsersDao {

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see vn.com.nsmv.dao.NFMYGX0010_UsersDao#login(java.lang.String, java.lang.String)
	 */
	public int login(String userId, String pwd){
		int result = 0;
		// check userId is exist or not
		if(!checkUserExists(userId)){
			result = 2;
		}else{
			String hql = "SELECT userId FROM SMstUserEntity WHERE userId=:userId AND password=:password";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("userId", userId);
			try {
				EncryptPassword en = new EncryptPassword();
				String password = en.encrypt(pwd);
				query.setParameter("password", password);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			result = query.list().size();
		}
		
		return result;
	}
	
	/**
	 * checkUserExists
	 * @param criteria
	 * @param userId
	 * @return boolean
	 */
	private boolean checkUserExists(String userId) {
		String hql = "SELECT userId FROM SMstUserEntity WHERE userId=:userId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("userId", userId);		
		int result = query.list().size();
		if (result == 1) return true;

		return false;
	}

	/* (non-Javadoc)
	 * @see vn.com.nsmv.dao.NFMYGX0010_UsersDao#getUserById(java.lang.String)
	 */
	@Override
	public SMstUserEntity getUserById(String userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SMstUserEntity.class);
		criteria.add(Restrictions.eq("userId", userId));
		return (SMstUserEntity) criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see vn.com.nsmv.dao.NFMYGX0010_UsersDao#checkSessionByUser(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public boolean checkSessionByUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		SMstUserEntity user = (SMstUserEntity) session.getAttribute("user");
		if (user == null) return false;
		return true;
	}

}
