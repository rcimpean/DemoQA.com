package TestSoftvision.DemoQA.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class utilsValues {

	public static InputStream input;
	public static Properties prop;

	public static void getProperties() throws IOException {
		prop = new Properties();
		input = new FileInputStream("Resource/config.properties");
		prop.load(input);

		ConstantProperty.BASE_URL = prop.getProperty("URL");
		ConstantProperty.TEXT_TO_CHECK = prop.getProperty("textToCheck");
	}
}
