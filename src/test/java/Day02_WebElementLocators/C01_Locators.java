package Day02_WebElementLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Locators {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://linkedin.com");
        driver.manage().window().maximize();


    }
    @After
    public void tearDown(){
       // driver.quit();
    }


    @Test
    public void idLocator(){
        //idLocator->"session_key"

        WebElement email= driver.findElement(By.id("session_key"));
        email.sendKeys("selenium dersinden selamlar...");//herhangi bir değer döndürmez sendkeys


    }
    @Test
    public void nameLocator(){
        //name locators ->session_password
        WebElement passwordField=driver.findElement(By.name("session_password"));
        passwordField.sendKeys("Sifre ");

    }
    @Test
    public void classLocators(){
        // class locators->"input_input"
        WebElement email=driver.findElement(By.className("input__input"));
        email.sendKeys("Class locator test");
    }
    @Test
    public void tagLocator(){
        //Taglocators -> input
       List<WebElement> emailList=driver.findElements(By.tagName("input"));

       // 2. elementimiz email test alanımız bu yüzden bu elamnı email değişken
       WebElement email=emailList.get(1);
       email.sendKeys("Tag locators test");

    }
    @Test
    public  void linkTestLocator(){
        //link test : Şifrenizi mi unuttunuz?
        WebElement forgotPassword =driver.findElement(By.linkText("Şifrenizi mi unuttunuz?"));
        forgotPassword.click();
    }

    @Test
    public  void partialLinkTest(){
        WebElement test =driver.findElement(By.partialLinkText("forgot"));

    }
    @Test
    public void absoluteXpath(){
        WebElement email = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[2]/div[1]/input"));
        email.sendKeys("merve absolute xpath tamamladı");

    }
    @Test
    public void relativeXpath(){
        // Xpath locator -> //input[@name='session_key']
        WebElement email = driver.findElement(By.xpath("//input[@name='session_key']"));
        email.sendKeys("merve relative xpath tamamladı");

    }
    @Test
    public void multipleAttributeXpath(){
        // Xpath locator -> //input[@name='session_key']
        WebElement email = driver.findElement(By.xpath("//input[@class='input__input'][@name='session_key']"));
        email.sendKeys("merve relative xpath tamamladı");

    }
    public void andOrXpath(){
        // Xpath locator -> //input[@name='session_key']
        WebElement email = driver.findElement(By.xpath("//input[@class='input__input'and @name='session_key']"));
        email.sendKeys("merve relative xpath tamamladı");

    }
    @Test
    public void containsXpath(){
        // xpath locator -> //input[contains(@name, 'key')]

        WebElement email = driver.findElement(By.xpath("//input[contains(@id, 'session')]"));
        email.sendKeys("Karl relative xpath konusunu gayet basirili tamamladi");
    }
    @Test
    public void containsXpath1(){
        // xpath locator -> //input[contains(@name, 'key')]

        WebElement email = driver.findElement(By.xpath("//input[contains(@name, 'key')]"));
        email.sendKeys("Karl relative xpath konusunu gayet basirili tamamladi");
    }




}
