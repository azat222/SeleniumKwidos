import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ServiceProviderSignUp extends BaseTest{



    @DataProvider(name = "ServiceRegistrationData")
    public Object[][] getDataFromDataProvider() {
        return new Object [][] {
                {"", "zakuanov", "test pro", "8183453434", "azat@testpro.io", "Password", "Please add firstname"},
                {"azat", "", "test pro", "8183453434", "azat@testpro.io", "Password", "Please add lastname"},
                {"azat", "zakuanov", "", "8183453434", "azat@testpro.io", "Password", "Please add BN"},
                {"azat", "zakuanov", "test pro", "", "azat@testpro.io", "Password", "Please add email"},
                {"azat", "zakuanov", "test pro", "8183453434", "", "Password", "Please add firstname"},
                {"azat", "zakuanov", "test pro", "8183453434", "azat+test@testpro.io", "Password@2", "Please add firstname"}
        };
    }



    @Test(dataProvider = "ServiceRegistrationData")
    public void ServiceProviderRegistrationTest (String firstName, String lastName, String BN, String PH, String email, String password, String expErrorText) throws InterruptedException {

//        driver.get("https://kwidos.com/auth/register/contractor");


        Thread.sleep(4000);
        driver.findElement(By.cssSelector("[formcontrolname='firstName']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("[formcontrolname='lastName']")).sendKeys(lastName);
        driver.findElement(By.cssSelector("[formcontrolname='businessName']")).sendKeys(BN);
        driver.findElement(By.cssSelector("[formcontrolname='phone']")).sendKeys(PH);
        driver.findElement(By.cssSelector("[formcontrolname='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("[formcontrolname='password']")).sendKeys(password);
        //p-checkbox[class='ng-dirty ng-touched ng-invalid'] .ui-chkbox-icon.ui-clickable
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[class='col-lg-12 col-xs-12 col-md-12 checkbox-block'] p-checkbox")).click();
        driver.findElement(By.cssSelector("[type='submit']")).click();

        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.cssSelector("[class='alert alert-danger']")).getText(), expErrorText);

//        driver.quit();
//        driver.findElement(By.cssSelector("#password")).sendKeys("Password");
//
//        driver.findElement(By.cssSelector("[type='submit']")).click();
//
//        String actualText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
//
//        Assert.assertEquals(actualText, "Username or password is incorrect");

        //Username or password is incorrect

    }
}
