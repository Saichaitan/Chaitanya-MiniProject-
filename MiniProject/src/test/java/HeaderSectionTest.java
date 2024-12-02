import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.Alert;

import java.nio.channels.WritableByteChannel;
import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;



public class HeaderSectionTest {
    public WebDriver driver;
    pages.HomePage homePage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\SELENIUM JAVA\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech" );
        homePage = new pages.HomePage(driver);

        WebElement username = driver.findElement(By.id("usernameInput"));
        WebElement password = driver.findElement(By.id("passwordInput"));

        username.sendKeys("rahul");
        password.sendKeys("rahul@2021");
        WebElement login = driver.findElement(By.className("login-button"));
        login.click();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void testHeaderSectionUI() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        Assert.assertTrue(homePage.findlogo().isDisplayed());
        Assert.assertTrue(homePage.findhome().isDisplayed());
        Assert.assertTrue(homePage.findpopulor().isDisplayed());
        Assert.assertTrue(homePage.findsearch().isDisplayed());
        Assert.assertTrue(homePage.findaccount().isDisplayed());







    }
    @Test
    public void testHeaderSectionFunctionalities(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));

        homePage.navigatepopulor();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/popular"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/popular", "Navigation to popular is failed");

        homePage.navigatehome();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/", "Navigation to home page is failed");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("avatar-img")));
        homePage.navigateaccount();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/account"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/account", "Navigation to Account page is failed");


    }





}
