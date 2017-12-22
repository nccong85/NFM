package vn.com.nsmv.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.dao.SMst207Dao;
import vn.com.nsmv.entities.SMst207Entity;

@Repository
@Transactional
public class SMst207DaoImpl implements SMst207Dao {

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

  @SuppressWarnings("unchecked")
  @Override
  public List<SMst207Entity> selectByList(String seizoshoKbn) {

    String sql = "FROM SMst207Entity WHERE seizosho_kbn = :seizoshoKbn";
    return sessionFactory.getCurrentSession().createQuery(sql)
        .setParameter("seizoshoKbn", seizoshoKbn).list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public SMst207Entity selectByPrimaryKey(String seizoshoKbn, String dataKbn, String key1,
      String key2) {

    SMst207Entity mst207Entity = new SMst207Entity();
    try {
      // Create query
      String sql = "FROM SMst207Entity WHERE seizosho_kbn = :seizoshoKbn AND data_kbn = :dataKbn AND key1 = :key1 AND key2 = :key2";

      // Find in S_MST_207
      List<SMst207Entity> list = sessionFactory.getCurrentSession().createQuery(sql)
          .setParameter("seizoshoKbn", seizoshoKbn).setParameter("dataKbn", dataKbn)
          .setParameter("key1", key1).setParameter("key2", key2).list();

      // Check size of list to return
      if (list != null && list.size() > 0) {
        return list.get(0);
      } else {
        // In case no data
        mst207Entity.setData_kbn(BusinessConst.CodeDef.DataKbn.DATAKBN_T11);
        mst207Entity.setKihon_yuso_kyori(0);
        mst207Entity.setKeisan_yuso_kyori(0);
        mst207Entity.setKinen_kbn("");
        return mst207Entity;
      }

    } catch (Exception e) {
      // In case exception
      mst207Entity.setData_kbn(BusinessConst.CodeDef.DataKbn.DATAKBN_T11);
      mst207Entity.setKihon_yuso_kyori(0);
      mst207Entity.setKeisan_yuso_kyori(0);
      mst207Entity.setKinen_kbn("");

      return mst207Entity;
    }
  }

}
