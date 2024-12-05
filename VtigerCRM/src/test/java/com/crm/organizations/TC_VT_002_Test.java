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
public class TC_VT_002_Test extends BaseClass{
	@Test(groups = "smoke")
	public void createOrganization() throws EncryptedDocumentException, IOException {
		hp=new HomePage(driver);
		hp.getOrganizationsLink().click();
		
		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.getCreateIcon().click();
		
		CreateOrganizationPage createOrgPage=new CreateOrganizationPage(driver);
		Assert.assertTrue(createOrgPage.getOrganizationNameTextField().isDisplayed(),"Create organization page is not displayed");
		test.log(Status.PASS, "Create organization page is displayed");
		
		String organizationName = eUtil.getStringDataFromExcel("Organizations", 1, 0)+jUtil.getRandomNumber();
		createOrgPage.getOrganizationNameTextField().sendKeys(organizationName);
		createOrgPage.getSaveButton().click();
		
		String headerText = createOrgPage.getOrganizationHeaderText().getText();
		System.out.println(headerText);
		
		Assert.assertTrue(headerText.contains(organizationName),"Organization is not created");
		test.log(Status.PASS, "Organization is created");
	}
}
