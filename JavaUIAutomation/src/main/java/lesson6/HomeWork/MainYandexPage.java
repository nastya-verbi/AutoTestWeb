package lesson6.HomeWork;

import io.qameta.allure.Step;
import lesson6.HomeWork.YandexMarket.MarketPage;
import lesson6.HomeWork.YandexVideo.VideoPage;
import lesson6.HomeWork.YandexWeather.WeatherPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainYandexPage extends BasePage {

    public MainYandexPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//a[@data-id='market']")
    private WebElement linkMarket;

    @FindBy (xpath = "//a[@data-statlog='weather.title']")
    private WebElement linkWeather;

    @FindBy (xpath = "//a[@data-id='video']")
    private WebElement linkVideo;

    @Step("Перейти на страницу Маркет")
    public MarketPage switchToMarket() {
        linkMarket.click();
        switchToPage(1);
        return new MarketPage(driver);
    }

    @Step("Перейти на страницу Погода")
    public WeatherPage switchToWeather() {
        linkWeather.click();
        switchToPage(1);
        return new WeatherPage(driver);
    }

    @Step("Перейти на страницу Видео")
    public VideoPage switchToVideo() {
        linkVideo.click();
        switchToPage(1);
        return new VideoPage(driver);
    }
}
