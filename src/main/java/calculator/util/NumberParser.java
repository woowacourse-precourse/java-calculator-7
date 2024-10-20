package calculator.util;

import calculator.model.Number;

public class NumberParser {
    public Number[] parse(String input, String customDelimiter) {
        String[] strings = splitStrings(input, customDelimiter);
        Number[] numbers = new Number[strings.length];
        for (int i = 0; i < strings.length; i++) {
            numbers[i] = new Number(strings[i]);
        }
        return numbers;
    }

    private String[] splitStrings(String input, String customDelimiter) {
        if (customDelimiter == null || customDelimiter.isBlank()) {
            return input.split("[,:]");
        }
        return input.split(customDelimiter);
    }
}
