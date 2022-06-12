package Utillies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static Properties propertie;

	static {
		String yol="src/configReader.properties";
		try {
			FileInputStream fis=new FileInputStream(yol);

			propertie=new Properties();
			propertie.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

		}


	}
	public static String getProperties(String key){

		return propertie.getProperty(key);
	}

}
