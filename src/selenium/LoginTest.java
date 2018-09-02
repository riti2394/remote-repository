package selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class LoginTest {
 
 WebDriver driver;

  @BeforeMethod
  public void beforeMethod() {
	  
	  driver= new FirefoxDriver();
	  driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }
  //@Test
  public void testLoginWithWrongPassword() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys("riti.rajput");
		driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@type='password']")).sendKeys("hsjdhqajash");
		driver.findElement(By.xpath(".//span[@class='RveJvd snByac']")).click();
	
		
		String actualErrMsg = driver.findElement(By.xpath("//*[@id='password']/div[2]/div[2]")).getText();
		
		System.out.println(actualErrMsg);
		
		String expectedErrMsg="Wrong password. Try again or click Forgot password to reset it.";
		
		if (actualErrMsg.endsWith(expectedErrMsg))
{System.out.println("test passed");

}
else
{System.out.println("test failed");
	}

  }
  @Test
  public void testLoginWithWrongEmail()
  {
	  driver.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys("jkasjjahd");
	  driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
	  
		String actualErrMsg = driver.findElement(By.xpath(".//div[@class='LXRPh']/div[2]")).getText();
		String expectedErrMsg="Couldn't find your Google Account";
		
		Assert.assertEquals(actualErrMsg,expectedErrMsg );
		
}
}
