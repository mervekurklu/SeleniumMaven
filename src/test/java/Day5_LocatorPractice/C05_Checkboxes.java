package Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_Checkboxes {
    //    Go to URL: https://demoqa.com/
    //    Click on Elements.
    //    Click on Checkbox.
    //    Verify if Home checkbox is selected.
    //    Verify that "You have selected" is visible.
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test(){
        driver.get("https://demoqa.com/");
        WebElement elementButton= driver.findElement(By.xpath("//div[@class='avatar mx-auto white']"));
        elementButton.click();
        WebElement checkboxButton = driver.findElement(By.xpath("//span[text()='Check Box']"));
        checkboxButton.click();
        WebElement homeButton = driver.findElement(By.className("rct-checkbox"));
        Assert.assertTrue("Seçili değil", !homeButton.isSelected());
        homeButton.click();
        WebElement homeButtonMesage= driver.findElement(By.id("result"));
        Assert.assertTrue("Mesaj görünmüyor", homeButtonMesage.isDisplayed());
    }
}