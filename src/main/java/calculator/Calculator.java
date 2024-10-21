package calculator;

import calculator.exception.CalculatorError;
import calculator.util.ParsingUtil;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
    private final InputView inputView;
    private final OutputView outputView;

    public Calculator() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.requestAddExpression();
        var input = inputView.getInput();
        var result = calculate(input);

        outputView.printResult(result);
    }

    private int calculate(String input) {
        System.out.println(input);
        var numbers = ParsingUtil.extractNumbers(input);
        System.out.println(numbers);
        var result = numbers.stream()
                .mapToInt(Integer::parseInt)
                .peek(this::checkNegative)
                .sum();
        return result;
    }

    private void checkNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(CalculatorError.INPUT_CONTAINS_NEGATIVE.getMessage());
        }
    }
}
