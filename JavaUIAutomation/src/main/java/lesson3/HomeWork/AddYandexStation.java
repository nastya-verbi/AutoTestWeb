package lesson3.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class AddYandexStation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        driver.get("https://yandex.ru");
        driver.findElement(By.xpath("//a[@data-id='market']")).click();
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        driver.findElement(By.id("header-search")).sendKeys("яндекс станция");
        driver.findElement(By.xpath("//button[@data-r='search-button']")).click();
//        Thread.sleep(1000); //не смогла определиться, к чему можно привязаться по ожиданию
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Цена до']")));
        driver.findElement(By.xpath("//input[@name='Цена до']")).sendKeys("6000");
        driver.findElement(By.xpath("//span[contains(text(), 'Цвет желтый')]/..")).click();
//        Thread.sleep(1000); //аналогично про ожидания, много элементов
        wait.until(ExpectedConditions.stalenessOf(driver.findElement
                (By.xpath("//div[@data-apiary-widget-id=\"/MarketNodeOutOfStockResults42/resultsPaged/searchPartition-0\"]/following-sibling::div"))));
        driver.findElement(By.xpath("//span[contains(text(), 'корзину')]/ancestor::button")).click();
//        Thread.sleep(1000);
        driver.switchTo().activeElement();
        driver.findElement(By.xpath("//div[@data-auto='modal']//a[@href='/my/cart']")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
