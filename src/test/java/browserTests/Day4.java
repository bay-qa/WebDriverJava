package browserTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by abarabash on 7/25/16.
 */
public class Day4 extends BaseTest {

    @Test
    public void upLoadFile() {

        String fileName = "some-file.txt";

        File file = new File(fileName);

        String absolutePath = file.getAbsolutePath();

        driver.get("http://the-internet.herokuapp.com/upload");

        driver.findElement(By.id("file-upload")).sendKeys(absolutePath);

        driver.findElement(By.id(("file-submit"))).click();


    }


}
