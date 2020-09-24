package com.intercom.invite.customer.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map.Entry;
import java.util.logging.Logger;

import java.util.SortedMap;

public final class OutputWriter {
	private OutputWriter(){}
	private static Logger logger = Logger.getLogger(OutputWriter.class.getName());
	
	public static void storeMapToFile(SortedMap<Integer, String> contentMap, String filePath) throws IOException {
        Writer writer = null;
        if (contentMap != null && !contentMap.isEmpty() && filePath != null && !filePath.isEmpty()) {
	        try {
				logger.info("Storing output in file "+ filePath);
	            writer = new FileWriter(filePath);
	            for(Entry<Integer, String> entry : contentMap.entrySet()) {
	            	  writer.write(entry.getKey()+","+entry.getValue() + System.lineSeparator());
	            	}
	        } finally {
	            if (writer != null) {
	                    writer.close();
	            }
	        }
        }
        else {
        	logger.warning("No output stored. Check input data or output file location");
        }
    }
}
