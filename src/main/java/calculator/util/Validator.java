package calculator.util;

import java.util.List;

public class Validator {

    public static void validateNumbers(List<String> tokens) {
        for (String token : tokens) {

            if (!isNumeric(token)) {
                throw new IllegalArgumentException();
            }

        }
    }

    private static boolean isNumeric(String token) {
        return token.matches("\\d+");
    }
}
