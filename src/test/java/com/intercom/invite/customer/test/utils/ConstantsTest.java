package com.intercom.invite.customer.test.utils;

import org.junit.Assert;
import org.junit.Test;

import com.intercom.invite.customer.utils.Constants;

public class ConstantsTest {
	//Customer List json constants
	public static final String cust_userId = "user_id";
	public static final String cust_name = "name";
	public static final String cust_latitude = "latitude";
	public static final String cust_longitude = "longitude";
	
	//Companies Geo Location
	public static final double host_latitude = 53.339428;
	public static final double host_longtitude = -6.257664;
	
	//Customer Distance range
	public static final double customer_range = 100;
	
	@Test
	public void testJsonObjectNames() {
		Assert.assertEquals("Json key user_id mismatch in constants.",cust_userId, Constants.cust_userId);
		Assert.assertEquals("Json key name mismatch in constants.",cust_name, Constants.cust_name);
		Assert.assertEquals("Json key latitude mismatch in constants.",cust_latitude, Constants.cust_latitude);
		Assert.assertEquals("Json key longitude mismatch in constants.",cust_longitude, Constants.cust_longitude);
	}

	@Test
	public void testCompanyGeoLocation() {
		Assert.assertEquals("Latitude value mismatch in constants.",host_latitude, Constants.host_latitude,0);
		Assert.assertEquals("longitude value mismatch in constants.",host_longtitude, Constants.host_longtitude,0);
	}

	@Test
	public void testRangeLimit() {
		Assert.assertEquals("Distance range mismatch in constants.",customer_range, Constants.customer_range,0);
	}
}
