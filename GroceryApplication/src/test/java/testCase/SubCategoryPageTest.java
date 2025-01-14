package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.SubCategoryPage;

public class SubCategoryPageTest extends BaseClass {
	LoginPage lp;// used aggregation
	HomePage hp;//used aggregation
	SubCategoryPage scp;

	@Test(priority = 1)
	public void createNewSubcategory() throws IOException {
		lp = new LoginPage(driver);// Calling constructor from LoginPage java class
		hp=lp.login(super.groceryApplicationLogin(1,0),super.groceryApplicationLogin(1,1));
		scp = hp.clickOnSubCategoryMenu();
		scp.addSubCategory();
		boolean alertStatus = scp.getAlertMessage().contains("Sub Category Created Successfully");
		Assert.assertEquals(alertStatus, true, Constant.scp_createNewSubcategory);
	}
	
	@Test(priority = 2)
	public void editSubCategoryFunction() throws IOException {
		lp = new LoginPage(driver);// Calling constructor from LoginPage java class
		hp=lp.login(super.groceryApplicationLogin(1,0),super.groceryApplicationLogin(1,1));
		scp = hp.clickOnSubCategoryMenu();
		scp.editSubCategory();
		boolean alertStatus = scp.getAlertMessage().contains("Sub Category Updated Successfully");
		Assert.assertEquals(alertStatus, true, Constant.scp_editSubCategoryFunction);
	}
	
	@Test(priority=3)
	public void searchSubCategoryFunction() throws IOException {
		lp = new LoginPage(driver);// Calling constructor from LoginPage java class
		hp=lp.login(super.groceryApplicationLogin(1,0),super.groceryApplicationLogin(1,1));;
		scp = hp.clickOnSubCategoryMenu();
		String actualResult = scp.searchSubCategory();
	    String expectedResult = "SamsungS24UltraAiswarya";
	    Assert.assertEquals(actualResult, expectedResult, Constant.scp_searchSubCategoryFunction);
		
	}
	
	@Test(priority=4)
	public void deleteSubCategoryFunction() throws IOException {
		lp = new LoginPage(driver);// Calling constructor from LoginPage java class
		hp=lp.login(super.groceryApplicationLogin(1,0),super.groceryApplicationLogin(1,1));;
		scp = hp.clickOnSubCategoryMenu();
		scp.deleteSubCategory();
		boolean subCategoryDeleteAlertMessage = scp.getAlertMessage().contains("Sub Category Deleted Successfully");
		Assert.assertEquals(subCategoryDeleteAlertMessage, true, Constant.scp_deleteSubCategoryFunction);	
		
	}
	
	@Test(priority=5)
	public void changeStatusActiveToInactive() throws IOException {
		lp = new LoginPage(driver);// Calling constructor from LoginPage java class
		hp=lp.login(super.groceryApplicationLogin(1,0),super.groceryApplicationLogin(1,1));;
		scp = hp.clickOnSubCategoryMenu();
		scp.addSubCategory();
		hp.clickOnSubCategoryMenu();
		scp.changeStatus();
		boolean changeStatusAlertMessage = scp.getAlertMessage().contains("Sub Category Status Changed Successfully");
		Assert.assertEquals(changeStatusAlertMessage, true, Constant.scp_changeStatus);
		
	}
	
	@Test(priority=6)
	public void changeStatusInactiveToActive() throws IOException {
		lp = new LoginPage(driver);// Calling constructor from LoginPage java class
		hp=lp.login(super.groceryApplicationLogin(1,0),super.groceryApplicationLogin(1,1));
		scp.changeStatus();
		boolean changeStatusAlertMessage = scp.getAlertMessage().contains("Sub Category Status Changed Successfully");
		Assert.assertEquals(changeStatusAlertMessage, true, Constant.scp_changeStatus);
		
	}
	
	
}
