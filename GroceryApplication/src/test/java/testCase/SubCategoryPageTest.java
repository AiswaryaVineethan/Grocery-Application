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

	@Test(priority = 1,groups = "Smoke")
	public void createNewSubCategoryAndVerifySuccessAlert() throws Exception {
		lp = new LoginPage(driver);// Calling constructor from LoginPage java class
		String password = EncryptDecryptUtility.decrypt(groceryApplicationLogin(10,0), "1234567890123456");
		hp = lp.login(super.groceryApplicationLogin(1, 0), password);
		scp = hp.clickOnSubCategoryMenu();
		scp.addSubCategory();
		boolean alertStatus = scp.getAlertMessage().contains("Sub Category Created Successfully");
		Assert.assertEquals(alertStatus, true, Constant.scp_createNewSubcategory);
	}
	
	@Test(priority = 2,groups = "Smoke")
	public void editSubCategoryAndVerifySubCategoryUpdateAlert() throws Exception {
		lp = new LoginPage(driver);// Calling constructor from LoginPage java class
		String password = EncryptDecryptUtility.decrypt(groceryApplicationLogin(10,0), "1234567890123456");
		hp = lp.login(super.groceryApplicationLogin(1, 0), password);
		scp = hp.clickOnSubCategoryMenu();
		scp.editTheFirstListedSubCategory();
		boolean alertStatus = scp.getAlertMessage().contains("Sub Category Updated Successfully");
		Assert.assertEquals(alertStatus, true, Constant.scp_editSubCategoryFunction);
	}
	
	@Test(priority=3,groups = "Smoke")
	public void searchSubCategoryAndVerifyWithReadingListedSubCategory() throws Exception {
		lp = new LoginPage(driver);// Calling constructor from LoginPage java class
		String password = EncryptDecryptUtility.decrypt(groceryApplicationLogin(10,0), "1234567890123456");
		hp = lp.login(super.groceryApplicationLogin(1, 0), password);
		scp = hp.clickOnSubCategoryMenu();
		String actualResult = scp.searchSubCategory();
	    String expectedResult = "SamsungS24UltraAiswarya";
	    Assert.assertEquals(actualResult, expectedResult, Constant.scp_searchSubCategoryFunction);
		
	}
	
	@Test(priority=4,groups = "Smoke")
	public void deleteSubCategoryAndVerifyDeleteSuccessAlert() throws Exception {
		lp = new LoginPage(driver);// Calling constructor from LoginPage java class
		String password = EncryptDecryptUtility.decrypt(groceryApplicationLogin(10,0), "1234567890123456");
		hp = lp.login(super.groceryApplicationLogin(1, 0), password);
		scp = hp.clickOnSubCategoryMenu();
		scp.deleteTheFirstListedSubCategory();
		boolean subCategoryDeleteAlertMessage = scp.getAlertMessage().contains("Sub Category Deleted Successfully");
		Assert.assertEquals(subCategoryDeleteAlertMessage, true, Constant.scp_deleteSubCategoryFunction);	
		
	}
	
	@Test(priority=5,groups = "Smoke")
	public void changeStatusActiveToInactiveAndVerifyStatusChangeAlertMessage() throws Exception {
		lp = new LoginPage(driver);// Calling constructor from LoginPage java class
		String password = EncryptDecryptUtility.decrypt(groceryApplicationLogin(10,0), "1234567890123456");
		hp = lp.login(super.groceryApplicationLogin(1, 0), password);
		scp = hp.clickOnSubCategoryMenu();
		scp.addSubCategory();
		hp.clickOnSubCategoryMenu();
		scp.changeStatusOfTheFirstListedSubCategory();
		boolean changeStatusAlertMessage = scp.getAlertMessage().contains("Sub Category Status Changed Successfully");
		Assert.assertEquals(changeStatusAlertMessage, true, Constant.scp_changeStatus);
		
	}
	
	@Test(priority=6,groups = "Smoke")
	public void changeStatusInactiveToActiveAndVerifyStatusChangeAlertMessage() throws Exception {
		lp = new LoginPage(driver);// Calling constructor from LoginPage java class
		String password = EncryptDecryptUtility.decrypt(groceryApplicationLogin(10,0), "1234567890123456");
		hp = lp.login(super.groceryApplicationLogin(1, 0), password);
		scp.changeStatusOfTheFirstListedSubCategory();
		boolean changeStatusAlertMessage = scp.getAlertMessage().contains("Sub Category Status Changed Successfully");
		Assert.assertEquals(changeStatusAlertMessage, true, Constant.scp_changeStatus);
		
	}
	
	
}
