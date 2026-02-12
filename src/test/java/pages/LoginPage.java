package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import user.User;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage implements BasePage {
    private final SelenideElement withLogin = $(ID_PATTERN.formatted("enterLogin0"));
    private final SelenideElement loginInput = $(ID_PATTERN.formatted("modal_auth_login"));
    private final SelenideElement passwordInput = $(ID_PATTERN.formatted("modal_auth_password"));
    private final SelenideElement loginButton = $(CLASS_PATTERN.formatted("btn cc-btn-submit btn-danger"));
    private final SelenideElement autharizationError = $("[style='display: block;']");

    @Step("Кликнуть по элементу войти по логину")
    public void clickWithLogin() {
        withLogin.click();
    }

    @Step("Выполнить вход в систему")
    public void login(User user) {
        enterLogin(user.getLogin());
        enterPassword(user.getPassword());
        clickLoginButton();
    }

    @Step("Ввести в поле логина значение {login}")
    public void enterLogin(String login) {
        loginInput.setValue(login);
    }

    @Step("Ввести в поле пароля значение {password}")
    public void enterPassword(String password) {
        passwordInput.setValue(password);
    }

    @Step("Нажать на кнопку входа")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Убедиться, что показан текст ошибки {expectedError}")
    public void checkError(String expectedError) {
        autharizationError.shouldBe(visible)
                .shouldHave(exactText(expectedError));
    }
}
