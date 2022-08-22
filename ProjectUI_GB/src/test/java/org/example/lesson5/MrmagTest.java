package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MrmagTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    private final static String MRMAG_BASE_URL = "https://mrmag.ru/";


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser () {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(MRMAG_BASE_URL);
    }

    @Test
    void AddInBoxTest()  {

        driver.findElement(
                By.xpath("//a[@href ='/shop/tekhnika_dlya_kukhni']//img[@alt = 'Техника для кухни']"))
                .click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class = 'category-name']//a[text() = 'Йогуртницы, мороженицы']")))
                .click();
        driver.findElement(
                By.xpath("//a[. = 'Йогуртница электрическая DELTA DL-8400, 20 Вт., объем контейнера 1л, белый с серо-зеленым']"))
                .click();
        driver.findElement(By.xpath("//div[@class = 'product-buy']//a")).click();


        Assertions.assertEquals(driver.findElement(By.xpath("//div//a[. = 'В корзине']")).isDisplayed(),true);


        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//b[@data-calc = 'result']")));
        Assertions.assertEquals(driver.findElement(
                By.xpath("//b[@data-calc = 'result']")).isDisplayed(),true);

        }

    @Test
    void InputTextForSearchTest() {
        driver.findElement(By.id("product_search")).sendKeys("Краска");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//li//a//span[. = 'Краска дорожная']")));
        actions.moveToElement(driver.findElement(By.xpath("//li//a//span[. = 'Краска дорожная']")))
                .click(driver.findElement(By.xpath("//li//a//span[. = 'Краска дорожная']")))
                .build()
                .perform();

        Assertions.assertEquals(driver.getCurrentUrl(), "https://mrmag.ru/shop/kraska-dorozhnaya/");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//h1//span")));

        }


    @AfterEach
    void quitBrowser() {
        driver.quit();
    }

}
