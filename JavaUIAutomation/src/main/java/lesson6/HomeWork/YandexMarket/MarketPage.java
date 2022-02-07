package lesson6.HomeWork.YandexMarket;

import lesson6.HomeWork.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MarketPage extends BasePage {

    public MarketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "header-search")
    private WebElement inputSearch;

    @FindBy (xpath = "//button[@data-r='search-button']")
    private WebElement buttonSearch;

    protected static final String INPUT_PRICE_LOCATOR = "//input[@name='Цена до']";


    public SearchResultPage searchGoods(String nameGoods) {
        inputSearch.sendKeys(nameGoods);
        buttonSearch.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(INPUT_PRICE_LOCATOR)));
        return new SearchResultPage(driver);
    }

}
