package com.tln.todoapptemplate;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.tln.todoapptemplate.pages.MainPage;
import com.tln.todoapptemplate.util.DataGenerator;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {

    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://todomvc.com/examples/react/dist/");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Create todo")
    public void createNewTodo() {
        // arrange and act
        mainPage.inputField.setValue(DataGenerator.generateTodoName());
        mainPage.inputField.pressEnter();
        // assert
        mainPage.itemLabel.get(0).shouldBe(visible);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Feature("Create todo")
    public void createFewTodoAndCheckNumberOfElements() {
        // arrange and act
        String todoNameFirst = DataGenerator.generateTodoName();
        mainPage.inputField.setValue(todoNameFirst);
        mainPage.inputField.pressEnter();
        String todoNameSecond = DataGenerator.generateTodoName();
        mainPage.inputField.setValue(todoNameSecond);
        mainPage.inputField.pressEnter();
        // assert
        mainPage.itemLabel.shouldHave(size(2));
        mainPage.itemLabel.get(0).shouldBe(visible).shouldHave(text(todoNameFirst));
        mainPage.itemLabel.get(1).shouldBe(visible).shouldHave(text(todoNameSecond));
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @Feature("Create and delete")
    public void createFewTodoAndDeleteIt() {
        // arrange
        mainPage.inputField.setValue(DataGenerator.generateTodoName());
        mainPage.inputField.pressEnter();
        mainPage.inputField.setValue(DataGenerator.generateTodoName());
        mainPage.inputField.pressEnter();
        // act
        mainPage.itemLabel.get(1).hover();
        mainPage.itemButton.get(1).click();
        mainPage.itemLabel.get(0).hover();
        mainPage.itemButton.get(0).click();
        // assert
        mainPage.itemLabel.shouldHave(size(0));
        mainPage.itemLabel.get(0).shouldNotBe(exist);
    }

}
