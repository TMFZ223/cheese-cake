package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.*;
import pages.DessertsPage;
import pages.LoginPage;
import pages.MainPage;
import pages.SearchResultsPage;
import listeners.ListenerTestNG;

@Listeners({AllureTestNg.class, ListenerTestNG.class})
public class BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    DessertsPage dessertsPage;
    SearchResultsPage searchResultsPage;

    @BeforeMethod
    @Step("Открыть браузер")
    public void setUp(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 30000;
        Configuration.timeout = 15000;
        mainPage = new MainPage();
        loginPage = new LoginPage();
        dessertsPage = new DessertsPage();
        searchResultsPage = new SearchResultsPage();
    }

    @AfterMethod(alwaysRun = true)
    @Step("Очистить куки и закрыть браузер")
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }
}
