package com.ajackus.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ajackus.page.PropertyCapsulePage;

@Listeners(value=com.ajackus.test.AjackusReporter.class)
public class PropertyCapsuleTC01Test {

	static WebDriver driver;
	static PropertyCapsulePage propertyPage;
	static String url = "https://dev.maps.propertycapsule.com/map";

	@BeforeTest
	public static void testSetup() {
		System.setProperty("webdriver.chrome.driver", "C:/Automation/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}

	@Test(alwaysRun = true)
	public static void testSignUp() {
		propertyPage = new PropertyCapsulePage(driver);
		PropertyCapsulePage.clicknSignUpink();
	}

	@Test(dependsOnMethods = "testSignUp")
	public static void testWaitForSignUpPage() {
		PropertyCapsulePage.waitForSignUpPage();
	}

	@Parameters({ "userName", "userEmail", "userPassword" })
	@Test(dependsOnMethods = "testWaitForSignUpPage")
	public static void enterDetails(String userName, String userEmail, String userPassword) {
		PropertyCapsulePage.enterDetails(userName, userEmail, userPassword);
	}

	@Test(dependsOnMethods = "enterDetails")
	public static void testWaitForUserPage() {
		PropertyCapsulePage.waitForUserPage();
		PropertyCapsulePage.clickOnUserIcon();
		PropertyCapsulePage.closeBroser();
	}
}
