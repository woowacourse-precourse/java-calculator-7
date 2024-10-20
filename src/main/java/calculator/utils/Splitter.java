package calculator.utils;

import calculator.constant.ErrorMessage;

import java.util.List;

import static calculator.constant.DelimiterConst.DEFAULT_DELIMITERS;
import static calculator.constant.DelimiterConst.START_POINT_OF_CUSTOM_DELIMITER;
import static calculator.constant.DelimiterConst.END_POINT_OF_CUSTOM_DELIMITER;

public class Splitter {
    public static List<String> getCalculationSectionSplitByDelimiter(String userInput) {
        if (isUsingCustomDelimiter(userInput)) {
            return splitWithCustomDelimiter(userInput);
        }

        return splitWithDefaultDelimiter(userInput);
    }

    private static List<String> splitWithDefaultDelimiter(String userInput) {
        return List.of(getCalculationSection(DEFAULT_DELIMITERS, userInput));
    }

    private static List<String> splitWithCustomDelimiter(String userInput) {
        String customSection = getCustomSection(userInput);
        String customDelimiter = getCustomDelimiter(customSection);

        validateDelimiter(customDelimiter);

        return List.of(getCalculationSection(customDelimiter, userInput));
    }

    private static String[] getCalculationSection(String delimiter, String userInput) {
        if (isUsingCustomDelimiter(userInput)) {
            int customEscapeIndex = getCustomEscapeIndex(userInput);
            return userInput.substring(customEscapeIndex + 2).split(delimiter);
        }

        return userInput.split(delimiter);
    }

    private static String getCustomSection(String userInput) {
        int customEscapeIndex = getCustomEscapeIndex(userInput);
        return userInput.substring(0, customEscapeIndex);
    }

    private static String getCustomDelimiter(String customSection) {
        String customDelimiter = customSection.replace(START_POINT_OF_CUSTOM_DELIMITER, "");

        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }

        return customDelimiter;
    }

    private static int getCustomEscapeIndex(String userInput) {
        return userInput.indexOf(END_POINT_OF_CUSTOM_DELIMITER);
    }

    private static boolean isUsingCustomDelimiter(String userInput) {
        return getCustomEscapeIndex(userInput) > 0;
    }

    private static void validateDelimiter(String delimiter) {
        if (Validator.isNumeric(delimiter)) {
            throw new IllegalArgumentException(ErrorMessage.CAN_USE_ONLY_STRING.getMessage());
        }
    }
}
