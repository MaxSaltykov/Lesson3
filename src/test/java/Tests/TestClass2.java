package Tests;

import PageObject.AuthorisationPage;
import PageObject.BasePage;
import PageObject.MainPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class TestClass2 extends BasePage {

    @Test
    public void newTask() {

        Selenide.open("https://edujira.ifellow.ru/login.jsp", AuthorisationPage.class)
                .isOpened()
                .clickBtnLogin()
                .clickBtnPassword()
                .clickIn();

        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa", MainPage.class)
                .isOpened();

        String taskName = "NightTask";
        //Random rand = new Random();
        //int randomNumber = rand.nextInt();
        // + " " + randomNumber
        /**
         * Создаю задачу
         */
        $x("//a[@id='create_link']").click();
        $x("//input[@id='summary']").sendKeys("NightTask");
        $x("//input[@id='create-issue-submit']").click();
        $x("//a[@id='find_link']").click();
        $x("//a[@id='jira.top.navigation.bar:issues_drop_current_lnk']").click();

        /**
         * Выцепляю номер, который был присвоен моей задаче для последующей проверки
         */
        String taskNumber = $x("//li[@title='NightTask']").text();
        taskNumber = taskNumber.substring(0, taskNumber.indexOf(taskName)).trim();

        /**
         * Перехожу на страницу свежесозданной задачи
         */
        open($x("//li[@title='NightTask']/a[1]").getAttribute("href"));

        /**
         * Проверяю что перешёл на страницу той задачи, что нужно
         */
        Assertions.assertEquals(taskNumber, $x("//a[@class='issue-link']").getText());

        /**
         * Назначил себя на эту задачу
         */
        $x("//span[@class='assign-to-me-link']").click();

        /**
         * Перевожу задачу в статус "выполнено"
         */
        $x("//span[contains(text(),'Бизнес-процесс')]").shouldBe(Condition.visible).click();
        $x("//span[contains(text(),'Выполнено')]").click();

        /**
         * Проверка смены статуса задания на "готово"
         * проверим цвет плашки "готово"
         */
        sleep(1000); //там в CSS прописана трансформация цвета, она занимает время, поэтому надо подождать
        Assertions.assertEquals("rgba(20, 137, 44, 1)", $x("//span[@id='status-val']/span").shouldBe().getCssValue("background-color"));
    }

}
