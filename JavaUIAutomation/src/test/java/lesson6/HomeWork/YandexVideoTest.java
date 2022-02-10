package lesson6.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import lesson4.HomeWork.HomeWork.HomeWork.CustomLoggerNew;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;

public class YandexVideoTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
//        driver = new ChromeDriver();
        driver = new EventFiringDecorator(new CustomLoggerNew()).decorate(new ChromeDriver());
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://yandex.ru");
    }

    @Test
    @DisplayName("Проверка поиска фильма 'Главный герой'")
    @Description("Проверка поиска фильма 'Главный герой'")
    void searchFilm() {
        new MainYandexPage(driver)
                .switchToVideo()
                .findFilm("главный герой 2021")
                .clickFirstFilm("герой")
                .checkTitle("Главный герой");
    }

    @AfterEach
    void tearDown() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        Iterator<LogEntry> iterator = logEntries.iterator();

        while (iterator.hasNext()) {
            Allure.addAttachment("Лог браузера:", iterator.next().getMessage());
        }

        for (LogEntry log: logEntries) {
            Allure.addAttachment("Лог браузера:", log.getMessage());
        }
        driver.quit();
    }

}
