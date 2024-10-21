package calculator.controller;

import calculator.model.Calculator;
import calculator.view.ConsoleView;

public class CalculatorController {
    private final Calculator calculator;
    private final ConsoleView view;

    public CalculatorController(Calculator calculator, ConsoleView view) {
        this.calculator = calculator;
        this.view = view;
    }

    public void run() {

        String input = view.getInput();
        String delimiter;
        String numbers;

        if (calculator.isCustomDelimiterPattern(input)) {
            delimiter = calculator.getCustomDelimiter(input);
            numbers = calculator.getNumbersAfterDelimiter(input);

            if (!calculator.isValidCustomPattern(numbers, delimiter)) {
                throw new IllegalArgumentException("잘못된 입력입니다. 커스텀 구분자와 숫자만 포함되어야 합니다.");
            }
        } else if (calculator.isValidDefaultPattern(input)) {
            delimiter = ",|:";
            numbers = input;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        if (calculator.isEmptyString(numbers)) {
            view.printResult(0);
        } else {
            calculator.validateContinuousDelimiters(numbers, delimiter);
            String[] tokens = numbers.split(delimiter);
            long sum = calculator.calculateSum(tokens);
            view.printResult(sum);
        }

    }
}
