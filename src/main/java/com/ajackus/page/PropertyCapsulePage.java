package com.ajackus.page;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

public class PropertyCapsulePage {

	// Page object  SignUp_TC_01
	static WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	static WebElement signup;

	@FindBy(xpath = "//div[@class='form-field-signup col-xs-12 col-sm-12']/input[1]")
	static WebElement name;

	@FindBy(xpath = "//input[@type='email']")
	static WebElement email;

	@FindBy(css = "input[type='password']")
	static WebElement password;

	@FindBy(xpath = "//div[@class='col-xs-12 text-center']/button[@class='btn register-btn']")
	static WebElement signUpBtn;

	@FindBy(id = "pac-input")
	static WebElement searchBox;

	@FindBy(id = "maps-header")
	static WebElement userloginHeader;

	@FindBy(xpath = "//div[@class='user-area logged-in']")
	static WebElement userIcon;

	@FindBy(xpath = "//div[@class='drop-down-row text-center logout-row']")
	static WebElement logout;

	// Page object SignUp_TC_02

	@FindBy(xpath = "//label[@class='field-label field-label-error']")
	static WebElement nameError;

	// TC_04
	@FindBy(xpath = "//input[@type='email']/preceding-sibling::label")
	static WebElement emailError;

	// TC_05
	@FindBy(xpath = "//input[@type='password']/preceding-sibling::label")
	static WebElement passError;

	@FindBy(xpath = "//div[@class='sign-up-content']/i") ////div[@class='sign-up-content']/i
	static WebElement closeIcon;

	// TC 10_11
	@FindBy(partialLinkText = "Terms of Service")
	static WebElement termAndServices;

	@FindBy(xpath = "//div[@class='terms-header']")
	static WebElement termAndServicesHeader;

	@FindBy(xpath = "//div[@class='terms-content']")
	static WebElement termAndServicesWindow;

	@FindBy(xpath = "//div[@class='terms-content']/i")
	static WebElement termAndServicesCloseIcon;

	@FindBy(xpath = "//a[@class='sign-in-link']")
	static WebElement loginlink;

	@FindBy(xpath = "//div[@class='sign-in-content']/i")
	static WebElement loginCloseIcon;

	static LinkedList<String> list;
	static LinkedHashMap<Integer, String> map;
	static int i = 1;

	// SignUp_TC_01
	public PropertyCapsulePage(WebDriver driver) {
		PropertyCapsulePage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void clicknSignUpink() {
		signup.click();
	}

	public static void waitForSignUpPage() {
		name.isDisplayed();
		email.isDisplayed();
		password.isDisplayed();
	}

	public static void enterDetails(String userName, String userEmail, String userPassword) {
		name.sendKeys(userName);
		email.sendKeys(userEmail);
		password.sendKeys(userPassword);
		signUpBtn.click();
	}

	public static void waitForUserPage() {
		searchBox.isDisplayed();
		userloginHeader.isDisplayed();
	}

	public static void clickOnUserIcon() {
		userIcon.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logout.isDisplayed();
		logout.click();
	}

	public static void closeBroser() {
		driver.quit();
	}

	// SignUp_TC_02

	public static void verifySignUpPageWithoutText() {
		List<WebElement> ele = driver.findElements(By.xpath("//label[@class='field-label field-label-error']"));
		int size = ele.size();
		System.out.println("size is " + size);
		for (WebElement e : ele) {
			System.out.println(e.getText());
		}
		if (size != 3) {
			System.out.println("size is " + size);
			Assert.assertFalse(false, "Error message should get displayed");
		}

	}

	public static void clickOnSignUpBtnOfSignUpPage() {
		signUpBtn.click();
	}

	// SignUp_TC_03
	public static void enterName(String usernme) {
		name.sendKeys(usernme);
	}

	public static void verifyNameErrorMsg() {
		System.out.println("Name error" + nameError.getText());
		String nameErr = nameError.getText();
		if (!nameErr.equalsIgnoreCase("Full Name Required")) {
			Assert.assertFalse(false, "Error message should be matched");
		}
	}

	// SignUp_TC_04

	public static void enterInvalidEmail(String invalidEmail) {
		email.sendKeys(invalidEmail);
	}

	public static void verifyEmailErrorMsg() {
		if (!emailError.isDisplayed()) {
			Assert.fail("Email error message should match");
		}

	}

	// TC_05
	public static void verifyPasswordErrorMsg() {
		if (!passError.isDisplayed()) {
			Assert.fail("Password error message should match");
		}

	}

	// TC_06
	public static void verifyPasswordMinimumLength() {
		System.out.println(passError.getText());
		String passErr = passError.getText();
		if (!passErr.equalsIgnoreCase("Password should have character and number")) {
			Assert.fail("Password error message should match");
		}

	}

	public static void refreshBrowser() {
		driver.navigate().refresh();
	}

	public static void clickOnCloseIcon() {
		closeIcon.isDisplayed();
		closeIcon.click();
	}

	// TC10_11

	public static void clickOnTermsAndServicesLink() {
		termAndServices.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		termAndServicesWindow.isDisplayed();
		String header = termAndServicesHeader.getText();
		System.out.println("header " + header);
		Assert.assertEquals("Terms & Conditions", header);
		termAndServicesCloseIcon.click();

	}

	public static void clickOnLoginLink() {
		loginlink.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		email.isDisplayed();
		password.isDisplayed();
		loginCloseIcon.isDisplayed();
		loginCloseIcon.click();
	}

	//TakeScreenShot
	 public static void takeScreenShot(String methodName) {
	    	String filePath="D:/Ajackus/Screenshot";
	    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	         //The below method will save the screen shot in d drive with test method name 
	            try {
					FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
					System.out.println("***Placed screen shot in "+filePath+" ***");
				} catch (IOException e) {
					e.printStackTrace();
				}
	    }
}
