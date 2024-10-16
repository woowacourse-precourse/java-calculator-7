package calculator.service;

import java.util.List;

public class CalculateCustom extends CalculateSeparator {

    private static final String CUSTOM_PRE = "//";
    private static final String CUSTOM_POST = "\\n";
    private static final Integer TWO = 2;

    public static boolean checkContainCustom(String userInput) {
        return checkContainSeparator(userInput, CUSTOM_PRE) || checkContainSeparator(userInput, CUSTOM_POST);
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
        return substringUserInputWithSeparator(getCustomPreToPost(userInput), TWO, getUserInputLength(getCustomPreToPost(userInput)) - TWO);
    }

    public static String getUserInput(String userInput) {
        return substringUserInputWithSeparator(userInput, getCustomPostIndex(userInput), getUserInputLength(userInput));
    }

    public static List<String> splitWithCustomSeparator(String userInput) {
        return splitWithSeparator(getUserInput(userInput), getCustomSeparator(userInput));
    }
}
