package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Homepage_positive_scenarios extends Generic_function {
	public static boolean value;
	WebElement ele;
	String ere;
	
	/*TC_001 -Validate that the user is navigated to Welcome page*/
	@Given("Welcome page is available")
	public static void browser_is_open() {
		try {
			Browser_Launch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	/*Login with valid data*/
	@Then("Enter valid phonenumber and password. Click on login button")
	public void login_valid_data() throws Exception {
		try {
			login(7,8);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("er and password. Click on login button\")\n"
					+ "	public void ");
		}
	}
	
	/*TC_002 - Validate that the user is navigated to  the Home page and User should be able to click on all the grid tiles */
	@When("clicks on all the grid tiles")
	public static void clicks_on_all_tiles() throws Exception, InterruptedException {
		try {
			grid_tiles(OR_reader("grid_path"));
			browser_wait(1000);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_clicks_on_all_tiles");
		}
	}
	
	/*TC_003 -Validate that the user is navigated to the Second Opinion page on clicking 'Request for second opinion' button*/
	@When("clicks on the 'Request for second opinion' button")
	public void clicks_on_request_second_opinion() throws InterruptedException, Exception {
		try {
			click("request_second_opinion_button");
			browser_wait(1000);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_clicks_on_request_second_opinion");
		}
	}
	@Then("navigated to the Second opinion page")
	public void navigate_to_second_opinion_page() throws Exception {
		try {
			value1=driver.findElement(By.xpath(OR_reader( "request_second_opinion_title"))).isDisplayed();
			Assert.assertEquals(true,value1);
			browser_wait(1500);
			browser_back();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_navigate_to_second_opinion_page");
		}
	}

	/*TC_004-Validate that the user is navigated to the  Refer a friend page on clicking 'Refer a friend' button*/
	@When("clicks on 'Refer a friend' button")
	public static void clicks_on_refer_a_friend() throws InterruptedException, Exception {
		try {
			click("refer_a_friend_button");
			browser_wait(1500);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_clicks_on_refer_a_friend");
		}				
	}
	@Then("navigated to the Refer a friend page")
	public void navigated_to_refer_a_friend_page() throws Exception {

		try {
			value1=driver.findElement(By.xpath(OR_reader("refer_a_friend_title"))).isDisplayed();
			Assert.assertEquals(true,value1);
			browser_wait(1000);
			System.out.println("home positive");
			browser_close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("home_positive_navigated_to_refer_a_friend_page");
		}		
	}
}
