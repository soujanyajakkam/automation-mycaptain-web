package com.mycaptain.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProCoursePage extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(LoginPage.class.getName());

	@FindBy(xpath = "//h3[contains(text(), 'UIUX PRO')]")
	private WebElement txtUIUXCourse;

	@FindBy(xpath = "(//div[@class=\"ant-collapse-item\"]//div[@class=\"ant-collapse-header\"])[2]")
	private WebElement ddMilstone1;

	@FindBy(xpath = "//div[@class=\"flex ml-[12px] gap-[8px] items-center flex-wrap\"]//div[contains(text(), 'Portfolio Project')]")
	private WebElement btnPortfolio;

	@FindBy(xpath = "//div[@class=\"ant-col ant-form-item-control\"]//div[@class=\"ant-form-item-control-input-content\"]")
	private WebElement lblURL;

	public ProCoursePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnMilstonedropdown() {
		logger.info("Starting of clickOnFieldPhoneNumber method");
		pause(10000);
		scrolltoView(ddMilstone1);
		pause(10000);
		clickOnWebElement(ddMilstone1);
		logger.info("Ending of clickOnFieldPhoneNumber method");

	}

	public void clickOnPortfolioButton(String URL) {
		logger.info("Starting of clickOnPortfolioButton method");
		pause(5000);

		scrolltoView(btnPortfolio);
		clickOnWebElement(btnPortfolio);
		this.btnPortfolio.sendKeys(URL);
		logger.info("Ending of clickOnPortfolioButton method");

	}

	public String getUIUXCourse() {
		logger.info("Starting of getMyCourses method");
		logger.info("Ending of getMyCourses method");
		return txtUIUXCourse.getText();
	}

}
