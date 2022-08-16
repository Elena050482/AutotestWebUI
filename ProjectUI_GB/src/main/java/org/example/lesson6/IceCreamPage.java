package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IceCreamPage extends BasePage {
    public IceCreamPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[. = 'Йогуртница электрическая DELTA DL-8400, 20 Вт., объем контейнера 1л, белый с серо-зеленым']")
    private WebElement yogurtMaker;

    public ProductPage clickYogurtMaker() {
        yogurtMaker.click();
        return new ProductPage(driver);
    }

}
