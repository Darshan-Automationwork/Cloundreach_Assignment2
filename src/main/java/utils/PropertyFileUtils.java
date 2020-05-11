package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileUtils {
	  //Constants
	  private static final String USER_DIR = System.getProperty("user.dir");
	  private static final String PROPERTY_FOLDER_LOCATION = USER_DIR + "/Resources/";


	  /**
	    * This method fetches the value from Property file
	    * @param fileName-Name         of the propertyFile
	    * @param propertyName-property name
	    * @return-Property value in String Format
	    */
	   public String getPropertyValue(String fileName, String propertyName) {
	       String value = "";
	       if (!fileName.contains(".properties")) {
	           fileName = fileName + ".properties";
	       }
	       InputStream input = null;
	       try
	       {
	        input=new FileInputStream(PROPERTY_FOLDER_LOCATION + fileName);
	           Properties prop = new Properties();
	           prop.load(input);
	           value = prop.getProperty(propertyName);
	       } catch (IOException ex) {
	         System.out.println("The" + fileName + "is not present in the " + PROPERTY_FOLDER_LOCATION);
	       }
	       finally {
	if(input!=null)
	{
	try {
	input.close();
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}
	}
	       return value;
	   }
	 
	 
}
