package com.ajackus.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ajackus.page.PropertyCapsulePage;

@Listeners(value = com.ajackus.test.AjackusReporter.class)
public class PropertyCapsuleT10_T11Test {


	@Test(alwaysRun = true)
	public static void testLaunchUrl() {
		PropertyCapsuleT02Test.testLaunchUrl();

	}

	
	@Test(dependsOnMethods = "testLaunchUrl")
	public static void testTermAndServices(){
		PropertyCapsulePage.clickOnTermsAndServicesLink();

		PropertyCapsulePage.waitForUserPage();
		
	}
	
	@Test(dependsOnMethods = "testTermAndServices")
	public static void testLoginPage() throws InterruptedException{
		Thread.sleep(2000);
	//	PropertyCapsulePage.clicknSignUpink();
		PropertyCapsulePage.waitForSignUpPage();
		PropertyCapsulePage.clickOnLoginLink();
		PropertyCapsulePage.closeBroser();
	
		
	}
}
