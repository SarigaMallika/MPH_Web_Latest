package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Services_positive_scenarios extends Generic_function {
	static boolean value;

	/*TC_001 Validate that the user is able to login with valid credentials*/	
	@Given("Open the Browser")
	public void services_page_positive_tc_001() throws Exception {
		try {
			Browser_Launch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	@When("clicks on the 'Login'")
	public void click_login_button() throws Exception {
		try {
			login(6,7);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("services_positive_click_login_button");
		}
	}
	@Then("Navigate to the login page")
	public void navigate_to_login() throws Exception {
		try {
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader( "logout"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("services_positive_navigate_to_login");
		}
	}

	/*TC_002  Validate that the user is able to click on the Services tab */	
	@When("clicks on the 'Services' tab")
	public static void click_on_services() throws Exception{
		try {
			browser_wait(1000);
			click("services");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			takeScreenShot("services_positive_click_on_services");
		}
	}
	@Then("Navigate to the Services pages")
	public static void navigate_to_services() throws Exception{
		try {
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader("logout"))).isDisplayed();
			Assert.assertEquals(true,value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			takeScreenShot("services_positive_navigate_to_services");
		}
	}

	/*TC_003 Validate that the user is able to click on the grid tiles*/
	@When("click on all the grid tiles")
	public void click_on_all_tiles() throws Exception {
		try {
			grid_tile(OR_reader("grid_path"));
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader( "logout"))).isDisplayed();
			Assert.assertEquals(true,value);
			System.out.println("services positive");
			browser_close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			takeScreenShot("services_positive_click_on_all_tiles");
		}		
	}
}