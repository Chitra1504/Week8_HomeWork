package pages;

import java.io.IOException;

import org.openqa.selenium.By;


import base.BaseClass;

public class MyHomePage extends BaseClass {
	public MyLeads cilckonLeads() throws IOException {
		try {
			getDriver().findElement(By.linkText(prop.getProperty("MyHomePage.Leads"))).click();
			reportStep("Click leads successfully","Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);	
			reportStep("Leads is not click","Fail");
		}
		return new MyLeads();
	}
		public MyAccountPage cilckonAccounts() throws IOException {
			try {
				getDriver().findElement(By.linkText(prop.getProperty("MyHomePage.Accounts"))).click();
				reportStep("Click accounts successfully","Pass");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);		
				reportStep("Accounts is not click","Fail");
}
			return new MyAccountPage();
		}
	}

