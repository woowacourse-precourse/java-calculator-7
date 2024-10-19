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
        if (input.isEmpty()) {
            return;
        }
        String regex = String.format("(//[^0-9]\\\\n)?([0-9]+)([%s]([0-9]+))*", separator);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }

    public int calculate(String input) {
        return 1;
    }
}
