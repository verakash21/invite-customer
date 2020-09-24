package com.intercom.invite.customer.data;

import java.io.Serializable;

public class CustomerPojo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2073741878833868292L;
	private int userId;
	private String userName;
	private double latitude;
	private double longitude;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "customerPojo [userId=" + userId + ", userName=" + userName + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}
}
