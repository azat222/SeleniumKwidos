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


        homepage.openPage();
        homepage.clickToOpenSignIn();
        loginPage.openPage();

        loginPage.enterEmail("azat@testpro.io");
        loginPage.enterPassword("Password1!");
        loginPage.clickSubmit();

        String actualText = loginPage.getSuccessText(".alert.alert-danger");
        Assert.assertEquals(actualText, "Success");

    }


    @Test
    public void LoginWrongCredentialsTest () throws InterruptedException {


        loginPage.openPage()
                .enterEmail("wrong@email.com")
                .enterPassword("Password")
                .clickSubmit();

        String actualText = loginPage.getErrorText(".alert.alert-danger");
        Assert.assertEquals(actualText, "Username or password is incorrect");

    }


    @Test
    public void LoginEmptyEmailTest () throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openPage();
        loginPage.enterEmail("");
        loginPage.enterPassword("Password");
        loginPage.clickSubmit();

        String actualText = loginPage.getErrorText("[class='form-group has-error'] div");
        Assert.assertEquals(actualText, "Email is required");

    }

    @Test
    public void LoginEmptyPasswordTest () throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openPage();
        loginPage.enterEmail("wrong@email.com");
        loginPage.enterPassword("");
        loginPage.clickSubmit();

        String actualText = loginPage.getErrorText("[class='form-group has-error'] div");
        Assert.assertEquals(actualText, "Password is required");
    }

    // Implementation methods



//    @Test
//    public void сookiesExample() throws InterruptedException {
////        driver.get("https://kwidos.tk/auth/login");
//        openLoginPage();
//        enterEmail("azat+3@testpro.io");
//        enterPassword("Qwerty2@");
//        clickSubmit();
//
//        driver.findElement(By.xpath("//*[contains(text(), 'GO TO PROFILE')]"));
//
//        Thread.sleep(3000);
//
//        driver.manage().deleteAllCookies();
//
//        Thread.sleep(3000);
//        driver.get("https://kwidos.tk");

        //azat+3@testpro.io
        //Qwerty2@

//
//        driver.manage().deleteAllCookies();
//        driver.get("https://kwidos.tk");
//    }




}
