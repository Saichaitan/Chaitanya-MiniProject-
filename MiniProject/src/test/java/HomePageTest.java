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


public class HomePageTest {
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
    public void testHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));

         Assert.assertTrue(homePage.findlogo().isDisplayed());
         Assert.assertTrue(homePage.findplaybutton().isDisplayed());
        List<WebElement> movieElements = homePage.findMovies();

        for (int i = 0; i < movieElements.size(); i++) { // Select up to 5 movies
            WebElement movie = movieElements.get(i);
            Assert.assertTrue(movie.isDisplayed()); // Assert each movie is displayed
            movie.click(); // Click on the movie
            // You might want to add logic to perform actions after clicking, such as checking details
            driver.navigate().back(); // Go back to the homepage after clicking
            movieElements = homePage.findMovies(); // Refresh the movie list after going back
        }

       Assert.assertTrue(homePage.findcontact().isDisplayed());

    }



}
