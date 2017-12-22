package vn.com.nsmv.daoImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nsmv.bean.NFMYCX0010_YusoTranSearchBean;
import vn.com.nsmv.common.StringUtil;
import vn.com.nsmv.bean.CommonSojoDataBean;
import vn.com.nsmv.dao.STraYusoDao;
import vn.com.nsmv.entities.STraYusoEntity;

/**
 * STraYusoDao Implement Class
 * 
 * @author cong85
 */
@Repository
@Transactional
public class STraYusoDaoImpl implements STraYusoDao {

	private static final Logger logger = Logger.getLogger(STraYusoDaoImpl.class);

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
	 * @see vn.com.nsmv.dao.STraYusoDao#list()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<STraYusoEntity> list() {
		return sessionFactory.getCurrentSession().createCriteria(STraYusoEntity.class).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.com.nsmv.dao.STraYusoDao#list(vn.com.nsmv.bean.
	 * NFMYCX0010_YusoTranSearchBean)
	 */
	@Override
	public List<STraYusoEntity> list(NFMYCX0010_YusoTranSearchBean yusoTran) {
		try {
			// StringBuilder sql = new StringBuilder();

			// sql.append(" FROM STraYusoEntity T");
			// sql.append(" WHERE");
			// sql.append(" T.seizoshoKbn = ?");
			// sql.append(" AND substr(T.shukkaDdate,0,4) = ?");
			// sql.append(" AND substr(T.shukkaDdate,4,2) = ?");
			// sql.append(" AND T.gyoshaCd = ?");

			return null;
		} catch (HibernateException e) {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.com.nsmv.dao.STraYusoDao#delete(vn.com.nsmv.entities.STraYusoEntity)
	 */
	@Override
	public boolean delete(STraYusoEntity yusoTran) {
		try {
			sessionFactory.getCurrentSession().delete(yusoTran);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.com.nsmv.dao.STraYusoDao#saveOrUpdate(vn.com.nsmv.entities.
	 * STraYusoEntity)
	 */
	@Override
	public boolean saveOrUpdate(STraYusoEntity yusoTran) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(yusoTran);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.com.nsmv.dao.STraYusoDao#count()
	 */
	@Override
	public int count() {
		return sessionFactory.getCurrentSession().createCriteria(STraYusoEntity.class).list().size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.com.nsmv.dao.STraYusoDao#selectDetailBySojoNo(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<CommonSojoDataBean> selectDetailBySojoNo(String seizosho, String basho, String shubetsu, String oban) {
		ResourceBundle bundle = ResourceBundle.getBundle("sql_query");
		String query = bundle.getString("nfmygx0110_select");

		SQLQuery sql = sessionFactory.getCurrentSession().createSQLQuery(query);
		sql.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		sql.setParameter("seizosho", seizosho);
		sql.setParameter("basho", basho);
		sql.setParameter("shubetsu", shubetsu);
		sql.setParameter("oban", oban);
		
		List<CommonSojoDataBean> results = new ArrayList<>();
		try {
			Iterator<?> iterator = sql.list().iterator();
			
			while (iterator.hasNext()) {
				@SuppressWarnings("unchecked")
				HashMap<String, String> iter = (HashMap<String, String>) iterator.next();
				CommonSojoDataBean c = new CommonSojoDataBean();
				try {
					BeanUtils.populate(c, iter);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				results.add(c);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return results;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.com.nsmv.dao.STraYusoDao#deleteBySojoNo(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean deleteBySojoNo(String seizosho, String basho, String shubetsu, String oban) {
		ResourceBundle bundle = ResourceBundle.getBundle("sql_query");
		String sql = bundle.getString("nfmygx0110_delete");

		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setString("seizosho", seizosho);
		query.setString("basho", basho);
		query.setString("shubetsu", shubetsu);
		query.setString("oban", oban);
		int result = query.executeUpdate();
		if (result > 0)
			return true;
		return false;
	}

	@Override
	public boolean selectBySojoNo(String seizosho, String basho, String shubetsu, String oban) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(STraYusoEntity.class);
		cr.add(Restrictions.eq("seizoshoKbn", seizosho));
		cr.add(Restrictions.eq("sojonoShukkoBasho", basho));
		cr.add(Restrictions.eq("sojonoTorihikiShubetsu", shubetsu));
		cr.add(Restrictions.eq("sojonoOban", oban));
		cr.setProjection(Projections.rowCount());

		Long result = (Long) cr.uniqueResult();
		if (result.intValue() > 0) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see vn.com.nsmv.dao.STraYusoDao#saveSojo(vn.com.nsmv.bean.NFMYGX0110_SojoData)
	 */
	@Override
	public boolean saveSojo(CommonSojoDataBean bean) throws Exception{
     try{
		STraYusoEntity entity = new STraYusoEntity();
		entity.setSeizoshoKbn(bean.getSeizokbn());
		entity.setSojonoShukkoBasho(bean.getBasho());
		entity.setSojonoTorihikiShubetsu(bean.getShubetsu());
		entity.setSojonoOban(bean.getOban());
		entity.setSojonoRenban(bean.getRenban());
		entity.setShukkaDate(bean.getDate());
		entity.setKeiyakunoYear(bean.getKeiyear());
		entity.setKeiyakunoKankatsu(bean.getKeikankatsu());
		entity.setKeiyakunoHinshu(bean.getKeihinshu());
		entity.setKeiyakunoTorihikiShubetsu(bean.getKeishubetsu());
		entity.setKeiyakunoMonth(bean.getKeimonth());
		entity.setKeiyakunoOban(bean.getKeioban());
		entity.setTsumikomiMinato(bean.getMinato().trim());
		entity.setAgeMinato(bean.getAge_minato().trim());
		entity.setBinCd(bean.getBincd().trim());
		entity.setGyoshaCd(bean.getGyoshacd().trim());
		entity.setTsumiaiCd(bean.getTsumiaicd().trim());
		entity.setWarimashiJikangai(bean.getJikangai().trim());
		entity.setWarimashiKuton(bean.getKuton().trim());
		entity.setHanbaiKbn(bean.getHanbai_kbn().trim());
		entity.setWarimashiChojaku(bean.getChojaku().trim());
		
		if (!StringUtil.nullToEmpty(bean.getJuryo()).isEmpty()) {
			entity.setJuryo(Integer.parseInt(bean.getJuryo()));
		}
		
		if (!StringUtil.nullToEmpty(bean.getRyosu()).isEmpty()) {
			entity.setYushutsuKenryoRyosu(Integer.parseInt(bean.getRyosu()));
		}
		
		if (!StringUtil.nullToEmpty(bean.getSokouhokan()).isEmpty()) {
			entity.setYushutsuSokouhokanNissu(Integer.parseInt(bean.getSokouhokan()));
		}
		
		if (!StringUtil.nullToEmpty(bean.getFutaisen()).isEmpty()) {
			entity.setYushutsuFutaisenNissu(Integer.parseInt(bean.getFutaisen()));
		}
		
		if (!StringUtil.nullToEmpty(bean.getKyuryo()).isEmpty()) {
			entity.setKyuryo(Integer.parseInt(bean.getKyuryo()));
		}
		
		if (!StringUtil.nullToEmpty(bean.getTomeryo()).isEmpty()) {
			entity.setTomeryo(Integer.parseInt(bean.getTomeryo()));
		}
		
		if (!StringUtil.nullToEmpty(bean.getCho1ju()).isEmpty()) {
			entity.setCho1ju(Integer.parseInt(bean.getCho1ju()));
		}
		
		if (!StringUtil.nullToEmpty(bean.getCho2ju()).isEmpty()) {
			entity.setCho2ju(Integer.parseInt(bean.getCho2ju()));
		}
		
		if (!StringUtil.nullToEmpty(bean.getBetto()).isEmpty()) {
			entity.setBetto(Integer.parseInt(bean.getBetto()));
		}
		
		if (!StringUtil.nullToEmpty(bean.getDaisu()).isEmpty()) {
			entity.setDaisu(Integer.parseInt(bean.getDaisu()));
		}
		
		entity.setTeiseiRiyu(bean.getTeisei_riyu());

		return saveOrUpdate(entity);
     }catch(Exception ex){
    	 throw ex;
     }

	}

}
