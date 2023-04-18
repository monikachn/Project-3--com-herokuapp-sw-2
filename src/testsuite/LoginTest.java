package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //Enter “tomsmith” username
        driver.findElement(By.name("username")).sendKeys("tomsmith");

        //Enter “SuperSecretPassword!” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[text() = ' Login']")).click();

        //Verify the error message “Your username"
        String expectedMessage = "Secure Area";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[text() = ' Secure Area']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Verify Secure Area text displayed ", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter “tomsmith1” username
        driver.findElement(By.name("username")).sendKeys("tomsmith1");

        //Enter “SuperSecretPassword!” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[text() = ' Login']")).click();

        //Verify the error message “Your username is invalid!”
        String expectedMessage = "Your username is invalid!\n" + "×";
        WebElement actualTextElement = driver.findElement(By.id("flash-messages"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //Enter “tomsmith” username
        driver.findElement(By.name("username")).sendKeys("tomsmith");

        //Enter “SuperSecretPassword” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[text() = ' Login']")).click();

        //Verify the error message “Your password is invalid!”
        String expectedMessage = "Your password is invalid!\n" + "×";
        WebElement actualTextElement = driver.findElement(By.id("flash-messages"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    public void closeBrowser(){
        driver.quit();

    }


}