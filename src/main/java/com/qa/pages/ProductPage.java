package com.qa.pages;

import com.qa.base.TestBase;
import com.qa.libs.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends TestBase {


	public String getMoneyCategory() {
		return driver.findElement(By.xpath("//h4[@class='pull-right']")).getText();
	}
	public String getReviewsCategory() {
		return driver.findElement(By.xpath("//p[@class='pull-right']")).getText();
	}
	public int getRatingCategory(){
		return driver.findElements(By.xpath("//span[@class='glyphicon glyphicon-star']")).size();
	}
	public ProductPage clickOrder() {
		WebElement orderBtn = driver.findElement(By.xpath("//a[@class='btn btn-success']"));
		orderBtn.click();
		return this;
	}
}
