package vn.com.nsmv.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nsmv.bean.NFMYGX0120_SukkaJissekiBean;
import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.common.DateUtil;
import vn.com.nsmv.common.StringUtil;
import vn.com.nsmv.dao.SShkaSeiDao;

/**
 * SukkaJisseki implements class
 * @author NSMV
 *
 */
@Repository
@Transactional
public class SShkaSeiDaoImpl implements SShkaSeiDao {

	private static final Logger logger = Logger.getLogger(SShkaSeiDaoImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see vn.com.nsmv.dao.SShkaSeiDao#selectSojoNo(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NFMYGX0120_SukkaJissekiBean selectSojoNo(String sojoNo) {
		NFMYGX0120_SukkaJissekiBean sukkaJisseki = null;
		try {
			StringBuilder sb = new StringBuilder();

			sb.append("SELECT ");
			sb.append("sukka.SOJO_NO,");
			sb.append("sukka.SHUKKA_DATE,");
			sb.append("sukka.KYAK_NO,");
			sb.append("sukka.USER1_CD,");
			sb.append("sukka.SOJO_SHUKKOBA,");
			sb.append("sukka.BKN14, ");
			sb.append("sukka.UKE_BA_KEN_CD,");
			sb.append("sukka.UKE_BA_SIGUN_CD,");
			sb.append("sukka.UKE_JOKEN_CD,");
			
			sb.append("A.USER_KANJI,");
			sb.append("B.SHUKKOBA_NIKKEN_KANJI,");
			sb.append("CONCAT(C.KEN_KANJI, C.SIGUN_KANJI) AS UKEWATASHIBASHO," );
			sb.append("D.BKN4_KANJI,");
			sb.append("E.UKE_JOKEN_KANJI");
			
			sb.append(" FROM");
			sb.append(" SHKA_SEI sukka");
			sb.append(" LEFT JOIN");
			sb.append(" S_MST_A5K A ON SUKKA.USER1_CD = A.USER_CD");
			sb.append(" LEFT JOIN");
			sb.append(" S_MST_A7K B ON SUKKA.SOJO_SHUKKOBA = B.SHUKKOBA");
			sb.append(" LEFT JOIN");
			sb.append(" S_MST_A3K C ON (SUKKA.UKE_BA_KEN_CD = C.UKE_BA_KEN_CD AND SUKKA.UKE_BA_SIGUN_CD = C.UKE_BA_SIGUN_CD)");
			sb.append(" LEFT JOIN");
			sb.append(" S_MST_60S d ON sukka.BKN14 = d.bkn14");
			sb.append(" LEFT JOIN");
			sb.append(" S_MST_A9K E ON SUKKA.UKE_JOKEN_CD = E.UKE_JOKEN");
			sb.append(" WHERE");
			sb.append(" SOJO_NO = :sojoNo");
			
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sb.toString());
			query.setParameter("sojoNo", sojoNo);
			List<Object[]> rows = query.list();

			if (rows != null && rows.size() > 0) {
				Object[] row = rows.get(0);
				sukkaJisseki = createEmptySukkaJisseki();
				sukkaJisseki.setSojoNo(StringUtil.getStr(row[0]));
				sukkaJisseki.setSukkaDate(DateUtil.convertyyyyMMddhhmmss(StringUtil.getStr(row[1])));
				sukkaJisseki.setKeiyakuNo(StringUtil.getStr(row[2]));
				sukkaJisseki.setIchijiJuyoka(StringUtil.getStr(row[3]));
				sukkaJisseki.setSukkoBasho(StringUtil.getStr(row[4]));
				sukkaJisseki.setBukkan14(StringUtil.getStr(row[5]));
				sukkaJisseki.setUkewatashiBasho(StringUtil.getStr(row[6]) + StringUtil.getStr(row[7]));
				sukkaJisseki.setUkewatashiJoken(StringUtil.getStr(row[8]));
				
				sukkaJisseki.setIchijiJuyokaName(StringUtil.getStr(row[9]));
				sukkaJisseki.setSukkoBashoName(StringUtil.getStr(row[10]));
				sukkaJisseki.setUkewatashiBashoName(StringUtil.getStr(row[11]));
				sukkaJisseki.setBukkan14Name(StringUtil.getStr(row[12]));
				sukkaJisseki.setUkewatashiJokenName(StringUtil.getStr(row[13]));

			} else {
				sukkaJisseki = new NFMYGX0120_SukkaJissekiBean();
				sukkaJisseki.setSojoNo(BusinessConst.CodeDef.CheckSpace.BLANK);

			}

		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}

		// Return sukka jisseki
		return sukkaJisseki;
	}

	/**
	 * Create empty NFMYGX0120_SukkaJissekiBean object
	 * @return
	 */
	private NFMYGX0120_SukkaJissekiBean createEmptySukkaJisseki() {
		NFMYGX0120_SukkaJissekiBean sukkaJisseki = new NFMYGX0120_SukkaJissekiBean();

		sukkaJisseki.setSojoNo(BusinessConst.CodeDef.CheckSpace.BLANK);
		sukkaJisseki.setSukkaDate(BusinessConst.CodeDef.CheckSpace.BLANK);
		sukkaJisseki.setKeiyakuNo(BusinessConst.CodeDef.CheckSpace.BLANK);
		sukkaJisseki.setIchijiJuyoka(BusinessConst.CodeDef.CheckSpace.BLANK);
		sukkaJisseki.setSukkoBasho(BusinessConst.CodeDef.CheckSpace.BLANK);
		sukkaJisseki.setBukkan14(BusinessConst.CodeDef.CheckSpace.BLANK);
		sukkaJisseki.setUkewatashiBasho(BusinessConst.CodeDef.CheckSpace.BLANK);
		sukkaJisseki.setUkewatashiJoken(BusinessConst.CodeDef.CheckSpace.BLANK);

		return sukkaJisseki;
	}
}
