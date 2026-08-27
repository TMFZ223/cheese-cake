package user;

import utils.PropertyReader;

public class UserFactory {

    public static User withCorrectCredantials() {
        return User.builder()
                .login(PropertyReader.getProperty("correct.login"))
                .password(PropertyReader.getProperty("correct.password"))
                .build();
    }

    public static User withIncorrectLogin() {
        return User.builder()
                .login(PropertyReader.getProperty("incorrect.login"))
                .password(PropertyReader.getProperty("correct.password"))
                .build();
    }

    public static User withEmptyLogin() {
        return User.builder()
                .login("")
                .password(PropertyReader.getProperty("correct.password"))
                .build();
    }

    public static User withEmptyPassword() {
        return User.builder()
                .login(PropertyReader.getProperty("correct.login"))
                .password("")
                .build();
    }

    public static User withEmptyCredantials() {
        return User.builder()
                .login("")
                .password("")
                .build();
    }
}