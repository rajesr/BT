package com.virtusa.bt;

import java.io.File;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ReadXMLFile {
	ClassLoader classLoader = getClass().getClassLoader();
	StringBuilder builder;
	public static void main(String[] args) {
		String nodeName = "family";
		ReadXMLFile o = new ReadXMLFile();
		o.readXML("",nodeName);
	}

	public String readXML(String xml, String nodeName) {
		builder = new StringBuilder();
		try {
			InputSource is = new InputSource();
		    is.setCharacterStream(new StringReader(xml));

			//File file = new File(classLoader.getResource("employee.xml").getFile());
			//File file = new File("/Users/mkyong/staff.xml");

			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
		                             .newDocumentBuilder();

			
		//	Document doc = dBuilder.parse(file);
			Document doc = dBuilder.parse(is);

			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			if (doc.hasChildNodes()) {

				return printNote(doc.getChildNodes(),nodeName,builder);

			}

		    } catch (Exception e) {
			System.out.println(e.getMessage());
		    }

			return "";
	}
	
	private  String printNote(NodeList nodeList, String nodeName, StringBuilder builder) {

	    for (int count = 0; count < nodeList.getLength(); count++) {

		Node tempNode = nodeList.item(count);

		// make sure it's element node.
		if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
			
			if(tempNode.getNodeName().equals(nodeName) || nodeName.equals("ALL") ) {
			// get node name and value
			//System.out.print("\n"+tempNode.getNodeName()+"="+tempNode.getTextContent() );
			builder.append(""+tempNode.getNodeName()+"="+tempNode.getTextContent()+" " );
			}

			if (tempNode.hasChildNodes()) {

				// loop again if has child nodes
				printNote(tempNode.getChildNodes(), nodeName, builder);

			}

			

		}

	    }
	    return builder.toString();

	  }


}
