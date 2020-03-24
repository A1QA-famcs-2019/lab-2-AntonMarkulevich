package pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginForm {
    private WebElement loginTextField = Browser.getDriver().findElement(By.xpath("//div[contains(@class,'auth-form__line')]//input[@type=\"text\"]"));
    private WebElement passwordTextField = Browser.getDriver().findElement(By.xpath("//div[contains(@class,'auth-form__line')]//input[@type=\"password\"]"));
    private WebElement loginButton = Browser.getDriver().findElement(By.xpath("//div[contains(@class, 'auth-form__control')]//button[@type='submit']"));
    private WebElement signInForm = Browser.getDriver().findElement(By.xpath("//div[contains(@class, 'auth-container')]//button[@type='submit']"));

    public void login(WebDriverWait wait) {
        loginTextField.sendKeys("qwertreyrt");
        passwordTextField.sendKeys("password");
        loginButton.click();
        wait.until(ExpectedConditions.invisibilityOf(signInForm));
    }

}
