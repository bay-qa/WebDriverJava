package browserTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

/**
 * Created by abarabash on 7/18/16.
 */
public class BaseTest {

    public static WebDriver driver;

    @BeforeSuite
    public void setUpDefault() {

        setUpBrowser();

        driver = new FirefoxDriver();



    }

    private void setUpBrowser() {

        String path = "/Users/abarabash/Documents/MyProject/WebDriverJava/src/test/resources/geckodriver";

        System.setProperty("webdriver.gecko.driver", path);

    }


}
