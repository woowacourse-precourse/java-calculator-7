package calculator;

import java.util.List;

public class FormatValidator {
    public void validateInput(String input, String delimiter) {
        String notAllowedChars = input.replaceAll("[0-9]", "").replaceAll(delimiter, "");
        System.out.println(input);
        if (!notAllowedChars.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNoLeadingZero(List<String> numbers) {
        for (String number : numbers) {
            if (number != null && number.startsWith("0")) {
                throw new IllegalArgumentException();
            }
        }
    }
}
