package lesson6.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YandexMarketTest {
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
    @DisplayName("Добавление Яндекс.станции в корзину")
    void addYandexStation() {
        new MainYandexPage(driver)
                .switchToMarket()
                .searchGoods("яндекс станция")
                .searchNewGoods("6000")
                .clickButtonCart()
                .checkTitleName();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
