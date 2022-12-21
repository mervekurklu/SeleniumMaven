package Day04_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task01 {
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
        //https://id.heroku.com/login sayfasına gidiniz.
        driver.get("https://id.heroku.com/login");
        //Bir mail adresi giriniz.
        WebElement searchButton = driver.findElement(By.name("email"));
        searchButton.sendKeys("abcde@gmail.com");
        //Bir password giriniz.
        WebElement passwordButton = driver.findElement(By.id("password"));
        passwordButton.sendKeys("123456"+Keys.ENTER);
        //"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
        WebElement textname= driver.findElement(By.xpath("//div[text()='There was a problem with your login.']"));
        if (textname.isDisplayed()){
            System.out.println("Kayıt yapılamadı");

        }else System.out.println("Kayıt yapıldııığğ");












    }
}
