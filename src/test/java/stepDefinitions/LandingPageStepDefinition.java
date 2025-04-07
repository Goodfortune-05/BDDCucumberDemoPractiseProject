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
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetUp;

public class LandingPageStepDefinition {

	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public TestContextSetUp testContextSetUp;
	LandingPage landingPage;
	
	
	public LandingPageStepDefinition(TestContextSetUp testContextSetUp) 
	{
		this.testContextSetUp=testContextSetUp;
		this.landingPage = testContextSetUp.pageObjectManager.getLandingPage();
	}

	@Given("User is oon GreenCart Landing Page")
	public void user_is_oon_green_cart_landing_page() {
		
		Assert.assertEquals(landingPage.getTitleLandingPage().contains("GREEN"), false);

	}

	@When("^user searched with Shortname (.+) and extracted the actual name of the product$")
	public void user_searched_with_shortname_and_extracted_the_actual_name_of_the_product(String shortName) throws InterruptedException {
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetUp.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(landingPageProductName  + "is extracted from Home Page");
	}

	
	@And("^Added (.+) items of the selected product to cart$")
	public void Added_items_product(String quantity) {
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	
}
}
