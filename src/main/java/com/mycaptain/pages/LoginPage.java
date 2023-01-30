package com.mycaptain.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseAutomationPage {
	private static final Logger logger = Logger.getLogger(LoginPage.class.getName());
	@FindBy(xpath = "//input[@id=\"email\"]")
	private WebElement fieldMobileNumber;

	@FindBy(xpath = "//input[@name='mobile']")
	private WebElement enterMobileNumber;

	@FindBy(xpath = "//span[contains(text(), 'Send OTP')]")
	private WebElement btnSendOTP;

	@FindBy(xpath = "//input[@id=\"mobile\"]")
	private WebElement fieldOtp;

	@FindBy(xpath = "//span[contains(text(), 'Continue')]")
	private WebElement btnContinue;

	@FindBy(xpath = "//span[contains(text(), 'Edit')]")
	private WebElement txtEdit;

	@FindBy(xpath = "//p[contains(text(),'My Courses')]	")
	private WebElement txtMyCourses;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnMobileNumberField(String Mobilenumber) {

		logger.info("Starting of clickOnFieldPhoneNumber method");
		clickOnWebElement(fieldMobileNumber);
		this.fieldMobileNumber.sendKeys(Mobilenumber);
		this.enterMobileNumber.clear();
		logger.info("Ending of clickOnFieldPhoneNumber method");
	}

	public void EnterMobileNumberField(String Mobilenumber) {

		logger.info("Starting of clickOnFieldPhoneNumber method");
		clickOnWebElement(enterMobileNumber);
		this.enterMobileNumber.sendKeys(Mobilenumber);
		logger.info("Ending of clickOnFieldPhoneNumber method");
	}

	public void SendOTPButton() {
		logger.info("Starting of clickOnFieldPhoneNumber method");
		clickOnWebElement(btnSendOTP);
		logger.info("Ending of clickOnFieldPhoneNumber method");
	}

	public void clickOnOtpField(String OTP) throws InterruptedException {
		logger.info("Starting of clickOnOtpField method");
		Thread.sleep(5000);
		clickOnWebElement(fieldOtp);
		this.fieldOtp.sendKeys(OTP);
		logger.info("Ending of clickOnOtpField method");

	}

	public void clickOnbtnContinue() throws InterruptedException {
		logger.info("Starting of clickOnbtnContinue method ");
		clickOnWebElement(btnContinue);
		logger.info("Ending of clickOnbtnContinue method");

	}

	public String getEdit() {
		logger.info("Starting of getVerification method");
		logger.info("Ending of getVerification method");
		return txtEdit.getText();

	}

	public String getMyCourses() {
		logger.info("Starting of getMyCourses method");
		logger.info("Ending of getMyCourses method");
		return txtMyCourses.getText();

	}

}
