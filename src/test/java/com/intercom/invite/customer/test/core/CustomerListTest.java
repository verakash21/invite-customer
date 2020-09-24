package com.intercom.invite.customer.test.core;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

import java.util.logging.Logger;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.intercom.invite.customer.core.CalculateDistance;
import com.intercom.invite.customer.core.CustomerList;
import com.intercom.invite.customer.data.CustomerPojo;
import com.intercom.invite.customer.utils.JsonReader;


@RunWith(PowerMockRunner.class)
@PrepareForTest({JsonReader.class,CalculateDistance.class,Logger.class})
public class CustomerListTest {

	private static final String testFileName = "customers.txt";
	private static final String customerName = "Christina McArdle";
	private static final int customerid = 12;
	private static final double lat = 52.986375;
	private static final double lon = -6.043701;
	private static final double dist = 80;
	private static final String inputJson = "{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}";

	@Test
	public void testProcessCustomerList() {
		String filePath = new String("src/test/resources/"+testFileName);
		
		CustomerPojo testCustomer = new CustomerPojo();
		testCustomer.setUserName(customerName);
		testCustomer.setUserId(customerid);
		testCustomer.setLatitude(lat);
		testCustomer.setLongitude(lon);
		
        //given
        PowerMockito.mockStatic(JsonReader.class,CalculateDistance.class);
        when(JsonReader.parseCustomerJson(inputJson)).thenReturn(testCustomer);
        when(CalculateDistance.greatCircleDistance(lat, lon)).thenReturn(dist);

        //when
		CustomerList.processCustomerList(filePath, null);

        //then
        PowerMockito.verifyStatic(JsonReader.class, atLeast(1));
        JsonReader.parseCustomerJson(anyString());
        PowerMockito.verifyStatic(CalculateDistance.class, atLeast(1));
        CalculateDistance.greatCircleDistance(anyDouble(),anyDouble());
	}	
}
