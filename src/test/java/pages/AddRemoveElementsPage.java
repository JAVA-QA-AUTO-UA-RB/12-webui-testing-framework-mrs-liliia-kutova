package pages;

import com.github.dockerjava.api.command.LoadImageAsyncCmd;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AddRemoveElementsPage extends BasePage {
    @FindBy(xpath = "//button[text()='Add Element']")
    private WebElement addElementButton;
    @FindBy (xpath = "//button[text()='Delete']")
    private List<WebElement> deleteButtons;

    public AddRemoveElementsPage(WebDriver driver){
        super(driver);
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }
    public void addElements(int count){
        for (int i =0; i < count; i++){
            wait.until(ExpectedConditions.elementToBeClickable(addElementButton)).click();
        }
    }
    public int getDeleteButtonsCount(){
        return deleteButtons.size();
    }
    public void removeAllElements(){
        while (!deleteButtons.isEmpty()){
            wait.until(ExpectedConditions.elementToBeClickable(deleteButtons.get(0))).click();
        }
    }
    public boolean isDeleteButtonsEmpty(){
        return deleteButtons.isEmpty();
    }
}
