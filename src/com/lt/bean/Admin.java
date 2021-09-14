package com.lt.bean;

public class Admin extends User {
	private int adminId;
	private String name;
	private String gender;
	private long phoneNumber;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Admin(int adminId, String name, String gender, long phoneNumber) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
	}

	public Admin() {
		super();
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", gender=" + gender + ", phoneNumber=" + phoneNumber
				+ "]";
	}

}
