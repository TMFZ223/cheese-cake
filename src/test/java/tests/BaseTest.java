package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DessertsPage;
import pages.LoginPage;
import pages.MainPage;
import pages.SearchResultsPage;
import utils.PropertyReader;

public class BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    DessertsPage dessertsPage;
    SearchResultsPage searchResultsPage;

    @BeforeMethod
    @Step("Открыть браузер")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
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
