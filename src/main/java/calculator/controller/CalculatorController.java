package calculator.controller;

import calculator.model.Calculator;
import calculator.model.StringParser;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {
    private static final StringParser stringParser = new StringParser();
    private static final Calculator calculator = new Calculator();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void run() {
        String input = inputView.getInput();
        int result = 0;
        if (!input.isEmpty()) {
            List<Integer> numbers = stringParser.extractNumbers(input);
            result = calculator.sum(numbers);
        }
        outputView.printResult(result);
    }
}
