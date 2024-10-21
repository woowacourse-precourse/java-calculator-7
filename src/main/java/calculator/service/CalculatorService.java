package calculator.service;


import static calculator.exception.ErrorMessages.INCLUDES_NEGATIVE_NUMBER;
import static calculator.exception.ErrorMessages.INCLUDES_NON_NUMERIC;

import calculator.domain.adder.NumberAdder;
import calculator.domain.parser.InputParser;
import calculator.domain.parser.InputParser.ParsedInput;
import calculator.domain.validator.InputValidator;

public class CalculatorService {

    private final InputParser inputParser;
    private final NumberAdder numberAdder;
    private final InputValidator inputValidator;

    public CalculatorService() {
        this.inputParser = new InputParser();
        this.numberAdder = new NumberAdder();
        this.inputValidator = new InputValidator();
    }

    public String calculate(String input) {
        final ParsedInput parsedInput = inputParser.parse(input);

        for (String numberToken : parsedInput.numbersToken()) {
            if (!inputValidator.isValidNumber(numberToken)) {
                throw new IllegalArgumentException(INCLUDES_NON_NUMERIC.getMessage());
            }
            if (inputValidator.isNegativeNumber(numberToken)) {
                throw new IllegalArgumentException(INCLUDES_NEGATIVE_NUMBER.getMessage());
            }
        }

        return numberAdder.adder(parsedInput);
    }

}
