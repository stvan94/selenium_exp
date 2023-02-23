package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class CheckoutPage extends TestBase {




	public CheckoutPage inputEmail(String email){
		WebElement emailTxt = driver.findElement(By.xpath("//input[@id='email']"));
		emailTxt.click();
		emailTxt.sendKeys(email);
		return this;

	}
	public CheckoutPage inputFull_name(String full_name){
		WebElement full_nameTxt = driver.findElement(By.xpath("//input[@id='full_name']"));
		full_nameTxt.click();
		full_nameTxt.sendKeys(full_name);
		return this;
	}

	public CheckoutPage inputPhone(String phone){
		WebElement phone_Txt = driver.findElement(By.xpath("//input[@id='phone']"));
		phone_Txt.click();
		phone_Txt.sendKeys(phone);
		return this;
	}
	public CheckoutPage inputAddress(String address){
		WebElement address_Txt = driver.findElement(By.xpath("//input[@id='address']"));
		address_Txt.click();
		address_Txt.sendKeys(address);
		return this;
	}
	public CheckoutPage inputNote(String note){
		WebElement note_Txt = driver.findElement(By.xpath("//textarea[@id='note']"));
		note_Txt.click();
		note_Txt.sendKeys(note);
		return this;
	}
	public CheckoutPage checkfoucslocator(String locator){
		WebElement e = driver.findElement(By.xpath("//input[@id='" + locator + "']"));
		if(e.equals(driver.switchTo().activeElement()))
			System.out.println("Passed: cursor is focus on "+locator);
		else
			System.out.println("Failed: cursor is not focus on "+locator);
		return new CheckoutPage();
	}

	public CheckoutPage clickSubmitBtn(){
		WebElement submitBtn = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		submitBtn.click();
		return this;
	}

	public CheckoutPage checkError(String errortxt, String error){
		WebElement e = driver.findElement(By.xpath("//input[@id='" + errortxt + "']"));
		System.out.println(e.getAttribute("validationMessage"));
		Assert.assertEquals(e.getAttribute("validationMessage"), error);
		return this;
	}

	public int getRatingCategory(){
		return driver.findElements(By.xpath("//span[@class='glyphicon glyphicon-star']")).size();
	}

	public String getMoneyCategory() {
		return driver.findElement(By.xpath("//h4[@class='pull-right']")).getText();
	}
	public String getReviewsCategory() {
		return driver.findElement(By.xpath("//p[@class='pull-right']")).getText();
	}
}
