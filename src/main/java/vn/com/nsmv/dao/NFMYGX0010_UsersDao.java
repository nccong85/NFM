package vn.com.nsmv.dao;

import javax.servlet.http.HttpServletRequest;

import vn.com.nsmv.entities.SMstUserEntity;

public interface NFMYGX0010_UsersDao {
	
	/**
	 * Login
	 * @param user
	 * @param pwd
	 * @return number of record
	 */
	int login(String userId, String pwd);
	
	/** 
	 * GetUserByName
	 * @param userId
	 * @return
	 */
	SMstUserEntity getUserById(String userId);
	
	/**
	 * CheckSessionByUser
	 * @param request
	 * @return boolean
	 */
	boolean checkSessionByUser(HttpServletRequest request);
}