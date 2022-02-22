package Tests;

import PageObject.AuthorisationPage;
import PageObject.MainPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class TestClass1 {

    @Test
    public void Test1() {

        Selenide.open("https://edujira.ifellow.ru/login.jsp", AuthorisationPage.class)
                .isOpened()
                .clickBtnLogin()
                .clickBtnPassword()
                .clickIn();

        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa", MainPage.class)
                .isOpened();

        $x("//a[@id='find_link']").shouldBe().click();
        $x("//a[@id='jira.top.navigation.bar:issues_drop_current_lnk']").shouldBe().click();
        $x("//div[@class='showing']").shouldBe();
        String number = ($x("//div[@class='showing']").text());
        number = number.substring(number.lastIndexOf(" ")).trim();
        String count = ($x("//div[@class='pagination']").getAttribute("data-displayable-total"));
        Assertions.assertEquals(number, count);
    }
}
