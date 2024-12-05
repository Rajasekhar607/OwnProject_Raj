package com.crm.organizations;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.genericutility.BaseClass;
import com.crm.genericutility.ListenerUtility;
import com.crm.objectrepository.CreateOrganizationPage;
import com.crm.objectrepository.HomePage;
import com.crm.objectrepository.OrganizationPage;
@Listeners(ListenerUtility.class)
public class TC_VT_004_Test extends BaseClass{
	@Test
	public void createOrganizathIndustryDropdown() throws EncryptedDocumentException, IOException {
		hp=new HomePage(driver);
		hp.getOrganizationsLink().click();
		
		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.getCreateIcon().click();
		
		CreateOrganizationPage createOrgPage=new CreateOrganizationPage(driver);
		String orgName = eUtil.getStringDataFromExcel("Organizations", 1, 0)+jUtil.getRandomNumber();
		createOrgPage.getOrganizationNameTextField().sendKeys(orgName);
		
		wUtil.selectByVisibleText(createOrgPage.getIndustryDropdown(), eUtil.getStringDataFromExcel("Organizations", 2, 1));
		createOrgPage.getSaveButton().click();
		
		Assert.assertEquals(createOrgPage.getIndustryField().getText(), eUtil.getStringDataFromExcel("Organizations", 2, 1));
		test.log(Status.PASS, "Organization is created with industry name===>"+createOrgPage.getIndustryField().getText());
	}
}
