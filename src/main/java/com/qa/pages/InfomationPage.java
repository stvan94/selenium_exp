package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class InfomationPage extends TestBase {

	public InfomationPage checkinfomationLbl_display(){
		WebElement infomationLbl = driver.findElement(By.xpath("//h3[contains(text(),'INFOMATION')]"));
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		infomationLbl.isDisplayed();
		return this;
	}



}
