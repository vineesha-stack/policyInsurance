package com.policybazaar.secondary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Read_Data {

	public Properties getData()  {

		File file = new File(System.getProperty("user.dir")+"\\data.properties");
		FileInputStream fileInput = null;
		
		try {
		
			fileInput = new FileInputStream(file);
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}

		Properties properties = new Properties();
		
		//load properties file
		try {
			
			properties.load(fileInput);
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return properties;
	}
}