import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.logging.Level;

public class HomePageTest extends BaseTest {


    @Test
    public void titleTest () {

        HomePage homePage = new HomePage(driver);

        homePage.openPage();
        String title = homePage.getTitle();

        Assert.assertEquals(title, "Kwidos");


    }
}
