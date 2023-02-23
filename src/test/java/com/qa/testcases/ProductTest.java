package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.CheckoutPage;
import com.qa.pages.HomePage;
import com.qa.pages.ProductPage;
import com.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductTest extends TestBase {
    HomePage homePage;
    ProductPage productPage;
    CheckoutPage checkoutPage;
    TestUtil testUtil;
    String sheetName = "money";


    public ProductTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        testUtil = new TestUtil();
    }


    @Test(priority = 1, dataProvider = "getTestData")
    public void checkMoneyTest(String product,String category)  {
        int block =(int) Double.parseDouble(product) ;
        int index =(int) Double.parseDouble(category);
        homePage = new HomePage();
        String money= homePage.getMoneyCategory(index,block);
        System.out.print(money);

        homePage.clickProduct(index,block);
        productPage = new ProductPage();
        String moneyInProduct = productPage.getMoneyCategory();

        productPage.clickOrder();
        checkoutPage = new CheckoutPage();
        String moneyInCheckoutPage =  checkoutPage.getMoneyCategory();

        Assert.assertEquals(money, moneyInProduct);
        Assert.assertEquals(moneyInCheckoutPage, moneyInProduct);
        Assert.assertEquals(moneyInCheckoutPage, money);

    }
    @Test(priority = 2, dataProvider = "getTestData")
    public void checkReviewsTest(String product,String category)  {
        int block =(int) Double.parseDouble(product) ;
        int index =(int) Double.parseDouble(category);
        homePage = new HomePage();
        String review= homePage.getReviewsCategory(index,block);
        System.out.print(review);

        homePage.clickProduct(index,block);
        productPage = new ProductPage();
        String reviewInProduct = productPage.getReviewsCategory();

        productPage.clickOrder();
        checkoutPage = new CheckoutPage();
        String reviewInCheckoutPage =  checkoutPage.getReviewsCategory();

        Assert.assertEquals(review, reviewInProduct);
        Assert.assertEquals(reviewInCheckoutPage, reviewInProduct);
        Assert.assertEquals(reviewInCheckoutPage, review);
    }

    @Test(priority = 3, dataProvider = "getTestData")
    public void checkRatingsTest(String product,String category)  {
        int block =(int) Double.parseDouble(product) ;
        int index =(int) Double.parseDouble(category);
        homePage = new HomePage();
        int rating= homePage.getRatingCategory(index,block);
        System.out.print(rating);
        homePage.clickProduct(index,block);
        productPage = new ProductPage();
        int ratingInProduct = productPage.getRatingCategory();
        productPage.clickOrder();
        checkoutPage = new CheckoutPage();
        String ratingInCheckoutPage =  checkoutPage.getReviewsCategory();

        Assert.assertEquals(rating, ratingInProduct);
        Assert.assertEquals(ratingInProduct, ratingInCheckoutPage);
        Assert.assertEquals(ratingInCheckoutPage, rating);
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
