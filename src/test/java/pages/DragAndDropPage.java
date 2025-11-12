package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {
    @FindBy(id= "column-a")
    private WebElement columnA;

    @FindBy(id = "column-b")
    private WebElement columnB;

    public DragAndDropPage(WebDriver driver){
        super(driver);
    }


    public void open() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    }
    public String getColumnAText(){
        return columnA.getText();
    }
    public String getColumnBText(){
        return columnB.getText();
    }
    public void dragAtoB(){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(columnA, columnB).perform();
    }
}
