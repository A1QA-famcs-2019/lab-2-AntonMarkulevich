package pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class PopularSections {
    private static List <WebElement> getSectionsList() {
        return Browser.getDriver().findElements(By.xpath("//ul[contains(@class, 'project-navigation__list')]//a[contains(@class, 'project-navigation__link')]"));
    }

    private static String getSectionText(WebElement section) {
        return section.findElement(By.xpath(".//span[@class='project-navigation__sign']")).getText();
    }

    public static String goToRandomSection(WebDriverWait wait) {
        List<WebElement> popularSection = PopularSections.getSectionsList();
        Random random = new Random();
        WebElement randomSection = popularSection.get(random.nextInt(popularSection.size()));
        String sectionName = getSectionText(randomSection);
        randomSection.click();
        return sectionName;
    }
}
