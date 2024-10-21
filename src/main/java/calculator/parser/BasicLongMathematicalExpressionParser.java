package calculator.parser;

import calculator.model.LongCalculatorModel;
import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;

public class BasicLongMathematicalExpressionParser implements LongMathematicalExpressionParser {
    private final String VALID_MATHEMATICAL_EXPRESSION_PATTERN = "(\\d+\\D)*\\d+$";
    private final Pattern VALID_PATTERN = Pattern.compile(VALID_MATHEMATICAL_EXPRESSION_PATTERN);

    public String getVALID_MATHEMATICAL_EXPRESSION_PATTERN() {
        return this.VALID_MATHEMATICAL_EXPRESSION_PATTERN;
    }

    private long stringNumberToNumber(String stringNumber) {
        try {
            long number = Long.parseLong(stringNumber);
            if (number <= 0) {
                throw new IllegalArgumentException(ParserError.INVALID_FORMAT_NUMBER.getMessage());
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ParserError.INVALID_FORMAT_NUMBER.getMessage());
        }

    }

    private void isValid(String expression) {
        if (!VALID_PATTERN.matcher(expression).matches()) {
            throw new IllegalArgumentException(ParserError.INVALID_MATHEMATICAL_EXPRESSION.getMessage());
        }
    }

    private String generateRegex(Set<Character> separators) {
        if (separators.isEmpty()) {
            return "";
        }
        StringBuilder separatorPattern = new StringBuilder();

        for (char separator : separators) {
            separatorPattern.append("|\\").append(separator);
        }

        separatorPattern.deleteCharAt(0);
        return separatorPattern.toString();
    }

    @Override
    public void parse(LongCalculatorModel model) {
        isValid(model.getMathematicalExpression());
        String separatorRegex = generateRegex(model.getSeparators());
        String[] stringNumbers = model.getMathematicalExpression().split(separatorRegex);

        long[] result = Arrays.stream(stringNumbers)
                .mapToLong(this::stringNumberToNumber)
                .toArray();

        model.setNumbers(result);
    }

}
