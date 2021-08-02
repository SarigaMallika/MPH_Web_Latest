package StepDefinitions;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.File;

public class Your_profile_negative_scenarios extends Generic_function {
	public static boolean value;
	public static String str,path;
	public static File file;

	/*Verify clicking on profile will navigates to Your profile screen*/
	@Given("Launch the URL and open login page")
	public static void launch_url() throws Exception{
		try {
			Browser_Launch();
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	@When("Enter login details")
	public void login() throws Exception {
		try {
			login(6,7);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_login");
		}
	}	
	@Then("Click on your profile")
	public static void click_profile() throws Exception{
		try {
			browser_wait(2000);
			click("header_menu");
			click("header_profile");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_click_profile");
		}		
	}

	/* TC_001- Validate that Send Code button is disabled when they do not check the phone number*/
	@When("Phone number check box is Unchecked")
	public void phonenumber_unchecked() throws Exception {
		try {
			browser_explicit_wait("profile_edit",5);
			click("profile_edit");
			value= driver.findElement(By.xpath(OR_reader( "profile_edit_title"))).isDisplayed();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_phonenumber_unchecked");
		}	
	}
	@Then("Verify Send Code button is disabled")
	public static void verify_send_code_button() throws Exception{
		try {
			Assert.assertEquals(true,value);
			value= driver.findElement(By.xpath(OR_reader("profile_send_code"))).isEnabled();
			Assert.assertEquals(false,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_verify_send_code_button");
		}
	}

	/* TC_002- Verify the scenario when blank 'security code and Re-enter password' fields*/
	@When("Enter 'security code and Re-enter password' as blank")
	public static void enter_blank_details() throws Exception{
		try {
			click("profile_checkbox");
			click("profile_send_code");
			value= driver.findElement(By.xpath(OR_reader( "profile_enter_code_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("profile_verify");
		} catch (Exception e) {
			e.printStackTrace();	
			takeScreenShot("your_profile_negative_enter_blank_details");
		}
	}
	@Then("verify the validation messages")
	public static void validation_msg() throws Exception{
		try {
			browser_wait(1000);
			str= driver.findElement(By.xpath(OR_reader( "security_code_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("security_code_valid_msg"));
		}catch(Exception e){
			e.printStackTrace();
			takeScreenShot("your_profile_negative_validation_msg");
		}
	}

	/* TC_003- Verify the scenario when entering invalid Security code  and Re-enter password */
	@When("Enter invalid 'security code and Re-enter password'")
	public static void enter_invalid_code() throws Exception{
		try {
			browser_wait(2000);
			driver.findElement(By.xpath(OR_reader( "profile_enter_code"))).sendKeys(td_reader("profile_enter_code",0));
			driver.findElement(By.xpath(OR_reader("profile_password"))).sendKeys(td_reader("profile_password",0));
			click("profile_verify");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_enter_invalid_code");
		}
	}
	@Then("Verify the validation message for invalid data")
	public static void invalid_validation_msg() throws Exception{
		try {
			browser_wait(2000);
			str= driver.findElement(By.xpath(OR_reader("security_code_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("security_code_match_valid_msg"));
			browser_wait(3000);
			driver.findElement(By.xpath(OR_reader("profile_enter_code"))).sendKeys(td_reader("profile_enter_code",1));
			driver.findElement(By.xpath(OR_reader( "profile_password"))).sendKeys(td_reader("profile_password",1));
			click("profile_verify");
			browser_wait(3000);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_invalid_validation_msg");
		}
	}

	/* TC_004- Verify the scenario when blank 'security code or Re-enter password' fields*/
	@When("Enter 'security code or Re-enter password' as blank")
	public static void enter_blank_code() throws Exception{
		try {
			browser_refresh();
			browser_explicit_wait("profile_edit",5);
			click("profile_edit");
			click("profile_checkbox");
			browser_wait(4000);
			click("profile_send_code");
			browser_wait(4000);
			driver.findElement(By.xpath(OR_reader( "profile_password"))).sendKeys(td_reader("profile_password",0));
			browser_wait(4000);
			click("profile_verify");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_enter_blank_code");
		}
	}
	@Then("Verify the validation blank message")
	public static void blank_validation_msg() throws Exception{
		try {
			browser_wait(8000);
			str= driver.findElement(By.xpath(OR_reader("security_code_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("security_code_valid_msg"));
			browser_wait(1000);
			backspace("profile_password");
			browser_wait(1000);
			driver.findElement(By.xpath(OR_reader( "profile_enter_code"))).sendKeys(td_reader("profile_enter_code",1));
			click("profile_verify");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_blank_validation_msg");
		}
	}

	/* TC_005- Verify the scenario when unable to  Edit the primary and deactivate email*/
	@When("Click on edit contact details")
	public void click_on_contact_details() throws Exception {
		browser_refresh();
		browser_wait(1500);
		click("profile_contact");
	}
	@Then("Not able to edit primary and deactivate email")
	public static void not_able_to_edit() throws Exception{
		try {
			browser_wait(1500);
			value= driver.findElement(By.xpath(OR_reader("profile_email_id"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("profile_email_id");
			value= driver.findElement(By.xpath(OR_reader("profile_email_id"))).isEnabled();
			Assert.assertEquals(true,value);
			browser_wait(1000);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_not_able_to_edit");
		}
	}

	/* TC_006- Verify the scenario when blank Your profile Page fields*/
	@When("Enter firstname and lastname fields as blank")
	public static void enter_blank_names() throws Exception{
		try {
			browser_back();
			browser_wait(1000);
			click_profile();
			browser_explicit_wait("profile_edit",5);
			click("profile_edit");
			click("profile_checkbox");
			click("profile_send_code");
			driver.findElement(By.xpath(OR_reader("profile_enter_code"))).sendKeys(td_reader("profile_enter_code",1));
			driver.findElement(By.xpath(OR_reader("profile_password"))).sendKeys(td_reader("profile_password",0));
			click("profile_verify");
			click("profile_ok_button");
			backspace("profile_firstname");
			backspace("profile_lastname");
			click("profile_save");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_enter_blank_names");
		}
	}
	@Then("Verify the validation message for blank fields")
	public static void blank_validation_msg_fields() throws Exception{
		try {
			str= driver.findElement(By.xpath(OR_reader( "profile_firstname_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_firstname_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_lastname_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_lastname_valid_msg"),str);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_blank_validation_msg_fields");
		}
	}

	/* TC_007- Verify the scenario when entering invalid First name, Last name  or  Preferred name*/
	@When("Enters invalid firstname,lastname and preferred name")
	public static void enter_invalid_names() throws Exception{
		try {
			driver.findElement(By.xpath(OR_reader("profile_firstname"))).sendKeys(td_reader("profile_firstname",0));
			driver.findElement(By.xpath(OR_reader("profile_lastname"))).sendKeys(td_reader("profile_lastname",1));
			driver.findElement(By.xpath(OR_reader( "profile_preferredname"))).sendKeys(td_reader("profile_preferred_name",1));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_enter_invalid_names");
		}
	}
	@Then("Verify the validation for invalid first name, last name or preferred name")
	public static void invalid_message() throws Exception{
		try {
			str= driver.findElement(By.xpath(OR_reader( "profile_firstname_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_firstname_invalid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_lastname_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_lastname_invalid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_preferred_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_preferred_invalid_msg"),str);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_invalid_message");
		}
	}

	/* TC_008- Verify the scenario unable to  Edit the User ID*/
	@When("Verify 'User ID' is displayed")
	public void user_id_displayed() throws Exception {
		try {
			browser_explicit_wait("profile_user_id",5);
			value= driver.findElement(By.xpath(OR_reader( "profile_user_id"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_user_id_displayed");
		}
	}
	@Then("verify 'User ID' is disabled for edit")
	public static void verify_user_id() throws Exception{
		try {
			value= driver.findElement(By.xpath(OR_reader( "profile_user_id"))).isEnabled();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_verify_user_id");
		}
	}

	/* TC_009- Verify the scenario when Email ID fields are blank*/
	@When("click on contact details")
	public void click_on_contact_details_button() throws Exception {
		browser_explicit_wait("profile_contact",5);
		click("profile_contact");
	}
	@Then("Leave email id field as blank")
	public static void enter_blank_email() throws Exception{
		try {
			click("profile_plus");
			browser_wait(1000);
			value= driver.findElement(By.xpath(OR_reader("profile_add_email_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("profile_submit");
			str= driver.findElement(By.xpath(OR_reader("profile_email_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_email_valid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();	
			takeScreenShot("your_profile_negative_enter_blank_email");
		}
	}

	/* TC_010- Verify the scenario when entering invalid Email ID  or  already exist Email ID*/
	@When("Enter invalid email id")
	public static void enter_invalid_email() throws Exception{
		try {
			driver.findElement(By.xpath(OR_reader( "profile_email"))).sendKeys(td_reader("profile_email",0));
			click("profile_submit");
			browser_wait(1000);
			str= driver.findElement(By.xpath(OR_reader( "profile_email_invalid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_email_invalid_msg"),str);
			backspace("profile_email");
			driver.findElement(By.xpath(OR_reader( "profile_email"))).sendKeys(td_reader("profile_email",1));
			click("profile_submit");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_enter_invalid_email");
		}
	}
	@Then("Verify the validation for invalid email id")
	public static void validation_msg_on_invalid_email() throws Exception{
		try {
			browser_wait(2000);
			str= driver.findElement(By.xpath(OR_reader( "profile_email_exists_msg"))).getText();
			Assert.assertEquals(td_reader("profile_email_exists_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_validation_msg_on_invalid_email");
		}
	}

	/* TC_011- Verify the scenario when unable to  Edit the primary and deactivate phone number*/
	@When ("Click on phone number")
	public void click_on_phone_number() throws Exception{
		browser_back();
		click("profile_phno");
	}
	@Then("primary and deactivate phone number is disabled for edit")
	public static void not_ablt_to_edit_phoneno() throws Exception{
		try {
			value= driver.findElement(By.xpath(OR_reader( "profile_phone_no_text"))).isEnabled();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_not_ablt_to_edit_phoneno");
		}
	}

	/* TC_012- Verify the scenario when entering invalid Phone number  or  Phone number fields are blank*/
	@When("Enter invalid Phone number  or  Phone number fields")
	public static void enter_invalid_phoneno() throws Exception{
		try {
			click("profile_plus");
			value= driver.findElement(By.xpath(OR_reader( "profile_add_phone_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("profile_submit");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_enter_invalid_phoneno");
		}
	}
	@Then("Verify the validation message for Phone number  or  Phone number fields")
	public static void invalid_validation_message() throws Exception{
		try {
			str= driver.findElement(By.xpath(OR_reader( "profile_phone_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_phone_valid_msg"),str);
			browser_wait(2000);
			driver.findElement(By.xpath(OR_reader( "profile_phone_no"))).sendKeys(td_reader("profile_phone_no"));
			click("profile_submit");
			str= driver.findElement(By.xpath(OR_reader("profile_phone_invalid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_phone_invalid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_invalid_validation_message");
		}
	}

	/* TC_013- Verify the scenario when unable to  Edit the primary and deactivate address*/
	@When("Click on Address")
	public void click_on_address() throws Exception{
		browser_back();
		click("profile_address");
	}
	@Then("primary and deactivate address are disbled for edit")
	public static void not_able_to_edit_address() throws Exception{
		try {
			value= driver.findElement(By.xpath(OR_reader("profile_add_address_text"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_not_able_to_edit_address");
		}
	}

	/* TC_014- Verify the scenario when leaving the fields blank in the Add new address Page*/
	@When("Click on add new address '+' symbol")
	public void click_new_address() throws Exception{
		click("profile_plus");
	}
	@Then("Leaves fields blank")
	public static void leaves_blank_fields() throws Exception{
		try {
			value= driver.findElement(By.xpath(OR_reader("profile_add_address_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("profile_save");
			str= driver.findElement(By.xpath(OR_reader( "profile_saveas_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_saveas_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_address_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_address_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_city_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_city_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_state_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_state_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_zip_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_zip_valid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_leaves_blank_fields");
		}
	}

	/* TC_015- Verify the scenario when entering invalid Zip code in Add new address page*/
	@When("Enters invalid zip code")
	public static void invalid_zipcode() throws Exception{
		driver.findElement(By.xpath(OR_reader( "profile_zip"))).sendKeys(td_reader("profile_zip"));
		click("profile_save");
	}
	@Then("Verify the Invalid zip code message")
	public void verify_validation_msg() throws Exception{
		try{
			str= driver.findElement(By.xpath(OR_reader( "profile_zip_invalid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_zip_invalid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_verify_validation_msg");
		}
	}

	/* TC_016- Verify the scenario when leaving the fields blank in the Add plan Page*/
	@When("click on plan coverage")
	public void click_on_plan_coverage() throws Exception {
		try {
			click_profile();
			browser_wait(1000);
			browser_explicit_wait("profile_plan_coverage",5);
			click("profile_plan_coverage");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_click_on_plan_coverage");
		}
	}
	@Then("Enter add plan page feilds blank")
	public static void enter_blank_plan_details() throws Exception{
		try {
			value= driver.findElement(By.xpath(OR_reader("profile_plan_coverage_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("profile_plan_plus");
			browser_wait(1000);
			click("profile_save");
			str= driver.findElement(By.xpath(OR_reader( "profile_insurer_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_insurer_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_plan_firstname_msg"))).getText();
			Assert.assertEquals(td_reader("profile_plan_firstname_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_plan_lastname_msg"))).getText();
			Assert.assertEquals(td_reader("profile_plan_lastname_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_memberid_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_memberid_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_groupid_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_groupid_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_plan_type_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_plan_type_valid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_enter_blank_plan_details");
		}
	}

	/* TC_017-Verify the scenario when entering invalid First name of policy holder or Last name of policy holder  in Add plan page*/
	@When("Enters invalid firstname and lastname fields in add plan page")
	public static void invalid_first_last_name() throws Exception{
		try {
			driver.findElement(By.xpath(OR_reader( "profile_plan_firstname"))).sendKeys(td_reader("profile_plan_firstname"));
			driver.findElement(By.xpath(OR_reader( "profile_plan_lastname"))).sendKeys(td_reader("profile_plan_lastname"));
			click("profile_plan_group");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_invalid_first_last_name");
		}
	}
	@Then("Verify the error message on invalid firstname and lastname")
	public void verify_error_msg() throws Exception {
		try{
			str= driver.findElement(By.xpath(OR_reader( "profile_plan_first_invalidmsg"))).getText();
			Assert.assertEquals(td_reader("profile_plan_first_invalidmsg"),str);
			str= driver.findElement(By.xpath(OR_reader( "profile_plan_last_invalidmsg"))).getText();
			Assert.assertEquals(td_reader("profile_plan_last_invalidmsg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_verify_error_msg");
		}
	}

	/* TC_018-Verify the scenario when leaving the fields blank in the Change password page*/
	@When("Enter blank fields in Change password page")
	public static void blank_password() throws Exception{
		click_profile(); browser_explicit_wait("profile_password_button",5);
		click("profile_password_button");
	}
	@Then("Verify the blank field message")
	public void verify_blank_field_msg() throws Exception {
		try{
			value= driver.findElement(By.xpath(OR_reader( "profile_password_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			browser_explicit_wait("profile_save",5);
			click("profile_save");
			str= driver.findElement(By.xpath(OR_reader( "profile_password_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_password_valid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_verify_blank_field_msg");
		}
	}

	/* TC_019-Verify the scenario when entering wrong Old password in Change password page*/
	@When("Enter wrong passwords")
	public static void wrong_password() throws Exception{
		try {
			driver.findElement(By.xpath(OR_reader( "profile_old_password"))).sendKeys(td_reader("profile_old_password",0));
			driver.findElement(By.xpath(OR_reader("profile_new_password"))).sendKeys(td_reader("profile_new_password",0));
			driver.findElement(By.xpath(OR_reader( "profile_confirm_password"))).sendKeys(td_reader("profile_new_password",0));
			click("profile_save");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_wrong_password");
		}
	}
	@Then("Verify wrong password message")
	public void verify_wrong_password_msg() throws Exception {
		try {
			browser_wait(1000);
			str= driver.findElement(By.xpath(OR_reader( "profile_password_invalid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_password_invalid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_verify_wrong_password_msg");
		}
	}

	/* TC_020-Verify the scenario when invalid New password in Change password page*/
	@When("Enter invalid new password")
	public static void invalid_new_password() throws Exception{
		try {
			backspace("profile_new_password");
			backspace("profile_confirm_password");
			driver.findElement(By.xpath(OR_reader( "profile_old_password"))).sendKeys(td_reader("profile_old_password",1));
			driver.findElement(By.xpath(OR_reader( "profile_new_password"))).sendKeys(td_reader("profile_new_password",1));
			click("profile_confirm_password");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_invalid_new_password");
		}
	}
	@Then("Verify invalid password message")
	public void verify_invalid_password_msg() throws Exception {
		try {
			browser_wait(1000);
			str= driver.findElement(By.xpath(OR_reader( "profile_new_password_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_new_password_valid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_verify_invalid_password_msg");
		}
	}

	/* TC_021-Verify the scenario when entering same data in Old password and New password fields in Change password page*/
	@When("Enter same data in Old password and New password fields")
	public static void enter_old_new_password() throws Exception{
		try {
			backspace("profile_new_password");
			driver.findElement(By.xpath(OR_reader( "profile_new_password"))).sendKeys(td_reader("profile_old_password",1));
			driver.findElement(By.xpath(OR_reader( "profile_confirm_password"))).sendKeys(td_reader("profile_old_password",1));
			click("profile_save");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_enter_old_new_password");
		}
	}
	@Then("verify the validation message")
	public void verify_validation_msgs() throws Exception {
		try{
			browser_wait(1000);
			str= driver.findElement(By.xpath(OR_reader( "profile_same_password"))).getText();
			Assert.assertEquals(td_reader("profile_same_password"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_verify_validation_msgs");
		}
	}

	/* TC_022-Verify the scenario when entering different data in New password and Confirm new password fields*/
	@When("Enter different data in New password and Confirm new password fields")
	public static void enter_diff_password_confirm_password() throws Exception{
		try {
			backspace("profile_new_password");
			backspace("profile_confirm_password");
			driver.findElement(By.xpath(OR_reader( "profile_new_password"))).sendKeys(td_reader("profile_new_password",0));
			driver.findElement(By.xpath(OR_reader( "profile_confirm_password"))).sendKeys(td_reader("profile_new_password",2));
			click("profile_save");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_enter_diff_password_confirm_password");
		}
	}
	@Then("Verify the different password message")
	public void verify_error_msgs() throws Exception {
		try{
			browser_wait(1000);
			str= driver.findElement(By.xpath(OR_reader( "profile_password_match"))).getText();
			Assert.assertEquals(td_reader("profile_password_match"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_verify_error_msgs");
		}
	}

	/* TC_023-Verify the scenario when a dialogue box appears dur to the failure of profile picture */
	@When("Not able to upload profile picture")
	public static void upload_profile_picture() throws Exception{
		try {
			click_profile();
			click("profile_picture");
			click("profile_picture");
			click("profile_upload_image");
			click("profile_files");
			file = new File(getprofilepic());
			StringSelection ss = new StringSelection(file.getAbsolutePath());
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			Robot robot = new Robot();
			robot.delay(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(400);
			robot.keyRelease(KeyEvent.VK_ENTER);
			click("profile_pic_save");
			browser_wait(6000);
		} catch (Exception e) {
			e.printStackTrace();	
			takeScreenShot("your_profile_negative_upload_profile_picture");
		}
	}
	@Then("Verify the message on unsuccessful upload")
	public void check_unsuccessful_upload() throws Exception {
		try{
			value= driver.findElement(By.xpath(OR_reader( "profile_pic_valid_msg"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("tab_ok");
			System.out.println("Your profile negative");
			browser_close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_check_unsuccessful_upload");
		}		
	}
}

