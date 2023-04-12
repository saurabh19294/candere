package jewellery.stepdefs;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.WebDriverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {

	private static final Logger logger = LogManager.getLogger(StepDefs.class);
	By clickProduct = By.xpath("//div[text()='Majestic Solitaire Diamond Ring']");
	Scenario scn;
	WebDriver driver;
	WebDriverWait wait;
	String base_url = "https://www.candere.com";
	int implicit_wait_timeout_in_sec = 20;

	@Before
	public void setup(Scenario snc) throws Exception {
		this.scn = snc;
		String browserName=WebDriverfactory.getBrowserName();
		driver=WebDriverfactory.getWebDriverForBrowser(browserName);
		wait = new WebDriverWait(driver, implicit_wait_timeout_in_sec);

	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("User navigate for a landing page")
	public void and_user_navigate_for_a_landing_page() {
		driver.get(base_url);
		logger.info("Browser invoked with url");
	}

	@Then("validate the landing page")
	public void validate_the_landing_page() {
		String expected = "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store";
		String actual = driver.getTitle();
		Assert.assertEquals("Page Title validation", expected, actual);
		logger.info("Assertion page validate is passed with expected as -> " + expected + " and actual is" + actual);
		scn.log("and user navigate for a landing page");
	}

	@When("user search a a product {string}")
	public void user_search_a_a_product(String productName) {
		WebElement elementSearchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
		logger.info("waiting for the webelement ");
		elementSearchBox.sendKeys(productName);
		logger.info("sending keys to web element");
	}

	@When("User select and click the product name in the landing page")
	public void user_select_and_click_the_product_name_in_the_landing_page() {
		WebElement Selectproduct = wait.until(ExpectedConditions.elementToBeClickable(clickProduct));
		Selectproduct.click();
		
	}

	@Then("validate the product discription")
	public void validate_the_product_discription() {
		WebElement actual=driver.findElement(By.xpath("//h1//span[text()='Majestic Solitaire Diamond Ring']"));
		
		String expected = "Majestic Solitaire Diamond Ring";
		//String actual=driver.getTitle();
		Assert.assertEquals("Page Title validation", expected, actual.getText());
		logger.info("Assertion page validate is passed with expected as -> " + expected + " and actual is" + actual.getText());
		scn.log("and user navigate for a landing page");
	}
	
	@Then("User Select ring size")
	public void user_select_ring_size() {
	    WebElement selectringsize =driver.findElement(By.xpath("//select[@class='type_select']"));
	    Select sc=new Select(selectringsize);
	    sc.selectByVisibleText("18");	
	}
	

	@Then("Validate the Price Update")
	public void validate_the_price_update() {
		String expected="Price updated";
		WebElement actual =wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[text()='Price updated']"))));
	   Assert.assertEquals(expected,actual.getText());
	   
	}
	
	@When("Scroll down the landing page")
	public void scroll_down_the_landing_page() {
		WebElement AboutUs = driver.findElement(By.xpath("//p[text()='ABOUT US']"));
	    JavascriptExecutor js= (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true)", AboutUs);
	}
	
	@When("validate aboutus section of the landing page")
	public void validate_aboutus_section_of_the_landing_page(List<String> AboutUs_List) {
	   List<WebElement> aboustus = driver.findElements(By.xpath("//div[@class='flex_group_item'][1]//a"));
	   for (int i = 0; i <AboutUs_List.size(); i++) {
		   if (AboutUs_List.get(i).equalsIgnoreCase(aboustus.get(i).getText())) {
			   Assert.assertTrue(true);
			 scn.log("Expected: "+AboutUs_List.get(i)+" Actual: "+aboustus.get(i).getText());
			   } 
		   else {
			   Assert.fail();

		}
	   }
		
	}

	
	
	@When("user select fb button")
	public void user_select_fb_button() {

//		WebElement fbtn = driver.findElement(By.xpath("//a[@class='social_icons__ fb']"));
//		fbtn.click();
//		driver.get("https://www.facebook.com/canderejewellery");
//		logger.info("Browser invoked with url");
//		String expected = "Candere by Kalyan Jewellers";
//		String actual = driver.getTitle();
//		Assert.assertEquals("Page Title validation", expected, actual);
//		logger.info("Assertion page validate is passed with expected as -> " + expected + " and actual is" + actual);
//		scn.log("and user navigate for a landing page");
	}

}