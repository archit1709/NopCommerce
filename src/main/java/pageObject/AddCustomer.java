package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import stepDefination.BaseClass;

import javax.xml.bind.Element;

public class AddCustomer {

   public WebDriver driver;

    public AddCustomer(WebDriver ldriver){
        driver=ldriver;
        PageFactory.initElements(driver,this);
    }

    By email= By.xpath("//input[@id='Email']");
    By pass= By.xpath("//input[@id='Password']");
    By firstName= By.xpath("//input[@id='FirstName']");
    By lastName= By.xpath("//input[@id='LastName']");
    By male= By.xpath("//input[@id='Gender_Male']");
    By female= By.xpath("//input[@id='Gender_Female']");
    By dob= By.xpath("//input[@id='DateOfBirth']");
    By cmpnyName= By.xpath("//input[@id='Company']");
    By custRole= By.xpath("//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover k-state-focused k-state-border-down']//div[@role='listbox']");
    By mangervendor= By.xpath("//select[@id='VendorId']");
    By adminContent= By.xpath("//textarea[@id='AdminComment']");
    By saveButton= By.xpath("//button[@name='save']");
    By custMenu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
    By custMenuItem=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
    By addNewCustButt=By.xpath("//a[@class='btn btn-primary']");

    public void clickCustMenu(){
        driver.findElement(custMenu).click();
    }
    public void clickCustMenuItem(){
       WebElement element= driver.findElement(custMenuItem);
       JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].click();", element);

    }
    public void clickAddNewButtton(){
        driver.findElement(addNewCustButt).click();
    }

    public void setEmail(String email1){
        driver.findElement(email).sendKeys(email1);
    }
    public void setPassword(String pass1){
        driver.findElement(pass).sendKeys(pass1);
    }

    public void setFirstName(String name){
        driver.findElement(firstName).sendKeys(name);
    }

    public void setLastName(String lastName1){
        driver.findElement(lastName).sendKeys(lastName1);
    }
    public void setGender(String gender){
        if(gender.equals("Male")){
            driver.findElement(male).click();
        }else{
            driver.findElement(female).click();
        }
    }

    public void setDateOfBirth(String dob1){
        driver.findElement(dob).sendKeys(dob1);
    }
    public void setCompanyName(String cmp){
        driver.findElement(cmpnyName).sendKeys(cmp);
    }
    public void setCustRole(String role){
        WebElement element = null;
        if(role.equals("Registered")){
          element= driver.findElement(By.xpath("//li[normalize-space()='Registered']"));
        }else if(role.equals("Guests")){
            element=driver.findElement(By.xpath("//li[normalize-space()='Guests']"));
        }else if(role.equals("Administrators")){
            element=driver.findElement(By.xpath("//li[normalize-space()='Administrators']"));
        }
       // element.click();
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].click();", element);
    }

    public void setAdminContent(String admin){
        driver.findElement(adminContent).sendKeys(admin);
    }
    public void setManagerVendor(String mgrVendor){
        Select select= new Select(driver.findElement(mangervendor));
        select.selectByVisibleText(mgrVendor);

    }
    public void clickSaveButton(){
        driver.findElement(saveButton).click();
    }

}
