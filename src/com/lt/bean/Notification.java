package com.lt.bean;

public class Notification {
	private long notificationId;
	private boolean notificationStatus;
	private String notificationMesssage;

	public long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(long notificationId) {
		this.notificationId = notificationId;
	}

	public boolean isNotificationStatus() {
		return notificationStatus;
	}

	public void setNotificationStatus(boolean notificationStatus) {
		this.notificationStatus = notificationStatus;
	}

	public String getNotificationMesssage() {
		return notificationMesssage;
	}

	public void setNotificationMesssage(String notificationMesssage) {
		this.notificationMesssage = notificationMesssage;
	}

}
