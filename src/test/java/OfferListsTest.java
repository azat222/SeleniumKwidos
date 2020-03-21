import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class OfferListsTest extends BaseTest {


    //
    @Test
    public void OfferListSizeTest () throws InterruptedException {
        driver.get("https://kwidos.tk/offer/search");
        Thread.sleep(2000);

        List<WebElement> cardLists =  driver.findElements(By.cssSelector("[class*='card-shape']"));
        Assert.assertEquals(cardLists.size(), 10);

    }

    @Test
    public void FilterByServiceTypeTest () throws InterruptedException {
        driver.get("https://kwidos.com/offer/search");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[contains(text(), 'Service Type')]/../p-multiselect")).click();
        driver.findElement(By.xpath("//label[contains(text(), 'Air conditioning')]")).click();
        Thread.sleep(2000);

        List<WebElement> serviceTypeCards =  driver.findElements(By.cssSelector("[class*='service-type-flex']"));

        // 3D Capture

        for(WebElement element: serviceTypeCards) {
//            System.out.println(element.getText());
            Assert.assertEquals(element.getText(), "Air conditioning");
        }

//        System.out.println(serviceTypeCards);





    }


}
