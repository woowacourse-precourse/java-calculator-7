package calculator.domain;

import calculator.dto.ParsedComponents;
import calculator.global.constants.DelimiterConstants;
import calculator.validator.DelimiterValidator;
import java.util.ArrayList;
import java.util.List;

public class StringParser {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    private final String inputExpression;

    public StringParser(String inputExpression) {
        this.inputExpression = inputExpression;
    }

    public ParsedComponents parse() {
        List<Delimiter> delimiters = new ArrayList<>(List.of(new Delimiter(DelimiterConstants.COMMA_DELIMITER),
                new Delimiter(DelimiterConstants.COLON_DELIMITER)));

        int prefixIndex = inputExpression.indexOf(CUSTOM_DELIMITER_PREFIX);
        int suffixIndex = inputExpression.indexOf(CUSTOM_DELIMITER_SUFFIX);

        DelimiterValidator.validateDelimiterFormat(prefixIndex, suffixIndex);

        if (prefixIndex < suffixIndex) {
            return handleCustomDelimiterCase(prefixIndex, suffixIndex, delimiters);
        }

        return new ParsedComponents(delimiters, inputExpression);
    }

    private ParsedComponents handleCustomDelimiterCase(int prefixIndex, int suffixIndex, List<Delimiter> delimiters) {
        String customDelimiter = inputExpression.substring(prefixIndex + CUSTOM_DELIMITER_PREFIX.length(), suffixIndex);

        DelimiterValidator.validateCustomDelimiter(customDelimiter);

        delimiters.add(new Delimiter(customDelimiter.charAt(0)));

        String operationalExpression =
                inputExpression.substring(0, prefixIndex) + inputExpression.substring(suffixIndex + 2);

        return new ParsedComponents(delimiters, operationalExpression);
    }
}