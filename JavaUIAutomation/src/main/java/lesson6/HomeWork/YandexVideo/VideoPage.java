package lesson6.HomeWork.YandexVideo;

import io.qameta.allure.Step;
import lesson6.HomeWork.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class VideoPage extends BasePage {
    public VideoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//span[@class='input__clear input__clear_visibility_visible']")
    private WebElement buttonRemove;

    @FindBy (xpath = "//input[@class='input__control']")
    private WebElement searchField;

    @FindBy (xpath = "//div[@class='websearch-button__text']")
    private WebElement searchButton;

    @FindBy (css = "div.VideoTitle")
    private WebElement textTitle;

    private static final String PROGRESS_BAR = "div div.spin2_progress_yes";
    private final String FILM_LIST = "//a[contains(@href, 'video')]/ancestor::div[@class='serp-item__snippet']";

    @Step("Очистить поле поиска")
    public void removeSearchText() {
        buttonRemove.click();
    }

    @Step("Нажать на кнопку поиска")
    public void clickButton() {
        searchButton.click();
    }

    @Step("Найти необходимый фильм в поле поиска")
    public VideoPage findFilm(String nameFilm) {
        removeSearchText();
        searchField.sendKeys(nameFilm);
        clickButton();
        driver.switchTo().activeElement();
        return this;
    }

    @Step("Выбрать фильм из списка")
    public VideoPage clickFirstFilm(String filmName) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(PROGRESS_BAR)));
        List<WebElement> filmsList = driver.findElements(By.xpath(FILM_LIST));
        filmsList.stream().filter(f -> f.getText().contains(filmName)).findFirst().get().click();
        return this;
    }

    @Step("Проверить название фильма")
    public VideoPage checkTitle(String filmName) {
        Assertions.assertEquals(textTitle.getText(), filmName);
        return this;
    }


}
