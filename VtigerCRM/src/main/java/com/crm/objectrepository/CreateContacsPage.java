package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContacsPage {
	@FindBy(name = "lastname")
	private WebElement lastNameTextField;
	
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement selectIcon;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement organizationNameField;
	
	public WebElement getOrganizationNameField() {
		return organizationNameField;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}


	public CreateContacsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}


	public WebElement getSelectIcon() {
		return selectIcon;
	}
	
	
}
