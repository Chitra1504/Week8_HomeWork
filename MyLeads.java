package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import base.BaseClass;

public class MyLeads extends BaseClass{
	public CreateLead clickCreateLead() throws IOException {
	try {
	getDriver().findElement(By.linkText("Create Lead")).click();
	reportStep("Create Lead is clicked successfully","Pass");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e);	
		reportStep("Create Lead is not clicked","Fail");
	}
	return new CreateLead();
}

}
