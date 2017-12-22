package vn.com.nsmv.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nsmv.dao.STraErrDao;
import vn.com.nsmv.entities.STraErrEntity;

@Repository
@Transactional
public class STraErrDaoImpl implements STraErrDao {

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<STraErrEntity> selectForList(String seizoshoKbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<STraErrEntity> selectByPrimaryKey(STraErrEntity error) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveOrUpdate(STraErrEntity error) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(error);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
