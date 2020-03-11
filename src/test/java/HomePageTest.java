import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Level;

public class HomePageTest extends BaseTest {


    @Test
    public void titleTest () {

        driver.get("https://kwidos.com/");

        String title = driver.getTitle();
        Assert.assertEquals(title, "Kwidos");


    }



    @Test
    public void ServiceProviderRegistrationTest () throws InterruptedException {

        driver.get("https://kwidos.com/auth/register/contractor");


        Thread.sleep(4000);
        driver.findElement(By.cssSelector("[formcontrolname='firstName']")).sendKeys("azat");
        driver.findElement(By.cssSelector("[formcontrolname='lastName']")).sendKeys("zakuanov");
        driver.findElement(By.cssSelector("[formcontrolname='businessName']")).sendKeys("test pro");
        driver.findElement(By.cssSelector("[formcontrolname='phone']")).sendKeys("8183453434");
        driver.findElement(By.cssSelector("[formcontrolname='email']")).sendKeys("azat@testpro.io");
        driver.findElement(By.cssSelector("[formcontrolname='password']")).sendKeys("Password");
        //p-checkbox[class='ng-dirty ng-touched ng-invalid'] .ui-chkbox-icon.ui-clickable
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[class='col-lg-12 col-xs-12 col-md-12 checkbox-block'] p-checkbox")).click();
        driver.findElement(By.cssSelector("[type='submit']")).click();

//        driver.quit();
//        driver.findElement(By.cssSelector("#password")).sendKeys("Password");
//
//        driver.findElement(By.cssSelector("[type='submit']")).click();
//
//        String actualText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
//
//        Assert.assertEquals(actualText, "Username or password is incorrect");

        //Username or password is incorrect

    }

}
