package calculator.service;

import java.util.List;

public class CalculateDefault extends CalculateSeparator {

    private static final String COLON = ":";
    private static final String COMMA = ",";
    private static final String OR = "|";

    public static boolean checkNotContainDefault(String userInput) {
        return checkNotContainSeparator(userInput, COLON) && checkNotContainSeparator(userInput, COMMA);
    }

    public static List<String> splitWithDefaultSeparator(String userInput) {
        return splitWithSeparator(userInput, COLON+OR+COMMA);
    }
}
