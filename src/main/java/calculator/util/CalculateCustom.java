package calculator.util;

import calculator.exception.CalculateException;
import java.util.List;

public class CalculateCustom extends CalculateSeparator {

    private static final String CUSTOM_PRE = "//";
    private static final String CUSTOM_POST = "\\n";
    private static final Integer TWO = 2;
    private static final Character BACK_SLASH = '\\';
    private static final String STRING_BACK_SLASH = "\\";

    public static boolean checkNotContainCustom(String userInput) {
        return checkNotContainSeparator(userInput, CUSTOM_PRE) || checkNotContainSeparator(userInput, CUSTOM_POST);
    }

    public static Integer getCustomPreIndex(String userInput) {
        return CalculateSeparator.getIndexNumberOfSeparator(userInput, CUSTOM_PRE);
    }

    public static Integer getCorrectCustomPreIndex(String userInput) {
        return CalculateException.catchCustomPrePositionException(userInput);
    }

    public static Integer getCustomPostIndex(String userInput) {
        return getIndexNumberOfSeparator(userInput, CUSTOM_POST) + TWO;
    }

    public static String getCustomPreToPost(String userInput) {
        return substringUserInputWithSeparator(userInput, makeIndexList(getCorrectCustomPreIndex(userInput), getCustomPostIndex(userInput)));
    }

    public static String getCustomSeparator(String userInput) {
        String splitCustom = getCustomPreToPost(userInput);
        return substringUserInputWithSeparator(splitCustom, makeIndexList(TWO, getUserInputLength(splitCustom) - TWO));
    }

    public static String getUserInput(String userInput) {
        return substringUserInputWithSeparator(userInput, makeIndexList(getCustomPostIndex(userInput), getUserInputLength(userInput)));
    }

    public static List<String> splitWithCustomSeparator(String userInput) {
        String custom = getCustomSeparator(userInput);
        if (checkContainBackSlash(custom)) {
            return splitWithSeparator(getUserInput(userInput), createNewCustom(custom));
        }
        return splitWithSeparator(getUserInput(userInput), getCustomSeparator(userInput));
    }

    public static boolean checkContainBackSlash(String custom) {
        return custom.contains(STRING_BACK_SLASH);
    }

    public static String createNewCustom(String custom) {
        StringBuilder newCustom = new StringBuilder();
        for (int i = 0; i < custom.length(); i++) {
            newCustom.append(custom.charAt(i));
            if (checkIsCustomEqualBackSlash(custom.charAt(i))) {
                newCustom.append(BACK_SLASH);
            }
        }
        return newCustom.toString();
    }

    public static boolean checkIsCustomEqualBackSlash(Character custom) {
        return custom == BACK_SLASH;
    }
}
