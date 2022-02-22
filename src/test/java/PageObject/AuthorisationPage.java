package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class AuthorisationPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@class='aui-page-header-main']//h1[text()='Добро пожаловать в Jira']")
    private SelenideElement header;

    @FindBy(how = How.XPATH, using = "//input[@id='login-form-username']")
    private SelenideElement loginLane;

    @FindBy(how = How.XPATH, using = "//input[@id='login-form-password']")
    private SelenideElement passworLane;

    @FindBy(how = How.XPATH, using = "//input[@value='Вход']")
    private SelenideElement logInBtn;

    public AuthorisationPage isOpened() {
        header.exists();
        return page(AuthorisationPage.class);
    }

    public AuthorisationPage clickBtnLogin() {
        loginLane.click();
        loginLane.sendKeys(login);
        return page(AuthorisationPage.class);
    }

    public AuthorisationPage clickBtnPassword() {
        passworLane.click();
        passworLane.sendKeys(password);
        return page(AuthorisationPage.class);
    }

    public AuthorisationPage clickIn() {
        logInBtn.click();
        return page(AuthorisationPage.class);
    }
}
