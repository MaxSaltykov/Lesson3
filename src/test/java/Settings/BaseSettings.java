package Settings;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseSettings {

    @BeforeAll
    public static void setupSettings() {
/*        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();*/
        Configuration.startMaximized = true;
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
    }

    @BeforeAll
    public static void allureSubSelenide() {
/*        String listenerName = "AllureSelenide";
        new AllureSelenide()
                .screenshots(true)
                .savePageSource(false);*/
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(false));
/*        String listenerName = "AllureSelenide";

        if(!(SelenideLogger.hasListener(listenerName)))
            SelenideLogger.addListener(listenerName,
                    new AllureSelenide().
                            screenshots(true).
                            savePageSource(false));*/
    }

    @AfterEach
    public void closeWebDriver() {
        WebDriverRunner.closeWebDriver();
    }

}
