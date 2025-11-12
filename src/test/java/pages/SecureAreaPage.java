package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SecureAreaPage extends BasePage {
    @FindBy(id="flash")
    private WebElement successMessage;

    @FindBy(css= "a.button.secondary.radius")
    private WebElement logoutButton;

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }
    public String getSuccessMessage(){
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText();
    }
    public void logout(){
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }
}
