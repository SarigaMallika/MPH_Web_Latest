package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Headerpage_positive_scenarios extends Generic_function {
	public static boolean value;

	/*TC 001 - Validate that the mpowered health logo in the header*/
	@Given("Site is available")
	public static void browser_launching () throws Exception {
		try {
			Browser_Launch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("Navigated to welcome screen")
	public void welcome_screen() throws Exception {
		login(6,7);
	}
	@Then("Check the mpowered health logo in the header")
	public static void check_logo() throws Exception {
		try {
			browser_explicit_wait("header_logo",5);
			value = driver.findElement(By.xpath(OR_reader("header_logo"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_check_logo");
		}		
	}

	/*TC 002 - Validate the navigation to the help page on clicking Help icon*/
	@When("Click on Help icon")
	public void click_help_icon() throws Exception {
		click("help");
		browser_wait(1000);
	}
	@Then("Verify navigation to the help page")
	public static void verify_navigation_to_help() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "header_frequently_asked"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_back();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_verify_navigation_to_help");
		} 
	}

	/*TC 003 -Validate the navigation to the alerts page on clicking Your alerts icon*/
	@When("Click on Your alerts icon")
	public void click_alerts_icon() throws Exception {
		browser_wait(1000);
		click("header_alerts");
	}
	@Then("Verify navigation to the alerts page")
	public static void verify_navigation_to_alerts() throws Exception {
		try {
			browser_explicit_wait("alerts_header",10);
			value = driver.findElement(By.xpath(OR_reader("alerts_header"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_verify_navigation_to_alerts");
		}
	}

	/*TC 004 -Validate the Drop down tab*/
	@When("Click on Drop down tab")
	public void click_dropDown() throws Exception {
		browser_explicit_wait("header_menu",10);
		click("header_menu");
	}
	@Then("Verify the drop down options")
	public static void verify_dropdown_options() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "header_profile"))).isDisplayed();
			click("header_profile");
			browser_wait(1000);
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_verify_dropdown_options");
		} 
	}

	/*TC 005 -Validate the navigation to the  profile page on clicking  Your profile tab*/
	@And("Click on  Your profile")
	public void click_your_profile() throws Exception {
		click("header_profile");
		browser_explicit_wait("your_profile_title",10);
	}
	@Then("Verify navigation to the profile page.")
	public static void verify_navigation_to_profile() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("your_profile_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_verify_navigation_to_profile");
		}
	}

	/*TC 006 -Validate  the  navigation to the ratings dashboard page on clicking Your ratings tab*/
	@And("Click on  Your ratings")
	public void clickOnYourRatings() throws Exception {
		click("header_ratings");
		browser_wait(4000);
	}
	@Then("Verify navigation to the ratings dashboard page.")
	public static void verify_navigation_to_ratings() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "your_ratings_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_verify_navigation_to_ratings");
		}		
	}

	/*TC 007 - Validate the navigation to the Feedback Port   page  on clicking Feedback*/
	@And("Click on  Feedback")
	public void click_feedback() throws Exception {
		browser_wait(1000);
		click("header_feedback");
		browser_wait(4000);
	}
	@Then("Verify the navigation to the Feedback Port.")
	public static void verify_navigation_to_feedback() throws Exception {
		try {
			browser_handle();
			value = driver.findElement(By.xpath(OR_reader("your_feedback_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_close();
			browser_switch();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_verify_navigation_to_feedback");
		}
	}

	/*TC 008 -Validate  the navigation to the Contact Us page  on clicking  Contact us*/
	@And("Click on  Contact Us")
	public void click_contactUs() throws Exception {
		browser_wait(1000);
		click("header_contact");
		browser_wait(4000);
	}
	@Then("Verify the navigation to the Contact Us.")
	public static void verify_navigation_to_contactus() throws Exception {
		try {
			browser_handle();
			value = driver.findElement(By.xpath(OR_reader( "contact_form"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_close();
			browser_switch();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_verify_navigation_to_contactus");
		}  
	}

	/*TC 009 - Validate the  Privacy Policy dialogue box on clicking on the Privacy Policy */
	@And("Click on  Privacy Policy")
	public void click_privacy_policy() throws Exception {
		browser_wait(4000);
		click("header_privacy");
		browser_wait(4000);
	}
	@Then("Verify the dialogue box on privacy page")
	public static void verify_dialoguebox_on_privacy_policy() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("privacy_ok"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("privacy_ok");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_verify_dialoguebox_on_privacy_policy");
		}		 
	}

	/*TC 010 -  Validate  the  Terms & Conditions dialogue box on clicking on the Terms & Conditions */
	@And("click on  Terms & Conditions")
	public void click_terms_conditions() throws Exception {
		browser_wait(3000);
		click("header_terms");
	}
	@Then("Verify the dialogue box on Terms and condition page")
	public static void verify_dialoguebox_on_terms() throws Exception {
		browser_explicit_wait("terms_ok",10);
		try {
			value = driver.findElement(By.xpath(OR_reader( "terms_ok"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("terms_ok");
			System.out.println("header positive");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_verify_dialoguebox_on_terms");
		}   
	}

	/*TC 011 -Validate the navigation to the Landing page on clicking Log out icon*/
	@When("Click on Log out icon")
	public void click_logout_icon() throws Exception {
		browser_wait(4000);
		click("logout");
	}
	@Then("Verify navigation to the Landing  page")
	public static void verify_navigation_to_landing() throws Exception {
		try {
			browser_explicit_wait("welcome_login",5);
			value = driver.findElement(By.xpath(OR_reader( "welcome_login"))).isDisplayed();
			Assert.assertEquals(true,value);
			driverquit();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("header_positive_verify_navigation_to_landing");
		}
	}

}