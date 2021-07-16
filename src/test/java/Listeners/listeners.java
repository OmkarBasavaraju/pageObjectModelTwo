package Listeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import utilities.ExtentReport;
import utilities.Screenshot;

public class listeners extends ExtentReport implements ITestListener {
	public static ExtentTest extentTest;
    public static ExtentReports report= reportBasic();
    Screenshot screenshot = new Screenshot();
	
	public void onTestStart(ITestResult result) {
		extentTest = report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		Markup m = MarkupHelper.createLabel("Passed", ExtentColor.GREEN);
		extentTest.pass(m);
	}

	public void onTestFailure(ITestResult result) {
	String text =  Arrays.toString(result.getThrowable().getStackTrace());
	screenshot.Screenshot();
	extentTest.addScreenCaptureFromPath("C:\\Users\\IGSA937002\\eclipse-workspace\\PageObjectModel\\Report\\Scrrenshot\\error.png", "Screenshot");
	extentTest.log(Status.FAIL, "<Details><Summary>"+text+"</Summary></Details>");
		Markup m = MarkupHelper.createLabel("Failed", ExtentColor.RED);
		extentTest.fail(m);
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}
}
