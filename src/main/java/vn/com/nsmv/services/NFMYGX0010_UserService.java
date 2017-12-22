package vn.com.nsmv.services;

import javax.servlet.http.HttpServletRequest;

import vn.com.nsmv.entities.SMstUserEntity;

public interface NFMYGX0010_UserService {

	/**
	 * Login
	 * @param userId
	 * @param pwd
	 * @return int
	 */
	int login(String userId, String pwd);

	/**
	 * GetUserById 
	 * @param userId
	 * @return user info
	 */
	SMstUserEntity getUserById(String userId);

	/**
	 * CheckSessionByUser
	 * @param request
	 * @return boolean
	 */
	boolean checkSessionByUser(HttpServletRequest request);
}
