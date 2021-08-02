package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Refer_a_friend_positive_scenarios extends Generic_function{
	public static boolean value;
	public static WebElement from,to;

	/*TC 001 - Validate that user must be able to view Refer a Friend under Home page*/
	@Given("Browser is open")	
	public  void browser_launching() throws Exception  {
		try {
			Browser_Launch();
			browser_wait(12);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("Login with valid data")
	public void login_with_valid_data() throws Exception {
		try {
		login(6,7);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_friend_positive_login_with_valid_data");
		}
	}	
	@Then("verify Tell your friends about Mpowered Health text and logo is displayed")
	public static void verify_logo() throws Exception   {
		try {
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader("refer_a_frnd_home_logo"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader( "refer_a_frnd_home_text"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_friend_positive_verify_logo");
		}
	}

	/*TC 002 - Validate that user must be able to click on Refer a Friend button displayed in the home page*/
	@When("clicks on Refer a Friend")
	public static void click_refer_friend() throws Exception   {
		try {
			click("refer_a_frnd_home_button");		
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_friend_positive_click_refer_friend");
		}
	}
	@Then("navigated to Refer a Friend landing page")
	public void navigate_to_refer_a_friend_page() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "refer_a_frnd_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_refresh();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_friend_positive_navigate_to_refer_a_friend_page");
		}
	}

	/*TC 003 - Validate that user must be able to view the referral code text*/
	@Given("verify referal code text is displayed")
	public static void verify_referal_code() throws Exception   {
		try {
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader("refer_a_frnd_referral_code"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_friend_positive_verify_referal_code");
		}
	}

	/*TC 004 - Validate that the user should able to see a Pop Up box when clicking on Share a link */
	@When("clicks on 'Share Link' button")
	public static void clicks_on_share_link() throws Exception{
		try {
			click("refer_a_frnd_share_link_button");	
			browser_wait(1000);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_friend_positive_clicks_on_share_link");
		}
	}

	/*TC 005 - Validate that the user should able to copy the link */
	@Then("clicks on copy the link")
	public static void clicks_on_copy_the_link() throws Exception   {
		try {
			Actions act = new Actions(driver);			  
			act.sendKeys(Keys.TAB).build().perform();
			act.sendKeys(Keys.TAB).build().perform();
			act.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_friend_positive_clicks_on_copy_the_link");
		}
	}

	/*TC 006 - Validate that user can view How its works*/
	@Given("verify How it work text is displayed")
	public static void verify_text() throws Exception   {
		try {
			value = driver.findElement(By.xpath(OR_reader("refer_a_frnd_howits_work"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_friend_positive_verify_text");
		}
	}

	/*TC 007 -Validate that user can view the text Invite your friends to Mpowered Health by sharing your unique invitation code*/
	@When("verify Invite your friends to Mpowered Health is displayed")
	public static void first_grid_text_checker() throws Exception   {
		try {
			value = driver.findElement(By.xpath(OR_reader( "refer_a_frnd_first_grid_text"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_friend_positive_first_grid_text_checker");
		}
	}

	/*TC 008 -Validate that user can able to slide the two grids visible under How its works*/
	@When("clicks to slide the grid")
	public static void grid_slideer() throws Exception   {
		try {
			from = driver.findElement(By.xpath(OR_reader( "refer_a_frnd_carousal_from")));
			to = driver.findElement(By.xpath(OR_reader("refer_a_frnd_carousal_to")));
			Actions action = new Actions(driver);
			action.dragAndDrop(from, to).perform();			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_friend_positive_grid_slideer");
		}
	}
	@Then("navigated to next slide")
	public static void nextslide() throws Exception   {
		try {
			value = driver.findElement(By.xpath(OR_reader("refer_a_frnd_carousal_from"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_friend_positive_nextslide");
		}
	}

	/*TC 009 -  Validate that user can able to click on the link More information & FAQ and it will navigated to Frequently asked questions page*/
	@When("clicks on the link More information & FAQ")
	public static void clicks_on_more_info() throws Exception   {
		try {
			click("refer_a_frnd_faq_link");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_friend_positive_clicks_on_more_info");
		}
	}

	/*TC 010 - Validate that the user should able to view list of frequently asked questions inside Frequently asked questions page*/
	@Given("verify list of Frequently asked questions")
	public static void verify_faq() throws Exception   {
		try {
			value = driver.findElement(By.xpath(OR_reader("header_frequently_asked"))).isDisplayed();
			Assert.assertEquals(true,value);
			System.out.println("Refer a friend positive");
			browser_close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("refer_a_friend_positive_verify_faq");
		}
	}
}