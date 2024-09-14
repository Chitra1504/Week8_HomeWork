package pages;

import java.io.IOException;

import base.BaseClass;

public class ViewAccount extends BaseClass {
	
	public void checkAccountCreated() throws IOException {
		try {
		String title = getDriver().getTitle();
		if (title.equals("Account Details | opentaps CRM"))
			System.out.println("Account Created Successfully");
		reportStep("Account is created succesfully","Pass");
		}
		catch(Exception e) {
			System.out.println(e);
			reportStep("Account is not created","Fail");
		}
	}

}
