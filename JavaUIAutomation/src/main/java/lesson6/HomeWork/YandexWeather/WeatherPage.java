package lesson6.HomeWork.YandexWeather;

import lesson6.HomeWork.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WeatherPage extends BasePage {
    public WeatherPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//input[@placeholder='Город или район']")
    private WebElement inputSearch;

    @FindBy (xpath = "//a[contains(@href, 'pogoda/213')]")
    private WebElement selectCity;

    @FindBy (xpath = "//a[contains(@href, 'moscow/month')]")
    private WebElement selectMonth;

    public WeatherPage searchByCity(String city) {
        inputSearch.sendKeys(city);
        selectCity.click();
        return this;
    }

    public WeatherMonth selectMonthWeather() {
        selectMonth.click();
        return new WeatherMonth(driver);
    }
}
