package browserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by abarabash on 7/18/16.
 */
public class Day2 extends BaseTest{

    @Test
    public void checkboxDiscoveryTest(){

        System.out.println("checkBoxTest started");

        driver.get("http://the-internet.herokuapp.com/checkboxes");

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type=\"checkbox\"]"));

        System.out.println("using attribute for checkboxes");
        //iterating through the checkboxes list
        for (WebElement eachCheckbox : checkboxes){

            System.out.println(String.valueOf(eachCheckbox.getAttribute("checked")));
        }

        System.out.println("using isSelected for checkboxes");
        //iterating through the checkboxes list
        for (WebElement eachCheckbox : checkboxes){

            System.out.println(eachCheckbox.isSelected());
        }









    }



}
