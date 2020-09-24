package com.intercom.invite.customer.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Logger;

import org.apache.commons.cli.*;

import com.intercom.invite.customer.data.CustomerPojo;
import com.intercom.invite.customer.utils.Constants;
import com.intercom.invite.customer.utils.JsonReader;
import com.intercom.invite.customer.utils.OutputWriter;

public class CustomerList {
	
	private static Logger logger = Logger.getLogger(CustomerList.class.getName());

	public static void main(String[] args) {
		Options options = new Options();

		Option input = new Option("i", "input", true, "input file path");
		input.setRequired(true);
		options.addOption(input);

		Option output = new Option("o", "output", true, "output file");
		output.setRequired(true);
		options.addOption(output);

		CommandLineParser parser = new DefaultParser();
		HelpFormatter formatter = new HelpFormatter();
		CommandLine cmd = null;

		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			logger.severe("Arguments missing. "+ e.getMessage());
			formatter.printHelp("utility-name", options);
			System.exit(1);
		}

		String inputFilePath = cmd.getOptionValue("input");
		String outputFilePath = cmd.getOptionValue("output");

		processCustomerList(inputFilePath, outputFilePath);
		
		logger.info("Execution Finished.");

	}
	
	public static void processCustomerList(String inputFile, String outputFile) {
		BufferedReader reader;
		SortedMap<Integer, String> outputMap = new TreeMap<Integer, String>();
		try {
			logger.info("Processing File "+ inputFile);
			reader = new BufferedReader(new FileReader(inputFile));
			String line = reader.readLine();
			while (line != null) {
				CustomerPojo customerInfo = JsonReader.parseCustomerJson(line);
				if(customerInfo != null) {
					double distance = CalculateDistance.greatCircleDistance(customerInfo.getLatitude(),customerInfo.getLongitude());
					if(distance<=Constants.customer_range) {
						outputMap.put(customerInfo.getUserId(), customerInfo.getUserName());
					}
				}
				// read next line
				line = reader.readLine();
			}
			reader.close();
			OutputWriter.storeMapToFile(outputMap, outputFile);
		} catch (IOException e) {
			logger.severe("Error while handling file. "+ inputFile);
			e.printStackTrace();
		}
	}
}
