package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DessertsPage implements BasePage {
    private final SelenideElement userName = $x("//*[@class='cc-account-icon']/following-sibling::span");
    private final SelenideElement searchInput = $(ID_PATTERN.formatted("search-string-input-head"));
    private final SelenideElement searchButton = $(CLASS_PATTERN.formatted("btn-danger rounded-right search-button"));

    @Step("Убедиться, что на странице отображается имя пользователя {expectedUserName}")
    public void checkUserName(String expectedUserName) {
        checkExactTextIn(userName, expectedUserName);
    }

    @Step("Ввести в поле поиска значения {dessertName}")
    public void enterDessertName(String dessertName) {
        setValueIn(searchInput, dessertName);
    }

    @Step("Нажать на кнопку поиска")
    public void clickSearchButton() {
        clickIn(searchButton);
    }
}
