package Utillies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
	public static WebDriver driver;

private Driver(){}
	public static WebDriver getDriver(){

	if(driver==null) {

			switch (ConfigReader.getProperties("browser")){
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

					break;
				case "safari":
					WebDriverManager.safaridriver().setup();
					driver=new SafariDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				default:
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
			}


		}


		return driver;
	}
	public static void closDriver(){
		if (driver!=null){
			driver.close();
			driver=null;
		}

	}

}
