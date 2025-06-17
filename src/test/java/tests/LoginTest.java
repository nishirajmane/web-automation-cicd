package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void loginSuccess() {
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        loginBtn.click();

        WebElement successMsg = driver.findElement(By.cssSelector(".flash.success"));
        assert successMsg.isDisplayed();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
