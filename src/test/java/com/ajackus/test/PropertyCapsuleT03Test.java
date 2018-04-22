package com.ajackus.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ajackus.page.PropertyCapsulePage;

@Listeners(value = com.ajackus.test.AjackusReporter.class)
public class PropertyCapsuleT03Test {

	@Test(alwaysRun = true)
	public static void testLaunchUrl() {
		PropertyCapsuleT02Test.testLaunchUrl();

	}

	@Parameters({ "username" })
	@Test(dependsOnMethods = "testLaunchUrl")
	public static void testVerifySignUpPage(String username) {
		PropertyCapsulePage.enterName(username);

		PropertyCapsulePage.clickOnSignUpBtnOfSignUpPage();
		PropertyCapsulePage.verifyNameErrorMsg();
		PropertyCapsulePage.closeBroser();
	}
}
