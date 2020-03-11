import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void LoginSuccessTest () throws InterruptedException {

        openLoginPage();
        enterEmail("azat@testpro.io");
        enterPassword("Password1!");
        clickSubmit();

        String actualText = getSuccessText(".alert.alert-danger");
        Assert.assertEquals(actualText, "Success");

    }


    @Test
    public void LoginWrongCredentialsTest () throws InterruptedException {

        openLoginPage();
        enterEmail("wrong@email.com");
        enterPassword("Password");
        clickSubmit();

        String actualText = getErrorText(".alert.alert-danger");
        Assert.assertEquals(actualText, "Username or password is incorrect");

    }


    @Test
    public void LoginEmptyEmailTest () throws InterruptedException {

        openLoginPage();
        enterEmail("");
        enterPassword("Password");
        clickSubmit();

        String actualText = getErrorText("[class='form-group has-error'] div");
        Assert.assertEquals(actualText, "Email is required");

    }

    @Test
    public void LoginEmptyPasswordTest () throws InterruptedException {
        openLoginPage();
        enterEmail("wrong@email.com");
        enterPassword("");
        clickSubmit();

        String actualText = getErrorText("[class='form-group has-error'] div");
        Assert.assertEquals(actualText, "Password is required");
    }

    private String getSuccessText(String s) {
        String st = "Success";
        return st;
    }

    public String getErrorText (String cssSelector) throws InterruptedException {
        Thread.sleep(2000);
        String actualText = driver.findElement(By.cssSelector(cssSelector)).getText();
        return actualText;
    }

    public void openLoginPage() {
        driver.get("https://kwidos.com/auth/login");
    }

    public void enterEmail(String email) throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#email")).sendKeys(email);
    }

    public void enterPassword(String password) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
    }

    private void clickSubmit() {
        driver.findElement(By.cssSelector("[type='submit']")).click();
    }

}
