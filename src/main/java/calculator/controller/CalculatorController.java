package calculator.controller;

import calculator.model.*;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {

    public void run() {
        String input = InputView.getInput();

        Validator validator = ValidatorFactory.createValidator(input);
        ParsedInput parsedInput = validator.validate(input);

        List<Integer> numbers = StringSplitter.split(parsedInput);

        int result = Calculator.calculate(numbers);
        OutputView.printResult(result);
    }
}
