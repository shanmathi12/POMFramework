package com.w3schools.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w3schools.utils.SeWrappers;
import com.w3schools.utils.W3Wrappers;

public class LoginTest extends SeWrappers{
	W3Wrappers w3= new W3Wrappers();
	SeWrappers se= new SeWrappers();

	@Test
	public void loginWithValidCredentials()
	{
		try
		{
			Reports.setTCDesc("validating login functionality with valid credentials");
			launchBrowser("https://profile.w3schools.com/");
 			String pageTitle="My learning | W3Schools";
			String actualTitle=se.getTitle();
			Assert.assertTrue(driver.getTitle().equals(pageTitle));
			Assert.assertEquals(actualTitle,pageTitle);
			Reports.reportStep("PASS", "Login with valid credentials passed");
		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Login failed");
			ex.printStackTrace();
		}
	}
	
	@Test
	public void loginWithInvalidEmail()
	{
		try
		{
			launchBrowser("https://profile.w3schools.com/");
			w3.loginW3Schools("bv.nirmal23333444@gmail.com","Testing@123");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
