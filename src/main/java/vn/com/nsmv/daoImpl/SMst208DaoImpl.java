package vn.com.nsmv.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nsmv.dao.SMst208Dao;
import vn.com.nsmv.entities.SMst208Entity;

@Repository
@Transactional
public class SMst208DaoImpl implements SMst208Dao {

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
   * @see vn.com.nsmv.dao.SMst208Dao#selectByList(java.lang.String)
   */
  @Override
  public List<SMst208Entity> selectByList(String seizoshoKbn) {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see vn.com.nsmv.dao.SMst208Dao#selectByPrimaryKey(vn.com.nsmv.entities.SMst208Entity)
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<SMst208Entity> selectByPrimaryKey(SMst208Entity entity) {

    // Create query
    StringBuilder sb = new StringBuilder();
    sb.append("FROM SMst208Entity ");
    sb.append("WHERE ");
    sb.append("seizosho_kbn = :seizosho_kbn ");
    sb.append("AND data_kbn = :data_kbn ");
    sb.append("AND key1 = :key1 ");
    sb.append("AND key2 = :key2");

    return sessionFactory.getCurrentSession().createQuery(sb.toString())
        .setParameter("seizosho_kbn", entity.getSeizosho_kbn())
        .setParameter("data_kbn", entity.getData_kbn()).setParameter("key1", entity.getKey1())
        .setParameter("key2", entity.getKey2()).list();
  }

}
