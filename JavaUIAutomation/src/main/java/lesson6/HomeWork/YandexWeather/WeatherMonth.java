package lesson6.HomeWork.YandexWeather;

import lesson6.HomeWork.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WeatherMonth extends BasePage {
    public WeatherMonth(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "main_title")
    private WebElement titleText;

    public WeatherMonth checkTitleWeather(String actualTitleText) {
        Assertions.assertEquals(titleText.getText(), actualTitleText);
        return this;
    }
}
