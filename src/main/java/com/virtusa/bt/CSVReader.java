package com.virtusa.bt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class CSVReader {

	ClassLoader classLoader = getClass().getClassLoader();

	
	public static void main(String[] args) throws IOException {
		// open file input stream
		CSVReader csv = new CSVReader();
		csv.readCSV(Integer.valueOf(args[0]),args[1]);
		
		//System.out.println(Double.valueOf("0.456"));
		//System.out.println(Integer.valueOf("456"));
	}
	
	public String readCSV(int readLine,String type) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				classLoader.getResource("employee.csv").getFile()));

		StringBuilder sb =  new StringBuilder();
		// read file line by line
		String line = null;
		Scanner scanner = null;
		int nline = 0;
		int index = 0;

		while ((line = reader.readLine()) != null) {
			nline++;
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			if (nline == readLine || readLine == -1) {
				while (scanner.hasNext()) {
					boolean flag = false;
					String data = scanner.next();
					if(type.equals("INTEGER")) {
						flag = isInteger(data);
					}
					if(type.equals("DOUBLE")) {
						flag = isDouble(data);
						data = (flag==true)?Double.valueOf(data).toString():data;
					} 
					if (type.equals("ALL")) {
						flag = true;
					}
					
					if(flag) {
					sb.append(data);
					}
					index++;
				}
			}
			index = 0;

		}
		
		//close reader
		reader.close();
		return sb.toString();
	}
	
	public static boolean isInteger(String s) {
		try {
			Integer.valueOf(s);
			return true;
		} catch (NumberFormatException ne) {
			return false;
		}
	}

	public static boolean isDouble(String s) {
		try {
			Double.valueOf(s);
			return true;
		} catch (NumberFormatException ne) {
			return false;
		}
	}

		

}
