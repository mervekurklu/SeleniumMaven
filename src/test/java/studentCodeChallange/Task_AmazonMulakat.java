package studentCodeChallange;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

public class Task_AmazonMulakat extends BaseTest {
    /*
    o https://www.amazon.com.tr/ sitesi açılır.
    o Ana sayfanın açıldığı kontrol edilir.
    o Çerez tercihlerinden Çerezleri kabul et seçilir.
    o Siteye login olunur.
    o Login işlemi kontrol edilir.
    o Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
    o Bilgisayar kategorisi seçildiği kontrol edilir.
    o Arama alanına MSI yazılır ve arama yapılır.
    o Arama yapıldığı kontrol edilir.
    o Arama sonuçları sayfasından 2. sayfa açılır.
    o 2. sayfanın açıldığı kontrol edilir.
    o Sayfadaki 2. ürün favorilere eklenir.
            o 2. Ürünün favorilere eklendiği kontrol edilir.
    o Hesabım > Favori Listem sayfasına gidilir.
    o “Favori Listem” sayfası açıldığı kontrol edilir.
o Eklenen ürün favorilerden silinir.
o Silme işleminin gerçekleştiği kontrol edilir.
o Üye çıkış işlemi yapılır.
o Çıkış işleminin yapıldığı kontrol edilir. */


    @Test
    public void test(){
        driver.get("https://www.amazon.com.tr/");
        String homePageTitle=driver.getTitle();
        Assert.assertTrue(homePageTitle.contains("Amazon.com.tr:"));
        WebElement cerezler= driver.findElement(By.name("accept"));
        cerezler.click();
        Actions action =new Actions(driver);
        action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1")));
        WebElement loginButton= driver.findElement(By.linkText("Giriş yap"));
        loginButton.click();
        WebElement eposta= driver.findElement(By.id("ap_email"));
        eposta.sendKeys("mervekurklu9393@gmail.com"+Keys.ENTER);
        WebElement password = driver.findElement(By.id("ap_password"));
        password.sendKeys("merve710606"+Keys.ENTER);
        WebElement loginControl= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Assert.assertTrue(!loginControl.getText().contains("Merhaba, Giriş yapın"));
        WebElement categories= driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(categories);
        select.selectByValue("search-alias=computers");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Bilgisayarlar");
        WebElement searcbox= driver.findElement(By.id("twotabsearchtextbox"));
        searcbox.sendKeys("MSI"+Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).isDisplayed());
        WebElement ikinciSayfa= driver.findElement(By.linkText("2"));
        ikinciSayfa.click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[@aria-label='Geçerli sayfa, sayfa 2']")).isDisplayed());
        WebElement icon = driver.findElement(By.xpath("(//div[@class='s-easy-mode-ingress-background'])[2]"));
        icon.click();
        WebElement listeyeEkleTıkla=driver.findElement(By.xpath("(//input[@class='a-button-input'])[2]"));
        listeyeEkleTıkla.click();




    }

}
