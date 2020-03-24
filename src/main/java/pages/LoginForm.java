package pages;

import driver.Browser;
import elements.Button;
import elements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginForm {
    private TextBox loginTextField = new TextBox(By.xpath("//div[contains(@class,'auth-form__line')]//input[@type=\"text\"]"), "loginTextField");
    private TextBox passwordTextField = new TextBox(By.xpath("//div[contains(@class,'auth-form__line')]//input[@type=\"password\"]"), "passwordTextField");
    private Button loginButton = new Button(By.xpath("//div[contains(@class, 'auth-form__control')]//button[@type='submit']"), "loginButton");
    private WebElement signInForm = Browser.getDriver().findElement(By.xpath("//div[contains(@class, 'auth-container')]//button[@type='submit']"));


    public void login(String login, String password, WebDriverWait wait) {
        loginTextField.sendKeys(login);
        passwordTextField.sendKeys(password);
        loginButton.click();
        wait.until(ExpectedConditions.invisibilityOf(signInForm));
    }

}
