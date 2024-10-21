package calculator.service;

import calculator.model.Expression;
import calculator.model.PositiveNumber;
import calculator.model.Separator;

public class CalculatorModel {
    private static final int ZERO = 0;

    private final Separator separator = new Separator();

    public int calculate(Expression expressionModel) {
        String nonSeparatorSection = expressionModel.nonSeparatorSection();
        separator.registerSeparator(expressionModel.separatorSection());

        String[] numbers = nonSeparatorSection.split(separator.getSeparator());

        PositiveNumber sum = new PositiveNumber(ZERO);
        for (String nowNum : numbers) {
            sum.plus(nowNum);
        }
        return sum.getCount();
    }
}
