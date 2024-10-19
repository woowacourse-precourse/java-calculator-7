package calculator.model.expression;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public final class CustomExpression implements Expression {

    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String CUSTOM_DELIMITER_SEPARATOR = "\\n";

    private final String input;
    private final String delimiter;
    private final List<String> operands;

    public CustomExpression(final String input) {
        validateInputNotNull(input);
        this.input = input;
        final int delimiterEndIndex = extractDelimiterEndIndex();
        this.delimiter = extractDelimiter(delimiterEndIndex);
        this.operands = extractOperands(delimiterEndIndex);
    }

    private void validateInputNotNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null일 수 없습니다.");
        }
    }

    private int extractDelimiterEndIndex() {
        final int delimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_SEPARATOR);
        if (!input.startsWith(CUSTOM_DELIMITER_PREFIX) || delimiterEndIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자 지정 형식이 잘못되었습니다.");
        }
        if (delimiterEndIndex <= CUSTOM_DELIMITER_PREFIX.length()) {
            throw new IllegalArgumentException("커스텀 구분자가 지정되지 않았습니다.");
        }
        return delimiterEndIndex;
    }

    private String extractDelimiter(final int delimiterEndIndex) {
        final String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterEndIndex);
        return Pattern.quote(customDelimiter);
    }

    private List<String> extractOperands(final int delimiterEndIndex) {
        final String numbersPart = input.substring(delimiterEndIndex + CUSTOM_DELIMITER_SEPARATOR.length());
        if (numbersPart.isBlank()) {
            return Collections.singletonList("0");
        }
        return List.of(numbersPart.split(delimiter));
    }

    @Override
    public String getInput() {
        return input;
    }

    @Override
    public String getDelimiter() {
        return delimiter;
    }

    @Override
    public List<String> getOperands() {
        return operands;
    }
}
