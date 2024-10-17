package calculator.strategy;

public class CustomCalcDelimiterStrategy extends AbstractCalcDelimiterStrategy {
    private static final String DELIMITER_PREFIX = "//";
    private static final String DELIMITER_POSTFIX = "\\n";

    @Override
    public Integer[] splitNumbers(String expression) {
        if (expression.startsWith(DELIMITER_PREFIX)) {
            return processCustomDelimiter(expression);
        }
        return new Integer[0];
    }

    private Integer[] processCustomDelimiter(String expression) {
        String delimiter = extractDelimiterPart(expression);
        String numbersPart = extractNumbersPart(expression);
        return processNumbers(numbersPart, delimiter);
    }

    private String extractDelimiterPart(String expression) {
        int delimiterIndex = expression.indexOf(DELIMITER_POSTFIX);
        return expression.substring(DELIMITER_PREFIX.length(), delimiterIndex);
    }

    private String extractNumbersPart(String expression) {
        int delimiterIndex = expression.indexOf(DELIMITER_POSTFIX);
        return expression.substring(delimiterIndex + DELIMITER_POSTFIX.length());
    }
}
