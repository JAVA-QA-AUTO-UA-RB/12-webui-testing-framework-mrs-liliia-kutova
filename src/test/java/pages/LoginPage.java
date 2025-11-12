package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {
    @FindBy(id="username")
    private WebElement userInput;

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(css ="button[type='submit']")
    private WebElement loginButton;

    @FindBy(id = "flash")
    private WebElement flashMessage;

    public LoginPage(WebDriver driver){
        super(driver);
    }
    public void enterUsername(String username){
        wait.until(ExpectedConditions.visibilityOf(userInput));
        userInput.clear();
        userInput.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    public void clickLogin(){
        loginButton.click();
    }
    public String getFlashMessage(){
        wait.until(ExpectedConditions.visibilityOf(flashMessage));
        return flashMessage.getText();
    }
    public SecureAreaPage loginAs(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new SecureAreaPage(driver);
    }
}
