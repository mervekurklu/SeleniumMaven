package studentCodeChallange;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Task_S01 {
    @Test
    public void test() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1-->git->"https://amazon.com"
        driver.get("https://amazon.com");
        //2-->arama kutusundan "all" dan "Electronic" seç
        Select select = new Select(driver.findElement(By.cssSelector("#searchDropdownBox")));
        select.selectByValue("search-alias=electronics-intl-ship");
        //3-->arama butonuna "tv" yazdır
        driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("tv" + Keys.ENTER);
        //4-->"2. sayfaya" git
        driver.findElement(By.xpath("//a[@aria-label=\"Go to page 2\"]")).click();
        //5-->tv  sepete ekle
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
        //6-->sepete git
        driver.findElement(By.xpath("//span[@id=\"nav-cart-count\"]")).click();
        //7-->Proceed to checkout' a tıkla
        driver.findElement(By.name("proceedToRetailCheckout")).click();
        //8-->"Email or mobile phone number" gir
        driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("ebikgabık@gmail.com");
        //9-->"continue" butonuna tıkla
        driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();
        //10--->"There was a problem" yazısının görüntülendiğini kontrol et
        Assert.assertTrue(driver.findElement(By.xpath("//h4[.='There was a problem']")).isDisplayed());
        //11-->Taraycı kapat
        driver.quit();


    }
}
