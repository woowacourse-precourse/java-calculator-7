package calculator.domain;

import static calculator.constants.AppConstants.fixDelimiter;

import java.util.HashSet;
import java.util.Set;

public class ExpressionParser {
    private final ParsedExpression parsedExpression;
    private final Delimiter delimiter;

    private final Number number;

    public ExpressionParser(String userExpression) {
        this.delimiter = new Delimiter(findDelimiters(userExpression));
        this.parsedExpression = new ParsedExpression(findExpression(userExpression), delimiter);
        this.number = new Number(parsedExpression.extractNumbers());
    }


    public int getAddResult() {
        return number.sum();
    }


    private String findExpression(String userExpression) {
        int prefixSize = delimiter.getDelimiterSize() - fixDelimiter.size();
        if (userExpression.startsWith("//")) {
            prefixSize += 3;
        }
        return userExpression.substring(prefixSize);
    }

    private Set<Character> findDelimiters(String userExpression) {
        Set<Character> delimiters = new HashSet<>(fixDelimiter);
        if (!userExpression.startsWith("//")) {
            return delimiters;
        }
        int idx = 2;
        while (idx < userExpression.length()) {
            if (userExpression.charAt(idx) == '\n') {
                return delimiters;
            }

            if (Character.isDigit(userExpression.charAt(idx))) {
                throw new IllegalArgumentException();
            }

            delimiters.add(userExpression.charAt(idx));
            idx++;
        }

        throw new IllegalArgumentException();
    }
}
