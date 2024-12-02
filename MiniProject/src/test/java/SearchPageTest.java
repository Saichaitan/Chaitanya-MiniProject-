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
import pages.SearchPage;


public class SearchPageTest {

    public WebDriver driver;
    pages.SearchPage searchPage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\SELENIUM JAVA\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech" );
        searchPage = new pages.SearchPage(driver);


        WebElement username = driver.findElement(By.id("usernameInput"));
        WebElement password = driver.findElement(By.id("passwordInput"));

        username.sendKeys("rahul");
        password.sendKeys("rahul@2021");
        WebElement login = driver.findElement(By.className("login-button"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        login.click();



    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

    @Test

    public void testSearchFunctionality(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-empty-button")));
        searchPage.presearchclick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        searchPage.entersearch("venom");
        searchPage.clickseaarch();
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.movie-image")));

        List<WebElement> movies = searchPage.findmovies();



        // Get and print the size of the movies list
        int movieCount = movies.size();
        System.out.println("Number of movies displayed: " + movieCount);

        // Optional: Assert on the expected number of movies
        int expectedCount = 2; // Set your expected count here
        Assert.assertEquals(movieCount, expectedCount, "The number of displayed movies does not match the expected count!");






    }


    @Test
    public void testSearchFailureFunctionality() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-empty-button")));
        searchPage.presearchclick();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        String msg = "Chay";
        searchPage.entersearch(msg);
        searchPage.clickseaarch();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("not-found-search-paragraph")));

        Assert.assertEquals(searchPage.getfailuremsg(), "Your search for "+ msg +" did not find any matches.", "The number of displayed movies does not match the expected count!");




    }

    }
