package browserTests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created by abarabash on 7/28/16.
 */
public class Day5 extends BaseTest {

    @Test
    public void keyboardKeys() {

        driver.get("http://the-internet.herokuapp.com/key_presses");

        WebElement webElement = driver.findElement(By.id("content"));

        webElement.sendKeys(Keys.SPACE);

        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("SPACE"));
    }

    @Test
    public void multipleWindows() {

        driver.get("http://the-internet.herokuapp.com/windows");

        driver.findElement(By.cssSelector(".example>a")).click();

        Object[] allWindows = driver.getWindowHandles().toArray();
        driver.switchTo().window(allWindows[0].toString());
        Assert.assertNotEquals(driver.getTitle(), "New Window");

        String secondWindowHandle = allWindows[1].toString();

        driver.switchTo().window(secondWindowHandle);

        Assert.assertEquals(driver.getTitle(), "New Window");


    }


}
