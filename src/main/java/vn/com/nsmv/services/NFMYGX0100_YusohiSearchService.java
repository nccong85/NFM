package vn.com.nsmv.services;

import java.util.List;

import vn.com.nsmv.bean.NFMYGX0100_SearchBean;
import vn.com.nsmv.bean.NFMYGX0100_SearchResultBean;

public interface NFMYGX0100_YusohiSearchService {
	
	/**
	 * Get data in s_tra_yuso for init page
	 * @param seizoshoKbn
	 * @return
	 */
	public List<NFMYGX0100_SearchResultBean> init(String seizoshoKbn);

	/**
	 * Search data in s_tra_yuso
	 * @param searchBean
	 * @return
	 */
	public List<NFMYGX0100_SearchResultBean> search(NFMYGX0100_SearchBean searchBean);
}
