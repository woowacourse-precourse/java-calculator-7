package calculator.controller;

import calculator.domain.Addition;
import calculator.domain.Calculator;
import calculator.domain.Delimiter;
import calculator.domain.Number;
import calculator.domain.Operation;
import calculator.util.Parser;
import calculator.view.CalculatorView;
import java.util.List;

public class CalculatorController {

    public void addCalculator() {
        String input = CalculatorView.requestAddCalculator();

        Delimiter delimiter = new Delimiter();
        String customDelimiter = Parser.parseCustomDelimiter(input);
        delimiter.addCustomDelimiter(customDelimiter);

        List<Number> numbers = Parser.parseNumber(input, delimiter);

        Calculator calculator = Calculator.getInstance();
        Operation operation = Addition.getInstance();
        Number result = calculator.calculate(operation, numbers);

        CalculatorView.responseResult(result);
    }
}
