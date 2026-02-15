package pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.PropertyReader;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;

public interface BasePage {
    public static String BASE_URL = PropertyReader.getProperty("cheese-cake.base.url");
    public static String ID_PATTERN = "#%s";
    public static String CLASS_PATTERN = "[class='%s']";

    default void clickIn(SelenideElement element) {
        element.highlight().click();
        takeScreenshot();
    }

    default void setValueIn(SelenideElement element, String value) {
        element.highlight().setValue(value);
        takeScreenshot();
    }

    default void checkexactTextIn(SelenideElement element, String text) {
        element.shouldBe(visible)
                .shouldHave(exactTextCaseSensitive(text))
                .highlight();
        takeScreenshot();
    }

    default void checkSizeIn(ElementsCollection elements) {
        elements.shouldBe(sizeGreaterThanOrEqual(1));
        for (SelenideElement element : elements) {
            element.shouldBe(visible).highlight();
        }
    }

    @Attachment(value = "screenshot", type = "image/png")
    private static byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver())
                .getScreenshotAs(OutputType.BYTES);
    }
}