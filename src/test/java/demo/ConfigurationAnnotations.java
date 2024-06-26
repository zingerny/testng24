package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ConfigurationAnnotations {

WebDriver driver;
@BeforeSuite
public void beforeSuite(){
    System.out.println("Before Suite: establishing db connection, creating a report object");
}

@AfterSuite
public void afterSuite(){
    System.out.println("After Suite: Closing db connection, generate a report");
}
    @BeforeMethod
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        System.out.println("Before Method");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");       driver.quit();
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("before class");// run once before everything that is in a class.
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }
    @Test
    public void testGoogle2() throws InterruptedException {

        driver.get("https://www.google.com/");
        String searchTerm = "tumbler";
        driver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);
        Thread.sleep(500);
        Assert.assertTrue(driver.getTitle().contains(searchTerm));
        System.out.println("Test Google2");


        driver.quit();

    }

    @Test(enabled = false, priority = -1)
    public void testGoogle3() throws InterruptedException {
        driver.get("https://www.google.com/");
        String searchTerm = "screen protector";
        driver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);
        Thread.sleep(500);
        Assert.assertTrue(driver.getTitle().contains(searchTerm));
        System.out.println("TestGoogle3");

    }
}
