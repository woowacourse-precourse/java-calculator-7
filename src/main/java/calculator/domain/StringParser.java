package calculator.domain;

import calculator.dto.ParsedComponents;
import calculator.global.exception.CalculatorException;
import calculator.global.message.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

public class StringParser {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\n";
    private static final char COMMA_DELIMITER = ',';
    private static final char COLON_DELIMITER = ':';

    private final String inputExpression;

    public StringParser(String inputExpression) {
        this.inputExpression = inputExpression;
    }

    public ParsedComponents parse() {
        List<Character> delimiters = new ArrayList<>(List.of(COMMA_DELIMITER, COLON_DELIMITER));

        int prefixIndex = inputExpression.indexOf(CUSTOM_DELIMITER_PREFIX);
        int suffixIndex = inputExpression.indexOf(CUSTOM_DELIMITER_SUFFIX);

        if ((prefixIndex == -1 && suffixIndex != -1) || (prefixIndex != -1 && suffixIndex == -1)) {
            throw CalculatorException.from(ErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT);
        }

        if (prefixIndex > suffixIndex) {
            throw CalculatorException.from(ErrorMessage.INVALID_CUSTOM_DELIMITER_ORDER);
        }

        if (prefixIndex < suffixIndex) {
            String customDelimiter = inputExpression.substring(prefixIndex + CUSTOM_DELIMITER_PREFIX.length(),
                    suffixIndex);

            if (customDelimiter.isEmpty()) {
                throw CalculatorException.from(ErrorMessage.EMPTY_CUSTOM_DELIMITER);
            }

            if (customDelimiter.length() != 1) {
                throw CalculatorException.from(ErrorMessage.INVALID_CUSTOM_DELIMITER_LENGTH);
            }

            if (Character.isDigit(customDelimiter.charAt(0))) {
                throw CalculatorException.from(ErrorMessage.CUSTOM_DELIMITER_IS_NUMBER);
            }

            delimiters.add(customDelimiter.charAt(0));

            String numbersWithoutDelimiterSection =
                    inputExpression.substring(0, prefixIndex) + inputExpression.substring(suffixIndex + 1);

            return new ParsedComponents(delimiters, numbersWithoutDelimiterSection);
        }

        return new ParsedComponents(delimiters, inputExpression);
    }
}