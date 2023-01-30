package com.mycaptain.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mycaptain.pages.LoginPage;
import com.mycaptain.pages.ProCoursePage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class ProCourseTest extends BaseAutomationTest {
	private static final Logger logger = Logger.getLogger(LoginPage.class.getName());

	public WebDriver driver;
	private LoginPage loginPage;
	private ProCoursePage proCoursePage;

	@BeforeClass
	@Parameters({ "siteURL", "browser" })
	public void initMethod(String siteURL, String browser) {

		logger.info("Starting of initial Method");

		driver = this.getWebDriver(browser);

		this.loginPage = new LoginPage(driver);

		this.proCoursePage = new ProCoursePage(driver);

		driver.manage().window().maximize();

		driver.get(siteURL);

		logger.info("Ending of initial Method ");

	}

	@Test(priority = 1)
	@Description("Verify PhoneNumber")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Login")
	public void testVerifyPhoneNumber() throws InterruptedException {
		logger.info("Starting of testVerifyPhoneNumber method");
		Thread.sleep(3000);
		loginPage.clickOnMobileNumberField(testDataProp.getProperty("Phone.number"));
		loginPage.EnterMobileNumberField(testDataProp.getProperty("Phone.number"));
		Thread.sleep(3000);
		loginPage.SendOTPButton();
		Assert.assertEquals(loginPage.getEdit(), expectedAssertionsProp.getProperty("Edit"));
		logger.info("Ending of testVerifyPhoneNumber method");
	}

	@Test(priority = 2)
	@Description("Verify OTPField")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Login")
	public void testVerifyOTP() throws InterruptedException {
		logger.info("Starting of testVerifyOTP method");
		loginPage.clickOnOtpField(testDataProp.getProperty("OTP"));
		loginPage.clickOnbtnContinue();
		Assert.assertEquals(loginPage.getMyCourses(), expectedAssertionsProp.getProperty("My.Courses"));
		logger.info("Ending of testVerifyOTP method");

	}

	@Test(priority = 3)
	@Parameters({ "procourseURL" })
	@Description("Verify OTPField")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Procourse")
	public void testVerifyProCourse(String procourseURL)  {
		logger.info("Starting of testVerifyProCourse method");
		proCoursePage.switchToNewUrl(procourseURL);
		Assert.assertEquals(proCoursePage.getUIUXCourse(), expectedAssertionsProp.getProperty("UIUX.Course"));
		proCoursePage.clickOnMilstonedropdown();
		proCoursePage.clickOnPortfolioButton(testDataProp.getProperty("URL"));
		logger.info("Ending of testVerifyProCourse method");
	}

	@AfterClass
	public void quitdriver() {

	}

}
