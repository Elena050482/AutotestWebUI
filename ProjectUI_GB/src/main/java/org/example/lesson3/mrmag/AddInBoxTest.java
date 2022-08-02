package org.example.lesson3.mrmag;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AddInBoxTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();


        WebDriver driver = new ChromeDriver();
        driver.get("https://mrmag.ru");


        driver.findElement(By.xpath("//a[@href ='/shop/tekhnika_dlya_kukhni']//img[@alt = 'Техника для кухни']")).click();
        driver.findElement(By.xpath("//div[@class = 'category-name']//a[text() = 'Йогуртницы, мороженицы']")).click();
        driver.findElement(By.id("carousel-product-1374136")).click();

        Thread.sleep (3000);
        driver.quit();
    }
}
