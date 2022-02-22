package Tests;

import PageObject.AuthorisationPage;
import PageObject.BasePage;
import PageObject.MainPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
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

        Random rand = new Random();
        int int_random = rand.nextInt();
        String taskName = "NightTask"+ " " + int_random;


        /**
         * Создаю задачу
         */
        $x("//a[@id='create_link']").click();
        $x("//input[@id='summary']").sendKeys(taskName);
        $x("//input[@id='create-issue-submit']").click();
        $x("//a[@id='find_link']").click();
        $x("//a[@id='jira.top.navigation.bar:issues_drop_current_lnk']").click();

        /**
         * Перехожу на страницу свежесозданной задачи
         */
        $x("//input[@id='searcher-query']").shouldBe(Condition.visible).setValue(taskName);
        $x("//button[@original-title='Поиск задач']").click();


        /**
         * Проверяю что перешёл на страницу той задачи, что нужно
         */
        //Assertions.assertEquals(taskNumber, $x("//a[@class='issue-link']").getText());

        /**
         * Назначил себя на эту задачу
         */
        $x("//span[@class='assign-to-me-link']").shouldBe(Condition.visible).click();

        /**
         * Перевожу задачу в статус "выполнено"
         */
        $x("//span[contains(text(),'Бизнес-процесс')]").shouldBe(Condition.exist).click();
        $x("//span[contains(text(),'Выполнено')]").click();

        /**
         * Проверка смены статуса задания на "готово"
         * проверим цвет плашки "готово"
         */
        sleep(1000); //там в CSS прописана трансформация цвета, она занимает время, поэтому надо подождать
        Assertions.assertEquals("rgba(20, 137, 44, 1)", $x("//span[@id='status-val']/span").getCssValue("background-color"));
    }

}
