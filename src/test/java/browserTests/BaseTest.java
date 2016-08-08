package browserTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by abarabash on 7/18/16.
 */
public class BaseTest {

    public static WebDriver driver;

    @BeforeSuite
    public void setUpDefault() throws MalformedURLException {

        //setUpBrowser();

        driver = sauseLabsSetUp();


    }

    @AfterSuite
    public void afterAllTests() {

        driver.quit();

    }

    private void setUpGeckoDriver() {

        String userdir = System.getProperty("user.dir");

        String path = userdir + "/src/test/resources/geckodriver";

        System.setProperty("webdriver.gecko.driver", path);

    }

    private WebDriver sauseLabsSetUp() throws MalformedURLException {

        String USERNAME = "abarabash";
        String ACCESS_KEY = "56f0639b-4260-4600-873b-f118205efa4c";

        String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows XP");
        caps.setCapability("version", "43.0");

        return new RemoteWebDriver(new URL(URL), caps);


    }


}
