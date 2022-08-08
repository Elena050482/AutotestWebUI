package org.example.lesson3.mrmag;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InputTextForSearchTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mrmag.ru/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.id("product_search")).sendKeys("Краска дорожная");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href = '/shop/kraska-dorozhnaya/']//span[. = 'Краска дорожная']")));

        driver.findElement(By.xpath("//a[@href = '/shop/kraska-dorozhnaya/']//span[. = 'Краска дорожная']")).click();

        Thread.sleep(5000);
        driver.quit();

    }

}
