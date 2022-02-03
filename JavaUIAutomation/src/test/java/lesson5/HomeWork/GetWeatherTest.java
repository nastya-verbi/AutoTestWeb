package lesson5.HomeWork;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

@DisplayName("Получение прогноза погоды")
public class GetWeatherTest {
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
        driver.findElement(By.xpath("//a[@data-statlog='weather.title']")).click();
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        driver.findElement(By.xpath("//input[@placeholder='Город или район']")).sendKeys("Москва");
        driver.findElement(By.xpath("//a[contains(@href, 'pogoda/213')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'moscow/month')]")).click();

        Assertions.assertEquals(driver.findElement(By.id("main_title")).getText(), "Погода в Москве на месяц");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
