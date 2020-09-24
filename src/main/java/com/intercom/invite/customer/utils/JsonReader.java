package com.intercom.invite.customer.utils;

import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import com.intercom.invite.customer.data.CustomerPojo;

public final class JsonReader {

	private JsonReader() {}
	private static Logger logger = Logger.getLogger(JsonReader.class.getName());
	/**
	 * Parses the json string to store customer details such as user id, name, latitude and longitude into a POJO object.
	 * @param jsonString
	 * @return
	 */
	public static CustomerPojo parseCustomerJson(String jsonString) {
		CustomerPojo customerDetails = null;
		try {
			if(jsonString != null && !jsonString.isEmpty()) {
				final JSONObject customerObj = new JSONObject(jsonString);
				customerDetails = new CustomerPojo();
				customerDetails.setUserId(customerObj.getInt(Constants.cust_userId));
				customerDetails.setUserName(customerObj.getString(Constants.cust_name));
				customerDetails.setLatitude(customerObj.getDouble(Constants.cust_latitude));
				customerDetails.setLongitude(customerObj.getDouble(Constants.cust_longitude));
			}
		}catch(JSONException e){
			logger.warning("Exception while parsing json message "+jsonString);
			//Change customerDetails to null if info is incomplete.
			customerDetails = null;
			e.printStackTrace();						
		}
		return customerDetails;
	}
}
