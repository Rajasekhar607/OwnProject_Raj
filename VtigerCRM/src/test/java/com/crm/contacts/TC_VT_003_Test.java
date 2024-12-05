package com.crm.contacts;

import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;

import org.apache.commons.collections4.ListUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.genericutility.BaseClass;
import com.crm.genericutility.ListenerUtility;
import com.crm.objectrepository.ContactsPage;
import com.crm.objectrepository.CreateContacsPage;
import com.crm.objectrepository.HomePage;

@Listeners(ListenerUtility.class)
public class TC_VT_003_Test extends BaseClass{
	@Test
	public void createContactWithOrganization() {
		hp=new HomePage(driver);
		hp.getContactsLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContactIcon().click();
		
		CreateContacsPage createConPage=new CreateContacsPage(driver);
		createConPage.getLastNameTextField().sendKeys("john");
		
		createConPage.getSelectIcon().click();
		wUtil.switchToWindow(driver, "Accounts&action");
		driver.findElement(By.xpath("//a[contains(text(),'flipkart')]")).click();
		
		wUtil.switchToWindow(driver, "Contacts&action");
		createConPage.getSaveButton().click();
		
		String organizationName = createConPage.getOrganizationNameField().getText();
		Assert.assertNotNull(organizationName);
		
		test.log(Status.PASS, "Contact is created with organizationname===>"+organizationName);
		
	}
}
