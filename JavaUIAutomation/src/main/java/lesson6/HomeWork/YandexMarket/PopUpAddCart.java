package lesson6.HomeWork.YandexMarket;

import io.qameta.allure.Step;
import lesson6.HomeWork.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopUpAddCart extends BasePage {
    public PopUpAddCart(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//div[@data-auto='modal']//a[@href='/my/cart']")
    private WebElement buttonCart;

    @Step("Добавить товар в корзину")
    public CartPage clickButtonCart() {
        driver.switchTo().activeElement();
        buttonCart.click();
        return new CartPage(driver);
    }
}
