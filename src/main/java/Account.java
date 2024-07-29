import io.qameta.allure.Step;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    @Step("Check whitespace in name")
    public boolean checkNameToEmboss() {
        String patternString = "^\\S{3,19}(?:\\s\\S{3,19})?$";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}