package org.example.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    SelenideElement addToBoxButton = $(By.xpath("//div[@class = 'product-buy']//a[1]"));

    @Step("Клик на кнопку Добавить в корзину")
    public ProductPage addToBox() {
        addToBoxButton.click();
        return this;
    }

    SelenideElement totalSumma = $(By.xpath("//div[1]//b[@data-calc = 'result']"));


    @Step("проверяем итоговую сумму")
    public ProductPage checkTotalSumma(String expectedSumma) {
        totalSumma.shouldHave(Condition.text(expectedSumma));
        return this;
    }
}

