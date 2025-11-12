package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;


public class HorizontalSliderTest extends BaseTest {
    @Test
    public void testSliderMovement(){
        HorizontalSliderPage sliderPage = new HorizontalSliderPage(driver);
        sliderPage.open();

        String initialValue = sliderPage.getSliderValue();
        sliderPage.moveSliderRight(40);
        String newValue = sliderPage.getSliderValue();

        Assert.assertNotEquals(newValue, initialValue, "Значення слайдера не змінилося після руху");
        System.out.println("Було: " + initialValue + " Стало " + newValue);

    }
}
