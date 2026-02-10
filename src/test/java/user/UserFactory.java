package user;

import utils.PropertyReader;

public class UserFactory {

    public static User withCorrectCredantials() {
        return new User(PropertyReader.getProperty("correct.login"), PropertyReader.getProperty("correct.password"));
    }

    public static User withIncorrectLogin() {
        return new User(PropertyReader.getProperty("incorrect.login"), PropertyReader.getProperty("correct.password"));
    }

    public static User withEmptyLogin() {
        return new User("", PropertyReader.getProperty("correct.password"));
    }

    public static User withEmptyPassword() {
        return new User(PropertyReader.getProperty("correct.login"), "");
    }

    public static User withEmptyCredantials() {
        return new User("", "");
    }
}