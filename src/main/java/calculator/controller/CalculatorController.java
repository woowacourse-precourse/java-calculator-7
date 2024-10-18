package calculator.controller;

import calculator.model.Calculator;
import calculator.util.InputParser;
import calculator.util.InputValidator;
import calculator.view.CalculatorView;
import java.util.List;

public class CalculatorController {

    private final Calculator calculator;
    private final InputParser inputParser;
    private final InputValidator inputValidator;
    private final CalculatorView calculatorView;

    public CalculatorController(Calculator calculator,
                                InputParser inputParser,
                                InputValidator inputValidator,
                                CalculatorView calculatorView) {
        this.calculator = calculator;
        this.inputParser = inputParser;
        this.inputValidator = inputValidator;
        this.calculatorView = calculatorView;
    }

    public void run() {
        String input = calculatorView.prompt();

        inputValidator.validateInputFormat(input);
        String delimiter = inputParser.extractDelimiter(input);
        List<String> stringList = inputParser.parseStringToList(input, delimiter);

        inputValidator.validateParsingStringToLong(stringList);
        List<Long> longList = inputParser.parseStringListToLongList(stringList);

        inputValidator.validatePositiveNumberList(longList);
        Long result = calculator.calculate(longList);

        calculatorView.display(String.valueOf(result));
    }
}
