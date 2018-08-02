package TestSoftvision.DemoQA.Utils;

import org.openqa.selenium.By;

import TestSoftvision.DemoQA.BasePage;

public class WebSelector {

	public static final String XPATH = "xpath";
	public static final String ID = "id";
	public static final String CSS = "css";
	public static final String CLASS_NAME = "class name";

	private static String selector;

	public static void set(String se) {
		selector = se;

	}

	public static By type(String findBy) {
		try {

			if (findBy.equals(XPATH)) {
				return (By.xpath(selector));
			} else if (findBy.equals(ID)) {
				return (By.id(selector));
			} else if (findBy.equals(CSS)) {
				return (By.cssSelector(selector));
			} else if (findBy.equals(CLASS_NAME)) {
				return (By.className(selector));
			} else {

				throw new NullPointerException();

			}
		} catch (NullPointerException e) {
			System.out.println(e.getClass().getName());
			System.out.println("\t at WebSelector.type locator:" + selector + " findBy " + findBy);
			System.out.println("\t" + e.getStackTrace()[0]);
			System.out.println("\t" + e.getStackTrace()[1]);
			BasePage.tearDown();
			System.exit(1);
		}
		return null;
	}
}
