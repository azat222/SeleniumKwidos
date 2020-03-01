import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Level;

public class HomePageTest {



    @Test
    public void titleTest () {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testkwidos.tk/");
        driver.manage().window().maximize();

        String title = driver.getTitle();
        Assert.assertEquals(title, "Kwidos2");

        driver.quit();

    }

    @Test
    public void LoginWrongCredentialsTest () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testkwidos.tk/auth/login");
        driver.manage().window().maximize();

        // email locator #email
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#email")).sendKeys("wrong@email.com");

        // password locator #passwor
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#password")).sendKeys("Password");

        driver.findElement(By.cssSelector("[type='submit']")).click();

        String actualText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();

        Assert.assertEquals(actualText, "Username or password is incorrect");

    }

    @Test
    public void ServiceProviderRegistrationTest () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testkwidos.tk/auth/register/contractor");


        // email locator #email
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


//        driver.findElement(By.cssSelector("#password")).sendKeys("Password");
//
//        driver.findElement(By.cssSelector("[type='submit']")).click();
//
//        String actualText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
//
//        Assert.assertEquals(actualText, "Username or password is incorrect");

        //Username or password is incorrect

//        driver.quit();

    }

}
