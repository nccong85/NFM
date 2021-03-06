package vn.com.nsmv.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nsmv.dao.SMst210KihonDao;
import vn.com.nsmv.entities.SMst210KihonEntity;

@Repository
@Transactional
public class SMst210KihonDaoImpl implements SMst210KihonDao {

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
  public List<SMst210KihonEntity> selectByList(String seizoshoKbn) {
    // TODO Auto-generated method stub
    return null;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<SMst210KihonEntity> selectByPrimaryKey(SMst210KihonEntity entity) {

    // Create query
    StringBuilder sb = new StringBuilder();
    sb.append("FROM SMst210KihonEntity ");
    sb.append("WHERE ");
    sb.append("seizosho_kbn = :seizosho_kbn ");
    sb.append("AND shukko_basho = :shukko_basho ");
    sb.append("AND gyoshacd = :gyoshacd ");
    sb.append("AND bincd = :bincd ");
    sb.append("AND himokucd = :himokucd ");

    return sessionFactory.getCurrentSession().createQuery(sb.toString())
        .setParameter("seizosho_kbn", entity.getSeizosho_kbn())
        .setParameter("shukko_basho", entity.getShukko_basho())
        .setParameter("gyoshacd", entity.getGyoshacd())
        .setParameter("bincd", entity.getBincd())
        .setParameter("himokucd", entity.getHimokucd())
        .list();
  }

}
