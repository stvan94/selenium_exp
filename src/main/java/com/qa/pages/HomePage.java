package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.base.TestBase;

import javax.lang.model.element.Element;
import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends TestBase {

	public HomePage checkHomeLbl_display(){
		WebElement infomationLbl = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		infomationLbl.isDisplayed();
		return this;
	}

	public HomePage clickElementHomePage(String item){
		String xpath = "//a[contains(text()," + "'" + item + "')]";
		driver.findElement(By.xpath(xpath)).click();
		return this;
	}
	public HomePage clickProduct(){
		String xpathProduct = "//a[contains(text(),'Product 2')]";
		WebElement b = driver.findElement(By.xpath(xpathProduct));
		b.click();
		return this;
	}
	public HomePage clickProduct(int index,int block){
		List<WebElement> listCategory = driver.findElements(By.xpath("//div[@block-id='cat"+block+"']//div//div//h4//a"));
		if(listCategory.size()>0&&listCategory.size()>index){
			 listCategory.get(index).click();
		}
		return this;
	}
	//lay category dau voi index vi tri truyen vao
	public String getMoneyCategory(int index,int block) {
		List<WebElement> listMoney = driver.findElements(By.xpath("//div[@block-id='cat"+block+"']//div//div//h4[@class='pull-right']"));
		if(listMoney.size()>0&&listMoney.size()>index){
			return listMoney.get(index).getText();
		}
		return "";
	}
	public String getReviewsCategory(int index,int block) {
		List<WebElement> listReview = driver.findElements(By.xpath("//div[@block-id='cat"+block+"']//div//div//p[@class='pull-right']"));
		if(listReview.size()>0&&listReview.size()>index){
			return listReview.get(index).getText();
		}
		return "";
	}
	public int getRatingCategory(int index,int block){
		List<WebElement> listRatings = driver.findElements(By.xpath("//div[@block-id='cat"+block+"']//div//div[@class='ratings']"));
		System.out.println(listRatings.size());
		if(listRatings.size()>0&&listRatings.size()>index){
			return listRatings.get(index).findElements(By.xpath(".//span[@class='glyphicon glyphicon-star']")).size();
		}
		return 0;
	}
}
