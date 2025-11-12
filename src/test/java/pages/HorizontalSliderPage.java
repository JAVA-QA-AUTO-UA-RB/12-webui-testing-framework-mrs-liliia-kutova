package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HorizontalSliderPage extends BasePage {
    @FindBy(css = "input[type='range']")
    private WebElement slider;

    @FindBy(id = "range")
    private WebElement valueDisplay;

    public HorizontalSliderPage(WebDriver driver){
        super(driver);
    }
    public void open(){
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
    }
    public String getSliderValue(){
        wait.until(ExpectedConditions.visibilityOf(valueDisplay));
        return valueDisplay.getText();
    }
    public void moveSliderRight(int offset){
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(offset, 0).release().perform();
    }
}
