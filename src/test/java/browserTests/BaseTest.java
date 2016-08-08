package browserTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by abarabash on 7/18/16.
 */
public class BaseTest {

    public static WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    public void setUpDefault(String browserName) throws MalformedURLException {

        //setUpBrowser();

        System.out.println("Set up tests for " + browserName);

        driver = sauseLabsSetUp(browserName);


    }

    @AfterTest
    public void afterAllTests() {

        driver.quit();

    }

    private void setUpGeckoDriver() {

        String userdir = System.getProperty("user.dir");

        String path = userdir + "/src/test/resources/geckodriver";

        System.setProperty("webdriver.gecko.driver", path);

    }

    private WebDriver sauseLabsSetUp(String browserName) throws MalformedURLException {

        String USERNAME = "abarabash";
        String ACCESS_KEY = "56f0639b-4260-4600-873b-f118205efa4c";

        String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.BROWSER_NAME, browserName);
        caps.setCapability("platform", "Yosemite");
        caps.setCapability("version", "46.0");

        caps.setCapability("name", "MyTestAutomationSuite");

        System.out.println("Launching instance at " + URL);
        return new RemoteWebDriver(new URL(URL), caps);


    }


}
