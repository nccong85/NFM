package vn.com.nsmv.dao;

import java.util.List;

import vn.com.nsmv.bean.NFMYGX0100_SearchBean;
import vn.com.nsmv.bean.NFMYGX0100_SearchResultBean;

public interface NFMYGX0100_YusohiSearchDao {


	/**
	 * Search data in s_mst_yuso_head , s_mst_yuso_body
	 * 
	 * @return NFMYGX0100_SearchResultBean
	 */
	List<NFMYGX0100_SearchResultBean> selectForSearch(NFMYGX0100_SearchBean searchBean);

	/**
	 * Search data in s_tra_yuso for init
	 * 
	 * @return NFMYGX0100_SearchResultBean
	 */
	List<NFMYGX0100_SearchResultBean> selectForInit(String seizoshoKbn);
}
