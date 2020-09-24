package com.intercom.invite.customer.core;

import com.intercom.invite.customer.utils.Constants;

public final class CalculateDistance {
	private CalculateDistance() {};

	/**
	 * Calculates distance in KM between given longitude and latitude against the company location stored on constant.
	 * @param cust_lat
	 * @param cust_lon
	 * @return
	 */
	public static double greatCircleDistance(double cust_lat, double cust_lon) {
		// convert degrees to radians. 
		double lon1 = Math.toRadians(cust_lon);
		double lat1 = Math.toRadians(cust_lat);
		double lon2 = Math.toRadians(Constants.host_longtitude);
		double lat2 = Math.toRadians(Constants.host_latitude);

		double dlon = lon2 - lon1;
		double c = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(dlon));

		// Radius of earth in kilometers.
		double r = 6371;
		// calculate the result 
		return (c * r);
	}

}
