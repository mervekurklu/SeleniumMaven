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

public class C04_Checkboxes {

    //    Go to https://the-internet.herokuapp.com/checkboxes
//    Locate the elements of checkboxes.
//    Then click on checkbox 1 if box is not selected.
//    Then click on checkbox 2 if box is not selected.
//    Then verify that checkbox 1 is checked.
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
       driver.quit();
    }
    @Test
    public void CheckBoxes(){
        driver.get("https://the-internet.herokuapp.com/checkboxes ");
        List<WebElement> checboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        WebElement checkboxes1=checboxes.get(0);
        WebElement checkboxes2=checboxes.get(1);
        // Checbox 1 seçili değilse tıklıyorz
        if (!checkboxes1.isSelected()){// select seç demek
            checkboxes1.click();
        }
        // Checbox 2 seçili değilse tıklıyorz
        if (!checkboxes2.isSelected()){
            checkboxes2.click();
        }
        // Checbox ların seçili olduğunun kontrolune bakıldı..
        Assert.assertTrue(checkboxes1.isSelected());
        Assert.assertTrue(checkboxes2.isSelected());

    }

}
