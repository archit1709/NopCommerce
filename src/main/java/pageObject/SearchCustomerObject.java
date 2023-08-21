package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchCustomerObject {

    public WebDriver driver;
    public SearchCustomerObject(WebDriver ldriver){
        driver=ldriver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(how = How.XPATH,using = "//input[@id='SearchEmail']")
    @CacheLookup
    WebElement email;
    @FindBy(how = How.XPATH,using = "//input[@id='SearchFirstName']")
    @CacheLookup
    WebElement firstName;

    @FindBy(how = How.XPATH,using = "//input[@id='SearchLastName']")
    @CacheLookup
    WebElement lastName;

    @FindBy(how = How.XPATH,using = "//input[@id='SearchCompany']")
    @CacheLookup
    WebElement cmpny;

    @FindBy(how = How.XPATH,using = "//button[@id='search-customers']")
    @CacheLookup
    WebElement searchBtn;

   /* @FindBy(how = How.CLASS_NAME,using = "sidebar-mini layout-fixed control-sidebar-slide-open sidebar-closed sidebar-collapse")
    WebElement table;*/

    @FindBy(how = How.ID,using = "customers-grid")
    WebElement table;

   // <table class="table table-bordered table-hover table-striped dataTable" width="100%" id="customers-grid">    @FindBy(how = How.XPATH,using = "")
    @FindBy(how = How.XPATH,using = ".//tr")
    List<WebElement> tableRows;

    @FindBy(how = How.XPATH,using = ".//td")
    List<WebElement> tableColmns;


    public int getNoOfRows(){
        return tableRows.size();
    }
    public int getNoOfColumns(){
        return tableColmns.size();
    }

    public void clickSideBar(){

       WebElement element= driver.findElement(By.xpath("//i[@class='far fa-angle-down']"));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].click();", element);

    }

    public void setEmail(String email1){
        //driver.findElement(By.xpath("//input[@id='SearchEmail']")).sendKeys(email1);
        email.sendKeys(email1);
    }

    public void setFirstName(String firstname){
        firstName.clear();
        firstName.sendKeys(firstname);
    }

    public void setLastName(String lastName1){
        lastName.clear();
        lastName.sendKeys(lastName1);
    }

    public void clickSearchbtn(){
      //  searchBtn.click();
        //WebElement element= driver.findElement(By.xpath("//i[@class='far fa-angle-down']"));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].click();", searchBtn);
    }


    public boolean searchCustomerByEmail(String email) {
        boolean flag = false;
        List<WebElement> table = driver.findElements(By.id("customers-grid"));
        List<WebElement> element = driver.findElements(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr/td[2]"));
        for (int i = 0; i < table.size(); i++) {
            String s = element.get(0).getText();
            if (email.equals(s)) {
                flag = true;
            }
        }
        return flag;

    }

    }



