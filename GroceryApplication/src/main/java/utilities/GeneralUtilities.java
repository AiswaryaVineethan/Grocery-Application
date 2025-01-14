package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}
	
	public boolean isSelected(WebElement element) {
		return element.isSelected();
	}
	
	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}

	public void selectValueFromDropdown(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}

	public void selectIndexFromDropdown(WebElement element, int indexNumber) {
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
	}

	public void selectVisibleTextFromDropdown(WebElement element, String text) {
		Select object = new Select(element);
		object.selectByVisibleText(text);
	}
	
	public String getTextFromDowpDown(WebElement element) {
		Select object = new Select(element);
		return object.getFirstSelectedOption().getText();
	}
	
	public void dragAndDropFunction(WebElement sourceElement, WebElement targetElement, WebDriver driver) {
		Actions actObj = new Actions(driver);
		actObj.dragAndDrop(sourceElement, targetElement).perform();
	}
	
	public void fileUploadUsingSendKeysFunction(WebElement element, String path) {
		element.sendKeys(path);
	}
	
	public void fileUploadUsingRobotClassFunction(WebElement element, String path) throws AWTException {
		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);//
		Robot robot = new Robot();
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void doubleClickFunction(WebElement element, WebDriver driver) {
		Actions actObj = new Actions(driver);
		actObj.doubleClick(element).perform();		
	}
	
	public void rightClickFunction(WebElement element, WebDriver driver) {
		Actions actObj = new Actions(driver);
		actObj.contextClick(element).perform();		
	}
	
	public void mouseHoveringFunction(WebElement element, WebDriver driver) {
		Actions actObj = new Actions(driver);
		actObj.moveToElement(element).perform();		
	}
	
	public String getTitleOfPage(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public void alertAcceptFunction(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void alertDismissFunction(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void getAlertTextFunction(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	
	public void switchToFrameByName(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}
	
	public void switchToFrameByWebElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	
	public int selectRowNumberFromDynamicTable(List<WebElement> listOfRow, String value) {
		int row = 0;
		for (int i = 0; i < listOfRow.size(); i++) {
			if (listOfRow.get(i).getText().equals(value)) {
				row = (i+1);
				
				break;
			}
		}
		return row;
	}
	
	public int selectRowFromDynamicTable(List<WebElement> listOfRow, String value) throws Exception {
		int j=0;
		for (int i=0; i< listOfRow.size(); i++) {
			if (listOfRow.get(i).getText().equals(value)) {
				j=i;
				break;
			}
			else if (i==listOfRow.size()) {
				throw new ArithmeticException("value not present");
			}
		}
		return j;
	}

	public void pageScroll(int horizontal, int vertical, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + horizontal + "," + vertical + ")");
	}
	
	public void clickJavaScriptExector(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;//typecasting
		js.executeScript("argument[0].click()", element);
	}
	
	public String getCSSValueOfElement(WebElement element, String parameter) {
		return element.getCssValue(parameter);
	}
	
	public void mediumDelay() throws InterruptedException{
		Thread.sleep(2000);
	}
	
	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}
	public int random(int limit) {
		Random random = new Random();
		// int limit = 1000;
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}

public void sendValueUsingJavaScript(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '" + value + "'", element);
	}

	public void blurThePlaceHolder(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].blur()", element);
	}
	
	public void scrollTestUsingWindowScrollByFunction(WebDriver driver, int hor, int ver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+hor+","+ver+")");
	}
	
	public void scrollTestusingelement(WebDriver driver,WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	

}
