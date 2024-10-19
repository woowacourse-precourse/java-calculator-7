package calculator.model;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.constants.DelimiterEnum.*;
import static calculator.controller.ExceptionMessage.*;

public class Model {
    private static final calculator.model.Parser parser = new Parser();

    public static String[] customDelimiterAddCalculator(String userInput) {
        userInput = userInput.replace("\\n", CUSTOM_DELIMITER_BACKWARD.getValue());
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN.getValue()).matcher(userInput);
        if (m.find()) {
            String[] numbers = splitByCustomDelimiter(m.group(2), m.group(1));
            isContainMinus(numbers);
            return numbers;
        }

        throw new IllegalArgumentException(INVALID_CUSTOM_TYPE.format());
    }

    public static String[] defaultDelimiterAddCalculator(String userInput) {
        String[] numbers = userInput.split(DEFAULT_DELIMITER.getValue());
        isContainMinus(numbers);
        return numbers;
    }

    private static String[] splitByCustomDelimiter(String userInput, String customDelimiter) {
        if (userInput.matches(".*[,:].*")) {
            String combinedDelimiter = Pattern.quote(customDelimiter) + AND.getValue() + DEFAULT_DELIMITER.getValue();
            return userInput.split(combinedDelimiter);
        }
        if (userInput.contains(customDelimiter)) {
            return userInput.split(Pattern.quote(customDelimiter));
        }
        if (userInput.matches("\\d+")) {
            return new String[]{userInput};
        }
        throw new IllegalArgumentException(INVALID_CUSTOM_TYPE.format());
    }

    public static int getSum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(parser::toInt)
                .sum();
    }

    public static boolean isCheckNullOrEmpty(String userInput) {
        return userInput == null || userInput.isEmpty();
    }

    public static void isContainZero(String userInput) {
        if (userInput.contains(ZERO.getValue())) {
            throw new IllegalArgumentException(MUST_BE_DIGIT.format());
        }
    }

    public static void isContainMinus(String[] numbers) {
        if (Arrays.toString(numbers).contains(MINUS.getValue())) {
            throw new IllegalArgumentException(MUST_BE_DIGIT.format());
        }
    }
}
