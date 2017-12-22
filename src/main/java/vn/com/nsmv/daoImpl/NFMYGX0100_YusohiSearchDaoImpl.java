package vn.com.nsmv.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.nsmv.bean.NFMYGX0100_HimokuBean;
import vn.com.nsmv.bean.NFMYGX0100_SearchBean;
import vn.com.nsmv.bean.NFMYGX0100_SearchResultBean;
import vn.com.nsmv.common.BusinessCommonUtil;
import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.common.StringUtil;
import vn.com.nsmv.dao.NFMYGX0100_YusohiSearchDao;

@Repository
@Transactional
public class NFMYGX0100_YusohiSearchDaoImpl implements NFMYGX0100_YusohiSearchDao {

	@Autowired
	SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(NFMYGX0100_YusohiSearchDaoImpl.class);

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NFMYGX0100_SearchResultBean> selectForInit(String seizoshoKbn) {

		List<NFMYGX0100_SearchResultBean> yusoMasterList = new ArrayList<>();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("HEAD.SEIZOSHO_KBN,");
			sb.append("HEAD.SOJONO_SHUKKO_BASHO,");
			sb.append("HEAD.SOJONO_TORIHIKI_SHUBETSU,");
			sb.append(" HEAD.SOJONO_OBAN,");
			sb.append("HEAD.SOJONO_RENBAN,");
			sb.append("HEAD.HEAD_TEISEI_KBN,");
			sb.append("HEAD.HEAD_TEISEI_KAISU,");
			sb.append("HEAD.BINCD,");
			sb.append("HEAD.SHUKKA_DATE,");
			sb.append("HEAD.SEIKYU_NENGETSU,");
			sb.append("HEAD.SHUKKO_BASHO,");
			sb.append("HEAD.UKEWATASHI_BASHO,");
			sb.append("HEAD.JURYO,");
			sb.append("BODY.TSUMIAICD,");
			sb.append("BODY.DAISU,");
			sb.append("BODY.GYOSHACD,");
			sb.append("BODY.HIMOKUCD,");
			sb.append("BODY.TANKA_TANI,");
			sb.append("BODY.TANKA,");
			sb.append("BODY.KINGAKU,");
			sb.append("BODY.BODY_TEISEI_KBN,");
			sb.append("BODY.BODY_TEISEI_KAISU,");
			sb.append("HEAD.KEIREKI_FLG,");
			sb.append("'YUSO_MASTER' AS SHUTOKU_MOTO ");
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
			sb.append("WHERE HEAD.KEIREKI_FLG = '0' AND ");
			sb.append("BODY.KEIREKI_FLG = '0' ");
			sb.append("AND HEAD.SEIZOSHO_KBN = :seizoshoKbn ");
			sb.append("AND BODY.SEIZOSHO_KBN = :seizoshoKbn ");

			sb.append("UNION ");
			sb.append("SELECT  SEIZOSHO_KBN,");
			sb.append("SOJONO_SHUKKO_BASHO,");
			sb.append("SOJONO_TORIHIKI_SHUBETSU,");
			sb.append("SOJONO_OBAN,");
			sb.append(" SOJONO_RENBAN,");
			sb.append("' ' AS HEAD_TEISEI_KBN,");
			sb.append("0 AS HEAD_TEISEI_KAISU,");
			sb.append("BINCD,");
			sb.append("SHUKKA_DATE,");
			sb.append("SUBSTRING(SHUKKA_DATE FROM 1 FOR 6) AS SEIKYU_NENGETSU,");
			sb.append("SHUKKO_BASHO,");
			sb.append("UKEWATASHI_BASHO,");
			sb.append("JURYO,");
			sb.append("TSUMIAICD,");
			sb.append("DAISU,");
			sb.append("GYOSHACD,");
			sb.append("' ' AS HIMOKUCD,");
			sb.append("' ' AS TANKA_TANI,");
			sb.append("0 AS TANKA,");
			sb.append(" BETTO AS KINGAKU,");
			sb.append("' ' AS BODY_TEISEI_KBN,");
			sb.append("0 AS BODY_TEISEI_KAISU,");
			sb.append("' ' AS KEIREKI_FLG,");
			sb.append("'YUSO_TRAN' AS SHUTOKU_MOTO ");
			sb.append("FROM S_TRA_YUSO ");
			sb.append("WHERE SEIZOSHO_KBN = :seizoshoKbn ");
			sb.append("ORDER BY ");
			sb.append("SOJONO_SHUKKO_BASHO,SOJONO_TORIHIKI_SHUBETSU,SOJONO_OBAN ASC");

			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sb.toString());
			query.setParameter("seizoshoKbn", seizoshoKbn);
			List<Object[]> rows = query.list();

			// Convert list object to list bean
			this.convertToListBean(yusoMasterList, rows);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}

		// Return init list
		return yusoMasterList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NFMYGX0100_SearchResultBean> selectForSearch(NFMYGX0100_SearchBean searchBean) {
		List<NFMYGX0100_SearchResultBean> yusoMasterList = new ArrayList<>();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("HEAD.SEIZOSHO_KBN,");
			sb.append("HEAD.SOJONO_SHUKKO_BASHO,");
			sb.append("HEAD.SOJONO_TORIHIKI_SHUBETSU,");
			sb.append(" HEAD.SOJONO_OBAN,");
			sb.append("HEAD.SOJONO_RENBAN,");
			sb.append("HEAD.HEAD_TEISEI_KBN,");
			sb.append("HEAD.HEAD_TEISEI_KAISU,");
			sb.append("HEAD.BINCD,");
			sb.append("HEAD.SHUKKA_DATE,");
			sb.append("HEAD.SEIKYU_NENGETSU,");
			sb.append("HEAD.SHUKKO_BASHO,");
			sb.append("HEAD.UKEWATASHI_BASHO,");
			sb.append("HEAD.JURYO,");
			sb.append("BODY.TSUMIAICD,");
			sb.append("BODY.DAISU,");
			sb.append("BODY.GYOSHACD,");
			sb.append("BODY.HIMOKUCD,");
			sb.append("BODY.TANKA_TANI,");
			sb.append("BODY.TANKA,");
			sb.append("BODY.KINGAKU,");
			sb.append("BODY.BODY_TEISEI_KBN,");
			sb.append("BODY.BODY_TEISEI_KAISU,");
			sb.append("HEAD.KEIREKI_FLG,");
			sb.append("'YUSO_MASTER' AS SHUTOKU_MOTO ");
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
			sb.append("WHERE HEAD.KEIREKI_FLG = '0' AND ");
			sb.append("BODY.KEIREKI_FLG = '0' ");
			sb.append("AND HEAD.SEIZOSHO_KBN = :seizoshoKbn ");
			sb.append("AND BODY.SEIZOSHO_KBN = :seizoshoKbn ");

			// Append search condition
			// Search SOJONO_SHUKKO_BASHO
			if (!StringUtil.isEmpty(searchBean.getSearchSojoNoShukkoBasho())) {
				sb.append(" AND HEAD.SOJONO_SHUKKO_BASHO iLIKE :sojoNoSukkoBasho ");
			}

			// Search SOJONO_TORIHIKI_SHUBETSU
			if (!StringUtil.isEmpty(searchBean.getSearchSojoNoTorihikiShubetsu())) {
				sb.append(" AND HEAD.SOJONO_TORIHIKI_SHUBETSU iLIKE :sojonoTorihikiShubetsu ");
			}

			// Search SOJONO_OBAN
			if (!StringUtil.isEmpty(searchBean.getSearchSojoNoOban())) {
				sb.append(" AND HEAD.SOJONO_OBAN iLIKE :sojoNoOban ");
			}

			// Search SHUKKA_DATE
			if (!StringUtil.isEmpty(searchBean.getSearchShukkaFromDate())
					&& !StringUtil.isEmpty(searchBean.getSearchShukkaToDate())) {
				sb.append(" AND (HEAD.SHUKKA_DATE BETWEEN :shukkaDateFrom AND :shukkaDateTo) ");
			}

			// Search UKEWATASHI_BASHO
			if (!StringUtil.isEmpty(searchBean.getSearchUkewatashiBasho())) {
				sb.append(" AND HEAD.UKEWATASHI_BASHO iLIKE :ukewatachiBasho ");
			}

			// Search GYOSHACD
			if (!StringUtil.isEmpty(searchBean.getSearchYusoGyoshaCd())) {
				sb.append(" AND BODY.GYOSHACD iLIKE :gyoshaCd ");
			}

			// Search HIMOKUCD
			if (!StringUtil.isEmpty(searchBean.getSearchHimokuCd())) {
				sb.append(" AND BODY.HIMOKUCD iLIKE :himokuCd ");
			}

			// Search TSUMIAICD
			if (!StringUtil.isEmpty(searchBean.getSearchTsumiaiCd())) {
				sb.append(" AND BODY.TSUMIAICD iLIKE :tsumiaiCd ");
			}

			// Search SEIKYU_NENGETSU
			if (!StringUtil.isEmpty(searchBean.getSearchSeikyuYearMonth())) {
				sb.append(" AND BODY.SEIKYU_NENGETSU iLIKE :seikyuNengetsu ");
			}

			if (StringUtil.isEmpty(searchBean.getSearchHimokuCd())) {
				sb.append("UNION ");
				sb.append("SELECT  SEIZOSHO_KBN,");
				sb.append("SOJONO_SHUKKO_BASHO,");
				sb.append("SOJONO_TORIHIKI_SHUBETSU,");
				sb.append("SOJONO_OBAN,");
				sb.append(" SOJONO_RENBAN,");
				sb.append("' ' AS HEAD_TEISEI_KBN,");
				sb.append("0 AS HEAD_TEISEI_KAISU,");
				sb.append("BINCD,");
				sb.append("SHUKKA_DATE,");
				sb.append("SUBSTRING(SHUKKA_DATE FROM 1 FOR 6) AS SEIKYU_NENGETSU,");
				sb.append("SHUKKO_BASHO,");
				sb.append("UKEWATASHI_BASHO,");
				sb.append("JURYO,");
				sb.append("TSUMIAICD,");
				sb.append("DAISU,");
				sb.append("GYOSHACD,");
				sb.append("' ' AS HIMOKUCD,");
				sb.append("' ' AS TANKA_TANI,");
				sb.append("0 AS TANKA,");
				sb.append(" BETTO AS KINGAKU,");
				sb.append("' ' AS BODY_TEISEI_KBN,");
				sb.append("0 AS BODY_TEISEI_KAISU,");
				sb.append("' ' AS KEIREKI_FLG,");
				sb.append("'YUSO_TRAN' AS SHUTOKU_MOTO ");
				sb.append("FROM S_TRA_YUSO ");
				sb.append("WHERE SEIZOSHO_KBN = :seizoshoKbn ");
				// Search SOJONO_SHUKKO_BASHO
				if (!StringUtil.isEmpty(searchBean.getSearchSojoNoShukkoBasho())) {
					sb.append(" AND SOJONO_SHUKKO_BASHO iLIKE :sojoNoSukkoBasho ");
				}

				// Search SOJONO_TORIHIKI_SHUBETSU
				if (!StringUtil.isEmpty(searchBean.getSearchSojoNoTorihikiShubetsu())) {
					sb.append(" AND SOJONO_TORIHIKI_SHUBETSU iLIKE :sojonoTorihikiShubetsu ");
				}

				// Search SOJONO_OBAN
				if (!StringUtil.isEmpty(searchBean.getSearchSojoNoOban())) {
					sb.append(" AND SOJONO_OBAN iLIKE :sojoNoOban ");
				}

				// Search SHUKKA_DATE
				if (!StringUtil.isEmpty(searchBean.getSearchShukkaFromDate())
						&& !StringUtil.isEmpty(searchBean.getSearchShukkaToDate())) {
					sb.append(" AND (SHUKKA_DATE BETWEEN :shukkaDateFrom AND :shukkaDateTo) ");
				}

				// Search UKEWATASHI_BASHO
				if (!StringUtil.isEmpty(searchBean.getSearchUkewatashiBasho())) {
					sb.append(" AND UKEWATASHI_BASHO iLIKE :ukewatachiBasho ");
				}

				// Search GYOSHACD
				if (!StringUtil.isEmpty(searchBean.getSearchYusoGyoshaCd())) {
					sb.append(" AND GYOSHACD iLIKE :gyoshaCd ");
				}

				// Search TSUMIAICD
				if (!StringUtil.isEmpty(searchBean.getSearchTsumiaiCd())) {
					sb.append(" AND TSUMIAICD iLIKE :tsumiaiCd ");
				}

				// Search SEIKYU_NENGETSU
				if (!StringUtil.isEmpty(searchBean.getSearchSeikyuYearMonth())) {
					sb.append(" AND SUBSTRING(SHUKKA_DATE FROM 1 FOR 6) iLIKE :seikyuNengetsu ");
				}
			}

			sb.append("ORDER BY ");
			if(searchBean.getSortSelect().equals("0")){
			  sb.append("SOJONO_SHUKKO_BASHO,SOJONO_TORIHIKI_SHUBETSU,SOJONO_OBAN ASC");
			}else if(searchBean.getSortSelect().equals("1")){
			  sb.append("SHUKKA_DATE,TSUMIAICD ASC");
			}

			// Create Query
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sb.toString());

			// Set param for query
			// Set seizoshoKbn
			query.setParameter("seizoshoKbn", searchBean.getSeizoshoKbn());

			// Set SOJONO_SHUKKO_BASHO
			if (!StringUtil.isEmpty(searchBean.getSearchSojoNoShukkoBasho())) {
				query.setParameter("sojoNoSukkoBasho",
						BusinessCommonUtil.createLikeQuery(searchBean.getSearchSojoNoShukkoBasho()));
			}

			// Set SOJONO_TORIHIKI_SHUBETSU
			if (!StringUtil.isEmpty(searchBean.getSearchSojoNoTorihikiShubetsu())) {
				query.setParameter("sojonoTorihikiShubetsu",
						BusinessCommonUtil.createLikeQuery(searchBean.getSearchSojoNoTorihikiShubetsu()));
			}

			// Set SOJONO_OBAN
			if (!StringUtil.isEmpty(searchBean.getSearchSojoNoOban())) {
				query.setParameter("sojoNoOban", BusinessCommonUtil.createLikeQuery(searchBean.getSearchSojoNoOban()));
			}

			// Set SHUKKA_DATE
			if (!StringUtil.isEmpty(searchBean.getSearchShukkaFromDate())
					&& !StringUtil.isEmpty(searchBean.getSearchShukkaToDate())) {

				query.setParameter("shukkaDateFrom",
						BusinessCommonUtil.removeSlash(searchBean.getSearchShukkaFromDate()));
				query.setParameter("shukkaDateTo", BusinessCommonUtil.removeSlash(searchBean.getSearchShukkaToDate()));
			}

			// Set UKEWATASHI_BASHO
			if (!StringUtil.isEmpty(searchBean.getSearchUkewatashiBasho())) {

				query.setParameter("ukewatachiBasho",
						BusinessCommonUtil.createLikeQuery(searchBean.getSearchUkewatashiBasho()));
			}

			// Set GYOSHACD
			if (!StringUtil.isEmpty(searchBean.getSearchYusoGyoshaCd())) {
				query.setParameter("gyoshaCd", BusinessCommonUtil.createLikeQuery(searchBean.getSearchYusoGyoshaCd()));
			}

			// Set HIMOKUCD
			if (!StringUtil.isEmpty(searchBean.getSearchHimokuCd())) {
				query.setParameter("himokuCd", BusinessCommonUtil.createLikeQuery(searchBean.getSearchHimokuCd()));
			}

			// Set TSUMIAICD
			if (!StringUtil.isEmpty(searchBean.getSearchTsumiaiCd())) {
				query.setParameter("tsumiaiCd", BusinessCommonUtil.createLikeQuery(searchBean.getSearchTsumiaiCd()));
			}

			// Set SEIKYU_NENGETSU
			if (!StringUtil.isEmpty(searchBean.getSearchSeikyuYearMonth())) {
				query.setParameter("seikyuNengetsu",
						BusinessCommonUtil.createLikeQuery(searchBean.getSearchSeikyuYearMonth()));
			}

			// Execute query
			List<Object[]> rows = query.list();

			// Convert list object to list bean
			this.convertToListBean(yusoMasterList, rows);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}

		// Return search result list
		return yusoMasterList;
	}

	/**
	 * Convert list object to list bean
	 * 
	 * @param yusoMasterList
	 *            list beans
	 * @param rows
	 *            list objects
	 */
	private void convertToListBean(List<NFMYGX0100_SearchResultBean> yusoMasterList, List<Object[]> rows) {

		String seizoshoKbn = "";
		String sojonoShukkoBasho = "";
		String sojonoTorihikiShubetsu = "";
		String sojonoOban = "";
		String sojonoRenban = "";
		String headTeiseiKbn = "";
		String headTeiseiKaisu = "";

		NFMYGX0100_SearchResultBean yusoMaster = null;
		int bodyCounter = 0;
		for (int i = 0; i < rows.size(); i++) {

			Object[] row = rows.get(i);
			if (StringUtil.getStr(row[23]).equals("YUSO_TRAN")) {
				yusoMaster = new NFMYGX0100_SearchResultBean();
				yusoMaster.setKeisanStatus(BusinessConst.CodeDef.Biko.KEISAN_ZEN);
				yusoMaster.setSeizoshoKbn(StringUtil.getStr(row[0]));
				yusoMaster.setSojonoShukkoBasho(StringUtil.getStr(row[1]));
				yusoMaster.setSojonoTorihikiShubetsu(StringUtil.getStr(row[2]));
				yusoMaster.setSojonoOban(StringUtil.getStr(row[3]));
				yusoMaster.setSojonoRenban(StringUtil.getStr(row[4]));
				yusoMaster.setHeadTeiseiKbn(StringUtil.getStr(row[5]));
				yusoMaster.setHeadTeiseiKaisu(StringUtil.getStr(row[6]));
				yusoMaster.setBincd(StringUtil.getStr(row[7]));
				yusoMaster.setShukkaDate(StringUtil.getStr(row[8]));
				yusoMaster.setSeikyuNengetsu(StringUtil.getStr(row[9]));

				yusoMaster.setShukkoBasho(StringUtil.getStr(row[10]));
				yusoMaster.setUkewatashiBasho(StringUtil.getStr(row[11]));
				yusoMaster.setGyoshaCd(StringUtil.getStr(row[15]));
				yusoMaster.setDaisu(StringUtil.getStr(row[14]));
				yusoMaster.setJuryo(StringUtil.getStr(row[12]));
				yusoMaster.setTsumiaicd(StringUtil.getStr(row[13]));

				NFMYGX0100_HimokuBean himoku = new NFMYGX0100_HimokuBean(StringUtil.getStr(row[16]),
						StringUtil.getStr(row[17]), StringUtil.getStr(row[18]), StringUtil.getStr(row[19]));
				yusoMaster.getSojoHimokuDataCOList().add(himoku);
				yusoMasterList.add(yusoMaster);
			} else {
				if (bodyCounter == 0) {
					yusoMaster = new NFMYGX0100_SearchResultBean();
					yusoMaster.setKeisanStatus(BusinessConst.CodeDef.Biko.KEISAN_GO);
					yusoMaster.setSeizoshoKbn(StringUtil.getStr(row[0]));
					yusoMaster.setSojonoShukkoBasho(StringUtil.getStr(row[1]));
					yusoMaster.setSojonoTorihikiShubetsu(StringUtil.getStr(row[2]));
					yusoMaster.setSojonoOban(StringUtil.getStr(row[3]));
					yusoMaster.setSojonoRenban(StringUtil.getStr(row[4]));
					yusoMaster.setHeadTeiseiKbn(StringUtil.getStr(row[5]));
					yusoMaster.setHeadTeiseiKaisu(StringUtil.getStr(row[6]));
					yusoMaster.setBincd(StringUtil.getStr(row[7]));
					yusoMaster.setShukkaDate(StringUtil.getStr(row[8]));
					yusoMaster.setSeikyuNengetsu(StringUtil.getStr(row[9]));

					yusoMaster.setShukkoBasho(StringUtil.getStr(row[10]));
					yusoMaster.setUkewatashiBasho(StringUtil.getStr(row[11]));
					yusoMaster.setGyoshaCd(StringUtil.getStr(row[15]));
					yusoMaster.setDaisu(StringUtil.getStr(row[14]));
					yusoMaster.setJuryo(StringUtil.getStr(row[12]));
					yusoMaster.setTsumiaicd(StringUtil.getStr(row[13]));

					NFMYGX0100_HimokuBean himoku = new NFMYGX0100_HimokuBean(StringUtil.getStr(row[16]),
							StringUtil.getStr(row[17]), StringUtil.getStr(row[18]), StringUtil.getStr(row[19]));
					yusoMaster.getSojoHimokuDataCOList().add(himoku);
					yusoMasterList.add(yusoMaster);
					bodyCounter++;
				} else {

					if (seizoshoKbn.equals(StringUtil.getStr(row[0]))
							&& sojonoShukkoBasho.equals(StringUtil.getStr(row[1]))
							&& sojonoTorihikiShubetsu.equals(StringUtil.getStr(row[2]))
							&& sojonoOban.equals(StringUtil.getStr(row[3]))
							&& sojonoRenban.equals(StringUtil.getStr(row[4]))
							&& headTeiseiKbn.equals(StringUtil.getStr(row[5]))
							&& headTeiseiKaisu.equals(StringUtil.getStr(row[6]))) {

						NFMYGX0100_HimokuBean himoku = new NFMYGX0100_HimokuBean(StringUtil.getStr(row[16]),
								StringUtil.getStr(row[17]), StringUtil.getStr(row[18]), StringUtil.getStr(row[19]));
						yusoMaster.getSojoHimokuDataCOList().add(himoku);
					} else {
						yusoMaster = new NFMYGX0100_SearchResultBean();
						yusoMaster.setKeisanStatus(BusinessConst.CodeDef.Biko.KEISAN_GO);
						yusoMaster.setSeizoshoKbn(StringUtil.getStr(row[0]));
						yusoMaster.setSojonoShukkoBasho(StringUtil.getStr(row[1]));
						yusoMaster.setSojonoTorihikiShubetsu(StringUtil.getStr(row[2]));
						yusoMaster.setSojonoOban(StringUtil.getStr(row[3]));
						yusoMaster.setSojonoRenban(StringUtil.getStr(row[4]));
						yusoMaster.setHeadTeiseiKbn(StringUtil.getStr(row[5]));
						yusoMaster.setHeadTeiseiKaisu(StringUtil.getStr(row[6]));
						yusoMaster.setBincd(StringUtil.getStr(row[7]));
						yusoMaster.setShukkaDate(StringUtil.getStr(row[8]));
						yusoMaster.setSeikyuNengetsu(StringUtil.getStr(row[9]));

						yusoMaster.setShukkoBasho(StringUtil.getStr(row[10]));
						yusoMaster.setUkewatashiBasho(StringUtil.getStr(row[11]));
						yusoMaster.setGyoshaCd(StringUtil.getStr(row[15]));
						yusoMaster.setDaisu(StringUtil.getStr(row[14]));
						yusoMaster.setJuryo(StringUtil.getStr(row[12]));
						yusoMaster.setTsumiaicd(StringUtil.getStr(row[13]));

						NFMYGX0100_HimokuBean himoku = new NFMYGX0100_HimokuBean(StringUtil.getStr(row[16]),
								StringUtil.getStr(row[17]), StringUtil.getStr(row[18]), StringUtil.getStr(row[19]));
						yusoMaster.getSojoHimokuDataCOList().add(himoku);
						yusoMasterList.add(yusoMaster);

					}
				}
				seizoshoKbn = StringUtil.getStr(row[0]);
				sojonoShukkoBasho = StringUtil.getStr(row[1]);
				sojonoTorihikiShubetsu = StringUtil.getStr(row[2]);
				sojonoOban = StringUtil.getStr(row[3]);
				sojonoRenban = StringUtil.getStr(row[4]);
				headTeiseiKbn = StringUtil.getStr(row[5]);
				headTeiseiKaisu = StringUtil.getStr(row[6]);
			}
		}
	}
}
