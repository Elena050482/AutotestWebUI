package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.lesson8.IceCreamPage;
import org.example.lesson8.MainPage;
import org.example.lesson8.ProductPage;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @Given("пользователь зашел на сайт")
    public void пользователь_зашел_на_сайт() {
        open("https://mrmag.ru/");
    }

    @When("пользователь кликает на кнопку Техника для кухни")
    public void пользователь_кликает_на_кнопку_техника_для_кухни() {
        new MainPage().clickKitchenAppliancesButton();
    }

    @And("кликает на ссылку йогуртницы, мороженницы")
    public void кликает_на_ссылку_йогуртницы_мороженницы() {
        new MainPage().clickIceLink();
    }

    @And("кликает на ссылку с продуктом йогуртница Дельта")
    public void кликает_на_ссылку_с_продуктом_йогуртница_дельта() {
        new IceCreamPage().clickYogurtMaker();
    }

    @And("кликает на кнопку Добавить в корзину")
    public void кликает_на_кнопку_добавить_в_корзину() {
        new ProductPage().addToBox();
    }

    @Then("проверяем итоговую сумму")
    public void проверяем_итоговую_сумму() {
        new ProductPage().checkTotalSumma("1 047");
    }
}
