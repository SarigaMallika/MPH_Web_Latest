package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Utilities_negative_scenarios  extends Generic_function{
	static boolean value;
	static String balance,text,ere,str;
	static WebElement ele;

	/* TC_001 -Navigate to Utilities screen*/
	@Given("User is on home page")
	public void launch_url() throws Exception {
		try {
			Browser_Launch();
			login(10,10);
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader("logout"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_launch_url");
		}		
	}	
	@When("Clicks on Utilities tab")
	public static void click_on_utilities_tab() throws Exception {
		try {
			click("utilities");
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader("wallet"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_click_on_utilities_tab");
		}	
	}

	/* TC_002 -Verify the scenario when 'Add Card' fields is blank*/
	@When("Leave Add card field as blank")
	public void enter_blank_card_details() throws IOException {
		try{
			click("wallet");
			browser_wait(1000);
			browser_explicit_wait("utilities_add_card",5);
			click_javascript("utilities_add_card");
			browser_explicit_wait("utilities_save_button",5);
			click("utilities_save_button");
			browser_wait(1000);
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_enter_blank_card_details");
		}	
	}
	@Then("Verify the message on leaving Add Card fields as blank")
	public void verify_blank_card_details_msg() throws Exception {
		try{
			str= driver.findElement(By.xpath(OR_reader("utilities_save_as_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_save_as_valid_msg"));
			str= driver.findElement(By.xpath(OR_reader("utilities_name_on_card_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_name_on_card_valid_msg")); 
			str= driver.findElement(By.xpath(OR_reader("utilities_zip_code_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_zip_code_valid_msg")); 
			str= driver.findElement(By.xpath(OR_reader("utilities_phone_number_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_phone_number_valid_msg"));   
			str= driver.findElement(By.xpath(OR_reader("utilities_address_valid_msg"))).getText(); 
			Assert.assertEquals(str,td_reader("utilities_address_valid_msg")); 
			str= driver.findElement(By.xpath(OR_reader("utilities_country_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_country_valid_msg")); 
			str= driver.findElement(By.xpath(OR_reader("utilities_state_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_state_valid_msg")); 
			str= driver.findElement(By.xpath(OR_reader("utilities_city_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_city_valid_msg"));
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_verify_blank_card_details_msg");
		}	
	}

	/* TC_003 -Verify the message on entering invalid details in the Add Card page*/
	@When("Enter invalid card details")
	public static void enter_invalid_card_details() throws Exception {
		try {
			browser_wait(1000);
			click_javascript("utilities");
			click_javascript("wallet");
			browser_wait(1000);
			click_javascript("utilities_add_card");
			driver.findElement(By.xpath(OR_reader("utilities_save_as"))).sendKeys(td_reader("utilities_save_as"));
			driver.findElement(By.xpath(OR_reader("utilities_name_on_card"))).sendKeys(td_reader("utilities_name_on_card"));
			browser_wait(9000);
			Robot robot = new Robot();
			browser_wait(4000);
			robot.keyPress(KeyEvent.VK_TAB);
			browser_wait(1000);
			robot.keyPress(KeyEvent.VK_NUMPAD4);
			robot.keyPress(KeyEvent.VK_NUMPAD2);
			robot.keyPress(KeyEvent.VK_NUMPAD4);
			robot.keyPress(KeyEvent.VK_NUMPAD2);
			robot.keyPress(KeyEvent.VK_TAB);
			browser_wait(4000);
			robot.keyPress(KeyEvent.VK_NUMPAD1);
			robot.keyPress(KeyEvent.VK_NUMPAD2);
			robot.keyPress(KeyEvent.VK_BACK_SLASH);
			robot.keyPress(KeyEvent.VK_TAB); 
			browser_wait(4000);
			robot.keyPress(KeyEvent.VK_NUMPAD1);
			robot.keyPress(KeyEvent.VK_NUMPAD2);
			driver.findElement(By.xpath(OR_reader("utilities_zip_code"))).sendKeys(td_reader("utilities_zip_code",1));
			driver.findElement(By.xpath(OR_reader("utilities_phone_number"))).sendKeys(td_reader("utilities_phone_number",1));
			driver.findElement(By.xpath(OR_reader("utilities_address"))).sendKeys(td_reader("utilities_address")); 			
			browser_wait(1000);
			click_javascript("utilities_save_button");
		}catch (Exception e) {
			takeScreenShot("utilities_negative_enter_invalid_card_details");
		}	
	}
	@Then("Verify the message on entering invalid Card details")
	public static void check_validation_msg() throws Exception {
		try {
			//put assertions here
		}catch (Exception e) {
			takeScreenShot("utilities_negative_check_validation_msg");

		}
	}

	/*TC_004- Verify the scenario when 'Add Bank' fields is blank*/
	@When("Leave Add Bank field as blank")
	public static void enter_blank_bank_details() throws Exception {
		try {
			browser_wait(1000);
			click_javascript("utilities");
			click_javascript("wallet");
			browser_wait(1000);
			click_javascript("utilities_add_bank");
			click("utilities_bank_saveas");
			click("utilities_account_name");
			click("utilities_routing_no");
			click("utilities_account_number");
			click("utilities_routing_no");	
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_enter_blank_bank_details");
		}	
	}
	@Then("Verify the message on leaving Add Bank fields as blank")
	public static void verify_validation_message() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("utilities_bank_save_as_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_save_as_valid_msg"));  
			str= driver.findElement(By.xpath(OR_reader("utilities_bank_account_holder_name_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_account_holder_name_valid_msg"));   
			str= driver.findElement(By.xpath(OR_reader("utilities_bank_routing_no_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_routing_no_valid_msg"));   
			str= driver.findElement(By.xpath(OR_reader("utilities_bank_account_no_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_account_no_valid_msg"));  
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_verify_validation_message");
		}	
	}

	/* TC_005 - Verify the message on entering invalid details in the 'Add Bank' page*/
	@When("Enter invalid bank details")
	public static void enter_invalid_details() throws Exception {
		try {
			browser_wait(1000);
			click_javascript("utilities");
			click_javascript("wallet");
			click_javascript("utilities_add_bank");
			driver.findElement(By.xpath(OR_reader("utilities_bank_saveas"))).sendKeys(td_reader("utilities_bank_saveas"));
			driver.findElement(By.xpath(OR_reader("utilities_account_name"))).sendKeys(td_reader("utilities_account_name",1));
			browser_wait(1000);
			click("utilities_routing_no");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_enter_invalid_details");
		}	
	}
	@Then("Verify the message on entering invalid bank details")
	public static void verify_validation_msg() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("utilities_bank_account_holder_name_invalid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_account_holder_name_invalid_msg"));  
			browser_wait(1000);
			driver.findElement(By.xpath(OR_reader("utilities_routing_no"))).sendKeys(td_reader("utilities_routing_no",1));
			click("utilities_account_type");
			str= driver.findElement(By.xpath(OR_reader("utilities_bank_routing_no_invalid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_routing_no_invalid_msg"));  
			text = td_reader("utilities_account_type");
			drop_down(OR_reader( "utilities_account_type_list"),text);  
			browser_wait(2000);
			driver.findElement(By.xpath(OR_reader("utilities_account_number"))).sendKeys(td_reader("utilities_account_number",1));
			browser_wait(2000);
			click("utilities_routing_no");
			str= driver.findElement(By.xpath(OR_reader("utilities_bank_account_no_invalid_msg"))).getText();
			Assert.assertEquals(str,td_reader("utilities_bank_account_no_invalid_msg"));  
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_verify_validation_msg");
		}	
	}

	/* TC_006 - Verify the redeem button when the balance is less than 2000 */
	@When ("Verify the redeem button is disabled")
	public static void verify_redeem_button() throws Exception{
		try {
			click_javascript("utilities");
			browser_wait(2000);
			click_javascript("award_points");
			value=driver.findElement(By.xpath(OR_reader("awardpoints_redeem_button"))).isEnabled();
			Assert.assertEquals(value,true); 
			System.out.println("Utilities negative");
			browser_close();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_verify_redeem_button");
		}	
	}

}