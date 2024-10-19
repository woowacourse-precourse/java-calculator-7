package calculator.Validator;

import java.util.List;

public final class Validator {

    public static void validateParsedStrings(List<String> parsedStrings) throws IllegalArgumentException {
        for (String str : parsedStrings) {
            try {
                Integer.parseInt(str);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid string input or delimiter");
            }
        }
    }
}
