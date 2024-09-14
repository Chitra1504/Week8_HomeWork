package runner;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC_002_CreateAccount extends BaseClass {
	@BeforeTest
	public void set() {
		testAuthor="Chitra";
		testDescription="Create Account with Positive value";
		testCategory="Sanity";
		testName="Create Account Test";
	}

	@Test
	public void runners() throws IOException {
		LoginPage lp=new LoginPage();
		lp.userName().password().login().crmsfa().cilckonAccounts().clickCA()
		.enterDetails()
		.viewAccountpage().checkAccountCreated();
	}
}
