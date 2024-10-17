package calculator.domain;

import calculator.constant.Condition;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputData {
    private final Separators separators;
    private Numbers numbers;

    public InputData(String input) {
        input = input.strip();

        separators = new Separators();
        input = findSeparator(input);
    }

    private String findSeparator(String input) {
        Pattern pattern = Pattern.compile(Condition.CUSTOM_SEPARATOR_INPUT);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            separators.add(matcher.group().charAt(Condition.CUSTOM_SEPARATOR_POSITION));
            return matcher.replaceFirst("");
        }

        return input;
    }
}