package com.pack.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Property {
	@SuppressWarnings("finally")
	public static String getProperty(String args) {
		Properties prop = new Properties();
		try {

			InputStream inputstream;
			Path path = Paths.get(new File("").getAbsolutePath());
			String parent = path.getParent().toString();
			String propFileName = parent+"\\maven_planit\\src\\test\\resources\\config.properties";
			inputstream = new FileInputStream(propFileName);
			prop.load(inputstream);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			return prop.getProperty(args);
		}
	}

}
