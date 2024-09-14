package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import base.BaseClass;

public class CreateAccount extends BaseClass {


	

	public CreateAccount enterDetails() throws IOException {
		try {
		getDriver().findElement(By.id("accountName")).sendKeys("Chitra");
		getDriver().findElement(By.name("description")).sendKeys("Description");
		getDriver().findElement(By.id("numberEmployees")).sendKeys("6");
		getDriver().findElement(By.id("officeSiteName")).sendKeys("Test Leaf");
		getDriver().findElement(By.className("smallSubmit")).click();
		reportStep("Account details are entered successfully","Pass");
		}
		catch(Exception e) {
			System.out.println(e);
			reportStep("Account details are not entered","Fail");
		}
		return this;
	}

	public ViewAccount viewAccountpage() {
		return new ViewAccount();
	}
}