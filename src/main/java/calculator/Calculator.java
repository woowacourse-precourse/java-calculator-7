package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    String separator;

    public int run(String input) {
        initial();
        getSeparator(input);
        isInputValid(input);
        return calculate(input);
    }

    public void initial() {
        separator = ",:";
    }

    public void getSeparator(String input) {
        Pattern pattern = Pattern.compile("//(.)\\\\n.*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            separator += matcher.group();
        }
    }

    public void isInputValid(String input) {

    }

    public int calculate(String input) {
        return 1;
    }
}
