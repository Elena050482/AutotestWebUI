package org.example.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.example.lesson6.IceCreamPage;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


public class MainPage {

    SelenideElement kitchenAppliancesButton = $(By.xpath("//a[@href ='/shop/tekhnika_dlya_kukhni']//img[@alt = 'Техника для кухни']"));
    SelenideElement  iceLink = $(By.xpath("//div[@class = 'category-name']//a[text() = 'Йогуртницы, мороженицы']"));

    @Step ("Клик на кнопку Техника для кухни")
    public MainPage clickKitchenAppliancesButton() {
        kitchenAppliancesButton.click();
        return this;
    }

    @Step("Клик на ссылку Йогуртницы, мороженницы")
    public IceCreamPage clickIceLink() {
        iceLink.click();
        return page(IceCreamPage.class);
    }

}
