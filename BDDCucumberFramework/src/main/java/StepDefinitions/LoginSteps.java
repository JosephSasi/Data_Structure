package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginSteps {
	
	WebDriver driver;
	
	@Given("^User is on Application Home Page$")
	public void user_is_on_Application_Home_Page() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.freecrm.com/index.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	}

	@When("^Application Page Tittle is FREE CRM$")
	public void application_Page_Tittle_is_FREE_CRM() {
	    String actualTitle = driver.getTitle();
	    String expectedTitle = "Free CRM in the cloud software boosts sales";
	    Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String uname, String password) {
	  driver.findElement(By.name("username")).sendKeys(uname);
	  driver.findElement(By.name("password")).sendKeys(password);
	   
	}

	@Then("^user clicks on Login Butoon$")
	public void user_clicks_on_Login_Butoon() {
	    WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", loginBtn);
	
	}

	@When("^User navigate to user Profile page$")
	public void user_navigate_to_user_Profile_page() {
	    String actualTitle = driver.getTitle();
	    String expectedTitle = "CRMPRO";
	    Assert.assertEquals(expectedTitle, actualTitle);
	    driver.close();
	}

}
