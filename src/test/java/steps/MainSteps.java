package steps;

import io.qameta.allure.Step;

import static PageObject.MainPage.headerMain;
import static com.codeborne.selenide.Selenide.$x;

public class MainSteps {

    @Step("Проверяем открытие главной страницы")
    public static void isOpened() {
        $x(headerMain).exists();
    }

}
