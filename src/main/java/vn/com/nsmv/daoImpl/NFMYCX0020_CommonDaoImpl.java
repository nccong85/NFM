package vn.com.nsmv.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nsmv.common.StringUtil;
import vn.com.nsmv.dao.NFMYCX0020_CommonDao;

/**
 * Common data access class.
 * 
 * @author NSMV
 */
@Repository
@Transactional
public class NFMYCX0020_CommonDaoImpl implements NFMYCX0020_CommonDao {

  private static final Logger logger = Logger.getLogger(NFMYCX0020_CommonDaoImpl.class);

  @Autowired
  SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /*
   * (non-Javadoc)
   * 
   * @see vn.com.nsmv.dao.NFMYCX0020_CommonDao#selectBinName(java.lang.String)
   */
  @Override
  public String selectBinName(String binCd) {
    String binName = StringUtil.EMPTY_STRING;
    try {
      StringBuilder sb = new StringBuilder();
      sb.append("SELECT ");
      sb.append("BIN_KANJI ");
      sb.append("FROM ");
      sb.append("S_MST_A4K ");
      sb.append("WHERE ");
      sb.append("bin_cd = :binCd");

      SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sb.toString());
      query.setParameter("binCd", binCd.toUpperCase());

      @SuppressWarnings("unchecked")
      List<String> rows = query.list();

      if (rows != null && rows.size() > 0) {
        binName = StringUtil.getStr(rows.get(0));
      }

    } catch (Exception ex) {
      logger.error(ex.getMessage());
    }

    // Return result
    return binName;
  }

  /*
   * (non-Javadoc)
   * 
   * @see vn.com.nsmv.dao.NFMYCX0020_CommonDao#selectGyoshaName(java.lang.String)
   */
  @Override
  public String selectGyoshaName(String gyoshaCd) {
    String gyoshaName = StringUtil.EMPTY_STRING;
    try {
      StringBuilder sb = new StringBuilder();
      sb.append("SELECT ");
      sb.append("YUSGYO_KANJI ");
      sb.append("FROM ");
      sb.append("S_MST_A8K ");
      sb.append("WHERE ");
      sb.append("yusgyo_cd = :gyoshaCd");

      SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sb.toString());
      query.setParameter("gyoshaCd", gyoshaCd.toUpperCase());

      @SuppressWarnings("unchecked")
      List<String> rows = query.list();

      if (rows != null && rows.size() > 0) {
        gyoshaName = StringUtil.getStr(rows.get(0));
      }

    } catch (Exception ex) {
      logger.error(ex.getMessage());
    }

    // Return result
    return gyoshaName;
  }

  /*
   * (non-Javadoc)
   * 
   * @see vn.com.nsmv.dao.NFMYCX0020_CommonDao#selectHimokuName(java.lang.String)
   */
  @Override
  public String selectHimokuName(String himokuCd) {
    String himokuName = StringUtil.EMPTY_STRING;
    try {
      StringBuilder sb = new StringBuilder();
      sb.append("SELECT ");
      sb.append("HIMO_KANJI ");
      sb.append("FROM ");
      sb.append("S_MST_A4K ");
      sb.append("WHERE ");
      sb.append("himo_cd = :himoCd");

      SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sb.toString());
      query.setParameter("himoCd", himokuCd.toUpperCase());

      @SuppressWarnings("unchecked")
      List<String> rows = query.list();

      if (rows != null && rows.size() > 0) {
        himokuName = StringUtil.getStr(rows.get(0));
      }

    } catch (Exception ex) {
      logger.error(ex.getMessage());
    }

    // Return result
    return himokuName;
  }
}
