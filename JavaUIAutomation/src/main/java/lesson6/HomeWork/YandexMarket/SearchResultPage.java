package lesson6.HomeWork.YandexMarket;

import lesson6.HomeWork.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static lesson6.HomeWork.YandexMarket.MarketPage.INPUT_PRICE_LOCATOR;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = INPUT_PRICE_LOCATOR)
    private WebElement inputPriceLocator;

    @FindBy (xpath = "//span[contains(text(), 'Цвет зеленый')]/..")
    private WebElement colorCheckbox;

    @FindBy(xpath = "//div[@data-apiary-widget-id='/MarketNodeOutOfStockResults42/resultsPaged/searchPartition-0']" +
            "/following-sibling::div")
    private WebElement waitGoods;

    @FindBy (xpath = "//span[contains(text(), 'корзину')]/ancestor::button")
    private WebElement addCart;

    public void inputPrice(String price) {
        inputPriceLocator.sendKeys(price);
    }

    public void selectColorCheckbox() {
        colorCheckbox.click();
    }

    public PopUpAddCart searchNewGoods(String price) {
        inputPrice(price);
        selectColorCheckbox();
        wait.until(ExpectedConditions.invisibilityOf(waitGoods));
        addCart.click();
        return new PopUpAddCart(driver);
    }
}
