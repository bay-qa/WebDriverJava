package browserTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest {


    public static WebDriver driver;


    @BeforeSuite
    public void setUpDefault() throws IOException {

        setBrowser();

        driver = new FirefoxDriver();
    }



    private void setBrowser() {
        String path = "/Users/abarabash/Documents/MyProject/java-test-pack/src/test/resources/geckodriver";
        System.setProperty("webdriver.gecko.driver", path);
    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
