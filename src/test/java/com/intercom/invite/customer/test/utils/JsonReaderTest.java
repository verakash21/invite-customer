package com.intercom.invite.customer.test.utils;

import org.junit.Assert;
import org.junit.Test;

import com.intercom.invite.customer.data.CustomerPojo;
import com.intercom.invite.customer.utils.JsonReader;


public class JsonReaderTest {
	private static final String inputJson = "{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}";

	private static final String customerName = "Christina McArdle";
	private static final int customerid = 12;
	private static final double lat = 52.986375;
	private static final double lon = -6.043701;
	
	@Test
	public void testParseCustomerJson() {
		CustomerPojo response = JsonReader.parseCustomerJson(inputJson);
		Assert.assertEquals("Name didn't match in json message.",customerName, response.getUserName());
		Assert.assertEquals("User id didn't match in json message.",customerid, response.getUserId());
		Assert.assertEquals("Latitude didn't match in json message.",lat, response.getLatitude(),0);
		Assert.assertEquals("Longitude didn't match in json message.",lon, response.getLongitude(),0);
	}
	
	@Test
	public void testEmptyInput() {
		CustomerPojo response = JsonReader.parseCustomerJson("");
		Assert.assertNull(response);
	}

	@Test
	public void testNullInput() {
		CustomerPojo response = JsonReader.parseCustomerJson(null);
		Assert.assertNull(response);
	}

	@Test
	public void testInvalidJson() {
		CustomerPojo response = JsonReader.parseCustomerJson("{not a json}");
		Assert.assertNull(response);
	}
	

	@Test
	public void testIncompleteJson() {
		String incompleteJson = "{\"user_id\": 12, \"longitude\": \"-6.043701\"}";
		CustomerPojo response = JsonReader.parseCustomerJson(incompleteJson);
		Assert.assertNull(response);
	}
}
