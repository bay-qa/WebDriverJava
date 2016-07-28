package browserTests;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created by abarabash on 7/28/16.
 */
public class Day5 extends BaseTest {

    @Test
    public void keyboardKeys() throws Exception {
        driver.get("http://the-internet.herokuapp.com/key_presses");
        // Option 1
        driver.findElement(By.id("content")).sendKeys(Keys.SPACE);
        assertThat(driver.findElement(By.id("result")).getText(), is("You entered: SPACE"));
    }


    @Test
    public void keyboardKeys2() throws Exception {
        driver.get("http://the-internet.herokuapp.com/key_presses");
        // Option 1
        driver.findElement(By.id("content")).sendKeys(Keys.SPACE);
        assertThat(driver.findElement(By.id("result")).getText(), is("You entered: SPACE"));
    }

    @Test
    public void multipleWindows() {
        driver.get("http://the-internet.herokuapp.com/windows");
        driver.findElement(By.cssSelector(".example a")).click();
        Object[] allWindows = driver.getWindowHandles().toArray();
        driver.switchTo().window(allWindows[0].toString());
        MatcherAssert.assertThat(driver.getTitle(), is(not("New Window")));
        driver.switchTo().window(allWindows[1].toString());
        MatcherAssert.assertThat(driver.getTitle(), is("New Window"));
    }

}
