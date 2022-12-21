package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.List;

public class C02_Dropdown {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void selectByIndex(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        //Dropdown locate edildi
        WebElement drpDown = driver.findElement(By.name("country"));
        // LOCATE EDİLEN SELECT DRPDOWN SELECT OBJ DONUSTU
        Select select=new Select(drpDown);
        select.selectByIndex(3);// ANDORRA selectbyındex 0 ile başlar


    }

    @Test
    public void selectByValue(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement drpDown = driver.findElement(By.name("country"));
        // LOCATE EDİLEN SELECT DRPDOWN SELECT OBJ DONUSTU
        Select select=new Select(drpDown);
        select.selectByValue("TURKEY");

    }

    @Test
    public void selectByVisibleText(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement drpDown = driver.findElement(By.name("country"));
        // LOCATE EDİLEN SELECT DRPDOWN SELECT OBJ DONUSTU
        Select select=new Select(drpDown);
        select.selectByVisibleText("NEPAL");


    }
    @Test
    public void multipleSelect(){

        driver.get("https://output.jsbin.com/osebed/2");

        //Dropdown locate ediliyor
        Select select = new Select(driver.findElement(By.id("fruits")));

        System.out.println(select.isMultiple());

        select.selectByValue("apple");

        select.selectByIndex(3);  //Grape

    }

    @Test
    public void getOption(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        Select select= new Select(driver.findElement(By.name("country")));
        List<WebElement> options = select.getOptions();
        for (WebElement option:options) {
            System.out.println(option.getText());// tüm country listesini yazdırdı burada..
        }
        // options.stream().forEach(x-> System.out.println(x.getText()));
    }
    @Test
    public void getFirstSelectedOption(){
        driver.get("https://output.jsbin.com/osebed/2");
        Select select= new Select(driver.findElement(By.id("fruits")));
        select.selectByIndex(3);// Grape
        select.selectByIndex(2);// Orange
        WebElement selectedOption = select.getFirstSelectedOption();// Web element yazmazsak referan geldi ama atadık sonra yazdırdık
        System.out.println(selectedOption.getText());
        //getFirstSelectedOption() metodu secili olan ilk option elementini bize verir. (Sectigimiz ilk option degil !!!)

    }
    @Test
    public void gelAllSelectedOptions(){
        driver.get("https://output.jsbin.com/osebed/2");
        Select select= new Select(driver.findElement(By.id("fruiıt")));
        select.selectByValue("banana");
        select.selectByValue("apple");
        List<WebElement>selectedOptions = select.getAllSelectedOptions();
        System.out.println(selectedOptions.get(0).getText());
       // selectedOptions.forEach(x-> System.out.println(x.getText()));

    }





}
