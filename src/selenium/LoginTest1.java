package selenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest1 {

	 WebDriver driver;
	 LoginPage lp= new LoginPage();
	 DataFile df = new DataFile();
	 
	// String correctEmail=(d.getCellData("Data1", "UserName", 2));
	// String inValidEmail=(d.getCellData("Data1", "UserName", 3));
	 //String wrongPassword=(d.getCellData("Data1", "Password", 2));
	// String emailError=(d.getCellData("Data1", "Email Error", 2));
	// String passwordError=(d.getCellData("Data1", "Password Error", 2));
	
	 @BeforeMethod
	  public void beforeMethod() throws IOException 
	  
	  {lp.openBrowser(df.browserName());
	  lp.openGmail();
		  
	  }
	  @AfterMethod
	  public void afterMethod()
	  {lp.closeBrowser();
		  
	  }
	  
	  @Test
	  public void testLoginWithWrongPassword() throws InterruptedException
{     lp.enterEmail(df.correctEmail);
      lp.enterPassword(df.wrongPassword);
     Assert.assertEquals(df.passwordError,lp.readPasswordError() ); 
     lp.readPasswordError();
}
	  @Test
	  public void testLoginWithWrongEmail() throws InterruptedException
	  {lp.enterEmail(df.inValidEmail);
	  Assert.assertEquals(df.emailError,lp.readEmailError() );    
	  }
}


