package browserTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;

/**
 * Created by abarabash on 7/25/16.
 */
public class Day4 extends BaseTest {

    @Test
    public void upLoadFile() throws InterruptedException {

        String fileName = "some-file.txt";

        File file = new File(fileName);

        String absolutePath = file.getAbsolutePath();

        driver.get("http://the-internet.herokuapp.com/upload");

        driver.findElement(By.id("file-upload")).sendKeys(absolutePath);

        driver.findElement(By.id(("file-submit"))).click();


        WebElement uploadedFilesTextField = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("uploaded-files@")));

        String actualFileName = uploadedFilesTextField.getText();

        Assert.assertEquals(actualFileName, fileName);

    }

    @Test
    public void javaScriptAlertTest() {

        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath(".//*[@id='content']/div/ul/li[1]/button")).click();

        Alert popup = driver.switchTo().alert();

        popup.accept();

        String resultMessage = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(resultMessage, "You successfuly clicked an alert");

    }

    @Test
    public void JavaScriptAlertTest3() throws AWTException {

        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector(".example li:nth-child(3) button")).click();
        Alert popup = driver.switchTo().alert();

        //popup


    }



}
