package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import Reusable_Functions.Generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class My_medicare_claims_positive_scenarios extends Generic_function {
	public static boolean value;
	public static String text, str; 

	/*Browser launch*/
	@Given("Launch the URL and click on Login button")
	public void browserlaunching() {
		try {
			Browser_Launch();
			login(9,5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC_001- Validate navigation to claims page*/
	@When("Clicks on the Circles from home dashboard")
	public void My_medicare_claims_positive_positive_tc_001() throws Exception {
		try {
			browser_wait(20);
			click("circle_click");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("My_medicare_claims_positive_positive_tc_001");
		}
	}

	@Then("Select My Medicare")
	public void select_my_medicare() throws Exception {
		try {
			browser_wait(20);
			click("circle_my_medicare_icon");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("select_my_medicare");
		}
	}

	@And("Click on Claims from the My Medicare dashbord")
	public void click_claims() throws Exception {
		try {
			click("my_medicare_claims_icon");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("click_claims");
		}
	}

	/*TC_002 - Verify the scenario when Claims title and back arrow visible on the page*/
	@When("Claims title and back arrow displayed")
	public void My_medicare_claims_positive_positive_tc_002() throws Exception {
		try {
			element_visible_wait(360,"claims_select_claim_type_text");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("My_medicare_claims_positive_positive_tc_002");
		}
	}

	@Then("Claims title and back arrow displayed on the page")
	public void title_arrow_visible_assertion() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("claims_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("claims_back_arrow"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("title_arrow_visible_assertion");
		}
	}

	/*TC_003 - Verify the scenario when select "Claim type" from the dropdown field*/
	@When("Select Claim type from the dropdown field")
	public void My_medicare_claims_positive_positive_tc_003() throws Exception {
		try {
			click("claims_claim_type");
			text = td_reader("claims_type");
			drop_down(OR_reader("claims_claim_type_dropdown"),text);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("My_medicare_claims_positive_positive_tc_003");
		}
	}

	@Then("Filtered Claims summary and Claims are displayed")
	public void view_claims_summary() throws Exception {
		try {
			click_javascript("claims_claims_tab");
			click_javascript("claims_claim_summary_tab");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("view_claims_summary");
		}
	}

	/*TC_004 - Verify the scenario when select "Time period" from the dropdown field*/
	@When("Select Time period from the dropdown field")
	public void My_medicare_claims_positive_positive_tc_004() throws Exception {
		try {
			click("claims_time_period");
			text = td_reader("claims_time_period");
			drop_down(OR_reader("claims_time_period_dropdown"),text);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("My_medicare_claims_positive_positive_tc_004");
		}
	}

	@Then("Filtered Claims summary and Claims page are displayed")
	public void view_claims_summary1() throws Exception {
		try {
			click_javascript("claims_claims_tab");
			click_javascript("claims_claim_summary_tab");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("view_claims_summary1");
		}
	}

	/*TC_005 - Verify the scenario  to view 'Patient portion and Insurer portion' under claims summary*/
	@Given("Patient portion and Insurer portion displayed on the page")
	public void My_medicare_claims_positive_positive_tc_005() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("claims_patient_portion_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("claims_insurer_portion_text"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("My_medicare_claims_positive_positive_tc_005");
		}
	}

	/*TC_006 - Verify the scenario  to view 'Here is the helpful breakdown' text under Claims summary*/
	@Given("'Here is the helpful breakdown'  text is displayed on the page")
	public void My_medicare_claims_positive_positive_tc_006() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("claims_help_breakdown_text"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("My_medicare_claims_positive_positive_tc_006");
		}
	}

	/*TC_007 - Verify the scenario claims breakdown is visible*/
	@Given("All the breakdown and total amount are displayed")
	public void My_medicare_claims_positive_positive_tc_007() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("claims_institutional"))).getText();
			Assert.assertEquals(str,td_reader("claims_institutional"));
			str= driver.findElement(By.xpath(OR_reader("claims_pharmacy"))).getText();
			Assert.assertEquals(str,td_reader("claims_pharmacy"));
			str= driver.findElement(By.xpath(OR_reader("claims_professional"))).getText();
			Assert.assertEquals(str,td_reader("claims_professional"));
			str= driver.findElement(By.xpath(OR_reader("claims_HHA"))).getText();
			Assert.assertEquals(str,td_reader("claims_HHA"));
			str= driver.findElement(By.xpath(OR_reader("claims_DME"))).getText();
			Assert.assertEquals(str,td_reader("claims_DME"));
			str= driver.findElement(By.xpath(OR_reader("claims_vision"))).getText();
			Assert.assertEquals(str,td_reader("claims_vision"));
			str= driver.findElement(By.xpath(OR_reader("claims_dental"))).getText();
			Assert.assertEquals(str,td_reader("claims_dental"));
			str= driver.findElement(By.xpath(OR_reader("claims_total"))).getText();
			Assert.assertEquals(str,td_reader("claims_total"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("My_medicare_claims_positive_positive_tc_007");
		}
	}

	/*TC_008 - Verify the scenario to sort claims under 'Claims' tab*/
	@When("Click on funnel icon then select Date created and Date created")
	public void My_medicare_claims_positive_positive_tc_008() throws Exception {
		try {
			click_javascript("claims_claims_tab");
			click("claims_funnel_icon");
			text = td_reader("claims_funnel_dropdown_option");
			drop_down(OR_reader("claims_funnel_dropdown"),text);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("My_medicare_claims_positive_positive_tc_008");
		}
	}

	@Then("Oldest and Newest claims claims are diplayed")
	public void oldest_newest_claim() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("claims_oldest_newest_box"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("oldest_newest_claim");
		}
	}

	/*TC_009 -  Verify the scenario to view total number of claims*/
	@Then("Total number records found text displayed.Also, user should able to see the list of records with Date")
	public void My_medicare_claims_positive_positive_tc_009() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("claims_record_found_text"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("My_medicare_claims_positive_positive_tc_009");
		}
	}

	/*TC_010 -  Verify the scenario to select one claim under the list of claims*/
	@When("Select one claim under list of claims")
	public void My_medicare_claims_positive_positive_tc_010() throws Exception {
		try {
			element_visible_wait(360,"claims_prescription_drug_claim");
			click("claims_prescription_drug_claim");
			element_visible_wait(360,"claims_claim_number");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("My_medicare_claims_positive_positive_tc_010");
		}
	}

	@Then("Selected claim details displayed")
	public void claims_details() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("claims_claim_details"))).isDisplayed();
			Assert.assertEquals(true,value);
			str= driver.findElement(By.xpath(OR_reader("claims_claim_number"))).getText();
			Assert.assertEquals(str,td_reader("claims_claim_number"));
			value = driver.findElement(By.xpath(OR_reader("claims_claim_type_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			str= driver.findElement(By.xpath(OR_reader("claims_claim_type_value"))).getText();
			Assert.assertEquals(str,td_reader("claims_claim_type_value"));
			value = driver.findElement(By.xpath(OR_reader("claims_claim_provider_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			str= driver.findElement(By.xpath(OR_reader("claims_claim_provider_value"))).getText();
			Assert.assertEquals(str,td_reader("claims_claim_provider_value"));
			value = driver.findElement(By.xpath(OR_reader("claims_claim_insurer_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			str= driver.findElement(By.xpath(OR_reader("claims_claim_insurer_value"))).getText();
			Assert.assertEquals(str,td_reader("claims_claim_insurer_value"));
			value = driver.findElement(By.xpath(OR_reader("claims_claim_patient_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			str= driver.findElement(By.xpath(OR_reader("claims_claim_patient_value"))).getText();
			Assert.assertEquals(str,td_reader("claims_claim_patient_value"));
			value = driver.findElement(By.xpath(OR_reader("claims_claim_service_date_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			str= driver.findElement(By.xpath(OR_reader("claims_claim_service_date_value"))).getText();
			Assert.assertEquals(str,td_reader("claims_claim_service_date_value"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Selected claim details displayed");
		}
	}

	/*TC_011 -  Verify the scenario when selected claim service details can be visible*/
	@When("Expand and view Services of selected claim")
	public void My_medicare_claims_positive_positive_tc_011() throws Exception {
		try {
			click("claims_services_down_arrow");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("My_medicare_claims_positive_positive_tc_011");
		}
	}

	@Then("Services details should be displayed")
	public void services_details() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("claims_service_name"))).isDisplayed();
			Assert.assertEquals(true,value);
			str= driver.findElement(By.xpath(OR_reader("claims_service_name"))).getText();
			Assert.assertEquals(str,td_reader("claims_service_name"));
			value = driver.findElement(By.xpath(OR_reader("claims_service_quantity_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			str= driver.findElement(By.xpath(OR_reader("claims_service_quantity_value"))).getText();
			Assert.assertEquals(str,td_reader("claims_service_quantity_value"));
			value = driver.findElement(By.xpath(OR_reader("claims_service_insurer_portion_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			str= driver.findElement(By.xpath(OR_reader("claims_service_insurer_portion_value"))).getText();
			Assert.assertEquals(str,td_reader("claims_service_insurer_portion_value"));
			value = driver.findElement(By.xpath(OR_reader("claims_service_patient_portion_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			str= driver.findElement(By.xpath(OR_reader("claims_service_patient_portion_value"))).getText();
			Assert.assertEquals(str,td_reader("claims_service_patient_portion_value"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("services_details");
		}
	}

	/*TC_012 -  Verify the scenario when clicking on related records*/
	@Given("Click on all the icons under related records")
	public void My_medicare_claims_positive_positive_tc_012() throws Exception {
		try {
			click("claims_related_record_claims");
			value = driver.findElement(By.xpath(OR_reader("claims_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("claims_back_arrow"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("claims_back_arrow");
			click("claims_related_record_conditions");
			value = driver.findElement(By.xpath(OR_reader("claims_back_arrow"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("claims_back_arrow");
			click("claims_related_record_medications");
			value = driver.findElement(By.xpath(OR_reader("claims_back_arrow"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("claims_back_arrow");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("My_medicare_claims_positive_positive_tc_012");
		}
	}

	/*TC_013 -  Verify the scenario when clicking on More icon*/
	@When("Click on 'More' icon and select each icon under 'More' popup")
	public void My_medicare_claims_positive_positive_tc_013() throws Exception {
		try {
			click("claims_related_record_more");
			click("claims_related_record_allergies");
			value = driver.findElement(By.xpath(OR_reader("claims_back_arrow"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("claims_back_arrow");
			click("claims_related_record_more");
			click("claims_related_record_procedures");
			value = driver.findElement(By.xpath(OR_reader("claims_back_arrow"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("claims_back_arrow");
			click("claims_related_record_more");
			browser_close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("My_medicare_claims_positive_positive_tc_013");
		}
	}
}
