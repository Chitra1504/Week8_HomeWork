package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import base.BaseClass;

public class WelcomePage extends BaseClass {
	public MyHomePage crmsfa() throws IOException {
		try {
			getDriver().findElement(By.linkText("CRM/SFA")).click();
			reportStep("Click crmsfa successfully","Pass");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			reportStep("Crmsfa is not click","Fail");

		}
		return new MyHomePage();
	}
	public LoginPage logOut() throws IOException {
		try {
			getDriver().findElement(By.className("decorativeSubmit")).click();
			reportStep("Logout is successful","Pass");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			reportStep("Logout is not successful","Fail");
		}
		return new LoginPage();
	}

}
