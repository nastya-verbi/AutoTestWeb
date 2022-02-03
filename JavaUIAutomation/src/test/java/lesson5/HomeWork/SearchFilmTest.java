package lesson5.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@DisplayName("Поиск фильма")
public class SearchFilmTest {
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
    @DisplayName("Поиск фильма 'Главный герой'")
    void searchFilm() {
        driver.findElement(By.xpath("//a[@data-id='video']")).click();
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        driver.findElement(By.xpath("//span[@class='input__clear input__clear_visibility_visible']")).click();
        driver.findElement(By.xpath("//input[@class='input__control']")).sendKeys("главный герой фильм 2021");
        driver.findElement(By.xpath("//div[@class='websearch-button__text']")).click();
        driver.switchTo().activeElement().click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div div.spin2_progress_yes")));
//        Thread.sleep(1000);
        List<WebElement> filmsList = driver.findElements(By.xpath("//a[contains(@href, 'video')]/ancestor::div[@class='serp-item__snippet']"));
        filmsList.stream().filter(f -> f.getText().contains("герой")).findFirst().get().click();

        Assertions.assertEquals(driver.findElement(By.cssSelector("div.VideoTitle")).getText(), "Главный герой");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
