package com.crm.genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.crm.objectrepository.HomePage;
import com.crm.objectrepository.LoginPage;

public class BaseClass {
	public static WebDriver sdriver;
	public WebDriver driver;
	
	public static ExtentReports extReport;
	public static ExtentTest test;
	
	public FileUtilty fUtil=new FileUtilty();
	public ExcelUtility eUtil=new ExcelUtility();
	public JavaUtility jUtil=new JavaUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	
	public LoginPage lp;
	public HomePage hp;
	
	
	@BeforeSuite
	public void reportConfiguration() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/ExtentReport_"+jUtil.getSystemTime()+".html");
		extReport=new ExtentReports();
		extReport.attachReporter(spark);
	}
	
	@Parameters("Browser")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browserName) throws IOException {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		sdriver=driver;
		wUtil.maximizeWindow(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(fUtil.getDataFromProperty("url"));	
	}
	@BeforeMethod
	public void login() throws IOException {
		lp=new LoginPage(driver);
		lp.getUsernameTextFiled().sendKeys(fUtil.getDataFromProperty("username"));
		lp.getPasswordTextField().sendKeys(fUtil.getDataFromProperty("password"));
		lp.getLoginButton().click();
	}
	
	@AfterMethod
	public void logout() {
		hp=new HomePage(driver);
		wUtil.mouseHover(driver, hp.getProfileIcon());
		hp.getSignOutLink().click();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	@AfterSuite
	public void reportBackup() {
		extReport.flush();
	}
	
	
}
