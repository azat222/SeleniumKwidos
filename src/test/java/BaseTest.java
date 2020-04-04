import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import javax.swing.text.html.Option;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//public class BaseTest {
//
//    public static final String USERNAME = "azatersky";
//    public static final String ACCESS_KEY = "7bb293f8-a613-461e-a326-faf59a4a0dcd";
//    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
//    public static final String LOCALGRIDURL = "http://localhost:4444/wd/hub";
//
//    public static final String BROWSERSTACKUSERNAME = "azat35";
//    public static final String BROWSERSTACKACCESS_KEY = "qmDeqGhqmM3Xpqu6LCo4";
//    public static final String BROWSERSTACKURL = "http://" + BROWSERSTACKUSERNAME + ":" + BROWSERSTACKACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public class BaseTest {

        WebDriver driver;
        WebDriverWait wait;

        ThreadLocal<RemoteWebDriver> threadDriver;
        Capabilities capabilities;

        @BeforeMethod
        public void setUp() throws MalformedURLException {

            threadDriver = new ThreadLocal<RemoteWebDriver>();

//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("ignore-certificate-errors");

            SafariOptions safariOptions = new SafariOptions();
            ChromeOptions chromeOptions = new ChromeOptions();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            InternetExplorerOptions ieoptions = new InternetExplorerOptions();

            switch (System.getProperty("browser")) {
                case "safari":
                    capabilities = safariOptions;
                    break;
//                case "chrome":
//                    chromeOptions.addArguments("ignore-certificate-errors");
//                    capabilities = chromeOptions;
//                    break;
                case "firefox":
                    firefoxOptions.addArguments("ignore-certificate-errors");
                    capabilities = firefoxOptions;
                    break;
                case "ie":
//                    ieoptions.addArguments("ignore-certificate-errors");
                    capabilities = ieoptions;
                    break;
                default:
                    chromeOptions.addArguments("ignore-certificate-errors");
                    capabilities = chromeOptions;
            }


            threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));

            getDriver().manage().window().maximize();
            getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            wait = new WebDriverWait(getDriver(), 4);

        }

        public WebDriver getDriver() {
            return threadDriver.get();
        }


        @AfterMethod
        public void tearDown(){
            getDriver().quit();
        }

    }

