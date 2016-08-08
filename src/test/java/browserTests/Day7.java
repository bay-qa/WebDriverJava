package browserTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;

/**
 * Created by abarabash on 8/4/16.
 */
public class Day7 extends BaseTest {

    @Test
    public void hoversTest() {

        driver.get("http://the-internet.herokuapp.com/hovers");

        WebElement avatar = driver.findElement(By.className("figure"));

        Actions actionBuilder = new Actions(driver);

        actionBuilder.moveToElement(avatar).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("figcaption")));

        assertTrue(driver.findElement(By.className("figcaption")).isDisplayed());
    }

    @Test(dataProvider = "hardCodedBrowsers")
    public void rightClickTest(String browser, String version, String os, Method method) throws MalformedURLException {

        driver = this.createSauseLabsBrowser(browser, version, os, method);

        System.out.println("rightClickTest starting...");

        driver.get("http://the-internet.herokuapp.com/context_menu");

        WebElement square = driver.findElement(By.id("hot-spot"));

        Actions action = new Actions(driver);

        action.contextClick(square)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();

        Alert alert = driver.switchTo().alert();

        assertTrue(alert.getText().contains("You selected a context menu"));


    }
}
