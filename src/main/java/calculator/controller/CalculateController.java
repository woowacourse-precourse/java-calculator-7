package calculator.controller;

import calculator.service.Calculator;
import calculator.service.Validator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculateController {
    public void start() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Validator validator = new Validator();
        Calculator calculator = new Calculator();

        String input = inputView.strInput();
        validator.validateInput(input);

        List<Integer> convertedInput = validator.getConvertedInput(input);
        int result = calculator.calculate(convertedInput);

        outputView.resultOutput(result);
    }
}
