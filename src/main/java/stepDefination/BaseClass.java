package stepDefination;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObject.AddCustomer;
import pageObject.SearchCustomerObject;

import java.util.Properties;

public class BaseClass {

   public WebDriver driver;
    public AddCustomer addCustPage;
    public SearchCustomerObject searchCust;
    public Properties config;

    public static String generateRandomString(){
       String  s= RandomStringUtils.randomAlphabetic(5);
       return s;
    }
}
