package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class BaseClass extends AbstractTestNGCucumberTests {
	//step 1
	private static final ThreadLocal<RemoteWebDriver> tlDriver=new ThreadLocal<RemoteWebDriver>();
	//properties variable should have common value to all the pages or test cases
	//so we need to add static keyword
	public static Properties prop;
	public static ExtentReports er;
	public static ExtentTest test;
	public String testName,testDescription,testAuthor,testCategory;
	public void setDriver() {
		tlDriver.set(new ChromeDriver());
	}
	public RemoteWebDriver getDriver(){
		return tlDriver.get();
		
	}
	@BeforeMethod
	public void beforeMethod() throws IOException {
		FileInputStream fis=new FileInputStream("src/main/resources/English.properties");
		prop=new Properties();
		prop.load(fis);
		
		setDriver();
		getDriver().manage().window().maximize();
		getDriver().get("http://leaftaps.com/opentaps/control/main");
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@AfterMethod
	public void afterMethod() {
		getDriver().close();
	}
	@BeforeSuite
	public void startReport(){
		ExtentHtmlReporter wb=new ExtentHtmlReporter("./report/loginReport.html");
		wb.setAppendExisting(true);
		er=new ExtentReports();
		er.attachReporter(wb);
	}
	@AfterSuite
	public void stopReport(){
		er.flush();
	}
	@BeforeClass
	public void testDetails() {
		test=er.createTest(testName, testDescription);
		test.assignAuthor(testAuthor);
		test.assignCategory(testCategory);
	}
	public void reportStep(String testDetails,String testStatus) throws IOException {
		if(testStatus.equalsIgnoreCase("pass")) {
			test.pass(testDetails,MediaEntityBuilder.createScreenCaptureFromPath(".././SnapShots/ts"+takeSnap()+".png").build());
		}
		else if(testStatus.equalsIgnoreCase("fail")) {
			test.fail(testDetails,MediaEntityBuilder.createScreenCaptureFromPath(".././SnapShots/ts"+takeSnap()+".png").build());
		}
	}
	public int takeSnap() throws IOException {
		int random=(int) (Math.random()*99999);
		File src=getDriver().getScreenshotAs(OutputType.FILE);
		File des=new File("./SnapShots/ts"+random+".png");
		FileUtils.copyFile(src, des);
		return random;
	}
}
