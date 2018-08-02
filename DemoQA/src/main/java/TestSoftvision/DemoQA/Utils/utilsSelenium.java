package TestSoftvision.DemoQA.Utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestSoftvision.DemoQA.BasePage;


public class utilsSelenium extends BasePage{

	
	/**
	 * Navigate o a specified url
	 * 
	 * @param URL - string represent the url
	 */
	public static void openURL(String url)
	{
		driver.navigate().to(url);
	}
	
	/**
	 * Wait for an web element to be loaded on the from doom
	 * 
	 * @param locator - css, xpath, className or cssSelector that define the element
	 * @param findBy  - ConstantName element that match the locator type
	 */
	public static void waitForWebElement(String locator, String findBy) {
		WebSelector.set(locator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(WebSelector.type(findBy)));
	}
	
	public static WebElement findWebElement(String locator, String selectorType, Boolean mandatory)
	{
		WebElement element = null;
		WebSelector.set(locator);
		try {
			waitForWebElement(locator,selectorType);
			element = driver.findElement(WebSelector.type(selectorType));
		} catch (org.openqa.selenium.NoSuchElementException ex) {
			if (mandatory) {
				System.err.println("Mandatory element not found!");
				System.err.println(
						"\t at findWebElement locator:" + locator + " findBy " + selectorType + " mandatory " + mandatory);
				System.err.println(ex.getClass().getName());
				// ex.printStackTrace();
				BasePage.tearDown();
				System.exit(1);
			} else {
				System.err.println(String.format("Element not found but is not mandatory %s", ex.getClass().getName()));
				System.err.println(
						"\t at findWebElement locator:" + locator + " findBy " + selectorType + " mandatory " + mandatory);
			}
		}
		return element;
	}
	/**
	 * Try insert text in the input field
	 * 
	 * @param locator - css, xpath, className or cssSelector that define the element
	 * @param findBy  - ConstantName element that match the locator type
	 * @param toSend  - string that represent the text that you want to insert in
	 *                the field
	 */
	public static void sendKeys(String locator, String findBy, String toSend) {
		try {
			WebElement toClick = findWebElement(locator, findBy, true);
			toClick.sendKeys(toSend);
		} catch (Exception e) {
			System.err.println("Send Keys error at locator: " + locator + " find by " + findBy);
		}
	}

	public static void executeJavaScript(String script, Object... argument) {
		((JavascriptExecutor) driver).executeScript(script, argument);
	}

	/**
	 * Try to scroll to an web element
	 * 
	 * @param locator - css, xpath, className or cssSelector that define the element
	 * @param findBy  - ConstantName element that match the locator type
	 *
	 */
	public static void scrollToElement(String locator, String findBy) {
		try {
			WebElement element = findWebElement(locator, findBy, true);
			executeJavaScript("arguments[0].scrollIntoView(true);", element);

		} catch (Exception e) {
			System.out.println("Could not scrol to specified element");
		}
		// return element;
	}

	/**
	 * Try to scroll to an web element
	 * 
	 * @param locator - css, xpath, className or cssSelector that define the element
	 * @param findBy  - ConstantName element that match the locator type
	 * @param result  - boolean value that indicate if you want to recive the
	 *                element or not
	 *
	 * @return web element or null
	 */
	public static WebElement scrollToElement(String locator, String findBy, Boolean result)
			throws NullPointerException {
		WebElement element = null;
		try {
			element = findWebElement(locator, findBy, true);
			executeJavaScript("arguments[0].scrollIntoView(true);", element);
			if (result == true) {
				return element;
			} else
				throw new NullPointerException();
		} catch (NullPointerException e) {
			System.out.println("Element uas not returned");
			return null;
		}

	}

	/**
	 * Check if the web element is displayed or not
	 *
	 * @param locator - string expression that represent the element in DOM
	 * @param findBy  - string that represent the search mechanism : id, xpath,
	 *                className, cssSelector
	 *
	 * @return true if element is displayed or false if element is not displayed
	 */
	public static Boolean isVisible(String locator, String findBy) {
		try {

			WebElement element = findWebElement(locator, findBy, true);
			if (element != null && element.isDisplayed()) {
				return true;
			} else
				throw new org.openqa.selenium.NoSuchElementException("");

		} catch (org.openqa.selenium.NoSuchElementException ex) {
			return false;
		}
	}

	/**
	 * Check if the web element is visible on screen or not
	 *
	 * @param locator - string expression that represent the element in DOM
	 * @param findBy  - string that represent the search mechanism : id, xpath,
	 *                className, cssSelector
	 *
	 * @return true if element is visible on screen or false if element is not
	 *         visible
	 */
	public static Boolean isVisibleOnScreen(String locator, String findBy) {
		try {
			WebElement element = findWebElement(locator, findBy, true);
			Dimension elementDimension = element.getSize();
			Point elementLocation = element.getLocation();
			Dimension driverDimension = driver.manage().window().getSize();

			int elementCoordX = elementDimension.getWidth() + elementLocation.getX();
			int elementCoordY = elementDimension.getHeight() + elementLocation.getY();

			return ((elementCoordX <= driverDimension.getWidth()) && (elementCoordY <= driverDimension.getHeight()));
		} catch (Exception e) {
			return false;
		}
	}


	/**
	 * Try clear the field and insert text in the input field
	 * 
	 * @param locator   - css, xpath, className or cssSelector that define the
	 *                  element
	 * @param findBy    - ConstantName element that match the locator type
	 * @param textToSet - string that represent the text that you want to insert in
	 *                  the field
	 */
	public static void setValue(String locator, String findBy, String textToSet) {
		try {
			WebElement toClick = findWebElement(locator, findBy, true);
			toClick.clear();
			toClick.sendKeys(textToSet);
		} catch (Exception e) {
			System.err.println("Send Keys error at locator: " + locator + " find by " + findBy);
		}
	}
	/**
	 * Try to click on a web element
	 * 
	 * @param locator - css, xpath, className or cssSelector that define the element
	 * @param findBy  - ConstantName element that match the locator type
	 *
	 */
	public static void clickWebElement(String locator, String findBy) {
		try {
			WebElement toClick = findWebElement(locator, findBy, true);
			if (isVisibleOnScreen(locator, findBy)) {
				toClick.click();
			} else {
				scrollToElement(locator, findBy);
				toClick.click();
			}

		} catch (Exception e) {
			System.err.println("Click error at clickWebElement, locator: " + locator + " find by " + findBy);
		}
	}
}
