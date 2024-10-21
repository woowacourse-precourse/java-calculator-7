package calculator.mvc.model.calculator;

import calculator.mvc.model.expression.Expression;

public interface Calculator {
    void setSeparator(String input, Expression expression);

    void parseNumbersFromString(String input);

    long addNumbers();
}
