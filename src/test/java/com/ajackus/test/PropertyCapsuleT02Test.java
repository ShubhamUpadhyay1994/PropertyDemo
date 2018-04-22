package com.ajackus.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ajackus.page.PropertyCapsulePage;

@Listeners(value=com.ajackus.test.AjackusReporter.class)
public class PropertyCapsuleT02Test {


	@Test(alwaysRun = true)
	public static void testLaunchUrl() {
		PropertyCapsuleTC01Test.testSetup();
		PropertyCapsuleTC01Test.testSignUp();
		PropertyCapsuleTC01Test.testWaitForSignUpPage();

	}

	@Test(dependsOnMethods = "testLaunchUrl")
	public static void testVerifySignUpPage() {
		PropertyCapsulePage.clickOnSignUpBtnOfSignUpPage();
		PropertyCapsulePage.verifySignUpPageWithoutText();
		PropertyCapsulePage.closeBroser();
	}
}
