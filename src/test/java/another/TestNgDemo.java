package another;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNgDemo {
    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test(priority = 1)
    public void testGoogle() throws InterruptedException {

        driver.get("https://www.google.com/");
        String searchTerm = "coffee mug";
        driver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);
        Thread.sleep(500);
        Assert.assertTrue(driver.getTitle().contains(searchTerm));




    }

    @Test(priority = 3)
    public void testGoogle2() throws InterruptedException {

        driver.get("https://www.google.com/");
        String searchTerm = "tumbler";
        driver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);
        Thread.sleep(500);
        Assert.assertTrue(driver.getTitle().contains(searchTerm));


        driver.quit();

    }

    @Test (priority = 2)
    public void testGoogle3() throws InterruptedException {
        driver.get("https://www.google.com/");
        String searchTerm = "screen protector";
        driver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);
        Thread.sleep(500);
        Assert.assertTrue(driver.getTitle().contains(searchTerm));

    }


}
