package Day7_Iframe_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

import java.util.List;

public class Task06 extends BaseTest {
    /*
    - https://demoqa.com/select-menu sitesine gidin
- multiple <select> elementini locate edin
- getOptions(), getFirstSelectedOption(), getAllSelected() methodlarini kullanmak adina:
    * Farkli secimler yaparak methodlarinizi kullanin ve Assertion yapmayi unutmayin
     */



    @Test
    public void selecttest(){
        driver.get("https://demoqa.com/select-menu");
        Select select =new Select(driver.findElement(By.name("cars")));
        Assert.assertTrue(select.isMultiple());
        List<WebElement> options= select.getOptions();
        options.forEach(x-> System.out.println(x.getText()));
        options.get(3).click();
        options.get(0).click();
        System.out.println(select.getFirstSelectedOption().getText());
        List<WebElement> allSelect= select.getAllSelectedOptions();
        allSelect.forEach(x-> System.out.println(x.getText()));



    }


}
