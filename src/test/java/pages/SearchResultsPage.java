package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage implements BasePage {
    private final ElementsCollection results = $$(CLASS_PATTERN.formatted("card-title-under-img pt-1"));
    private final SelenideElement noResultsElement = $(CLASS_PATTERN.formatted("item-message-info message-on-page"));

    @Step("Убедиться, что после поиска существующих десертов список результатов содержит1 или более элементов")
    public void checkQuantityDessertsSearchList() {
        checkSizeIn(results);
    }

    @Step("Убедиться, что при отсутствии результатов поиска отображается сообщение {expectedMessage}")
    public void checkNoResultMessage(String expectedMessage) {
        checkExactTextIn(noResultsElement, expectedMessage);
    }
}
