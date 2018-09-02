package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DataFile {
	 Xls_Reader d = new Xls_Reader("C:\\Testing\\NikulTest.xlsx");
	 String correctEmail=(d.getCellData("Data1", "UserName", 2));
	 String inValidEmail=(d.getCellData("Data1", "UserName", 3));
	 String wrongPassword=(d.getCellData("Data1", "Password", 2));
	 String emailError=(d.getCellData("Data1", "Email Error", 2));
	 String passwordError=(d.getCellData("Data1", "Password Error", 2));
	 
	 public String browserName() throws IOException
	 {FileInputStream fs= new FileInputStream("C:\\Testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(fs);
		
String browser= prop.getProperty("browser");
return browser;
	 }
/*public void multipleBrowser(String browser)
{WebDriver driver;
if (browser.equals("firefox")) 
{
	driver= new FirefoxDriver();
}
else if(browser.equals("Chrome"))
{System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
}
else	
	
{System.setProperty("webdriver.ie.driver", "C:\\SeleniumJars\\ie.exe");
driver= new InternetExplorerDriver();
}
}*/


}
