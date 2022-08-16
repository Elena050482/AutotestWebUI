package org.example.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get("https://mrmag.ru/");
    }

    @Test
    void addInBoxTest() {

        new MainPage(driver).clickKitchenAppliancesButton().clickIceLink().clickYogurtMaker().addToBox();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[1]//b[@data-calc = 'result']")));
        Assertions.assertEquals(driver.findElement(By.xpath("//div[1]//b[@data-calc = 'result']")).isDisplayed(),true);

    }

    @AfterEach
    void killBrowser() {
        driver.quit();
    }
}
