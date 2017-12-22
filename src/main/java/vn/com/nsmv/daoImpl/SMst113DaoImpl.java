package vn.com.nsmv.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nsmv.dao.SMst113Dao;
import vn.com.nsmv.entities.SMst113Entity;

@Repository
@Transactional
public class SMst113DaoImpl implements SMst113Dao {

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

  @Override
  public List<SMst113Entity> selectForList(String seizoshoKbn) {
    return null;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<SMst113Entity> selectByPrimaryKey(SMst113Entity mst113Entity) {

    // Create query
    StringBuilder sb = new StringBuilder();
    sb.append("FROM SMst113Entity ");
    sb.append("WHERE ");
    sb.append("seizosho_kbn = :seizosho_kbn ");
    sb.append("AND bincd = :bincd ");
    sb.append("AND gyoshacd = :gyoshacd ");
    sb.append("AND yushutsu_kbn = :yushutsu_kbn");

    return sessionFactory.getCurrentSession()
        .createQuery(sb.toString()).setParameter("seizosho_kbn", mst113Entity.getSeizosho_kbn())
        .setParameter("bincd", mst113Entity.getBincd())
        .setParameter("gyoshacd", mst113Entity.getGyoshacd())
        .setParameter("yushutsu_kbn", mst113Entity.getYushutsu_kbn()).list();

  }

  @Override
  public int selectCount() {
    return 0;
  }

}
