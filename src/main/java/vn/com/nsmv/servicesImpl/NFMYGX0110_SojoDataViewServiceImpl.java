package vn.com.nsmv.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.nsmv.bean.CommonSojoDataBean;
import vn.com.nsmv.dao.STraYusoDao;
import vn.com.nsmv.services.NFMYGX0110_Services;

@Service
public class NFMYGX0110_SojoDataViewServiceImpl implements NFMYGX0110_Services{
	
	@Autowired
	STraYusoDao yusoTranDao;
	
	/* (non-Javadoc)
	 * @see vn.com.nsmv.services.NFMYGX0110_Services#selectDetailBySojoNo(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<CommonSojoDataBean> selectDetailBySojoNo(String seizosho, String basho, String shubetsu, String oban) throws Exception{
		return yusoTranDao.selectDetailBySojoNo(seizosho, basho, shubetsu, oban);
	}

	/* (non-Javadoc)
	 * @see vn.com.nsmv.services.NFMYGX0110_Services#deleteBySojoNo(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean deleteBySojoNo(String seizosho, String basho, String shubetsu, String oban) throws Exception{
		
		boolean flag = yusoTranDao.selectBySojoNo(seizosho, basho, shubetsu, oban);
		
		if(flag){
			return yusoTranDao.deleteBySojoNo(seizosho, basho, shubetsu, oban);
		}
		
		return false;
	}
	
}
