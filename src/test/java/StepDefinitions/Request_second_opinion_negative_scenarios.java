package StepDefinitions;

import Reusable_Functions.Generic_function;
import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Request_second_opinion_negative_scenarios extends Generic_function{
	public static boolean value;
	public static WebElement ele,fr;
	public static String ere,str;
	public static File file;

	// Validate that the user is navigated to Welcome page
	@Given("Browser opens and opens the URL")
	public void browser_launching() {
		try {
			Browser_Launch();
			browser_wait(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("User enters the valid phonenumber and password.Clicks on Login button")
	public static void clicks_on_welcome_login() throws Exception {
		try {
			login(5,6);
			browser_wait(1000);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_clicks_on_welcome_login");
		}
	}

	// Validate that the user is able to click on 'Request for a Second opinion' button
	@When("clicks on 'Request for second opinion' button")
	public static void click_on_request_second_opinion() throws IOException {
		try {
			click("request_second_opinion_button");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_click_on_request_second_opinion");
		}
	}
	@Then("navigated to the second opinion page")
	public static void navigate_to_second_opinion() throws IOException {
		try {
			click("create_new_case");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_navigate_to_second_opinion");
		}
	}

	//TC_001 Validate that the 'Proceed' button is disabled when unchecked the check box self and I agree to DocPanels terms and condition
	@When("unchecked  the check box 'self and I agree to DocPanels terms and condition'")
	public static void click_checkbox() throws Exception, InterruptedException {
		try {
			click("so_self_checkbox");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_click_checkbox");
		}	
	}
	@Then("'Proceed' button is disabled")
	public static void verify_proceed_button_disabled() throws Exception, InterruptedException {
		try {
			value = driver.findElement(By.xpath(OR_reader("so_proceed_button"))).isEnabled();
			Assert.assertEquals(true,value); 
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_verify_proceed_button_disabled");
		}	
	}

	//TC_002 Validate the validation message on clicking "Continue to add clinical details" button without uploading "Upload your scan page"
	@When("clicks on 'Continue to add clinical details' button")
	public static void click_continue()  throws Exception {	   
		try {
			click("so_agree_to_docpanel_checkbox");
			browser_wait(10);
			click("so_proceed_button");
			browser_wait(10000);
			Thread.sleep(8000);
			fr= driver.findElement(By.xpath(OR_reader("outer_frame")));
			driver.switchTo().frame(fr);
			browser_wait(15000);
			click_javascript("so_dont_have_doctors_checkbox");
			browser_wait(20);
			click_javascript("so_i_dont_have_it");
			click_javascript("so_clinical_details_button");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_click_continue");
		}
	}
	@Then("validation message is displayed without clicking on'upload my scans'")
	public static void verify_validation_msg() throws Exception {	   
		try {
			str= driver.findElement(By.xpath(OR_reader("upload_scan_validation_msg"))).getText();
			Assert.assertEquals(str,td_reader("upload_scan_validation_msg")); 
			browser_wait(10);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_verify_validation_msg");
		}
	}

	//TC_003 Validate the validation message on clicking "Continue to add clinical details" button when the check box "I don not have a doctor's reports" is unchecked
	@When("unchecked the check box 'I do not have a doctors reports'")
	public static void uncheck_checkbox() throws Exception {
		try {
			click_javascript("so_dont_have_doctors_checkbox");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_uncheck_checkbox");
		}
	}
	@And("clicks on 'Continue to add clinical details'")
	public static void clicks_continue() throws Exception {
		try {
			browser_wait(20);
			click_javascript("so_clinical_details_button");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_clicks_continue");
		}
	}
	@Then("Validation message is displayed")
	public static void check_validation_msg() throws Exception {
		try {
			browser_wait(10);
			str= driver.findElement(By.xpath(OR_reader("upload_scan_validation_msg"))).getText();
			Assert.assertEquals(str,td_reader("upload_scan_validation_msg")); 
			str= driver.findElement(By.xpath(OR_reader("upload_report_validation_msg"))).getText();
			Assert.assertEquals(str,td_reader("upload_report_validation_msg")); 
			browser_wait(10);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_check_validation_msg");
		}
	}

	//TC_004 Validate not allowed to  click on "Continue to add clinical details" without "upload my reports"
	@When("click on the 'Continue to add clinical details' button")
	public static void clicks_on_the_continue_button() throws InterruptedException, Exception {
		try {
			browser_wait(2);
			file = new File(getreport());
			driver.findElement(By.xpath(OR_reader( "so_upload_report_button"))).sendKeys(file.getAbsolutePath());
			click_javascript("so_clinical_details_button");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_clicks_on_the_continue_button");
		}
	}
	@Then("validation message is displayed without clicking on 'upload my reports'")
	public static void check_validation_message() throws InterruptedException, Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("upload_scan_validation_msg"))).getText();
			Assert.assertEquals(str,td_reader("upload_scan_validation_msg")); 
			browser_wait(10);
			driver.navigate().to(getsourl());
			click_javascript("create_new_case");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_check_validation_message");
		}
	}

	//TC_005 Validate  not allowed to leave  check box 'other'  unchecked
	@When("not allowed to uncheck the other check box")
	public static void not_allowed_to_unckeck_other()  throws Exception {
		try {
			click("so_other_checkbox");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_not_allowed_to_unckeck_other");
		}
	}

	//TC_006 Validate that the user is not allowed to proceed when 'First name' and 'Last name' fields are blank
	@When("'First name' and 'Last name' fields are blank")
	public static void when_names_fields_blank() throws Exception, InterruptedException {
		try {
			click("so_other_agree_to_docpanel_checkbox");
			click("so_iam_legal_guardian_checkbox");
			click("so_proceed_button");
		}catch(Exception e) {
			takeScreenShot("request_second_opinion_negative_when_names_fields_blank");
		}		
	}
	@Then("validation message is displayed under 'First name' and 'Last name' fields")
	public static void blank_validation_message() throws IOException, InterruptedException {
		try {
			str= driver.findElement(By.xpath(OR_reader("so_first_name_validation_msg"))).getText();
			Assert.assertEquals(str,td_reader("so_first_name_validation_msg")); 
			browser_wait(1000);
			browser_refresh();
			click("create_new_case");
		}catch(Exception e) {
			takeScreenShot("request_second_opinion_negative_blank_validation_message");
		}
	}

	//TC_007 Validate that the user is not allowed leave blank 'First name' field
	@When("'First name' field are blank")
	public static void firstname_field_blank() throws InterruptedException, Exception {	
		try {
			click("so_other_checkbox");
			browser_wait(2000);
			driver.findElement(By.xpath(OR_reader("so_patient_last_name"))).sendKeys(td_reader("so_patient_last_name",2));
			click("so_other_agree_to_docpanel_checkbox");
			click("so_iam_legal_guardian_checkbox");
			click("so_proceed_button");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_firstname_field_blank");
		}
	}
	@Then("validation message is displayed under 'First name' field")
	public static void firstname_blank_msg() throws InterruptedException, IOException {
		try {
			str= driver.findElement(By.xpath(OR_reader("so_first_name_validation_msg"))).getText();
			Assert.assertEquals(str,td_reader("so_first_name_validation_msg")); 
			browser_wait(1000);
			browser_refresh();
			click("create_new_case");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_firstname_blank_msg");
		}
	}

	//TC_008 Validate that the user is not allowed leave blank 'Last name' field
	@When("'Last name' field are blank")
	public static void lastname_field_blank() throws Exception, InterruptedException {	
		try {
			click("so_other_checkbox");
			browser_wait(1000);
			driver.findElement(By.xpath(OR_reader("so_patient_first_name"))).sendKeys(td_reader("so_patient_first_name",2));
			click("so_other_agree_to_docpanel_checkbox");
			click("so_iam_legal_guardian_checkbox");
			click("so_proceed_button");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_lastname_field_blank");
		}
	}
	@Then("validation message is displayed under 'Last name' field")
	public static void lastname_blank_msg() throws Exception, InterruptedException {
		try {
			str= driver.findElement(By.xpath(OR_reader("so_last_name_validation_msg"))).getText();
			Assert.assertEquals(str,td_reader("so_last_name_validation_msg")); 
			browser_wait(1000);
			browser_refresh();
			click("create_new_case");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_lastname_blank_msg");
		}
	}

	//TC_009 Validate that the user should get a validation message on entering invalid 'First name'  and 'Last name'
	@When("'First name' and 'Last name' fields are invalid")
	public static void invalid_names() throws Exception, InterruptedException {		
		try {
			click("so_other_checkbox");
			driver.findElement(By.xpath(OR_reader( "so_patient_first_name"))).sendKeys(td_reader("so_patient_first_name",0));
			driver.findElement(By.xpath(OR_reader("so_patient_last_name"))).sendKeys(td_reader("so_patient_last_name",0));
			click("so_other_agree_to_docpanel_checkbox");
			click("so_iam_legal_guardian_checkbox");
			click("so_proceed_button");
		}
		catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_invalid_names");
		}
	}
	@Then("validation message is display")
	public static void validation_message() throws Exception, InterruptedException {
		try {
			str= driver.findElement(By.xpath(OR_reader("so_invalid_first_name"))).getText();
			Assert.assertEquals(str,td_reader("so_invalid_first_name")); 
			str= driver.findElement(By.xpath(OR_reader("so_invalid_last_name"))).getText();
			Assert.assertEquals(str,td_reader("so_invalid_last_name")); 
			browser_wait(1000);
			browser_refresh();
			click("create_new_case");
		}
		catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_validation_message");
		}
	}

	//TC_010 Validate that the user is not allowed to Proceed with invalid 'First name' and valid 'Last name'
	@When("invalid 'First name' and valid 'Last name'")
	public static void invalid_firstname()  throws Exception, InterruptedException {	
		try {
			click("so_other_checkbox");
			driver.findElement(By.xpath(OR_reader( "so_patient_first_name"))).sendKeys(td_reader("so_patient_first_name",0));
			driver.findElement(By.xpath(OR_reader("so_patient_last_name"))).sendKeys(td_reader("so_patient_last_name",2));
			click("so_other_agree_to_docpanel_checkbox");
			click("so_iam_legal_guardian_checkbox");
			click("so_proceed_button");
		}
		catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_invalid_firstname");
		}
	}
	@Then("validation message is displayed under 'First name'")
	public static void validation_msg_on_invalid_firstname()  throws Exception, InterruptedException {
		try {
			str= driver.findElement(By.xpath(OR_reader("so_invalid_first_name"))).getText();
			Assert.assertEquals(str,td_reader("so_invalid_first_name")); 
			browser_wait(1000);
			browser_refresh();
			click("create_new_case");
		}
		catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_validation_msg_on_invalid_firstname");
		}
	}

	//TC_011 Validate that the user is not allowed to Proceed with valid 'First name' and invalid 'Last name'
	@When("valid 'First name' and invalid 'Last name'")
	public static void invalid_lastname_field()  throws Exception, InterruptedException {
		try {
			click_javascript("so_other_checkbox");
			driver.findElement(By.xpath(OR_reader("so_patient_first_name"))).sendKeys(td_reader("so_patient_first_name",3));
			driver.findElement(By.xpath(OR_reader("so_patient_last_name"))).sendKeys(td_reader("so_patient_last_name",3));
			click_javascript("so_other_agree_to_docpanel_checkbox");
			click_javascript("so_iam_legal_guardian_checkbox");
			click_javascript("so_proceed_button");
		}
		catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_invalid_lastname_field");
		}
	}
	@Then("validation message is displayed under 'Last name'")
	public static void invalid_lastname_msg()  throws Exception, InterruptedException {
		try {
			str= driver.findElement(By.xpath(OR_reader("so_invalid_last_name"))).getText();
			Assert.assertEquals(str,td_reader("so_invalid_last_name"));
		}
		catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_invalid_lastname_msg");
		}
	}

	//TC_012 Validate that the "Proceed" button is disabled when  unchecked  the check box 'I agree to DocPanels terms and condition'
	@When("unchecked the check box 'I agree to DocPanels terms and condition'")
	public static void uncheck_chekcbox()  throws Exception {
		try {
			click("so_iam_legal_guardian_checkbox");
		} catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_uncheck_chekcbox");
		}
	}
	@Then("not allowed to Proceed")
	public static void not_allowed_to_proceed()  throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("so_proceed_button"))).isEnabled();
			Assert.assertEquals(true,value); 
			browser_wait(1000);
		} catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_not_allowed_to_proceed");
		}
	}

	//TC_013 Validate that the "Proceed" button is disabled when unchecked  the check box 'I am the legal guardian or have the necessary consents to order this second opinion'
	@When("unchecked the check box 'I am the legal guardian or have the necessary consents to order this second opinion'")
	public static void uncheck_check_box()  throws Exception {
		try {
			click("so_iam_legal_guardian_checkbox");
			click("so_other_agree_to_docpanel_checkbox");
		} catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_tc_001");
		}
	}
	@Then("unable to clicks on 'Proceed' button")
	public static void unable_to_proceed()  throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("so_proceed_button"))).isEnabled();
			Assert.assertEquals(true,value); 
			browser_wait(1000);
			System.out.println("Request second opinion negative");
			browser_close();
		} catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("request_second_opinion_negative_tc_001");
		}		
	}
}

