package tests;

import io.qameta.allure.Feature;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import user.UserFactory;

@Feature("логин")
public class LoginTest extends BaseTest {

    @Test(description = "Позитивный тест на логин")
    public void positiveLoginTest() {
        mainPage.openPage();
        mainPage.goLoginLink();
        loginPage.clickWithLogin();
        loginPage.login(UserFactory.withCorrectCredantials());
        dessertsPage.checkUserName("Роберт");
    }

    @DataProvider
    public Object[][] negativeTestLoginData() {
        return new Object[][]{
                {UserFactory.withIncorrectLogin()},
                {UserFactory.withEmptyLogin()},
                {UserFactory.withEmptyPassword()},
                {UserFactory.withEmptyCredantials()}};
    }

    @Test(description = "Негативный тест на логин", dataProvider = "negativeTestLoginData")
    public void negativeLoginTest(User user) {
        mainPage.openPage();
        mainPage.goLoginLink();
        loginPage.clickWithLogin();
        loginPage.login(user);
        loginPage.checkError("Ошибка аутентификации");
    }
}
