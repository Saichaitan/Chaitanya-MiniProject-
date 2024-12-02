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
import pages.LoginPage;





public class LoginPageTest {

    public WebDriver driver;
    LoginPage loginPage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\SELENIUM JAVA\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech" );
        loginPage = new LoginPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



    @Test (priority = 1)
    public void testLoginPageUI() {
        Assert.assertTrue(loginPage.findlogoimage().isDisplayed() , "Logo Not Displayed");
        Assert.assertTrue(loginPage.findlogintext().isDisplayed());
        Assert.assertTrue(loginPage.findusername().isDisplayed());
        Assert.assertTrue(loginPage.findpassword().isDisplayed());
        Assert.assertTrue(loginPage.findloginbutton().isDisplayed());
        driver.close();

    }

    @Test(priority = 2)
    public void testLoginPageFunctionalities() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        loginPage.clickloginbutton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        Assert.assertEquals(loginPage.finderrormsg(), "*Username or password is invalid", "Error MSG Not Displayed");

        loginPage.setEnterpassword("rahul@2021");
        loginPage.clickloginbutton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        Assert.assertEquals(loginPage.finderrormsg(), "*Username or password is invalid", "Error MSG Not Displayed");

        driver.navigate().refresh();
        driver.findElement(By.id("passwordInput")).clear(); // Clear password field
        loginPage.setEnterusername("rahul");
        loginPage.clickloginbutton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        Assert.assertEquals(loginPage.finderrormsg(), "*Username or password is invalid", "Error MSG Not Displayed");


        driver.navigate().refresh();
        loginPage.setEnterpassword("rahul2021");
        loginPage.setEnterusername("rahul");
        loginPage.clickloginbutton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        Assert.assertEquals(loginPage.finderrormsg(), "*username and password didn't match", "Error MSG Not Displayed");




        driver.navigate().refresh();
        loginPage.setEnterpassword("rahul@2021");
        loginPage.setEnterusername("rahul");
        loginPage.clickloginbutton();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/", "Navigation Failed To The Home Page");




    }





}
