package calculator.service;

import calculator.constant.CalculatorConstants;
import calculator.constant.ExceptionMessageConstants;
import calculator.model.Calculator;
import calculator.validator.InputValidator;
import java.util.List;

public class StringCalculatorService {
    private final InputValidator inputValidator;
    private final StringSplitterService stringSplitter;

    public StringCalculatorService(InputValidator inputValidator, StringSplitterService stringSplitter) {
        this.inputValidator = inputValidator;
        this.stringSplitter = stringSplitter;
    }

    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        if (input.length() > CalculatorConstants.MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessageConstants.INPUT_TOO_LONG,
                            CalculatorConstants.MAX_INPUT_LENGTH));
        }

        inputValidator.validate(input);
        List<String> numbers = stringSplitter.split(input);
        Calculator calculator = new Calculator(numbers);
        return calculator.calculate();
    }
}