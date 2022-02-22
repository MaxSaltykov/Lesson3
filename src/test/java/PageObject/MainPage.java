package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    @FindBy(how = How.XPATH, using = "//h1[text()='System Dashboard']")
    private SelenideElement header;

    public AuthorisationPage isOpened() {
        header.exists();
        return page(AuthorisationPage.class);
    }

}
