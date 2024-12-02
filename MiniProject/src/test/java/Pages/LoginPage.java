package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {


    By logoimage = By.className("login-website-logo");
    By logintext = By.className("sign-in-heading");
    By username = By.cssSelector(".input-container:first-of-type .input-label");
    By password = By.cssSelector(".input-container:last-of-type .input-label");
    By loginbutton = By.className("login-button");
    By enterusername = By.id("usernameInput");
    By enterpassword = By.id("passwordInput");
    By errormsg = By.className("error-message");
    WebDriver driver;
    public  LoginPage(WebDriver driver) {
        this.driver = driver; // Initialize the driver
    }



    public WebElement findlogoimage() {return driver.findElement(logoimage);}
    public WebElement findlogintext(){return driver.findElement(logintext);}
    public WebElement findusername(){return driver.findElement(username);}
    public WebElement findpassword(){return driver.findElement((password));}
    public WebElement findloginbutton(){return driver.findElement(loginbutton);}
    public void setEnterusername(String username){driver.findElement(enterusername).sendKeys(username);}
    public void setEnterpassword(String password){driver.findElement(enterpassword).sendKeys(password);}
    public void clickloginbutton(){driver.findElement(loginbutton).click();}
    public String  finderrormsg(){return driver.findElement(errormsg).getText();}

    public void loginwithvalid(String username, String password){
        driver.findElement(enterusername).sendKeys(username);
        driver.findElement(enterpassword).sendKeys(password);
        driver.findElement(loginbutton).click();
    }

}
