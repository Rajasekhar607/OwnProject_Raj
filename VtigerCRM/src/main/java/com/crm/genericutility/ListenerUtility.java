package com.crm.genericutility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenerUtility extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		test=extReport.createTest(result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getName();
		test.log(Status.FAIL, methodName+" is failed");
		
		TakesScreenshot ts=(TakesScreenshot) sdriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));//add screenshot in extent report
		File dest=new File("./screenshots/"+methodName+jUtil.getSystemTime()+".png");
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
