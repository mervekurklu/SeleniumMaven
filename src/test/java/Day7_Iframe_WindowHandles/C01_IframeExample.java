package Day7_Iframe_WindowHandles;

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

public class C01_IframeExample {

    //        Go to URL: https://the-internet.herokuapp.com/iframe
//        Verify the Bolded text contains "Editor"
//        Locate the text box
//        Delete the text in the text box
//        Type "Hi everyone"
//        Verify the text Elemental Selenium text is displayed on the page.
    WebDriver driver;

    @Before
    public void setup(){
        //Driver ile ilgili her turlu initial(baslangic) islemi burada yapilir
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        // test sonrasinda driver kapatmak (varsa raporlari dosyalamak) icin kullanilir.
        //driver.quit();
    }
    @Test
    public void ıframetext(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement boldedtext= driver.findElement(By.tagName("h3"));
        String text=boldedtext.getText();
        // Verify the Bolded text contains "Editor"
        Assert.assertTrue(text.contains("Editor"));
        driver.switchTo().frame(0);
        WebElement textbox =driver.findElement(By.id("tinymce"));
        textbox.clear();
        textbox.sendKeys("Hi everyone");
        driver.switchTo().defaultContent();// iframe de işin bitinve bunu yaz
        Assert.assertTrue(driver.findElement(By.partialLinkText("Elemental")).isDisplayed());
    }

}
