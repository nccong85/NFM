package vn.com.nsmv.servicesImpl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.nsmv.dao.NFMYGX0010_UsersDao;
import vn.com.nsmv.entities.SMstUserEntity;
import vn.com.nsmv.services.NFMYGX0010_UserService;

@Service
public class NFMYGX0010_UserServicesImpl implements NFMYGX0010_UserService {

	@Autowired
	NFMYGX0010_UsersDao NFMYGX0010_UsersDao;

	public int login(String userId, String pwd) {
		return NFMYGX0010_UsersDao.login(userId, pwd);
	}

	@Override
	public SMstUserEntity getUserById(String userId) {
		return NFMYGX0010_UsersDao.getUserById(userId);
	}

	@Override
	public boolean checkSessionByUser(HttpServletRequest request) {
		return NFMYGX0010_UsersDao.checkSessionByUser(request);
	}

}
