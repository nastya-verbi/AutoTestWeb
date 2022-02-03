package lesson5.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

@DisplayName("Добавление Яндекс.станции в корзину")
public class AddYandexStationTest {
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
        driver.findElement(By.xpath("//a[@data-id='market']")).click();
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        driver.findElement(By.id("header-search")).sendKeys("яндекс станция");
        driver.findElement(By.xpath("//button[@data-r='search-button']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Цена до']")));
        driver.findElement(By.xpath("//input[@name='Цена до']")).sendKeys("6000");
        driver.findElement(By.xpath("//span[contains(text(), 'Цвет желтый')]/..")).click();

        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//div[@data-apiary-widget-id=\"/MarketNodeOutOfStockResults42/resultsPaged/searchPartition-0\"]/following-sibling::div"))));
        driver.findElement(By.xpath("//span[contains(text(), 'корзину')]/ancestor::button")).click();

        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-auto='modal']//a[@href='/my/cart']")));
        driver.findElement(By.xpath("//div[@data-auto='modal']//a[@href='/my/cart']")).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@data-zone-name='button']//button[@disabled]"))));

        Assertions.assertEquals(driver.findElement(By.xpath("//a[contains(text(), 'Станция лайт, лимон')]")).getText(), "Умная колонка Яндекс.Станция Лайт, лимон");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
