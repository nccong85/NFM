package vn.com.nsmv.servicesImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.nsmv.bean.NFMYGX0140_Bean;
import vn.com.nsmv.common.BusinessConst;
import vn.com.nsmv.common.MessageIdConst;
import vn.com.nsmv.dao.NFMYCX0020_CommonDao;
import vn.com.nsmv.dao.SMstYusoBodyDao;
import vn.com.nsmv.dao.SMstYusoHeadDao;
import vn.com.nsmv.entities.SMstYusoBodyEntity;
import vn.com.nsmv.entities.SMstYusoHeadEntity;
import vn.com.nsmv.services.NFMYGX0140_YusohiUpdateService;

/**
 * @author TayLQ create at October 10, 2016
 */
@Service
public class NFMYGX0140_YusohiUpdateServiceImpl implements NFMYGX0140_YusohiUpdateService {

	private static final Logger logger = Logger.getLogger(NFMYGX0140_YusohiUpdateServiceImpl.class);

	@Autowired
	SMstYusoHeadDao yusoMstHead;
	@Autowired
	SMstYusoBodyDao yusoMstBody;
	@Autowired
	NFMYCX0020_CommonDao nfmycx0020CommonDao;

	/* (non-Javadoc)
	 * @see vn.com.nsmv.services.NFMYGX0140_YusohiUpdateService#selectHeadAnBody(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)
	 */
	@Override
	public NFMYGX0140_Bean selectHeadAndBody(String seizoshoKbn, String sojoNoBasho, String sojoNoShubetsu,
			String sojoNoOban, int renban) {
		return yusoMstHead.selectHeadAnBody(seizoshoKbn, sojoNoBasho, sojoNoShubetsu, sojoNoOban, renban);
	}

	/* (non-Javadoc)
	 * @see vn.com.nsmv.services.NFMYGX0140_YusohiUpdateService#saveOnHead(vn.com.nsmv.bean.NFMYGX0140_Bean)
	 */
	@Override
	public void saveOnHead(NFMYGX0140_Bean bean) {
		
		try {
			SMstYusoHeadEntity entity = selectHeadEntity(bean);
			
			entity.setKeirekiFlg(BusinessConst.CodeDef.NumberValue.ONE);
			yusoMstHead.updateByPrimaryKey(entity);
			
			entity.setHeadTeiseiKbn(BusinessConst.CodeDef.HeadTeiseiKbn.C);
			entity.setKeirekiFlg(BusinessConst.CodeDef.NumberValue.ONE);
			entity.setJuryo(entity.getJuryo()* BusinessConst.CodeDef.NumberValue.MINUS_ONE);
			entity.setKihonYusoKyori(entity.getKihonYusoKyori()* BusinessConst.CodeDef.NumberValue.MINUS_ONE);
			yusoMstHead.updateByPrimaryKey(entity);
			
			entity.setHeadTeiseiKbn(BusinessConst.CodeDef.HeadTeiseiKbn.T);
			entity.setKeirekiFlg(BusinessConst.CodeDef.NumberValue.ZERO);
			int headTeiseiKaisu = entity.getHeadTeiseiKaisu() + 1;
			entity.setHeadTeiseiKaisu(headTeiseiKaisu);
			entity.setBinCd(bean.getBinCd());
			entity.setJuryo(bean.getJuryo());
			entity.setKihonYusoKyori(bean.getKihonYusoKyori());
			
			yusoMstHead.updateByPrimaryKey(entity);
			
			// update on body table
			saveOnBody(bean, headTeiseiKaisu);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
	}

	/* (non-Javadoc)
	 * @see vn.com.nsmv.services.NFMYGX0140_YusohiUpdateService#saveOnBody(vn.com.nsmv.bean.NFMYGX0140_Bean, int)
	 */
	@Override
	public void saveOnBody(NFMYGX0140_Bean bean, int headTeiseiKbn){		
		
		// check action
		if(bean.getAction().equals(MessageIdConst.NFMYGX0140_ACT_UPDATE)){
			SMstYusoBodyEntity entity = selectBodyEntity(bean);
			// hidden record
			entity.setKeirekiFlg(BusinessConst.CodeDef.NumberValue.ONE);
			yusoMstBody.updateByPrimaryKey(entity);
			
			// if change value on head table
			if(headTeiseiKbn>0){
				entity.setHeadTeiseiKbn(BusinessConst.CodeDef.HeadTeiseiKbn.C);
			}else{
				entity.setBodyTeiseiKbn(BusinessConst.CodeDef.BodyTeiseiKbn.C);
			}
			entity.setKeirekiFlg(BusinessConst.CodeDef.NumberValue.ONE);
			entity.setUchiwakeBaseJuryo(entity.getUchiwakeBaseJuryo()* BusinessConst.CodeDef.NumberValue.MINUS_ONE);
			entity.setUchiwakeBaseKingaku(entity.getUchiwakeBaseKingaku()* BusinessConst.CodeDef.NumberValue.MINUS_ONE);
			entity.setUchiwakeKutonJuryo(entity.getUchiwakeKutonJuryo()* BusinessConst.CodeDef.NumberValue.MINUS_ONE);
			entity.setUchiwakeKutonKingaku(entity.getUchiwakeKutonKingaku()* BusinessConst.CodeDef.NumberValue.MINUS_ONE);
			entity.setUchiwakeChojakuJuryo(entity.getUchiwakeChojakuJuryo()* BusinessConst.CodeDef.NumberValue.MINUS_ONE);
			entity.setUchiwakeChojakuKingaku(entity.getUchiwakeChojakuKingaku()* BusinessConst.CodeDef.NumberValue.MINUS_ONE);
			entity.setUchiwakeJikangaiJuryo(entity.getUchiwakeJikangaiJuryo()* BusinessConst.CodeDef.NumberValue.MINUS_ONE);
			entity.setUchiwakeJikangaiKingaku(entity.getUchiwakeJikangaiKingaku()* BusinessConst.CodeDef.NumberValue.MINUS_ONE);
			entity.setUchiwakeSonotaJuryo(entity.getUchiwakeSonotaJuryo()* BusinessConst.CodeDef.NumberValue.MINUS_ONE);
			entity.setUchiwakeSonotaKingaku(entity.getUchiwakeSonotaKingaku()* BusinessConst.CodeDef.NumberValue.MINUS_ONE);
			entity.setKingaku(entity.getKingaku()* BusinessConst.CodeDef.NumberValue.MINUS_ONE);
			entity.setDaisu(entity.getDaisu()* BusinessConst.CodeDef.NumberValue.MINUS_ONE);
			entity.setTanka(entity.getTanka()* BusinessConst.CodeDef.NumberValue.MINUS_ONE);
			yusoMstBody.updateByPrimaryKey(entity);
			
			// add new record 
			entity.setKeirekiFlg(BusinessConst.CodeDef.NumberValue.ZERO);
			entity.setBodyTeiseiKbn(BusinessConst.CodeDef.BodyTeiseiKbn.T);
			// if change value on head table
			if(headTeiseiKbn>0){
				entity.setHeadTeiseiKaisu(bean.getHeadTeiseiKaisu()+1);
			}else{
				entity.setHeadTeiseiKaisu(bean.getHeadTeiseiKaisu());
			}
			entity.setBodyTeiseiKaisu(entity.getBodyTeiseiKaisu() + 1);
			entity.setHeadTeiseiKbn(bean.getHeadTeiseiKbn());
			entity.setTsumikomiMinato(bean.getTsumikomiMinato());
			entity.setAgeMinato(bean.getAgeMinato());
			entity.setDaisu(bean.getDaisu());
			entity.setTsumiaiCd(bean.getTsumiaiCd());
			entity.setGyoshaCd(bean.getGyoshaCd());
			entity.setHimokuCd(bean.getHimokuCd());
			entity.setTanka(bean.getTanka());
			entity.setTankaTani(bean.getTankaTani());
			entity.setSeikyuNengetsu(bean.getSeikyuNengetsu());
			entity.setUchiwakeBaseJuryo(bean.getUchiwakeBaseJuryo());
			entity.setUchiwakeBaseKingaku(bean.getUchiwakeBaseKingaku());
			entity.setUchiwakeKutonJuryo(bean.getUchiwakeKutonJuryo());
			entity.setUchiwakeKutonKingaku(bean.getUchiwakeKutonKingaku());
			entity.setUchiwakeChojakuJuryo(bean.getUchiwakeChoJakuJuryo());
			entity.setUchiwakeChojakuKingaku(bean.getUchiwakeChojakuKingaku());
			entity.setUchiwakeJikangaiJuryo(bean.getUchiwakeJikangaiJuryo());
			entity.setUchiwakeJikangaiKingaku(bean.getUchiwakeJikagaiKingaku());
			entity.setUchiwakeSonotaJuryo(bean.getUchiwakeSonotaJuryo());
			entity.setUchiwakeSonotaKingaku(bean.getUchiwakeSonotaKingaku());
			entity.setKingaku(bean.getUchiwakeBaseKingaku()+bean.getUchiwakeKutonKingaku()+bean.getUchiwakeChojakuKingaku()
			+bean.getUchiwakeJikagaiKingaku()+bean.getUchiwakeSonotaKingaku());
			entity.setBodyTeiseiRiyu(bean.getTeiseiRiyu());
			yusoMstBody.updateByPrimaryKey(entity);
		
		}else if(bean.getAction().equals(MessageIdConst.NFMYGX0140_ACT_ADD)){
			SMstYusoBodyEntity entity = new SMstYusoBodyEntity();
			
			entity.setSeizoshoKbn(bean.getSeizoshoKbn());
			entity.setSojonoShukkoBasho(bean.getSojoNoBasho());
			entity.setSojonoTorihikiShubetsu(bean.getSojoNoShubetsu());
			entity.setSojonoOban(bean.getSojoNoOban());
			entity.setSojonoRenban(bean.getSojoNoRenban());
			entity.setBodyTeiseiKbn(BusinessConst.CodeDef.BodyTeiseiKbn.S);
			entity.setBodyTeiseiKaisu(bean.getBodyTeiseiKaisu());
			entity.setHeadTeiseiKbn(bean.getHeadTeiseiKbn());
			entity.setHeadTeiseiKaisu(bean.getHeadTeiseiKaisu());
			entity.setHimokuCd(bean.getHimokuCd());
			entity.setSeikyuNengetsu(bean.getSeikyuNengetsu());
			entity.setKeirekiFlg(BusinessConst.CodeDef.NumberValue.ZERO);
			entity.setTsumikomiMinato(bean.getTsumikomiMinato());
			entity.setAgeMinato(bean.getAgeMinato());
			entity.setDaisu(bean.getDaisu());
			entity.setTsumiaiCd(bean.getTsumiaiCd());
			entity.setGyoshaCd(bean.getGyoshaCd());
			entity.setTanka(bean.getTanka());
			entity.setTankaTani(bean.getTankaTani());
			entity.setUchiwakeBaseJuryo(bean.getUchiwakeBaseJuryo());
			entity.setUchiwakeBaseKingaku(bean.getUchiwakeBaseKingaku());
			entity.setUchiwakeKutonJuryo(bean.getUchiwakeKutonJuryo());
			entity.setUchiwakeKutonKingaku(bean.getUchiwakeKutonKingaku());
			entity.setUchiwakeChojakuJuryo(bean.getUchiwakeChoJakuJuryo());
			entity.setUchiwakeChojakuKingaku(bean.getUchiwakeChojakuKingaku());
			entity.setUchiwakeJikangaiJuryo(bean.getUchiwakeJikangaiJuryo());
			entity.setUchiwakeJikangaiKingaku(bean.getUchiwakeJikagaiKingaku());
			entity.setUchiwakeSonotaJuryo(bean.getUchiwakeSonotaJuryo());
			entity.setUchiwakeSonotaKingaku(bean.getUchiwakeSonotaKingaku());
			entity.setKingaku(bean.getUchiwakeBaseKingaku()+bean.getUchiwakeKutonKingaku()+bean.getUchiwakeChojakuKingaku()
			+bean.getUchiwakeJikagaiKingaku()+bean.getUchiwakeSonotaKingaku());
			entity.setBodyTeiseiRiyu(bean.getTeiseiRiyu());
			yusoMstBody.updateByPrimaryKey(entity);
				
		}
	}
		
	/* (non-Javadoc)
	 * @see vn.com.nsmv.services.NFMYGX0140_YusohiUpdateService#selectHeadEntiy(vn.com.nsmv.bean.NFMYGX0140_Bean)
	 */
	@Override
	public SMstYusoHeadEntity selectHeadEntity(NFMYGX0140_Bean bean){		
		return yusoMstHead.selectHeadEntity(bean);
	}

	/* (non-Javadoc)
	 * @see vn.com.nsmv.services.NFMYGX0140_YusohiUpdateService#selectBodyEntiy(vn.com.nsmv.bean.NFMYGX0140_Bean)
	 */
	@Override
	public SMstYusoBodyEntity selectBodyEntity(NFMYGX0140_Bean bean){
		return yusoMstBody.selectBodyEntity(bean);
	}

	@Override
	public boolean checkHimokuCdExist(NFMYGX0140_Bean bean) {
		return yusoMstBody.checkHimokuCdExist(bean);
	}

	@Override
	public boolean disableHimokuCd(NFMYGX0140_Bean bean) {
		SMstYusoBodyEntity entity = selectBodyEntity(bean);
		entity.setKeirekiFlg(BusinessConst.CodeDef.NumberValue.ONE);
		
		return yusoMstBody.updateByPrimaryKey(entity);
	}

	@Override
	public String selectBinName(String binCd) {
		return nfmycx0020CommonDao.selectBinName(binCd);
	}

	@Override
	public String selectGyoshaName(String gyoshaCd) {
		return nfmycx0020CommonDao.selectGyoshaName(gyoshaCd);
	}

	@Override
	public String selectHimokuName(String himokuCd) {
		return nfmycx0020CommonDao.selectHimokuName(himokuCd);
	}
}