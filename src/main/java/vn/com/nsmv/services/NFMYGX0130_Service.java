package vn.com.nsmv.services;

import java.util.List;

import vn.com.nsmv.bean.CommonSojoDataBean;

public interface NFMYGX0130_Service {

	/**
	 * GetSojoDetailBySojoNo
	 * 
	 * @param branchId
	 * @param basho
	 * @param shubetsu
	 * @param oban
	 * @return list of sojo by sojo number and branchId
	 */
	List<CommonSojoDataBean> selectDetailBySojoNo(String seizosho, String basho, String shubetsu, String oban);

	/**
	 * SaveSojo
	 * 
	 * @param bean
	 * @return boolean
	 * @throws Exception
	 */
	boolean saveSojo(CommonSojoDataBean bean) throws Exception;

	/**
	 * Get bin name.
	 * 
	 * @param binCd
	 * @return bin name
	 */
	String selectBinName(String binCd);
}
