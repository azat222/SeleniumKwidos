import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static final String USERNAME = "azatersky";
    public static final String ACCESS_KEY = "7bb293f8-a613-461e-a326-faf59a4a0dcd";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
    public static final String LOCALGRIDURL = "http://localhost:4444/wd/hub";

    public static final String BROWSERSTACKUSERNAME = "azat35";
    public static final String BROWSERSTACKACCESS_KEY = "qmDeqGhqmM3Xpqu6LCo4";
    public static final String BROWSERSTACKURL = "http://" + BROWSERSTACKUSERNAME + ":" + BROWSERSTACKACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";


    WebDriver driver;
    WebDriverWait wait;
    HomePage homepage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("ignore-certificate-errors");

//        driver = new ChromeDriver(options);

        driver = new RemoteWebDriver(new URL(LOCALGRIDURL), options);


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 4);

        homepage = new HomePage(driver);
        loginPage = new LoginPage(driver);


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
