package calculator.service;

import calculator.model.Delimiter;
import calculator.model.Expression;
import calculator.model.PositiveNumber;

public class Calculator {
    private final Delimiter delimiter = new Delimiter();

    public int calculate(Expression expressionModel) {
        String nonDelimiterSection = expressionModel.getExpression();

        if (expressionModel.hasCustomDelimiter()) {
            delimiter.registerDelimiter(expressionModel.delimiterSection());
            nonDelimiterSection = expressionModel.nonDelimiterSection();
        }

        String[] numbers = nonDelimiterSection.split(delimiter.getDelimiter());

        PositiveNumber sum = new PositiveNumber(0);
        for (String nowNum : numbers) {
            sum.plus(nowNum);
        }
        return sum.getCount();
    }
}
