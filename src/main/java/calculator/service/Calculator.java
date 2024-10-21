package calculator.service;

import calculator.model.Expression;
import calculator.model.PositiveNumber;
import calculator.model.Separator;

public class Calculator {
    private final Separator separator = new Separator();

    public int calculate(Expression expressionModel) {
        String nonSeparatorSection = expressionModel.getExpression();

        if (expressionModel.hasCustomSeparator()) {
            separator.registerSeparator(expressionModel.separatorSection());
            nonSeparatorSection = expressionModel.nonSeparatorSection();
        }

        String[] numbers = nonSeparatorSection.split(separator.getSeparator());

        PositiveNumber sum = new PositiveNumber(0);
        for (String nowNum : numbers) {
            sum.plus(nowNum);
        }
        return sum.getCount();
    }
}
