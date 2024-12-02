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
import pages.AccountsPage;


public class AccountPageTest {

    public WebDriver driver;
    pages.AccountsPage accountsPage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\SELENIUM JAVA\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        accountsPage = new pages.AccountsPage(driver);

        WebElement username = driver.findElement(By.id("usernameInput"));
        WebElement password = driver.findElement(By.id("passwordInput"));

        username.sendKeys("rahul");
        password.sendKeys("rahul@2021");
        WebElement login = driver.findElement(By.className("login-button"));
        login.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("avatar-img")));
        accountsPage.clickonaccounts();


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



    @Test
    public void testAccountPage(){

        Assert.assertEquals(accountsPage.getheading(),"Account", "Mismatch in Accounts heading");


        Assert.assertEquals(accountsPage.getmemheading(),"Member ship", "Mismatch in Membership Heading");

        Assert.assertEquals(accountsPage.getmemusername(),"User name : rahul","Missmatch in Membership Username");

        Assert.assertEquals(accountsPage.getmempassword(),"Password : **********", "Mismatch");

        Assert.assertEquals(accountsPage.getmemheading2(),"Plan details","Mismatch Found");

        Assert.assertEquals(accountsPage.getplanparagraph(), "Premium", "Missmatch Found");

        Assert.assertEquals(accountsPage.getplandetails(),"Ultra HD", "Missmatch Found");

    }


    @Test
    public void testAccountPageLogoutFun()
    {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        accountsPage.lougoutfunction();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/login"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/login", "Logout Failed");


    }
}
