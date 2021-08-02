package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Bills_positive_scenarios extends Generic_function{
	public static boolean value;
	public static String str,text,driver_name;
	public static WebElement from,to;

	/*TC_001 - Validate navigation to bills page */
    @Given("Launch the url")
	public void browser_launching() throws Exception {
		try {
			Browser_Launch();
			browser_wait(1000);
			login(6,7);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_browser launching");
		}
	}
	@When("Click on 'Bills'")
	public void click_on_bills() throws Exception {
		try {
			browser_wait(4000);
			click("services");
			click("bills_title_services");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_click_on_bills");
		}
	}   
	@Then("Verify user navigated to bills page")
	public void navigate_bills_page() throws Exception {
		try {
			browser_wait(2000);
			value = driver.findElement(By.xpath(OR_reader("bills_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_navigate_bills_page");
		}
	}
	
	/*TC 002 -Verify the scenario to view Total bills due*/
	@When("'Total bills due' visible on the page")
	public void total_bills_due_visiblitiy() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("bills_due_amount"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_total_bills_due_visiblitiy");		
		}	
	}
	@And("'Amount' visible on the page")
	public void amount_visible() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("bills_due_amount_dollar"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_amount_visible");
		}	
	}

	/*TC 003 - Validate by selecting Newest option from the dropdown */
	@When("Click on dropdown")
	public void click_on_dropdown() throws Exception {
		try {
			click("bills_dropdown");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_click_on_dropdown");		
		}	
	}
	@Then("Select 'Newest'")
	public void select_newest() throws Exception {
		try {
			text = td_reader("bills_dropdown_option");
			drop_down(OR_reader( "bills_dropdown_box"),text);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_select_newest");			
		}	
	}
	
	/*TC 004 -Validate view bills as two sections*/
	@When("Click on 'Due' section")
	public void click_on_due_section() throws Exception {
		try {
			click_javascript("bills_due_section");
			value = driver.findElement(By.xpath(OR_reader( "bills_due_message"))).isDisplayed();
			Assert.assertEquals(true,value);
			click_javascript("bills_paid_section");
			value = driver.findElement(By.xpath(OR_reader( "bills_paid_message"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_click_on_due_section");			
		}	
	}	
	@And("Click on 'Paid' section")
	public void click_paid_section() throws Exception {
		try {
			click_javascript("bills_paid_section");
			value = driver.findElement(By.xpath(OR_reader( "bills_paid_message"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_click_paid_section");
		}	
	}
	
	/*TC 005 - Validate slide the grid below the Bills page title.*/
	@When("Slide through 'Total bills due'")
	public void sliding() throws Exception {
		try {
			from = driver.findElement(By.xpath(OR_reader( "bills_carousel_from")));
			to = driver.findElement(By.xpath(OR_reader( "bills_carousel_to")));
			driver_name = browser_name();
			if(driver_name.equals("geck"))
			{
				firefox_slide(from);
			}
			else{
				chrome_edge_slide(from,to);
			}
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_sliding");
			
		}
	}
	@Then("Validate  'Your expenses' grid is visible")
	public void your_expense_grid() throws Exception {
		try {
			browser_wait(3000);
			value = driver.findElement(By.xpath(OR_reader( "bills_carousel_to"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_your_expense_grid");			
		}
	}
	
	/*TC 006 - Validate'Pay a Bill' button*/
	@When("Click on 'Pay a Bill' button")
	public void click_on_pay_a_bill() throws Exception {
		try {
			click("bills_pay_a_bill_button");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_click_on_pay_a_bill");
		}	
	}	
	@Then("Validate navigation to bill due section")
	public void bills_due_section() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "bills_due_message"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_bills_due_section");		
		}	
	}

	/*TC 007 - Validate Explore Services button*/
	@When("Click on 'Explore Services' button")
	public void click_on_explore_services() throws Exception {
		try {
			from = driver.findElement(By.xpath(OR_reader( "bills_carousel_from")));
			to = driver.findElement(By.xpath(OR_reader( "bills_carousel_to")));
			driver_name = browser_name();
			if(driver_name.equals("geck"))
			{
				firefox_slide(from);
			}
			else{
				chrome_edge_slide(from, to);
			}
			click("bills_explore_services_button");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_click_on_explore_services");
		}	
	}	
	@Then("Validate navigation to Services dashboard")
	public void navigation_service_page() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("services_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_navigation_service_page");
		}	
	}

	/*TC 008 - Validate that the user will get validation message when expense is $0*/
	@When("Shows validation message 'you have no expenditures yet'")
	public void validation_msg() throws Exception {
		try {
			click("services");
			click("bills_title_services");
			from = driver.findElement(By.xpath(OR_reader("bills_carousel_from")));
			to = driver.findElement(By.xpath(OR_reader("bills_carousel_to")));
			driver_name = browser_name();
			if(driver_name.equals("geck"))
			{
				firefox_slide(from);
			}
			else{
				chrome_edge_slide(from, to);
			}
			str= driver.findElement(By.xpath(OR_reader("bills_zero_expenditure_msg"))).getText();
			Assert.assertEquals(str,td_reader("bills_zero_expenditure_msg"));
			value = driver.findElement(By.xpath(OR_reader( "bills_zero_expenditure_img"))).isDisplayed();
			Assert.assertEquals(true,value);
			System.out.println("Bills positive");
			browser_close();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("bills_positive_validation_msg");
		}	
	}
}
