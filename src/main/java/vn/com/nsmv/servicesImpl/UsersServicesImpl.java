package vn.com.nsmv.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.nsmv.bean.NFMYGX0400_UserSearchConditionBean;
import vn.com.nsmv.dao.UsersDao;
import vn.com.nsmv.entities.Users;
import vn.com.nsmv.services.UsersServices;

@Service
public class UsersServicesImpl implements UsersServices {

	@Autowired
	UsersDao userDao;

	public List<Users> list() {
		// TODO Auto-generated method stub
		return userDao.list();
	}

	public boolean delete(Users users) {
		// TODO Auto-generated method stub
		return userDao.delete(users);
	}

	public boolean saveOrUpdate(Users users) {
		// TODO Auto-generated method stub
		return userDao.saveOrUpdate(users);
	}

	public List<Users> listAll(Integer offset, Integer maxResults, String sortName, String sortOrder) {
		// TODO Auto-generated method stub
		return userDao.listAll(offset, maxResults, sortName, sortOrder);
	}

	public Long count() {
		// TODO Auto-generated method stub
		return userDao.count();
	}

	public List<Users> search(NFMYGX0400_UserSearchConditionBean searchInfoBean) {
		// TODO Auto-generated method stub
		
		return userDao.searchUsers(searchInfoBean);
	}

	public Long count(NFMYGX0400_UserSearchConditionBean searchInfoBean) {
		// TODO Auto-generated method stub
		return userDao.countByQuery(searchInfoBean);
	}

}

