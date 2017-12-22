package vn.com.nsmv.dao;

import java.util.List;

import vn.com.nsmv.bean.NFMYCX0010_YusoTranSearchBean;
import vn.com.nsmv.bean.NFMYGX0100_Bean;
import vn.com.nsmv.bean.CommonSojoDataBean;
import vn.com.nsmv.entities.STraYusoEntity;


/**
 * Yuso transaction dao
 * @author NSMV
 *
 */
public interface STraYusoDao {

	/**
	 * STraYusoDao Class
	 * 
	 * @return
	 */
	List<STraYusoEntity> list();

	/**
	 * @return
	 */
	List<STraYusoEntity> list(NFMYCX0010_YusoTranSearchBean yusoTran);

	/**
	 * @param yusoTran
	 * @return delete status
	 */
	boolean delete(STraYusoEntity yusoTran);

	/**
	 * @param yusoTran
	 * @return update status
	 */
	boolean saveOrUpdate(STraYusoEntity yusoTran);

	/**
	 * Get record count
	 * 
	 * @return
	 */
	int count();

	/** GetSojoDetailBySojoNo
	 * @param branchId
	 * @param basho
	 * @param shubetsu
	 * @param oban
	 * @return list of sojo by sojo number and branchId
	 */
	List<CommonSojoDataBean> selectDetailBySojoNo(String seizosho, String basho, String shubetsu, String oban);
	
	/** DeleteBySojoNo
	 * @param branchId
	 * @param basho
	 * @param shubetsu
	 * @param oban
	 * @return int
	 */
	boolean deleteBySojoNo(String seizosho, String basho, String shubetsu, String oban);
	
	/**
	 * SelectBySojoNo
	 * @param seizosho
	 * @param basho
	 * @param shubetsu
	 * @param oban
	 * @param renban
	 * @return boolean
	 */
	boolean selectBySojoNo(String seizosho, String basho, String shubetsu, String oban);
	
	/**
	 * SaveSojo
	 * @return boolean
	 */
	boolean saveSojo(CommonSojoDataBean bean) throws Exception;
	
}
