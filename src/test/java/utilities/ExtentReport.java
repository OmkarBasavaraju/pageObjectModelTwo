package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Base.Base;

public class ExtentReport extends Base {
	public static ExtentReports extentreport;
	public static ExtentSparkReporter extent;

	public static ExtentReports reportBasic() {
		extent = new ExtentSparkReporter("C://Users//IGSA937002//eclipse-workspace//PageObjectModel//target//surefire-reports//Extent.html");
		extent.config().setEncoding("utf-8");
//		extent.config().setDocumentTitle("PageObjectModel");
		extent.config().setReportName("PageObjectModel");
		extent.config().setTheme(Theme.STANDARD);
		extentreport = new ExtentReports();
		extentreport.attachReporter(extent);
		return extentreport;
	}
}
