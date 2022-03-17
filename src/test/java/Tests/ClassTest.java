package Tests;

import Settings.BaseSettings;
import org.junit.jupiter.api.Test;

import static steps.AutorizationSteps.*;
import static steps.TaskSteps.checkTaskNumber;
import static steps.TaskSteps.createTask;

public class ClassTest extends BaseSettings {

    @Test
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
