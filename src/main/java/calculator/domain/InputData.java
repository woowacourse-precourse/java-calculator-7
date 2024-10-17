package calculator.domain;

import calculator.constant.Condition;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputData {
    private final Separators separators;
    private final Numbers numbers;

    public InputData(String input) {
        input = input.strip();

        separators = new Separators();
        input = findSeparator(input);

        numbers = new Numbers();
        if (!input.isEmpty()) {
            separateNumber(input);
        }
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

    private void separateNumber(String input) {
        if (input.isEmpty()) {
            return;
        }

        if (isStartOrEndSeparator(input)) {
            throw new IllegalArgumentException();
        }

        String[] tokens = input.split(separators.makePattern());

        for (String token : tokens) {
            numbers.add(token);
        }
    }

    private boolean isStartOrEndSeparator(String input) {
        return separators.contain(input.charAt(0)) || separators.contain(input.charAt(input.length() - 1));
    }
}