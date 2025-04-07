package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetUp;
//Single responsibility Principle - 
//Loosly coupled
// factory design pattern - assign property to one class file

//Factory design principle


public class OfferPageStepDefinition {
	
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public TestContextSetUp testContextSetUp;
	 PageObjectManager pageObjectManager;
	
	public OfferPageStepDefinition( TestContextSetUp  testContextSetUp) {
		this.testContextSetUp=testContextSetUp;
	}
	
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page_tp_check_if_product_exist(String shortName) throws InterruptedException {
		switchToOffersPage();
		OffersPage offersPage = new OffersPage(testContextSetUp.driver);	
		offersPage.searchItem(shortName);
		Thread.sleep(2000);
		 offerPageProductName = offersPage.getProductName();
	}
	
	public void switchToOffersPage() {
		// if switched to offer page -> skip below part
		//if(testContextSetUp.driver.getCurrentUrl().equalsIgnoreCase("https;//rahulshettyacademy.com/seleniumPractise");
		LandingPage landingPage = testContextSetUp.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testContextSetUp.genericUtils.SwitchWindowToChild();
		
	}
	

	@And("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_Page() {
		Assert.assertEquals(offerPageProductName,testContextSetUp, landingPageProductName);
	}

}
