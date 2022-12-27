package studentCodeChallange;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

import java.util.Set;

public class G07_Task extends BaseTest {
    /*
    1- https://the-internet.herokuapp.com/context_menu sitesine gidelim.
    2- Çizili alan üzerinde sağ click yapalım.
    3- Alert'te çıkan yazının "You selected a context menu" olduğunu test edelim.
    4- Tamam diyerek Alert'i kapatalım.
    5- Elemental Selenium linkine tıklayalım.
    6- Açılan sayfada h1 tagında "Elemental Selenium" yazdığını test edelim.
 */
    @Test
    public void test(){

        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);
        WebElement box = driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();//sağ clic demek js bir alert çünkü sağ clic yapabiliyorum

        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        String firstPageHandle = driver.getWindowHandle();// ikinci sayfaya tıklamadan önce 1. sayfanın window handle değerini aldık burada

        driver.findElement(By.linkText("Elemental Selenium")).click();


        Set<String> allWindowPageHandle = driver.getWindowHandles();
        String secondPageHandle = "";

        for (String each: allWindowPageHandle){
            if (!each.equals(firstPageHandle)){
                secondPageHandle = each;// ikinci sayfamın handle değerine atadım burada
            }
        }

        driver.switchTo().window(secondPageHandle);// şuan 2. sayfadayım


        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Elemental Selenium", "İkinci sayfadaki text istenenden farklı.");

    }
}
