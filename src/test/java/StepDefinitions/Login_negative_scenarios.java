package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_negative_scenarios extends Generic_function {
	public static String str1,str2="";
	public static String valid_msg="";
	public static String end_case="";

	/*TC_001 - Validate that the user is not allowed to login when Phone number and Password fields are blank*/
	@Given("launch URL and clicks on login button")
	public static void browser_launching() throws Exception {
		Browser_Launch();
		click("welcome_login");
		browser_wait(1000);
		click("login");
	}	
	@Then("verify validation message")
	public static void verify_validation_msg() throws Exception {
		try {
     		browser_wait(1000);
			str1= driver.findElement(By.xpath(OR_reader("login_validate_msg"))).getAttribute("oninvalid");
			valid_msg=str1.substring(24,49);
			Assert.assertEquals(valid_msg,Generic_function.td_reader("login_validate_msg",0));
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_verify_validation_msg");
		}
	}

	/*TC_002 - Validate that the user should get a validation message on entering invalid credentials in the 'Login' Page*/
	@When("enters invalid phone no and password")
	public void enters_invalid_phoneno_and_password() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",0));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",0));
			click("login");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_enters_invalid_phoneno_and_password");
		}
	}
	@Then("validation message is displayed")
	public static void validation_msg() throws Exception {
		try {
			browser_refresh();
			str1= driver.findElement(By.xpath(OR_reader("login_negative_validate_msg"))).getText();
			Assert.assertEquals(str1.substring(2),td_reader("login_negative_validate_msg"));
			if(end_case=="True"||end_case=="False") {
				browser_close();
			}
		} catch (Exception e) {
			e.printStackTrace();	
			takeScreenShot("login_negative_validation_msg");
		}
	}

	/*TC_003 - Validate that user is not allowed to enter more than 10 digits in the 'Phone number' field */
	@When("enters phone no with more than ten digits")
	public void enters_invalid_phoneno() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",1));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",1));
			click("login");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_enters_invalid_phoneno");
		}
	}	

	/*TC_004 - Validate that the user is not allowed to login with invalid 'Phone number' and valid 'Password' */
	@When("enters invalid phone no and valid password")
	public static void enters_invalid_phoneno_and_valid_password() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(Generic_function.td_reader("login_phone_number",2));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(Generic_function.td_reader("login_password",2));
			click("login");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_enters_invalid_phoneno_and_valid_password");
		}
	}

	/*TC_005 - Validate that the user is not allowed to login with invalid Password and valid phone number */
	@When("enters invalid password and valid phone no")
	public static void enters_invalid_password() throws InterruptedException, Exception {
		try {
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(Generic_function.td_reader("login_phone_number",3));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(Generic_function.td_reader("login_password",3));
			click("login");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_enters_invalid_password");
		}
	}

	/*TC_006 - Validate that user is not able to login on leaving 'Phone number' field blank and only giving valid 'Password' */
	@When("enters phone no as  blank field")
	public static void enters_blank_phoneno() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(Generic_function.td_reader("login_password",4));
			click("login");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_enters_blank_phoneno");
		}
	}

	/*TC_007 - Validate that user is not able to login on leaving 'Password' field blank and only giving valid 'Phone number' */
	@When("enters password as  blank field")
	public static void enters_blank_password() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(Generic_function.td_reader("login_phone_number",4));
			click("login");
			end_case="True";
			System.out.println("login negative");
		}catch(Exception e) {
			e.printStackTrace();
			end_case="False";	
			takeScreenShot("login_negative_enters_blank_password");
		}
	}
}