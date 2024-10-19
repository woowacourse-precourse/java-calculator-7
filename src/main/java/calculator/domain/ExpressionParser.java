package calculator.domain;

import static calculator.constants.AppConstants.fixDelimiter;

import java.util.HashSet;
import java.util.Set;

public class ExpressionParser {
    private final ParsedExpression parsedExpression;
    private final Delimiter delimiter;

    private final ParsedNumber parsedNumber;

    public ExpressionParser(String userExpression) {
        this.delimiter = new Delimiter(findDelimiters(userExpression));
        this.parsedExpression = new ParsedExpression(findExpression(userExpression), delimiter);
        this.parsedNumber = new ParsedNumber(parsedExpression.extractNumbers());
    }


    public int getAddResult() {
        return parsedNumber.sum();
    }


    private String findExpression(String userExpression) {
        if (!userExpression.startsWith("//")) {
            return userExpression;
        }

        return userExpression.substring(userExpression.indexOf("\\n") + 2);
    }

    private Set<Character> findDelimiters(String userExpression) {
        Set<Character> delimiters = new HashSet<>(fixDelimiter);
        if (!userExpression.startsWith("//")) {
            return delimiters;
        }
        int idx = 2;
        while (idx < userExpression.length() - 1) {
            char currentChar = userExpression.charAt(idx);
            if (currentChar == '\\' && userExpression.charAt(idx + 1) == 'n') {
                return delimiters;
            }

            if (Character.isDigit(currentChar)) {
                throw new IllegalArgumentException("구분자로 숫자가 등장할 수 없습니다:" + currentChar);
            }

            delimiters.add(currentChar);
            idx++;
        }

        throw new IllegalArgumentException();
    }
}
