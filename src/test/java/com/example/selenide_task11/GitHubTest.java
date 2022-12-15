package com.example.selenide_task11;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class GitHubTest extends TestBase{
    @Test
    void gitHubTest(){

        step("Открывыаем страницу", () ->{
            open("https://github.com/");});
        step("Ищем репощиторий selenide", () ->{
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("selenide");
            $(".header-search-input").submit();});
        step("Нажать на ссылку репозитория", () ->{
            $(linkText("selenide/selenide")).click();});
        step("Открыть таб wiki", () ->{
            $("#wiki-tab").shouldBe(Condition.visible).click();});
        step("Ищем page и кликаем по нему", () ->{
            $(".wiki-more-pages-link").lastChild().click();
            $x("//div[@id='wiki-pages-box']//a[text()='SoftAssertions']").shouldBe(Condition.visible).click();});
        step("Проверяем что на странице есть текст", () ->{
            $("#user-content-3-using-junit5-extend-test-class").shouldBe(Condition.visible);
        });

    }
}
