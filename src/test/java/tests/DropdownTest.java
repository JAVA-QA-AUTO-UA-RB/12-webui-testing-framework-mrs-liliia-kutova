package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTest extends BaseTest {
    @Test
    public void testSelectedDropdownOption(){
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.open();

        dropdownPage.selectOption("Option 2");
        Assert.assertEquals(dropdownPage.getSelectedOption(), "Option 2", "Óption 2 повинна бути вибрана");
    }
}
