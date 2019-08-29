package stepDefinitions;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition2{

	 WebDriver driver;

	
	 @Given("^user is already on Login Page new$")
	 public void user_already_on_login_page(){
	 System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("https://login.salesforce.com/");
	 }
	
	
	 @When("^title of login page is Free CRM new$")
	 public void title_of_login_page_is_free_CRM(){
	 String title = driver.getTitle();
	 System.out.println(title);
	 Assert.assertEquals("Login | Salesforce", title);
	 }
	
	 //Reg Exp:
	 //1. \"([^\"]*)\"
	 //2. \"(.*)\"
	
	 @Then("^user enters username and password new$")
	 public void user_enters_username_and_password(){
		 driver.findElement(By.id("username")).sendKeys("proshob@trailhead.com"); //*[@id="username"]
		  driver.findElement(By.id("password")).sendKeys("Sridevi2009");//*[@id="password"]
			 }
	
	 @Then("^user clicks on login button new$")
	 public void user_clicks_on_login_button() {
	 WebElement loginBtn =
     driver.findElement(By.id("Login"));
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click();", loginBtn);
	 }
		
	 @Then("^user is on home page new$")
	 public void user_is_on_hopme_page(){
	 String title = driver.getTitle();
	 System.out.println("Home Page title ::"+ title);
	 Assert.assertEquals("Lightning Experience", title);
	 }
	 
	 @Then("^user moves to new Accounts page new$")
	 public void user_moves_to_new_accounts_page() {
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']")).click();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//a[@title='Accounts']")).click();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//div[text()='New']")).click();
		
		}
	 
	 
	 @Then("^user enters Account details new$")
	 public void user_enters_contacts_details(){
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 String username = "Proshob" + new Random().nextInt(1000);
		  driver.findElement (By.xpath("//input[@class='input uiInput uiInputText uiInput--default uiInput--input']")).sendKeys(username);
		  driver.findElement(By.xpath("//button[@title='Save']")).click();
	 }
	 

	 @Then("^Close the browser new$")
	 public void close_the_browser(){
		 driver.quit();
	 }
	
	
	

}
