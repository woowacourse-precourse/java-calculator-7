package calculator.service;


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
        ParsedInput parsedInput = inputParser.parse(input);

        for (String numberToken : parsedInput.numbersToken()) {
            if (!inputValidator.isValidNumber(numberToken)) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
            if (inputValidator.isNegativeNumber(numberToken)) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }

        return numberAdder.adder(parsedInput);
    }

}
