package TestSoftvision.DemoQA.Page;

import org.openqa.selenium.WebElement;

import TestSoftvision.DemoQA.BasePage;
import TestSoftvision.DemoQA.Utils.utilsSelenium;

public class HomePage extends BasePage {

	public HomePage OpenURL(String str)
	{
		utilsSelenium.openURL(str);
		return this;
	}
	
	public HomePage waitToLoadElement(String selector, String selectorType)
	{
		utilsSelenium.waitForWebElement(selector, selectorType);
		return this;
	}
	
	public HomePage clickOnElement(String selector, String selectorType)
	{
		utilsSelenium.waitForWebElement(selector, selectorType);
		utilsSelenium.clickWebElement(selector, selectorType);
		return this;
	}
	
	public WebElement returnWebElement(String selector, String selectorType, boolean mandatory) {
		return utilsSelenium.findWebElement(selector, selectorType, mandatory);
	}
	
}
