package com.lt.constants;

public class SQLConstantQueries {
	
	public static final String VALIDATE_USER = "SELECT userid, rollid FROM user WHERE username=? AND userpassword=?";

	public static final String FETCH_ADMIN = "SELECT * FROM admin WHERE adminID=?";

	public static final String INSERT_ADMIN = "INSERT INTO admin VALUES (?,?,?,?)";

	public static final String DELETE_ADMIN = "DELETE FROM admin WHERE adminid=?";

	public static final String UPDATE_ADMIN = "UPDATE admin SET name=?,gender=?, phonenumber=? WHERE adminid=?";

	public static final String DISPLAY_ADMINS = "SELECT * FROM admin";

}
