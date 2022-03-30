package SM_Lecture3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.util.TimeUtils;

import java.util.concurrent.TimeUnit;

public class LoginTest_HWS {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://shop.pragmatic.bg/admin");
    }

    @Test
    public void loginTest() {
        WebElement usernameInput = driver.findElement(By.id("input-username"));
        usernameInput.sendKeys("admin");
        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys("parola123!");
        driver.findElement(By.cssSelector(".btn-primary")).click();

        WebElement userInfo = driver.findElement(By.xpath("//*[@id='user-profile']/.."));

        assertEquals(userInfo.getText(), "Milen Strahinski");
    }


    @AfterMethod
    public void tearDown()
    { driver.quit();}

}
