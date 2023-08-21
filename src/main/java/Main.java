import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {

        //System.setProperty("webdriver.gecko.driver","D:/geckodriver.exe");
       // System.setProperty("webdriver.chrome.driver","D://chromedriver//chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.devgadhvilearninghub.com/users/sign_in");
        //driver.manage().window().fullscreen();
        driver.findElement(By.xpath("//div[@class='sign-in__wrapper']//div[1]//input[1]")).sendKeys("gupta.archit27@gmail.com");
        driver.findElement(By.id("user[password]")).sendKeys("tarlochan08!AB");
        driver.findElement(By.id("sign-in")).click();
        String s=driver.getTitle();
        System.out.println("Title of page is "+s);
        //driver.close();




    }
}
