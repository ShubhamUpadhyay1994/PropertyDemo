package com.ajackus.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ajackus.page.PropertyCapsulePage;

@Listeners(value = com.ajackus.test.AjackusReporter.class)
public class PropertyCapsuleT06Test {


	@Test(alwaysRun = true)
	public static void testLaunchUrl() {
		PropertyCapsuleT02Test.testLaunchUrl();

	}

	@Parameters({ "userName" ,"userEmail","userPassword"})
	@Test(dependsOnMethods = "testLaunchUrl")
	public static void testVerifySignUpPage(String userName,String userEmail,String userPassword) {
	PropertyCapsulePage.enterDetails(userName, userEmail, userPassword);
	//PropertyCapsulePage.verifyPasswordMinimumLength();
	PropertyCapsulePage.verifyPasswordErrorMsg();
	
	//TC 07
	PropertyCapsulePage.refreshBrowser();
	PropertyCapsulePage.enterDetails(userName, userEmail, "aniketsingh");
	PropertyCapsulePage.verifyPasswordErrorMsg();
	
	//TC 08
	PropertyCapsulePage.refreshBrowser();
	PropertyCapsulePage.enterDetails(userName, userEmail, "76856745");
	PropertyCapsulePage.verifyPasswordErrorMsg();
	PropertyCapsulePage.clickOnCloseIcon();
	PropertyCapsulePage.waitForUserPage();
	
	
	}
}
