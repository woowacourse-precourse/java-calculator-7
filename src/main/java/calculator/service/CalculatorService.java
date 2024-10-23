package calculator.service;

import calculator.model.StringCalculator;
import calculator.model.StringParser;
import calculator.validator.InputValidator;
import java.util.List;

public class CalculatorService {

    private final StringParser stringParser;
    private final StringCalculator stringCalculator;
    private final InputValidator inputValidator;

    public CalculatorService(StringParser stringParser, StringCalculator stringCalculator,
                             InputValidator inputValidator) {
        this.stringParser = stringParser;
        this.stringCalculator = stringCalculator;
        this.inputValidator = inputValidator;
    }

    public int calculate(String input) {
        List<String> numbers = validatedParseInput(input);
        return stringCalculator.sumNumbers(numbers);
    }

    private List<String> validatedParseInput(String input) {
        inputValidator.validate(input);
        return stringParser.parseInput(input);
    }

}