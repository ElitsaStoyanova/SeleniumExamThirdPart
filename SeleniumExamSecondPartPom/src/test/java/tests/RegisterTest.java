package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;
import pages.RegisterPage;

public class RegisterTest {
    private WebDriver driver;
    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private RegisterPage registerPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void testRegister() {
        homePage.goToHomePage();
        homePage.clickMyAccountLink();
        myAccountPage.clickRegisterLink();
        registerPage.fillInMandatoryFields("Maria", "Mechkarskaq", "mariamechkar@gmail.com", "096572960", "password123!");
        registerPage.selectMandatoryCheckboxes();
        registerPage.clickContinueButton();
        Assert.assertTrue(registerPage.getSuccessMessage().contains("Your Account Has Been Created!"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}