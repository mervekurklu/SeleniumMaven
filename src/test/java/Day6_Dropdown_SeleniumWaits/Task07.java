package Day6_Dropdown_SeleniumWaits;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

import java.util.List;

public class Task07 extends BaseTest {
    /*
    Go to URL: https://opensource-demo.orangehrmlive.com/
Login with Username: Admin
Login with Password: admin123
Click login button
Click on PIM
Click on Employee List
    Employee Name -> Use Faker Class
    ID -> Use Faker Class
    Employment Status -> select by index: 2
    Include -> selectByVisibleText: Current and Past Employees
    Supervisor Name -> Use Faker Class
    Job Title ->selectByValue: IT Manager
    Sub Unit ->selectByValue: 3
Click search button
Verify text visible : "No Records Found"
     */



    @Test
    public void adminTest(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement userName= driver.findElement(By.name("username"));
        userName.sendKeys("Admin");
        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        WebElement login= driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        WebElement pim= driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[2]"));
        pim.click();
        WebElement employeList= driver.findElement(By.xpath("//a[text()='Employee List']"));
        employeList.click();
        Faker faker=new Faker();
        WebElement employeeName = driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]"));
        employeeName.sendKeys(faker.name().firstName());
        WebElement employeeId= driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
        employeeId.sendKeys(faker.idNumber().invalid());
        //WebElement dropDown =driver.findElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]"));
        //dropDown.click();
        // Select select=new Select(dropDown);
        // select.selectByIndex(2);
        WebElement dropDown1 =driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]"));
        dropDown1.click();
        Select select1=new Select(dropDown1);
        select1.selectByVisibleText("Current and Past Employees");
        //List<WebElement> links = driver.findElements(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]"));
        // links.get(2).click();




    }

}
