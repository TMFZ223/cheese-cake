package pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import utils.PropertyReader;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;

public interface BasePage {
    public static String BASE_URL = PropertyReader.getProperty("cheese-cake.base.url");
    public static String ID_PATTERN = "#%s";
    public static String CLASS_PATTERN = "[class='%s']";

    default void clickIn(SelenideElement element) {
        element.scrollIntoCenter().click();
    }

    default void setValueIn(SelenideElement element, String value) {
        element.setValue(value);
    }

    default void checkExactTextIn(SelenideElement element, String text) {
        element.shouldBe(visible)
                .shouldHave(exactTextCaseSensitive(text));
    }

    default void checkSizeIn(ElementsCollection elements) {
        elements.shouldBe(sizeGreaterThanOrEqual(1));
        elements.forEach(element -> element.shouldBe(visible));
    }

    @Attachment(value = "screenshot", type = "image/png")
    private static byte[] takeScreenshot() {
        return (Selenide.screenshot(OutputType.BYTES));
    }
}