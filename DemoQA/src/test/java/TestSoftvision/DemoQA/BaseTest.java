package TestSoftvision.DemoQA;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest extends BasePage {

	@BeforeClass
	public void initialSetUP() {
		initSetUp();
	}

	@AfterClass
	public void tearDownTest() {
		tearDown();
	}
}
