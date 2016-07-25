package browserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by abarabash on 7/21/16.
 */
public class Day3 extends BaseTest {

    @Test
    public void nestedFrames() {

        driver.get("http://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-middle");

        assertEquals(driver.findElement((By.id("content"))).getText(), "MIDDLE");
    }

    @Test
    public void iFrames() {

        driver.get("http://the-internet.herokuapp.com/tinymce");

        driver.switchTo().frame("mce_0_ifr");

        WebElement textBody = driver.findElement(By.id("tinymce"));

        String textFromTextBody = textBody.getText();

        textBody.clear();

        textBody.sendKeys("Hello World!");

        String afterText = textBody.getText();

        assertEquals(afterText, "Hello World!");

        driver.switchTo().defaultContent();

        String textFromTheDefaultContent = driver.findElement(By.cssSelector(".example>h3")).getText();

        String expected = "An iFrame containing the TinyMCE WYSIWYG Editor";

        assertEquals(textFromTheDefaultContent, expected);


    }


}
