package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;

public class LoginPage extends BasePage {

    @FindBy(css = "#email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "[type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".alert.alert-danger")
    private WebElement successText;

    public LoginPage (WebDriver givendriver) {
        super(givendriver);
    }

    public String getSuccessText() {
        return successText.getText();
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
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public LoginPage login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        return clickSubmit();
    }
}
