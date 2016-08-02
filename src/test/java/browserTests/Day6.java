package browserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by abarabash on 8/1/16.
 */
public class Day6 extends BaseTest {

    @Test
    public void dropdownTest() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdownList = driver.findElement(By.id("dropdown"));
        List<WebElement> options = dropdownList.findElements(By.tagName("option"));
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().equals("Option 1")) {
                options.get(i).click();
            }
        }
        String selectedOption = "";
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).isSelected()) {
                selectedOption = options.get(i).getText();
            }
        }
        assertTrue(selectedOption.contains("Option 1"));
    }

    @Test
    public void dropdownTestDiffWay() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select selectList = new Select(driver.findElement(By.id("dropdown")));
        selectList.selectByVisibleText("Option 1");
        // You could also use select.selectByValue("1");

        assertTrue(selectList.getFirstSelectedOption().getText().contains("Option 1"));
    }

    @Test
    public void testDisabled() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));

        assertFalse(dropdown.getOptions().get(0).isEnabled());
    }

}
