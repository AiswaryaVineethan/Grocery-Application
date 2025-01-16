package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtilities;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class SubCategoryPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExcelUtilities eu = new ExcelUtilities();
	WaitUtilities wu = new WaitUtilities();
	
	
	public SubCategoryPage(WebDriver driver) {//creating constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);//page object model with pagefactory, to use @findby notation
	}
	

	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath="//select[@id='cat_id']")
	WebElement categorySelectField;
	@FindBy(xpath="//input[@id='subcategory']")
	WebElement subCategoryField;
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	@FindBy(xpath="//table//tbody//tr[1]//td[1]")
	WebElement firstSubCategoryName;
	@FindBy(xpath="//table//tbody//tr[1]//td[2]")
	WebElement firstCategoryName;
	@FindBy(xpath="//table//tbody//tr//td[1]")
	List<WebElement> subCategoryTableSize;
	@FindBy(xpath="//table//tbody//tr[10]//td[5]//a[2]")
	WebElement firstSubCategoryDeleteButton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath="//select[@id='un']")
	WebElement serachButtonCategoryField;
	@FindBy(xpath="//input[@class='form-control']")
	WebElement serachButtonSubCategoryField;
	@FindBy(xpath="//button[text()='Search']")
	WebElement searchButtonSearchField;
	@FindBy(xpath="//table//tbody//tr[1]//td[5]//a[1]")
	WebElement firstsubCategoryEditButton;
	@FindBy(xpath="//select[@id='cat_id']")
	WebElement editButtonCategoryField;
	@FindBy(xpath="//input[@id='subcategory']")
	WebElement editButtonSubCategoryField;
	@FindBy(xpath="//button[text()='Update']")
	WebElement editUpdateButton;
	
	
	
	public void addSubCategory() {
		newButton.click();
		gu.isEnabled(categorySelectField);
		gu.selectVisibleTextFromDropdown(categorySelectField, "phone");
		gu.isEnabled(subCategoryField);
		subCategoryField.sendKeys("SamsungS24Ultra"+ gu.generateCurrentDateAndTime());
		gu.isDisplayed(saveButton);
		saveButton.click();
	}
	
	public String getAlertMessage() {
		return alertMessage.getText();
	}
	
	public void editTheFirstListedSubCategory() {
		String nameOfSubCategory = firstSubCategoryName.getText();
		for (int i=0; i<subCategoryTableSize.size(); i++) {
			if (subCategoryTableSize.get(i).getText().equals(nameOfSubCategory)) {
				String path = "//table//tbody//tr["+(i+1)+"]//td[5]//a[1]";
				WebElement element = driver.findElement(By.xpath(path));
				element.click();
				gu.selectVisibleTextFromDropdown(editButtonCategoryField, "phone");
				editButtonSubCategoryField.clear();
				editButtonSubCategoryField.sendKeys("SamsungS24UltraAiswarya");
				editUpdateButton.click();
			}
		}
	}
	
	public String searchSubCategory() {
		searchButton.click();
		gu.selectVisibleTextFromDropdown(serachButtonCategoryField, "phone");
		String searchItem = "SamsungS24UltraAiswarya";
		serachButtonSubCategoryField.sendKeys(searchItem);
		searchButtonSearchField.click();
		return firstSubCategoryName.getText();
	}
	
	public void deleteTheFirstListedSubCategory() {
		String nameOfSubCategory = firstSubCategoryName.getText();
		for (int i=0; i<subCategoryTableSize.size(); i++) {	
			if (subCategoryTableSize.get(i).getText().equals(nameOfSubCategory)) {
				String path = "//table//tbody//tr["+(i+1)+"]//td[5]//a[2]";
				WebElement element = driver.findElement(By.xpath(path));
				element.click();
				wu.waitForAlertIsPresent(driver, 10);
				gu.alertAcceptFunction(driver);
				
			}
		}
	}
	
	public void changeStatusOfTheFirstListedSubCategory() {
		String nameOfSubCategory = firstSubCategoryName.getText();
		for (int i=0; i<subCategoryTableSize.size(); i++) {
			if (subCategoryTableSize.get(i).getText().equals(nameOfSubCategory)) {
				String path = "//table//tbody//tr["+(i+1)+"]//td[4]//a//span[contains(@class,'badge bg')]";
				WebElement element = driver.findElement(By.xpath(path));
				String initialStatus = element.getText();
				element.click();
			}
		}
	}
	
	



}
