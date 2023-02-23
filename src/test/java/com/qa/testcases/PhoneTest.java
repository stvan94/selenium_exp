package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.CheckoutPage;
import com.qa.pages.HomePage;
import com.qa.pages.InfomationPage;
import com.qa.pages.ProductPage;
import com.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PhoneTest extends TestBase {
	HomePage homePage;
	ProductPage productPage;
	CheckoutPage checkoutPage;
	TestUtil testUtil;
	InfomationPage infomationPage;
	String sheetName = "phone";

	public PhoneTest() {
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
	public void inputPhoneInValidTest(String phone)  {
		homePage = new HomePage();
		homePage.clickProduct();
		productPage = new ProductPage();
		productPage.clickOrder();
		checkoutPage = new CheckoutPage();
		checkoutPage.inputEmail("aaa@gmail.com");
		checkoutPage.inputFull_name("aaaa bbbb");
		checkoutPage.inputPhone(phone);
		checkoutPage.clickSubmitBtn();
		checkoutPage.checkfoucslocator("phone");
	}
	@Test(priority = 2)
	public void inputPhoneTest()  {
		homePage = new HomePage();
		homePage.clickProduct();
		productPage = new ProductPage();
		productPage.clickOrder();
		checkoutPage = new CheckoutPage();
		checkoutPage.inputEmail("aaa@gmail.com");
		checkoutPage.inputFull_name("aaaa bbbb");
		checkoutPage.inputPhone("0984111222");
		checkoutPage.clickSubmitBtn();
		infomationPage = new InfomationPage();
		infomationPage.checkinfomationLbl_display();

	}
	@Test(priority = 3)
	public void inputNullPhoneTest()  {
		homePage = new HomePage();
		homePage.clickProduct();
		productPage = new ProductPage();
		productPage.clickOrder();
		checkoutPage = new CheckoutPage();
		checkoutPage.inputEmail("aaa@gmail.com");
		checkoutPage.inputFull_name("aaaa bbbb");
		checkoutPage.inputPhone("");
		checkoutPage.clickSubmitBtn();
		checkoutPage.checkfoucslocator("phone");

	}
	@Test(priority = 4)
	public void inputBlankPhoneTest()  {
		homePage = new HomePage();
		homePage.clickProduct();
		productPage = new ProductPage();
		productPage.clickOrder();
		checkoutPage = new CheckoutPage();
		checkoutPage.inputEmail("aaa@gmail.com");
		checkoutPage.inputFull_name("aaaa bbbb");
		checkoutPage.inputPhone("     ");
		checkoutPage.clickSubmitBtn();
		checkoutPage.checkfoucslocator("phone");

	}
	@Test(priority = 5)
	public void inputOnlyPhoneTest()  {
		homePage = new HomePage();
		homePage.clickProduct();
		productPage = new ProductPage();
		productPage.clickOrder();
		checkoutPage = new CheckoutPage();
		checkoutPage.inputPhone("0984222333");
		checkoutPage.clickSubmitBtn();
		infomationPage = new InfomationPage();
		infomationPage.checkinfomationLbl_display();

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
