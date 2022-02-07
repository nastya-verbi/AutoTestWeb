package lesson6.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YandexWeatherTest {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://yandex.ru");
    }

    @Test
    @DisplayName("Получение прогноза погоды в Москве на месяц")
    void getWeatherMoscow30Days() {
        new MainYandexPage(driver)
                .switchToWeather()
                .searchByCity("Москва")
                .selectMonthWeather()
                .checkTitleWeather("Погода в Москве на месяц");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
