package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	@FindBy(name = "accountname")
	private WebElement organizationNameTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationHeaderText;
	
	@FindBy(name = "industry")
	private WebElement industryDropdown;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement industryField;
	
	public WebElement getIndustryField() {
		return industryField;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getOrganizationHeaderText() {
		return organizationHeaderText;
	}
	
	
}
