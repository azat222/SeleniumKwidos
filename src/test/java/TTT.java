import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TTT {

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://kwidos.com/auth/register/contractor");
        Thread.sleep(4000);
        //name
        driver.findElement(By.cssSelector("[formcontrolname='firstName']")).sendKeys("Sara");
//     last name
        driver.findElement(By.cssSelector("[formcontrolname='lastName']")).sendKeys("Bruno");
//business name
        driver.findElement(By.cssSelector("[formcontrolname='businessName']")).sendKeys("Test pro");
        //phone number
        driver.findElement(By.cssSelector("[formcontrolname='phone']")).sendKeys("5678905674");
        driver.findElement(By.cssSelector("[formcontrolname='email']")).sendKeys("mary@testpro.io");
        driver.findElement(By.cssSelector("[formcontrolname='password']")).sendKeys("Qwerty2@");
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("[class='col-lg-12 col-xs-12 col-md-12 checkbox-block'] p-checkbox")).click();//review
        // ui-chkbox-box ui-widget ui-corner-all ui-state-default ui-state-active
        // 'col-lg-12 col-xs-12 col-md-12 checkbox-block'] p-checkbox"
        driver.findElement(By.cssSelector("[type='submit']")).click();
//ui-chkbox-icon ui-clickable pi pi-check']
        Thread.sleep(4000);
        //Assert.assertTrue(!driver.findElement(By.cssSelector("[type='submit']")).isEnabled());
        //    driver.quit();
        //Assort and except result
        driver.findElement(By.cssSelector("[type='submit']")).click();
        driver.quit();
    }
}
