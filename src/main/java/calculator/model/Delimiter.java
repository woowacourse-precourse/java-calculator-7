package calculator.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Delimiter {

    public static final String CUSTOM_DELIMITER = "//(.*)\n(.*)";
    public static final String BASIC_DELIMITER = ",|:";
    public static final String INVALID_DELIMITER = "허용되지 않은 구분자가 존재합니다";

    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);
    public static final String STRING_BETWEEN_DELIMITER = "|";
    public static final String COMMA = ",";
    public static final String COLON = ":";

    private static Set<String> delimiter;

    public Delimiter() {
        delimiter = new HashSet<>();
        delimiter.add(COMMA);
        delimiter.add(COLON);
    }

    public String[] splitWithCustomDelimiter(String expression) {
        Matcher m = pattern.matcher(expression.replace("\\n", "\n"));
        if (m.find()) {
            return splitExpression(m);
        }
        String[] splitedExpression = splitWithDelimiter(expression);
        checkExpressionHasInvalidExpression(splitedExpression);
        return splitedExpression;
    }

    private String[] splitExpression(Matcher m) {
        String customDelimiter = m.group(1);
        for (char c : customDelimiter.toCharArray()) {
            delimiter.add(String.valueOf(c));
        }
        String delimiterToUse = customAndBasicDelimiter();
        String[] splitedExpression = m.group(2).split(delimiterToUse);
        checkExpressionHasInvalidExpression(splitedExpression);
        return splitedExpression;
    }

    public String[] splitWithDelimiter(String expression) {
        return expression.split(BASIC_DELIMITER);
    }

    private String customAndBasicDelimiter() {
        return delimiter.stream()
                .collect(Collectors.joining(STRING_BETWEEN_DELIMITER));
    }

    private void checkExpressionHasInvalidExpression(String[] splitedExpression) {
        Arrays.stream(splitedExpression)
                .forEach(i -> validOperandHasInvalidDelimiter(i));
    }

    private void validOperandHasInvalidDelimiter(String i) {
        for (char s : i.toCharArray()) {
            if (!Character.isDigit(s)) {
                throw new IllegalArgumentException(INVALID_DELIMITER);
            }
        }
    }

}
