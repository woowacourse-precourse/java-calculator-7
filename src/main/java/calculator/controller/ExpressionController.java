package calculator.controller;

import calculator.domain.CustomDelim;
import calculator.domain.UserExpression;
import calculator.domain.UserExpressionDivide;
import calculator.repository.DelimiterRepository;

public class ExpressionController {

    private UserExpression userExpression;
    private DelimiterRepository delimiterRepository;

    private void createExpression(UserExpression userExpression) {
        this.userExpression = userExpression;
        delimiterRepository = new DelimiterRepository();
    }

    private void divideUserExpression() {
        UserExpressionDivide.dividePart(userExpression);
    }

    private void customDelimTreatment(String customDelimCandidate) {
        delimiterRepository.addDelimiter(new CustomDelim(customDelimCandidate).getDelim());
        userExpression.setEssentialExpression(userExpression.getRawExpression()
                .replace(userExpression.getCustomDelimExpressionCandidate(), ""));
    }
}
