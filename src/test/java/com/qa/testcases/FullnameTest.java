package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.CheckoutPage;
import com.qa.pages.HomePage;
import com.qa.pages.ProductPage;
import com.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FullnameTest extends TestBase {
	HomePage homePage;
	ProductPage productPage;
	CheckoutPage checkoutPage;
	TestUtil testUtil;

	public FullnameTest() {
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


	@Test(priority = 1)
	public void inputFullnameTest()  {
		homePage = new HomePage();
		homePage.clickProduct();
		productPage = new ProductPage();
		productPage.clickOrder();
		checkoutPage = new CheckoutPage();
		checkoutPage.inputEmail("aaa@gmail.com");
		checkoutPage.inputFull_name("aaa bbb");
		checkoutPage.clickSubmitBtn();
		checkoutPage.checkfoucslocator("phone");

	}
	@Test(priority = 2)
	public void inputBlankFullnameTest()  {
		homePage = new HomePage();
		homePage.clickProduct();
		productPage = new ProductPage();
		productPage.clickOrder();
		checkoutPage = new CheckoutPage();
		checkoutPage.inputEmail("aaa@gmail.com");
		checkoutPage.inputFull_name("    ");
		checkoutPage.clickSubmitBtn();
		checkoutPage.checkfoucslocator("phone");
	}
	@Test(priority = 3)
	public void inputNullFullnameTest()  {
		homePage = new HomePage();
		homePage.clickProduct();
		productPage = new ProductPage();
		productPage.clickOrder();
		checkoutPage = new CheckoutPage();
		checkoutPage.inputEmail("aaa@gmail.com");
		checkoutPage.inputFull_name("");
		checkoutPage.clickSubmitBtn();
		checkoutPage.checkfoucslocator("phone");
	}

	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
	

}
