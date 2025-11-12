package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;

public class AuthenticationTest extends BaseTest{
    @Test
    public void testSuccessfulLoginAndLogout(){
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.clickFormAuthentication();

        LoginPage loginPage = new LoginPage(driver);
        SecureAreaPage secureAreaPage = loginPage.loginAs("tomsmith", "SuperSecretPassword!");

        Assert.assertTrue(
                secureAreaPage.getSuccessMessage().contains("You logged into a secure area!"),
                "Повідомлення про успішний логін відсутнє"
        );
        secureAreaPage.logout();
        Assert.assertTrue(
                loginPage.getFlashMessage().contains("You logged out of the secure area!"),
                "Після logout не з`яіилося повідомлення про вихід"
        );
    }

}
