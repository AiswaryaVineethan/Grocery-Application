package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageContactPage;
import utilities.EncryptDecryptUtility;
import utilities.GeneralUtilities;

public class ManageContactTest extends BaseClass{
	LoginPage lp;
	HomePage hp;
	ManageContactPage mc;
	GeneralUtilities gu;
	EncryptDecryptUtility eu = new EncryptDecryptUtility();
	
  @Test(groups = "Smoke")
  public void editContactDetailsAndVerifySuccessAlertMessage() throws IOException, Exception {
		lp = new LoginPage(driver);
		String password = EncryptDecryptUtility.decrypt(groceryApplicationLogin(10,0), "1234567890123456");
		hp = lp.login(super.groceryApplicationLogin(1, 0), password);
		mc = hp.clickOnManageContactMenu();
		mc.editContactUsDetails(groceryApplicationLogin(16,1), groceryApplicationLogin(17,1));
		boolean alertStatus = mc.getSuccessAlertMessage().contains("Contact Updated Successfully");
		Assert.assertEquals(alertStatus, true, Constant.mc_editContactDetailsAndVerifySuccessAlertMessage);
		
  }
}
