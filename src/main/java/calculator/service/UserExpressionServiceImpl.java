package calculator.service;

import calculator.constants.AppConstants;
import calculator.domain.Delimiter;
import calculator.domain.Expression;
import calculator.dto.UserExpressionDto;
import java.util.HashSet;
import java.util.Set;

public class UserExpressionServiceImpl implements UserExpressionService {
    private Delimiter delimiter;

    private Expression expression;

    @Override
    public void saveUserExpression(UserExpressionDto userExpressionDto) {
        delimiter = new Delimiter(findDelimiters(userExpressionDto));
    }

    private Set<Character> findDelimiters(UserExpressionDto userExpressionDto) {
        Set<Character> delimiters = new HashSet<>(AppConstants.fixDelimiter);
        String expression = userExpressionDto.getExpression();
        if (!expression.startsWith("//")) {
            return delimiters;
        }
        int idx = 2;
        while (idx < expression.length()) {
            if (expression.charAt(idx) == '\n') {
                return delimiters;
            }

            if (Character.isDigit(expression.charAt(idx))) {
                throw new IllegalArgumentException();
            }

            delimiters.add(expression.charAt(idx));
        }

        throw new IllegalArgumentException();
    }

}
