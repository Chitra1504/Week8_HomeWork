package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import base.BaseClass;

public class CreateLead extends BaseClass{
	public ViewLead enterLeadDetails() throws IOException {
		try {
			getDriver().findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
			getDriver().findElement(By.id("createLeadForm_firstName")).sendKeys("Dilip");
			getDriver().findElement(By.id("createLeadForm_lastName")).sendKeys("Kumar");
			getDriver().findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("99");
			getDriver().findElement(By.name("submitButton")).click();
			reportStep("Lead details are entered successfully","Pass");
		}
		catch(Exception e) {
			System.out.println(e);	
			reportStep("Lead details are not entered","Fail");
		}
		return new ViewLead();
	}
}
