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

public class Task03 {
    /*
    - https://demoqa.com/select-menu sitesine gidin
            - <select> elementini locate edin
- <select> elementinin seceneklerini yazdirin
- Sirasiyla selectByIndex, selectByValue, selectByVisibleText methodlarini kullanarak;
    * Yellow (index)
    * Purple (value)
    * Black  (text)
    seceneklerini secin

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
        //driver.quit();
    }
    @Test
    public void selectMethod(){
        driver.get("https://demoqa.com/select-menu");
        WebElement selectButton= driver.findElement(By.id("oldSelectMenu"));
        Select secim=new Select(selectButton);
        System.out.println(secim.isMultiple());
        secim.selectByIndex(3);
        secim.selectByValue("4");
        secim.selectByVisibleText("Black");


    }


}
