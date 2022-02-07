package lesson6.HomeWork.YandexMarket;

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

    public CartPage checkTitleName() {
        Assertions.assertEquals(cardGoods.getText(), "Умная колонка Яндекс.Станция Лайт, мята");
        return this;
    }
}
