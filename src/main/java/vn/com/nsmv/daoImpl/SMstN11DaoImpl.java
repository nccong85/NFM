package vn.com.nsmv.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nsmv.common.StringUtil;
import vn.com.nsmv.dao.SMstN11Dao;
import vn.com.nsmv.entities.SMstN11Entity;

@Repository
@Transactional
public class SMstN11DaoImpl implements SMstN11Dao {

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
  
  /* (non-Javadoc)
   * @see vn.com.nsmv.dao.SMstN11Dao#selectByList(java.lang.String)
   */
  @Override
  public List<SMstN11Entity> selectByList(String seizoshoKbn) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see vn.com.nsmv.dao.SMstN11Dao#selectByPrimaryKey(vn.com.nsmv.entities.SMstN11Entity)
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<SMstN11Entity> selectByPrimaryKey(SMstN11Entity entity) {

    // Create query
    StringBuilder sb = new StringBuilder();
    sb.append("FROM SMstN11Entity ");
    sb.append("WHERE ");
    sb.append("seizosho_kbn = :seizosho_kbn ");
    sb.append("AND shukko_basho = :shukko_basho ");
    sb.append("AND gyoshacd = :gyoshacd ");
    sb.append("AND bincd = :bincd ");
    sb.append("AND himokucd = :himokucd ");
    sb.append("AND tsumikomi_minato = :tsumikomi_minato ");
    sb.append("AND age_minato = :age_minato ");
    sb.append("AND tranship_tsumikomi_minato = :tranship_tsumikomi_minato ");
    sb.append("AND ukewatashi_basho = :ukewatashi_basho ");
    sb.append("AND chukei_kbn = :chukei_kbn ");
    sb.append("AND hamakbn = :hamakbn ");
    sb.append("AND mochikomi_cd = :mochikomi_cd ");
    sb.append("AND sub_cd = :sub_cd ");
    sb.append("AND tumikomi_kbn = :tumikomi_kbn ");
    sb.append("AND karioki_kbn = :karioki_kbn ");
    sb.append("AND bt_kbn = :bt_kbn ");
    sb.append("AND hinshu = :hinshu");

    
    if(StringUtil.isEmpty(entity.getTsumikomi_minato())){
      entity.setTsumikomi_minato("    ");
    }
    
    if(StringUtil.isEmpty(entity.getAge_minato())){
      entity.setAge_minato("    ");
    }
    
    if(StringUtil.isEmpty(entity.getTranship_tsumikomi_minato())){
      entity.setTranship_tsumikomi_minato("    ");
    }
    
    if(StringUtil.isEmpty(entity.getUkewatashi_basho())){
      entity.setUkewatashi_basho("    ");
    }
    
    if(StringUtil.isEmpty(entity.getChukei_kbn())){
      entity.setChukei_kbn(" ");
    }
    
    if(StringUtil.isEmpty(entity.getHamakbn())){
      entity.setHamakbn(" ");
    }
    
    if(StringUtil.isEmpty(entity.getMochikomi_cd())){
      entity.setMochikomi_cd("   ");
    }
    
    if(StringUtil.isEmpty(entity.getSub_cd())){
      entity.setSub_cd(" ");
    }
    
    if(StringUtil.isEmpty(entity.getTumikomi_kbn())){
      entity.setTumikomi_kbn(" ");
    }
    
    if(StringUtil.isEmpty(entity.getKarioki_kbn())){
      entity.setKarioki_kbn(" ");
    }
    
    if(StringUtil.isEmpty(entity.getBt_kbn())){
      entity.setBt_kbn(" ");
    }
    
    if(StringUtil.isEmpty(entity.getHinshu())){
      entity.setHinshu("   ");
    }
    
    return sessionFactory.getCurrentSession().createQuery(sb.toString())
        .setParameter("seizosho_kbn", entity.getSeizosho_kbn())
        .setParameter("shukko_basho", entity.getShukko_basho())
        .setParameter("gyoshacd", entity.getGyoshacd())
        .setParameter("bincd", entity.getBincd())
        .setParameter("himokucd", entity.getHimokucd())
        .setParameter("tsumikomi_minato", entity.getTsumikomi_minato())
        .setParameter("age_minato", entity.getAge_minato())
        .setParameter("tranship_tsumikomi_minato", entity.getTranship_tsumikomi_minato())
        .setParameter("ukewatashi_basho", entity.getUkewatashi_basho())
        .setParameter("chukei_kbn", entity.getChukei_kbn())
        .setParameter("hamakbn", entity.getHamakbn())
        .setParameter("mochikomi_cd", entity.getMochikomi_cd())
        .setParameter("sub_cd", entity.getSub_cd())
        .setParameter("tumikomi_kbn", entity.getTumikomi_kbn())
        .setParameter("karioki_kbn", entity.getKarioki_kbn())
        .setParameter("bt_kbn", entity.getBt_kbn())
        .setParameter("hinshu", entity.getHinshu()).list();
  }

}
