package calculator;

import java.util.List;

public class FormatValidator {
    public static final String DIGIT = "[0-9]";
    public static final String CHARACTER_ZERO = "0";
    public static final int DECIMAL_ZERO = 0;

    public void validateCharactersOrThrow(String input, String delimiter) {
        String notAllowedChars = input.replaceAll(DIGIT, "").replaceAll(delimiter, "");
        if (!notAllowedChars.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNoLeadingZeroOrThrow(List<String> numbers) {
        for (String number : numbers) {
            if (number != null && number.startsWith(CHARACTER_ZERO)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
