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
    public void dropDownTest() {

        driver.get("http://the-internet.herokuapp.com/dropdown");

        WebElement dropdownList = driver.findElement(By.id("dropdown"));

        List<WebElement> optionsFromList = dropdownList.findElements(By.tagName("option"));

        for (int i = 0; i < optionsFromList.size(); i++) {

            if (optionsFromList.get(i).getText().equals("Option 1")) {
                optionsFromList.get(i).click();
            }
        }

        String selectedOption = "";

        for (int i = 0; i < optionsFromList.size(); i++) {
            if (optionsFromList.get(i).isSelected()) {
                selectedOption = optionsFromList.get(i).getText();
            }
        }

        assertTrue(selectedOption.contains("Option 1"));
    }

    @Test
    public void dropDownTestDiffWay() {

        driver.get("http://the-internet.herokuapp.com/dropdown");

        Select dropDownList = new Select(driver.findElement(By.id("dropdown")));

        dropDownList.selectByVisibleText("Option 1");

        //dropDownList.selectByValue("1");

        assertTrue(dropDownList.getFirstSelectedOption().getText().contains("Option 1"));
    }


    @Test
    public void testDisabled() {

        driver.get("http://the-internet.herokuapp.com/dropdown");

        Select dropdown = new Select(driver.findElement(By.id("dropdown1")));

        List<WebElement> allOptions = dropdown.getOptions();

        assertTrue(!allOptions.get(0).isEnabled());

    }


}
