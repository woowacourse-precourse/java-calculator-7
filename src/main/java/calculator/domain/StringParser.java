package calculator.domain;

import calculator.dto.ParsedComponents;
import calculator.global.constants.DelimiterConstants;
import calculator.validator.DelimiterValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParser {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final String INITIAL_VALUE_FOR_EMPTY_INPUT = "0";

    private final int prefixIndex;
    private final int suffixIndex;
    private final String inputExpression;

    public StringParser(String inputExpression) {
        this.prefixIndex = inputExpression.indexOf(CUSTOM_DELIMITER_PREFIX);
        this.suffixIndex = inputExpression.indexOf(CUSTOM_DELIMITER_SUFFIX);
        this.inputExpression = inputExpression;
        validateInputExpression();
    }

    public ParsedComponents parse() {
        List<Delimiter> delimiters = initializeDelimiters();

        String operationalExpression = inputExpression;
        if (hasCustomDelimiter()) {
            String customDelimiter = extractCustomDelimiter();
            delimiters.add(new Delimiter(customDelimiter.charAt(0)));

            operationalExpression = extractOperationalExpression();
            return new ParsedComponents(delimiters, operationalExpression);
        }

        return new ParsedComponents(delimiters, operationalExpression);
    }

    private void validateInputExpression() {
        DelimiterValidator.validateDelimiterFormat(prefixIndex, suffixIndex);

        if (hasCustomDelimiter()) {
            String customDelimiter = extractCustomDelimiter();
            DelimiterValidator.validateCustomDelimiter(customDelimiter);
        }
    }

    private List<Delimiter> initializeDelimiters() {
        return new ArrayList<>(Arrays.asList(new Delimiter(DelimiterConstants.COMMA_DELIMITER),
                new Delimiter(DelimiterConstants.COLON_DELIMITER)));
    }

    private boolean hasCustomDelimiter() {
        return prefixIndex < suffixIndex;
    }

    private String extractCustomDelimiter() {
        return inputExpression.substring(prefixIndex + CUSTOM_DELIMITER_PREFIX.length(), suffixIndex);
    }

    private String extractOperationalExpression() {
        String operationalExpression =
                inputExpression.substring(0, prefixIndex) + inputExpression.substring(prefixIndex + 2, suffixIndex)
                        + inputExpression.substring(suffixIndex + 2);

        if (operationalExpression.startsWith(extractCustomDelimiter())) {
            return INITIAL_VALUE_FOR_EMPTY_INPUT + operationalExpression;
        }

        return operationalExpression;
    }
}