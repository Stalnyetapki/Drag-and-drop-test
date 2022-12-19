package com.herokuapp;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class DragAndDropTests {

    @Test
    @Owner("Aleksei Tupikov")
    @DisplayName("Move rectangle A to place B")
    void checkIssuesTabInRepoByLambdaTest() {

        Configuration.holdBrowserOpen = true;
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {
            open("https://the-internet.herokuapp.com/drag_and_drop");
        });
        step("Move rectangle A to place B", () -> {
            $("#column-a").dragAndDropTo("#column-b");
//            actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(275, 0).release().perform();
        });
        step("Check that rectangles swapped", () -> {
            $("#column-a").shouldHave(text("B"));
            $("#column-b").shouldHave(text("A"));
        });

    }
}
