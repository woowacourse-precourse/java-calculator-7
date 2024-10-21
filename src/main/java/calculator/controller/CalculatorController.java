package calculator.controller;

import calculator.model.Calculator;
import calculator.model.Validator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class CalculatorController {

    private final Calculator calculator;
    private final Validator validator;

    public CalculatorController() {
        this.calculator = new Calculator();
        this.validator = new Validator();
    }

    public void run() {
        String input = InputView.getString();

        int validationResult = validator.validateInput(input);
        int result = 0;


        if (validationResult != 0) {
            String delimiter = validator.getDelimiter(input);
            String numbersPart = validator.getNumbersPart(input);

            validator.validateLastNumber(numbersPart);

            String[] numbers = validator.splitNumbers(numbersPart, delimiter);


            List<Integer> numbersList = calculator.convertStringToInteger(Arrays.asList(numbers));

            result = calculator.sumNumbers(numbersList);
        }

        OutputView.printResult(result);
    }

}
