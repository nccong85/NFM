package vn.com.nsmv.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nsmv.bean.NFMYGX0140_Bean;
import vn.com.nsmv.common.NumberUtil;
import vn.com.nsmv.common.StringUtil;
import vn.com.nsmv.dao.SMstYusoHeadDao;
import vn.com.nsmv.entities.SMstYusoHeadEntity;

@Repository
@Transactional
public class SMstYusoHeadDaoImpl implements SMstYusoHeadDao {

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
	 * @see vn.com.nsmv.dao.SMstYusoHeadDao#selectForList(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SMstYusoHeadEntity> selectForList(String seizoshoKbn) {
		String sql = "FROM SMstYusoHeadEntity WHERE seizosho_kbn = :seizoshoKbn";
		return sessionFactory.getCurrentSession().createQuery(sql).setParameter("seizoshoKbn", seizoshoKbn).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SMstYusoHeadEntity> selectByPrimaryKey(SMstYusoHeadEntity yusoMasterHeadEntity) {

		// Create select query
		StringBuilder sb = new StringBuilder();
		sb.append("FROM SMstYusoHeadEntity WHERE");
		sb.append(" seizoshoKbn = :seizoshoKbn");
		sb.append(" AND sojonoShukkoBasho = :sojonoShukkoBasho");
		sb.append(" AND sojonoTorihikiShubetsu = :sojonoTorihikiShubetsu");
		sb.append(" AND sojonoOban = :sojonoOban");
		sb.append(" AND sojonoRenban = :sojonoRenban");

		// Execute select
		return sessionFactory.getCurrentSession().createQuery(sb.toString())
				.setParameter("seizoshoKbn", yusoMasterHeadEntity.getSeizoshoKbn())
				.setParameter("sojonoShukkoBasho", yusoMasterHeadEntity.getSojonoShukkoBasho())
				.setParameter("sojonoTorihikiShubetsu", yusoMasterHeadEntity.getSojonoTorihikiShubetsu())
				.setParameter("sojonoOban", yusoMasterHeadEntity.getSojonoOban())
				.setParameter("sojonoRenban", yusoMasterHeadEntity.getSojonoRenban()).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.com.nsmv.dao.SMstYusoHeadDao#selectByPrimaryKeyOrderByTeisei(vn.com.
	 * nsmv.entities. SMstYusoHeadEntity)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SMstYusoHeadEntity> selectByPrimaryKeyOrderByTeisei(SMstYusoHeadEntity yusoMasterHeadEntity) {
		// Create select query
		StringBuilder sb = new StringBuilder();
		sb.append("FROM SMstYusoHeadEntity WHERE");
		sb.append(" seizoshoKbn = :seizoshoKbn");
		sb.append(" AND sojonoShukkoBasho = :sojonoShukkoBasho");
		sb.append(" AND sojonoTorihikiShubetsu = :sojonoTorihikiShubetsu");
		sb.append(" AND sojonoOban = :sojonoOban");
		sb.append(" AND sojonoRenban = :sojonoRenban");
		sb.append(" ORDER BY headTeiseiKaisu DESC,headTeiseiKbn ASC");

		// Execute select
		return sessionFactory.getCurrentSession().createQuery(sb.toString())
				.setParameter("seizoshoKbn", yusoMasterHeadEntity.getSeizoshoKbn())
				.setParameter("sojonoShukkoBasho", yusoMasterHeadEntity.getSojonoShukkoBasho())
				.setParameter("sojonoTorihikiShubetsu", yusoMasterHeadEntity.getSojonoTorihikiShubetsu())
				.setParameter("sojonoOban", yusoMasterHeadEntity.getSojonoOban())
				.setParameter("sojonoRenban", yusoMasterHeadEntity.getSojonoRenban()).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.com.nsmv.dao.SMstYusoHeadDao#insert(vn.com.nsmv.entities.
	 * SMstYusoHeadEntity)
	 */
	@Override
	public int insert(SMstYusoHeadEntity yusoMasterHead) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(yusoMasterHead);
			return 1;
			
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.com.nsmv.dao.SMstYusoHeadDao#updateByPrimaryKey(vn.com.nsmv.entities.
	 * SMstYusoHeadEntity)
	 */
	@Override
	public boolean updateByPrimaryKey(SMstYusoHeadEntity yusoMasterHead) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(yusoMasterHead);
			return true;
			
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.com.nsmv.dao.SMstYusoHeadDao#deleteByPrimaryKey(vn.com.nsmv.entities.
	 * SMstYusoHeadEntity)
	 */
	@Override
	public boolean deleteByPrimaryKey(SMstYusoHeadEntity yusoMasterHead) {

		// Get current session
		Session session = sessionFactory.getCurrentSession();
		try {
			// Begin transaction
			// session.beginTransaction();

			session.delete(yusoMasterHead);

			// Commit transaction
			// session.getTransaction().commit();
		} catch (HibernateException e) {

			// In case exception
			e.printStackTrace();
			return false;
		}

		// In case delete success
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.com.nsmv.dao.SMstYusoHeadDao#selectCount()
	 */
	@Override
	public int selectCount() {
		return (int) sessionFactory.getCurrentSession().createCriteria(SMstYusoHeadEntity.class)
				.setProjection(Projections.rowCount()).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see vn.com.nsmv.dao.SMstYusoHeadDao#deleteAll()
	 */
	@Override
	public void deleteAll() {
		String hql = String.format("delete from %s", "SMstYusoHeadEntity");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see vn.com.nsmv.dao.SMstYusoHeadDao#selectHeadEntity(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, java.lang.String)
	 */
	@Override
	public SMstYusoHeadEntity selectHeadEntity(NFMYGX0140_Bean bean) {
		
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SMstYusoHeadEntity.class);
			criteria.add(Restrictions.eq("seizoshoKbn", bean.getSeizoshoKbn()));
			criteria.add(Restrictions.eq("sojonoShukkoBasho", bean.getSojoNoBasho()));
			criteria.add(Restrictions.eq("sojonoTorihikiShubetsu", bean.getSojoNoShubetsu()));
			criteria.add(Restrictions.eq("sojonoOban", bean.getSojoNoOban()));
			criteria.add(Restrictions.eq("sojonoRenban", bean.getSojoNoRenban()));
			criteria.add(Restrictions.eq("headTeiseiKbn", bean.getHeadTeiseiKbn()));
			criteria.add(Restrictions.eq("headTeiseiKaisu", bean.getHeadTeiseiKaisu()));
			criteria.add(Restrictions.eq("seikyuNengetsu", bean.getSeikyuNengetsu()));
			
			return (SMstYusoHeadEntity) criteria.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see vn.com.nsmv.dao.SMstYusoHeadDao#selectHeadAnBody(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)
	 */
	@Override
	public NFMYGX0140_Bean selectHeadAnBody(String seizoshoKbn, String sojonoShukkoBasho, String sojonoTorihikiShubetsu,
			String sojonoOban, int sojonoRenban) {
		ResourceBundle bundle = ResourceBundle.getBundle("sql_query");
		String query = bundle.getString("nfmygx0140_select");

		SQLQuery sql = sessionFactory.getCurrentSession().createSQLQuery(query);
		sql.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		sql.setParameter("seizosho", seizoshoKbn);
		sql.setParameter("basho", sojonoShukkoBasho);
		sql.setParameter("shubetsu", sojonoTorihikiShubetsu);
		sql.setParameter("oban", sojonoOban);
		sql.setParameter("renban", sojonoRenban);

		@SuppressWarnings("unchecked")
		List<HashMap<String, String>> rows = (List<HashMap<String, String>>) sql.list();

		if (rows.size()>0) {
			HashMap<String, String> row = rows.get(0);
			NFMYGX0140_Bean bean = new NFMYGX0140_Bean();
			bean.setSeizoshoKbn(StringUtil.getStr(row.get("seizosho_kbn")));
			bean.setSojoNoBasho(StringUtil.getStr(row.get("sojono_shukko_basho")));
			bean.setSojoNoShubetsu(StringUtil.getStr(row.get("sojono_torihiki_shubetsu")));
			bean.setSojoNoOban(StringUtil.getStr(row.get("sojono_oban")));
			int sojoNoRenban = 0;
			if (!StringUtil.nullToEmpty(StringUtil.getStr(row.get("sojono_renban"))).isEmpty()) {
				sojoNoRenban = NumberUtil.toInteger(StringUtil.getStr(row.get("sojono_renban")));
				bean.setSojoNoRenban(sojoNoRenban);
			}
			bean.setShukkaDate(StringUtil.getStr(row.get("shukka_date")));
			bean.setKeiyakunoYear(StringUtil.getStr(row.get("keiyakuno_year")));
			bean.setKeiyakunoKankatsu(StringUtil.getStr(row.get("keiyakuno_kankatsu")));
			bean.setKeiyakunoHinshu(StringUtil.getStr(row.get("keiyakuno_hinshu")));
			bean.setKeiyakunoTorihiki(StringUtil.getStr(row.get("keiyakuno_torihiki_shubetsu")));
			bean.setKeiyakunoMonth(StringUtil.getStr(row.get("keiyakuno_month")));
			bean.setKeiyakunoOban(StringUtil.getStr(row.get("keiyakuno_oban")));
			bean.setIchijiJuyoka(StringUtil.getStr(row.get("ichiji_juyoka")));
			bean.setUserKanji(StringUtil.getStr(row.get("user_kanji")));
			bean.setShukkoBasho(StringUtil.getStr(row.get("shukko_basho")));
			bean.setNikenKaji(StringUtil.getStr(row.get("shukkoba_nikken_kanji")));
			bean.setBuppin04(StringUtil.getStr(row.get("buppin04")));
			bean.setBkn4Kanji(StringUtil.getStr(row.get("bkn4_kanji")));
			bean.setUkBasho(StringUtil.getStr(row.get("ukewatashi_basho")));
			bean.setA3kUkBasho(StringUtil.getStr(row.get("ukewatashibasho")));
			bean.setUkJoken(StringUtil.getStr(row.get("ukewatashi_joken")));
			bean.setJokenKanji(StringUtil.getStr(row.get("uke_joken_kanji")));
			bean.setBinCd(StringUtil.getStr(row.get("bincd")));
			bean.setTsumikomiMinato(StringUtil.getStr(row.get("tsumikomi_minato")));
			bean.setAgeMinato(StringUtil.getStr(row.get("age_minato")));
			if (!StringUtil.nullToEmpty(StringUtil.getStr(row.get("daisu"))).isEmpty()) {
				bean.setDaisu(NumberUtil.toInteger(StringUtil.getStr(row.get("daisu"))));
			}
			if (!StringUtil.nullToEmpty(StringUtil.getStr(row.get("juryo"))).isEmpty()) {
				bean.setJuryo(NumberUtil.toInteger(StringUtil.getStr(row.get("juryo"))));
			}
			bean.setTsumiaiCd(StringUtil.getStr(row.get("tsumiaicd")));
			bean.setSeikyuNengetsu(StringUtil.getStr(row.get("seikyu_nengetsu")));
			if (!StringUtil.nullToEmpty(StringUtil.getStr(row.get("kihon_yuso_kyori"))).isEmpty()) {
				bean.setKihonYusoKyori(NumberUtil.toInteger(StringUtil.getStr(row.get("kihon_yuso_kyori"))));
			}
			String headTeiseiKbn = StringUtil.getStr(row.get("head_teisei_kbn"));
			bean.setHeadTeiseiKbn(headTeiseiKbn);
			int headTeiseiKaisu = 0;
			if (!StringUtil.nullToEmpty(StringUtil.getStr(row.get("head_teisei_kaisu"))).isEmpty()) {
				headTeiseiKaisu = NumberUtil.toInteger(StringUtil.getStr(row.get("head_teisei_kaisu")));
				bean.setHeadTeiseiKaisu(headTeiseiKaisu);
			}
			// Set list sojo follow to Himocku
			List<NFMYGX0140_Bean> listObject = selectDetail(seizoshoKbn, sojonoShukkoBasho, sojonoTorihikiShubetsu,
					sojonoOban, sojoNoRenban, headTeiseiKbn, headTeiseiKaisu);
			if (listObject.size() > 0) {
				bean.setSelectDetail(listObject);
				// Set 金額 {22}
				int totalKingaku = 0;
				for (NFMYGX0140_Bean e : listObject) {
					totalKingaku += e.getTotalKingaku();
				}
				bean.setTotalKingaku(totalKingaku);
			} 
			
			return bean;
		}
		return null;
	}

	/**
	 * SelectDetail
	 * @param seizoshoKbn
	 * @param sojoNoBasho
	 * @param sojoNoShubetsu
	 * @param sojoNoOban
	 * @param sojoNoRenban
	 * @param headTeiseiKbn
	 * @param headTeiseiKaisu
	 * @return
	 */
	private List<NFMYGX0140_Bean> selectDetail(String seizoshoKbn, String sojoNoBasho, String sojoNoShubetsu, 
			String sojoNoOban, int sojoNoRenban, String headTeiseiKbn, int headTeiseiKaisu){
		ResourceBundle bundle = ResourceBundle.getBundle("sql_query");
		String query = bundle.getString("nfmygx0140_select_detail");

		SQLQuery sql = sessionFactory.getCurrentSession().createSQLQuery(query);
		sql.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		sql.setParameter("seizosho", seizoshoKbn);
		sql.setParameter("basho", sojoNoBasho);
		sql.setParameter("shubetsu", sojoNoShubetsu);
		sql.setParameter("oban", sojoNoOban);
		sql.setParameter("renban", sojoNoRenban);
		sql.setParameter("teiseiKbn", headTeiseiKbn);
		sql.setParameter("teiseiKaisu", headTeiseiKaisu);
		
		List<NFMYGX0140_Bean> results = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<HashMap<String, String>> rows = sql.list();
		
		if (rows.size()>0) {
			for (int i = 0; i < rows.size(); i++) {
				HashMap<String, String> row = rows.get(i);
				NFMYGX0140_Bean bean = new NFMYGX0140_Bean();
				
				bean.setHimokuCd(StringUtil.getStr(row.get("himokucd")));
				bean.setGyoshaCd(StringUtil.getStr(row.get("gyoshacd")));
				
				bean.setBodyTeiseiKbn(StringUtil.getStr(row.get("body_teisei_kbn")));
				
				if(!StringUtil.nullToEmpty(StringUtil.getStr(row.get("body_teisei_kaisu"))).isEmpty()){
					bean.setBodyTeiseiKaisu(NumberUtil.toInteger(StringUtil.getStr(row.get("body_teisei_kaisu"))));
				}
				bean.setSeikyuNengetsu(StringUtil.getStr(row.get("seikyu_nengetsu")));
				bean.setTankaTani(StringUtil.getStr(row.get("tanka_tani")));
				
				if (!StringUtil.nullToEmpty(StringUtil.getStr(row.get("tanka"))).isEmpty()) {
					bean.setTanka(NumberUtil.toInteger(StringUtil.getStr(row.get("tanka"))));
				}
				
				int baseJuryo= 0;
				int baseKingaku = 0;
							
				int kutonJuryo= 0;
				int kutonKingaku = 0;
				
				int chojakuJuryo= 0;
				int chojakuKingaku = 0;
				
				int jikangaiJuryo= 0;
				int jikangaiKingaku = 0;
				
				int sonotaJuryo= 0;
				int sonotaKingaku = 0;
				
				int totalJuryo= 0;
				int totalKingaku = 0;

				if (!StringUtil.nullToEmpty(StringUtil.getStr(row.get("uchiwake_base_juryo"))).isEmpty()) {
					baseJuryo = NumberUtil.toInteger(StringUtil.getStr(row.get("uchiwake_base_juryo")));
					bean.setUchiwakeBaseJuryo(baseJuryo);
				}
				if (!StringUtil.nullToEmpty(StringUtil.getStr(row.get("uchiwake_base_kingaku"))).isEmpty()) {
					baseKingaku = NumberUtil.toInteger(StringUtil.getStr(row.get("uchiwake_base_kingaku")));
					bean.setUchiwakeBaseKingaku(baseKingaku);
				}
				if (!StringUtil.nullToEmpty(StringUtil.getStr(row.get("uchiwake_kuton_juryo"))).isEmpty()) {
					kutonJuryo = NumberUtil.toInteger(StringUtil.getStr(row.get("uchiwake_kuton_juryo")));
					bean.setUchiwakeKutonJuryo(kutonJuryo);
				}
				if (!StringUtil.nullToEmpty(StringUtil.getStr(row.get("uchiwake_kuton_kingaku"))).isEmpty()) {
					kutonKingaku = NumberUtil.toInteger(StringUtil.getStr(row.get("uchiwake_kuton_kingaku")));
					bean.setUchiwakeKutonKingaku(kutonKingaku);
				}
				if (!StringUtil.nullToEmpty(StringUtil.getStr(row.get("uchiwake_chojaku_juryo"))).isEmpty()) {
					chojakuJuryo = NumberUtil.toInteger(StringUtil.getStr(row.get("uchiwake_chojaku_juryo")));
					bean.setUchiwakeChoJakuJuryo(chojakuJuryo);
				}
				if (!StringUtil.nullToEmpty(StringUtil.getStr(row.get("uchiwake_chojaku_kingaku"))).isEmpty()) {
					chojakuKingaku = NumberUtil.toInteger(StringUtil.getStr(row.get("uchiwake_chojaku_kingaku")));
					bean.setUchiwakeChojakuKingaku(chojakuKingaku);
				}
				if (!StringUtil.nullToEmpty(StringUtil.getStr(row.get("uchiwake_jikangai_juryo"))).isEmpty()) {
					jikangaiJuryo = NumberUtil.toInteger(StringUtil.getStr(row.get("uchiwake_jikangai_juryo")));
					bean.setUchiwakeJikangaiJuryo(jikangaiJuryo);
				}
				if (!StringUtil.nullToEmpty(StringUtil.getStr(row.get("uchiwake_jikangai_kingaku"))).isEmpty()) {
					jikangaiKingaku = NumberUtil.toInteger(StringUtil.getStr(row.get("uchiwake_jikangai_kingaku")));
					bean.setUchiwakeJikagaiKingaku(jikangaiKingaku);
				}
				if (!StringUtil.nullToEmpty(StringUtil.getStr(row.get("uchiwake_sonota_juryo"))).isEmpty()) {
					sonotaJuryo = NumberUtil.toInteger(StringUtil.getStr(row.get("uchiwake_sonota_juryo")));
					bean.setUchiwakeSonotaJuryo(sonotaJuryo);
				}
				if (!StringUtil.nullToEmpty(StringUtil.getStr(row.get("uchiwake_sonota_kingaku"))).isEmpty()) {
					sonotaKingaku = NumberUtil.toInteger(StringUtil.getStr(row.get("uchiwake_sonota_kingaku")));
					bean.setUchiwakeSonotaKingaku(sonotaKingaku);
				}
				
				// Total Juryo and Kinkaku
				totalJuryo = baseJuryo + kutonJuryo + jikangaiJuryo + chojakuJuryo + sonotaJuryo;
				totalKingaku = baseKingaku + kutonKingaku + jikangaiKingaku + chojakuKingaku + sonotaKingaku;
				
				bean.setTotalJuryo(totalJuryo);
				bean.setTotalKingaku(totalKingaku);
				
				results.add(bean);			
			}
			return results;
		}
		
		return null;
	}
}
