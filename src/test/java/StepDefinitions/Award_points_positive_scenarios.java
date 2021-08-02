package StepDefinitions;

import java.util.List;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Reusable_Functions.Generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Award_points_positive_scenarios extends Generic_function{
	public static boolean value;
	static WebElement ele;
	String ere;
	public static WebElement fr;
	static String str,text;
	static List<WebElement> grid_elements,drp_list;

	/*TC_001- Validate navigation to utility page*/
	@Given("user is landing page")
	public static void launch_url() throws Exception {
		Browser_Launch();
		browser_wait(8000);
	}
	@When("Navigate to Welcome screen")
	public static void Award_point_positive_welcome() throws Exception {
		try {
			login(9,5);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_welcome()");
		}
	}
	@Then("Click on 'Utilities'")
	public static void click_utilities() throws Exception {
		try {
			browser_wait(1000);
			click("utilities");
			browser_wait(1500);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_click_utilities");
		}
	}	
	
	//TC_002 - Validate Tile "Award Points"in the Utilities dashboard
	@When("Click on Award points tile")
	public void click_awardpoints() throws Exception {
		try {
		click("award_points");
		browser_wait(5000);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_click_awardpoints");
		}
	}
	@And("Validate Award points page")
	public static void validate_award_points() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("award_points_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_validate_award_points");
		}
	}
	@Then("User should be able to click on Award point tile and to Award points page successfully")
	public static void user_is_on_awardpoints_page()throws InterruptedException, Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "award_point_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader( "your_award_point_history"))).isDisplayed();
			Assert.assertEquals(true,value);
			WebDriverWait wait=new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(OR_reader("awardpoints_redeem_button")))));
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_user_is_on_awardpoints_page");
		}
	}

	/*TC 003 - Validate the Redeem points  in the Award points dashboard */
	@When("Click on the Redeem Points button")
	public void click_redeem_points_button() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "awardpoints_redeem_button"))).isEnabled();
			Assert.assertEquals(true,value);
		browser_explicit_wait("awardpoints_redeem_button",10);
		Actions builder=new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath(OR_reader("awardpoints_redeem_button"))));
		builder.click(driver.findElement(By.xpath(OR_reader("awardpoints_redeem_button"))));
		Action action= builder.build();
		action.perform();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_click_redeem_points_button");
		}
	}
	@Then("Validate the redeem award points page")
	public void validate_the_Redeem_AwardPoints() throws Exception {
		try {
			browser_wait(10000);
			value = driver.findElement(By.xpath(OR_reader( "redeem_award_points_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader( "available_award_point"))).isDisplayed();
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_validate_the_Redeem_AwardPoints");
		}
	}

	/*TC 004 - Validate the navigation to the redeemed page   */
	@When("Navigate to the redeem page")
	public void navigate_redeem_page() throws Exception {
		browser_wait(2000);
		browser_back();
	}
	@Then("Validate the redeem page")
	public static void validate_the_redeem_page() throws Exception {
		try {
						/*value = driver.findElement(By.xpath(OR_reader( "redeemed_title"))).isDisplayed();
						Assert.assertEquals(true,value);
					        browser_wait(20);
						value = driver.findElement(By.xpath(OR_reader( "redeemed_points"))).isDisplayed();
						Assert.assertEquals(true,value);
						value = driver.findElement(By.xpath(OR_reader( "availed_gift"))).isDisplayed();
						Assert.assertEquals(true,value);
						click("goto_dashboard_button");
						value = driver.findElement(By.xpath(OR_reader( "your_award_point_history"))).isDisplayed();
						Assert.assertEquals(true,value);*/
			click("logout");
			System.out.println("Award points positive"); 
			browser_close();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_validate_the_redeem_page");
		}
	}
}
