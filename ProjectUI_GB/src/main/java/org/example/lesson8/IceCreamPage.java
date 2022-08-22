package org.example.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class IceCreamPage {
    SelenideElement yogurtMaker = $(By.xpath("//a[. = 'Йогуртница электрическая DELTA DL-8400, 20 Вт., объем контейнера 1л, белый с серо-зеленым']"));

    @Step("Клик на ссылку с продуктом йогуртница Дельта")
    public ProductPage clickYogurtMaker() {
        yogurtMaker.click();
        return page(ProductPage.class);
    }
}
