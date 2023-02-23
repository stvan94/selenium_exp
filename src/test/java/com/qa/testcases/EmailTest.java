package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.CheckoutPage;
import com.qa.pages.HomePage;
import com.qa.util.TestUtil;
import com.qa.pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class EmailTest extends TestBase {
	HomePage homePage;
	ProductPage productPage;
	CheckoutPage checkoutPage;
	TestUtil testUtil;
	String sheetName = "email";

	public EmailTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
	}

	@Test(priority = 1, dataProvider = "getTestData")
	public void emailInvalidTest(String email, String error)  {
		homePage = new HomePage();
		homePage.clickProduct();
		productPage = new ProductPage();
		productPage.clickOrder();
		checkoutPage = new CheckoutPage();
		checkoutPage.inputEmail(email);
		checkoutPage.clickSubmitBtn();
		checkoutPage.checkError("email", error);
		checkoutPage.checkfoucslocator("email");
	}

	@Test(priority = 2)
	public void emailValidTest()  {
		homePage = new HomePage();
		homePage.clickProduct();
		productPage = new ProductPage();
		productPage.clickOrder();
		checkoutPage = new CheckoutPage();
		checkoutPage.inputEmail("aaa@gmail.com");
		checkoutPage.clickSubmitBtn();
		checkoutPage.checkfoucslocator("email");
	}

	@Test(priority = 3)
	public void blankEmailTest()  {
		homePage = new HomePage();
		homePage.clickProduct();
		productPage = new ProductPage();
		productPage.clickOrder();
		checkoutPage = new CheckoutPage();
		checkoutPage.inputEmail("  ");
		checkoutPage.clickSubmitBtn();
		checkoutPage.checkfoucslocator("full_name");
	}
	@Test(priority = 4)
	public void nullEmailTest()  {
		homePage = new HomePage();
		homePage.clickProduct();
		productPage = new ProductPage();
		productPage.clickOrder();
		checkoutPage = new CheckoutPage();
		checkoutPage.inputEmail("  ");
		checkoutPage.clickSubmitBtn();
		checkoutPage.checkfoucslocator("full_name");
	}
	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
	

}
