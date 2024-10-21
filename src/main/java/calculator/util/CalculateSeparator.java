package calculator.util;

import java.util.List;

public class CalculateSeparator {

    private static final Integer ZERO = 0;
    private static final Integer ONE = 1;

    public static boolean checkNotContainSeparator(String userInput, String separator) {
        return !userInput.contains(separator);
    }

    public static List<String> splitWithSeparator(String userInput, String separator) {
        return List.of(userInput.split(separator));
    }

    public static Integer getIndexNumberOfSeparator(String userInput, String separator) {
        return userInput.indexOf(separator);
    }

    public static String substringUserInputWithSeparator(String userInput, List<Integer> indexOfStartAndEnd) {
        return userInput.substring(indexOfStartAndEnd.get(ZERO), indexOfStartAndEnd.get(ONE));
    }

    public static Integer getUserInputLength(String userInput) {
        return userInput.length();
    }

    public static List<Integer> makeIndexList(Integer startIndex, Integer endIndex) {
        return List.of(startIndex, endIndex);
    }
}
