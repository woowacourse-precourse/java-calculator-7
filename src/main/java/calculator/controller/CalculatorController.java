package calculator.controller;

import calculator.model.ParsedInput;
import calculator.model.StringSplitter;
import calculator.model.Validator;
import calculator.model.ValidatorFactory;
import calculator.view.InputView;

import java.util.List;

public class CalculatorController {

    public void run() {
        String input = InputView.getInput();

        Validator validator = ValidatorFactory.createValidator(input);
        ParsedInput parsedInput = validator.validate(input);

        List<Integer> numbers = StringSplitter.split(parsedInput);
    }
}
