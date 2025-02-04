package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtilities;
import utilities.FakerUtility;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageContactPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExcelUtilities eu = new ExcelUtilities();
	WaitUtilities wu = new WaitUtilities();
	FakerUtility fu = new FakerUtility();
	
	
	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table/tbody//tr//td[6]//a")
	WebElement editButton;
	@FindBy(xpath="//input[@id='phone']")
	WebElement phoneFiled;
	@FindBy(xpath="//input[@id='email']")
	WebElement emailFiled;
	@FindBy(xpath="//textarea[@name='address']")
	WebElement addressFiled;
	@FindBy(xpath="//textarea[@name='del_time']")
	WebElement deliveryTimeFiled;
	@FindBy(xpath="//input[@id='del_limit']")
	WebElement deliveryChargeLimitFiled;
	@FindBy(xpath="//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlertMessage;
	
	public static String groceryApplicationLogin(int row, int col) throws IOException {
		String data = ExcelUtilities.readExcelData(row, col,
				System.getProperty("user.dir") + "\\src\\main\\resources\\Excel\\GroceryApplicationData.xlsx",
				"sheet1");
		return data;
	}
	
	public void editContactUsDetails(String deliveryTime,String deliveryChargeLimit) throws InterruptedException {
		Thread.sleep(2000);
		//gu.clickJavaScriptExector(editButton, driver);
		editButton.click();
		Thread.sleep(2000);
		String phonenum = fu.generateRandomDigits(10);
		phoneFiled.clear();
		phoneFiled.sendKeys(phonenum);
		String email = fu.generateEmail();
		emailFiled.clear();
		emailFiled.sendKeys(email);
		String address=fu.generateAddress();
		addressFiled.clear();
		addressFiled.sendKeys(address);		
		deliveryTimeFiled.clear();
		deliveryTimeFiled.sendKeys(deliveryTime);
		deliveryChargeLimitFiled.clear();
		deliveryChargeLimitFiled.sendKeys(deliveryChargeLimit);
		gu.scrollTestUsingWindowScrollByFunction(driver, 0, 1500);
		Thread.sleep(2000);
		updateButton.click();		
		
	}
	
	public String getSuccessAlertMessage() {
		return successAlertMessage.getText();
	}
	

}
