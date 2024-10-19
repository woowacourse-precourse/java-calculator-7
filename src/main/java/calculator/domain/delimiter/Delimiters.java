package calculator.domain.delimiter;

import calculator.exception.BusinessException;
import calculator.exception.CalculatorExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {

    private static final int BEGIN_INDEX = 2;
    private static final String CUSTOM_DELIMITER_START_SEPARATOR = "//";
    private static final String CUSTOM_DELIMITER_END_SEPARATOR = "\n";
    public static final String BLANK_DELIMITER = "";

    private final List<String> delimiters = new ArrayList<>();

    public Delimiters() {
        addDefaultDelimiters();
    }

    private void addDefaultDelimiters() {
        delimiters.add(DelimiterType.COMMA.getDelimiter());
        delimiters.add(DelimiterType.COLON.getDelimiter());
    }

    public List<String> getAllDelimiters(final String input) {
        final String findCustomDelimiter = findCustomDelimiter(input);

        if (!isDefaultDelimiter(findCustomDelimiter)) {
            validateDelimiter(findCustomDelimiter);
            delimiters.add(findCustomDelimiter);
        }

        return delimiters;
    }

    private String findCustomDelimiter(final String input) {
        if (hasCustomDelimiter(input)) {
            final int endIndex = input.indexOf(CUSTOM_DELIMITER_END_SEPARATOR);
            return input.substring(BEGIN_INDEX, endIndex);
        }

        return BLANK_DELIMITER;
    }

    private void validateDelimiter(final String delimiter) {
        if (isNotSingleDelimiter(delimiter)) {
            throw new BusinessException(CalculatorExceptionMessage.MULTIPLE_CUSTOM_DELIMITERS_EXCEPTION);
        }

        if (isNumeric(delimiter)) {
            throw new BusinessException(CalculatorExceptionMessage.DELIMITER_MUST_ACCEPT_NO_NUMBER);
        }
    }

    private boolean hasCustomDelimiter(final String input) {
        return input.startsWith(CUSTOM_DELIMITER_START_SEPARATOR);
    }

    private boolean isDefaultDelimiter(String findCustomDelimiter) {
        return findCustomDelimiter.isEmpty();
    }

    private boolean isNotSingleDelimiter(String delimiter) {
        return delimiter.length() != 1;
    }

    private boolean isNumeric(String delimiter) {
        try {
            Integer.parseInt(delimiter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
