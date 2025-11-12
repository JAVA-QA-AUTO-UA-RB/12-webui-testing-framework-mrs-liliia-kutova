package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    @FindBy (linkText = "Form Authentication")
    private WebElement formAuthLink;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/");
    }
    public void clickFormAuthentication(){
        formAuthLink.click();
    }
}
