package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainPage implements BasePage {
    private final SelenideElement acceptCity = $(ID_PATTERN.formatted("modal-confirm-city"));
    private final SelenideElement loginLink = $("[data-target='#authModal']");

    @Step("Открыть страницу {this.BASE_URL}")
    public void openPage() {
        Selenide.open(BASE_URL);
    }

    @Step("Перейти по ссылке входа в личный кабинет")
    public void goLoginLink() {
        if (acceptCity.exists()) {
            clickIn(acceptCity);
        }
        clickIn(loginLink);
    }
}
