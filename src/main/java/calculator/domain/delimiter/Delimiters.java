package calculator.domain.delimiter;

import calculator.exception.BusinessException;
import calculator.exception.CalculatorExceptionMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Delimiters {

    private static final int BEGIN_INDEX = 2;
    private static final String CUSTOM_DELIMITER_START_SEPARATOR = "//";
    private static final String CUSTOM_DELIMITER_END_SEPARATOR = "\n";

    private final List<String> delimiters;

    public Delimiters() {
        this.delimiters = new ArrayList<>();
        addDefaultDelimiters();
    }

    private void addDefaultDelimiters() {
        delimiters.add(DelimiterType.COMMA.getDelimiter());
        delimiters.add(DelimiterType.COLON.getDelimiter());
    }

    public List<String> getAllDelimiters(final String input) {
        final String customDelimiter = findCustomDelimiter(input);

        if (!customDelimiter.isBlank()) {
            validateSingleDelimiter(customDelimiter);
            delimiters.add(customDelimiter);
        }

        return delimiters;
    }

    public String findCustomDelimiter(final String input) {
        if (hasCustomDelimiter(input)) {
            final int endIndex = input.indexOf(CUSTOM_DELIMITER_END_SEPARATOR);
            return input.substring(BEGIN_INDEX, endIndex);
        }

        return "";
    }

    private void validateSingleDelimiter(final String delimiter) {
        if (delimiter.length() != 1) {
            throw new BusinessException(CalculatorExceptionMessage.MULTIPLE_CUSTOM_DELIMITERS_EXCEPTION);
        }
    }

    public boolean hasCustomDelimiter(final String input) {
        return input.startsWith(CUSTOM_DELIMITER_START_SEPARATOR);
    }
}
