package lesson3.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchFilm {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://yandex.ru");
        driver.findElement(By.xpath("//a[@data-id='video']")).click();
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        driver.findElement(By.xpath("//span[@class='input__clear input__clear_visibility_visible']")).click();
        driver.findElement(By.xpath("//input[@class='input__control']")).sendKeys("главный герой фильм 2021");
        driver.findElement(By.xpath("//div[@class='websearch-button__text']")).click();
        Thread.sleep(1000); //иногда падает на этом месте, не могу сообразить насчет ожидания...
        List<WebElement> filmsList = driver.findElements(By.xpath("//a[contains(@href, 'video')]/ancestor::div[@class='serp-item__snippet']"));
        filmsList.stream().filter(f -> f.getText().contains("герой")).findFirst().get().click();

        Thread.sleep(2000);
        driver.quit();

    }
}
