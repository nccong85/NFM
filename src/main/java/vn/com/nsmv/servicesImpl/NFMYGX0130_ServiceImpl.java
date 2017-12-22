package vn.com.nsmv.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.nsmv.bean.CommonSojoDataBean;
import vn.com.nsmv.dao.NFMYCX0020_CommonDao;
import vn.com.nsmv.dao.STraYusoDao;
import vn.com.nsmv.services.NFMYGX0130_Service;

@Service
public class NFMYGX0130_ServiceImpl implements NFMYGX0130_Service {

	@Autowired
	STraYusoDao yusoTranDao;

	@Autowired
	NFMYCX0020_CommonDao nfmycx0020CommonDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.com.nsmv.services.NFMYGX0130_Service#saveSojo(vn.com.nsmv.bean.
	 * CommonSojoDataBean)
	 */
	@Override
	public boolean saveSojo(CommonSojoDataBean bean) throws Exception {
		return yusoTranDao.saveSojo(bean);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.com.nsmv.services.NFMYGX0130_Service#selectDetailBySojoNo(java.lang.
	 * String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<CommonSojoDataBean> selectDetailBySojoNo(String seizosho, String basho, String shubetsu, String oban) {
		return yusoTranDao.selectDetailBySojoNo(seizosho, basho, shubetsu, oban);
	}

	/* (non-Javadoc)
	 * @see vn.com.nsmv.services.NFMYGX0130_Service#selectBinName(java.lang.String)
	 */
	@Override
	public String selectBinName(String binCd) {
		return nfmycx0020CommonDao.selectBinName(binCd);
	}

}
