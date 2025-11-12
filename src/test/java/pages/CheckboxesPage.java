package pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckboxesPage extends BasePage {
    @FindBy (css = "input[type='checkbox']")
    private List<WebElement> checkboxes;

    public CheckboxesPage(WebDriver driver){
        super(driver);
    }
    public void open() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }
    public int getCheckboxCount(){
        return checkboxes.size();
    }
    public void selectAllCheckboxes(){
        for (WebElement checkbox : checkboxes){
            if (!checkbox.isSelected()){
                checkbox.click();
            }
        }
    }
    public void deselectAllCheckboxes(){
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }
    public boolean areAllcheckboxesSelected(){
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                return false;
            }
        }
        return true;
    }
    public boolean areAllCheckboxesUnselected() {
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                return false;
            }
        }
        return true;
    }
}
