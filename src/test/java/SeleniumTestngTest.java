import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

// This test class inherits BasicSetupTest class, where the browser is initialized
// browser variable is available here as it's inherited, so you'll have it available at any place
public class SeleniumTestngTest extends BasicSetupTest {

    @Test
    public void abTestingPageHasSpecificTextTest() {
        browser.get("https://the-internet.herokuapp.com/");
        // Write your code here (just an example provided)
        WebElement abTestingTaskLink = browser.findElement(By.linkText("A/B Testing"));
        abTestingTaskLink.click();

        WebElement heading = browser.findElement(By.tagName("h3"));
        String headingText = heading.getText();


        // Write your assertions in the after the steps of scenario are executed to validate results
        Assert.assertTrue(
                headingText.startsWith("A/B Test"),
                "Очікується заголовок, що починається з 'A/B Test', aле отримано: " + headingText);
    }

    // Write the rest of TEST METHODS according to the task here, each method checking one scenario described in README.md file
    // In the end you should have a set of test methods each of them describing some specific scenario
    @Test
    public void addRemoveElementsTest() {
        browser.get("https://the-internet.herokuapp.com/");
        WebElement addRemoveTestElement = browser.findElement(By.linkText("Add/Remove Elements"));
        addRemoveTestElement.click();

        WebElement addElement = browser.findElement(By.xpath("//button[text()='Add Element']"));
        for (int i = 0; i < 3; i++) {
            addElement.click();
        }
        List<WebElement> deleteButtons = browser.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(deleteButtons.size(), 3, "Очікується 3 кнопки 'Delete' після додавання.");

        for (WebElement deleteButton : deleteButtons) {
            deleteButton.click();
        }
        List<WebElement> remainingButtons = browser.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertTrue(remainingButtons.isEmpty(), "Кнопки 'Delete' були видалені всі");
    }

    @Test
    public void addCheckboxTest() {
        browser.get("https://the-internet.herokuapp.com/");
        WebElement addCheckbox = browser.findElement(By.linkText("Checkboxes"));
        addCheckbox.click();
        List<WebElement> checkboxes = browser.findElements(By.cssSelector("input[type='checkbox']"));
        Assert.assertFalse(checkboxes.isEmpty(), "Не знайдено жодного чекбоксу");
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isSelected(), "Один з чекбоксів не вибрано");
        }
    }

    @Test
    public void dropdownSelectionTest() {
        browser.get("https://the-internet.herokuapp.com/");
        WebElement dropdownLink = browser.findElement(By.linkText("Dropdown"));
        dropdownLink.click();
        WebElement selectElement = browser.findElement(By.id("dropdown"));
        Select dropdown = new Select(selectElement);
        dropdown.selectByVisibleText("Option 2");
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        Assert.assertEquals(selectedOption.getText(), "Option 2", "Option 2 вибрана");
    }

    @Test
    public void loginLogoutTest() {
        browser.get("https://the-internet.herokuapp.com/");
        WebElement formAuthentication = browser.findElement(By.linkText("Form Authentication"));
        formAuthentication.click();
        WebElement username = browser.findElement(By.id("username"));
        WebElement password = browser.findElement(By.id("password"));
        WebElement loginButton = browser.findElement(By.cssSelector("button[type='submit']"));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        loginButton.click();


        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("flash"))
        );
        Assert.assertTrue(
                successMessage.getText().contains("You logged into a secure area!"),
                "З`вилося повідомлення про успішний логін"
        );

        WebElement logoutButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("a.button.secondary.radius"))
        );
        logoutButton.click();
        WebElement logoutMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("flash"))
        );
        Assert.assertTrue(
                logoutMessage.getText().contains("You logged out of the secure area!"),
                "Після logout з`являється повідомлення про завершення сесії"
        );

        if (!browser.getCurrentUrl().contains("/login")) {
            System.out.println("Сайт не перенаправив на /login автоматично — переходимо вручну.");
            browser.get("https://the-internet.herokuapp.com/login");
        }

        WebElement loginHeader =wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Login Page']")));
        Assert.assertEquals(loginHeader.getText(), "Login Page", "Після logout відображається сторінка логіну");


    }

    @Test
    public void dragAndDropElementsTest() {
        browser.get("https://the-internet.herokuapp.com/");
        WebElement dragAndDropElements = browser.findElement(By.linkText("Drag and Drop"));
        dragAndDropElements.click();

        WebElement columnA = browser.findElement(By.id("column-a"));
        WebElement columnB = browser.findElement(By.id("column-b"));
        String beforeA = columnA.getText();
        String beforeB = columnB.getText();
        Actions actions = new Actions(browser);
        actions.dragAndDrop(columnA, columnB).perform();

        String afterA = columnA.getText();
        String afterB = columnB.getText();

        Assert.assertNotEquals(beforeA, afterA, "Елементи помінялися місцями");
        Assert.assertNotEquals(beforeB, afterB, "Елементи помінялися місцями");
    }

    @Test
    public void sliderElementTest() {
        browser.get("https://the-internet.herokuapp.com/");
        WebElement sliderElement = browser.findElement(By.linkText("Horizontal Slider"));
        sliderElement.click();

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        WebElement slider = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='range']"))
                );

        WebElement valueDisplay = browser.findElement(By.id("range"));

        slider.click();

        while (!valueDisplay.getText().equals("3")){
            slider.sendKeys(org.openqa.selenium.Keys.ARROW_RIGHT);
        }


        Assert.assertEquals(valueDisplay.getText(), "3",
                "Значення слайдера змінилося на 3");
        System.out.println(" Слайдер встановлено на " + valueDisplay.getText());
    }
}




