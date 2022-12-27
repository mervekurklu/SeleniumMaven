package Day8_WindowHandles_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;



public class C02_Actions extends BaseTest {

    /*
Go to URL: https://demoqa.com/buttons
Run the buttons on the page using the Actions Class.Actions Class'ı kullanarak sayfadaki düğmeleri çalıştırın.
Verify the texts that appear after the buttons are operated.Düğmeler çalıştırıldıktan sonra
görünen metinleri doğrulayın
 */
    @Test
    public void doubleClick(){
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClick= driver.findElement(By.id("doubleClickBtn"));
        Actions action= new Actions(driver);
        action.doubleClick(doubleClick).perform();
        Assert.assertTrue(driver.findElement(By.id("doubleClickMessage")).isDisplayed());


    }
    @Test
    public void rightClick(){
        driver.get("https://demoqa.com/buttons");
        WebElement rightClick= driver.findElement(By.id("rightClickBtn"));
        Actions action= new Actions(driver);
        action.contextClick(rightClick).build().perform();
        WebElement rightClickMesage =driver.findElement(By.id("rightClickMessage"));
        Assert.assertTrue(rightClickMesage.isDisplayed());


    }
    @Test
    public void click(){

        driver.get("https://demoqa.com/buttons");

        WebElement clickBtn = driver.findElement(By.xpath("//button[.='Click Me']"));
        Actions actions = new Actions(driver);

        actions.click(clickBtn).build().perform();

        WebElement dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertTrue(dynamicClickMessage.isDisplayed());

    }

}
