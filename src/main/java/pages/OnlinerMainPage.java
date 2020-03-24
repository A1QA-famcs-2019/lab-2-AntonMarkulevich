package pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OnlinerMainPage {
    private WebElement loginBtn = Browser.getDriver().findElement(By.xpath("//div[contains(@class,'auth-bar__item--text')]"));
    private WebElement logoutBtn = Browser.getDriver().findElement(By.xpath("//div[@class='b-top-profile__header']//div[@class='b-top-profile__logout']//a[contains(@class, 'b-top-profile__link')]"));
    private WebElement userMenuBtn = Browser.getDriver().findElement(By.xpath("//a[contains(@class, 'js-toggle-bar') and contains(@class, 'b-top-profile__preview')]"));

    public void clickLogIn() {
        loginBtn.click();
    }

    public void clickLogOut() {
        userMenuBtn.click();
        logoutBtn.click();
    }
}
