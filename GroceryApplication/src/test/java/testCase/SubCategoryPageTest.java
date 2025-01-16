package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.SubCategoryPage;
import utilities.EncryptDecryptUtility;

public class SubCategoryPageTest extends BaseClass {
	LoginPage lp;// used aggregation
	HomePage hp;//used aggregation
	SubCategoryPage scp;
	EncryptDecryptUtility eu = new EncryptDecryptUtility();

	@Test(priority = 1)
	public void createNewSubcategory() throws Exception {
		lp = new LoginPage(driver);// Calling constructor from LoginPage java class
		String password = EncryptDecryptUtility.decrypt(groceryApplicationLogin(10,0), "1234567890123456");
		hp = lp.login(super.groceryApplicationLogin(1, 0), password);
		scp = hp.clickOnSubCategoryMenu();
		scp.addSubCategory();
		boolean alertStatus = scp.getAlertMessage().contains("Sub Category Created Successfully");
		Assert.assertEquals(alertStatus, true, Constant.scp_createNewSubcategory);
	}
	
	@Test(priority = 2)
	public void editSubCategoryFunction() throws Exception {
		lp = new LoginPage(driver);// Calling constructor from LoginPage java class
		String password = EncryptDecryptUtility.decrypt(groceryApplicationLogin(10,0), "1234567890123456");
		hp = lp.login(super.groceryApplicationLogin(1, 0), password);
		scp = hp.clickOnSubCategoryMenu();
		scp.editSubCategory();
		boolean alertStatus = scp.getAlertMessage().contains("Sub Category Updated Successfully");
		Assert.assertEquals(alertStatus, true, Constant.scp_editSubCategoryFunction);
	}
	
	@Test(priority=3)
	public void searchSubCategoryFunction() throws Exception {
		lp = new LoginPage(driver);// Calling constructor from LoginPage java class
		String password = EncryptDecryptUtility.decrypt(groceryApplicationLogin(10,0), "1234567890123456");
		hp = lp.login(super.groceryApplicationLogin(1, 0), password);
		scp = hp.clickOnSubCategoryMenu();
		String actualResult = scp.searchSubCategory();
	    String expectedResult = "SamsungS24UltraAiswarya";
	    Assert.assertEquals(actualResult, expectedResult, Constant.scp_searchSubCategoryFunction);
		
	}
	
	@Test(priority=4)
	public void deleteSubCategoryFunction() throws Exception {
		lp = new LoginPage(driver);// Calling constructor from LoginPage java class
		String password = EncryptDecryptUtility.decrypt(groceryApplicationLogin(10,0), "1234567890123456");
		hp = lp.login(super.groceryApplicationLogin(1, 0), password);
		scp = hp.clickOnSubCategoryMenu();
		scp.deleteSubCategory();
		boolean subCategoryDeleteAlertMessage = scp.getAlertMessage().contains("Sub Category Deleted Successfully");
		Assert.assertEquals(subCategoryDeleteAlertMessage, true, Constant.scp_deleteSubCategoryFunction);	
		
	}
	
	@Test(priority=5)
	public void changeStatusActiveToInactive() throws Exception {
		lp = new LoginPage(driver);// Calling constructor from LoginPage java class
		String password = EncryptDecryptUtility.decrypt(groceryApplicationLogin(10,0), "1234567890123456");
		hp = lp.login(super.groceryApplicationLogin(1, 0), password);
		scp = hp.clickOnSubCategoryMenu();
		scp.addSubCategory();
		hp.clickOnSubCategoryMenu();
		scp.changeStatus();
		boolean changeStatusAlertMessage = scp.getAlertMessage().contains("Sub Category Status Changed Successfully");
		Assert.assertEquals(changeStatusAlertMessage, true, Constant.scp_changeStatus);
		
	}
	
	@Test(priority=6)
	public void changeStatusInactiveToActive() throws Exception {
		lp = new LoginPage(driver);// Calling constructor from LoginPage java class
		String password = EncryptDecryptUtility.decrypt(groceryApplicationLogin(10,0), "1234567890123456");
		hp = lp.login(super.groceryApplicationLogin(1, 0), password);
		scp.changeStatus();
		boolean changeStatusAlertMessage = scp.getAlertMessage().contains("Sub Category Status Changed Successfully");
		Assert.assertEquals(changeStatusAlertMessage, true, Constant.scp_changeStatus);
		
	}
	
	
}
