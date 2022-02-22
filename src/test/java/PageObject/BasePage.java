package PageObject;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    String login = "grushil";
    String password = "123qaz!@#QAZ";

    @BeforeAll
    public static void setupSettings() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterEach
    public void closeWebDriver() {
        WebDriverRunner.closeWebDriver();
    }

}
