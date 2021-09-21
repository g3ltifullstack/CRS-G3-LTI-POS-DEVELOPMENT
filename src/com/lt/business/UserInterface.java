package com.lt.business;

import com.lt.bean.Admin;

import com.lt.bean.User;

public interface UserInterface {
	/**
	 * 
	 * @param userID
	 * @param newPassword
	 * @return
	 */
	public User validateUser(String username, String password);

	/**
	 * @param adminId
	 * @return
	 */
	public Admin fetchAdmin(int adminId);

	/**
	 * Display Admins
	 */
	public void displayAdmins();

	/**
	 * Login 
	 */
	public void login();

}
