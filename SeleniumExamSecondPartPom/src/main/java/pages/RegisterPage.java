package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage extends BasePage {
    private By firstNameField = By.id("input-firstname");
    private By lastNameField = By.id("input-lastname");
    private By emailField = By.id("input-email");
    private By telephoneField = By.name("telephone");
    private By passwordField = By.id("input-password");
    private By confirmPasswordField = By.id("input-confirm");
    private By agreeCheckbox = By.name("agree");
    private By continueButton = By.xpath("//input[@value='Continue']");
    private By successMessage = By.xpath("//h1[text()='Your Account Has Been Created!']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void fillInMandatoryFields(String firstName, String lastName, String email, String telephone, String password) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(telephoneField).sendKeys(telephone);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    public void selectMandatoryCheckboxes() {
        WebElement agreeCheckboxElement = driver.findElement(agreeCheckbox);
        if (!agreeCheckboxElement.isSelected()) {
            agreeCheckboxElement.click();
        }
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }

}
