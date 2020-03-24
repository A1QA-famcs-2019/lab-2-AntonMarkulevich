import driver.Browser;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginForm;
import pages.OnlinerMainPage;
import pages.PopularSections;
import pages.SectionPage;

import java.util.concurrent.TimeUnit;

public class OnlinerTest {

    @BeforeMethod
    public void setUp() {
        Browser.getDriver().manage().window().maximize();
        Browser.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Browser.getDriver().get("http://onliner.by/");
    }

    @Test
    public void onlinerTest() {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 10);
        OnlinerMainPage onlinerMainPage = new OnlinerMainPage();
        onlinerMainPage.clickLogIn();
        new LoginForm().login(wait);
        String sectionName = PopularSections.goToRandomSection(wait);
        Assert.assertEquals(new SectionPage().getSectionTitleText(), sectionName);

        Browser.getDriver().navigate().back();

        onlinerMainPage.clickLogOut();
    }
}
