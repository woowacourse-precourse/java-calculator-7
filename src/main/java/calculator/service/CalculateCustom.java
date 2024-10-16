package calculator.service;

import java.util.List;

public class CalculateCustom extends CalculateSeparator {

    private static final String CUSTOM_PRE = "//";
    private static final String CUSTOM_POST = "\\n";
    private static final Integer TWO = 2;

    public static boolean checkNotContainCustom(String userInput) {
        return checkNotContainSeparator(userInput, CUSTOM_PRE) || checkNotContainSeparator(userInput, CUSTOM_POST);
    }

    public static Integer getCustomPreIndex(String userInput) {
        return getIndexNumberOfSeparator(userInput, CUSTOM_PRE);
    }

    public static Integer getCustomPostIndex(String userInput) {
        return getIndexNumberOfSeparator(userInput, CUSTOM_POST) + TWO;
    }

    public static String getCustomPreToPost(String userInput) {
        return substringUserInputWithSeparator(userInput, getCustomPreIndex(userInput), getCustomPostIndex(userInput));
    }

    public static String getCustomSeparator(String userInput) {
        String splitCustom = getCustomPreToPost(userInput);
        return substringUserInputWithSeparator(splitCustom, TWO, getUserInputLength(splitCustom) - TWO);
    }

    public static String getUserInput(String userInput) {
        return substringUserInputWithSeparator(userInput, getCustomPostIndex(userInput), getUserInputLength(userInput));
    }

    public static List<String> splitWithCustomSeparator(String userInput) {
        String splitUserInput = getUserInput(userInput);
        String splitCustomSeparator = getCustomSeparator(userInput);
        if (checkNotContainSeparatorInUserInput(splitUserInput, splitCustomSeparator)) {
            //예외 처리
            throw new IllegalArgumentException("에러 처리-커스텀 구분자");
        }
        return splitWithSeparator(splitUserInput, splitCustomSeparator);
    }

    public static boolean checkNotContainSeparatorInUserInput(String userInput, String separator) {
        return checkNotContainSeparator(userInput, separator);
    }
}
