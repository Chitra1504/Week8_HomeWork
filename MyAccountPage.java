package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import base.BaseClass;

public class MyAccountPage extends BaseClass {
	
	public CreateAccount clickCA() throws IOException {
		try {
		getDriver().findElement(By.linkText("Create Account")).click();
		reportStep("Create Account is clicked","Pass");
		}
		catch(Exception e) {
			System.out.println(e);
			reportStep("Create Account is not clicked","Fail");
		}
		return new CreateAccount();
	}

}
