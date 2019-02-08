package com.virtusa.bt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.virtusa.bt.ReadXMLFile;

public class ReadXMLFileTest {
	
	  private ReadXMLFile reader;
	  
	  @Before
	  public void initialize() {
		  reader = new ReadXMLFile();
	   }

	@Test
	public void testXMLReader1() {
		String xml = "<person>user1</person>";
		
		String expected = "person=user1 ";
		Assert.assertEquals(expected,reader.readXML(xml, "ALL"));
	}
	

	@Test
	public void testXMLReader2() {
		String xml = "<person><first_name>usr1Fname </first_name><last_name>usr1Lname</last_name>"+
					"<address><line_1>U1l1</line_1><line_2>U1l2</line_2><line_3>U1l3</line_3></address>"+
					"</person>";


		String expected = "person=usr1Fname usr1LnameU1l1U1l2U1l3 first_name=usr1Fname  last_name=usr1Lname address=U1l1U1l2U1l3 line_1=U1l1 line_2=U1l2 line_3=U1l3 ";
		Assert.assertEquals(expected,reader.readXML(xml, "ALL"));
	}
	
	@Test
	public void testXMLReader3() {
		String xml = "<person><first_name>usr1Fname </first_name><last_name>usr1Lname</last_name></person>";
		
		String expected = "person=usr1Fname usr1Lname first_name=usr1Fname  last_name=usr1Lname ";
		Assert.assertEquals(expected,reader.readXML(xml, "ALL"));
	}
	
	
	@Test
	public void testXMLReader4() {
		String xml = "<person><first_name>usr1Fname </first_name><last_name>usr1Lname</last_name><address><line_1>U1l1</line_1>"+
					 "<line_2>U1l2</line_2><line_3>U1l3</line_3></address><family><person><first_name>usr2Fname </first_name>"+
			         "<last_name>usr2Lname</last_name><address><line_1>U2l1</line_1><line_2>U2l2</line_2><line_3>U2l2</line_3>"+
			         "</address></person></family></person>";
		
		String expected = "person=usr1Fname usr1LnameU1l1U1l2U1l3usr2Fname usr2LnameU2l1U2l2U2l2 first_name=usr1Fname  last_name=usr1Lname "
							+"address=U1l1U1l2U1l3 line_1=U1l1 line_2=U1l2 line_3=U1l3 family=usr2Fname usr2LnameU2l1U2l2U2l2 person=usr2Fname usr2LnameU2l1U2l2U2l2 "
							+ "first_name=usr2Fname  last_name=usr2Lname address=U2l1U2l2U2l2 line_1=U2l1 line_2=U2l2 line_3=U2l2 ";
		Assert.assertEquals(expected,reader.readXML(xml, "ALL"));
	}

}
