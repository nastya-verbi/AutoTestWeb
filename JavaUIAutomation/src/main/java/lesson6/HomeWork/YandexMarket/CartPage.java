package lesson6.HomeWork.YandexMarket;

import io.qameta.allure.Step;
import lesson6.HomeWork.BasePage;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(), 'Станция Лайт, мята')]")
    private WebElement cardGoods;

    @Step("Проверить, что товар в корзине")
    public CartPage checkTitleName() {
        Assertions.assertEquals(cardGoods.getText(), "Умная колонка Яндекс.Станция Лайт, мята");
        return this;
    }
}
