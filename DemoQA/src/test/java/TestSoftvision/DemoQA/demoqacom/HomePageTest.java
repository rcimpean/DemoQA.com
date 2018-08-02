package TestSoftvision.DemoQA.demoqacom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestSoftvision.DemoQA.BaseTest;
import TestSoftvision.DemoQA.Page.HomePage;
import TestSoftvision.DemoQA.Utils.ConstantProperty;
import TestSoftvision.DemoQA.Utils.ConstantSelector;
import TestSoftvision.DemoQA.Utils.WebSelector;

public class HomePageTest extends BaseTest {
	public HomePage homePage;

	@Test
	public void homePageTest() {
		homePage = new HomePage();
		homePage.OpenURL(ConstantProperty.BASE_URL)
				.clickOnElement(ConstantSelector.DEMO_BUTTON_XPATH, WebSelector.XPATH)
				.clickOnElement(ConstantSelector.DEMO_TITLE_XPATH, WebSelector.XPATH)
				.clickOnElement(ConstantSelector.TAB_3_ID, WebSelector.ID);
		WebElement weTabElement = homePage.returnWebElement(ConstantSelector.TAB_3_CONTENT_XPATH, WebSelector.XPATH,
				true);
		assertTrue(weTabElement.getText().contains(ConstantProperty.TEXT_TO_CHECK));
	}
}
