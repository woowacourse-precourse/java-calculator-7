package calculator.controller;

import calculator.model.Calculator;
import calculator.model.Validator;
import calculator.view.InputView;

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
//        int result = calculator.addition(input);
        validator.validateInput(input);

        String delimiter = validator.getDelimiter(input);
        String numbersPart = validator.getNumbersPart(input);

        String[] numbers = validator.splitNumbers(numbersPart, delimiter);

        validator.validateLastNumber(numbers);

        List<Integer> numbersList = calculator.convertStringToInteger(Arrays.asList(numbers));

        int result = calculator.sumNumbers(numbersList);

        System.out.println(result);
    }

}
