package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Task04 {
    /*
- https://demoqa.com/select-menu sitesine gidin
            - Multiple select yapabileceginiz <select> elementini locate edin
- Birden fazla secim yapip secimlerinizi DOGRULAyin

     */
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void selectMethod(){
        driver.get("https://demoqa.com/select-menu");
        WebElement dropdown = driver.findElement(By.id("cars"));
        Select select =new Select(dropdown);
        System.out.println(select.isMultiple());
        select.selectByVisibleText("Volvo");
        select.selectByIndex(2);
        select.selectByValue("audi");


    }
}
