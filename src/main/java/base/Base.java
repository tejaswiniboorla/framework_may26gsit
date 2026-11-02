package base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Base {
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	private static Properties prop;

    static {
        try {
         String path=System.getProperty("user.dir")+"\\src\\main\\java\\data.properties";
            FileInputStream fis = new FileInputStream
            (path);
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Properties not loaded");
        }
    }

    public static String getData(String key) {
        return prop.getProperty(key);
    }
	
    public WebDriver getDriver()
	{
		return driver.get();
	}
public void setDriver(WebDriver driver1)
	{
		 driver.set(driver1);
	
	}

}
