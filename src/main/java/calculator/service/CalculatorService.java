package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.Parser;
import calculator.domain.StringCalculator;
import calculator.domain.StringParser;
import calculator.view.View;
import java.util.List;

public class CalculatorService implements Service{

    private final Parser parser;

    public CalculatorService(String input) {
        this.parser = new StringParser(input);
    }

    @Override
    public void run() {
        List<Double> numbers = parser.parse();
        Calculator calculator = new StringCalculator(numbers);
        View.output(calculator.calculate());
    }
}
