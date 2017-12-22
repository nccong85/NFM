package vn.com.nsmv.services;

import java.util.List;

import vn.com.nsmv.bean.CommonSojoDataBean;

public interface NFMYGX0110_Services {

	/**
	 * SelectDetailBySojoNo
	 * @param seizosho
	 * @param basho
	 * @param shubetsu
	 * @param oban
	 * @return list of sojo
	 * @throws Exception
	 */
	List<CommonSojoDataBean> selectDetailBySojoNo(String seizosho, String basho, String shubetsu, String oban)throws Exception;
	
	/**
	 * DeleteBySojoNo
	 * @param seizosho
	 * @param basho
	 * @param shubetsu
	 * @param oban
	 * @return boolean
	 * @throws Exception
	 */
	boolean deleteBySojoNo(String seizosho, String basho, String shubetsu, String oban) throws Exception;
	
}
