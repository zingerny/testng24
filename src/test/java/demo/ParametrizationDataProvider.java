package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParametrizationDataProvider {
WebDriver driver;

@AfterTest
public void tearDown(){
    driver.quit();
}


@Test(dataProvider = "getData")
public void testValidLogin( String username, String password){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");
        driver.findElement(By.id("loginUsername")).sendKeys(username, Keys.TAB, password,Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("You Might Also Like"));
        driver.quit();
    }

    @Test(dataProvider = "testData")
    public void testInvalidLogin( String username, String password){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");
        driver.findElement(By.id("loginUsername")).sendKeys(username, Keys.TAB, password,Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("You Might Also Like"));
        driver.quit();
    }


    @DataProvider
    public Object[][]  getData(){
        return new Object[][]{
                {"duotech2023", "duotech"},
                {"duotech2050", "duotech123"},
                {"coolherc2055", "coolherc"}
        };

    }
    @DataProvider(name = "testData")
    public Object[][]  getData2() throws FileNotFoundException {
        return Utility.readFromCSV("invalid.csv");

        }

    }

