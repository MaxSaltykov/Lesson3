package Tests;

import Settings.BaseSettings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static steps.AutorizationSteps.*;
import static steps.TaskSteps.checkTaskNumber;
import static steps.TaskSteps.createTask;

public class ClassTest extends BaseSettings {

    @Test
    @DisplayName("Проверяем количество задач в системе")
    public void Test1() {

        openUrl("https://edujira.ifellow.ru/login.jsp");
        checkIsOpened();
        clickBtnLogin();
        clickBtnPassword();
        clickIn();

        openUrl("https://edujira.ifellow.ru/secure/Dashboard.jspa");
        checkIsOpened();
        checkTaskNumber();
    }
    @Test
    @DisplayName("Создаём задачу с последующим прохождением её ЖЦ")
    public void Test2()  throws InterruptedException {

        openUrl("https://edujira.ifellow.ru/login.jsp");
        checkIsOpened();
        clickBtnLogin();
        clickBtnPassword();
        clickIn();

        openUrl("https://edujira.ifellow.ru/secure/Dashboard.jspa");
        checkIsOpened();

        createTask();
    }
}
