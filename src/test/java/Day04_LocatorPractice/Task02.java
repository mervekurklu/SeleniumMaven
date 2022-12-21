package Day04_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task02 {
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
       //driver.quit();
    }
    @Test
    public void test(){
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
        WebElement calculatetest = driver.findElement(By.id("calculatetest"));
        calculatetest.click();
        WebElement buttonText1 = driver.findElement(By.name("number1"));
        buttonText1.sendKeys("10");
        WebElement buttonText2 = driver.findElement(By.id("number2"));
        buttonText2.sendKeys("20");
        WebElement Calculateclick = driver.findElement(By.xpath("//input[@value='Calculate']"));
        Calculateclick.click();
        WebElement answer = driver.findElement(By.xpath("//p[text()='Answer : ']"));
        System.out.println(answer.getText());


    }

}
