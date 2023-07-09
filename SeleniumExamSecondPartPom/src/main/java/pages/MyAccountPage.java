package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {
    private By registerLink = By.xpath("//a[text()='Register']");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }
}