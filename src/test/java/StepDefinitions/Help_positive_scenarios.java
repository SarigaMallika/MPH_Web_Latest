package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Help_positive_scenarios extends Generic_function{
	public static boolean value;

	/*TC 001 - Validate that the Frequently asked questions title  should be present in  Help page*/
	@Given("site is available")
	public void browser_launching() throws Exception {
		try {
			Browser_Launch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	@When("clicks on Help tab")
	public void click_help() throws Exception {
		try {
		login(6,7);
		browser_wait(1000);
		value = driver.findElement(By.xpath(OR_reader("header_logo"))).isDisplayed();
		Assert.assertEquals(true,value);
		browser_wait(1000);
		click("help");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_click_help");
		}		
	}
	@Then("verify the Frequently asked questions title")
	public void verify_faq_title() throws Exception {
		try {
			browser_wait(5000);
			value = driver.findElement(By.xpath(OR_reader("header_frequently_asked"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_verify_faq_title");
		}		
	}

	/*TC 002 - Validate that the 'Second Opinions' title  should be present  and able to see description , when user click on Second Opinions title */
	@When("clicks on Second Opinions title")
	public void click_second_opinion() throws Exception {
		try {
			browser_wait(3000);
			click("help_secondassert");
			browser_wait(5000);
			value = driver.findElement(By.xpath(OR_reader( "help_secondabout"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_click_second_opinion");
		}
	}
	@Then("verify the Second Opinions description is displayed")
	public void verify_second_opinion_description() throws Exception {
		try {
			browser_wait(5000);
			value = driver.findElement(By.xpath(OR_reader("help_secondassert"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_verify_second_opinion_description");
		}
	}
	
	/*TC 003 - Validate that the 'Award Points' title  should be present  and able to see description , when user click on Award Points title  */
	@When("clicks on Award Points title")
	public void click_award_points() throws Exception {
		try {
			click("help_awardpoints");
			browser_wait(6000);
			value = driver.findElement(By.xpath(OR_reader("help_awardpointsabout"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_click_award_points");
		}
	}
	@Then("verify the Award Points description is displayed")
	public void verify_award_points_description() throws Exception {
		try {
			browser_wait(6000);
			value = driver.findElement(By.xpath(OR_reader("help_awardpoints"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_verify_award_points_description");
		}
	}

	/*TC 004 - Validate that the 'Referral' title  should be present  and able to see description , when user click on Referral title   */
	@When("clicks on Referral title")
	public void click_referral_title() throws Exception {
		try {
			click("help_referralassert");
			browser_wait(5000);
			browser_explicit_wait("help_referralabout",5);
			value = driver.findElement(By.xpath(OR_reader("help_referralabout"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_click_referral_title");
		}
	}
	@Then("verify the Referral description is displayed")
	public void verify_referral_description() throws Exception {
		try {
			browser_wait(3000);
			value = driver.findElement(By.xpath(OR_reader("help_referralassert"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_verify_referral_description");
		}
	}
	
	/*TC 005 - Validate that the 'Profile' title  should be present  and able to see description , when user click on Profile title  */
	@When("clicks on Profile title")
	public void click_profile_title() throws Exception {
		try {
			browser_wait(3000);
			click("help_profileassert");
			browser_wait(3000);
			value = driver.findElement(By.xpath(OR_reader("help_profileabout"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_click_profile_title");
		}
	}
	@Then("verify the Profile description is displayed")
	public void verify_profile_description() throws Exception {
		try {
			browser_wait(3000);
			value = driver.findElement(By.xpath(OR_reader( "help_profileassert"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_verify_profile_description");
		}
	}

	/*TC 006 - Validate that the 'Payments' title  should be present  and able to see description , when user click on Payments title  */
	@When("clicks on Payments  title")
	public void click_payments_title() throws Exception {
		try {
			browser_wait(2000);
			click("help_paymentassert");
			browser_explicit_wait("help_paymentabout",5);
			value = driver.findElement(By.xpath(OR_reader( "help_paymentabout"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_click_payments_title");
		}
	}
	@Then("verify the Payments description is displayed")
	public void verify_payments_description() throws Exception {
		try {
			browser_wait(3000);
			scrolldown();
			browser_wait(2000);
			value = driver.findElement(By.xpath(OR_reader("help_paymentassert"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_verify_payments_description");
		}
	}

	/*TC 007 - Validate that the 'Add coverage' title  should be present  and able to see description , when user click on Add coverage title   */
	@When("clicks on Add coverage  title")
	public void click_addcoverage_title() throws Exception {
		try {
			browser_wait(4000);
			click("help_coverageassert");
			browser_explicit_wait("help_coverageabout",5);
			value = driver.findElement(By.xpath(OR_reader( "help_coverageabout"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_click_addcoverage_title");
		}
	}
	@Then("verify the Add coverage description is displayed")
	public void verify_add_coverage_description() throws Exception {
		try {
			browser_wait(2000);
			value = driver.findElement(By.xpath(OR_reader( "help_coverageassert"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("logout");
			System.out.println("Help positive");
			driverquit();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_verify_add_coverage_description");
		}		
	}
}