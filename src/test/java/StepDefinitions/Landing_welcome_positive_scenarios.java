
package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Landing_welcome_positive_scenarios extends Generic_function {
	static boolean value;
    static int s;
	
    /*TC_001 Verify that user is navigated to the Welcome page */
	@Given("launch the URL")
	public static void browser_launching() throws Exception, InterruptedException {
		Browser_Launch();
		s= Dataiter();		
	}		
	@Then("navigated to Welcome page")
	public static void navigate_to_welcome_page() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("welcome_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_positive_navigate_to_welcome_page");
		}
	}
	
	/*TC_002 Validate that the  user is able to click on 'Login' button and navigated to login page*/
	@When("clicks on the 'Login' button")
	public static void click_login() throws Exception {
		try {
			click("welcome_login");	
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_positive_click_login");
		}
	}	
	@Then("navigate to Login page")
	public void navigate_to_login_page() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "login_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_positive_navigate_to_login_page");
		}	
	}

	/*TC_003 Validate that the user is able to click on 'Sign Up' button and navigate to 'Sign Up' page*/
	@When("clicks on  'Sign Up' button")
	public static void click_sign_up() throws Exception {
		try {
			driver.navigate().to(getURL());
			click("welcome_signup");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_positive_click_sign_up");
		}
	}	
	@Then("navigate to Sign up page")
	public void navigate_to_signup_page() throws Exception {
		try {
			browser_wait(1500);
			value = driver.findElement(By.xpath(OR_reader( "signup_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			System.out.println("landing positive");
			browser_close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_positive_navigate_to_signup_page");
		}		
	}
}
