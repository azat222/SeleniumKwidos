package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {


    public LoginPage (WebDriver givendriver) {
        super(givendriver);
    }


    public String getSuccessText(String s) {
        String st = "Success";
        return st;
    }

    public String getErrorText (String cssSelector) {

        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector))).getText();

        return actualText;
    }

    public LoginPage openPage() {
        driver.get("https://kwidos.tk/auth/login");
        return this;
    }

    public LoginPage enterEmail(String email) {
        findElement("#email").sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        findElement("#password").sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        clickToElement("[type='submit']");
        return this;
    }


}
