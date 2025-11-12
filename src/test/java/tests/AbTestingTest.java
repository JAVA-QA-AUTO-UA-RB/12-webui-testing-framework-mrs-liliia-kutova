package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AbTestingPage;

public class AbTestingTest extends base.BaseTest {

    @Test
    public void headerShouldContainAbTestText() {
        String text = new AbTestingPage(driver)
                .open()
                .getHeaderText();
        Assert.assertTrue(text.contains("A/B Test"), "Очікували, що заголовок міститиме 'A/B Test'");
    }
}