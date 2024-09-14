package runner;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC_001_CreateLead extends BaseClass {
	@BeforeTest
	public void set() {
		testAuthor="Chitra";
		testDescription="Create Lead with Positive value";
		testCategory="Sanity";
		testName="Create Lead Test";
	}
	@Test
	public void runners() throws IOException {
		LoginPage lp=new LoginPage();
		lp.userName().password().login().
		crmsfa().cilckonLeads().clickCreateLead().enterLeadDetails().verifyLeadCreation();
	}
	
}
