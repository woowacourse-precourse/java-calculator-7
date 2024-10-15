package calculator.Utils;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    private static final String COMMA = ",";
    private static final String SEMICOLONS = ";";
    private static final String DELIMITER = COMMA + "|" + SEMICOLONS;

    public static List<String> splitByDelimiter(String userInput) {
        String[] splittedInput = userInput.split(DELIMITER);
        return Arrays.stream(splittedInput).toList();
    }

    public static List<String> splitByCumstomDelimiter(String userInput, String customDelimiter) {
        String[] splittedInput = userInput.split(customDelimiter);
        return Arrays.stream(splittedInput).toList();
    }
}
