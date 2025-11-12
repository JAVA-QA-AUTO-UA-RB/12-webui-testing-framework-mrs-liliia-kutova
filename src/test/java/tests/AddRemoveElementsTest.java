package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void testAddRemoveElements(){
        AddRemoveElementsPage page = new AddRemoveElementsPage(driver);
        page.open();

        page.addElements(3);
        Assert.assertEquals(page.getDeleteButtonsCount(), 3, "Очікується 3 кнорки 'Delete'");

        page.removeAllElements();
        Assert.assertTrue(page.isDeleteButtonsEmpty(), "Кнопки 'Delete' повинні бути відсутні");
    }
}
