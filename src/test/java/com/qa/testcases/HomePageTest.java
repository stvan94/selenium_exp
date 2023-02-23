package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
	HomePage homePage;
	TestUtil testUtil;
	String sheetName = "home";

	public HomePageTest() {
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
	public void homepageTest(String item) {
		homePage = new HomePage();
		homePage.clickElementHomePage(item);
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
