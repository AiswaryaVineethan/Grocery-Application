package elementRepository;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtilities;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class CategoryPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExcelUtilities eu = new ExcelUtilities();
	WaitUtilities wu = new WaitUtilities();

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id = "category")
	WebElement enterCategory;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlertMessage;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement dangerAlertMessage;
	@FindBy(xpath = "//div[@class='ms-selectable']//ul//li//span[text()='discount']")
	WebElement discountGroup;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFileButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement searchButtonCategoryField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButtonInSearchFunction;
	@FindBy(xpath = "//table//tbody//tr[1]//td[1]")
	WebElement firstCategoryName;
	@FindBy(xpath = "//table//tbody//tr//td[1]")
	List<WebElement> categoryTableSize;
	@FindBy(xpath = "//input[@id='category']")
	WebElement editButtonCategoryField;
	@FindBy(xpath = "//button[text()='Update']")
	WebElement editFieldUpdateButton;

	public void createNewCategory(String category) throws AWTException, InterruptedException {
		newButton.click();
		enterCategory.sendKeys(category);
		discountGroup.click();
		gu.scrollTestUsingWindowScrollByFunction(driver, 0, 1500);
		Thread.sleep(2000);
		wu.waitForWebElement(driver, chooseFileButton, "id", "main_img");
		Thread.sleep(2000);
		gu.fileUploadUsingSendKeysFunction(chooseFileButton,
				System.getProperty("user.dir") + "\\src\\main\\resources\\PhoneImage.jpeg");
		saveButton.click();
	}

	public String getSuccessAlertMessage() {
		return successAlertMessage.getText();
	}

	public String getDangerAlertMessage() {
		return dangerAlertMessage.getText();
	}

	public void searchCreatedCategory(String category) {
		searchButton.click();
		searchButtonCategoryField.sendKeys(category);
		searchButtonInSearchFunction.click();
	}

	public String getListCategoryText() {
		return firstCategoryName.getText();
	}

	public void deleteCreatedCategory() {
		String categoryName = "SamSung_S24_Ultra_8281";
		for (int i = 0; i < categoryTableSize.size(); i++) {
			if (categoryTableSize.get(i).getText().equals(categoryName)) {
				String path = "//table//tbody//tr[" + (i + 1) + "]//td[4]//a[2]";
				WebElement element = driver.findElement(By.xpath(path));
				element.click();
				wu.waitForAlertIsPresent(driver, 10);
				gu.alertAcceptFunction(driver);

			}
		}
	}

	public void editCreatedCategory() throws InterruptedException {
		String categoryName = "SamSung_S24_Ultra_8281";
		for (int i = 0; i < categoryTableSize.size(); i++) {
			if (categoryTableSize.get(i).getText().equals(categoryName)) {
				String path = "//table//tbody//tr[" + (i + 1) + "]//td[4]//a[1]";
				WebElement element = driver.findElement(By.xpath(path));
				element.click();
				editButtonCategoryField.sendKeys("_New");
				gu.scrollTestUsingWindowScrollByFunction(driver, 0, 1500);
				Thread.sleep(2000);
				editFieldUpdateButton.click();
			}
		}

	}

}
