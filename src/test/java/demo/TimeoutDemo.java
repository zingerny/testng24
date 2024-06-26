package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TimeoutDemo {

    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void Setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }



    @Test
    public void testValidLogin() throws InterruptedException {

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB,"test", Keys.ENTER);
        Thread.sleep(2000000);
        Assert.assertEquals(driver.getTitle(),"Web Orders");
    }

    @Test (dependsOnMethods = "testValidLogin")
    public void testDeleteSelected() throws InterruptedException {
    List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
            checkbox.click();}
          driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(500);
            Assert.assertTrue(driver.getPageSource().contains("List of orders is empty."));
        }



    }

