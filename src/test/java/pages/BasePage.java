package pages;

import utils.PropertyReader;

public interface BasePage {
    public static String BASE_URL = PropertyReader.getProperty("cheese-cake.base.url");
    public static String ID_PATTERN = "#%s";
    public static String CLASS_PATTERN = "[class='%s']";
}
