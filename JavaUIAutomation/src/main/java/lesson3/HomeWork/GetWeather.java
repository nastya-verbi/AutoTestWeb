package lesson3.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class GetWeather {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://yandex.ru");
        driver.findElement(By.xpath("//a[@data-statlog='weather.title']")).click();
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        driver.findElement(By.xpath("//input[@placeholder='Город или район']")).sendKeys("Москва");
        driver.findElement(By.xpath("//a[contains(@href, 'pogoda/213')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'moscow/month')]")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
