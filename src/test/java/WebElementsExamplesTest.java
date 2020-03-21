import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class WebElementsExamplesTest extends BaseTest {

    @Test
    public void dropDownExample() throws InterruptedException {

        driver.get("http://demo.guru99.com/test/newtours/register.php");

        Select dropdown = new Select(driver.findElement(By.cssSelector("[name='country']")));
//        dropdown.selectByVisibleText("ARGENTINA");
        dropdown.selectByIndex(5);

        WebElement option = dropdown.getFirstSelectedOption();
        System.out.println(option.getText());


        List<WebElement> options = dropdown.getOptions();

//        List<WebElement> options = driver.findElements(By.cssSelector("select option"));


        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }

        Thread.sleep(5000);


    }

    @Test
    public void checkBoxExample() throws InterruptedException {

        driver.get("http://demo.guru99.com/test/radio.html");

        Thread.sleep(2000);

        WebElement checkbox = driver.findElement(By.id("vfb-6-1"));
//        driver.findElement(By.cssSelector("#vfb-6-1"));
//        driver.findElement(By.xpath("//*[@id='vfb-6-1']"));

        checkbox.click();

        Thread.sleep(2000);

        Assert.assertTrue(checkbox.isSelected());


    }

    @Test
    public void alertExample() throws InterruptedException {

        driver.get("http://demo.guru99.com/test/delete_customer.php");

        driver.findElement(By.cssSelector("[name='submit']")).click();

        System.out.println(driver.switchTo().alert().getText());

        Thread.sleep(2000);


    }
}
