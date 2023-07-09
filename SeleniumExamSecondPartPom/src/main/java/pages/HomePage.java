package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private static final String HOME_PAGE_URL = "http://shop.pragmatic.bg/";

    private By myAccountLink = By.xpath("//span[text()='My Account']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage() {
        driver.get(HOME_PAGE_URL);
    }

    public void clickMyAccountLink() {
        driver.findElement(myAccountLink).click();
    }
}
