package calculator.stringcalculator;

import calculator.input.InputReader;
import calculator.output.OutputWriter;

public class StringCalculator {

    private final StringCalculatorService stringCalculatorService;

    public StringCalculator(StringCalculatorService stringCalculatorService) {
        this.stringCalculatorService = stringCalculatorService;
    }

    public String operate(String input) {
        stringCalculatorService.validateInputForm(input);
        String result = stringCalculatorService.calculate(input);

        return result;
    }

}
