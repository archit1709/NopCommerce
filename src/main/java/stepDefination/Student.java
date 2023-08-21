package stepDefination;

import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.AddCustomer;
import pageObject.SearchCustomerObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Student extends BaseClass {

    public WebDriver driver;
    public Logger logger;
    @Before
    public void  setup() throws IOException {

        config=new Properties();
        FileInputStream fis=new FileInputStream("config.properties");
        config.load(fis);
        logger= Logger.getLogger(Student.class);
        PropertyConfigurator.configure("log4j.properties");

    String br= config.getProperty("browser");

    /*if(br.equals("chrome")){
     //   System.setProperty("webdriver.chrome.driver", config.getProperty("chromepath"));
        driver=new ChromeDriver();
    }else if(br.equals("firexox")){
        System.setProperty("webdriver.gecko.driver",config.getProperty("firefoxpath"));
        driver=new FirefoxDriver();
    }*/

    }

    @Given("User launch a chrome browser")
    public void user_launch_a_chrome_browser() {
        //logger.debug("**************Launching chrome browser****************");
        driver=new ChromeDriver();

    }
    @When("Enters a url as {string}")
    public void enters_a_url_as(String url) {
        logger.debug("************Enter URL************");
       driver.get(url);
    }
    @And("User enter email as {string} and password as {string}")
    public void userEnterEmailAsAndPasswordAs(String email, String pass) throws InterruptedException {
        logger.debug("***********Enter User email & password**************");
        WebElement element=driver.findElement(By.id("Email"));
        element.clear();
        driver.findElement(By.id("Email")).sendKeys(email);
        Thread.sleep(3000);
        WebElement password=driver.findElement(By.id("Password"));
        password.clear();
        driver.findElement(By.id("Password")).sendKeys(pass);
    }

    @When("click on login button")
    public void click_on_login_button() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
    @Then("User can view a Dashboard")
    public void user_can_view_a_dashboard() {
        Assert.assertEquals("Dashboard / nopCommerce administration",driver.getTitle());
    }
    @When("User click on Customer menu")
    public void user_click_on_customer_menu() {
        addCustPage=new AddCustomer(driver);
        addCustPage.clickCustMenu();
    }
    @When("click on Customer menu item")
    public void click_on_customer_menu_item() {
        addCustPage.clickCustMenuItem();
    }
    @Then("User can view a Customer Dashboard page")
    public void user_can_view_a_add_customer_page() {
        Assert.assertEquals("Customers / nopCommerce administration",driver.getTitle());
    }
    @When("click on Add customer button")
    public void click_on_add_customer_button() {
        addCustPage.clickAddNewButtton();
    }
    @Then("Add a new customer page displays")
    public void add_a_new_customer_page_displays() {
        Assert.assertEquals("Add a new customer / nopCommerce administration",driver.getTitle());
    }
    @When("User add customer info")
    public void user_add_customer_info() {
       String randomString= generateRandomString();
       addCustPage.setEmail(randomString+"@gmail.com");
        addCustPage.setPassword("12345");
        addCustPage.setFirstName("Ram");
        addCustPage.setLastName("Kumar");
        addCustPage.setGender("Male");
        addCustPage.setDateOfBirth("11/11/2023");
        addCustPage.setCompanyName("Jetways india pvt Ltd");
        addCustPage.setCustRole("Registered");
        addCustPage.setManagerVendor("Vendor 1");
        addCustPage.setAdminContent("Hello welcome");
    }
    @When("click on save button")
    public void click_on_save_button() {
        addCustPage.clickSaveButton();
    }
    @Then("User get a confirmation {string}")
    public void user_get_a_confirmation(String text) {
       Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(text));
    }
    @Then("browser closed")
    public void browser_closed() {
        driver.close();
    }

    @When("User enter emailId")
    public void userEnterEmailId() {
        searchCust=new SearchCustomerObject(driver);
        searchCust.setEmail("victoria_victoria@nopCommerce.com");
    }

    @And("click on search button")
    public void clickOnSearchButton() {
        searchCust.clickSearchbtn();
    }

    @Then("User should be able to find Emailid in table")
    public void userShouldBeAbleToFindEmailidInTable() {
      boolean value= searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
        //Assert.assertEquals(true ,value);
      if(value){
          System.out.println("Test case passed");
      }
    }



}
