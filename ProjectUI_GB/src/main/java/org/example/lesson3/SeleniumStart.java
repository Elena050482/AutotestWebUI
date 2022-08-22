package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumStart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        WebDriver driver  = new ChromeDriver();
        driver.get("https://google.com");

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://ya.ru");

        WebDriverManager.safaridriver().setup();
        WebDriver safariDriver = new SafariDriver();
        safariDriver.get("https://yablyk.com");

        Thread.sleep(5000);
        driver.quit();
        firefoxDriver.quit();
        safariDriver.quit();

    }

}
