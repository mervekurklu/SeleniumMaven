package Day03_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Practice {
    //    Go to https://www.linkedin.com/
//    When we write an e-mail without the @ sign in the e-mail box and press enter.
//    Let's test the "Invalid email address" warning.
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


    }
    @After
    public void tearDown(){
       // driver.close();

    }
    @Test
    public void xPathPractice(){
        // linkedin adresine gir
        driver.get("https://linkedin.com");
        // email alanına @ sembolu bulunmayan bir mail adresi gir
        driver.findElement(By.xpath("//input[@id='session_key']")).sendKeys("mervekurklu9393gmail.com"+ Keys.ENTER);
        // 3. adım hata mesajı görüntülediğini doğrula
        WebElement allertmessage = driver.findElement(By.xpath("/p[@class='alert-content']"));
        Assert.assertTrue(allertmessage.isDisplayed());// ikiside true ise test geçer tam tersi ise kalır..
       // Assert.assertEquals(true,allertmessage.isDisplayed());
       // Assert.assertFalse(!allertmessage.isDisplayed());





    }
}
