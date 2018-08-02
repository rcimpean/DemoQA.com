package TestSoftvision.DemoQA.demoqacom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import TestSoftvision.DemoQA.BaseTest;
import TestSoftvision.DemoQA.Page.HomePage;
import TestSoftvision.DemoQA.Utils.ConstantProperty;
import TestSoftvision.DemoQA.Utils.ConstantSelector;
import TestSoftvision.DemoQA.Utils.WebSelector;

public class HomePageTest extends BaseTest{
	public HomePage homePage;
	
	@Test
	public void homePageTest()
	{
		homePage = new HomePage();
		homePage.OpenURL(ConstantProperty.BASE_URL)
				.waitToLoadElement(ConstantSelector.TABS_ID, WebSelector.ID)
				.clickOnElement(ConstantSelector.DEMO_BUTTON_XPATH, WebSelector.XPATH)
				.waitToLoadElement(ConstantSelector.DEMO_TITLE_XPATH, WebSelector.XPATH)
				.clickOnElement(ConstantSelector.DEMO_TITLE_XPATH, WebSelector.XPATH)
				.waitToLoadElement(ConstantSelector.TAB_3_ID, WebSelector.ID)
				.clickOnElement(ConstantSelector.TAB_3_ID, WebSelector.ID);
		System.err.println(homePage.returnWebElement(ConstantSelector.TAB_3_CONTENT_XPATH, WebSelector.XPATH, true).getText());
		//assertEquals(homePage.returnWebElement(ConstantSelector.TAB_3_XPATH, WebSelector.XPATH, true).getText(),ConstantProperty.TEXT_TO_CHECK);
		assertTrue(homePage.returnWebElement(ConstantSelector.TAB_3_CONTENT_XPATH, WebSelector.XPATH, true).getText().contains(ConstantProperty.TEXT_TO_CHECK));
	}
}
