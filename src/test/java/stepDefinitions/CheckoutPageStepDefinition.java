package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetUp;

public class CheckoutPageStepDefinition {

	
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public TestContextSetUp testContextSetUp;
	public CheckoutPage checkoutPage;
	public LandingPage landingPage;
	
	public CheckoutPageStepDefinition(TestContextSetUp testContextSetUp) 
	{
		this.testContextSetUp=testContextSetUp;
		this.checkoutPage = testContextSetUp.pageObjectManager.getCheckoutPage();
	}

	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void User_proceeds_to_Checkout_and_validate_the_items_in_checkout_page(String name) throws InterruptedException {
	checkoutPage.CheckoutItems();
	Thread.sleep(2000);
	}
	
//	@And(" Verify user has ability to enter promo code and place the order")
//	public void  Verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
//		checkoutPage = testContextSetUp.pageObjectManager.getCheckoutPage();
//		Assert.assertTrue(checkoutPage.VerifyPromoBTn());
//		Assert.assertTrue(checkoutPage.VerifyPlanOrder());
//	}
	
	@Then("Verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() throws InterruptedException {
		checkoutPage = testContextSetUp.pageObjectManager.getCheckoutPage();
		Assert.assertTrue(checkoutPage.VerifyPromoBTn());
		Assert.assertTrue(checkoutPage.VerifyPlanOrder());
	}

	
	
}
