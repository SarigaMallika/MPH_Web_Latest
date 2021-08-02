package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Signup_negative_scenarios extends Generic_function{
	public static String str;

	/*TC_001 -Verify the scenario when entered invalid firstname and lastname*/
	@Given("Launch  URL and click on signup")
	public static void launch() throws Exception  {
		try {
			Browser_Launch();
			click("welcome_signup"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("Enter invalid 'Firstname' and 'Lastname' details")
	public static void invalid_details() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("signup_first_name"))).sendKeys(td_reader("signup_first_name",0));
			click("signup_last_name");
			str= driver.findElement(By.xpath(OR_reader("firstname_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_firstname_valid_msg"));
			driver.findElement(By.xpath(OR_reader("signup_last_name"))).sendKeys(td_reader("signup_last_name",0));
			click("signup_email_id");
			str= driver.findElement(By.xpath(OR_reader("lastname_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_lastname_valid_msg"));   
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_invalid_details");
		}
	}
	@Then("Verify the validation message")
	public static void refresh() throws Exception {
		browser_refresh();
	}

	/* TC_002 -Verify the scenario when entered invalid 'Email ID'*/
	@When("Enter invalid 'Email ID'")
	public static void invalid_email() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("signup_email_id"))).sendKeys(td_reader("signup_email_id",0));
			click("signup_phone_number");
			str= driver.findElement(By.xpath(OR_reader("emailid_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_email_invalid_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_invalid_email");
		}
	}

	/* TC_003 -Verify the scenario when blank 'Email ID' field*/
	@When("Enter 'Email ID' as blank")
	public static void blank_emailid() throws Exception  {
		try {
			click("signup_email_id");
			click("signup_phone_number");
			str = driver.findElement(By.xpath(OR_reader("emailid_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_email_blank_msg")); 
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_blank_emailid");
		}
	}

	/* TC_004 -Verify the scenario when entering less than 10 digits in the 'Phone number' field*/
	@When("Enter phone number with less than ten digits")
	public static void invalid_phoneno() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(td_reader("signup_phone_number",0));
			click("signup_password");
			str= driver.findElement(By.xpath(OR_reader("phonenumber_valid_msg"))).getText();
			Assert.assertEquals(str,"Phone number should be 10 digit number");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_invalid_phoneno");
		}
	}

	/* TC_005 -Verify the scenario when entering more than 10 digits in 'Phone number' field*/
	@When("Enter phone number with more than ten digits")
	public static void invalid_phone_no() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(td_reader("signup_phone_number",1));
			click("signup_password");
			str= driver.findElement(By.xpath(OR_reader("phonenumber_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_less_ten_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_invalid_phone_no");
		}
	}

	/* TC_006 -Verify the scenario when entering already registered phone number*/
	@When("Enter already registered phone number")
	public static void already_registered_no() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("signup_first_name"))).sendKeys(td_reader("signup_first_name",1));
			driver.findElement(By.xpath(OR_reader("signup_last_name"))).sendKeys(td_reader("signup_last_name",1));
			driver.findElement(By.xpath(OR_reader("signup_email_id"))).sendKeys(td_reader("signup_email_id",1));
			driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(td_reader("signup_phone_number",2));
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",0));
			driver.findElement(By.xpath(OR_reader("signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",1));
			click("signup_terms_and_conditions");
			click("signup");
			browser_wait(1000);
//			str= driver.findElement(By.xpath(OR_reader("phonenumber_valid_msg"))).getText();
//			Assert.assertEquals(str,td_reader("signup_exist_no_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_already_registered_no");
		}
	}

	/* TC_007 -Verify the scenario when blank 'Password' field*/
	@When("Enter 'Password' as blank")
	public static void blank_password() throws Exception  {
		try {
			click("signup_password");
			click("signup_confirm_password");
			str = driver.findElement(By.xpath(OR_reader("password_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_pass_blank_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_blank_password");
		}
	}

	/*TC_008 -Verify the scenario when password strength message and progress bar is displayed while entering password in 'Password' field */
	@When("Enter password")
	public static void enter_password() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			str= driver.findElement(By.xpath(OR_reader("passwordstrength_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_pass_stren_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_enter_password");
		}
	}

	/*TC_009 -Verify the scenario when entering different data in 'Password' and 'Confirm Password'*/
	@When("Enter password and confirm password data differently")
	public static void enter_different_passwords() throws Exception  {
		try {
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			driver.findElement(By.xpath(OR_reader("signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",0));
			click("signup_referral_code");
			str= driver.findElement(By.xpath(OR_reader("passwordmatch_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("signup_pass_match_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_enter_different_passwords");
		}
	}

	/*TC_010 -Verify the scenario when 'Sign Up' button is disabled  when 'Terms & Conditions' is unchecked*/
	@When("Check box is unchecked")
	public static void uncheck_the_checkbox() throws Exception  {
		try {
			Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup_terms_and_conditions"))).isSelected(),false);
			Assert.assertEquals(driver.findElement(By.xpath(OR_reader("signup"))).isEnabled(),true);
			System.out.println("signup negative");
			browser_close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_negative_uncheck_the_checkbox");
		}		
	}
}
