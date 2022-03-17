package steps;

import io.qameta.allure.Step;

import static PageObject.AuthorisationPage.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class AutorizationSteps {

    public static String login = "maxSaltykov";
    public static String password = "123qaz!@#QAZ";

    @Step ("Открываем страницу авторизации")
    public static void openUrl(String url){
        open(url);
    }

    @Step ("Проверяем переход на страницу авторизации")
    public static void checkIsOpened() {
        $x(header).exists();
    }

    @Step ("Вводим логин")
    public static void clickBtnLogin() {
        $x(loginLane).click();
        $x(loginLane).sendKeys(login);
    }

    @Step ("Вводим пароль")
    public static void clickBtnPassword() {
        $x(passworLane).click();
        $x(passworLane).sendKeys(password);
    }

    @Step ("Кликаем кнопку войти")
    public static void clickIn() {
        $x(logInBtn).click();
    }
}
