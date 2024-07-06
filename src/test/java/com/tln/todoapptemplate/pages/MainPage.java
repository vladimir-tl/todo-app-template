package com.tln.todoapptemplate;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://www.jetbrains.com/
public class MainPage {

    public SelenideElement inputField = $("[data-testid='text-input']");
    public SelenideElement itemLabel = $("[data-testid='todo-item-label']");
}
