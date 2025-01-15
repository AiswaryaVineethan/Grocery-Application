package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.CategoryPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.GeneralUtilities;

public class CategoryPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	CategoryPage cp;
	GeneralUtilities gu;

	@Test(priority = 1,enabled=true)
	public void addNewCategoryAndVerifySuccessAlert() throws Exception {
		lp = new LoginPage(driver);
		hp = lp.login(super.groceryApplicationLogin(1, 0), super.groceryApplicationLogin(1, 1));
		cp = hp.clickOnCategoryMenu();
		cp.createNewCategory(groceryApplicationLogin(7, 0));
		boolean alertStatus = cp.getSuccessAlertMessage().contains("Category Created Successfully");
		Assert.assertEquals(alertStatus, true, Constant.cp_addNewCategory);
	}

	@Test(priority=2, enabled=true)
  public void createDuplicateCategoryAndVerifyCategoryAlreadyExistAlertMessage() throws Exception {
	  lp = new LoginPage(driver);
		hp =lp.login(super.groceryApplicationLogin(1,0),super.groceryApplicationLogin(1,1));
		cp = hp.clickOnCategoryMenu();
		cp.createNewCategory(groceryApplicationLogin(7,0));
		boolean alertStatus = cp.getDangerAlertMessage().contains("Category already exists");
		Assert.assertEquals(alertStatus, true, Constant.cp_createDuplicateCategoryAndVerifyCategoryAlreadyExistAlertMessage);
		
  }

	@Test(priority=3, enabled=true)
  public void searchingCreatedCategoryAndVerifyListCategory() throws Exception {
    lp = new LoginPage(driver);
	hp =lp.login(super.groceryApplicationLogin(1,0),super.groceryApplicationLogin(1,1));
	cp = hp.clickOnCategoryMenu();
	cp.searchCreatedCategory(groceryApplicationLogin(7,0));
	boolean listCategoryNameStatus = cp.getListCategoryText().contains(groceryApplicationLogin(7,0));
	Assert.assertEquals(listCategoryNameStatus, true, Constant.cp_searchingCreatedCategoryAndVerifyListCategory);	
	}
	
	@Test(priority=4, enabled=true)
	  public void deletingCreatedCategoryAndVerifyDeleteAlertMessage() throws Exception {
	    lp = new LoginPage(driver);
		hp =lp.login(super.groceryApplicationLogin(1,0),super.groceryApplicationLogin(1,1));
		cp = hp.clickOnCategoryMenu();
		cp.deleteCreatedCategory();
		boolean alertStatus = cp.getSuccessAlertMessage().contains("Category Deleted Successfully");
		Assert.assertEquals(alertStatus,true,Constant.cp_deletingCreatedCategoryAndVerifyDeleteAlertMessage);
	}
	
	@Test(priority=5, enabled=true)
	  public void editingCreatedCategoryAndVerifyUpdatedSuccessfullyAlert() throws Exception {
		lp = new LoginPage(driver);
		hp =lp.login(super.groceryApplicationLogin(1,0),super.groceryApplicationLogin(1,1));
		cp = hp.clickOnCategoryMenu();
		cp.createNewCategory(groceryApplicationLogin(7,0));
		hp.clickOnCategoryMenu();
		cp.editCreatedCategory();
		boolean alertStatus = cp.getSuccessAlertMessage().contains("Category Updated Successfully");
		Assert.assertEquals(alertStatus,true,Constant.cp_editingCreatedCategoryAndVerifyUpdatedSuccessfullyAlert);
		
	}

}
