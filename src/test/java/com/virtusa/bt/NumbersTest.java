package com.virtusa.bt;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.virtusa.bt.Numbers;

@RunWith(Parameterized.class)
public class NumbersTest {

	  private Integer inputNumber;
	  private String expectedResult;
	  private Numbers number;
	  
	  @Before
	   public void initialize() {
		  number = new Numbers();
	   }
	  public NumbersTest(Integer inputNumber, String expectedResult) {
	      this.inputNumber = inputNumber;
	      this.expectedResult = expectedResult;
	   }
	  
	  @Parameterized.Parameters
	   public static Collection primeNumbers() {
	      return Arrays.asList(new Object[][] {
	         { 65, "sixty-five" },
	         { 872, "eight hundred seventy-two" },
	         { 999999999, "nine hundred ninety-nine million, nine hundred ninety-nine thousand, nine hundred ninety-nine" },
	         { 3, "three" },
	         { 12, "twelve" }
	      });
	   }
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void negativNumberTest() throws Exception {
		
	      Assert.assertEquals(expectedResult, 
	    		  number.english_number(-12));
			
	}
	
	@Test
	public void englishNumberTest() throws Exception {
		System.out.println("Parameterized Number is : " + inputNumber);
	      Assert.assertEquals(expectedResult, 
	    		  number.english_number(inputNumber));
			
	}
	
}
