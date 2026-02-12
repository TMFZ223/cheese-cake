package tests;

import io.qameta.allure.Feature;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.UserFactory;

import static enums.Desserts.*;

@Feature("Поиск десертов")
public class SearchTest extends BaseTest {

    @DataProvider
    public Object[][] existsDessertsQuery() {
        return new Object[][]{
                {TARTLETS.getDessertTitle()},
                {CHEESECAKEE.getDessertTitle()},
                {DONUTS.getDessertTitle()}};
    }

    @Test(description = "Поиск существующего десерта", dataProvider = "existsDessertsQuery")
    public void searchExistsDessertsTest(String query) {
        mainPage.openPage();
        mainPage.goLoginLink();
        loginPage.clickWithLogin();
        loginPage.login(UserFactory.withCorrectCredantials());
        dessertsPage.enterDessertName(query);
        dessertsPage.clickSearchButton();
        searchResultsPage.checkQuantityDessertsSearchList();
    }

    @DataProvider
    public Object[][] negativeSearchData() {
        return new Object[][]{
                {"Блинный торт"},
                {""}};
    }

    @Test(description = "Негативный тест поиска (ввод несуществующего в базе десерта, а также поиск с пустым значением в поле", dataProvider = "negativeSearchData")
    public void negativeSearchTest(String negativeSearchQuery) {
        mainPage.openPage();
        mainPage.goLoginLink();
        loginPage.clickWithLogin();
        loginPage.login(UserFactory.withCorrectCredantials());
        dessertsPage.enterDessertName(negativeSearchQuery);
        dessertsPage.clickSearchButton();
        searchResultsPage.checkNoResultMessage("Товаров, соответствующих вашему запросу, не обнаружено.");
    }
}
