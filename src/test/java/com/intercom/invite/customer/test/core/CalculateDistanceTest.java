package com.intercom.invite.customer.test.core;

import org.junit.Assert;
import org.junit.Test;

import com.intercom.invite.customer.core.CalculateDistance;

public class CalculateDistanceTest {

	@Test
	public void testCalculateDistance() {
		double cust_lat = 52.833502;
		double cust_lon = -8.522366;
		double result = 161.36207870697515;
		
		double response = CalculateDistance.greatCircleDistance(cust_lat, cust_lon);
		
		Assert.assertEquals("Distance between the two chosen coordinates didn't match the expected value.",result, response,0);
		
	}
}
