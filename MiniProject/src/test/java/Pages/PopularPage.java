package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class PopularPage {

    By movies  = By.cssSelector("img.movie-image");
    By populor = By.xpath("/html/body/div/div/div[1]/nav/div[1]/ul/li[2]/a");




    WebDriver driver;

    public  PopularPage(WebDriver driver) {
        this.driver = driver; // Initialize the driver
    }

    public WebElement findpopulor(){return driver.findElement(populor);}

    public List<WebElement> findMovies() {
        return driver.findElements(movies); // Return a list of movie elements
    }




}
