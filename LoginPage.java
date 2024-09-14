package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import base.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage userName() throws IOException {
		try {
			getDriver().findElement(By.id("username")).sendKeys(prop.getProperty("username"));
			reportStep("UserName Enter successfully","Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			reportStep("UserName Not Enter successfully","Fail");
		}
		return this;
	}
	public LoginPage password() throws IOException {
		try {
			getDriver().findElement(By.id("password")).sendKeys(prop.getProperty("password"));
			reportStep("Password Enter successfully","Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			reportStep("Password Not Enter successfully","Fail");
		}
	return this;
	}
	public WelcomePage login() throws IOException {
		try {
			getDriver().findElement(By.className("decorativeSubmit")).click();
			reportStep("Click Login successfully","Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			reportStep("Click Login Not successfully","Fail");

		}

	return new WelcomePage();
	}	
}
