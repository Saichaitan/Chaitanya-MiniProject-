package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;



public class HomePage {

    By logo = By.className("website-logo");
    By playbutton = By.className("home-movie-play-button");
    By movies = By.cssSelector("img.poster");
    By contact = By.className("contact-us-paragraph");
    By home = By.xpath("/html/body/div/div/div[1]/nav/div[1]/ul/li[1]/a");
    By populor = By.xpath("/html/body/div/div/div[1]/nav/div[1]/ul/li[2]/a");
    By searchbutton = By.className("search-empty-button");
    By account = By.className("avatar-button");
    By homebutton = By.className("nav-link");
    By accountbutton = By.className("avatar-img");





    WebDriver driver;

    public  HomePage(WebDriver driver) {
        this.driver = driver; // Initialize the driver
    }



    public WebElement findlogo(){ return driver.findElement(logo);}
    public WebElement findplaybutton() {return driver.findElement(playbutton);}
       public List<WebElement> findMovies() {
        return driver.findElements(movies); // Return a list of movie elements
    }
    public WebElement findcontact(){ return driver.findElement(contact);}

    public WebElement findhome(){ return driver.findElement(home);}
    public WebElement findpopulor(){return driver.findElement(populor);}
    public WebElement findsearch(){return driver.findElement(searchbutton);}
    public WebElement findaccount(){return driver.findElement(account);}

    public void navigatehome(){driver.findElement(homebutton).click();}
    public void navigatepopulor(){driver.findElement(populor).click();}
    public void navigateaccount(){driver.findElement(accountbutton).click();}

}
