package com.ajackus.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ajackus.page.PropertyCapsulePage;


@Listeners(value = com.ajackus.test.AjackusReporter.class)
public class PropertyCapsuleT04Test {

	@Test(alwaysRun = true)
	public static void testLaunchUrl() {
		PropertyCapsuleT02Test.testLaunchUrl();

	}

	@Parameters({ "username", "invalidEmail" })
	@Test(dependsOnMethods = "testLaunchUrl")
	public static void testVerifySignUpPage(String username, String invalidEmail) {
		PropertyCapsulePage.enterName(username);
		PropertyCapsulePage.enterInvalidEmail(invalidEmail);
		PropertyCapsulePage.clickOnSignUpBtnOfSignUpPage();
		// PropertyCapsulePage.VerifyErrorMsg();
		PropertyCapsulePage.verifyEmailErrorMsg();
		PropertyCapsulePage.closeBroser();
	}
}
