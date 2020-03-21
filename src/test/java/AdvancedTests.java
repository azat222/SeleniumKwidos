import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class AdvancedTests extends BaseTest {

    @Test
    public void multipleTabs() {
        driver.get("https://kwidos.tk/share");

        String mainWindow = driver.getWindowHandle();

        driver.findElement(By.xpath("//*[contains(text(), 'Twitter')]")).click();

        String twitterWindow = driver.getWindowHandle();

        driver.switchTo().window(mainWindow);

        driver.switchTo().window(twitterWindow);


    }

    @Test
    public void scrollingTest() {

        driver.get("https://kwidos.tk/contractor/search");

        WebElement job = driver.findElement(By.xpath("//*[contains(text(), 'NEU')]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("alert('Hello! I am an alert box!!');");


    }

    @Test
    public void keysTest() {

        driver.get("https://kwidos.com/auth/login");

        WebElement element = driver.findElement(By.cssSelector("#email"));


        Actions builder = new Actions(driver);


        Action seriesOfActions = builder
                .moveToElement(element)
                .click()
                .sendKeys(element, "HELLO")
                .doubleClick(element)
                .contextClick()
                .build();

        seriesOfActions.perform();

    }

    @Test
    public void hover() {
        driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");

        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.cssSelector("#sub-menu"));

        Action mouseOverHome = builder.moveToElement(element).build();
        mouseOverHome.perform();

        driver.findElement(By.cssSelector("#link2")).click();

    }

    @Test
    public void frames() {

        driver.get("https://testpro.io/");

        driver.findElement(By.cssSelector("#mapDiv"));

    }

    @Test
    public void сookiesExample() {
        driver.get("https://kwidos.tk/auth/login");

        //azat+3@testpro.io
        //Qwerty2@


        driver.manage().deleteAllCookies();
        driver.get("https://kwidos.tk");
    }



    // https://kwidos.tk/auth/login

}
