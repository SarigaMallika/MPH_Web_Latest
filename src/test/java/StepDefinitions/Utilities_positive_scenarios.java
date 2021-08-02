package StepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Utilities_positive_scenarios extends Generic_function{
	static boolean value;
	static String balance,text,ere;
	static WebElement ele;
	static List<WebElement> grid_elements,drp_list;

	/* TC_001 -Navigate to Utilities screen*/
	@Given("user is on home page")
	public static void launch_url() throws Exception{
		try {
			Browser_Launch();
			login(9,5);
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader("logout"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_launch_url");
		}		
	}	
	@When("clicks on Utilities tab")
	public static void click_utilities() throws Exception {
		try {
			click("utilities");
			browser_wait(1000);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_click_utilities");
		}	
	}
	@Then("Navigate to Utilities Dashboard")
	public static void navigate_to_utilities() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("wallet"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_navigate_to_utilities");
		}	
	}

	/* TC_002-Click options provided in left side navigator*/
	@When("Click on left side navigator options")
	public static void click_navigator_options() throws Exception {
		browser_wait(1000);
		click("home");
		browser_wait(1000);
	}
	@Then("Verify the navigator options")
	public void verify_navigators() throws Exception {
		try{
			value = driver.findElement(By.xpath(OR_reader("home_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("services");
			value = driver.findElement(By.xpath(OR_reader("services_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("circles");
			browser_wait(1000);
			value = driver.findElement(By.xpath(OR_reader("circles_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_verify_navigators");
		}
	}

	/* TC_003 - Verify that click on all the Tiles in the Utilities dashboard*/
	@When("Click all tiles in utilities dashboard")
	public static void click_all_tiles() throws Exception {
		try {
			click_javascript("utilities");
			browser_wait(1000);
			utilities_grid_tile(OR_reader( "utilities_gridpath"));
			browser_wait(1000);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_click_all_tiles");
		}	
	}

	/* TC_004 - Add card details  in the Wallet dashboard*/
	@When("Enter card details in wallet dashboard")
	public static void enter_card_details() throws Exception {
		try {
			browser_wait(1000);
			click_javascript("utilities");
			click_javascript("wallet");
			browser_wait(1000);
			click_javascript("utilities_add_card");
			browser_wait(4000);
			driver.findElement(By.xpath(OR_reader("utilities_save_as"))).sendKeys(td_reader("utilities_save_as"));
			driver.findElement(By.xpath(OR_reader("utilities_name_on_card"))).sendKeys(td_reader("utilities_name_on_card"));
			Robot robot = new Robot();
			browser_wait(8000);
			robot.keyPress(KeyEvent.VK_TAB);
			for (int i=0; i<5;i++) {
				robot.keyPress(KeyEvent.VK_NUMPAD4);
				robot.keyPress(KeyEvent.VK_NUMPAD2);
				robot.keyPress(KeyEvent.VK_NUMPAD4);
				robot.keyPress(KeyEvent.VK_NUMPAD2);
			}
			robot.keyPress(KeyEvent.VK_TAB);
			browser_wait(3000);
			robot.keyPress(KeyEvent.VK_NUMPAD1);
			robot.keyPress(KeyEvent.VK_NUMPAD2);
			robot.keyPress(KeyEvent.VK_BACK_SLASH);
			robot.keyPress(KeyEvent.VK_NUMPAD2);
			robot.keyPress(KeyEvent.VK_NUMPAD6);
			robot.keyPress(KeyEvent.VK_TAB);
			browser_wait(3000);
			robot.keyPress(KeyEvent.VK_NUMPAD1);
			robot.keyPress(KeyEvent.VK_NUMPAD2);
			robot.keyPress(KeyEvent.VK_NUMPAD3);
			browser_wait(3000);
			driver.findElement(By.xpath(OR_reader("utilities_zip_code"))).sendKeys(td_reader("utilities_zip_code",0));
			driver.findElement(By.xpath(OR_reader("utilities_phone_number"))).sendKeys(td_reader("utilities_phone_number",0));
			driver.findElement(By.xpath(OR_reader("utilities_address"))).sendKeys(td_reader("utilities_address"));
			driver.findElement(By.xpath(OR_reader("utilities_country"))).sendKeys(td_reader("utilities_country"));
			driver.findElement(By.xpath(OR_reader("utilities_state"))).sendKeys(td_reader("utilities_state"));
			driver.findElement(By.xpath(OR_reader("utilities_city"))).sendKeys(td_reader("utilities_city"));
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_enter_card_details");
		}	
	}
	@Then("Verify card details is saved")
	public static void card_details_save() throws Exception {
		try {
			click_javascript("utilities_save_button");
			//click_javascript("card_ok");
			browser_wait(1000);
			browser_back();
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_card_details_save");
		}
	}

	/* TC_005 - Add bank details  in the Wallet dashboard*/
	@When("Enter bank details in wallet dashboard")
	public void enter_bank_details() throws Exception {
		browser_wait(1000);
		try {
			click_javascript("utilities");
			click_javascript("wallet");
			click_javascript("utilities_add_bank");
			browser_wait(3000);
			driver.findElement(By.xpath(OR_reader("utilities_bank_saveas"))).sendKeys(td_reader("utilities_bank_saveas"));
			driver.findElement(By.xpath(OR_reader("utilities_account_name"))).sendKeys(td_reader("utilities_account_name",0));
			driver.findElement(By.xpath(OR_reader("utilities_routing_no"))).sendKeys(td_reader("utilities_routing_no",0));
			click("utilities_account_type");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_enter_bank_details");
		}
	}
	@Then("Verify bank details is saved")
	public static void save_bank_details() throws Exception {
		try {
			text = td_reader("utilities_account_type");
			drop_down(OR_reader( "utilities_account_type_list"),text);  
			driver.findElement(By.xpath(OR_reader("utilities_account_number"))).sendKeys(td_reader("utilities_account_number",0));
			click_javascript("utilities_bank_checkbox");
			click_javascript("utilities_save_button");
			click_javascript("card_ok");
		}catch (Exception e) {
			takeScreenShot("utilities_positive_save_bank_details");
		}	
	}

	/* TC_006 -Redeem points  in the Award points dashboard*/
	@When("Click award points")
	public static void click_award_points() throws Exception{
		try {
		browser_wait(4000);
		click("utilities");
		browser_wait(5000);
		click("award_points");
		browser_wait(9000);
	}catch (Exception e) {
		takeScreenShot("utilities_positive_click_award_points");
	}
}
	@Then("Verify the award points")
	public void verify_award_points()throws Exception {
		try{
		value1 = driver.findElement(By.xpath(OR_reader("award_point_title"))).isDisplayed();
		Assert.assertEquals(true,value1);
		System.out.println("Utilities positive");
		browser_close();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_verify_award_points");
		}
	}
}
