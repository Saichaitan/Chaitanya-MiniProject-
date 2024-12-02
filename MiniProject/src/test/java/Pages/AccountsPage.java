package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage {



    By accountsimg = By.className("avatar-img");
    By heading = By.className("account-heading");
    By membershipheading = By.className("membership-heading");
    By membershipusername = By.className("membership-username");
    By membershippassword = By.className("membership-password");
    By membership2heading = By.xpath("/html/body/div/div/div[1]/div[2]/p");
    By planparagraph = By.className("plan-paragraph");
    By plandetails = By.className("plan-details");
    By logoutbutton = By.className("logout-button");



    WebDriver driver;


    public  AccountsPage(WebDriver driver) {
        this.driver = driver; // Initialize the driver
    }


    public void clickonaccounts(){driver.findElement(accountsimg).click();}

    public String getheading(){return driver.findElement(heading).getText();}


    public String getmemheading(){return driver.findElement(membershipheading).getText();}

    public String getmemusername(){return driver.findElement(membershipusername).getText();}

    public String getmempassword(){return driver.findElement(membershippassword).getText();}

    public String getmemheading2(){return driver.findElement(membership2heading).getText();}

    public String getplanparagraph(){ return driver.findElement(planparagraph).getText();}

    public String getplandetails() { return driver.findElement(plandetails).getText();}

    public void lougoutfunction(){driver.findElement(logoutbutton).click();}


}
