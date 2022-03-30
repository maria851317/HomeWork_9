package SM_Lecture3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;


public class ShopPragmatic{

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\BrowserDrivers\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://shop.pragmatic.bg/admin");
    }


    @Test
    public void testExample1(){
        WebElement element= driver.findElement(By.id("input-username"));
        element.sendKeys("admin");
    }

    @Test
    public void testExample2(){
        WebElement element= driver.findElement(By.id("input-password"));
        element.sendKeys("parola123!");

    }

    @Test
    public void testExample3(){
        WebElement element=driver.findElement(By.tagName("button"));
        element.click();

    }

    @Test
    public void testExample4(){
        WebElement element = driver.findElement(By.partialLinkText("dashboard&user_token"));
        assertEquals(element.getText(),"Dashboard");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}


