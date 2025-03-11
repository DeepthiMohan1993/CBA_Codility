package com.cba.petstore.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataReader {

	public static Properties LoadPropertiesfile() {
		Properties prop = new Properties();
		try {
			String path = System.getProperty("user.dir");
			FileInputStream fis = new FileInputStream(
					path+"/src/test/java/com/cba/petstore/test/resources/API.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	
}
