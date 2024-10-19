package calculator;

import java.util.regex.Pattern;

public class StringValidator {

    public static String customDelimiterValidator(String userInput) throws IllegalArgumentException {
        for (Delimiter delimiter : Delimiter.values()) {
            if (userInput.contains(delimiter.getDelimiter())) {
                return delimiter.getDelimiter();
            }
        }
        throw new IllegalArgumentException();
    }

    public static boolean stringFiter(String userInput) throws IllegalArgumentException {
        return Pattern.matches("^[0-9\\p{Punct}n]*", userInput);
    }

}
