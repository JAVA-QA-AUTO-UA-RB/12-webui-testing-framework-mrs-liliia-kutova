package tests;

import base.BaseTest;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

public class CheckboxesTest extends BaseTest {
    @Test
    public void testSelectAllCheckboxes(){
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.open();

        Assert.assertTrue(checkboxesPage.getCheckboxCount() > 0,"Чекбокси не знайдено на сторінці");

        checkboxesPage.selectAllCheckboxes();
        Assert.assertTrue(checkboxesPage.areAllcheckboxesSelected(), "Не всі чекбокси вибрані");
    }
    @Test
    public void testDeselectAllCheckboxes(){
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.open();
        checkboxesPage.deselectAllCheckboxes();
        Assert.assertTrue(checkboxesPage.areAllCheckboxesUnselected(), "Не всі чекбокси знято");
    }
}
