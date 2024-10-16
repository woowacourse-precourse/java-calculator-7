package calculator.service;

import java.util.List;

public class CalculateDefault extends CalculateSeparator {

    private static final String COLON = ":";
    private static final String COMMA = ",";
    private static final String OR = "|";

    public static boolean checkContainDefault(String userInput) {
        return checkContainSeparator(userInput, COLON) || checkContainSeparator(userInput, COMMA);
    }

    public static List<String> splitWithDefaultSeparator(String userInput) {
        return splitWithSeparator(userInput, COLON+OR+COMMA);
    }
}
