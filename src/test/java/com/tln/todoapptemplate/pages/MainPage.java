package com.tln.todoapptemplate.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    public SelenideElement inputField = $("[data-testid='text-input']");
    public ElementsCollection itemButton = $$("[data-testid='todo-item-button']");
    public ElementsCollection itemLabel = $$("[data-testid='todo-item-label']");

    public SelenideElement clearButtonWithClassName = $(byClassName("clear-completed"));
    public SelenideElement clearButtonWithText = $(byText("Clear completed"));
}
