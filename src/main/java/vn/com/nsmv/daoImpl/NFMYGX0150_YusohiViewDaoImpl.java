package vn.com.nsmv.daoImpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nsmv.bean.CommonParam;
import vn.com.nsmv.bean.NFMYGX0150_YusohiViewBodyBean;
import vn.com.nsmv.bean.NFMYGX0150_YusohiViewHeadBean;
import vn.com.nsmv.common.StringUtil;
import vn.com.nsmv.dao.NFMYGX0150_YusohiViewDao;

/**
 * Select yusohi dao implement class.
 * 
 * @author NSMV
 */
@Repository
@Transactional
public class NFMYGX0150_YusohiViewDaoImpl implements NFMYGX0150_YusohiViewDao {

  @Autowired
  SessionFactory sessionFactory;

  /**
   * Logger
   */
  private static final Logger logger = Logger.getLogger(NFMYGX0150_YusohiViewDaoImpl.class);

  /**
   * Get session factory
   * 
   * @param sessionFactory
   */
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * vn.com.nsmv.dao.NFMYGX0150_YusohiViewDao#selectHeadInfoYusohi(vn.com.nsmv.bean.CommonParam)
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<NFMYGX0150_YusohiViewHeadBean> selectHeadInfoYusohi(CommonParam param) {
    List<NFMYGX0150_YusohiViewHeadBean> detailHeadList = new ArrayList<>();

    try {
      // Create SQL
      StringBuilder sb = new StringBuilder();
      sb.append("SELECT ");
      sb.append("HEAD.SEIZOSHO_KBN,");
      sb.append("HEAD.SOJONO_SHUKKO_BASHO,");
      sb.append("HEAD.SOJONO_TORIHIKI_SHUBETSU,");
      sb.append("HEAD.SOJONO_OBAN,");
      sb.append("HEAD.SOJONO_RENBAN,");
      sb.append("HEAD.HEAD_TEISEI_KBN,");
      sb.append("HEAD.HEAD_TEISEI_KAISU,");
      sb.append(
          "CONCAT(HEAD.KEIYAKUNO_YEAR,'-',HEAD.KEIYAKUNO_KANKATSU,'-',HEAD.KEIYAKUNO_HINSHU,'-',HEAD.KEIYAKUNO_TORIHIKI_SHUBETSU,'-',HEAD.KEIYAKUNO_MONTH,'-',HEAD.KEIYAKUNO_OBAN) AS KEIYAKU_NO,");
      sb.append("HEAD.BINCD,");
      sb.append("HEAD.SHUKKA_DATE,");
      sb.append("HEAD.SHUKKO_BASHO,");
      sb.append("HEAD.UKEWATASHI_BASHO,");
      sb.append("HEAD.UKEWATASHI_JOKEN,");
      sb.append("HEAD.ICHIJI_JUYOKA,");
      sb.append("HEAD.BUPPIN04,");
      sb.append("HEAD.KEIREKI_FLG,");

      sb.append("HEAD.JURYO,");
      sb.append("A.USER_KANJI,");
      sb.append("B.SHUKKOBA_NIKKEN_KANJI,");
      sb.append("CONCAT(C.KEN_KANJI, C.SIGUN_KANJI) AS UKEWATASHIBASHO,");
      sb.append("D.BKN4_KANJI,");
      sb.append("E.UKE_JOKEN_KANJI,");

      sb.append("BODY.TSUMIKOMI_MINATO,");
      sb.append("BODY.AGE_MINATO,");
      sb.append("BODY.TSUMIAICD,");
      sb.append("BODY.DAISU, ");
      sb.append("HEAD.KIHON_YUSO_KYORI ");

      sb.append("FROM  S_MST_YUSO_HEAD HEAD ");
      sb.append("INNER JOIN  S_MST_YUSO_BODY BODY ");
      sb.append("ON (HEAD.SEIZOSHO_KBN  = BODY.SEIZOSHO_KBN  AND ");
      sb.append("HEAD.SOJONO_SHUKKO_BASHO =  BODY.SOJONO_SHUKKO_BASHO  AND ");
      sb.append("HEAD.SOJONO_TORIHIKI_SHUBETSU = BODY.SOJONO_TORIHIKI_SHUBETSU  AND ");
      sb.append("HEAD.SOJONO_OBAN =  BODY.SOJONO_OBAN  AND ");
      sb.append("HEAD.SOJONO_RENBAN =  BODY.SOJONO_RENBAN  AND ");
      sb.append("HEAD.HEAD_TEISEI_KBN = BODY.HEAD_TEISEI_KBN  AND ");
      sb.append("HEAD.HEAD_TEISEI_KAISU = BODY.HEAD_TEISEI_KAISU  AND ");
      sb.append("HEAD.SEIKYU_NENGETSU = BODY.SEIKYU_NENGETSU AND ");
      sb.append("HEAD.KEIREKI_FLG = BODY.KEIREKI_FLG) ");

      sb.append("LEFT JOIN S_MST_A5K A ON HEAD.ICHIJI_JUYOKA = A.USER_CD ");
      sb.append("LEFT JOIN S_MST_A7K B ON HEAD.SHUKKO_BASHO = B.SHUKKOBA  ");
      sb.append(
          "LEFT JOIN S_MST_A3K C ON (SUBSTRING(HEAD.UKEWATASHI_BASHO,1,2) = C.UKE_BA_KEN_CD AND SUBSTRING(HEAD.UKEWATASHI_BASHO,3,2) = C.UKE_BA_SIGUN_CD) ");
      sb.append("LEFT JOIN S_MST_60S D ON HEAD.BUPPIN04 = D.BKN14 ");
      sb.append("LEFT JOIN S_MST_A9K E ON HEAD.UKEWATASHI_JOKEN = E.UKE_JOKEN ");

      sb.append("WHERE ");
      sb.append("HEAD.SEIZOSHO_KBN = :seizoshoKbn ");
      sb.append("AND BODY.SEIZOSHO_KBN = :seizoshoKbn ");
      sb.append("AND HEAD.SOJONO_SHUKKO_BASHO = :sojoNoShukkoBasho ");
      sb.append("AND HEAD.SOJONO_TORIHIKI_SHUBETSU = :sojoNoTorihikiShubetsu ");
      sb.append("AND HEAD.SOJONO_OBAN = :sojoNoOban ");
      sb.append("AND HEAD.SOJONO_RENBAN = :sojoNoRenban ");
      sb.append("AND HEAD.HEAD_TEISEI_KBN IN ('S','T','C') ");

      sb.append("ORDER BY  HEAD.HEAD_TEISEI_KAISU ASC,HEAD.HEAD_TEISEI_KBN ASC");

      // Create Query
      SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sb.toString());

      // Set param for query
      query.setParameter("seizoshoKbn", param.getSeizoshoKbn());
      query.setParameter("sojoNoShukkoBasho", param.getSojoNoShukkoBasho());
      query.setParameter("sojoNoTorihikiShubetsu", param.getSojoNoTorihikiShubetsu());
      query.setParameter("sojoNoOban", param.getSojoNoOban());
      query.setParameter("sojoNoRenban", param.getSojoNoRenban());

      // Execute query
      List<Object[]> rows = query.list();

      // Convert to bean
      this.convertToHeadInfoList(detailHeadList, rows);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
      throw ex;
    }

    // Return result
    return detailHeadList;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * vn.com.nsmv.dao.NFMYGX0150_YusohiViewDao#selectBodyInfoYusohi(vn.com.nsmv.bean.CommonParam)
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<NFMYGX0150_YusohiViewBodyBean> selectBodyInfoYusohi(CommonParam param) {
    List<NFMYGX0150_YusohiViewBodyBean> detailBodyList = new ArrayList<>();
    try {
      StringBuilder sb = new StringBuilder();
      sb.append("SELECT ");
      sb.append("BODY.HIMOKUCD,");
      sb.append("BODY.GYOSHACD,");
      sb.append("BODY.SEIKYU_NENGETSU,");
      sb.append("BODY.TANKA_TANI,");
      sb.append("BODY.TANKA,");
      sb.append("BODY.UCHIWAKE_BASE_JURYO,");
      sb.append("BODY.UCHIWAKE_BASE_KINGAKU,");
      sb.append("BODY.UCHIWAKE_KUTON_JURYO,");
      sb.append("BODY.UCHIWAKE_KUTON_KINGAKU,");
      sb.append("BODY.UCHIWAKE_CHOJAKU_JURYO,");
      sb.append("BODY.UCHIWAKE_CHOJAKU_KINGAKU,");
      sb.append("BODY.UCHIWAKE_JIKANGAI_JURYO,");
      sb.append("BODY.UCHIWAKE_JIKANGAI_KINGAKU,");
      sb.append("BODY.UCHIWAKE_SONOTA_JURYO,");
      sb.append("BODY.UCHIWAKE_SONOTA_KINGAKU,");
      sb.append("BODY.BODY_TEISEI_KBN,");
      sb.append("BODY.BODY_TEISEI_KAISU,");
      sb.append("HEAD.HEAD_TEISEI_KBN,");
      sb.append("HEAD.HEAD_TEISEI_KAISU,");
      sb.append("BODY.KEIREKI_FLG,");
      sb.append("BODY.KINGAKU ");

      sb.append("FROM  S_MST_YUSO_HEAD HEAD ");
      sb.append("INNER JOIN  S_MST_YUSO_BODY BODY ");
      sb.append("ON (HEAD.SEIZOSHO_KBN  = BODY.SEIZOSHO_KBN  AND ");
      sb.append("HEAD.SOJONO_SHUKKO_BASHO =  BODY.SOJONO_SHUKKO_BASHO  AND ");
      sb.append("HEAD.SOJONO_TORIHIKI_SHUBETSU = BODY.SOJONO_TORIHIKI_SHUBETSU  AND ");
      sb.append("HEAD.SOJONO_OBAN =  BODY.SOJONO_OBAN  AND ");
      sb.append("HEAD.SOJONO_RENBAN =  BODY.SOJONO_RENBAN  AND ");
      sb.append("HEAD.HEAD_TEISEI_KBN = BODY.HEAD_TEISEI_KBN  AND ");
      sb.append("HEAD.HEAD_TEISEI_KAISU = BODY.HEAD_TEISEI_KAISU  AND ");
      sb.append("HEAD.SEIKYU_NENGETSU = BODY.SEIKYU_NENGETSU)");

      sb.append("WHERE ");
      sb.append("HEAD.SEIZOSHO_KBN = :seizoshoKbn ");
      sb.append("AND BODY.SEIZOSHO_KBN = :seizoshoKbn ");
      sb.append("AND HEAD.SOJONO_SHUKKO_BASHO = :sojoNoShukkoBasho ");
      sb.append("AND HEAD.SOJONO_TORIHIKI_SHUBETSU = :sojoNoTorihikiShubetsu ");
      sb.append("AND HEAD.SOJONO_OBAN = :sojoNoOban ");
      sb.append("AND HEAD.SOJONO_RENBAN = :sojoNoRenban ");
      sb.append("AND HEAD.HEAD_TEISEI_KBN IN ('S','T','C') ");

      sb.append("ORDER BY  HEAD.HEAD_TEISEI_KAISU ASC,HEAD.HEAD_TEISEI_KBN ASC");

      // Create Query
      SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sb.toString());

      // Set param for query
      query.setParameter("seizoshoKbn", param.getSeizoshoKbn());
      query.setParameter("sojoNoShukkoBasho", param.getSojoNoShukkoBasho());
      query.setParameter("sojoNoTorihikiShubetsu", param.getSojoNoTorihikiShubetsu());
      query.setParameter("sojoNoOban", param.getSojoNoOban());
      query.setParameter("sojoNoRenban", param.getSojoNoRenban());

      // Execute query
      List<Object[]> rows = query.list();

      // Convert to bean
      this.convertToBodyInfoList(detailBodyList, rows);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
      throw ex;
    }

    // Return result
    return detailBodyList;
  }

  /*
   * (non-Javadoc)
   * 
   * @see vn.com.nsmv.dao.NFMYGX0150_YusohiViewDao#isFukusuBin(vn.com.nsmv.bean.CommonParam)
   */
  @SuppressWarnings("unchecked")
  @Override
  public Integer selectBinCounts(CommonParam param) {
    Integer binCounter = 0;
    try {
      StringBuilder sb = new StringBuilder();
      sb.append("SELECT ");
      sb.append("COUNT(*) AS BINCOUNT ");
      sb.append("FROM  S_MST_YUSO_HEAD HEAD ");
      sb.append("WHERE ");
      sb.append("HEAD.SEIZOSHO_KBN = :seizoshoKbn ");
      sb.append("AND HEAD.SOJONO_SHUKKO_BASHO = :sojoNoShukkoBasho ");
      sb.append("AND HEAD.SOJONO_TORIHIKI_SHUBETSU = :sojoNoTorihikiShubetsu ");
      sb.append("AND HEAD.SOJONO_OBAN = :sojoNoOban ");
      sb.append("AND HEAD.KEIREKI_FLG = '0'");

      // Create Query
      SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sb.toString());

      // Set param for query
      query.setParameter("seizoshoKbn", param.getSeizoshoKbn());
      query.setParameter("sojoNoShukkoBasho", param.getSojoNoShukkoBasho());
      query.setParameter("sojoNoTorihikiShubetsu", param.getSojoNoTorihikiShubetsu());
      query.setParameter("sojoNoOban", param.getSojoNoOban());

      // Execute query
      List<BigInteger> rows = query.list();

      binCounter = rows.get(0).intValue();

    } catch (Exception ex) {
      logger.error(ex.getMessage());
      throw ex;
    }

    // Return result
    return binCounter;
  }

  /**
   * Convert to bean.
   * 
   * @param detailHeadList
   * @param rows
   */
  private void convertToHeadInfoList(List<NFMYGX0150_YusohiViewHeadBean> detailHeadList,
      List<Object[]> rows) {

    String seizoshoKbn = "";
    String sojonoShukkoBasho = "";
    String sojonoTorihikiShubetsu = "";
    String sojonoOban = "";
    String headTeiseiKbn = "";
    String headTeiseiKaisu = "";

    NFMYGX0150_YusohiViewHeadBean bean = null;

    for (int i = 0; i < rows.size(); i++) {
      Object[] row = rows.get(i);

      if (!seizoshoKbn.equals(StringUtil.getStr(row[0]))
          && !sojonoShukkoBasho.equals(StringUtil.getStr(row[1]))
          && !sojonoTorihikiShubetsu.equals(StringUtil.getStr(row[2]))
          && !sojonoOban.equals(StringUtil.getStr(row[3])) && !headTeiseiKbn.equals(StringUtil.getStr(row[4]))
          && !headTeiseiKaisu.equals(StringUtil.getStr(row[5]))) {

        bean = new NFMYGX0150_YusohiViewHeadBean();
        bean.setSeizoshoKbn(StringUtil.getStr(row[0]));
        bean.setSojonoShukkoBasho(StringUtil.getStr(row[1]));
        bean.setSojonoTorihikiShubetsu(StringUtil.getStr(row[2]));
        bean.setSojonoOban(StringUtil.getStr(row[3]));
        bean.setSojonoRenban(StringUtil.getStr(row[4]));
        bean.setHeadTeiseiKbn(StringUtil.getStr(row[5]));
        bean.setHeadTeiseiKaisu(StringUtil.getStr(row[6]));
        bean.setKeiyakuNo(StringUtil.getStr(row[7]));
        bean.setBincd(StringUtil.getStr(row[8]));
        bean.setShukkaDate(StringUtil.getStr(row[9]));
        bean.setShukkoBasho(StringUtil.getStr(row[10]));
        bean.setUkewatashiBasho(StringUtil.getStr(row[11]));
        bean.setUkewatashiJoken(StringUtil.getStr(row[12]));
        bean.setIchijiJuyoka(StringUtil.getStr(row[13]));
        bean.setBukkan14(StringUtil.getStr(row[14]));
        bean.setKeirikiFlg(StringUtil.getStr(row[15]));
        bean.setJuryo((Integer) row[16]);

        bean.setIchijiJuyokaName(StringUtil.getStr(row[17]));
        bean.setShukkoBashoName(StringUtil.getStr(row[18]));
        bean.setUkewatashiBashoName(StringUtil.getStr(row[19]));
        bean.setBukkan14Name(StringUtil.getStr(row[20]));
        bean.setUkewatashiJokenName(StringUtil.getStr(row[21]));

        bean.setTsumiko(StringUtil.getStr(row[22]));
        bean.setAgeko(StringUtil.getStr(row[23]));
        bean.setTsumiaicd(StringUtil.getStr(row[24]));
        bean.setDaisu(StringUtil.getStr(row[25]));
        bean.setKyori(StringUtil.getStr(row[26]));

        detailHeadList.add(bean);
      }
      seizoshoKbn = StringUtil.getStr(row[0]);
      sojonoShukkoBasho = StringUtil.getStr(row[1]);
      sojonoTorihikiShubetsu = StringUtil.getStr(row[2]);
      sojonoOban = StringUtil.getStr(row[3]);
      headTeiseiKbn = StringUtil.getStr(row[4]);
      headTeiseiKaisu = StringUtil.getStr(row[5]);
    }
  }

  /**
   * Convert list result to list bean
   * 
   * @param detailBodyList
   * @param rows
   */
  private void convertToBodyInfoList(List<NFMYGX0150_YusohiViewBodyBean> detailBodyList,
      List<Object[]> rows) {
    NFMYGX0150_YusohiViewBodyBean himoku = null;

    for (int i = 0; i < rows.size(); i++) {
      Object[] row = rows.get(i);
      himoku = new NFMYGX0150_YusohiViewBodyBean();

      himoku.setHimokucd(StringUtil.getStr(row[0]));
      himoku.setGyoshaCd(StringUtil.getStr(row[1]));
      himoku.setSeikyuNengetsu(StringUtil.getStr(row[2]));
      himoku.setTankaTani(StringUtil.getStr(row[3]));
      himoku.setTanka((Integer) row[4]);

      himoku.setUchiwakeBaseJuryo((Integer) row[5]);
      himoku.setUchiwakeBaseKingaku((Integer) row[6]);

      himoku.setUchiwakeKutonJuryo((Integer) row[7]);
      himoku.setUchiwakeKutonKingaku((Integer) row[8]);

      himoku.setUchiwakeChojakuJuryo((Integer) row[9]);
      himoku.setUchiwakeChojakuKingaku((Integer) row[10]);

      himoku.setUchiwakeJikangaiJuryo((Integer) row[11]);
      himoku.setUchiwakeJikangaiKingaku((Integer) row[12]);

      himoku.setUchiwakeKyujitsuJuryo((Integer) row[13]);
      himoku.setUchiwakeKyujitsuKingaku((Integer) row[14]);

      himoku.setBodyTeiseiKbn(StringUtil.getStr(row[15]));
      himoku.setBodyTeiseiKaisu(StringUtil.getStr(row[16]));

      himoku.setHeadTeiseiKbn(StringUtil.getStr(row[17]));
      himoku.setHeadTeiseiKaisu(StringUtil.getStr(row[18]));

      himoku.setBodyKeirikiFlag(StringUtil.getStr(row[19]));

      himoku.setKingaku((Integer) row[20]);
      detailBodyList.add(himoku);
    }
  }
}
