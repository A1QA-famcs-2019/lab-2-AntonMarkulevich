import driver.Browser;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginForm;
import pages.OnlinerMainPage;
import pages.PopularSections;
import pages.SectionPage;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class OnlinerTest {
    private String login;
    private String password;

    @BeforeMethod
    public void setUp() {
        ResourceBundle testResources = ResourceBundle.getBundle("testResources");
        login = testResources.getString("login");
        password = testResources.getString("password");
        Browser.getDriver().manage().window().maximize();
        Browser.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Browser.getDriver().get("http://onliner.by/");
    }

    @Test
    public void onlinerTest() {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 10);
        OnlinerMainPage onlinerMainPage = new OnlinerMainPage();
        onlinerMainPage.clickLogIn();
        new LoginForm().login(login, password, wait);
        String sectionName = PopularSections.goToRandomSection(wait);
        Assert.assertEquals(new SectionPage().getSectionTitleText(), sectionName);

        Browser.getDriver().navigate().back();

        onlinerMainPage.clickLogOut();
    }
}
