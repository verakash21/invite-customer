package com.intercom.invite.customer.test.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.intercom.invite.customer.utils.OutputWriter;

public class OutputWriterTest {


    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();
    
    @Test
	public void testStoreMapToFile() throws IOException {
		SortedMap<Integer, String> outputMap = new TreeMap<Integer, String>();
		outputMap.put(1, "testString");
		File output = temporaryFolder.newFolder("reports")
                .toPath()
                .resolve("output.txt")
                .toFile();
		OutputWriter.storeMapToFile(outputMap, output.getPath());
		List<String> lines = Files.readAllLines(Paths.get(output.getPath()));
		Assert.assertEquals(1, lines.size());
		Assert.assertEquals("1,testString", lines.get(0));
	}
    
    @Test(expected = IOException.class)
  	public void testStoreMapToFileInvalidFileLocation() throws IOException {
  		SortedMap<Integer, String> outputMap = new TreeMap<Integer, String>();
  		outputMap.put(1, "testString");
  		OutputWriter.storeMapToFile(outputMap, "abc/pqr.txt");
  	}

}
