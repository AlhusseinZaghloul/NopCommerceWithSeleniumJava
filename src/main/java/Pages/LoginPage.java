package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private By emailField =By.id("Email");
    private By passwordField =By.id("Password");
    private By loginButton =
            By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button");
    private By myAccountLink =By.xpath( "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
    public void EnterEmail(String email){
        sendText(driver.findElement(emailField),email);
    }
    public void EnterPassWord(String password){
        sendText(driver.findElement(passwordField),password);
    }
    public void loginButtonClick(){
        clicking(driver.findElement(loginButton));
    }
    public MyAccountPage openMyAccountPage(){
        clicking(driver.findElement(myAccountLink));
        return new MyAccountPage(driver);
    }
    public void userLogin(String email,String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(emailField));
        sendText(driver.findElement(emailField),email);
        sendText(driver.findElement(passwordField),password);
        clicking(driver.findElement(loginButton));
    }
}

