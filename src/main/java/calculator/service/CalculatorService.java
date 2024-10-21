package calculator.service;

import calculator.model.Calculator;
import calculator.model.Delimiters;
import calculator.model.Numbers;
import calculator.util.ExtractionUtil;
import calculator.util.InputValidator;
import java.math.BigDecimal;
import java.util.List;

public class CalculatorService {

    private final Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public String calculate(String rawInput) {
        Delimiters delimiters = Delimiters.from(rawInput);
        String expression = ExtractionUtil.extractExpression(rawInput);
        InputValidator.validateExpression(expression, delimiters.getDelimiters());
        List<BigDecimal> numbers = Numbers
                .of(expression, delimiters)
                .getNumbers();
        BigDecimal sum = calculator.add(numbers);
        return sum.toString();
    }
}
