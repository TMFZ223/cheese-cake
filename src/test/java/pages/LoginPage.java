package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import user.User;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage implements BasePage {
    private final SelenideElement withLogin = $(ID_PATTERN.formatted("enterLogin0"));
    private final SelenideElement loginInput = $(ID_PATTERN.formatted("modal_auth_login"));
    private final SelenideElement passwordInput = $(ID_PATTERN.formatted("modal_auth_password"));
    private final SelenideElement loginButton = $(CLASS_PATTERN.formatted("btn cc-btn-submit btn-danger"));
    private final SelenideElement autharizationError = $x("//*[@class='tab-pane show active']/div");

    @Step("Кликнуть по элементу войти по логину")
    public void clickWithLogin() {
        clickIn(withLogin);
    }

    @Step("Выполнить вход в систему")
    public void login(User user) {
        enterLogin(user.getLogin());
        enterPassword(user.getPassword());
        clickLoginButton();
    }

    @Step("Ввести в поле логина значение {login}")
    public void enterLogin(String login) {
        setValueIn(loginInput, login);
    }

    @Step("Ввести в поле пароля значение {password}")
    public void enterPassword(String password) {
        setValueIn(passwordInput, password);
    }

    @Step("Нажать на кнопку входа")
    public void clickLoginButton() {
        clickIn(loginButton);
    }

    @Step("Убедиться, что показан текст ошибки {expectedError}")
    public void checkError(String expectedError) {
        checkExactTextIn(autharizationError, expectedError);
    }
}
