package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class SearchPage {


    By presearch = By.className("search-empty-button");
    By search = By.id("search");
    By failuremsg = By.className("not-found-search-paragraph");
    By searchbutton = By.className("search-button");
    By movies = By.cssSelector("img.movie-image");

    WebDriver driver;

    public  SearchPage(WebDriver driver) {
        this.driver = driver; // Initialize the driver
    }

    public void presearchclick() {
        driver.findElement(presearch).click();
    }
    public WebElement findsearch(){return driver.findElement(search);}

    public void entersearch(String text){
        driver.findElement(search).sendKeys(text);
    }
    public void clickseaarch(){driver.findElement(searchbutton).click();}

    public List<WebElement> findmovies() {
        return driver.findElements(movies);
    }
    public String getfailuremsg(){
        return  driver.findElement(failuremsg).getText();
    }



}
