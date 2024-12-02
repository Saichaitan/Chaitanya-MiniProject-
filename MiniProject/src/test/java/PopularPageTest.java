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
import pages.PopularPage;



public class PopularPageTest {
    public WebDriver driver;
    pages.PopularPage popularPage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\SELENIUM JAVA\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech" );
        popularPage = new pages.PopularPage(driver);

        WebElement username = driver.findElement(By.id("usernameInput"));
        WebElement password = driver.findElement(By.id("passwordInput"));

        username.sendKeys("rahul");
        password.sendKeys("rahul@2021");
        WebElement login = driver.findElement(By.className("login-button"));
        login.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='popular']")));
        WebElement popular = driver.findElement(By.cssSelector("a[href*='popular']"));
        popular.click();


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



    @Test
    public void  testPopularPgeUI() {




        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/popular"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("img.movie-image"))); // Ensure movies are visible

        // Get the list of movies
        List<WebElement> movies = popularPage.findMovies();

        // Assert that movies are displayed
        Assert.assertFalse(movies.isEmpty(), "No movies are displayed!");

        // Get and print the size of the movies list
        int movieCount = movies.size();
        System.out.println("Number of movies displayed: " + movieCount);

        // Optional: Assert on the expected number of movies
        int expectedCount = 30; // Set your expected count here
        Assert.assertEquals(movieCount, expectedCount, "The number of displayed movies does not match the expected count!");


    }













}
