package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrizationSimple {
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
@Parameters({"usr", "pass"})
public void testValidaLogin( String username, String password){
        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");
        driver.findElement(By.id("loginUsername")).sendKeys(username, Keys.TAB, password,Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("You Might Also Like"));
    }
}
