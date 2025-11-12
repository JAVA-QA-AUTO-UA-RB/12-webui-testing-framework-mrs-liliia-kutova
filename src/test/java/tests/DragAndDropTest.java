package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDropPage;

public class DragAndDropTest extends BaseTest {
    @Test
    public void testDragAndDrop(){
        DragAndDropPage page = new DragAndDropPage(driver);
        page.open();

        String beforeA = page.getColumnAText();
        String beforeB = page.getColumnBText();

        page.dragAtoB();

        String afterA = page.getColumnAText();
        String afterB = page.getColumnBText();

        Assert.assertNotEquals(beforeA, afterA, "Елементи не помінялися місцями");
        Assert.assertNotEquals(beforeB, afterB, "Елементи не помінялися місцями");
    }
}
