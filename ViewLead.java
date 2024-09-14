package pages;

import java.io.IOException;

import base.BaseClass;

public class ViewLead extends BaseClass{
	public void verifyLeadCreation() throws IOException {
		try {
		String title=getDriver().getTitle();
		if(title.equals("View Lead | opentaps CRM"))
			reportStep("Lead is created successfully","Pass");
		}
		catch(Exception e) {
			System.out.println(e);
			reportStep("Lead is not created successfully","Fail");
		}
	}
}
