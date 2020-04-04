import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void LoginSuccessTest () throws InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homepage = new HomePage(getDriver());

        homepage.openPage();
        loginPage.openPage();
        loginPage.openPage();
        loginPage.login("azat@testpro.io", "Password1!");

        String actualText = loginPage.getSuccessText();
        Assert.assertEquals(actualText, "Username or password is incorrect");
    }


    @Test
    public void LoginWrongCredentialsTest () throws InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homepage = new HomePage(getDriver());

        homepage = new HomePage(getDriver());
        loginPage = new LoginPage(getDriver());


        loginPage.openPage();
        loginPage.enterEmail("wrong@email.com");
        loginPage.enterPassword("Password");
        loginPage.clickSubmit();

        String actualText = loginPage.getErrorText(".alert.alert-danger");
        Assert.assertEquals(actualText, "Username or password is incorrect");

    }
//
//
//    @Test
//    public void LoginEmptyEmailTest () throws InterruptedException {
//
//
//        LoginPage loginPage = new LoginPage(getDriver());
//
//        loginPage.openPage();
//        loginPage.enterEmail("");
//        loginPage.enterPassword("Password");
//        loginPage.clickSubmit();
//
//        String actualText = loginPage.getErrorText("[class='form-group has-error'] div");
//        Assert.assertEquals(actualText, "Email is required");
//
//    }
//
//    @Test
//    public void LoginEmptyPasswordTest () throws InterruptedException {
//
//        homepage = new HomePage(getDriver());
//        loginPage = new LoginPage(getDriver());
//
//        LoginPage loginPage = new LoginPage(driver);
//
//        loginPage.openPage();
//        loginPage.enterEmail("wrong@email.com");
//        loginPage.enterPassword("");
//        loginPage.clickSubmit();
//
//        String actualText = loginPage.getErrorText("[class='form-group has-error'] div");
//        Assert.assertEquals(actualText, "Password is required");
//    }

    // Implementation methods



//    @Test
//    public void cookiesExample() throws InterruptedException {
////        getDriver().get("https://kwidos.tk/auth/login");
//        openLoginPage();
//        enterEmail("azat+3@testpro.io");
//        enterPassword("Qwerty2@");
//        clickSubmit();
//
//        getDriver().findElement(By.xpath("//*[contains(text(), 'GO TO PROFILE')]"));
//
//        Thread.sleep(3000);
//
//        getDriver().manage().deleteAllCookies();
//
//        Thread.sleep(3000);
//        getDriver().get("https://kwidos.tk");

        //azat+3@testpro.io
        //Qwerty2@

//
//        getDriver().manage().deleteAllCookies();
//        getDriver().get("https://kwidos.tk");
//    }




}
