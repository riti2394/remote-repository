package selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	/*public WebElement email = driver.findElement(By.xpath(".//*[@id='identifierId']"));
	public WebElement emailNext= driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span"));- we cannot use like this because as soon as object is created it tries to call and it throws null point exception beacuse we havent opened the browser and we are trying to find elemnts so we use page object model*/
	
	
	@FindBy(xpath=".//*[@id='identifierId']")
	public static WebElement email;
	
	@FindBy(name= "password")
	public static WebElement password;
	
	@FindBy(xpath=".//*[@id='identifierNext']/content/span")
	public static WebElement emailNext;
	
	@FindBy(xpath=".//span[@class='RveJvd snByac']")
	public static WebElement passwordNext;
	
	@FindBy(xpath=".//div[@class='LXRPh']/div[2]")
	public static WebElement readEmailError;
	
	@FindBy(xpath="/*[@id='password']/div[2]/div[2]")
	public static WebElement readPasswordError;
	
	public void openBrowser(String browser) throws IOException{
	{
		//driver = new FirefoxDriver();
		 /*{FileInputStream fs= new FileInputStream("C:\\Testing\\prop.properties");
			Properties prop = new Properties();
			prop.load(fs);
			
	String browser= prop.getProperty("browser");*/
	
		 
	
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
	}

		PageFactory.initElements(driver, this);
	}
    
	public void closeBrowser() 
	{ driver.quit();
		
	}
	public void openGmail()
	{
		  driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void enterEmail(String a) throws InterruptedException
	{
		email.sendKeys(a);
		emailNext.click();
		Thread.sleep(4000);
	}
	
	public void enterPassword(String b) throws InterruptedException
	{
		password.sendKeys(b);
		passwordNext.click();
		Thread.sleep(4000);
		  
	}
	public String readEmailError()
	{
		String actualErrMsg = driver.findElement(By.xpath(".//div[@class='LXRPh']/div[2]")).getText();
		return actualErrMsg;
	}
	public String readPasswordError()
	{
		String actualErrMsg = driver.findElement(By.xpath("//*[@id='password']/div[2]/div[2]")).getText();
		return actualErrMsg;
	}
}
