package elements;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    private By locator;
    private String name;
    public  BaseElement (){

    }
    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    protected WebElement getElement() {
        return Browser.getDriver().findElement(locator);
    }

    public void click() {
        getElement().click();
    }
}
