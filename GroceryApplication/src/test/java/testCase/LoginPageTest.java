package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class LoginPageTest extends BaseClass {//Inheritance
	LoginPage lp;//used aggregation
	HomePage hp;//used aggregation
	
  @Test(enabled=true)
  public void loginWithValidCredential() throws IOException, Exception {
	  lp = new LoginPage(driver);//Calling constructor from LoginPage java class
	  //hp = new HomePage(driver);//constructor need to be called first
	  hp = lp.login(groceryApplicationLogin(1,0),groceryApplicationLogin(1,1));
	  String actual = hp.getHomePageHeading();
	  String expected = "7rmart supermarket";
	  Assert.assertEquals(actual, expected, Constant.lp_loginWithValidCredential);//using hard assertion to compare the actual and expected values
	  
  }
  
  @Test(dataProvider="data-provider", enabled=false)
  public void loginWithInvalidCredential(String username, String password) throws Exception {
	  lp = new LoginPage(driver);//Calling constructor from LoginPage java class
	  hp= lp.login(username,password);
	  String actual=lp.AlertMessage();
	  String expected = "Alert!";
	  Assert.assertEquals(actual, expected, Constant.lp_loginWithInvalidCredential);

  }
  
	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() throws IOException {
		return new Object[][] {{groceryApplicationLogin(2,0), groceryApplicationLogin(2,1)},
			{groceryApplicationLogin(3,0), groceryApplicationLogin(3,1)},
			{groceryApplicationLogin(4,0), groceryApplicationLogin(4,1)}};
	}
  
  
}
