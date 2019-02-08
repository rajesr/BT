package com.virtusa.bt;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.virtusa.bt.CSVReader;

@RunWith(Parameterized.class)
public class CSVReaderTest {


	  private Integer inputNumber;
	  private String expectedResult;
	  private CSVReader reader;
	  
	  @Before
	  public void initialize() {
		  reader = new CSVReader();
	   }
	  public CSVReaderTest(Integer inputNumber, String expectedResult) {
	      this.inputNumber = inputNumber;
	      this.expectedResult = expectedResult;
	   }
	  
	  @Parameterized.Parameters
	   public static Collection primeNumbers() {
	      return Arrays.asList(new Object[][] {
	         { 1, "1Pankaj KumarDeveloper5000 USD" },
	         { 2, "2ManiProgrammer4000 USD" },
	         { 3, "3AvinashDeveloper5000 USD" },
	         { 4, "4DavidQA Lead4000 USD" }
	      });
	   }
	  
	  @Test
	  public void lineNumberCSVTest() throws Exception {

		 Assert.assertEquals(expectedResult, 
				 reader.readCSV(inputNumber, "ALL"));
	  }
	  
	  @Test
	  public void integerCSVTest() throws Exception {
		  String result = "1234";
		  System.out.println(reader.readCSV(-1, "INTEGER"));
		  Assert.assertEquals(result, 
				 reader.readCSV(-1, "INTEGER"));
	  }
	  
	  @Test
	  public void doubleCSVTest() throws Exception {
		  String expectedResult = "1.02.03.04.0";
		  System.out.println(reader.readCSV(-1, "DOUBLE"));
		 Assert.assertEquals(expectedResult, 
				 reader.readCSV(-1, "DOUBLE"));
	  }

}
