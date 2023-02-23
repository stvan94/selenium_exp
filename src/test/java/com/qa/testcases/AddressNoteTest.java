package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.CheckoutPage;
import com.qa.pages.HomePage;
import com.qa.pages.InfomationPage;
import com.qa.pages.ProductPage;
import com.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddressNoteTest extends TestBase {
	HomePage homePage;
	ProductPage productPage;
	CheckoutPage checkoutPage;
	InfomationPage infomationPage;
	TestUtil testUtil;

	public AddressNoteTest() {
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
	public void inputAddressTest()  {
		homePage = new HomePage();
		homePage.clickProduct();
		productPage = new ProductPage();
		productPage.clickOrder();
		checkoutPage = new CheckoutPage();
		checkoutPage.inputEmail("aaa@gmail.com");
		checkoutPage.inputFull_name("aaaa bbbb");
		checkoutPage.inputPhone("0984111222");
		checkoutPage.inputAddress("aaaaaaaaaaa");
 		checkoutPage.clickSubmitBtn();
		infomationPage = new InfomationPage();
		infomationPage.checkinfomationLbl_display();
	}
	@Test(priority = 2)
	public void inputBlankAddressTest()  {
		homePage = new HomePage();
		homePage.clickProduct();
		productPage = new ProductPage();
		productPage.clickOrder();
		checkoutPage = new CheckoutPage();
		checkoutPage.inputEmail("aaa@gmail.com");
		checkoutPage.inputFull_name("aaaa bbbb");
		checkoutPage.inputPhone("0984111222");
		checkoutPage.inputAddress("          ");
		checkoutPage.clickSubmitBtn();
		infomationPage = new InfomationPage();
		infomationPage.checkinfomationLbl_display();

	}
	@Test(priority = 3)
	public void inputNullAddressTest()  {
		homePage = new HomePage();
		homePage.clickProduct();
		productPage = new ProductPage();
		productPage.clickOrder();
		checkoutPage = new CheckoutPage();
		checkoutPage.inputEmail("aaa@gmail.com");
		checkoutPage.inputFull_name("aaaa bbbb");
		checkoutPage.inputPhone("0984111222");
		checkoutPage.inputAddress("");
		checkoutPage.clickSubmitBtn();
		infomationPage = new InfomationPage();
		infomationPage.checkinfomationLbl_display();

	}
	@Test(priority = 4)
	public void inputNoteTest()  {
		homePage = new HomePage();
		homePage.clickProduct();
		productPage = new ProductPage();
		productPage.clickOrder();
		checkoutPage = new CheckoutPage();
		checkoutPage.inputEmail("aaa@gmail.com");
		checkoutPage.inputFull_name("aaaa bbbb");
		checkoutPage.inputPhone("0984111222");
		checkoutPage.inputAddress("aaaaaaa");
		checkoutPage.inputNote("aaaaaaaaa");
		checkoutPage.clickSubmitBtn();
		infomationPage = new InfomationPage();
		infomationPage.checkinfomationLbl_display();

	}
	@Test(priority = 5)
	public void inputBlankNoteTest()  {
		homePage = new HomePage();
		homePage.clickProduct();
		productPage = new ProductPage();
		productPage.clickOrder();
		checkoutPage = new CheckoutPage();
		checkoutPage.inputEmail("aaa@gmail.com");
		checkoutPage.inputFull_name("aaaa bbbb");
		checkoutPage.inputPhone("0984111222");
		checkoutPage.inputAddress("aaaaaaaaa");
		checkoutPage.inputNote("     ");
		checkoutPage.clickSubmitBtn();
		infomationPage = new InfomationPage();
		infomationPage.checkinfomationLbl_display();

	}
	@Test(priority = 6)
	public void inputNullNoteTest()  {
		homePage = new HomePage();
		homePage.clickProduct();
		productPage = new ProductPage();
		productPage.clickOrder();
		checkoutPage = new CheckoutPage();
		checkoutPage.inputEmail("aaa@gmail.com");
		checkoutPage.inputFull_name("aaaa bbbb");
		checkoutPage.inputPhone("0984111222");
		checkoutPage.inputAddress("aaaaaaaa");
		checkoutPage.inputNote("");
		checkoutPage.clickSubmitBtn();
		infomationPage = new InfomationPage();
		infomationPage.checkinfomationLbl_display();

	}


	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
	

}
