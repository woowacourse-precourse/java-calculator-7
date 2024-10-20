package calculator.model.delimiter;

import static calculator.enumStatus.ExceptionMessage.INVALID_CUSTOM_DELIMITER_CHAR;

public class CustomDelimiter implements Delimiter {
    @Override
    public String getDelimiter(String input) {
        validateDelimiterChar(input);

        String customDelimiter = String.valueOf(input.charAt(2));
        return new DefaultDelimiter().getDelimiter(input) + customDelimiter;
    }

    private static void validateDelimiterChar(String input) {
        if (!input.substring(0, 5).matches("^//.\\\\n")) {
            throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER_CHAR.toString());
        }
    }
}
