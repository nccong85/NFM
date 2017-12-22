package vn.com.nsmv.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nsmv.bean.NFMYGX0140_Bean;
import vn.com.nsmv.dao.SMstYusoBodyDao;
import vn.com.nsmv.entities.SMstYusoBodyEntity;

@Repository
@Transactional
public class SMstYusoBodyDaoImpl implements SMstYusoBodyDao {

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Set session factory
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.com.nsmv.dao.SMstYusoBodyDao#selectForList(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SMstYusoBodyEntity> selectForList(String seizoshoKbn) {

		// Create select query
		String sql = "FROM SMstYusoBodyEntity WHERE seizoshoKbn = :seizoshoKbn";

		// Execute select
		return sessionFactory.getCurrentSession().createQuery(sql).setParameter("seizoshoKbn", seizoshoKbn).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.com.nsmv.dao.SMstYusoBodyDao#selectForList(vn.com.nsmv.entities.
	 * SMstYusoBodyEntity)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SMstYusoBodyEntity> selectForList(SMstYusoBodyEntity sMstYusoBodyEntity) {

		// Create select query
		StringBuilder sb = new StringBuilder();
		sb.append("FROM SMstYusoBodyEntity WHERE");
		sb.append(" seizoshoKbn = :seizoshoKbn");
		sb.append(" AND sojonoShukkoBasho = :sojonoShukkoBasho");
		sb.append(" AND sojonoTorihikiShubetsu = :sojonoTorihikiShubetsu");
		sb.append(" AND sojonoOban = :sojonoOban");
		sb.append(" AND sojonoRenban = :sojonoRenban");
		sb.append(" AND headTeiseiKbn = :headTeiseiKbn");
		sb.append(" AND headTeiseiKaisu = :headTeiseiKaisu");
		sb.append(" AND seikyuNengetsu = :seikyuNengetsu");

		// Execute select
		List<SMstYusoBodyEntity> yusoBodyList = sessionFactory.getCurrentSession().createQuery(sb.toString())
				.setParameter("seizoshoKbn", sMstYusoBodyEntity.getSeizoshoKbn())
				.setParameter("sojonoShukkoBasho", sMstYusoBodyEntity.getSojonoShukkoBasho())
				.setParameter("sojonoTorihikiShubetsu", sMstYusoBodyEntity.getSojonoTorihikiShubetsu())
				.setParameter("sojonoOban", sMstYusoBodyEntity.getSojonoOban())
				.setParameter("sojonoRenban", sMstYusoBodyEntity.getSojonoRenban())
				.setParameter("headTeiseiKaisu", sMstYusoBodyEntity.getHeadTeiseiKaisu())
				.setParameter("headTeiseiKbn", sMstYusoBodyEntity.getHeadTeiseiKbn())
				.setParameter("seikyuNengetsu", sMstYusoBodyEntity.getSeikyuNengetsu()).list();

		if (yusoBodyList != null && yusoBodyList.size() > 0) {
			return yusoBodyList;
		}
		return null;
	}

	@Override
	public SMstYusoBodyEntity selectByPrimaryKey(SMstYusoBodyEntity sMstYusoBodyEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.com.nsmv.dao.SMstYusoBodyDao#insert(vn.com.nsmv.entities.
	 * SMstYusoBodyEntity)
	 */
	@Override
	public int insert(SMstYusoBodyEntity entity) {

		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(entity);
			return 1;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.com.nsmv.dao.SMstYusoBodyDao#updateByPrimaryKey(vn.com.nsmv.entities.
	 * SMstYusoBodyEntity)
	 */
	@Override
	public boolean updateByPrimaryKey(SMstYusoBodyEntity yusoMasterBody) {
		// Get current session
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(yusoMasterBody);

		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.com.nsmv.dao.SMstYusoBodyDao#deleteByPrimaryKey(vn.com.nsmv.entities.
	 * SMstYusoBodyEntity)
	 */
	@Override
	public boolean deleteByPrimaryKey(SMstYusoBodyEntity yusoMasterBody) {
		try {
			sessionFactory.getCurrentSession().delete(yusoMasterBody);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int selectCount() {
		return (int) sessionFactory.getCurrentSession().createCriteria(SMstYusoBodyEntity.class)
				.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public void deleteAll() {
		String hql = String.format("delete from %s", "SMstYusoBodyEntity");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.com.nsmv.dao.SMstYusoBodyDao#selectBodyEntity(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, int,
	 * java.lang.String, int, java.lang.String, int, java.lang.String)
	 */
	@Override
	public SMstYusoBodyEntity selectBodyEntity(NFMYGX0140_Bean bean) {
		
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SMstYusoBodyEntity.class);
			criteria.add(Restrictions.eq("seizoshoKbn", bean.getSeizoshoKbn()));
			criteria.add(Restrictions.eq("sojonoShukkoBasho", bean.getSojoNoBasho()));
			criteria.add(Restrictions.eq("sojonoTorihikiShubetsu", bean.getSojoNoShubetsu()));
			criteria.add(Restrictions.eq("sojonoOban", bean.getSojoNoOban()));
			criteria.add(Restrictions.eq("sojonoRenban", bean.getSojoNoRenban()));
			criteria.add(Restrictions.eq("headTeiseiKbn", bean.getHeadTeiseiKbn()));
			criteria.add(Restrictions.eq("headTeiseiKaisu", bean.getHeadTeiseiKaisu()));
			criteria.add(Restrictions.eq("himokuCd", bean.getOldHimokuCd()));
			criteria.add(Restrictions.eq("bodyTeiseiKbn", bean.getBodyTeiseiKbn()));
			criteria.add(Restrictions.eq("bodyTeiseiKaisu", bean.getBodyTeiseiKaisu()));
			criteria.add(Restrictions.eq("seikyuNengetsu", bean.getOldSeikyuNengetsu()));

			return (SMstYusoBodyEntity) criteria.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();

		}
		return null;
	}

	@Override
	public boolean checkHimokuCdExist(NFMYGX0140_Bean bean) {

		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SMstYusoBodyEntity.class);
			criteria.add(Restrictions.eq("seizoshoKbn", bean.getSeizoshoKbn()));
			criteria.add(Restrictions.eq("sojonoShukkoBasho", bean.getSojoNoBasho()));
			criteria.add(Restrictions.eq("sojonoTorihikiShubetsu", bean.getSojoNoShubetsu()));
			criteria.add(Restrictions.eq("sojonoOban", bean.getSojoNoOban()));
			criteria.add(Restrictions.eq("sojonoRenban", bean.getSojoNoRenban()));
			criteria.add(Restrictions.eq("himokuCd", bean.getHimokuCd()));
			criteria.add(Restrictions.eq("keirekiFlg", "0"));
			criteria.setProjection(Projections.rowCount());
			
			 Long result = (Long)criteria.uniqueResult();
			 if (result.intValue()>0) {
				return true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();

		}
		return false;
	}

}
