package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.Random;

import static PageObject.TaskPage.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class TaskSteps {

    @Step("Проверяем количество задач в системе")
    public static void checkTaskNumber(){
        $x(find_link).shouldBe(Condition.visible).click();
        $x(navigation_bar).shouldBe(Condition.visible).click();
        $x(showing_bar).shouldBe(Condition.visible);
        String number = ($x(showing_bar).text());
        number = number.substring(number.lastIndexOf(" ")).trim();
        String count = ($x(pagination).getAttribute("data-displayable-total"));
        Assertions.assertEquals(number, count);
    }

    @Step("Создаём задачу с последующим прохождением её ЖЦ")
    public static void createTask() throws InterruptedException {

        Random rand = new Random();
        int int_random = rand.nextInt();
        String taskName = "NightTask " + int_random;

        $x(createLink).click();
        $x(summary).sendKeys(taskName);
        $x(createIssueSubmit).click();
        $x(findLink).click();
        $x(topNavigationBar).click();

        /**
         * Перехожу на страницу свежесозданной задачи
         */
        $x(searcherQuery).shouldBe(Condition.visible).setValue(taskName);
        $x(searchTasks).click();

        /**
         * Назначил себя на эту задачу
         */
        $x(assignToMeLink).shouldBe(Condition.visible).click();

        /**
         * Перевожу задачу в статус "выполнено"
         */
        $x(businessProsess).shouldBe(Condition.exist).click();
        $x(done).click();

        /**
         * Проверка смены статуса задания на "готово"
         * проверим цвет плашки "готово"
         * там в CSS прописана трансформация цвета, она занимает время, поэтому надо подождать
         */
        sleep(1000);

        /**
         * Если вместо sleep использовать .shouldBe(Condition.exist,Duration.ofSeconds(1)), проверка не пройдет, так как элемент уже существует,
         * у него просто меняется цвет. А от проверки цвета я отказываться не хочу, иначе мне негде применить .getCssValue("background-color")
         */
        Assertions.assertEquals("rgba(20, 137, 44, 1)", $x(statusVal).getCssValue("background-color"));
    }
}
