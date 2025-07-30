package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLibrary implements FrameWorkConstant {
	 static FileInputStream fis;
	 static FileOutputStream fos;
	 static Properties property;
	 public static String readData(String key)  {
			// 1.Convert the Extenal File Into Java UnderStandable
		 
		   
		try {
			fis = new FileInputStream(propertypath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		   //2. Crate an object for Properties class
		    property = new Properties();
		   // 3.Load all the Properties
		   try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   //4.Read/Fetch the data
		   
			return property.getProperty(key);
		
	 }
			public static void writeData(String newkey, String newvalue) {

				// 1. Convert the External File into Jva Understandable
				 try {
					fis = new FileInputStream(propertypath);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// 2. Create an object for Properties class
				 property = new Properties();

				// 3. Load all the Properties
				try {
					property.load(fis);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// 4. Put the new dat in properties file
				property.put(newkey, newvalue);

				// 5. Convert the Jva Understandable into External File
				 try {
					fos = new FileOutputStream(propertypath);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// 6. Store the new dat with message
				try {
					property.store(fos, "Update new key");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
}


