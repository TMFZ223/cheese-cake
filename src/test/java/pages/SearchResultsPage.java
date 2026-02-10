package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage implements BasePage {
    private final ElementsCollection results = $$(CLASS_PATTERN.formatted("card cc-card-product border-0"));
    private final SelenideElement noResultsElement = $(CLASS_PATTERN.formatted("item-message-info message-on-page"));

    @Step("Убедиться, что после поиска существующих десертов список результатов содержит1 или более элементов")
    public void checkQuantityDessertsSearchList() {
        results.shouldHave(sizeGreaterThanOrEqual(1));
        for (SelenideElement result : results) {
            result.shouldBe(visible);
        }
    }

    @Step("Убедиться, что при отсутствии результатов поиска отображается сообщение {expectedMessage}")
    public void checkNoResultMessage(String expectedMessage) {
        noResultsElement.shouldBe(visible)
                .shouldHave(exactText(expectedMessage));
    }
}
