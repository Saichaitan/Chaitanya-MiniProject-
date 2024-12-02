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
import pages.PopularPage;

public class MovieDetailsPageTest {
    public WebDriver driver;
    pages.HomePage homePage;
    pages.PopularPage popularPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\SELENIUM JAVA\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        homePage = new pages.HomePage(driver);
        popularPage = new pages.PopularPage(driver);
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
    public void testMovieDetailsPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        WebElement shanchi = driver.findElement(By.cssSelector(".home-bottom-container > div:nth-of-type(1) .App .slick-slide:nth-of-type(2) img.poster"));
        shanchi.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-title")));
        WebElement head  = driver.findElement(By.className("movie-title"));
        Assert.assertEquals(head.getText(),"Shang-Chi and the Legend of the Ten Rings","Movie Title Mismatched");
        WebElement watchtime = driver.findElement(By.className("watch-time"));
        WebElement releaseyear = driver.findElement(By.className("release-year"));
        WebElement review = driver.findElement(By.className("movie-overview"));
        Assert.assertEquals(watchtime.getText(), "2h 12m", "Watch Time Mismatch");
        Assert.assertEquals(releaseyear.getText(),"2021","Release Year Mismatch");
        Assert.assertEquals(review.getText(), "Shang-Chi must confront the past he thought he left behind when he is drawn into the web of the mysterious Ten Rings","Mismatch In Overview");




        List<WebElement> genres = driver.findElements(By.cssSelector("div.genres-category * p"));


        // Create a list to hold the actual genres
        List<String> actualGenres = new ArrayList<>();
        for (WebElement genre : genres) {
            actualGenres.add(genre.getText().trim());
        }

        // Expected genres
        List<String> expectedGenres = List.of("Action", "Adventure", "Fantasy");

        // Assert that the actual genres match the expected genres
        Assert.assertTrue(actualGenres.containsAll(expectedGenres), "The genres do not match!");


        List<WebElement> audios = driver.findElements(By.cssSelector("div.audio-category * p"));

        List<String> actualaudio = new ArrayList<>();
        for (WebElement audio : audios) {
            actualaudio.add(audio.getText().trim());
        }

        // Expected genres
        List<String> expectedaudio = List.of("English" , "Mandarin");

        // Assert that the actual genres match the expected genres
        Assert.assertTrue(actualaudio.containsAll(expectedaudio), "The audio do not match!");


        WebElement heading = driver.findElement(By.className("similar-movies-heading"));
        Assert.assertEquals(heading.getText(), "More like this", "Mismatch In Similar Movies Heading");



        List<WebElement> Movieslist = driver.findElements(By.cssSelector("img.image-style"));
        int movieslist  = Movieslist.size();
        int expectedmovieslist = 33;
        Assert.assertEquals(movieslist, expectedmovieslist, "Count Mismatch" );


    }

    @Test
    public void popularpage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='popular']")));
        WebElement popular = driver.findElement(By.cssSelector("a[href*='popular']"));
        popular.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.movie-image[alt='The Amazing Spider-Man']")));
        WebElement spider = driver.findElement(By.cssSelector("img.movie-image[alt='The Amazing Spider-Man']"));
        spider.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-title")));
        WebElement head  = driver.findElement(By.className("movie-title"));
        Assert.assertEquals(head.getText(),"The Amazing Spider-Man","Movie Title Mismatched");
        WebElement watchtime = driver.findElement(By.className("watch-time"));
        WebElement releaseyear = driver.findElement(By.className("release-year"));
        WebElement review = driver.findElement(By.className("movie-overview"));
        Assert.assertEquals(watchtime.getText(), "2h 43m", "Watch Time Mismatch");
        Assert.assertEquals(releaseyear.getText(),"2021","Release Year Mismatch");
        Assert.assertEquals(review.getText(), "Peter Parker is an outcast high schooler abandoned by his parents as a boy, leaving him to be raised by his Uncle Ben and Aunt May.","Mismatch In Overview");



        List<WebElement> genres = driver.findElements(By.cssSelector("div.genres-category * p"));


        // Create a list to hold the actual genres
        List<String> actualGenres = new ArrayList<>();
        for (WebElement genre : genres) {
            actualGenres.add(genre.getText().trim());
        }

        // Expected genres
        List<String> expectedGenres = List.of("Adventure", "Action", "Thriller");

        // Assert that the actual genres match the expected genres
        Assert.assertTrue(actualGenres.containsAll(expectedGenres), "The genres do not match!");


        List<WebElement> audios = driver.findElements(By.cssSelector("div.audio-category * p"));

        List<String> actualaudio = new ArrayList<>();
        for (WebElement audio : audios) {
            actualaudio.add(audio.getText().trim());
        }

        // Expected genres
        List<String> expectedaudio = List.of("English" , "French","Italian", "Russian", "Spanish");

        // Assert that the actual genres match the expected genres
        Assert.assertTrue(actualaudio.containsAll(expectedaudio), "The audio do not match!");


        WebElement heading = driver.findElement(By.className("similar-movies-heading"));
        Assert.assertEquals(heading.getText(), "More like this", "Mismatch In Similar Movies Heading");



        List<WebElement> Movieslist = driver.findElements(By.cssSelector("img.image-style"));
        int movieslist  = Movieslist.size();
        int expectedmovieslist = 38;
        Assert.assertEquals(movieslist, expectedmovieslist, "Count Mismatch" );



    }
}
