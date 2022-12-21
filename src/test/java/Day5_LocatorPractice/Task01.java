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

public class Task01 {
     //Go to URL: https://demoqa.com/radio-button
     //Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.
    //Her bir seçenek seçildiğinde aşağıda çıkan text’leri konsolda yazdırınız.

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
         driver.quit();
    }
@Test
    public void test(){
        driver.get("https://demoqa.com/radio-button");
    WebElement yesRadio = driver.findElement(By.xpath("//label[@for='yesRadio']"));
    yesRadio.click();
    Assert.assertTrue("yes seçilmiyor",!yesRadio.isSelected());
    WebElement yesText= driver.findElement(By.xpath("//p[@class='mt-3']"));
    System.out.println("yesText.getText() = " + yesText.getText());


    WebElement impressiveRadio = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
    impressiveRadio.click();
    WebElement impressiveText= driver.findElement(By.xpath("//p[@class='mt-3']"));
    System.out.println("noText.getText() = " + impressiveText.getText());


    WebElement noRadio = driver.findElement(By.xpath("//label[@for='noRadio']"));
    noRadio.click();
    Assert.assertTrue("No seçilmiyor",noRadio.isSelected());

}

}
